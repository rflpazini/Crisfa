<%-- 
    Document   : create
    Created on : 22/01/2015, 17:02:02
    Author     : rflpazini
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List, com.crisfa.dao.ProfessionDAO, com.crisfa.model.Profession"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-Br" class="bg-change">
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="Rafael Pazini"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="assets/img/favicon.ico" type="image/x-icon">

        <title>Create Account - CRISFA</title>

        <!--[if lt IE 9]><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
        <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

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
            <h1 class="center">Criar conta</h1>
            <div class="forms center">
                <form method="POST" class="col-md-4 col-md-offset-4" id="form-login"  action="UserController">
                    <div class="form-group col-md-6" id="name-add">
                        <label for="inputName">Nome</label>
                        <input type="text" class="form-control" id="inputName" name="first-name" required>
                    </div>
                    <div class="form-group col-md-6" id="last-name-add">
                        <label for="inputLastName">Sobrenome</label>
                        <input type="text" class="form-control" id="inputLastName" name="last-name" required>
                    </div>
                    <div class="form-group">
                        <label for="inputProf">Profissão</label>
                        <select name="professions" class="form-control" required>
                            <option>Selecione uma profissão</option>
                            <%
                                ProfessionDAO pDao = new ProfessionDAO();
                                List<Profession> professions = pDao.getProfessions();
                                for (Profession profession : professions) {
                                    out.println("<option value='" + profession.getIdProfession() + "'>" + profession.getDescProfession() + "</option>");
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group" id="last-name-add">
                        <label for="inputBDay">Data de nascimento</label>
                        <input type="text" class="form-control" id="inputBDay" name="data" oninput="maskData(this)" maxlength="10" required>
                    </div>
                    <div class="form-group" >
                        <label for="exampleInputEmail1">Endereço de e-mail</label>
                        <input type="email" class="form-control" id="InputEmail" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail1">Senha</label>
                        <input type="password" class="form-control" id="inputPassword" name="pass">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword2">Confirme sua senha</label>
                        <input type="password" class="form-control no-paste" id="validadePassword" name="valPass" oninput="passwordValidade(this)">
                    </div>
                    <button type="submit" value="Submit" class="btn btn-primary btn-lg btn-total">Criar</button>
                    <label class="pull-right">
                        <a href="#">Precisa de ajuda?</a>
                    </label>
                </form>
            </div>
        </div>
        <footer>
            <div id="line-header"></div>
        </footer>

        <!-- JS -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.js"></script>
        <script type="text/javascript" src="assets/js/custom.js"></script>
    </body>
</html>