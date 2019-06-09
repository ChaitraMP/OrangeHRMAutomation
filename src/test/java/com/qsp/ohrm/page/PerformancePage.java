package com.qsp.ohrm.page;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;

public class PerformancePage 
{
	WebDriver driver ; 
	@FindBy(id="menu__Performance")
	WebElement performance;
	@FindBy(id="menu_performance_Configure")
	WebElement configure;
	@FindBy(id="menu_performance_searchKpi")
	WebElement kpi;
	@FindBy(id="btnAdd")
	WebElement addbtn;
	@FindBy(xpath="//select[contains(@id, 'defineKpi')]")
	WebElement jobtitledropdown;
	@FindBy(xpath="//input[contains(@id, 'keyPerformanceIndicators')]")
	WebElement kpitbox;
	@FindBy(xpath="//input[contains(@id, 'minRating')]")
	WebElement minrating;
	@FindBy(xpath="//input[contains(@id, 'maxRating')]")
	WebElement maxrating;
	@FindBy(id="saveBtn")
	WebElement savebtn;
	
	Consumer<WebElement> clickconsumer=we->{
		DriverUtils.getVisibleElement(driver, we);
		DriverUtils.getClickableElement(driver, we);
		we.click();
	};
	Consumer<WebElement> mousehover=we->{
		DriverUtils.getVisibleElement(driver, we);
		DriverUtils.moveMouse(we);
	};
	BiConsumer<WebElement, String> sendkeyconsumer=(we, name)->{
		DriverUtils.getVisibleElement(driver, we);
		we.sendKeys(name);
	};
	public void mousehoverPerformance()
	{
		mousehover.accept(performance);
	}
	public void mousehoverConfigure()
	{
		mousehover.accept(configure);
	}
	public void clickKpis()
	{
		clickconsumer.accept(kpi);
	}
	public void setFullName(String Name)
	{
		Log.info("Entering first name");
		//sendkeyconsumer.accept(firstname, Name);
	}
	
	
	
	
	
	

}
