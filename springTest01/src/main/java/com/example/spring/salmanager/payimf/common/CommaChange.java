package com.example.spring.salmanager.payimf.common;

public class CommaChange {

	public String comma( String str ) {
		
		 int result = Integer.parseInt( str );
         str = new java.text.DecimalFormat("#,###").format(result).toString();
		
		return str;
	}
	
	public String unComma( String str ) {
		
		
		
		return str;
	}

	
}
