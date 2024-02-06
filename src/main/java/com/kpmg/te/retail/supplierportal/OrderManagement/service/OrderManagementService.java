package com.kpmg.te.retail.supplierportal.OrderManagement.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.te.retail.supplierportal.OrderManagement.controller.CustomerOrderController;
import com.kpmg.te.retail.supplierportal.OrderManagement.controller.PurchaseOrderController;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.CustomerOrderMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.PurchaseOrderMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.manager.CustomerOrderManager;
import com.kpmg.te.retail.supplierportal.OrderManagement.manager.PurchaseOrderManager;
import com.kpmg.te.retail.supplierportal.OrderManagement.utils.OrderManagementUtils;

@RestController
@RequestMapping("/api/orderManagement/service")
public class OrderManagementService {
	
	@Autowired
	PurchaseOrderController poController;
	
	@Autowired
	PurchaseOrderManager poManager;
	
	@Autowired
	CustomerOrderController coController;

	@Autowired
	CustomerOrderManager coManager;
	
	@Autowired
	OrderManagementUtils omUtils;
	
	private static final Logger logger = Logger.getLogger(OrderManagementService.class.getName());

	/************************************************************************************************************************************************************************** */
	/*													PURCHASE ORDERS MODULE REST END-POINTS                                                                                 */
	/**************************************************************************************************************************************************************************/
	
	@RequestMapping(path = "/purchaseOrders/getPOListingData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<PurchaseOrderMaster> getPOListingData() throws ClassNotFoundException, SQLException {
		ArrayList<PurchaseOrderMaster> purchaseOrderMasterList = new ArrayList<PurchaseOrderMaster>();
		purchaseOrderMasterList = poController.getAllPOListingData();
		logger.info("[C]OrderManagementService::[M]getPOListingData -> The Purchase Order List to display is: "+purchaseOrderMasterList.toString());
		return  purchaseOrderMasterList;
	}
	
	@RequestMapping(path = "/purchaseOrders/getPODetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PurchaseOrderMaster getPODetails(@RequestBody String poId) throws ClassNotFoundException, SQLException {
		PurchaseOrderMaster poDetails = new PurchaseOrderMaster();
		poDetails = poController.getPODetailsData(poId);
		logger.info("[C]ListingPricingService::[M]getItemDetails -> The Purchase Order Details list to display is: "+poDetails.toString());
		return  poDetails;
	}
	
	/************************************************************************************************************************************************************************** */
	/*													CUSTOMER ORDERS MODULE REST END-POINTS                                                                                 */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/customerOrders/getCOListingData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<CustomerOrderMaster> getCOListingData() throws ClassNotFoundException, SQLException {
		ArrayList<CustomerOrderMaster> customerOrderMasterList = new ArrayList<CustomerOrderMaster>();
		customerOrderMasterList = coController.getAllCOListingData();
		logger.info("[C]OrderManagementService::[M]getCOListingData -> The Customer Order List to display is: "+customerOrderMasterList.toString());
		return  customerOrderMasterList;
	}
	
	@RequestMapping(path = "/customerOrders/getCODetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerOrderMaster getCODetails(@RequestBody String coId) throws ClassNotFoundException, SQLException {
		CustomerOrderMaster coDetails = new CustomerOrderMaster();
		coDetails = coController.getCODetailsData(coId);
		logger.info("[C]OrderManagementService::[M]getCODetails -> The Customer Order Details list to display is: "+coDetails.toString());
		return  coDetails;
	}
	
	@RequestMapping(path = "/customerOrders/generateInvoice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateInvoice(@RequestBody String coId, @RequestBody String invoiceTotalAmt,
			@RequestBody String totalItemQty, @RequestBody String totalUniqItems, @RequestBody String deliveryAddress,
			@RequestBody String dispatchLocation) throws ClassNotFoundException, SQLException, ParseException {
		String invoiceId = new String();
		invoiceId = coController.createInvoice(coId, invoiceTotalAmt, totalItemQty, totalUniqItems, deliveryAddress,
				dispatchLocation);
		logger.info("[C]OrderManagementService::[M]generateInvoice -> The Customer Order invoice id to display is: "
				+ invoiceId.toString());
		return invoiceId;
	}

	@RequestMapping(path = "/customerOrders/generateEway", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateEway(@RequestBody String invoiceList) throws ClassNotFoundException, SQLException {
		String ewayBillList = new String();
		ewayBillList = coController.generateEway(invoiceList);
		logger.info("[C]OrderManagementService::[M]getCODetails -> The Customer Order Details list to display is: "+ewayBillList.toString());
		return  ewayBillList;
	}
	
	@RequestMapping(path = "/customerOrders/generateAWB", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateAWB(@RequestBody String invoiceList) throws ClassNotFoundException, SQLException {
		String awbBill = new  String();
		awbBill = coController.generateAWB(invoiceList);
		logger.info("[C]OrderManagementService::[M]generateAWB -> The Customer Order Details list to display is: "+awbBill.toString());
		return  awbBill;
	}
	
	@RequestMapping(path = "/customerOrders/submitCO", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String submitCO(@RequestBody CustomerOrderMaster customerOrderMaster) throws ClassNotFoundException, SQLException {
		String status;
		status = coController.submitCustomerOrder(customerOrderMaster);
		logger.info("[C]OrderManagementService::[M]submitCO -> The status of Customer Order submission is: "+status.toString());
		return  status;
	}
	
	@RequestMapping(path = "/customerOrders/dispatchCO", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String dispatchCO(@RequestBody CustomerOrderMaster customerOrderMaster) throws ClassNotFoundException, SQLException {
		String status;
		status = coController.dispatchCustomerOrder(customerOrderMaster);
		logger.info("[C]OrderManagementService::[M]submitCO -> The status of Customer Order submission is: "+status.toString());
		return  status;
	}
}
