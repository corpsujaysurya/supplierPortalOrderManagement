package com.kpmg.te.retail.supplierportal.OrderManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.OrderManagement.constants.OrderManagementConstants;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.PurchaseOrderMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.utils.OrderManagementUtils;

@Component
public class PurchaseOrderDao {

	@Autowired
	OrderManagementUtils omUtils;

	private static final Logger logger = Logger.getLogger(PurchaseOrderDao.class.getName());

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

	public ArrayList<PurchaseOrderMaster> getAllPOListingData() throws SQLException, ClassNotFoundException {
		PurchaseOrderMaster poMasterObj;
		ArrayList<PurchaseOrderMaster> poMasterList = new ArrayList<PurchaseOrderMaster>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.PURCHASE_ORDER_MASTER ORDER BY CREATION_DATE DESC LIMIT 20";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			poMasterObj = new PurchaseOrderMaster();
			poMasterObj.setPoNumber(rs.getString("PO_NUMBER"));
			poMasterObj.setLocation(rs.getString("LOCATION"));
			poMasterObj.setCreationDate(rs.getString("CREATION_DATE"));
			poMasterObj.setTotalItemQty(rs.getLong("TOTAL_ITEM_QUANTIY"));
			poMasterObj.setTotalUniqItms(rs.getLong("TOTAL_UNIQUE_ITEMS"));
			poMasterList.add(poMasterObj);
		}
		logger.info("[C]PurchaseOrderDao::[M]getAllPOListingData -> The Item list is: " + poMasterList.toString());
		return poMasterList;
	}

	public PurchaseOrderMaster getPODetails(String poId) throws SQLException, ClassNotFoundException {
		PurchaseOrderMaster poMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.PURCHASE_ORDER_MASTER WHERE PO_NUMBER ='" + poId+ "'";
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			poMasterObj = new PurchaseOrderMaster();
			poMasterObj.setUniqueId(rs.getString("UNIQUE_ID"));
			poMasterObj.setPoNumber(rs.getString("PO_NUMBER"));
			poMasterObj.setLocation(rs.getString("LOCATION"));
			poMasterObj.setCreationDate(rs.getString("CREATION_DATE"));
			poMasterObj.setTotalItemQty(rs.getLong("TOTAL_ITEM_QUANTIY"));
			poMasterObj.setTotalUniqItms(rs.getLong("TOTAL_UNIQUE_ITEMS"));
			poMasterObj.setShipByDate(rs.getString("SHIPBY_DATE"));
			poMasterObj.setEstDelDate(rs.getString("ESTIMATED_DELIVERY_DATE"));
			poMasterObj.setLeadTime(rs.getString("LEAD_TIME"));
			poMasterObj.setTotalCost(rs.getString("TOTAL_COST"));
			poMasterObj.setItemDetails(rs.getString("ITEM_DETAILS"));
			poMasterObj.setAsnDetails(rs.getString("ASN_DETAILS"));
		}
		logger.info("[C]ListingDao::[M]getAllItemDetails -> The Item details list is: " + poMasterObj.toString());
		return poMasterObj;
	}

}
