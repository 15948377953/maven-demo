<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="../css/style.css">
    </head>

    <body>
        <form action="login.do">
            <div class="login-form">
                <h1>Vini</h1>
                <div class="form-group ">
                    <input type="text" class="form-control" placeholder="Username " id="UserName">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group log-status">
                    <input type="password" class="form-control" placeholder="Password" id="Passwod">
                    <i class="fa fa-lock"></i>
                </div>
                <span class="alert">Invalid Credentials</span>
                <a class="link" href="#">Lost your password?</a>
                <button type="button" class="log-btn" >Log in</button>
            </div>
        </form>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script  src="../js"></script>
    </body>
</html>

