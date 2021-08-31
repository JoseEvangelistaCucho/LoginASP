<%-- 
    Document   : index
    Created on : 09-29-2017, 04:49:38 PM
    Author     : VA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="font/css/font-awesome.min.css">
        <link rel='stylesheet prefetch' href='bootstrap/css/bootstrap.min.css'>
        <link rel="stylesheet" href="css/style.css">
        <title>.::Login::.</title>
    </head>
    <body >
        <div class="wrapper">
            <form class="form-signin" action="accesoLogin" method="POST">
                <center><span class="fa fa-user fa-5x"></span></center>
                    <input type="text" class="form-control" name="nombreUsuario" placeholder="Nombre de Usuario" required="" autofocus="" />
                    <input type="password" class="form-control" name="clave" placeholder="Clave" required=""/>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnAcceder">Acceder</button>   
            </form>
        </div>
    </body>
</html>
