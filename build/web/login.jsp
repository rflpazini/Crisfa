<%-- 
    Document   : login
    Created on : 22/01/2015, 15:00:45
    Author     : rflpazini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-Br" class="bg-change">
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="Rafael Pazini"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="assets/img/favicon.ico" type="image/x-icon">
        
        <title>Login - Crisfa</title>

        <!-- Css -->
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
    </head>
    <body class="bg-change">
        <div class="container">
            <div class="lga">
                <img class="center" src="assets/img/logo.png" alt="">
            </div>
            <h1 class="center">Entrar</h1>
            <div class="forms center">
                <form class="col-md-4 col-md-offset-4" id="form-login" method="POST" action="LoginController">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Entre com seu endereço de e-mail</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Senha</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                    <button type="submit" value="Submit" class="btn btn-primary btn-lg btn-total">Entrar</button>
                    <label class="pull-right">
                        <a href="#">Precisa de ajuda?</a>
                    </label>
                </form>
            </div>
        </div>
        <div class="container">
            <div id="create-account" class="center">
                <a href="create.jsp">Criar uma conta</a>
            </div>
        </div>
        <footer>
            <div id="line-header"></div>
        </footer>

        <!-- JS -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    </body>
</html>
