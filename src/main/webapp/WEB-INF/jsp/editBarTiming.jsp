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
           <!-- Modal -->
           <div class="container">
                <!-- Modal -->
                <div class="modal" id="editBarTimingModal" role="dialog">
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
                                               <h2 class="service-title pad-bt15"> Fill in the Bar timing  </h2>
                                                <hr class="bottom-line white-bg">
                                           </div>

                                           <div class="col-md-6 col-sm-6 col-xs-12">
                                               <div class="loction-info white">
                                                   <div class="contact-form">
                                                        <form:form action="/editBarTiming/${singleBarDetails.barId}" method="post" role="form" modelAttribute="barWeekTimingDetails" class="contactForm">

                                                            <c:forEach items="${barWeekTimingDetails.weekTiming}" var="weekday" varStatus="status">

                                                                 <div class="col-md-6">
                                                                      <div class="form-group">
                                                                          <label for="file">${weekday.day}</label>
                                                                          <br>
                                                                           Opening Time   <input type="text" name="weekTiming[${status.index}].pmOpenTime" class="form-control" id="weekday[${status.index}].pmOpenTime" value="${weekday.pmOpenTime}" data-rule="minlen:4" data-msg="Invalid Name" />
                                                                           Close Time  <input type="text" name="weekTiming[${status.index}].pmCloseTime" class="form-control" id="weekday[${status.index}].pmCloseTime" value="${weekday.pmCloseTime}" data-rule="minlen:4" data-msg="Invalid Name" />
                                                                           <div class="validation"></div>
                                                                      </div>
                                                                 </div>

                                                            </c:forEach>


                                                            <div class="col-md-12">
                                                                <div class="form-group">

                                                                </div>
                                                                 <button type="submit" class="btn btn-primary btn-submit"> Update  </button>
                                                            </div>
                                                        </form:form>
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
 </body>
</html>