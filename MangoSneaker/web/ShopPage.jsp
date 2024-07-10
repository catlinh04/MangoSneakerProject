<%-- 
    Document   : shop
    Created on : May 30, 2024, 6:27:14 PM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="mangosneaker.model.dto.ProductDTO" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Mango Sneaker - Product Listing Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    </head>

    <body>
        <!-- Start Top Nav -->
        <%--<%@include file="TopNav.jsp" %>--%>
        <!-- Close Top Nav -->

        <!-- Header -->
        <%@include file="Header.jsp" %>
        <!-- Close Header -->

        <!-- Start Content -->
        <div class="container py-5">
            <div class="row">
                <h2 class="col-md-12 text-center">
                    <c:choose>
                        <c:when test="${not empty param.searchNameValue}">
                            Search Results For: '${param.searchNameValue}'
                        </c:when>
                    </c:choose>
                </h2>

                <div class="col-lg-12">
                    <form class="row" id="sortForm" action="DispatcherProductController?action=GetAllProducts" method="POST">
                        <input type="hidden" name="cid" value="${param.cid}" id="cidInput">
                        <input type="hidden" name="searchNameValue" value="${param.searchNameValue}">

                        <!--Category-->
                        <div class="col-md-6">
                            <ul class="list-inline shop-top-menu pb-3 pt-1">
                                <li class="list-inline-item hover-pointer">
                                    <a class="h3 text-dark text-decoration-none mr-3" onclick="updateCidValueAndSubmit(0)">All</a>
                                </li>
                                <c:forEach items="${requestScope.cateList}" var="cate">
                                    <li class="list-inline-item hover-pointer">
                                        <a class="h3 text-dark text-decoration-none mr-3" onclick="updateCidValueAndSubmit(${cate.id})">${cate.name}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>

                        <!--Sort-->
                        <div class="col-md-6 pb-4">
                            <div class="d-flex align-items-center justify-content-end">
                                <label for="sort" style="margin-right: 10px;">Sort By</label>
                                <select id="sort" name="sortType" class="form-control" style="width: auto;" onchange="document.getElementById('sortForm').submit();">
                                    <option value="discount" ${param.sortType == 'newest' ? 'selected' : ''}>Newest</option>
                                    <option value="priceHighLow" ${param.sortType == 'priceHighLow' ? 'selected' : ''} >Price: High-Low</option>
                                    <option value="priceLowHigh" ${param.sortType == 'priceLowHigh' ? 'selected' : ''}>Price: Low-High</option>
                                </select>
                            </div>
                        </div>

                    </form>
                    <div class="row">
                        <c:forEach items="${requestScope.proList}" var="p">
                            <form class="col-md-3" action="DispatcherProductController?action=GetSingleProduct" method="POST">
                                <div class="card mb-4 product-wap rounded-0">
                                    <input type="hidden" name="productId" value="${p.id}">
                                    <div class="card rounded-0">
                                        <button type="submit" class="button-reset">
                                            <img class="card-img rounded-0 img-fluid" src="assets/img/product/${p.img}">
                                        </button>
                                    </div>
                                    <div class="card-body">
                                        <button type="submit" class="button-reset">
                                            <p class="fw-bold h3">${p.name}</p>
                                            <p class="text-start mb-0 fw-normal">${p.price}</p>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <!-- End Content -->
        <%@include file="Brands.jsp"%>
        <%@include file="Footer.jsp"%>
        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <script>
                                    function submitSortForm() {
                                        document.getElementById('sortForm').submit();
                                    }
                                    function updateCidValueAndSubmit(value) {
                                        document.getElementById('cidInput').value = value;
                                        document.getElementById('sortForm').submit();
                                    }

        </script>
        <!-- End Script -->
        <!--</head>-->
    </body>
</html>