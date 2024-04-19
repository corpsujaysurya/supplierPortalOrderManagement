package com.kpmg.te.retail.supplierportal.OrderManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.OrderManagement.constants.OrderManagementConstants;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.CustomerOrderMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.InvoiceMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.ItemMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.TPLPartnerMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.utils.OrderManagementUtils;

@Component
public class CustomerOrderDao {

	@Autowired
	OrderManagementUtils omUtils;

	private static final Logger logger = Logger.getLogger(CustomerOrderDao.class.getName());

	public Connection getConnectioDetails() throws ClassNotFoundException, SQLException {
		String myDriver = OrderManagementConstants.myDriver;
		String myUrl = OrderManagementConstants.myUrl;
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, OrderManagementConstants.mySQL_ID,
				OrderManagementConstants.mySQL_pass);
		return conn;
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public ArrayList<CustomerOrderMaster> getAllCOListingData() throws SQLException, ClassNotFoundException {
		CustomerOrderMaster coMasterObj;
		ArrayList<CustomerOrderMaster> coMasterList = new ArrayList<CustomerOrderMaster>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.CUSTOMER_ORDER_MASTER ORDER BY CREATION_DATE DESC LIMIT 20";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			coMasterObj = new CustomerOrderMaster();
			coMasterObj.setCoNumber(rs.getString("CO_NUMBER"));
			coMasterObj.setCustomerMobNum(rs.getString("MOBILE_NUM"));
			coMasterObj.setOrderCreationDate(rs.getString("CREATION_DATE"));
			coMasterObj.setExpectedDelDate(rs.getString("EXP_DELIVERY_DATE"));
			coMasterObj.setOrderStatus(rs.getString("ORDER_STATUS"));
			coMasterList.add(coMasterObj);
		}
		logger.info("[C]CustomerOrderDao::[M]getAllCOListingData -> The Item list is: " + coMasterList.toString());
		return coMasterList;
	}

	public CustomerOrderMaster getCODetails(String coId) throws SQLException, ClassNotFoundException {
		CustomerOrderMaster coMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.CUSTOMER_ORDER_MASTER WHERE CO_NUMBER ='" + coId + "'";
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			coMasterObj = new CustomerOrderMaster();
			coMasterObj.setCoNumber(rs.getString("CO_NUMBER"));
			coMasterObj.setCustomerMobNum(rs.getString("MOBILE_NUM"));
			coMasterObj.setOrderCreationDate(rs.getString("CREATION_DATE"));
			coMasterObj.setExpectedDelDate(rs.getString("EXP_DELIVERY_DATE"));
			coMasterObj.setOrderStatus(rs.getString("ORDER_STATUS"));
			coMasterObj.setGiftWrap(rs.getString("GIFT_WRAP"));
			coMasterObj.setGiftMessage(rs.getString("GIFT_MESSAGE"));
			coMasterObj.setCustomerName(rs.getString("CUSTOMER_NAME"));
			coMasterObj.setDeliveryType(rs.getString("DELIVERY_TYPE"));
			coMasterObj.setShippingAddress(rs.getString("SHIPPING_ADDRESS"));
			coMasterObj.setItemDetails(rs.getString("ITEM_DETAILS"));
		}
		logger.info("[C]CustomerOrderDao::[M]getCODetails -> The Customer Order Details is: " + coMasterObj.toString());
		return coMasterObj;
	}

	public String generateInvoice(String coId, String invoiceTotalAmt, String totalItemQty, String totalUniqItems,
			String deliveryAddress, String dispatchLocation) throws ClassNotFoundException, ParseException {
		PreparedStatement preparedStatement;
		try {
			Connection conn = getConnectioDetails();
			conn.setAutoCommit(true);
			String insertQuery = "INSERT INTO SUPPLIER_PORTAL.INVOICE_MASTER(UNIQUE_ID, INVOICE_ID,INVOICE_DATE,INVOICE_TYPE, CURRENCY,INVOICE_TOTAL_AMOUNT,INVOICE_DUE_AMOUNT,NETTED_AMOUNT,INVOICE_STATUS,INVOICE_ON_HOLD_FLAG,"
					+ "INVOICE_PAYMENT_STATUS,INVOICE_DUE_DATE,TOTAL_ITEM_QUANTIY,TOTAL_UNIQUE_ITEMS,ATTACHMENTS,DELIVERY_ADDRESS,SENDER_ADDRESS,CREATED_DATETIME,PO_NUMBER)"
					+ " VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = conn.prepareStatement(insertQuery);
			preparedStatement.setString(1, omUtils.setRandomUUID());
			preparedStatement.setString(2, omUtils.generateInvoiceId());
			preparedStatement.setString(3, omUtils.generateCurrentDate());
			preparedStatement.setString(4, "Standard");
			preparedStatement.setString(5, "INR");
			preparedStatement.setString(6, invoiceTotalAmt);
			preparedStatement.setString(7, invoiceTotalAmt);
			preparedStatement.setString(8, "0");
			preparedStatement.setString(9, "IN-PROGRESS");
			preparedStatement.setString(10, "N");
			preparedStatement.setString(11, "NOT PAID");
			preparedStatement.setString(12, omUtils.getNextSeventhDate(omUtils.generateCurrentDate()));
			preparedStatement.setString(13, totalItemQty);
			preparedStatement.setString(14, totalUniqItems);
			preparedStatement.setString(15, "");
			preparedStatement.setString(16, deliveryAddress);
			preparedStatement.setString(17, dispatchLocation);
			preparedStatement.setString(18, omUtils.generateCurrentDate());
			preparedStatement.setString(19, coId);
			preparedStatement.addBatch();
			preparedStatement.close();
			conn.close();
			return "Invoice created Successfully";

		} catch (SQLException ex) {
			System.err.println("SQLException information");
			while (ex != null) {
				System.err.println("Error msg: " + ex.getMessage());
				ex = ex.getNextException();
			}
			throw new RuntimeException("Error");
		}
	}

	public String generateEway() {
		return omUtils.generateEway();
	}

	public String generateAWB() {
		return omUtils.generateAWB();
	}

	public String submitCustomerOrder(String customerOrderId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnectioDetails();
		String updateStatus = "Invalid";
		try {
			conn = getConnectioDetails();
			String query = "UPDATE SUPPLIER_PORTAL.CUSTOMER_ORDER_MASTER SET ORDER_STATUS = ? WHERE CO_NUMBER = ?  ";
			logger.info(query);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Submitted");
			pstmt.setString(2, customerOrderId);
			int updateStatusCode = pstmt.executeUpdate();
			logger.info(Integer.toString(updateStatusCode));
			updateStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return updateStatus;

	}

	public String dispatchCustomerOrder(String customerOrderId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnectioDetails();
		String updateStatus = "Invalid";
		try {
			conn = getConnectioDetails();
			String query = "UPDATE SUPPLIER_PORTAL.CUSTOMER_ORDER_MASTER SET ORDER_STATUS = ? WHERE CO_NUMBER = ?  ";
			logger.info(query);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Ready For Dispatch");
			pstmt.setString(2, customerOrderId);
			int updateStatusCode = pstmt.executeUpdate();
			logger.info(Integer.toString(updateStatusCode));
			updateStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return updateStatus;
	}

	public ArrayList<TPLPartnerMaster> getTPLPartnerData() throws SQLException, ClassNotFoundException {
		TPLPartnerMaster tplPartner;
		ArrayList<TPLPartnerMaster> tplPartnerList = new ArrayList<TPLPartnerMaster>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.TPL_PARTNERS;";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			tplPartner = new TPLPartnerMaster();
			tplPartner.setPartnerId(rs.getString("PARTNER_ID"));
			tplPartner.setPartnerName(rs.getString("PARTNER_NAME"));
			tplPartnerList.add(tplPartner);
		}
		logger.info("[C]CustomerOrderDao::[M]getAllCOListingData -> The Item list is: " + tplPartnerList.toString());
		return tplPartnerList;
	}

		public String generateInvoice(InvoiceMaster invoiceMaster) throws ParseException, ClassNotFoundException {
			PreparedStatement preparedStatement;
			try {
				Connection conn = getConnectioDetails();
				conn.setAutoCommit(true);
				String insertQuery = "INSERT INTO SUPPLIER_PORTAL.INVOICE_MASTER(UNIQUE_ID, INVOICE_ID,INVOICE_DATE,INVOICE_TYPE, CURRENCY,INVOICE_TOTAL_AMOUNT,INVOICE_DUE_AMOUNT,NETTED_AMOUNT,INVOICE_STATUS,INVOICE_ON_HOLD_FLAG,"
						+ "INVOICE_PAYMENT_STATUS,INVOICE_DUE_DATE,TOTAL_ITEM_QUANTIY,TOTAL_UNIQUE_ITEMS,ATTACHMENTS,DELIVERY_ADDRESS,SENDER_ADDRESS,CREATED_DATETIME,PO_NUMBER,CUSTOMER_ID,INVOICED_ITEM_DETAILS)"
						+ " VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				preparedStatement = conn.prepareStatement(insertQuery);
				String invoiceId = omUtils.generateInvoiceId();
				preparedStatement.setString(1, omUtils.setRandomUUID());
				preparedStatement.setString(2,invoiceId);
				preparedStatement.setString(3, omUtils.generateCurrentDate());
				preparedStatement.setString(4, "Standard");
				preparedStatement.setString(5, "INR");
				preparedStatement.setString(6, invoiceMaster.getInvoiceTotalAmount());
				preparedStatement.setString(7, invoiceMaster.getInvoiceDueAmount());
				preparedStatement.setString(8, invoiceMaster.getNettedAmt());
				preparedStatement.setString(9, "IN-PROGRESS");
				preparedStatement.setString(10, "N");
				preparedStatement.setString(11, "NOT PAID");
				preparedStatement.setString(12, omUtils.getNextSeventhDate(omUtils.generateCurrentDate()));
				preparedStatement.setString(13, invoiceMaster.getTotalItemQty());
				preparedStatement.setString(14, invoiceMaster.getTotalUniqueItems());
				preparedStatement.setString(15, "");
				preparedStatement.setString(16, invoiceMaster.getDeliveryAddress());
				preparedStatement.setString(17, invoiceMaster.getSenderAddress());
				preparedStatement.setString(18, omUtils.generateCurrentDate());
				preparedStatement.setString(19, invoiceMaster.getPoNumber());
				preparedStatement.setString(20, invoiceMaster.getCustomerId());
				preparedStatement.setString(21, invoiceMaster.getInvoicedItems());
				preparedStatement.addBatch();
				preparedStatement.executeBatch();
				preparedStatement.close();
				conn.close();
				return invoiceId;

			} catch (SQLException ex) {
				System.err.println("SQLException information");
				while (ex != null) {
					System.err.println("Error msg: " + ex.getMessage());
					ex = ex.getNextException();
				}
				throw new RuntimeException("Error");
			}
		}
	

	public String updateCOStatus(String coId, String coStatus) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectioDetails();
		String updateStatus = "Invalid";
		try {
			conn = getConnectioDetails();
				String query = "UPDATE SUPPLIER_PORTAL.CUSTOMER_ORDER_MASTER SET ORDER_STATUS = ? WHERE CO_NUMBER = ?  ";
				logger.info(query);
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,coStatus);
				pstmt.setString(2,coId);
				int updateStatusCode = pstmt.executeUpdate();
				logger.info(Integer.toString(updateStatusCode));
				updateStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return updateStatus;
	}

	public String saveCODetailsInter(String coId, String itemDetails) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectioDetails();
		String updateStatus = "Invalid";
		try {
			conn = getConnectioDetails();
			String query = "UPDATE SUPPLIER_PORTAL.CUSTOMER_ORDER_MASTER SET ITEM_DETAILS = ? WHERE CO_NUMBER = ?  ";
			logger.info(query);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, itemDetails);
			pstmt.setString(2, coId);
			int updateStatusCode = pstmt.executeUpdate();
			logger.info(Integer.toString(updateStatusCode));
			updateStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return updateStatus;
	}

	public ArrayList<ItemMaster> saveCODetailsInter(String[] itemId) throws SQLException, ClassNotFoundException {
		ItemMaster itemMasterObj;
		ArrayList<ItemMaster> itemMasterList = new ArrayList<ItemMaster>();
		Connection conn = getConnectioDetails();
		String[] strarr = itemId;
		StringBuilder itemIdString  = omUtils.toString(strarr);
		String query = "SELECT  * from SUPPLIER_PORTAL.ITEM_LISTING_MASTER WHERE ITEM_ID IN" + itemIdString + "ORDER BY CREATED_DATETIME DESC LIMIT 20";
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			itemMasterObj = new ItemMaster();
			itemMasterObj.setItemId(rs.getString("item_Id"));
			itemMasterObj.setItemName(rs.getString("ITEM_NAME"));
			itemMasterObj.setItemDescription(rs.getString("item_Description"));
			itemMasterObj.setSku(rs.getString("sku"));
			itemMasterObj.setCategory(rs.getString("category"));
			itemMasterObj.setPrice(rs.getString("price"));
			itemMasterObj.setStatus(rs.getString("status"));
			itemMasterList.add(itemMasterObj);
		}
		logger.info("[C]ListingDao::[M]getAllItemDetails -> The Item details list is: " + itemMasterList.toString());
		return itemMasterList;
	}

}
