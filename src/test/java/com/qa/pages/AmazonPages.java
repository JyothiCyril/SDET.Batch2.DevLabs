package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {

	// Create the reference variable to store the test object description
	// Define the set of methods that can perform the user actions
	// to redefine the scope of class member within this , create a constructor that can load the elements at the time of execution

	WebDriver driver;
	
	
	@FindBy(linkText="Careers")
	WebElement CareersLink;
	
	public WebElement getCareersLink() {
		return CareersLink;
	}
	
	@FindBy(id="nav-logo-sprites")
	WebElement amazonLogo;
	
	public WebElement getamazonLogo() {
		return amazonLogo;
	}
	
	@FindBy(linkText="Start here.")
	WebElement regLink;
	
	public WebElement getregLink() {
		return regLink;
	}
	
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement AccountsandLists;
	
	public WebElement getAccountsandLists() {
		return AccountsandLists;
	}

	@FindBy(id="searchDropdownBox")
	WebElement Category;


	@FindBy(css="#twotabsearchtextbox")
	WebElement SearchTextBox;


	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement MagnifierBtn;
	
	
	@FindAll(@FindBy(xpath="//*[@class='nav_a']"))
	List<WebElement> FooterLinks;
	
	
	@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
	List<WebElement> ItemNames;

	// select a value
	public void setCategoryInput(String input) {
		Select sel = new Select(Category);		
		sel.selectByVisibleText(input);
	}

	// type a value

	public void setSearchTextBoxInput(String input) {
		SearchTextBox.clear();
		SearchTextBox.sendKeys(input);
	}


	// click the button

	public void setMagnifierBtnClick() {
		MagnifierBtn.click();
	}

	
	public List<WebElement> getItemNames(){
		return ItemNames;
	}
	
	public List<WebElement> getFooterLinks() {
		return FooterLinks;
	}
	
	public AmazonPages(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}


}
