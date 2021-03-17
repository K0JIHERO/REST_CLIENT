package com.zaur.spring.rest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        String id = session.getId();
        pw.println("Session Id is : " + id);
    }


}