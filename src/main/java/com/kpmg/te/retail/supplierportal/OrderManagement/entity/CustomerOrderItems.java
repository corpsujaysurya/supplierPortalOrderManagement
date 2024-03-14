package com.kpmg.te.retail.supplierportal.OrderManagement.entity;

public class CustomerOrderItems {

	private String itemId;
	private String itemDesc;
	private String orderQty;
	private String fulfillmentId;
	private String ewayBillNo;
	private String awbNo;
	private String tplPartner;
	private String shipmentStatus;
	private String itemAcceptStatus;
	private String picklistStatus;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public String getFulfillmentId() {
		return fulfillmentId;
	}

	public void setFulfillmentId(String fulfillmentId) {
		this.fulfillmentId = fulfillmentId;
	}

	public String getEwayBillNo() {
		return ewayBillNo;
	}

	public void setEwayBillNo(String ewayBillNo) {
		this.ewayBillNo = ewayBillNo;
	}

	public String getAwbNo() {
		return awbNo;
	}

	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}

	public String getTplPartner() {
		return tplPartner;
	}

	public void setTplPartner(String tplPartner) {
		this.tplPartner = tplPartner;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getItemAcceptStatus() {
		return itemAcceptStatus;
	}

	public void setItemAcceptStatus(String itemAcceptStatus) {
		this.itemAcceptStatus = itemAcceptStatus;
	}

	public String getPicklistStatus() {
		return picklistStatus;
	}

	public void setPicklistStatus(String picklistStatus) {
		this.picklistStatus = picklistStatus;
	}

	@Override
	public String toString() {
		return "CustomerOrderItems [itemId=" + itemId + ", itemDesc=" + itemDesc + ", orderQty=" + orderQty
				+ ", fulfillmentId=" + fulfillmentId + ", ewayBillNo=" + ewayBillNo + ", awbNo=" + awbNo
				+ ", tplPartner=" + tplPartner + ", shipmentStatus=" + shipmentStatus + ", itemAcceptStatus="
				+ itemAcceptStatus + ", picklistStatus=" + picklistStatus + "]";
	}

}
