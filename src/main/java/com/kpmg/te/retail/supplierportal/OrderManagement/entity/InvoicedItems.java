package com.kpmg.te.retail.supplierportal.OrderManagement.entity;

public class InvoicedItems {

	private String itemId;
	private String itemName;
	private String poNum;
	private Integer invoicedQuantity;
	private String mrp;
	private String invoicedPrice;
	private String totalPrice;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPoNum() {
		return poNum;
	}

	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}

	public Integer getInvoicedQuantity() {
		return invoicedQuantity;
	}

	public void setInvoicedQuantity(Integer invoicedQuantity) {
		this.invoicedQuantity = invoicedQuantity;
	}

	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public String getInvoicedPrice() {
		return invoicedPrice;
	}

	public void setInvoicedPrice(String invoicedPrice) {
		this.invoicedPrice = invoicedPrice;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "InvoicedItems [itemId=" + itemId + ", itemName=" + itemName + ", poNum=" + poNum + ", invoicedQuantity="
				+ invoicedQuantity + ", mrp=" + mrp + ", invoicedPrice=" + invoicedPrice + ", totalPrice=" + totalPrice
				+ "]";
	}

}
