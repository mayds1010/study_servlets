<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
<% 
    HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question");
%>

    <div> 
        <a href="/polls/PollServlet?QUESTIONS_UID=Q1">Q1</a> / 
        <a href="/polls/PollServlet?QUESTIONS_UID=Q2">Q2</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q3">Q3</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q4">Q4</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q5">Q5</a>
        
         <%-- <% for (int i = 0; i < questionUIDs.size(); i++) { %>
    <% String questionUID = questionUIDs.get(i); %> --%>
    </div>
    <div>
        <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS")%>
    </div>
    <div>
    <%
    ArrayList<HashMap> answer_list = null;
     answer_list = (ArrayList<HashMap>) request.getAttribute("answer_list");
    %>
    <%  
    for(int i = 0; i< answer_list.size(); i++){  
         HashMap<String, Object> answer = answer_list.get(i);
    %>
       <div> (<%= answer.get("ORDERS") %>) <%=  answer.get ("EXAMPLE") %> </div>
     <%-- <div>(2) 아니다 </div>
     <div>(3) 보통이다 </div> --%>
       <% } %>
    </div>
</body>

</html>

<%-- 
<%@ %> = 환경
<%= %> = jsp 표시
<% %> = 나머지 
--%>