package com.kpmg.te.retail.supplierportal.OrderManagement.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.OrderManagement.dao.CustomerOrderDao;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.CustomerOrderMaster;

@Component
public class CustomerOrderController {

	@Autowired
	CustomerOrderDao coDao;

	public ArrayList<CustomerOrderMaster> getAllCOListingData() throws ClassNotFoundException, SQLException {
		return coDao.getAllCOListingData();
	}

	public CustomerOrderMaster getCODetailsData(String coId) throws ClassNotFoundException, SQLException {
		return coDao.getCODetails(coId);
	}

	public String createInvoice(String coId, String invoiceTotalAmt, String totalItemQty, String totalUniqItems,
			String deliveryAddress, String dispatchLocation) throws ClassNotFoundException, ParseException {
		return coDao.generateInvoice(coId, invoiceTotalAmt, totalItemQty, totalUniqItems, deliveryAddress,
				dispatchLocation);
	}

	public String generateEway(String invoiceId) {
		return coDao.generateEway(invoiceId);
	}

	public String generateAWB(String invoiceId) {
		return coDao.generateAWB(invoiceId);
	}

	public String submitCustomerOrder(CustomerOrderMaster customerOrderMaster) throws ClassNotFoundException {
		return coDao.submitCustomerOrder(customerOrderMaster);
	}

	public String dispatchCustomerOrder(CustomerOrderMaster customerOrderMaster) throws ClassNotFoundException {
		return coDao.dispatchCustomerOrder(customerOrderMaster);
	}

}
