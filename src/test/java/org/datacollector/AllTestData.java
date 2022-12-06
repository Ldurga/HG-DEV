package org.datacollector;

import org.testng.annotations.DataProvider;

public class AllTestData {
	
	
	@DataProvider(name="invalid")
	public Object[][] invalidLogin() {
		return new Object[][] {
			
			{"demo_user","demo_password"},
			
		};
	}

	@DataProvider(name="valid")
	public Object[][] valid(){
		return new Object[][] {
			{"admin","admin"}
		};
	}
	
	
}
