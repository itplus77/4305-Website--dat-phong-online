--	De tai quan ly khach san - quan ly khach san Fairy bay
--	Tables are included:
	--	Room			 R (Short hand)
	--	TypeRoom	     TR
	-- 	Services: Food F, FoodCategory FC, Massage M
	--	Account			 A
	--	Rent_Room		 B  Thuê Phòng
	--	Room_in_Detail 		Chi tiết phòng 
	-- 	id_Customer			
	--  Using_Service		Sử dụng dịch vụ
	-- 	Service_in_Detail	Chi tiết sử dụng dịch vụ


CREATE SCHEMA nhom3

CREATE TABLE nhom3.TypeRoom(id_TR SMALLINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 0 INCREMENT BY 1),type_TR VARGRAPHIC(30) NOT NULL,name_TR VARGRAPHIC(40) NOT NULL ,Price_TR DOUBLE NOT NULL)
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0001','SINGLE ROOM','NORMAL','500000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0002','SINGLE ROOM','NORMAL','500000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0003','SINGLE ROOM','VIP','750000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0004','SINGLE ROOM','VIP','750000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0005','TWIN ROOM','NORMAL','600000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0006','TWIN ROOM','NORMAL','600000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0007','TWIN ROOM','VIP','900000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0008','TWIN ROOM','VIP','90000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0009','DORM ROOM','NORMAL','800000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0010','DORM ROOM','NORMAL','800000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0011','DORM ROOM','VIP','1100000')
INSERT INTO nhom3.TypeRoom(id_TR,type_TR,name_TR,Price_TR) VALUES('TR0012','DORM ROOM','VIP','1100000')

CREATE TABLE nhom3.Room(	id_R SMALLINT PRIMARY KEY NOT NULL,	name_R VARGRAPHIC(30) NOT NULL,	status_R VARGRAPHIC(20) NOT NULL DEFAULT 1)
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00001','ROOM 101','GOOD')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00002','ROOM 102','QUITE')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00003','ROOM 103','QUITE')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00004','ROOM 104','GOOD')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00005','ROOM 201','GOOD')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00006','ROOM 202','QUITE')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00007','ROOM 203','QUITE')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00008','ROOM 204','GOOD')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00009','ROOM 301','QUITE')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00010','ROOM 302','GOOD'),
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00011','ROOM 303','GOOD')
INSERT into nhom3.Room(id_R,name_R,status_R) VALUES ('R00012','ROOM 304','GOOD')

CREATE TABLE nhom3.Room_in_Detail(id_RD SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 0 INCREMENT BY 1),id_R VARGRAPHIC(30) NOT NULL,Price_dimatic DOUBLE)
INSERT INTO nhom3.Room_in_Detail(id_RD,Price_dimatic) VALUES ('RD0001','R00001','300000')
INSERT INTO nhom3.Room_in_Detail(id_RD,Price_dimatic) VALUES ('RD0001','R00001','300000')
#chỗ này có Price_dimatic (Giá động) vì khi bình thường giá nó sẽ rẻ hơn 1 chút so với gia tham khảo (Show ở trên TypeRoom), còn lễ hay cao điểm giá sẽ cao hơn bình thường. Khi tính tiền thì luôn dùng giá động này để tính, còn giá Trên TypeRoom sẽ show lên trang web để khách tham khảo đặt phòng thôi.

CREATE TABLE  phuc.Customer(id_Customer SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 0 INCREMENT BY 1),name_CS VARGRAPHIC(40) NOT NULL WITH DEFAULT N'No named',age_CS VARGRAPHIC(2) NOT NULL ,gender VARGRAPHIC(10) NOT NULL,Identify VARGRAPHIC(10) NOT NULL,Phone_Number VARGRAPHIC(11) NOT NULL,Nationality VARGRAPHIC(20) NOT NULL)
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0001',N'DAVID MAHOME','41','MALE','251011214','01215121541','US')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0002',N'TRẦN QUỐC ANH','24','MALE','25105684','01255506789','VIE')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0003',N'CHIZEAZ ALEX','28','MALE','301412814','01663268574','BRAZIL')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0004',N'OSROSDINNHO ','50','FEMALE','211011214','0167326161','US')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0005',N'CARSLOT','48','MALE','2510147471','0985252515','RUSSIA')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0006',N'PHẠM THỊ KIỀU TRƯƠNG','27','FEMALE','25174171458','01216325156','VIE')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0007',N'ĐỖ THANH NHUNG','23','FEMALE','364125414','0126325325','VIE')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0008',N'JESSICA','20','FEMALE','251011214','0127147147','CHILE')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0009',N'TRỊNH ĐÌNH PHÚC','21','MALE','284125550','01216585084','VIE')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0010',N'TRẦN THANH PHƯƠNG','22','MALE','257474171','09889652365','VIE')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0011',N'LÊ THỊ HOÀI THUẬN','22','FEMALE','35241241','09841515151','VIE')
INSERT INTO nhom3.Customer(id_Customer,name_CS,age_CS,gender,Identify,Phone_Number,Nationality) VALUES ('CS0012',N'DERIX FIELD','35','MALE','255052414','01222562562','CHILE')

CREATE Table phuc.Account_Staff(UserName VARGRAPHIC(50) NOT NULL PRIMARY KEY,Pass VARGRAPHIC NOT NULL DEFAULT 0,name_Staff VARGRAPHIC(50) NOT NULL Default N'no named',	type_account INT NOT NULL DEFAULT 0 )
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'PK_NHUNG','123456','PHẠM KIỀU NHUNG','STAFF')
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'TD_PHUC','666666','TRỊNH ĐÌNH PHÚC','ADMIN')
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'TH_PHUONG','123456','TRẦN THANH PHƯƠNG','ADMIN')
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'LTH_THUAN','123456','LÊ THỊ HOÀI THUẬN','ADMIN')
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'ADMIN','123456','ADMIN','ADMIN')
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'TRAN_NAM','123456','TRẦN NAM','STAFF')
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'DM_ANH','123456','ĐỖ MAI ANH','STAFF')
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'LTM_HOA','123456','LÊ THỊ MINH HOA','STAFF')
INSERT INTO nhom3.Account_Staff(UserName,Pass,name_Staff,type_account) VALUES(N'TN_NAM','123456','TRẦN NGỌC NAM','STAFF')


CREATE Table phuc.Rent_Room(	id_RR SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 0 INCREMENT BY 1),DateCheckIn TIMESTAMP NOT NULL DEFAULT CURRENT TIMESTAMP,DateCheckOut TIMESTAMP)
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0001','2017-01-15-15-50-00','2017-01-15-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0002','2017-01-16-08-52-00','2017-01-17-10-50-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0003','2017-01-17-15-40-00','2017-01-17-20-10-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0004','2017-01-18-14-20-00','2017-01-18-22-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0005','2017-01-18-05-00-00','2017-01-19-05-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0006','2017-01-18-10-00-00','2017-01-18-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0007','2017-01-19-15-52-00','2017-01-20-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0009','2017-01-19-15-52-00','2017-01-20-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0010','2017-01-19-00-52-00','2017-01-21-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0011','2017-01-20-15-52-00','2017-01-20-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0012','2017-01-21-15-52-00','2017-01-22-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0013','2017-01-22-15-52-00','2017-01-23-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0014','2017-01-23-14-52-00','2017-01-23-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0015','2017-01-23-08-52-00','2017-01-24-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0016','2017-01-23-15-52-00','2017-01-24-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0017','2017-01-24-10-52-00','2017-01-24-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0018','2017-01-24-04-52-00','2017-01-24-20-00-00')
INSERT INTO nhom3.Rent_Room(ID_RR,DateCheckIn,DateCheckOut) VALUES ('RR0019','2017-01-25-16-52-00','2017-01-25-20-00-00')


CREATE Table phuc.Services(id_service SMALLINT NOT NULL GENERATED ALWAYS as IDENTITY (START WITH 0 INCREMENT BY 1),Category VARGRAPHIC(30) Not NULL ,name_Service VARGRAPHIC(50) NOT NULL,price_Service DOUBLE)
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0001','FOOD',N'BÁNH MỲ TRỨNG','30000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0002','FOOD',N'PHỞ BÒ TÁI','50000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0003','FOOD',N'PHỞ BÒ NẠM','50000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0003','FOOD',N'PHỞ BÒ NẠM','50000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0004','FOOD',N'PHỞ BÒ GÂN','50000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0005','FOOD',N'MÌ TÔM TRỨNG','45000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0006','FOOD',N'BÚN CHẢ','40000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0007','FOOD',N'BÚN CÁ','40000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0008','FOOD',N'BÚN RIÊU','40000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0009','FOOD',N'BÚN BÒ','50000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0010','FOOD',N'BÚN HEO','50000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0011','FOOD',N'Sandtwich','65000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0012','FOOD',N'vegan1','45000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0013','FOOD',N'vegan2','65000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0014','MASSAGE',N'15Minutes','60000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0015','MASSAGE',N'30Minutes','90000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0016','MASSAGE',N'45Minutes','120000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0017','MASSAGE',N'60Minutes','150000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0018','Clean Room',N'Whole Room','200000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0019','Clean Room',N'BED','50000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0020','Clean Room',N'CLEAN DESK','70000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0021','DRINKS',N'COCA COLA','20000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0022','DRINKS',N'PEPSI','20000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0023','DRINKS',N'ORANGE JUICE','350000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0024','DRINKS',N'WHOLE COCONUT','30000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0025','DRINKS',N'KHOANG NGOT','15000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0026','DRINKS',N'BEER','22000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0027','DRINKS',N'RUM','850000')
INSERT INTO nhom3.Services (id_service,name_Service,price_Service) VALUES('SER0028','DRINKS',N'SĂM Banh','1100000')


CREATE Table nhom3.Using_Service(	id_US SMALLINT NOT NULL GENERATED ALWAYS as IDENTITY (START WITH 0 INCREMENT BY 1),	Quantities SMALLINT NOT NULL, Using_Date TIMESTAMP NOT NULL DEFAULT CURRENT TIMESTAMP)
#FOREIGN KEY (ID_US) REFERENCES Services(id_service)
#CHO NAY CAN TEN KHACH HANG VOI SERVICES NỮA
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0001','1','2017-01-25-17-50-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0002','2','2017-01-20-22-00-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0003','4','2017-01-24-22-00-00')
INSERT INTO nhom3.sing_Service (id_US,Quantity,Using_Date) VALUES ('US0004','3','2017-01-25-16-20-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0005','3','2017-01-24-21-00-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0006','2','2017-01-18-15-52-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0007','4','2017-01-17-12-20-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0008','2','2017-01-25-16-10-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0009','1','2017-01-19-00-50-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0010','2','2017-01-25-16-40-00')
INSERT INTO nhom3.Using_Service (id_US,Quantity,Using_Date) VALUES ('US0011','1','2017-01-23-05-20-00')

