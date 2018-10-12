package com.ideas;

import static org.junit.Assert.*;

import org.eclipse.jetty.testing.ServletTester;
import org.eclipse.jetty.testing.HttpTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyServletTest {
	ServletTester servletTester;
	@Before
	public void setup() throws Exception{
		servletTester =  new ServletTester();
		servletTester.setContextPath("/WelcomeServlet");
		servletTester.addServlet(WelcomeServlet.class, "/");
		servletTester.start();
	}	
	
	@Test
	public void shouldGetTheRequestFromtServlet() throws Exception {
		HttpTester request = new HttpTester();
		request.setMethod("GET");
		request.setHeader("Host","127.0.0.1");
		request.setURI("/WelcomeServlet/welcome1");
		request.setVersion("HTTP/1.0");
	
		HttpTester response = new HttpTester();
		response.parse(servletTester.getResponses(request.generate()));
		
		assertNull(response.getMethod());
		assertEquals(200,response.getStatus());
	}
	@Test
	public void shouldPostTheRequestFromtServlet() throws Exception {
		HttpTester request = new HttpTester();
		request.setMethod("POST");
		request.setHeader("Host","127.0.0.1");
		request.setURI("/WelcomeServlet/welcome1");
		request.setVersion("HTTP/1.0");
	
		
		request.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		request.setContent("name=1&address=1");
		
		HttpTester response = new HttpTester();
		response.parse(servletTester.getResponses(request.generate()));
		
		assertNull(response.getMethod());
		assertEquals(200,response.getStatus());
	}
	@After
	public void tearDown() throws Exception{
		servletTester.stop();
	}
		
	
	
}
