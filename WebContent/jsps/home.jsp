<%@page import="com.dbutil.CurrentUser"%>
<%@page import="com.pojo.Studentpojo"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function save(){
	alert("save");
	document.getElementById("formid").action="saveservlet";
	document.getElementById("formid").submit();
}

function getallstud(){
	alert("getall");
	document.getElementById("formid").action="getallservlet";
	document.getElementById("formid").submit();
}

function getstud(){
	alert("get");
	document.getElementById("formid").action="getservlet";
	document.getElementById("formid").submit();
}

function deletestud(){
	alert("deleting records");
	document.getElementById("formid").action="deleteservlet";
	document.getElementById("formid").submit();
}
function update(){
	alert("update");
	document.getElementById("formid").action="updateservlet";
	document.getElementById("formid").submit();
}

</script>
</head>
<body>
<b font color="red">${error}</b>
<%
String user=(String)session.getAttribute("user");
Integer count=(Integer)application.getAttribute("count");
if(user!=null){
	out.print(user+"["+count+"]");
}
%>

<h2>Welcome to home page</h2>
<a href="data">GetData</a>
${error }
<form id="formid" >
<fieldset>
<legend>StudentDetails</legend>
<input type="hidden" name="stno" value="${student.stno}">
enter Stno::<input type="text" name="stno" value="${student.stno}"><br>
StName::<input type="text" name="stname" value="${student.stname}"><br>
Marks::<input type="text" name="marks" value="${student.marks}"><br>
<input  type="button" value="save" onclick="save()"></input>
<input  type="button" value="update" onclick="update()"></input>
<input  type="button" value="delete" onclick="deletestud()"></input>
<a:if test="${userdetails.role=='ADMIN'}">
<input  type="button" value="getall" onclick="getallstud()"></input>
</a:if>
<%-- <c:if test="${userdetails.role=='ADMIN'}"><input type="button" value="getAll" onclick="getAll()"></c:if> --%>
<input  type="button" value="get" onclick="getstud()"></input>
</fieldset>
</form>

 <%
         Studentpojo std=(Studentpojo)request.getAttribute("student");
         if(std!=null){
         out.print("stno::"+std.getStno()+"stname::"+std.getStname()+"marks::"+std.getMarks());
         }
      %>
<%
List<Studentpojo> student=(List<Studentpojo>)request.getAttribute("studentsList");
        if(student==null){
        	%>
          <table border="2">
                <tr>
                   <th><a href="getallservlet?sort=stno">Stno</a></th>
                   <th><a href="getallservlet?sort=stname">Stname</a></th>
                   <th><a href="getallservlet?sort=marks">Marks</a></th>
                </tr>
                <a:forEach items="${studentsList}" var="stdlist">
                <tr>
                   <td>${stdlist.stno}</td>
                   <td><a href="getservlet?stno=${stdlist.stno}">${stdlist.stname}</a></td>
                   <td>${stdlist.marks}</td>
                </tr>
                </a:forEach>
                <%-- <%
                   for(StudentPojo stds:student){
                %>
                  <tr>
                    <td><%=stds.getId() %></td>
                    <td><%=stds.getName() %></td>
                    <td><%=stds.getQual() %></td>
                  </tr>
               <% 
                }
               %> --%>
          </table>
     <%
        }
     %>

<h2>List of users</h2>
<ol>
<a:forEach items="<%=CurrentUser.getAllCurrentUsers()%>" var="user">
<li>${user}</li>
</a:forEach>
</ol>
</body>
</html>