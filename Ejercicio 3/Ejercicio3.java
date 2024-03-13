package com.m3.informatica.api.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio3 {
	
	
	private List<String> arrayList;
	
	public Ejercicio3() {
		this.arrayList= new ArrayList<>();
	}
	
	public void comprobarArray() {
		arrayList.add("UNO");
		arrayList.add("dos");
		arrayList.add("Tres");
		arrayList.add("TRES");
		arrayList.add("tres");
		arrayList.add("DoS");
		
		Map<String,Integer> mapa= new HashMap<String, Integer>();
		
		for(String cadena: arrayList) {
			if(mapa.containsKey(cadena.toUpperCase())) {
				mapa.put(cadena.toUpperCase(), mapa.get(cadena.toUpperCase())+1);
			}else {
				mapa.put(cadena.toUpperCase(),1);
			}
			
		}
		for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	

}
