<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Student</h1> <br>
${msg }

<table>
<tr>
<td>
Name
</td>

<td>
${student.name}
</td>
</tr>
<tr>
<td>
password
</td>

<td>
${student.password}
</td>
</tr>
<tr>
<td>
Mobile no
</td>

<td>
${student.mobileNo}
</td>
</tr>
<tr>
<td>
DOB
</td>

<td>
${student.dob}
</td>
</tr>

<tr>
<td>
Skills
</td>

<td>
${student.skills}
</td>
</tr> 


<tr><td>STUDENT DETAILS :</td><td></td></tr>
<tr>
<td>
country,city,street,pincode
</td>

<td>
${student.studentAddress.country} ${student.studentAddress.city}
  ${student.studentAddress.street} ${student.studentAddress.pincode}
</td>
</tr> 

</table>
</body>
</html>