# Đề tài môn học Phát triển phần mềm mã nguồn mở

## Website quản lý đặt phòng online khách sạn Fairybay

​	 				                     ![a](http://imageshack.com/a/img922/4127/BIHQnK.png)







​	Ngày nay việc đặt phòng khách sạn thật sự đơn giản . Trước đây, khách du lịch thường mua dịch vụ trọn gói của đại lý hoặc tự tìm thông tin liên hệ  khách sạn và đặt phòng. Nhưng giờ đây, chỉ đơn giản bằng cách truy cập vào trang web, với các thao tác đơn giản  du khách quên đi mối lo lắng về nơi ăn chốn nghỉ cho Chuyến du lịch thú vị của mình

​	Công nghệ thông tin phát triển, the web trực tuyến trang bắt đầu ra đời giành vị trí lớn trong việc đặt phòng ở Việt Nam. Các web trang online ngày càng thu hút lượng lớn khách .

​	Hệ thống dữ liệu có sẵn luôn, thông tin đầy đủ về vị trí, giá phòng, tiêu chuẩn, the tiện ích, dịch vụ giải trí, hình ảnh của hàng trăm khách sạn been phân loại cụ thể từ địa điểm đến giá phòng với nhiều cấp độ từ bình dân đến cao cấp, du khách dễ dàng chọn  khách sạn phù hợp với mình, 

 #### Mục tiêu phát triển của dự án

Tạo ra một website gồm những chức năng:

- module Đặt phòng online cho du khách
- Áp dụng phương thức thanh toán online
- Quản lý số lượng du khách đặt phòng
- Quản lý doanh thu khách thanh toán
- Thống kê báo cáo
- Sử dụng các phương thức mã hóa trong quá trình giao dịch online
####Thông tin tổ chức mã nguồn
Framework này được thiết kế theo mô hình MVC, nó giúp cho việc thiết kế, xử lý và bảo trì mã nguồn dễ dàng, đồng thời tăng khả năng mở rộng của phần mềm. vận dụng mô hình này trong thiết kế, giúp tách biệt các tập tin giao diện với các tập tin xử lý dữ liệu, nâng cao khả năng quản lý và dễ bảo trì.

Tập tin index.php được xem như controller đầu vào, tiếp nhận các yêu cầu từ phía client và chuyển các yêu cầu này cho hệ thống xử lý.



Thư mục [controllers](https://github.com/itplus77/4305-Website--dat-phong-online/tree/master/controller): chứa các lớp controller

Thư mục [connection](https://github.com/itplus77/4305-Website--dat-phong-online/tree/master/connection): chứa kết nối với csdl

Thư mục [models](https://github.com/itplus77/4305-Website--dat-phong-online/tree/master/model): chứa các lớp model


Thư mục [js](https://github.com/itplus77/4305-Website--dat-phong-online/tree/master/js): bootstrap.js để thiết kết giao diện html

Thư mục [entities](https://github.com/itplus77/4305-Website--dat-phong-online/tree/master/entities): chứa các thực thể

#### Quản lý phiên bản:

Chúng tôi dùng [Git](https://git-scm.com/) để tổ chức quản lý phiên bản theo hướng phân tán
####Bảo mật 
- Nhà phát triển sử dụng [Cuckoo Sandbox](http://nixmicrosoft.blogspot.com/2013/10/damn-vulnerable-web-app-dvwa_9.html)hệ thống phân tích malware động tự động, giám sát những file nghi ngờ trong một môi trường tách biệt.



#### Tác giả

- Lê Thị Hoài thuận - Trưởng Nhóm (Giám đốc dự án) | Email: Hoaithuan95@gmail.com 
- Trần Thanh Phương - cộng tác viên | Email:itplus1a1@gmail.com

#### Giấy phép: 

[Chi tiết thông tin về Giấy phép](https://github.com/itplus77/4305-phan-mem-quan-ly-khach-san/blob/master/Th%C3%B4ng%20tin%20v%E1%BB%81%20gi%E1%BA%A5y%20ph%C3%A9p.md)

#### Kênh truyền thông cho dự án

[Chuyển tiếp đến kênh truyền thông dự án](https://www.facebook.com/Kh%C3%A1ch-s%E1%BA%A1n-Fairy-Bay-148207479088621/)

#### Chuẩn lập trình

project được viết theo mô hình MVC kết hợp với các nguyên tắc trong lập trình

Các quy tắc về chuẩn lập trình:[Thông tin chi tiết về chuẩn lập trình](https://github.com/itplus77/4305-phan-mem-quan-ly-khach-san/blob/master/Quy%20t%E1%BA%AFc%20v%C3%A0%20phong%20c%C3%A1ch%20vi%E1%BA%BFt%20code%20trong%20l%E1%BA%ADp%20tr%C3%ACnh.md)



#### Tài liệu dành cho nhà thiết kế:

Tài liệu thiết kế: [Tài liệu dành cho thiết kế Html css](https://thachpham.com/web-development/html-css/html-va-css-can-ban-danh-cho-cho-moi-nguoi.html)

#### Tài liệu cho người dùng cuối 

[See instructions](https://github.com/itplus77/4305-phan-mem-quan-ly-khach-san/blob/master/T%C3%A0i%20li%E1%BB%87u%20ng%C6%B0%E1%BB%9Di%20d%C3%B9ng%20cu%E1%BB%91i.docx)



#### Cách lấy mã và đóng góp mã nguồn

[Xem video hướng dẫn chi tiết](https://www.youtube.com/watch?v=yXT1ElMEkW8)

#### Tài liệu cho nhà phát triển:

- Hệ thống CSDL DB2: [hướng dẫn chi tiết](https://www.ibm.com/developerworks/vn/library/contest/dw-freebooks/Nhap_Mon_DB2_ExpressC/Nhap_mon_DB2_ExpressC_v9.7.pdf)
- Hướng dẫn lập trình JSP:[hướng dẫn chi tiết](http://o7planning.org/vi/10263/huong-dan-lap-trinh-java-jsp)
- Hướng dẫn kết nối CSDL:[chuyển tiếp đến trang hướng dẫn](https://zstar2.wordpress.com/2011/05/06/java-k%E1%BA%BFt-n%E1%BB%91i-csdl-t%E1%BB%AB-netbean/)
- Sử dụng các phương thức mã hóa trong quá trình giao dịch online
- Thanh toán trực tuyến



#### Danh sách các lỗi và cách sửa chữa:

- lỗi kết nối CSDL: [kết nối CSDL DB2 đến JSP Hướng dẫn](http://congdongjava.com/forum/threads/help-k%E1%BA%BFt-n%E1%BB%91i-t%E1%BB%9Bi-csdl-b%E1%BA%B1ng-jsp.16832/)

- Tổng hợp lỗi trong JSP: [Cách khắc phục](http://kenhlaptrinh.net/bai-20-tong-hop-mot-so-loi-va-cach-khac-phuc-trong-jsp-servlet/)

  ​

#### Demo Giao diện ban đầu

[chuyển tiếp đên trang web demo giao diện](https://itplus77.github.io/demodatphongonline.github.io/)



#### Kiến thức áp dụng

####  



- Sử dụng ngôn ngữ JSP và CSDL DB2 

- DataGridView, DataSet, DataTable, DataRow.

- Phân tích thiết kế hệ thống cơ sở dữ liệu.

- Phân tích thiết kế giao diện.

- Trigger SQL.

- Procedure, function SQL.

- Kết nối DB2 với JSP dùng JDBC.

- Chuyển data giữa các form.

- Phân quyền người dùng trên ứng dụng

- Thêm, xóa, sửa dữ liệu từ trang quản trị.

  ​

  ​





 









