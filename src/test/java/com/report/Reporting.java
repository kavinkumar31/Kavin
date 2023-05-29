package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
	 * @author RAMKUMAR
	 * @see used to get reports
	 * @date 16/feb/23
	 */
	public class Reporting extends BaseClass {
		/**
		 * @see used to generatejvmreport
		 * @param jsonFile
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
			
			File file=new File(getProjectPath()+getPropertyFileValue("jvmpath"));

		Configuration con=new Configuration(file,"Adactin Automation");
		
		con.addClassifications("browser", "chrome");
		con.addClassifications("browser rersion", "102");
		con.addClassifications("os", "WIN11");
		con.addClassifications("sprint", "34");
		con.addClassifications("testing", "reg");
		
		
		List<String>jsonFiles=new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder=new ReportBuilder(jsonFiles,con);
		
		builder.generateReports();
		
		}
	}

