package com.kpmg.te.retail.supplierportal.OrderManagement.entity;

import java.util.ArrayList;

public class ASNDetails {

	private String asnId;
	private long asnCount;
	private String asnCreationDate;
	private String dcNumber;
	private long asnTotalUniqItems;
	private long asnTotalShippingsQty;
	private String shippingDate;
	private String etaDate;
	private String location;
	private ArrayList<String> containerDetails;

	public String getAsnCreationDate() {
		return asnCreationDate;
	}

	public void setAsnCreationDate(String asnCreationDate) {
		this.asnCreationDate = asnCreationDate;
	}

	public String getDcNumber() {
		return dcNumber;
	}

	public void setDcNumber(String dcNumber) {
		this.dcNumber = dcNumber;
	}

	public long getAsnTotalUniqItems() {
		return asnTotalUniqItems;
	}

	public void setAsnTotalUniqItems(long asnTotalUniqItems) {
		this.asnTotalUniqItems = asnTotalUniqItems;
	}

	public long getAsnTotalShippingsQty() {
		return asnTotalShippingsQty;
	}

	public void setAsnTotalShippingsQty(long asnTotalShippingsQty) {
		this.asnTotalShippingsQty = asnTotalShippingsQty;
	}

	public String getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getEtaDate() {
		return etaDate;
	}

	public void setEtaDate(String etaDate) {
		this.etaDate = etaDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAsnId() {
		return asnId;
	}

	public void setAsnId(String asnId) {
		this.asnId = asnId;
	}

	public long getAsnCount() {
		return asnCount;
	}

	public void setAsnCount(long asnCount) {
		this.asnCount = asnCount;
	}

	public ArrayList<String> getContainerDetails() {
		return containerDetails;
	}

	public void setContainerDetails(ArrayList<String> containerDetails) {
		this.containerDetails = containerDetails;
	}

	@Override
	public String toString() {
		return "ASNDetails [asnId=" + asnId + ", asnCount=" + asnCount + ", asnCreationDate=" + asnCreationDate
				+ ", dcNumber=" + dcNumber + ", asnTotalUniqItems=" + asnTotalUniqItems + ", asnTotalShippingsQty="
				+ asnTotalShippingsQty + ", shippingDate=" + shippingDate + ", etaDate=" + etaDate + ", location="
				+ location + ", containerDetails=" + containerDetails + "]";
	}

}
