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
                    <h2>Đăng nhập</h2>
                    <form method="post" action="account?action=login">
                        Username: <input class="" type="text" value="" id="" name="username"/>
                        Mật khẩu: <input class="" type="password" value="" id="" name="password"/>
                        ${Message}
                        <input class="fr" type="submit" value="Đăng nhập" id="" name=""/>
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