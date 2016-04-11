package com.cosorio.prueba.rest;

import java.util.ArrayList;
import java.util.List;

import com.cosorio.prueba.servlets.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prueba {

	public static void main(String ... args) throws JsonProcessingException{
		Message me=new Message("Hola mundo");
		ObjectMapper mapper = new ObjectMapper();
		List<Message> list = new ArrayList();
		
		list.add(me);
		list.add(me);
		list.add(me);
		list.add(me);
		list.add(me);
		
		
		
		String jsonInString = mapper.writeValueAsString(list);
		
		System.out.println(jsonInString);
		
	}
	
}
