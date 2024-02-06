package com.kpmg.te.retail.supplierportal.OrderManagement.entity;

public class ItemDetails {

	private String itemId;
	private String itemName;
	private String orderedQty;
	private long shippedQty;
	private long deliveredQty;
	private long estLandingCost;

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

	public String getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(String orderedQty) {
		this.orderedQty = orderedQty;
	}

	public long getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(long shippedQty) {
		this.shippedQty = shippedQty;
	}

	public long getDeliveredQty() {
		return deliveredQty;
	}

	public void setDeliveredQty(long deliveredQty) {
		this.deliveredQty = deliveredQty;
	}

	public long getEstLandingCost() {
		return estLandingCost;
	}

	public void setEstLandingCost(long estLandingCost) {
		this.estLandingCost = estLandingCost;
	}

	@Override
	public String toString() {
		return "ItemDetails [itemId=" + itemId + ", itemName=" + itemName + ", orderedQty=" + orderedQty
				+ ", shippedQty=" + shippedQty + ", deliveredQty=" + deliveredQty + ", estLandingCost=" + estLandingCost
				+ "]";
	}

}
