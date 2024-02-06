package com.kpmg.te.retail.supplierportal.OrderManagement.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class OrderManagementUtils {

	private static final Logger logger = Logger.getLogger(OrderManagementUtils.class.getName());

	public String setRandomUUID() {
		return UUID.randomUUID().toString();
	}

	public String generateInvoiceId() {
		String invoiceId = "INV-" + generateRandomNumber(7);
		logger.info(
				"[C]OrderManagementUtils::[M]generateInvoiceId -> The Invoice ID generated is:" + invoiceId.toString());
		return invoiceId;
	}

	public String generateRandomNumber(int charLength) {
		return String.valueOf(charLength < 1 ? 0
				: new Random().nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
						+ (int) Math.pow(10, charLength - 1));
	}

	public String generateCurrentDate() {
		return new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
	}

	public String getNextSeventhDate(String curDate) throws ParseException {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		final Date date = format.parse(curDate);
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		return format.format(calendar.getTime());
	}

	public String generateEway() {
		String ewayBill = "EWAY-" + generateRandomNumber(9);
		logger.info(
				"[C]OrderManagementUtils::[M]generateEway -> The Eway Bill generated is:" + ewayBill.toString());
		return ewayBill;
	}

	public String generateAWB() {
		String awbBill = "AWB-" + generateRandomNumber(12);
		logger.info(
				"[C]OrderManagementUtils::[M]generateAWB -> The AWB generated is:" + awbBill.toString());
		return awbBill;
	}

}
