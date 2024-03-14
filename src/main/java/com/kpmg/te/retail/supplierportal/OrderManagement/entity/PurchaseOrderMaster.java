package com.kpmg.te.retail.supplierportal.OrderManagement.entity;


public class PurchaseOrderMaster {
	private String uniqueId;
	private String poNumber;
	private String location;
	private String creationDate;
	private Long totalItemQty;
	private Long totalUniqItms;
	private String shipByDate;
	private String estDelDate;
	private String leadTime;
	private String totalCost;
	private String itemDetails;
	private String asnDetails;
	
	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	public String getAsnDetails() {
		return asnDetails;
	}

	public void setAsnDetails(String asnDetails) {
		this.asnDetails = asnDetails;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Long getTotalItemQty() {
		return totalItemQty;
	}

	public void setTotalItemQty(Long totalItemQty) {
		this.totalItemQty = totalItemQty;
	}

	public Long getTotalUniqItms() {
		return totalUniqItms;
	}

	public void setTotalUniqItms(Long totalUniqItms) {
		this.totalUniqItms = totalUniqItms;
	}

	public String getShipByDate() {
		return shipByDate;
	}

	public void setShipByDate(String shipByDate) {
		this.shipByDate = shipByDate;
	}

	public String getEstDelDate() {
		return estDelDate;
	}

	public void setEstDelDate(String estDelDate) {
		this.estDelDate = estDelDate;
	}

	public String getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "PurchaseOrderMaster [uniqueId=" + uniqueId + ", poNumber=" + poNumber + ", location=" + location
				+ ", creationDate=" + creationDate + ", totalItemQty=" + totalItemQty + ", totalUniqItms="
				+ totalUniqItms + ", shipByDate=" + shipByDate + ", estDelDate=" + estDelDate + ", leadTime=" + leadTime
				+ ", totalCost=" + totalCost + ", itemDetails=" + itemDetails + ", asnDetails=" + asnDetails + "]";
	}

}
