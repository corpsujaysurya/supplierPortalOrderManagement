package com.kpmg.te.retail.supplierportal.OrderManagement.entity;

public class CustomerOrderMaster {

	private String uniqueId;
	private String coNumber;
	private String customerMobNum;
	private String orderCreationDate;
	private String expectedDelDate;
	private String orderStatus;

	private String giftWrap;
	private String giftMessage;
	private String customerName;
	private String deliveryType;
	private String shippingAddress;

	private String itemDetails;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getCoNumber() {
		return coNumber;
	}

	public void setCoNumber(String coNumber) {
		this.coNumber = coNumber;
	}

	public String getCustomerMobNum() {
		return customerMobNum;
	}

	public void setCustomerMobNum(String customerMobNum) {
		this.customerMobNum = customerMobNum;
	}

	public String getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	public String getExpectedDelDate() {
		return expectedDelDate;
	}

	public void setExpectedDelDate(String expectedDelDate) {
		this.expectedDelDate = expectedDelDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getGiftWrap() {
		return giftWrap;
	}

	public void setGiftWrap(String giftWrap) {
		this.giftWrap = giftWrap;
	}

	public String getGiftMessage() {
		return giftMessage;
	}

	public void setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	@Override
	public String toString() {
		return "CustomerOrderMaster [uniqueId=" + uniqueId + ", coNumber=" + coNumber + ", customerMobNum="
				+ customerMobNum + ", orderCreationDate=" + orderCreationDate + ", expectedDelDate=" + expectedDelDate
				+ ", orderStatus=" + orderStatus + ", giftWrap=" + giftWrap + ", giftMessage=" + giftMessage
				+ ", customerName=" + customerName + ", deliveryType=" + deliveryType + ", shippingAddress="
				+ shippingAddress + ", itemDetails=" + itemDetails + "]";
	}

}
