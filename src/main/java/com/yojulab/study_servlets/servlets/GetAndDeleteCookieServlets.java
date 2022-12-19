package com.yojulab.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/cookies/getAndDeleteServlets")
public class GetAndDeleteCookieServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>Get and Delete Cookie Servlets</div>");

        // get Cookie
        Cookie cookies[] = request.getCookies();//한번에 다 뭉쳐서 오기때문에 ArrayList
        for(Cookie cookie : cookies) { //ArrayList여서 반복
            String name = cookie.getName(); //값들 가져오기
            String value = cookie.getValue();
            printWriter.println("<div>Cookie Name : "+name+", value : "+value+" </div>");

            // delete cookie
            if(name.equals("secondName")){
                cookie.setMaxAge(0);//maxAge를 통해서 브라우저의 설정에 따라 일정 기간 동안 Cookie저장
                response.addCookie(cookie);//보내기
            }

        }

        printWriter.close();
    }
}