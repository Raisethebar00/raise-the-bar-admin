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
                              <div class="modal" id="editModal" role="dialog">
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
                                                                        <form action="/editBar/${singleBarDetails.barId}" method="post" role="form" class="contactForm">
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <input type="text" name="name" class="form-control" id="name" value="${singleBarDetails.name}" data-rule="minlen:4" data-msg="Invalid Name" />
                                                                                    <div class="validation"></div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <input type="text" name="phoneNumber" class="form-control" id="phoneNumber" value="${singleBarDetails.phoneNumber}" data-rule="minlen:4" data-msg="Invalid Phone Number" />
                                                                                    <div class="validation"></div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-12">
                                                                                <div class="form-group">
                                                                                    <input type="text" class="form-control" name="address" id="address" value="${singleBarDetails.address}" data-rule="address" data-msg="Invalid Address" />
                                                                                    <div class="validation"></div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <input type="text" class="form-control" name="latitude" id="latitude" value="${singleBarDetails.latitude}" data-rule="minlen:4" data-msg="Invalid Latitude" />
                                                                                    <div class="validation"></div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <input type="text" class="form-control" name="longitude" id="longitude" value="${singleBarDetails.longitude}" data-rule="minlen:4" data-msg="Invalid longitude" />
                                                                                    <div class="validation"></div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <input type="text" class="form-control" name="amOpenTime" id="amOpenTime" value="${singleBarDetails.amOpenTime}" data-rule="minlen:4" data-msg="Invalid longitude" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <input type="text" class="form-control" name="pmCloseTime" id="pmCloseTime" value="${singleBarDetails.pmCloseTime}" data-rule="minlen:4" data-msg="Invalid longitude" />

                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-12">
                                                                              <div class="form-group">

                                                                               </div>
                                                                              <button type="submit" class="btn btn-primary btn-submit"> Update  </button>
                                                                            </div>
                                                                        </form>


                                                                    </div>

                                                        </div>
                                                      </div>
                                                         <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <div class="loction-info white">
                                                              <div class="contact-form">
                                                                        <form action="/editBar/${singleBarDetails.barId}/logo" method="post" enctype="multipart/form-data" role="form" class="contactForm">

                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                       <label for="file">Upload LOGO :</label>
                                                                                       <input type="file" class="form-control" name="logo" id="logo"  data-rule="minlen:4" data-msg="Invalid longitude" />
                                                                                       <div class="validation"></div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="col-md-6">
                                                                              <div class="form-group">

                                                                                </div>
                                                                              <button type="submit" class="btn btn-primary btn-submit"> Update  </button>
                                                                            </div>
                                                                        </form>
                                                              </div>
                                                            </div>
                                                         </div>

                                                         <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <div class="loction-info white">
                                                              <div class="contact-form">
                                                                        <form action="/editBar/${singleBarDetails.barId}/picture" method="post" enctype="multipart/form-data" role="form" class="contactForm">

                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                       <label for="file">Upload Picture :</label>
                                                                                       <input type="file" class="form-control" name="picture" id="picture"  data-rule="minlen:4" data-msg="Invalid longitude" />
                                                                                       <div class="validation"></div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="col-md-6">
                                                                              <div class="form-group">

                                                                                </div>
                                                                              <button type="submit" class="btn btn-primary btn-submit"> Update  </button>
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