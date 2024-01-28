package com.self.enums;

public enum TopMenuItems {
USERMANAGEMENT("User Management"),
JOB("Job"),
ORGANIZATION("Organization"),
QUALIFICATIONS("Qualifications"),
NATIONALITIES("Nationalities"),
CORPORATEBRANDING("Corporate Branding"),
CONFIGURATION("Configuration");
	
private String topMenuItem;

TopMenuItems(String topMenuItem ){
	this.topMenuItem= topMenuItem;
}

public String getItem() {
	return topMenuItem;
}

public static String getValue(String itemName) {
	
	if(itemName==null || itemName.isEmpty()) {
		return null;
	}
	TopMenuItems menuItem = TopMenuItems.valueOf(itemName);
	return menuItem.getItem();
	
}


}
