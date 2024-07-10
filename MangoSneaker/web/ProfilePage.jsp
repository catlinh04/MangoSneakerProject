<%-- 
    Document   : profile
    Created on : Jun 5, 2024, 11:47:02 PM
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
        <header>
            <%--<%@include file="TopNav.jsp"%>--%>
            <%@include file="Header.jsp"%>
        </header>

        <c:set var="info" value="${sessionScope.information}" scope="session"/>
        <div class="container light-style flex-grow-1 container-p-y">
            <h1 class="font-weight-bold py-3 mb-4" style="color: #5a958a; text-align: center;">
                Account settings
            </h1>

            <div class="card overflow-hidden">
                <div class="row no-gutters row-bordered row-border-light">
                    <div class="col-md-2 pt-0">
                        <div class="list-group list-group-flush account-settings-links">
                            <a class="list-group-item list-group-item-action ${param.tab == 'general' ? 'active' : ''}" data-toggle="list"
                               href="#account-general">General</a>
                            <a class="list-group-item list-group-item-action ${param.tab == 'change-password' ? 'active' : ''}" data-toggle="list"
                               href="#account-change-password">Change password</a>
                            <a id='log-out' class="list-group-item list-group-item-action ${param.tab == 'logout' ? 'active' : ''}" data-toggle="list"
                               href="#account-logout">Logout</a>
                        </div>
                    </div>
                    <div class="col-md-10">
                        <div class="tab-content">
                            <div class="tab-pane fade ${param.tab == 'general' || param.tab == null ? 'active show' : ''}" id="account-general">

                                <hr class="border-light m-0">
                                <form id="saveForm" action="MainAuthenticationController">
                                    <div class="card-body" style="width: 80%; margin-left: 10%;">
                                        <div class="form-group">
                                            <label class="form-label">Username</label>
                                            <input type="text" class="form-control mb-1" value="${info.username}" readonly>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Name</label>
                                            <input type="text" class="form-control" value="${info.firstName} ${info.lastName}" readonly>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">E-mail</label>
                                            <input type="text" class="form-control mb-1" value="${info.mail}" readonly>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Phone</label>
                                            <input type="text" class="form-control" value="${info.phone}" readonly>
                                        </div>
                                    </div>
                                    <div class="text-right mt-3 mr-3">
                                        <a href="UpdateCustomerPage.jsp"><button type="button" class="btn btn-primary" 
                                                                                 style="background-color: #5a958a; border: 2px solid #5a958a; margin-bottom: 20px;">Update</button></a> &nbsp;
                                        <button type="submit" class="btn btn-default" id="cancelButton" name="action" value="HomePage"
                                                style="margin-bottom: 20px;">Cancel</button>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade ${param.tab == 'change-password' ? 'active show' : ''}" id="account-change-password">
                                <p style="color: red; align-content: center; margin: 2% 0 0 4% ">${requestScope.err}</p>
                                <form id="saveForm" action="MainAuthenticationController" method="post">
                                    <div class="card-body pb-2" style="width: 80%; margin-left: 10%;">
                                        <div class="form-group">
                                            <label class="form-label">Current password</label>
                                            <input type="password" name="curPwd" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">New password</label>
                                            <input type="password" name="newPwd" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Repeat new password</label>
                                            <input type="password" name="reNewPwd" class="form-control">
                                        </div>
                                    </div>
                                    <div class="text-right mt-3 mr-3">
                                        <button type="submit" class="btn btn-primary" id="saveButton" name="action" value="UpdatePwd"
                                                style="background-color: #5a958a; border: 2px solid #5a958a; margin-bottom: 20px;">Save changes</button>&nbsp;
                                        <button type="submit" class="btn btn-default" id="cancelButton" name="action" value="HomePage"
                                                style="margin-bottom: 20px;">Cancel</button>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade ${param.tab == 'logout' ? 'active show' : ''}" id="account-logout">
                                <div class="card-body pb-2">
                                    <div class="form-group">
                                        <p>Are you sure you want to log out?</p>
                                        <div style="display: flex; justify-content: start;">
                                            <p style="color: red; align-content: center; margin: 2% 0 0 4% ">${requestScope.errLogout}</p>
                                            <form action="MainAuthenticationController">
                                                <button type="submit" class="btn btn-danger" id="logoutButton" style="margin: 0 5px;" name="action" value="Logout">Log out</button>
                                                <button type="submit" class="btn btn-danger" id="DelButton" name="action" value="DeleteAccount" style="margin: 0 5px;">Delete Account</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
                                            <footer style="margin-top: 10%"><%@include file="Footer.jsp"%></footer>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">
            document.addEventListener("DOMContentLoaded", function () {
                var logoutLink = document.getElementById('log-out');
                var generalLink = document.querySelector('[href="#account-general"]');
                var changePasswordLink = document.querySelector('[href="#account-change-password"]');
                var saveButton = document.getElementById('saveButton');
                var cancelButton = document.getElementById('cancelButton');
                var saveForm = document.getElementById('saveForm');

                function setFormAction(action) {
                    saveForm.action = "MainAuthenticationController?action=" + action;
                }

                function hideButtons() {
                    if (saveButton) {
                        saveButton.style.display = 'none';
                    }
                    if (cancelButton) {
                        cancelButton.style.display = 'none';
                    }
                }

                function showButtons() {
                    if (saveButton) {
                        saveButton.style.display = 'inline-block';
                    }
                    if (cancelButton) {
                        cancelButton.style.display = 'inline-block';
                    }
                }

                logoutLink.addEventListener('click', function () {
                    hideButtons();
                });

                generalLink.addEventListener('click', function () {
                    showButtons();
                });

                changePasswordLink.addEventListener('click', function () {
                    showButtons();
                });
            });

        </script>

    </body>
</html>
