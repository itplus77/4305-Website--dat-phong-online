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
        <div class="navbar-wrapper">
            <div class="container-fluid">
                <div id="mod-banner">
                    <img src="admin/tql.png">
                </div>

                <div>
                    <h2>Sửa thông tin</h2>
                    <form method="post" action="PhieuDat?action=SuaPhong">
                        <input type="text" value="${phieuDat.idphieu}" name="id" hidden=""/>
                        Tên khách hàng: <input type="text" value="${phieuDat.khach.nameK}" name="full_name"/> <br/>
                        Số điện thoại:  <input type="text" value="${phieuDat.khach.sdt}" name="phone_number"/> <br/>
                        Email:  <input type="text" value="${phieuDat.khach.email}" name="email"/> <br/>
                        CMND:  <input type="text" value="${phieuDat.khach.cmnd}" name="cmnd_number"/> <br/>
                        Ngày đặt:  <input type="text" value="${phieuDat.datein}" name=""/> <br/>
                        Ngày ra:  <input type="text" value="${phieuDat.dateout}" name=""/> <br/>
                        ${Message}
                        <input onclick="window.history.back()" class="fr" type="submit" value="Quay lại" id="" name=""/>
                        <input class="fr" type="submit" value="Sửa thông tin" id="" name=""/>
                        </ul>
                    </form>
                </div>

                <nav class="navbar" id="mod-navigation" hidden="">
                    <div class="container">
                        <nav class="navbar navbar-toggleable-md">
                            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav mr-auto">
                                    <li class="nav-item">
                                        <a class="nav-link" href="admin/quanliphong.html">Thông tin phòng <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="admin/quanlikhachhang.html">Thông tin khách hàng</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="admin/quanlithongke.html">Thống kê doanh thu</a>
                                    </li>				      
                                    <li class="nav-item">
                                        <a class="nav-link" href="admin/quanlithanhtoan.html">Thanh toán</a>
                                    </li>				      
                                    <li class="nav-item justify-content-end">
                                        <a class="nav-link" href="admin/quanlithanhtoan.html" style="background:#1e65dd;border-radius: 10px;">Đăng xuất</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </nav>


            </div>
        </div>
        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </body>
</html>