package com.yojulab.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = " /poll/PollServlet")
public class DetailServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //input type
       String questions_Uid =  request.getParameter("QUESTIONS_UID"); //밖에서 가져올때
       
      //biz with DB and class
      
       //output with html
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter printWriter = response.getWriter();
       printWriter.close();
    }
}
