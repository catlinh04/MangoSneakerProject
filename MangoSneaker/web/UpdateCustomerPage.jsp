<%-- 
    Document   : UpdateCustomerPage
    Created on : Jul 7, 2024, 5:13:30 PM
    Author     : catlinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Profile</title>
        <link rel="stylesheet" href="./assets/css/profile.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    </head>
    <body>
        <%--<%@include file="TopNav.jsp"%>--%>
        <%@include file="Header.jsp"%>
        <div class="container light-style flex-grow-1 container-p-y">
            <h1 class="font-weight-bold py-3 mb-4" style="color: #5a958a; text-align: center;">
                Update Account
            </h1>
            <c:set var="info" value="${sessionScope.information}" scope="session"/>
            <div class="card overflow-hidden">
                <div class="row no-gutters row-bordered row-border-light">

                    <div class="col-md-12">
                        <div class="tab-content">
                            <div class="tab-pane fade active show" id="account-general">
                                <hr class="border-light m-0">
                                <p style="color: red; align-content: center; margin: 3% 0% 0% 12%;">${requestScope.err}</p>
                                <form id="saveForm" action="MainAuthenticationController" method="post">
                                    <div class="form-group">
                                        <input type="hidden" id="customerId" name="customerId" value="${info.id}"/>
                                    </div>
                                    <div class="card-body" style="margin:3% 10% 0 10%;">
                                        <div class="form-group">
                                            <label class="form-label">Username</label>
                                            <input type="text" class="form-control mb-1" name="username" value="${info.username}"/>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                <label class="form-label">First Name</label>
                                                <input type="text" class="form-control" name="firstName" value="${info.firstName}"/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label class="form-label">Last Name</label>
                                                <input type="text" class="form-control" name="lastName" value="${info.lastName}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">E-mail</label>
                                            <input type="text" class="form-control mb-1" name="mail" value="${info.mail}"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Phone</label>
                                            <input type="text" class="form-control" name="phone" value="${info.phone}"/>
                                        </div>
                                    </div>
                                    <div class="text-right mt-3 mr-3">
                                        <button type="submit" class="btn btn-primary" id="saveButton" name="action" value="UpdateCustomer"
                                                style="background-color: #5a958a; border: 2px solid #5a958a; margin-bottom: 20px;">Save changes</button> &nbsp;
                                        <button type="submit" class="btn btn-default" id="cancelButton" name="action" value="ProfilePage"
                                                style="margin-bottom: 20px;">Cancel</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="Footer.jsp"%>
    </body>
</html>
