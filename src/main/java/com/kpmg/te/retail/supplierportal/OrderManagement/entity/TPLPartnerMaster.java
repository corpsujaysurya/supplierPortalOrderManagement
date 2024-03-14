package com.kpmg.te.retail.supplierportal.OrderManagement.entity;

public class TPLPartnerMaster {

	private String partnerId;
	private String partnerName;

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	@Override
	public String toString() {
		return "TPLPartnerMaster [partnerId=" + partnerId + ", partnerName=" + partnerName + "]";
	}

}
