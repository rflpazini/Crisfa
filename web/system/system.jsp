<%-- 
    Document   : system
    Created on : 28/01/2015, 11:13:07
    Author     : rflpazini
--%>

<%@page import="com.crisfa.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!private User user = null;%>
<!DOCTYPE html>
<html lang="pt-Br">

    <head>
        <meta charset="UTF-8">
        <meta name="author" content="Rafael Pazini"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="../assets/img/favicon.ico" type="image/x-icon">

        <title>System - CRISFA</title>

        <!-- Css -->
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/style.css">

        <!-- Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
    </head>

    <body>
        <nav class="navbar navbar-default navbar-fixed-top no-select">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img src="../assets/img/logo_40.png" alt=""> Crisfa <span>Console</span>
                    </a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <!--<li><a href="#">Link</a>
                        </li>-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                <% 
                                    this.user = (User) session.getAttribute("Usuario");
                                    out.println(this.user.getNome());
                                %>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Sair</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
        <section class="left-menu">
            <div class="nav">
                <ul>
                    <li><span class="glyphicon glyphicon-knight orange-ico" aria-hidden="true"></span><a href="">Todas as atividades</a></li>
                    <li><span class="glyphicon glyphicon-plus orange-ico" aria-hidden="true"></span><a href="">Adicionar atividade</a>
                    </li>
                    <li><span class="glyphicon glyphicon-tasks orange-ico" aria-hidden="true"></span><a href="">Meu desempenho</a>
                    </li>
                    <li><span class="glyphicon glyphicon-cog" aria-hidden="true"></span><a href="" data-toggle="modal" data-target="#myModal">Configuração</a>
                    </li>
                </ul>
            </div>
        </section>

        <section class="all-things">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <figure class="col-background">
                            <img src="../assets/img/banner.jpg" alt="banner"/>
                            <h1 class="normal light">Teste</h1>
                            <div class="ball">
                                <img src="../assets/img/ic_done_all_black_36dp.png" alt="ic_done_all_black_48dp"/>
                            </div>
                            <figcaption>
                               <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus labore repellat voluptates</p> 
                            </figcaption>
                        </figure>
                    </div>
                    <div class="col-md-3">
                        <figure class="col-background">
                            <img src="../assets/img/banner.jpg" alt="banner"/>
                            <h1 class="normal light">Teste</h1>
                            <div class="ball">
                                <img src="../assets/img/ic_done_all_black_36dp.png" alt="ic_done_all_black_48dp"/>
                            </div>
                            <figcaption>
                               <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus labore repellat voluptates</p> 
                            </figcaption>
                        </figure>
                    </div>
                    <div class="col-md-3">
                        <figure class="col-background">
                            <img class="center" src="../assets/img/banner.jpg" alt="banner"/>
                            <h1 class="normal light">Teste</h1>
                            <div class="ball">
                                <img src="../assets/img/ic_done_all_black_36dp.png" alt="ic_done_all_black_48dp"/>
                            </div>
                            <figcaption>
                               <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus labore repellat voluptates</p> 
                            </figcaption>
                        </figure>
                    </div>
                </div>
            </div>
        </section>

        <section class="config-modal">
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title center" id="myModalLabel">Configurações</h4>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                            <button type="button" class="btn btn-primary">Salvar</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <footer>
            <div id="line-header"></div>
        </footer>

        <!-- JS -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.js"></script>
    </body>

</html>
