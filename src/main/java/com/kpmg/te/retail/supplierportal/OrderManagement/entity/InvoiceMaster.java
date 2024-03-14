package com.kpmg.te.retail.supplierportal.OrderManagement.entity;

import java.util.ArrayList;

public class InvoiceMaster {
	private String uniqueId;
	private String invoiceId;
	private String invoiceDate;
	private String invoiceType;
	private String currency;
	private String invoiceTotalAmount;
	private String invoiceDueAmount;
	private String nettedAmt;
	private String invoiceStatus;
	private String poNumber;
	private String invoiceOnHoldFlag;
	private String invoicePaymentStatus;
	private String invoiceDueDate;
	private String totalItemQty;
	private String totalUniqueItems;
	private String attachments;
	private String deliveryAddress;
	private String senderAddress;
	private String created_datetime;
	private String customerId;
	private String itemDetails;

	private ArrayList<InvoicedItems> InvoicedItems;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getInvoiceTotalAmount() {
		return invoiceTotalAmount;
	}

	public void setInvoiceTotalAmount(String invoiceTotalAmount) {
		this.invoiceTotalAmount = invoiceTotalAmount;
	}

	public String getInvoiceDueAmount() {
		return invoiceDueAmount;
	}

	public void setInvoiceDueAmount(String invoiceDueAmount) {
		this.invoiceDueAmount = invoiceDueAmount;
	}

	public String getNettedAmt() {
		return nettedAmt;
	}

	public void setNettedAmt(String nettedAmt) {
		this.nettedAmt = nettedAmt;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getInvoiceOnHoldFlag() {
		return invoiceOnHoldFlag;
	}

	public void setInvoiceOnHoldFlag(String invoiceOnHoldFlag) {
		this.invoiceOnHoldFlag = invoiceOnHoldFlag;
	}

	public String getInvoicePaymentStatus() {
		return invoicePaymentStatus;
	}

	public void setInvoicePaymentStatus(String invoicePaymentStatus) {
		this.invoicePaymentStatus = invoicePaymentStatus;
	}

	public String getInvoiceDueDate() {
		return invoiceDueDate;
	}

	public void setInvoiceDueDate(String invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}

	public String getTotalItemQty() {
		return totalItemQty;
	}

	public void setTotalItemQty(String totalItemQty) {
		this.totalItemQty = totalItemQty;
	}

	public String getTotalUniqueItems() {
		return totalUniqueItems;
	}

	public void setTotalUniqueItems(String totalUniqueItems) {
		this.totalUniqueItems = totalUniqueItems;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}

	public ArrayList<InvoicedItems> getInvoicedItems() {
		return InvoicedItems;
	}

	public void setInvoicedItems(ArrayList<InvoicedItems> invoicedItems) {
		InvoicedItems = invoicedItems;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	@Override
	public String toString() {
		return "InvoiceMaster [uniqueId=" + uniqueId + ", invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate
				+ ", invoiceType=" + invoiceType + ", currency=" + currency + ", invoiceTotalAmount="
				+ invoiceTotalAmount + ", invoiceDueAmount=" + invoiceDueAmount + ", nettedAmt=" + nettedAmt
				+ ", invoiceStatus=" + invoiceStatus + ", poNumber=" + poNumber + ", invoiceOnHoldFlag="
				+ invoiceOnHoldFlag + ", invoicePaymentStatus=" + invoicePaymentStatus + ", invoiceDueDate="
				+ invoiceDueDate + ", totalItemQty=" + totalItemQty + ", totalUniqueItems=" + totalUniqueItems
				+ ", attachments=" + attachments + ", deliveryAddress=" + deliveryAddress + ", senderAddress="
				+ senderAddress + ", created_datetime=" + created_datetime + ", customerId=" + customerId
				+ ", itemDetails=" + itemDetails + ", InvoicedItems=" + InvoicedItems + "]";
	}

}