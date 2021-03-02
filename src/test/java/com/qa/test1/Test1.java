package com.qa.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.By;

public class Test1 {
	
	protected static WebDriver driver;
	
	@Test
	public void testPage() throws InterruptedException {
		Selectors selectors = new Selectors(driver);
		selectors.loadDriver();
		selectors.openPage();
		selectors.bestSellers();
		selectors.thirdItem();
		selectors.selectSize();
		selectors.selectColor();
		selectors.addToCart();
		selectors.modalIsDisplayed();
		selectors.increaseAmount();
		selectors.proceedToCheckout2();
		selectors.login();
		selectors.cityInAddress();
		selectors.proceedToCheckout3();
		selectors.checkTermsOfService();
		selectors.proceedToCheckout4();
		selectors.selectBankWire();
		selectors.confirmOrder();
		selectors.orderConfirmation();
	}
}
