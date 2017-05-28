<!-- Modal -->
 <div class="container">
     <div class="modal" id="editSpecialModal" role="dialog">
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
                                 <h2 class="service-title pad-bt15"> Edit Special </h2>
                                 <hr class="bottom-line white-bg">
                            </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                     <div class="loction-info white">
                                          <div class="contact-form">
                                                <form action="/bar/special/edit" method="post" role="form" class="contactForm">
                                                      <div class="col-md-12">
                                                           <div class="form-group">
                                                                 <label for="name">Name</label>
                                                                 <input type="text" class="form-control" name="name" id="editSpecialName"
                                                                 data-rule="minlen:4" data-msg="Invalid Address" />
                                                                        <div class="validation"></div>
                                                           </div>
                                                      </div>

                                                      <div class="col-md-6">
                                                            <div class="form-group">
                                                                 <label for="price">Price</label>
                                                                 <input type="text" name="price" class="form-control" id="editSpecialPrice"
                                                                 data-rule="minlen:4" data-msg="Invalid Phone Number" />
                                                                 <div class="validation"></div>
                                                            </div>
                                                      </div>

                                                      <div class="col-md-6">
                                                           <div class="form-group">
                                                                 <label for="quantity">Quantity</label>
                                                                 <input type="text" class="form-control" name="quantity" id="editSpecialQuantity"
                                                                 data-rule="minlen:4" data-msg="Invalid Latitude" />
                                                                  <div class="validation"></div>
                                                           </div>
                                                      </div>
                                                      <div class="col-md-6">
                                                           <div class="form-group">
                                                                 <label for="validFrom">Valid From</label>
                                                                <input type="text" class="form-control" name="validFrom" id="editSpecialValidFrom"
                                                                 data-rule="minlen:4" data-msg="Invalid Latitude" />
                                                                <div class="validation"></div>
                                                           </div>
                                                      </div>

                                                      <div class="col-md-6">
                                                           <div class="form-group">
                                                                 <label for="tillTime">Valid Till</label>
                                                                <input type="text" class="form-control" name="tillTime" id="editSpecialTillTime"
                                                                 data-rule="minlen:4" data-msg="Invalid Latitude" />
                                                                <div class="validation"></div>
                                                           </div>
                                                      </div>

                                                       <div class="col-md-6">
                                                            <div class="form-group">
                                                                 <label for="dayOfWeek">Day of Week</label>
                                                                 <input type="text" class="form-control" name="dayOfWeek" id="editSpecialDayOfWeek"
                                                                 data-rule="minlen:4" data-msg="Invalid Latitude" />
                                                                 <div class="validation"></div>
                                                            </div>
                                                       </div>

                                                        <input type="hidden" id="editSpecialId" name="itemId">


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
