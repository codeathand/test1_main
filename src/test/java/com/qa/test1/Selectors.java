package com.qa.test1;

import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selectors {
	
	/** Timeout for waiting element **/
	int timeoutInSeconds = 2;
	
	protected static WebDriver driver;
	
	/** Locators **/
	private static By signin = By.xpath("//div[@class='header_user_info']//a[contains(text(), 'Sign in')]");
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By submitButton = By.id("SubmitLogin");
	private By bestSellersTab = By.xpath("//*[@id='home-page-tabs']/li[2]/a");
	// private By thirdItem = By.xpath("//*[@id='blockbestsellers']//li[3]");
	private By thirdItem = By.xpath("//*[@id='blockbestsellers']/li[3]/div/div[2]/h5/a");
	private By selectSize = By.xpath("//*[@id='group_1']");
	private By whiteColor = By.xpath("//*[@id='color_to_pick_list']//li[1]");
	private By addToCartButton = By.name("Submit");
	private By modalCheckout = By.xpath("//*[@id='layer_cart']");
	private By proceedToCheckout = By.xpath("//a[contains(@class, 'button-medium')]//span[contains(text(), 'Proceed to checkout')]");
	private By amountIncrease = By.id("cart_quantity_up_2_12_0_0");
	private By totalProducts = By.id("total_product");
	private By proceedToCheckout2 = By.xpath("//*[@id='center_column']/p[2]/a[1]");
	private By addressCity = By.xpath("//li[contains(@class, 'address_city')]");
	private By proceedToCheckout3 = By.name("processAddress");
	private By termsOfService = By.id("uniform-cgv");
	private By proceedToCheckout4 = By.name("processCarrier");
	private By bankWire = By.className("bankwire");
	private By iConfirmMyOrder = By.xpath("//button[contains(@class, 'button-medium')]//span[contains(text(), 'I confirm my order')]");
	private By orderConfirmation = By.xpath("//h1[contains(text(), 'Order confirmation')]");
	
	public Selectors(WebDriver driver) {
		this.driver = driver;
	}
	
	/** load Chrome web driver **/
	public WebDriver loadDriver() {
//		System.out.println("Working Directory is " + System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver_win32_88.0.4324.96\\chromedriver.exe");
		System.out.println("Web driver is loaded");
		return driver = new ChromeDriver();
	}
	
	/** open page and maximize it **/
	public void openPage() {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		System.out.println("Page is opened and maximized");
	}
	
	/** click on the BEST SELLERS tab **/
	public void bestSellers() {
		
		// validate that home page is displayed and BEST SELLERS tab is displayed
		Assert.assertTrue(driver.findElement(bestSellersTab).isDisplayed());
		
		// click on the BEST SELLERS tab
		if (driver.findElement(bestSellersTab).isDisplayed()) {
			System.out.println("BEST SELLERS tab is displayed");
			driver.findElement(bestSellersTab).click();
		}
	}
	
	/** click on the third item in the BEST SELLERS tab **/
	public void thirdItem() {
		
		// validate that the third item is displayed in the BEST SELLERS tab
		Assert.assertTrue(driver.findElement(thirdItem).isDisplayed());
		
		// click on the third item in the BEST SELLERS tab
		if (driver.findElement(thirdItem).isDisplayed()) {
			System.out.println("Third item in the BEST SELLERS tab has been displayed");
			driver.findElement(thirdItem).click();
		}
	}
	
	/** select L from the Size select **/
	public void selectSize() {
//		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(selectSize));

		driver.findElement(selectSize).click();
		Select size = new Select(driver.findElement(selectSize));
		size.selectByVisibleText("L");
	}
	
	/** select white color from the palette **/
	public void selectColor() {
		driver.findElement(whiteColor).click();
	}
	
	/** click on the Add to cart button **/
	public void addToCart() {
		driver.findElement(addToCartButton).click();
	}
	
	/** modal window with order data **/
	public void modalIsDisplayed() {
		// validate that modal is displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(modalCheckout));
		Assert.assertTrue(driver.findElement(modalCheckout).isDisplayed());
		// click on the Proceed to checkout button
		if (driver.findElement(modalCheckout).isDisplayed()) {
			System.out.println("Modal with order data has been displayed");
			driver.findElement(proceedToCheckout).click();
		}
	}
	
	/** increase amount and check price changes **/
	public void increaseAmount() throws InterruptedException {
		// validate that shopping cart summary is displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(amountIncrease));
		Assert.assertTrue(driver.findElement(amountIncrease).isDisplayed());
		// increase amount
		if (driver.findElement(amountIncrease).isDisplayed()) {
			System.out.println("Shopping cart summary has been displayed");
			WebElement total = driver.findElement(totalProducts);
			// get price from the Total products section
			int price = Integer.parseInt(total.getText().substring(1).split("\\.", 2)[0]);
			// increase amount to 4 by clicking + button in the Qty column and check if total price is correct
			for (int i=1; i<4; i++) {
				driver.findElement(amountIncrease).click();
				Thread.sleep(2000);
//				WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSeconds);
//				wait1.until(ExpectedConditions.visibilityOfElementLocated(totalProducts));
				WebElement totalnew = driver.findElement(totalProducts);
				int pricenew = Integer.parseInt(totalnew.getText().substring(1).split("\\.", 2)[0]);
//				System.out.println(price);
//				System.out.println(pricenew);
				int j = i + 1;
				Assert.assertEquals(pricenew, price * j);
				System.out.println("New Total price " + pricenew + " is correct");
			}
			
		}
		
	}
	
	/** click on the Proceed to checkout button in the 01. Summary section **/
	public void proceedToCheckout2() {
		driver.findElement(proceedToCheckout2).click();
	}
	
	/** login with temp email and password **/
	public void login() {
		
		// validate that Sign in section is displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		Assert.assertTrue(driver.findElement(email).isDisplayed());
		
		if (driver.findElement(email).isDisplayed()) {
			System.out.println("Sign in section has been displayed");
			
			// enter email
			driver.findElement(email).sendKeys("doxecav187@hancack.com");
			
			// enter password
			driver.findElement(password).sendKeys("Bc231");
			
			// validate that email format is ok
			By oksign = By.xpath("//div[contains(@class, 'form-ok')]");
			Assert.assertTrue(driver.findElement(oksign).isDisplayed());
			
			// submit credentials
			driver.findElement(submitButton).click();
		}
	}
	
	/** city in address **/
	public void cityInAddress() {
		// validate that name of the city element is present
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addressCity));
		Assert.assertTrue(driver.findElement(addressCity).isDisplayed());
		// validate that city name has length more than 0
		if (driver.findElement(addressCity).isDisplayed() == true) {
			System.out.println("Shopping cart has been displayed");
			List<WebElement> city = driver.findElements(addressCity);
			for (WebElement webElement : city) {
	            String name = webElement.getText();
	            Assert.assertTrue(name.length() > 0);
	            System.out.println(name);
	        }
		}
	}
	
	/** click on the Proceed to checkout button in the 03. Address **/
	public void proceedToCheckout3() {
		driver.findElement(proceedToCheckout3).click();
	}
	
	/** Shipping section **/
	public void checkTermsOfService() {
		// validate that Shipping section is displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(termsOfService));
		Assert.assertTrue(driver.findElement(termsOfService).isDisplayed());
		// check Terms of service checkbox
		if (driver.findElement(termsOfService).isDisplayed() == true) {
			System.out.println("Shipping section has been displayed");
			driver.findElement(termsOfService).click();
		}
	}
	
	/** click on the Proceed to checkout button in the 04. Shipping **/
	public void proceedToCheckout4() throws InterruptedException {
		driver.findElement(proceedToCheckout4).click();
	}
	
	/** payment method **/
	public void selectBankWire() {
		// validate that payment method section is displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(bankWire));
		Assert.assertTrue(driver.findElement(bankWire).isDisplayed());
		// click on the link with Pay by bank wire text
		if (driver.findElement(bankWire).isDisplayed() == true) {
			System.out.println("Payment section has been displayed");
			driver.findElement(bankWire).click();
		}
	}
	
	/** confirm order **/
	public void confirmOrder() {
		// validate that ORDER SUMMARY section has been displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(iConfirmMyOrder));
		Assert.assertTrue(driver.findElement(iConfirmMyOrder).isDisplayed());
		// click on the I confirm my order button
		if (driver.findElement(iConfirmMyOrder).isDisplayed() == true) {
			System.out.println("Confirm order section has been displayed");
			driver.findElement(iConfirmMyOrder).click();
		}
	}
	
	/** order is completed **/
	public void orderConfirmation() {
		// validate that ORDER CONFIRMATION section has been displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation));
		Assert.assertTrue(driver.findElement(orderConfirmation).isDisplayed());
		if (driver.findElement(orderConfirmation).isDisplayed() == true) {
			System.out.println("Order confirmation section has been displayed");
		}
	}

}
