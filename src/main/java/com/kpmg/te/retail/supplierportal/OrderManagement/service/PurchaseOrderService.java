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
import com.kpmg.te.retail.supplierportal.OrderManagement.controller.PurchaseOrderController;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.CustomerOrderMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.PurchaseOrderMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.TPLPartnerMaster;
import com.kpmg.te.retail.supplierportal.OrderManagement.manager.CustomerOrderManager;
import com.kpmg.te.retail.supplierportal.OrderManagement.manager.PurchaseOrderManager;
import com.kpmg.te.retail.supplierportal.OrderManagement.utils.OrderManagementUtils;

@RestController
@RequestMapping("/api/purchaseOrders/service")
public class PurchaseOrderService {
	
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
	
	private static final Logger logger = Logger.getLogger(PurchaseOrderService.class.getName());

	/************************************************************************************************************************************************************************** */
	/*													PURCHASE ORDERS MODULE REST END-POINTS                                                                                 */
	/**************************************************************************************************************************************************************************/
	
	@RequestMapping(path = "/getPOListingData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<PurchaseOrderMaster> getPOListingData() throws ClassNotFoundException, SQLException {
		ArrayList<PurchaseOrderMaster> purchaseOrderMasterList = new ArrayList<PurchaseOrderMaster>();
		purchaseOrderMasterList = poController.getAllPOListingData();
		logger.info("[C]OrderManagementService::[M]getPOListingData -> The Purchase Order List to display is: "+purchaseOrderMasterList.toString());
		return  purchaseOrderMasterList;
	}
	
	@RequestMapping(path = "/getPODetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PurchaseOrderMaster getPODetails(@RequestParam String poId) throws ClassNotFoundException, SQLException {
		PurchaseOrderMaster poDetails = new PurchaseOrderMaster();
		poDetails = poController.getPODetailsData(poId);
		logger.info("[C]ListingPricingService::[M]getItemDetails -> The Purchase Order Details list to display is: "+poDetails.toString());
		return  poDetails;
	}
	
	@RequestMapping(path = "/createPO", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public PurchaseOrderMaster createPO(@RequestBody PurchaseOrderMaster poMaster) throws ClassNotFoundException, SQLException {
		PurchaseOrderMaster poDetails = new PurchaseOrderMaster();
		poDetails = poController.savePO(poMaster);
		logger.info("[C]ListingPricingService::[M]createPO -> The Purchase Order Details list to display is: "+poDetails.toString());
		return  poDetails;
	}
}
