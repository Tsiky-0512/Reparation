<% 
       String user="jean";
       String mdp="1111";
       String paramu=request.getParameter("username");
       String paramc=request.getParameter("password");
       if(paramu!=null && paramc!=null){
           if(paramu.compareTo(user)==0 && paramc.compareTo(mdp)==0 ){
            response.sendRedirect("repa");
            }
           else{
               response.sendRedirect("index.jsp");
           }
       }      
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
             "http://www.w3.org/TR/html4/loose.dtd">
<a href="../../../../ITU S3/Webapps(Tomcat)/MobileMoney/traitementlogin.jsp"></a>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="Bootstrap/bootstrap-4.3-2.1-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="Bootstrap/bootstrap-4.3-2.1-dist/css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="Login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reparation</title>
</head>
<html>
	<body>
		<div class="container">
			<h1>LOG IN</h1>
				<form action="index.jsp" method="POST">
					<div class="tbox">
						<input type="text"  placeholder="@user" name="username" required>
					</div>
					<div class="tbox">
						<input type="password" placeholder="password" name="password" required>
					</div>
						<input type="submit" id='submit' value='Se Connecter'>	
				</form>
		</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

	</body>

</html>
