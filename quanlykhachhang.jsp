<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>trang quản lý</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="admin/style.css">

    </head>
    <body>
        <div id="mod-banner">
            <img src="admin/tql.png">
        </div>
        <div class="container main">
            <nav class="navbar" id="mod-navigation">
                <div class="container">
                    <nav class="navbar navbar-toggleable-md">
                        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="url?href=admin">Thông tin phòng</a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="url?href=admin_khach">Thông tin khách đặt phòng</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="url?href=admin_thongke">Thống kê doanh thu</a>
                                </li>
                                <li class="nav-item justify-content-end">
                                    <a class="nav-link" href="account?action=logout" style="background:#1e65dd;border-radius: 10px;">Đăng xuất</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </nav>
            <div id="mod-quanlikhachhang-content">
                <table class="table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Tên khách hàng</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>CMND</th>
                            <th>Phòng</th>
                            <th>Ngày đặt</th>
                            <th>Ngày ra</th>
                            <th>Tùy chọn</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="phieu" items="${phieuDatList}" varStatus="loop">    
                            <tr>
                                <th scope="row">${loop.index +1}</th>
                                <td>${phieu.khach.nameK}</td>        
                                <td>${phieu.khach.sdt}</td>        
                                <td>${phieu.khach.email}</td>        
                                <td>${phieu.khach.cmnd}</td>         
                                <td>${phieu.room.type} (${phieu.room.nameP})</td>    
                                <td>${phieu.datein}</td>
                                <td>${phieu.dateout}</td>
                                <td>
                                    <button type="button" class="btn btn-primary">
                                        <a onclick="thanhToan(${phieu.idphieu})" style="color: #fff">Thanh toán</a>
                                    </button>
                                    <button type="button" class="btn btn-warning">
                                        <a href="url?href=edit_phieudat&id=${phieu.idphieu}" style="color: #fff">Sửa</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>	
                    </tbody>
                </table>
            </div>
        </div>

        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <script>
                                            function thanhToan(id) {
                                                var money = prompt("Nhập tiền phòng:", "0");
                                                if (money == null || money == "") {
                                                    txt = "";
                                                } else {
                                                    window.location = "ThanhToan?action=ThanhToan&id=" + id + "&tienphong=" + money;
                                                }
                                            }
        </script>
    </body>
</html>
