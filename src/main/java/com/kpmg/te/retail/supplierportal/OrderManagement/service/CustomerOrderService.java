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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.te.retail.supplierportal.OrderManagement.controller.CustomerOrderController;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.CustomerOrderMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.InvoiceMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.ItemMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.TPLPartnerMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.manager.CustomerOrderManager;
import com.kpmg.te.retail.supplierportal.OrderManagement.utils.OrderManagementUtils;


@RestController
@RequestMapping("/api/customerOrders/service")
public class CustomerOrderService {
	
	@Autowired
	CustomerOrderController coController;

	@Autowired
	CustomerOrderManager coManager;
	
	@Autowired
	OrderManagementUtils omUtils;
	
	private static final Logger logger = Logger.getLogger(CustomerOrderService.class.getName());


	/************************************************************************************************************************************************************************** */
	/*													CUSTOMER ORDERS MODULE REST END-POINTS                                                                                 */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/getCOListingData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<CustomerOrderMaster> getCOListingData() throws ClassNotFoundException, SQLException {
		ArrayList<CustomerOrderMaster> customerOrderMasterList = new ArrayList<CustomerOrderMaster>();
		customerOrderMasterList = coController.getAllCOListingData();
		logger.info("[C]CustomerOrderService::[M]getCOListingData -> The Customer Order List to display is: "+customerOrderMasterList.toString());
		return  customerOrderMasterList;
	}
	
	@RequestMapping(path = "/getCODetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerOrderMaster getCODetails(@RequestParam String coId) throws ClassNotFoundException, SQLException {
		CustomerOrderMaster coDetails = new CustomerOrderMaster();
		coDetails = coController.getCODetailsData(coId);
		logger.info("[C]CustomerOrderService::[M]getCODetails -> The Customer Order Details list to display is: "+coDetails.toString());
		return  coDetails;
	}
	
	
	@RequestMapping(path = "/updateCOStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateCOStatus(@RequestParam String coId,@RequestParam String coStatus) throws ClassNotFoundException, SQLException {
		String updateStatus = coController.updateCOStatus(coId,coStatus);
		logger.info("[C]CustomerOrderService::[M]updateCOStatus -> The Customer Order status is updated");
		return  updateStatus;
	}
	
	@RequestMapping(path = "/saveIntermediateCO", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveCO(@RequestParam String coId,@RequestParam String itemDetails) throws ClassNotFoundException, SQLException {
		String updateStatus = coController.saveItemDetails(coId,itemDetails);
		logger.info("[C]CustomerOrderService::[M]saveCO -> The Customer Order is saved");
		return  updateStatus;
	}
	
	@RequestMapping(path = "/getItemPrice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<ItemMaster> getItemPrice(@RequestParam(value="itemId[]") String[] itemId) throws ClassNotFoundException, SQLException {
		logger.info(itemId.toString());
		ArrayList<ItemMaster> itemDetails = new ArrayList<ItemMaster>();
		itemDetails = coController.getItemPrice(itemId);
		logger.info("[C]CustomerOrderService::[M]getItemPrice -> The Item Details list to display is: "+itemDetails.toString());
		return  itemDetails;
	}
	
	
	@RequestMapping(path = "/getTPLPartners", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<TPLPartnerMaster> getTPLPartners() throws ClassNotFoundException, SQLException {
		ArrayList<TPLPartnerMaster> tplPartnerList = new ArrayList<TPLPartnerMaster>();
		tplPartnerList = coController.getPartnerData();
		logger.info("[C]CustomerOrderService::[M]getTPLPartners -> The TPL Partners list to display is: "+tplPartnerList.toString());
		return  tplPartnerList;
	}
	
	
	@RequestMapping(path = "createInvoice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createInvoice(@RequestBody InvoiceMaster invoiceMaster) throws ClassNotFoundException, SQLException, ParseException {
		String message  = new String();
		message = coController.createNewInvoice(invoiceMaster);
		logger.info("[C]InvoiceService::[M]createInvoice -> The new invoice number  to display is: "+message.toString());
		return  message;
	}

	@RequestMapping(path = "/generateEway", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateEway(@RequestBody String invoiceList) throws ClassNotFoundException, SQLException {
		String ewayBillList = new String();
		ewayBillList = coController.generateEway(invoiceList);
		logger.info("[C]CustomerOrderService::[M]getCODetails -> The Customer Order Details list to display is: "+ewayBillList.toString());
		return  ewayBillList;
	}
	
	@RequestMapping(path = "/generateAWB", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateAWB(@RequestBody String invoiceList) throws ClassNotFoundException, SQLException {
		String awbBill = new  String();
		awbBill = coController.generateAWB(invoiceList);
		logger.info("[C]CustomerOrderService::[M]generateAWB -> The Customer Order Details list to display is: "+awbBill.toString());
		return  awbBill;
	}
	
	@RequestMapping(path = "/submitCO", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String submitCO(@RequestBody CustomerOrderMaster customerOrderMaster) throws ClassNotFoundException, SQLException {
		String status;
		status = coController.submitCustomerOrder(customerOrderMaster);
		logger.info("[C]CustomerOrderService::[M]submitCO -> The status of Customer Order submission is: "+status.toString());
		return  status;
	}
	
	@RequestMapping(path = "/dispatchCO", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String dispatchCO(@RequestBody CustomerOrderMaster customerOrderMaster) throws ClassNotFoundException, SQLException {
		String status;
		status = coController.dispatchCustomerOrder(customerOrderMaster);
		logger.info("[C]OrderManagementService::[M]submitCO -> The status of Customer Order submission is: "+status.toString());
		return  status;
	}

}
