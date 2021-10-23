package com.formacionbdi.springboot.app.productos.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MatrizController {
	
	
	@PostMapping("/matriz-cuadrada")
	public ResponseEntity<?>  arreglo(@RequestBody  HashMap<String,int[][]> matrizRequest){
		
		Map<String,Object> response= new HashMap<>();
		
		Object matrizresponse=matrizRequest;
		
		HashMap<String,int[][]> map=new HashMap<String,int[][]>();
		HashMap<String,int[][]> map2=new HashMap<String,int[][]>();
		
		//map.put("matrizResponse", matrisRequest.get("matrisRequest"));
		
		try {
			Object obj=null;
			
			int[][] matriz =  matrizRequest.get("matrizRequest");
			int tamanio = matriz.length;
			int[][] nuevamatriz = new int[tamanio][tamanio];
			
			for (int x=0;x<tamanio;x++) {
				  for (int y=0;y<tamanio;y++) {
					  nuevamatriz[tamanio-1-y][x] = matriz[x][y];
				  }
			}
			response.put("matrizResponse", nuevamatriz);
			response.put("message", "Matris Rotada en sentido antihorario");
			
			
			return   new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			
		} catch (Exception e) {
			response.put("error", e.getMessage());
			response.put("message", "Error compruebe los datos");
			
			return  new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
	};
}
