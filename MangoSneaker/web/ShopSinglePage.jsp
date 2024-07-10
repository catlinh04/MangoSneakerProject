<%-- 
    Document   : shop-single
    Created on : May 30, 2024, 6:26:59 PM
    Author     : Nhatthang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Mango Shop - Product Detail Page</title>
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

        <!-- Slick -->
        <link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">
    </head>

    <body>    
        <!-- Start Top Nav -->
        <%--<%@include file="TopNav.jsp" %>--%>
        <!-- Close Top Nav -->

        <!-- Header -->
        <%@include file="Header.jsp" %>
        <!-- Close Header -->

        <!-- Modal -->
        <div class="modal fade bg-white" id="templatemo_search" tabhome="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="w-100 pt-1 mb-5 text-right">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="" method="get" class="modal-content modal-body border-0 p-0">
                    <div class="input-group mb-2">
                        <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                        <button type="submit" class="input-group-text bg-success text-light">
                            <i class="fa fa-fw fa-search text-white"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>



        <!-- Open Content -->
        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-6 mt-5">
                        <div class="card mb-3">
                            <img class="card-img img-fluid" src="assets/img/product/${product.img}" alt="Card image cap" id="product-detail">
                            <img class="card-img img-fluid" src="assets/img/product/${product.img}" alt="Card image cap" id="product-detail">

                        </div>
                    </div>
                    <!-- col end -->
                    <div class="col-lg-6 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h1 class="h2">${product.name}</h1>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Brand: <span class="fw-light">${product.category.name}</span> </h6>
                                    </li>
                                </ul>
                                <p class="h3 py-2 fw-bold">$${product.price}</p>


                                <form action="DispatcherProductController" method="POST">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <div class="row">
                                        <div class="col-auto">
                                            <ul class="list-inline pb-3">
                                                <li class="list-inline-item fw-bold">Size : 
                                                    <input type="hidden" name="productSize" id="productSize" value="">
                                                </li>
                                                <c:forEach var="szQuan" items="${szQuan}">
                                                    <li class="list-inline-item"><span class="btn btn-success btn-size">${szQuan.key}</span></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-auto">
                                            <ul class="list-inline pb-3">
                                                <li class="list-inline-item text-right fw-bold">
                                                    Quantity
                                                    <input type="hidden" name="productQuantity" id="productQuantity" value="1">
                                                </li>
                                                <li class="list-inline-item"><span class="btn btn-success" id="btn-minus">-</span></li>
                                                <li class="list-inline-item"><span class="badge bg-secondary" id="var-value">1</span></li>
                                                <li class="list-inline-item"><span class="btn btn-success" id="btn-plus">+</span></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row pb-3">
                                        <div class="col d-grid">
                                            <button type="submit" class="btn btn-success btn-lg" name="action" value="buy">Buy</button>
                                        </div>
                                        <div class="col d-grid">
                                            <button type="submit" class="btn btn-success btn-lg" name="action" value="AddToCart">Add To Cart</button>
                                        </div>
                                    </div>
                                </form>

                                <p>${product.description}</p>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Close Content -->

        <!-- Start Related -->
        <section class="py-5">
            <div class="container">
                <div class="row text-left p-2 pb-3">
                    <h4>Related Products</h4>
                </div>

                <!--Start Carousel Wrapper-->
                <div id="carousel-related-product">
                    <c:forEach items="${requestScope.proList}" var="p">
                        <div class="p-2 pb-3">
                            <div class="product-wap card rounded-0">
                                <form action="DispatcherProductController?action=GetSingleProduct" method="POST">
                                    <input type="hidden" name="pId" value="${p.id}">
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

                                </form>

                            </div>
                        </div>
                    </c:forEach>


                </div>
        </section>
        <!-- End Related -->


        <!-- Start Footer -->
        <%@include file="Footer.jsp" %>
        <!-- End Footer -->

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- End Script -->

        <!-- Start Slider Script -->
        <script src="assets/js/slick.min.js"></script>
        <script>
            $('#carousel-related-product').slick({
                infinite: true,
                arrows: false,
                slidesToShow: 4,
                slidesToScroll: 3,
                dots: true,
                responsive: [{
                        breakpoint: 1024,
                        settings: {
                            slidesToShow: 3,
                            slidesToScroll: 3
                        }
                    },
                    {
                        breakpoint: 600,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 3
                        }
                    },
                    {
                        breakpoint: 480,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 3
                        }
                    }
                ]
            });
        </script>
        <!-- End Slider Script -->

    </body>

</html>