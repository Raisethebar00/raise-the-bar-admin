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
<body><!-- Modal -->
    <div class="container">
    <!-- Modal -->
        <div class="modal" id="editMenuModal" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Modal Header </h4>
                    </div>
                    <div class="modal-body">
                        <section id="contact" class="section-padding wow fadeInUp delay-05s">
                             <div class="container">
                                 <div class="row">
                                     <div class="col-md-12 text-center white">
                                         <h2 class="service-title pad-bt15"> Add menu</h2>
                                         <hr class="bottom-line white-bg">
                                     </div>
                                     <div class="col-md-6 col-sm-6 col-xs-12">
                                          <div class="loction-info white">
                                               <div class="contact-form">
                                                    <form action="/bar/item/edit" method="post" role="form" class="contactForm">
                                                         <div class="col-md-12">
                                                             <div class="form-group">
                                                                  <input type="text" class="form-control" name="name" id="editMenuName"
                                                                  data-rule="minlen:4" data-msg="Invalid Address" />
                                                                       <div class="validation"></div>
                                                             </div>
                                                         </div>
                                                         <div class="col-md-6">
                                                             <div class="form-group">
                                                                  <input type="text" name="price" class="form-control" id="editMenuPrice"
                                                                  data-rule="minlen:4" data-msg="Invalid Phone Number" />
                                                                       <div class="validation"></div>
                                                             </div>
                                                         </div>
                                                         <div class="col-md-6">
                                                              <div class="form-group">
                                                                  <input type="text" class="form-control" name="quantity" id="editMenuQuantity"
                                                                  data-rule="minlen:4" data-msg="Invalid Latitude" />
                                                              <div class="validation"></div>
                                                              </div>
                                                         </div>
                                                           <input type="hidden" id="editMenuId" name="itemId">

                                                              <div class="col-md-12">
                                                                  <div class="form-group">
                                                                  </div>
                                                                  <button type="submit" class="btn btn-primary btn-submit"> Submit  </button>
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
    <!-- modal -->
</body>
</html>
