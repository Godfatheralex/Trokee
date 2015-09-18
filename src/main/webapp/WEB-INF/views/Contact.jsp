<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta charset=utf-8 />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#blah')
                        .attr('src', e.target.result)
                        .width(150)
                        .height(150);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }
</script>

<title>New/Edit Contact</title>
</head>
<body onload="chargement()">

	<div align="center">
		<h1>Nouveau / Modification Usager</h1>
		<form:form action="saveContact" method="post" modelAttribute="contact">
		<table>
			<form:hidden path=""/>
			<tr>
				<td>Prenom:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Nom:</td>
				<td><form:input path="email" /></td>
			</tr>
			
			<tr>
				<td>Photo:</td>
				<td>
				
				<img id="blah"  src=${contact.photo} alt="Aucune image disponible" style="width:200px" class="image-responsive"/><br /> 
				
				<form method="POST" enctype="multipart/form-data" action="/upload"> File to upload: 				
				<form:input path="photo" id="choix" type="file" onchange="readURL(this);" />
			
				</form>
				
				<INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;">
				
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>