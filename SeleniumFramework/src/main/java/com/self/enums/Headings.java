package com.self.enums;

public enum Headings {
	PERSONALDETAILS("Pesronal Details");

	private String headings;

	Headings(String headings) {
	    this.headings = headings;
	}

	public String getItem() {
		return headings;
	}

	public static String getValue(String heading) {
		if (heading == null || heading.isEmpty()) {
	        return null;
	    }
		LeftMenuItems pageHeading= LeftMenuItems.valueOf(heading);
		return pageHeading.getItem();
		
	}
		
	}


