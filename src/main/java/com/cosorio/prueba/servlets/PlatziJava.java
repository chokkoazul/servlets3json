package com.cosorio.prueba.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/platzijava")
public class PlatziJava extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = req.getParameter("message");
		resp.setContentType("application/json");
		
		try(PrintWriter out = resp.getWriter()){
		out.print("{\"message\": \""+ message + "\"}");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String line;
		StringBuffer json = new StringBuffer();
		try(BufferedReader reader = req.getReader()){
			while((line = reader.readLine())!=null ){
				json.append(line);
			}
		}
		
		System.out.println(json.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		
		Message message = mapper.readValue(json.toString(), Message.class);
		
		System.out.println("message size:"+ message.getSize());
		
		System.out.println("message en objeto:"+ message.getMessage());
		System.out.println("filter:"+ req.getAttribute("segundoEstado"));
		
			
		
	}

	
	
	
}
