<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="special" class="container">
     <div class="week-day-list-padding">
             <ul class="mytab">
                  <li><a href="javascript:void(0)" onclick="openCity('Monday')">Monday</a></li>
                  <li><a href="javascript:void(0)" onclick="openCity('Tuesday')">Tuesday</a></li>
                  <li><a href="javascript:void(0)" onclick="openCity('Wednesday')">Wednesday</a></li>
                  <li><a href="javascript:void(0)" onclick="openCity('Thursday')">Thursday</a></li>
                  <li><a href="javascript:void(0)" onclick="openCity('Friday')">Friday</a></li>
                  <li><a href="javascript:void(0)" onclick="openCity('Saturday')">Saturday</a></li>
                  <li><a href="javascript:void(0)" onclick="openCity('Sunday')">Sunday</a></li>
             </ul>
                      <!---->
                      <section id="contact" class="section-padding wow fadeInUp delay-05s">
                             <div class="container">
                                   <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                             <div class="loction-info white">
                                                    <a href="#" class="btn btn-more-free" data-toggle="modal"
                                                    data-target="#addSpecialModal"> Add New Special </a>
                                             </div>
                                        </div>
                                   </div>
                             </div>
                      </section>

                                <jsp:include page="addSpecial.jsp" />
                                <jsp:include page="editSpecial.jsp" />

                                   <!---->
                                      <section id="service" class="section-padding wow fadeInUp delay-05s">
                                         <div class="container">
                                           <div class="row">
                                             <div class="col-md-12 text-center">
                                               <h2 class="service-title pad-bt15">List of All Special for this Bar !</h2>
                                               <p class="sub-title pad-bt15"> Click Above navigation bar to see day wise Special ! </p>
                                               <hr class="bottom-line">
                                             </div>

                                              <div id="Monday" class="day">
                                                  <c:forEach items="${specialDetails}" var="item">
                                                    <c:if test="${item.dayOfWeek == 1}">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                                <div class="service-item">
                                                                   <h3> ${item.name}</h3>
                                                                    <p><b>Price  :: </b> ${item.price} USD
                                                                        <br><b>Quantity :: </b> ${item.quantity}
                                                                        <br><b>Valid Till ::</b> ${item.quantity}
                                                                    </p>
                                                                    <a href="#" class="btn btn-more-free" data-toggle="modal"
                                                                        data-target="#editSpecialModal"
                                                                        onClick="configEditSpecial('${item.name}','${item.price}','${item.quantity}',
                                                                        '${item.tillTime}','${item.dayOfWeek}','${item.itemId}');" >
                                                                        Edit This Item
                                                                    </a>
                                                                </div>
                                                        </div>
                                                    </c:if>
                                                  </c:forEach>
                                              </div>



                                              <div id="Tuesday" class="day">
                                                  <c:forEach items="${specialDetails}" var="item">
                                                    <c:if test="${item.dayOfWeek == 2}">
                                                        ${item.name}
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                                <div class="service-item">
                                                                   <h3> ${item.name}</h3>
                                                                    <p><b>Price  :: </b> ${item.price} USD
                                                                        <br><b>Quantity :: </b> ${item.quantity}
                                                                        <br><b>Valid Till ::</b> ${item.quantity}
                                                                    </p>
                                                                    <a href="#" class="btn btn-more-free" data-toggle="modal"
                                                                     data-target="#editSpecialModal"
                                                                     onClick="configEditSpecial('${item.name}','${item.price}','${item.quantity}',
                                                                     '${item.tillTime}','${item.dayOfWeek}','${item.itemId}');" >
                                                                     Edit This Item
                                                                     </a>
                                                                </div>
                                                        </div>
                                                    </c:if>
                                                  </c:forEach>
                                              </div>

                                              <div id="Wednesday" class="day">
                                                  <c:forEach items="${specialDetails}" var="item">
                                                    <c:if test="${item.dayOfWeek == 3}">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                                <div class="service-item">
                                                                   <h3> ${item.name}</h3>
                                                                    <p><b>Price  :: </b> ${item.price} USD
                                                                        <br><b>Quantity :: </b> ${item.quantity}
                                                                        <br><b>Valid Till ::</b> ${item.quantity}
                                                                    </p>
                                                                    <a href="#" class="btn btn-more-free" data-toggle="modal"
                                                                     data-target="#editSpecialModal"
                                                                     onClick="configEditSpecial('${item.name}','${item.price}','${item.quantity}',
                                                                     '${item.tillTime}','${item.dayOfWeek}','${item.itemId}');" >
                                                                     Edit This Item
                                                                     </a>
                                                                </div>
                                                        </div>
                                                    </c:if>
                                                  </c:forEach>
                                              </div>

                                              <div id="Thursday" class="day">
                                                  <c:forEach items="${specialDetails}" var="item">
                                                    <c:if test="${item.dayOfWeek == 4}">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                                <div class="service-item">
                                                                   <h3> ${item.name}</h3>
                                                                    <p><b>Price  :: </b> ${item.price} USD
                                                                        <br><b>Quantity :: </b> ${item.quantity}
                                                                        <br><b>Valid Till ::</b> ${item.quantity}
                                                                    </p>
                                                                    <a href="#" class="btn btn-more-free" data-toggle="modal"
                                                                     data-target="#editSpecialModal"
                                                                     onClick="configEditSpecial('${item.name}','${item.price}','${item.quantity}',
                                                                     '${item.tillTime}','${item.dayOfWeek}','${item.itemId}');" >
                                                                     Edit This Item
                                                                     </a>
                                                                </div>
                                                        </div>
                                                    </c:if>
                                                  </c:forEach>
                                              </div>

                                              <div id="Friday" class="day">
                                                  <c:forEach items="${specialDetails}" var="item">
                                                    <c:if test="${item.dayOfWeek == 5}">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                                <div class="service-item">
                                                                   <h3> ${item.name}</h3>
                                                                    <p><b>Price  :: </b> ${item.price} USD
                                                                        <br><b>Quantity :: </b> ${item.quantity}
                                                                        <br><b>Valid Till ::</b> ${item.quantity}
                                                                    </p>
                                                                    <a href="#" class="btn btn-more-free" data-toggle="modal"
                                                                     data-target="#editSpecialModal"
                                                                     onClick="configEditSpecial('${item.name}','${item.price}','${item.quantity}',
                                                                     '${item.tillTime}','${item.dayOfWeek}','${item.itemId}');" >
                                                                     Edit This Item
                                                                     </a>
                                                                </div>
                                                        </div>
                                                    </c:if>
                                                  </c:forEach>
                                              </div>

                                              <div id="Saturday" class="day">
                                                  <c:forEach items="${specialDetails}" var="item">
                                                    <c:if test="${item.dayOfWeek == 6}">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                                <div class="service-item">
                                                                   <h3> ${item.name}</h3>
                                                                    <p><b>Price  :: </b> ${item.price} USD
                                                                        <br><b>Quantity :: </b> ${item.quantity}
                                                                        <br><b>Valid Till ::</b> ${item.quantity}
                                                                    </p>
                                                                    <a href="#" class="btn btn-more-free" data-toggle="modal"
                                                                     data-target="#editSpecialModal"
                                                                     onClick="configEditSpecial('${item.name}','${item.price}','${item.quantity}',
                                                                     '${item.tillTime}','${item.dayOfWeek}','${item.itemId}');" >
                                                                     Edit This Item
                                                                     </a>
                                                                </div>
                                                        </div>
                                                    </c:if>
                                                  </c:forEach>
                                              </div>

                                              <div id="Sunday" class="day">
                                                  <c:forEach items="${specialDetails}" var="item">
                                                    <c:if test="${item.dayOfWeek == 7}">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                                <div class="service-item">
                                                                   <h3> ${item.name}</h3>
                                                                    <p><b>Price  :: </b> ${item.price} USD
                                                                        <br><b>Quantity :: </b> ${item.quantity}
                                                                        <br><b>Valid Till ::</b> ${item.quantity}
                                                                    </p>
                                                                    <a href="#" class="btn btn-more-free" data-toggle="modal"
                                                                     data-target="#editSpecialModal"
                                                                     onClick="configEditSpecial('${item.name}','${item.price}','${item.quantity}',
                                                                     '${item.tillTime}','${item.dayOfWeek}','${item.itemId}');" >
                                                                     Edit This Item
                                                                     </a>
                                                                </div>
                                                        </div>
                                                    </c:if>
                                                  </c:forEach>
                                              </div>

                                           </div>
                                         </div>
                                      </section>

                <div class ="week-day-list">
                   <div id="Monday" >
                     <span onclick="this.parentElement.style.display='none'" class="w3-closebtn">&times;</span>
                     <jsp:include page="addSpecial.jsp" />
                   </div>

                    <div id="Paris"  style="display:none">
                       <span onclick="this.parentElement.style.display='none'" class="w3-closebtn">&times;</span>
                        <h2>Paris</h2>
                         <p>Paris is the capital of France.</p>

                    </div>

                     <div id="Tokyo" style="display:none">
                        <span onclick="this.parentElement.style.display='none'" class="w3-closebtn">&times;</span>
                        <h2>Tokyo</h2>
                        <p>Tokyo is the capital of Japan.</p>
                     </div>
                </div>
     </div>
</div>

