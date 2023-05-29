package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	PageObjectManager pom=new PageObjectManager();

	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		enterAppInurl(getPropertyFileValue("url"));
		maximizewindow();
		
    }
	@After
	public void afterScenario(Scenario senario) {
	
		boolean b = senario.isFailed();
	if (!b) {
		
		senario.attach(screenShot(), "image/png", "adactin Scenario");
		
	}
		
		closeallwindow();		
	

}}
