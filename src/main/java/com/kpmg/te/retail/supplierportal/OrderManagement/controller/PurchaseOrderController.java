package com.kpmg.te.retail.supplierportal.OrderManagement.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.OrderManagement.dao.PurchaseOrderDao;
import com.kpmg.te.retail.supplierportal.OrderManagement.entity.PurchaseOrderMaster;

@Component
public class PurchaseOrderController {
	
	@Autowired
	PurchaseOrderDao poDao;

	public ArrayList<PurchaseOrderMaster> getAllPOListingData() throws ClassNotFoundException, SQLException {
		return poDao.getAllPOListingData();
	}

	public PurchaseOrderMaster getPODetailsData(String poId) throws ClassNotFoundException, SQLException {
		return poDao.getPODetails(poId);
	}

}
