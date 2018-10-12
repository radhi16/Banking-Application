package com.ideas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(name = "WelcomeServlet", urlPatterns = { "/welcome1" })

public class WelcomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WelcomeServlet doGet");
		// String test=req.getParameter("accountId");
		// String test1=req.getParameter("test");
		int id = Integer.parseInt(req.getParameter("accountId"));

		System.out.println(id);

		BankingService bankingService = new BankingService();
	
		List<Account> list = (List) bankingService.getAccountById(id);
		System.out.println(id);
		// AccountVO acc = list.get(0);
		Gson gson = new Gson();
		String jsonString = gson.toJson(list.get(0));
		System.out.println("Servlet json" + jsonString);
		PrintWriter writer = resp.getWriter();
		writer.write(jsonString);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WelcomeServlet doPost");
		resp.setContentType("text/html"); /*Content Type is also known as MIME (Multipurpose internet Mail Extension) Type. 
                                           It is a HTTP header that provides the description about what are you sending to the browser*/
		BankingService bankingService = new BankingService();
		
		 if (req.getParameter("from").equals("createtable")) {
		String name = req.getParameter("name");
		String address = req.getParameter("addres");
		String date = req.getParameter("date");
		String panNo = req.getParameter("panNo");
		String mobNo = req.getParameter("mobNo");
		String accountType = req.getParameter("accountType");

		
		Account account = new Account(0,name, address, date, panNo, mobNo, accountType);
		bankingService.saveAccount(account);
		showAccountTables(bankingService,req,resp);
		 }
		 
		  if (req.getParameter("from").equals("showtable")) {
			  System.out.println("Inside show table..........");
              showAccountTables(bankingService,req,resp);

}

		 
		 if (req.getParameter("from").equals("update")) {
			 String temp=req.getParameter("updateid");
             System.out.println(req.getParameter("updateid"));

             Account account = new Account(0,req.getParameter("updateName"), req.getParameter("updateAddres"),
            		 req.getParameter("updateDate"), req.getParameter("updatePanNo"), 
            		                            req.getParameter("updateMobNo"), req.getParameter("updateAccountType"));
           int upId= Integer.parseInt(temp);
             System.out.println("update id= ");
             bankingService.updateWhenIdGiven(upId, account);

             showAccountTables(bankingService,req,resp);

          }
		
		
		
		 
	}
		 
	
			private void showAccountTables(BankingService bankingService, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 List<Account> list = (List) bankingService.getAll();

         req.setAttribute("list", list);
         RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/AccountList.jsp");
 		dispatcher.forward(req, resp);
		
	}
}

// System.out.println("WelcomeServlet doPost");

/*
 * String name=req.getParameter("name"); req.setAttribute("name",name);
 * RequestDispatcher dispatcher=
 * getServletContext().getRequestDispatcher("/javaserverpages.jsp");
 * dispatcher.forward(req, resp);
 */

// String education=req.getParameter("education");
// String city= req.getParameter("city");
// String[] subjects=req.getParameterValues("subject");
/*
 * for (int i=0;i<5;i++) { String rating[i]=(String) req.getParameter("rating");
 * String remark[i]=req.getParameter("remark");
 * 
 * }
 */

// String date= req.getParameter("joiningdate");
// String experience=req.getParameter("experience");

/*
 * PrintWriter writer = resp.getWriter(); writer.write(name);
 * writer.write(education); writer.write(city);
 * 
 * int length= subjects.length;
 * 
 * for(int i=0;i<length;i++) writer.write(subjects[i]);
 * 
 * writer.write(date); writer.write(experience);
 */
/*
 * for(int i=0;i<5;i++) { writer.write(rating[i]);
 * 
 * }
 */
