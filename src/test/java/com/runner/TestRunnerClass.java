package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(tags = "", stepNotifications = false, publish = true, monochrome = true, dryRun = false, plugin = {
			"pretty", "json:target/Hello.json" }, features = "src/test/resources/Features", glue = "com.stepdefinition")

	/**
	 * @author RAMKUMAR
	 * @see used to run the project
	 * @date 16/feb/23
	 */
	public class TestRunnerClass extends BaseClass {
		/**
		 * @see used to generatejvmreport
		 * @throws FileNotFoundException
		 * @throws IOException
		 */
		@AfterClass
		public static void afterClass() throws FileNotFoundException, IOException {
			Reporting.generateJvmReport(getProjectPath() + getPropertyFileValue("jsonpath"));

		}

	
}
