<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Raise The Bar </title>
    <meta name="description" content="Raise The Bar ">
    <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:400,300|Raleway:300,400,900,700italic,700,300,600">
    <link rel="stylesheet" type="text/css" href="../css/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/animate.css">
    <link rel="stylesheet" type="text/css" href="../css/style.rest.css">
    <!-- =======================================================
        Theme Name: Baker
        Theme URL: https://bootstrapmade.com/baker-free-onepage-bootstrap-theme/
        Author: BootstrapMade.com
        Author URL: https://bootstrapmade.com
    ======================================================= -->
  </head>
  <body>

    <div class="loader"></div>
    <div id="myDiv">
    <!--HEADER-->
    <div class="header">
        <header id="main-header">
        <nav class="navbar navbar-default navbar-fixed-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Raise The <span class="logo-dec">Bar</span></a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
              <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="/home">Home</a></li>

                <!--<li class=""><a href="#feature">About</a></li>
                <li class=""><a href="#service">Services</a></li>
                <li class=""><a href="#portfolio">Portfolio</a></li>
                <li class=""><a href="#testimonial">Testimonial</a></li>
                <li class=""><a href="#blog">Blog</a></li>
                <li class=""><a href="#contact">Contact Us</a></li>-->

                   <c:if test="${empty ownerDetail}">
                      <li><a href="index.html#contact" >Login ${ownerDetail.emailId}</a></li>
                   </c:if>
                   <c:if test="${not empty ownerDetail}">
                      <li class=""><a href="/logout">Logout</a></li>
                   </c:if>
              </ul>
            </div>
          </div>
        </nav>
        </header>

    </div>
    <!--/ HEADER-->
    <!---->
    <!---->



    <section id="blog" class=" wow fadeInCus delay-05s">

        <div class="navbar navbar-inverse navbar-fixed-left">
          <a class="navbar-brand" href="/home">Home</a>
          <ul class="nav navbar-nav">
           <li><a href="#" onclick="return showMenu();">Menu</a></li>
           <li><a href="#" onclick="return showSpecial();">Special</a></li>
          </ul>
        </div>



      <div class="section-padding">
        <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
               <div class="col-md-12 col-sm-6 col-xs-12">

                         <div class="col-md-3">
                              <a href="#" class="btn btn-more-free" data-toggle="modal" data-target="#editModal"> Edit Bar information </a>
                          </div>

                          <div class="col-md-6">
                          <h2 class="service-title"> ${singleBarDetails.name} </h2>
                          </div>

                         <div class="col-md-3">
                            <a href="#" class="btn btn-more" data-toggle="modal" data-target="#editBarTimingModal"> Edit Bar Timing </a>
                         </div>

               </div>
          </div>
              <jsp:include page="editBar.jsp" />
              <jsp:include page="menu.jsp" />
              <jsp:include page="editBarTiming.jsp" />
              <jsp:include page="special.jsp" />
        </div>
      </div>
      </div>
                  <hr class="bottom-line">
    </section>



    <!---->
    <!---->
    <footer id="footer">
      <div class="container">
        <div class="row text-center">
          <p>&copy; Baker Theme. All Rights Reserved.</p>
          <div class="credits">
            <!-- 
                All the links in the footer should remain intact. 
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Baker
            -->
            Designed  by <a href="https://bootstrapmade.com/">Bootstrap Themes</a>
        </div>
        </div>
      </div>
    </footer>
    <!---->
  </div>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/jquery.easing.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/wow.js"></script>
    <script src="../js/jquery.bxslider.min.js"></script>
    <script src="../js/custom.js"></script>
    <script src="../js/extra.js"></script>
    <script src="contactform/contactform.js"></script>
    
  </body>
</html>