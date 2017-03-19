<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
         <title>Title</title>
    </head>
<body>
 <div id="menu" class="container">
  <!---->
   <section id="contact" class="section-padding wow fadeInUp delay-05s">
        <div class="container">
             <div class="row">
                  <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="loction-info white">
                              <a href="#" class="btn btn-more-free" data-toggle="modal" data-target="#addMenuModal"> Add a New Item </a>
                        </div>
                  </div>
             </div>
        </div>
   </section>

   <jsp:include page="addMenu.jsp" />
   <jsp:include page="EditMenu.jsp" />

    <!---->
    <section id="service" class="section-padding wow fadeInUp delay-05s">
        <div class="container">
             <div class="row">
                  <div class="col-md-12 text-center">
                       <h2 class="service-title pad-bt15">What We Do?</h2>
                       <p class="sub-title pad-bt15">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                       <br>tempor incididunt ut labore et dolore magna aliqua.</p>
                        <hr class="bottom-line">
                  </div>
                   <c:forEach items="${itemDetails}" var="item">
                        <div class="col-md-3 col-sm-6 col-xs-12">
                             <div class="service-item">
                                  <h3> ${item.name}</h3>
                                   <p>Price :: ${item.price}
                                   <br>Quantity :: ${item.quantity}</p>
                                   <a href="#" class="open-AddBookDialog btn btn-more-free" data-toggle="modal"
                                   data-target="#editMenuModal" onClick="configEditMenu('${item.name}','${item.price}','${item.quantity}','${item.itemId}');" > Edit This Item </a>
                             </div>
                        </div>
                   </c:forEach>
             </div>
        </div>
    </section>
    <!---->


 </div>
     <script src="../js/jquery.min.js"></script>
     <script src="../js/jquery.easing.min.js"></script>
     <script src="../js/bootstrap.min.js"></script>
     <script src="../js/wow.js"></script>
     <script src="../js/jquery.bxslider.min.js"></script>
     <script src="../js/custom.js"></script>
    <script src="../js/extra.js"></script>
</body>
</html>