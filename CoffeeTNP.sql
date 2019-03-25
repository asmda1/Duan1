USE master
GO

IF EXISTS ( SELECT  *
            FROM    sys.databases
            WHERE   name = 'QLCF' )
    DROP DATABASE QLCF
GO

CREATE DATABASE QLCF
GO

USE QLCF
GO

CREATE TABLE NguoiDung
    (
      maNguoiDung VARCHAR(10) PRIMARY KEY ,
      taiKhoan VARCHAR(20) NOT NULL ,
      matKhau VARCHAR(50) NOT NULL ,
      hoTen NVARCHAR(50) ,
      dienThoai VARCHAR(13) ,
      vaiTro VARCHAR(20) NOT NULL ,
      trangThai BIT not null
    )

	ALTER TABLE dbo.nguoiDung ADD UNIQUE (taiKhoan)

CREATE TABLE KhachHang
    (
      maKh VARCHAR(10) PRIMARY KEY ,
      tenKh NVARCHAR(50) NOT NULL ,
      email VARCHAR(50) ,
      dienThoai VARCHAR(13) NOT NULL ,
      diaChi NVARCHAR(50) ,
      trangThai BIT NOT NULL ,
      diemThuong INT CHECK ( diemThuong >= 0 )
    )

CREATE TABLE HangHoa
    (
      maHangHoa VARCHAR(10) PRIMARY KEY ,
      tenHangHoa NVARCHAR(50),
      donViTinh VARCHAR(10) NOT NULL ,
      soLuong FLOAT NOT NULL ,
      donGia MONEY CHECK ( donGia > 0 )
                   NOT NULL ,
      moTa NVARCHAR(50)
    )



CREATE TABLE PhieuNhap
    (
      maPhieu VARCHAR(10) PRIMARY KEY ,
      maHangHoa VARCHAR(10) NOT NULL ,
      maNhaCungCap VARCHAR(10) NOT NULL ,
	  nguoiNhap VARCHAR(10),
      ngayNhap DATE NOT NULL ,
	  soLuong int check (soLuong > 0) not null,
      tongTien MONEY NOT NULL
    )


CREATE TABLE LoaiSanPham
    (
      maLoai VARCHAR(10) PRIMARY KEY ,
      tenLoai NVARCHAR(30) not null
    )

CREATE TABLE SanPham
    (
      maSp VARCHAR(10) PRIMARY KEY ,
      maLoai VARCHAR(10) not null ,
      maHangHoa VARCHAR(10) not null,
      tenSp NVARCHAR(50) ,
	  giaBan MONEY CHECK (giaBan > 0) NOT NULL ,
	  trangThai BIT NOT NULL,  -- 1 = đang bán, 0 = ko bán sản phẩm này nữa
      hinhAnh VARCHAR(50) 
    )

CREATE TABLE SizeSP
	(
		maSize VARCHAR(5) PRIMARY KEY,
		tenSize NVARCHAR(20) ,
		heSo FLOAT CHECK (heSo > 0) NOT NULL 
	)

	CREATE TABLE Extra
	(
		id VARCHAR(10) PRIMARY KEY,
		ten NVARCHAR(25) NOT NULL ,
		gia MONEY NOT NULL 
	)


CREATE TABLE NhaCungCap
    (
      maNhaCungCap VARCHAR(10) PRIMARY KEY ,
      tenNhaCungCap NVARCHAR(25) NOT NULL ,
      dienThoai VARCHAR(13) ,
      diaChi NVARCHAR(50) NOT null,
      trangThai BIT NOT NULL   -- tinh trang hop tac mua ban
    )

CREATE TABLE HoaDon
    (
      maHD VARCHAR(10) PRIMARY KEY ,
      maNguoiDung VARCHAR(10) NOT NULL ,
      maKH VARCHAR(10) NOT NULL ,
      chietKhau MONEY , --dung khi kh co the hội viên
      ngayHD DATE NOT NULL ,
      tongTien MONEY NOT NULL
                     CHECK ( tongTien > 0 ) ,
      trangThai BIT --Trường sẽ áp dụng cho web ( khach chưa thanh toán), ap mặc định thah toán
	 )



CREATE TABLE CTHoaDon
    (
      maCTHD INT IDENTITY
                 PRIMARY KEY ,
      maHD VARCHAR(10) NOT NULL ,
      maSp VARCHAR(10) NOT NULL ,
	  maSize VARCHAR(5) NOT NULL ,
	  extra VARCHAR(10) NULL,
      soLuong INT NOT NULL
    )


ALTER TABLE dbo.PhieuNhap ADD CONSTRAINT FK_NCC FOREIGN KEY (maNhaCungCap) REFERENCES dbo.NhaCungCap(maNhaCungCap) ON UPDATE CASCADE
ALTER TABLE dbo.PhieuNhap ADD CONSTRAINT FK_HangHoaNhap FOREIGN KEY (maHangHoa) REFERENCES dbo.HangHoa(maHangHoa) ON UPDATE CASCADE
ALTER TABLE dbo.SanPham ADD CONSTRAINT FK_LoaiSP FOREIGN KEY (maLoai) REFERENCES dbo.LoaiSanPham(maLoai) ON UPDATE CASCADE
ALTER TABLE dbo.SanPham ADD CONSTRAINT FK_HangHoa FOREIGN KEY (maHangHoa) REFERENCES dbo.HangHoa(maHangHoa) ON UPDATE CASCADE
ALTER TABLE dbo.HoaDon ADD CONSTRAINT FK_NguoiDung FOREIGN KEY (maNguoiDung) REFERENCES dbo.NguoiDung(maNguoiDung) ON UPDATE CASCADE
ALTER TABLE dbo.HoaDon ADD CONSTRAINT FK_KhachHang FOREIGN KEY (maKH) REFERENCES dbo.KhachHang(maKh) ON UPDATE CASCADE
ALTER TABLE dbo.CTHoaDon ADD CONSTRAINT FK_HoaDon FOREIGN KEY (maHD) REFERENCES dbo.HoaDon ON UPDATE CASCADE
ALTER TABLE dbo.CTHoaDon ADD CONSTRAINT FK_SanPham FOREIGN KEY (maSp) REFERENCES dbo.SanPham(maSp) ON UPDATE CASCADE
ALTER TABLE dbo.PhieuNhap ADD CONSTRAINT FK_NguoiNhap FOREIGN KEY (nguoiNhap) REFERENCES dbo.NguoiDung(maNguoiDung) ON UPDATE CASCADE
ALTER TABLE dbo.CTHoaDon ADD CONSTRAINT FK_Extra FOREIGN KEY (extra) REFERENCES dbo.extra(id) ON UPDATE CASCADE
ALTER TABLE dbo.CTHoaDon ADD CONSTRAINT FK_Size FOREIGN KEY (maSize) REFERENCES dbo.SizeSP(maSize) ON UPDATE CASCADE

------------------------------- THÊM DỮ LIỆU -----------------------------------------

INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH001' , N'Bánh Mì Chả Lựa Xá Xíu' , 'Cái' , 10.0 ,  150000 ,  N'' ) 
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia,moTa) VALUES  ( 'HH002' , N'Bánh Mì Gà Xé Nước Tương' , 'Cái' , 10.0 ,  150000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH003' , N'Bánh Mì Thịt Nướng' , 'Cái' , 10.0 ,  150000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH004' , N'Bánh Mì Xíu Mại '  , 'Cái' , 10.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH005' , N'Coffee' , 'Kg' , 10.0 ,  250000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH006' , N'Trà B' , 'Hộp' , 15.0 ,  40000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH007' , N'Sữa Tươi Không Đường '  , 'Hộp' , 15.0 ,  50000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH008' , N'Kem Béo Thực Vật RICH '  , 'Hộp' , 15.0 ,  30000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH009' , N'Kem Làm Bánh RICH '  , 'Hộp' , 15.0 ,  70000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH010' , N'Bánh Oreo '  , 'Hộp' , 5.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH011' , N'Bánh Chuối '  , 'Cái' , 5.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH012' , N'Bánh Chocolate HighLand '  , 'Cái' , 5.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH013' , N'Bánh Mousse CaCao '  , 'Cái' , 5.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH014' , N'Bánh Caramel Phô Mai '  , 'Cái' , 5.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH015' , N'Bánh Phô Mai Chanh Dây '  , 'Cái' , 5.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH016' , N'Bánh Phô Mai Trà Xanh '  , 'Cái' , 5.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH017' , N'Bánh Tiramisu '  , 'Cái' , 5.0 ,  15000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH018' , N'Hạt Sen Khô'  , 'Kg' , 2.0 ,  200000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH019' , N'Hạt Lựu Khô '  , 'Kg' , 1.0 ,  80000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH020' , N'Đào Ngâm '  , 'Hộp' , 2.0 ,  60000 ,  N'' )
INSERT INTO dbo.HangHoa ( maHangHoa , tenHangHoa ,donViTinh ,soLuong ,donGia ,moTa) VALUES  ( 'HH021' , N'Vải Ngâm '  , 'Hộp' , 2.0 ,  70000 ,  N'' )
 GO 

INSERT INTO dbo.NguoiDung ( maNguoiDung , taiKhoan ,matKhau , hoTen , dienThoai , vaiTro ,trangThai ) VALUES  ( 'ND001' , 'admin' ,'123' ,N'Trần Admin' ,'0911111111' ,'Administration' , 1 )
INSERT INTO dbo.NguoiDung ( maNguoiDung , taiKhoan ,matKhau , hoTen , dienThoai , vaiTro ,trangThai ) VALUES  ( 'ND002' , 'user1' ,'123' ,N'Nguyễn Hiếu Nghĩa' ,'0922222222' ,'Staff' , 1 )
INSERT INTO dbo.NguoiDung ( maNguoiDung , taiKhoan ,matKhau , hoTen , dienThoai , vaiTro ,trangThai ) VALUES  ( 'ND003' , 'user2' ,'123' ,N'Đổ Bảo Trị' ,'0933333333' ,'Staff' , 0 )
 GO
 
INSERT INTO dbo.KhachHang ( maKh , tenKh , email , dienThoai , diaChi , trangThai , diemThuong ) VALUES  ( 'KH001' ,N'Nguyễn Minh Nghĩa' ,'nghiamn@gmail.com' ,'0811111111' ,N'Quận 1' ,1 ,100)
INSERT INTO dbo.KhachHang ( maKh , tenKh , email , dienThoai , diaChi , trangThai , diemThuong ) VALUES  ( 'KH002' ,N'Đổ Văn Trị' ,'trivd@gmail.com' ,'07123456778' ,N'Quận 8' ,1 ,90)
INSERT INTO dbo.KhachHang ( maKh , tenKh , email , dienThoai , diaChi , trangThai , diemThuong ) VALUES  ( 'KH003' ,N'Phạm Minh Hùng' ,'hungpm@gmail.com' ,'0615236985' ,N'Quận Bình Tân' ,1 ,80)
INSERT INTO dbo.KhachHang ( maKh , tenKh , email , dienThoai , diaChi , trangThai , diemThuong ) VALUES  ( 'KH004' ,N'Ngọc Hưng' ,null ,'0753215863' ,N'Thái Nguyên' ,0 ,0)
INSERT INTO dbo.KhachHang ( maKh , tenKh , email , dienThoai , diaChi , trangThai , diemThuong ) VALUES  ( 'KH005' ,N'Nguyễn Phát Thanh' ,'thanhnp@gmail.com' ,'0687125832' ,N'Huyện Bình Chánh' ,1 ,20)
 GO
 
INSERT INTO dbo.LoaiSanPham ( maLoai, tenLoai )VALUES ( 'ML001',N'Coffee') 
INSERT INTO dbo.LoaiSanPham ( maLoai, tenLoai )VALUES ( 'ML002',N'Tea') 
INSERT INTO dbo.LoaiSanPham ( maLoai, tenLoai )VALUES ( 'ML003',N'BanhMi') 
INSERT INTO dbo.LoaiSanPham ( maLoai, tenLoai )VALUES ( 'ML004',N'BanhNgot') 
INSERT INTO dbo.LoaiSanPham ( maLoai, tenLoai )VALUES ( 'ML005',N'Freeze') 
GO

-- Sản phẩm được bán ra với giá của size nhỏ nhất
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP001','ML001','HH005',N'Americano(44)',44000,1 ,'Americano(44).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP002','ML001','HH005',N'Cappuchino(54)',54000,1 ,'Cappuchino(54).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP003','ML001','HH005',N'Caramel Macchiato(59)',59000,1 ,'CaramelMacchiato(59).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP004','ML001','HH005',N'Espersso(44)',44000,1 ,'Espersso(44).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP005','ML001','HH005',N'Latte(54)',54000,1 ,'Latte(54).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP006','ML001','HH005',N'Mocho Macchiato(59)',59000,1 ,'MochoMacchiato(59).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP007','ML001','HH005',N'Phin Đen Đá(29)',29000,1 ,'PhinDenDa(29).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP008','ML001','HH005',N'Phin Đen Nóng(29)',29000,1 ,'PhinDenNong(29).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP009','ML001','HH005',N'Phin Sữa Nóng(29)',29000,1 ,'PhinSuaNong(29).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP010','ML001','HH005',N'Phin Sữa Đá(29)',29000,1 ,'PhinSuaDa(29).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP011','ML005','HH005',N'Caramel Phin Freeze(49)',49000,1 ,'CaramelPhinFreeze(49).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP012','ML005','HH005',N'Classic Phin Freeze(49)',49000,1 ,'ClassicPhinFreeze(49).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP013','ML005','HH005',N'Cookies & Cream(49)',49000,1 ,'Cookies&Cream(49).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP014','ML005','HH005',N'Freeze Chocolate(49)',49000,1 ,'FreezeChocolate(49).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP015','ML005','HH005',N'Freeze Trà Xanh(49)',49000,1 ,'FreezeTraXanh(49).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP016','ML002','HH008',N'Trà Sen Vàng(39)',39000,1 ,'TraSenVang(39).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP017','ML002','HH008',N'Trà Thạch Đào(39)',39000,1 ,'TraThachDao(39).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP018','ML002','HH008',N'Trà Thạch Vải(39)',39000,1 ,'TraThachVai(39).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP019','ML002','HH008',N'Trà Thanh Đào(39)',39000,1 ,'TraThanhDao(39).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP020','ML003','HH005',N'Chả Lụa Xá Xíu(19)',19000,1 ,'ChaLuaXaXiu(19).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP021','ML003','HH005',N'Gà Xé Nước Tương(19)',19000,1 ,'GaXeNuocTuong(19).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP022','ML003','HH005',N'Thịt Nương(19)',19000,1 ,'ThitNuong(19).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP023','ML003','HH005',N'Xíu Mại(19)',19000,1 ,'XiuMai(19).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP024','ML004','HH005',N'Bánh Chuối(19)',19000,1 ,'BanhChuoi(19).jpg')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP025','ML004','HH005',N'Chocolate HighLand(29)',29000,1 ,'ChocolateHighLand(29).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP026','ML004','HH005',N'Mousse CaCao(29)',29000,1 ,'MousseCaCao(29).png')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP027','ML004','HH005',N'Caramel Phô Mai(29))',29000,1 ,'CaramelPhoMai(29).jpg')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP028','ML004','HH005',N'Phô Mai Chanh Dây(29)',29000,1 ,'PhoMaiChanhDay(29).jpg')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP029','ML004','HH005',N'Phô Mai Coffee(29)',29000,1 ,'PhoMaiCoffee(29).jpg')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP030','ML004','HH005',N'Phô Mai Trà Xanh(29)',29000,1 ,'PhoMaiTraXanh(29).jpg')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP031','ML004','HH005',N'Tiramisu(29)',29000,1 ,'Tiramisu(29).jpg')
INSERT INTO dbo.SanPham( maSp,maLoai,maHangHoa,tenSp,giaBan,trangThai,hinhAnh)VALUES ( 'SP032','ML004','HH005',N'Coffee 1kg(235)',235000,1 ,'Coffee1kg(235).png')
GO


INSERT INTO dbo.SizeSP ( maSize, tenSize, heSo ) VALUES  ( 'M',  N'Vừa', 1  )
INSERT INTO dbo.SizeSP ( maSize, tenSize, heSo ) VALUES  ( 'L',  N'Lớn', 1.2  )
INSERT INTO dbo.SizeSP ( maSize, tenSize, heSo ) VALUES  ( 'XL',  N'Siêu lớn', 1.5  )
GO


INSERT INTO dbo.NhaCungCap( maNhaCungCap,tenNhaCungCap,dienThoai,diaChi,trangThai)VALUES ('NCC001',N'Công Ty A','0586326954',N'Long An' ,1)
INSERT INTO dbo.NhaCungCap( maNhaCungCap,tenNhaCungCap,dienThoai,diaChi,trangThai)VALUES ('NCC002',N'Công Ty B','0586326950',N'Quận 10' ,0)
INSERT INTO dbo.NhaCungCap( maNhaCungCap,tenNhaCungCap,dienThoai,diaChi,trangThai)VALUES ('NCC003',N'Công Ty C','0586326955',N'Tây Ninh' ,1)
INSERT INTO dbo.NhaCungCap( maNhaCungCap,tenNhaCungCap,dienThoai,diaChi,trangThai)VALUES ('NCC004',N'Công Ty D','0586326520',N'Quận Thủ Đức' ,1)
INSERT INTO dbo.NhaCungCap( maNhaCungCap,tenNhaCungCap,dienThoai,diaChi,trangThai)VALUES ('NCC005',N'Công Ty E','0584826944',N'Long An' ,0)
GO

INSERT INTO dbo.Extra ( id,ten,gia)VALUES ('EX001',N'Thêm Kem',10000)
INSERT INTO dbo.Extra ( id,ten,gia)VALUES ('EX002',N'Không Đường',0)
INSERT INTO dbo.Extra ( id,ten,gia)VALUES ('EX003',N'Ít Đường',0)
INSERT INTO dbo.Extra ( id,ten,gia)VALUES ('EX004',N'Ít Đá',0)
INSERT INTO dbo.Extra ( id,ten,gia)VALUES ('EX005',N'One Shot',15000)
GO

CREATE VIEW LichSuBanHang AS 
	SELECT tenSp, giaBan, soLuong, ngayHD, tongTien FROM dbo.HoaDon, dbo.CTHoaDon, dbo.SanPham
	WHERE CTHoaDon.maHD = HoaDon.maHD AND CTHoaDon.maSp = SanPham.maSp
	GO
 
SELECT * FROM dbo.LichSuBanHang
GO 

INSERT dbo.HoaDon VALUES  ( '1' , 'ND001' , 'KH001' , 0 , GETDATE() , 500 , 1  )
GO
INSERT dbo.CTHoaDon VALUES  ( '1', 'SP001', 'M', 'EX001', 2  )
GO

INSERT dbo.HoaDon VALUES  ( '2' , 'ND003' , 'KH003' , 0 , GETDATE() , 5000 , 1  )
GO
INSERT dbo.CTHoaDon VALUES  ( '2', 'SP003', 'XL', 'EX003', 5  )
GO   
INSERT dbo.HoaDon VALUES  ( '3' , 'ND001' , 'KH001' , 0 , GETDATE() , 400 , 1  )
GO
INSERT dbo.CTHoaDon VALUES  ( '3', 'SP001', 'M', 'EX001', 2  )
GO

CREATE PROCEDURE SanPhamBanChay AS 
	SELECT CTHoaDon.maSp, tenSp, SUM(soLuong) AS tongSoLuong 
		FROM dbo.CTHoaDon, dbo.SanPham
		WHERE CTHoaDon.maSp = SanPham.maSp
		GROUP BY CTHoaDon.maSp, tenSp
		ORDER BY tongSoLuong DESC
GO

EXEC dbo.SanPhamBanChay
GO



CREATE PROCEDURE DoanhThuTheoSP AS 
SELECT CTHoaDon.maSp, tenSp, giaBan, SUM(soLuong) AS soLuong, SUM(tongTien) AS doanhThu FROM dbo.HoaDon, dbo.CTHoaDon, dbo.SanPham 
	WHERE CTHoaDon.maHD = HoaDon.maHD AND CTHoaDon.maSp = SanPham.maSp
	GROUP BY CTHoaDon.maSp, tenSp, giaBan
	ORDER BY doanhThu DESC
GO

EXEC dbo.DoanhThuTheoSP

SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.CTHoaDon
SELECT maNguoiDung, GETDATE() AS Times FROM dbo.NguoiDung;


INSERT INTO dbo.HoaDon
        ( maHD ,
          maNguoiDung ,
          maKH ,
          chietKhau ,
          ngayHD ,
          tongTien ,
          trangThai
        )
VALUES  ( '' , -- maHD - varchar(10)
          '' , -- maNguoiDung - varchar(10)
          '' , -- maKH - varchar(10)
          NULL , -- chietKhau - money
          GETDATE() , -- ngayHD - date
          NULL , -- tongTien - money
          NULL  -- trangThai - bit
        )

		SELECT * FROM dbo.KhachHang