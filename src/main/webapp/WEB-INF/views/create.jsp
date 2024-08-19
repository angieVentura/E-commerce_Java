
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/index" method="post">
	 <table style="width: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Description</td>
     <td><input type="text" name="description" /></td>
    </tr>
    <tr>
     <td>Price</td>
     <td><input type="text" name="price" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
	</form>
</body>
</html>

