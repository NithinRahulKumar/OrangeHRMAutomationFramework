package com.self.enums;

public enum LeftMenuItems {
ADMIN("Admin"),
PIM("PIM"),
LEAVE("Leave"),
TIME("Time"),
RECRUITMENT("Recruitment"),
MYINFO("My Info"),
PERFORMANCE("Performance"),
DASHBOARD("Dashboard"),
DIRECTORY("Directory"),
MAINTENANCE("Maintenance"),
CLAIM("Claim"),
BUZZ("Buzz");



private String leftMenuitem;
	
LeftMenuItems(String leftMenuitem) {
    this.leftMenuitem = leftMenuitem;
}

public String getItem() {
	return leftMenuitem;
}

public static String getValue(String itemName) {
	if (itemName == null || itemName.isEmpty()) {
        return null;
    }
	LeftMenuItems menuItem= LeftMenuItems.valueOf(itemName);
	return menuItem.getItem();
	
}
	
}



