package com.self.enums;

public enum TopSubMenuItems {
JOBTITLES("Job Titles"),
JOBTITLESHEADING("Add Job Title"),
PAYGRADES("Pay Grades"),
ADDPAYGRADES("Add Pay Grade"),
CURRENCIES("Currencies"),
ADDCURRENCY("Add Currency"),
EMPLOYMENTSTATUS("Employment Status"),
ADDEMPLOYMENTSTATUS("Add Employment Status"),
JOBCATEGORIES("Job Categories"),
ADDJOBCATEGORY("Add Job Category"),
WORKSHIFTS("Work Shifts"),
GENERALINFORMATION("General Information"),
EMPLOYEELIST("Employee List"),
ADDEMPLOYEE("Add Employee");


private String topSubMenuItems;

TopSubMenuItems(String topSubMenuItems){
	this.topSubMenuItems=topSubMenuItems;
}

public String getItem() {
	return topSubMenuItems;
}

public static String getValue(String subItemName) {
	
	if(subItemName == null || subItemName.isEmpty()) {
		return null;
	}
	TopSubMenuItems subMenuItem = TopSubMenuItems.valueOf(subItemName);
	return subMenuItem.getItem();
	
	
}



}
