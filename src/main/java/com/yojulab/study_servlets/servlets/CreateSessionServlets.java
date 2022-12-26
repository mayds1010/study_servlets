package com.yojulab.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createServlets?username=yojulab&password=1234
@WebServlet(urlPatterns="/session/createServlets")
public class CreateSessionServlets extends HttpServlet{ //로그인때 사용
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //로그인값 받기
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>Create Session Servlets</div>");
        // login되는 상태 
        if(username.equals("yojulab") && password.equals("1234")){ //디버깅시 "yojulab".equals(username),상수를 앞으로
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
            printWriter.println("<div>"+username+", "+password+"</div>");
        } else {
            printWriter.println("<div>Faild</div>");
        }
        printWriter.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
