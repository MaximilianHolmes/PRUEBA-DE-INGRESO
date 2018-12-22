package com.java.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.ws.rest.vo.VOTwoStrings;

@Path("/ServiceTwoStrings")
public class ServiceTwoStrings {

	@POST
	@Path("/twoStrings")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOTwoStrings twoStrings(VOTwoStrings strings) {
		
		strings.setLetrasEnComun("NO");
		char[] str2Array = strings.getStr2().trim().toUpperCase().toCharArray();
		for(int i=0;i<str2Array.length;i++) {
			if(strings.getStr1().toUpperCase().trim().indexOf(str2Array[i])>=0) {
				strings.setLetrasEnComun("YES");
				break;
			}
		}
		return strings;		
	}
}
