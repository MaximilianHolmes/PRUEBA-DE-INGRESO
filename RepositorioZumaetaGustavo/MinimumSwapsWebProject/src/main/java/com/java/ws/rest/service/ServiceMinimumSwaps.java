package com.java.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.ws.rest.vo.VOMinimumSwaps;

@Path("/ServiceMinimumSwaps")
public class ServiceMinimumSwaps {

	@POST
	@Path("/minimumSwaps")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOMinimumSwaps minimumSwaps(VOMinimumSwaps objSwaps) {
		
		int[] arrayEnterosConsecutivos = objSwaps.getArrayEnteros();
		int numeroIntercambios = 0;
		int menor = arrayEnterosConsecutivos[0];
		int indiceMenor = 0;
		for(int i=1;i<arrayEnterosConsecutivos.length;i++) {
			if(menor>arrayEnterosConsecutivos[i]) {
				menor=arrayEnterosConsecutivos[i];
				indiceMenor=i;
			}
		}
		if(indiceMenor>0) {
			//El primer intercambio
			arrayEnterosConsecutivos[indiceMenor]=arrayEnterosConsecutivos[0];
			arrayEnterosConsecutivos[0]=menor;
			indiceMenor=0;
			numeroIntercambios=1;
		}
		
		for(int j=1;j<arrayEnterosConsecutivos.length-1;j++) {
			
			for(int i=j;i<arrayEnterosConsecutivos.length;i++) {
				if(arrayEnterosConsecutivos[i] == menor+j) {
					if(i!=j) {
						//Otros intercambios
						arrayEnterosConsecutivos[i]=arrayEnterosConsecutivos[j];
						arrayEnterosConsecutivos[j]=menor+j;
						numeroIntercambios++;						
					}
				}
			}
			
		}	
		
		objSwaps.setNumeroIntercambios(numeroIntercambios);
		return objSwaps;
	}

	
}
