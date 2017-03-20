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
    <link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/style.rest.css">
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

                <!--
                <li class=""><a href="#feature">About</a></li>
                <li class=""><a href="#service">Services</a></li>
                <li class=""><a href="#portfolio">Portfolio</a></li>
                <li class=""><a href="#testimonial">Testimonial</a></li>
                <li class=""><a href="#blog">Blog</a></li>
                <li class=""><a href="#contact">Contact Us</a></li>
                --!>
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

        <!--<div class="navbar navbar-inverse navbar-fixed-left">
          <a class="navbar-brand" href="#">Brand</a>
          <ul class="nav navbar-nav">
           <li class="dropdown"><a href="/home" > HOME </span></a>
           </li>
          </ul>
        </div>--!>

      <div class="section-padding">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <h2 class="service-title pad-bt15">List of Bars Owned by You
                                        <a href="#contact" class="btn btn-more" data-toggle="modal" data-target="#myModal"> Add A New Bar </a>

            </h2>
            <hr class="bottom-line">

          </div>


          				<c:forEach items="${barDetail}" var="bar">

          				    ${bar.name}
          				              <div class="col-md-4 col-sm-6 col-xs-12">
                                        <div class="blog-sec">
                                          <div class="blog-img">
                                            <a href="<c:url value="/bar/${bar.barId}" />" >
                                              <img src="${bar.barPicture}" class="img-responsive">
                                            </a>
                                          </div>
                                          <div class="blog-info">
                                            <h2>${bar.name}.</h2>
                                            <div class="blog-comment">
                                                <p>Last Updated : <span>  Some Date </span></p>
                                            </div>

                                          </div>
                                        </div>
                                      </div>

                        </c:forEach>


            <div class="container">


              <!-- Modal -->
              <div class="modal" id="myModal" role="dialog">
                <div class="modal-dialog modal-lg">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">

                                <section id="contact" class="section-padding wow fadeInUp delay-05s">
                                  <div class="container">
                                    <div class="row">
                                      <div class="col-md-12 text-center white">
                                        <h2 class="service-title pad-bt15"> Fill in the below details </h2>
                                        <hr class="bottom-line white-bg">
                                      </div>
                                      <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="loction-info white">
                                                    <div class="contact-form">
                                                        <form action="/addNewBar" method="post" enctype="multipart/form-data" role="form" class="contactForm">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <input type="text" name="name" class="form-control" id="name" placeholder="Bar Name" data-rule="minlen:4" data-msg="Invalid Name" />
                                                                    <div class="validation"></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <input type="text" name="phoneNumber" class="form-control" id="phoneNumber" placeholder="Phone Number" data-rule="minlen:4" data-msg="Invalid Phone Number" />
                                                                    <div class="validation"></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="address" id="address" placeholder="Bar Address" data-rule="address" data-msg="Invalid Address" />
                                                                    <div class="validation"></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="latitude" id="latitude" placeholder="Bar Latitude" data-rule="minlen:4" data-msg="Invalid Latitude" />
                                                                    <div class="validation"></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="longitude" id="longitude" placeholder="Bar longitude" data-rule="minlen:4" data-msg="Invalid longitude" />
                                                                    <div class="validation"></div>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                       <label for="file">Logo to upload:</label>
                                                                       <input type="file" class="form-control" name="logo" id="logo"  data-rule="minlen:4" data-msg="Invalid longitude" />
                                                                       <div class="validation"></div>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                       <label for="file">Picture to upload:</label>
                                                                       <input type="file" class="form-control" name="picture" id="picture"  data-rule="minlen:4" data-msg="Invalid longitude" />
                                                                       <div class="validation"></div>

                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="amOpenTime" id="amOpenTime" placeholder="Opening Time" data-rule="minlen:4" data-msg="Invalid longitude" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="pmCloseTime" id="pmCloseTime" placeholder="Closing Time" data-rule="minlen:4" data-msg="Invalid longitude" />

                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                              <div class="form-group">

                                                                </div>
                                                              <button type="submit" class="btn btn-primary btn-submit"> Submit </button>
                                                            </div>
                                                        </form>

                                                    </div>

                                        </div>
                                      </div>

                                    </div>
                                  </div>
                                </section>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        </div>
      </div>
      </div>
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
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/wow.js"></script>
    <script src="js/jquery.bxslider.min.js"></script>
    <script src="js/custom.js"></script>
    <script src="contactform/contactform.js"></script>
    
  </body>
</html>