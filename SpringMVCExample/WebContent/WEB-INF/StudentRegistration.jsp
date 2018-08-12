<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration.</title>
</head>
<body>
<h2>${headermsg }</h2>
<form:errors path="student.*"/>
<form action="/SpringMVCExample/Register" method="post">

<p>
Name : <input type="text" name="name"><br>
</p>
<p>
Password : <input type="password" name="password" value="Test@123"><br>
</p>
 <p>
Mobile : <input type="text" name="mobileNo"><br>
</p>

<p>
DOB : <input type="text" name="dob" placeholder="yyyy-mm-dd" value="1995--01--13"><br>
</p>
<p>
Skills : <select name="skills" multiple="multiple">
<option value="java">JAVA</option>
<option  value="Spring">Spring</option selected>
<option  value="Angular">Angular</option>
</select><br>
</p> 
<h1>
<input type="submit" value="click to submit"> 
</h1>

<br>
<p>STUDENT ADDRESS</p>
COUNTRY : <input type="text" name="studentAddress.country"><br>
CITY : <input type="text" name="studentAddress.city"><br>
STREET : <input type="text" name="studentAddress.street"><br>
PINCODE : <input type="text" name="studentAddress.pincode"><br>



</form>
</body>
</html>