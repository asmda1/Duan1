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
	  email VARCHAR(50),
      hoTen NVARCHAR(50) ,
      dienThoai VARCHAR(13) ,
      vaiTro VARCHAR(20) NOT NULL ,
      trangThai BIT NOT NULL
    ) 

ALTER TABLE dbo.NguoiDung ADD UNIQUE (taiKhoan)

CREATE TABLE KhachHang
    (
      maKh VARCHAR(10) PRIMARY KEY ,
      tenKh NVARCHAR(50) NOT NULL ,
      matKhau NVARCHAR(50) NOT NULL ,
      email VARCHAR(50) ,
      dienThoai VARCHAR(13),
      diaChi NVARCHAR(50) ,
	  trangThai BIT DEFAULT 0,
      diemThuong INT CHECK ( diemThuong >= 0 )
	 
    )

CREATE TABLE HangHoa
    (
      maHangHoa VARCHAR(10) PRIMARY KEY ,
      tenHangHoa NVARCHAR(50) ,
      donViTinh VARCHAR(10) NOT NULL ,
      soLuong FLOAT NOT NULL ,
      donGia MONEY CHECK ( donGia > 0 )
                   NOT NULL ,
      moTa NVARCHAR(50)
    )



CREATE TABLE PhieuNhap
    (
      maPhieu VARCHAR(10) PRIMARY KEY ,
      maNhaCungCap VARCHAR(10) NOT NULL ,
      nguoiNhap VARCHAR(10) ,
      ngayNhap DATE NOT NULL ,
      tongTien MONEY NOT NULL
    )

CREATE TABLE CTPhieuNhap
    (
      maCTPhieuNhap INT IDENTITY
                        PRIMARY KEY ,
      maPhieu VARCHAR(10) NOT NULL ,
      maHangHoa VARCHAR(10) NOT NULL ,
      soLuong FLOAT CHECK ( soLuong > 0 )
                  NOT NULL ,
	)


CREATE TABLE LoaiSanPham
    (
      maLoai VARCHAR(10) PRIMARY KEY ,
      tenLoai NVARCHAR(30) NOT NULL
    )

CREATE TABLE SanPham
    (
      maSp VARCHAR(10) PRIMARY KEY ,
      maLoai VARCHAR(10) NOT NULL ,
      tenSp NVARCHAR(50) ,
      giaBan MONEY CHECK ( giaBan > 0 )
                   NOT NULL ,
      trangThai BIT NOT NULL ,  -- 1 = đang bán, 0 = ko bán sản phẩm này nữa
      hinhAnh VARCHAR(50)
    )

CREATE TABLE SizeSP
    (
      maSize VARCHAR(5) PRIMARY KEY ,
      tenSize NVARCHAR(20) ,
      heSo FLOAT CHECK ( heSo > 0 )
                 NOT NULL
    )

CREATE TABLE Extra
    (
      id VARCHAR(10) PRIMARY KEY ,
      ten NVARCHAR(25) NOT NULL ,
      gia MONEY NOT NULL
    )


CREATE TABLE NhaCungCap
    (
      maNhaCungCap VARCHAR(10) PRIMARY KEY ,
      tenNhaCungCap NVARCHAR(25) NOT NULL ,
      dienThoai VARCHAR(13) ,
      diaChi NVARCHAR(50) NOT NULL ,
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
      extra VARCHAR(10) NULL ,
      soLuong INT NOT NULL
    )


ALTER TABLE dbo.PhieuNhap ADD CONSTRAINT FK_NCC FOREIGN KEY (maNhaCungCap) REFERENCES dbo.NhaCungCap(maNhaCungCap) ON UPDATE CASCADE
ALTER TABLE dbo.PhieuNhap ADD CONSTRAINT FK_NguoiNhap FOREIGN KEY (nguoiNhap) REFERENCES dbo.NguoiDung(maNguoiDung) ON UPDATE CASCADE
ALTER TABLE dbo.CTPhieuNhap ADD CONSTRAINT FK_HangHoaNhap FOREIGN KEY (maHangHoa) REFERENCES dbo.HangHoa(maHangHoa) ON UPDATE CASCADE
ALTER TABLE dbo.CTPhieuNhap ADD CONSTRAINT FK_MaPhieu FOREIGN KEY (maPhieu) REFERENCES dbo.PhieuNhap(maPhieu) ON UPDATE CASCADE
ALTER TABLE dbo.SanPham ADD CONSTRAINT FK_LoaiSP FOREIGN KEY (maLoai) REFERENCES dbo.LoaiSanPham(maLoai) ON UPDATE CASCADE
ALTER TABLE dbo.HoaDon ADD CONSTRAINT FK_NguoiDung FOREIGN KEY (maNguoiDung) REFERENCES dbo.NguoiDung(maNguoiDung) ON UPDATE CASCADE
ALTER TABLE dbo.HoaDon ADD CONSTRAINT FK_KhachHang FOREIGN KEY (maKH) REFERENCES dbo.KhachHang(maKh) ON UPDATE CASCADE
ALTER TABLE dbo.CTHoaDon ADD CONSTRAINT FK_HoaDon FOREIGN KEY (maHD) REFERENCES dbo.HoaDon ON UPDATE CASCADE
ALTER TABLE dbo.CTHoaDon ADD CONSTRAINT FK_SanPham FOREIGN KEY (maSp) REFERENCES dbo.SanPham(maSp) ON UPDATE CASCADE
ALTER TABLE dbo.CTHoaDon ADD CONSTRAINT FK_Extra FOREIGN KEY (extra) REFERENCES dbo.Extra(id) ON UPDATE CASCADE
ALTER TABLE dbo.CTHoaDon ADD CONSTRAINT FK_Size FOREIGN KEY (maSize) REFERENCES dbo.SizeSP(maSize) ON UPDATE CASCADE

------------------------------- THÊM DỮ LIỆU -----------------------------------------

INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH001' ,
          N'Bánh Mì Chả Lựa Xá Xíu' ,
          'Cái' ,
          10.0 ,
          150000 ,
          N''
        ) 
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH002' ,
          N'Bánh Mì Gà Xé Nước Tương' ,
          'Cái' ,
          10.0 ,
          150000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH003' ,
          N'Bánh Mì Thịt Nướng' ,
          'Cái' ,
          10.0 ,
          150000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH004' ,
          N'Bánh Mì Xíu Mại ' ,
          'Cái' ,
          10.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH005' ,
          N'Coffee' ,
          'Kg' ,
          10.0 ,
          250000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH006' ,
          N'Trà B' ,
          'Hộp' ,
          15.0 ,
          40000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH007' ,
          N'Sữa Tươi Không Đường ' ,
          'Hộp' ,
          15.0 ,
          50000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH008' ,
          N'Kem Béo Thực Vật RICH ' ,
          'Hộp' ,
          15.0 ,
          30000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH009' ,
          N'Kem Làm Bánh RICH ' ,
          'Hộp' ,
          15.0 ,
          70000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH010' ,
          N'Bánh Oreo ' ,
          'Hộp' ,
          5.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH011' ,
          N'Bánh Chuối ' ,
          'Cái' ,
          5.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH012' ,
          N'Bánh Chocolate HighLand ' ,
          'Cái' ,
          5.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH013' ,
          N'Bánh Mousse CaCao ' ,
          'Cái' ,
          5.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH014' ,
          N'Bánh Caramel Phô Mai ' ,
          'Cái' ,
          5.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH015' ,
          N'Bánh Phô Mai Chanh Dây ' ,
          'Cái' ,
          5.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH016' ,
          N'Bánh Phô Mai Trà Xanh ' ,
          'Cái' ,
          5.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH017' ,
          N'Bánh Tiramisu ' ,
          'Cái' ,
          5.0 ,
          15000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH018' ,
          N'Hạt Sen Khô' ,
          'Kg' ,
          2.0 ,
          200000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH019' ,
          N'Hạt Lựu Khô ' ,
          'Kg' ,
          1.0 ,
          80000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH020' ,
          N'Đào Ngâm ' ,
          'Hộp' ,
          2.0 ,
          60000 ,
          N''
        )
INSERT  INTO dbo.HangHoa
        ( maHangHoa ,
          tenHangHoa ,
          donViTinh ,
          soLuong ,
          donGia ,
          moTa
        )
VALUES  ( 'HH021' ,
          N'Vải Ngâm ' ,
          'Hộp' ,
          2.0 ,
          70000 ,
          N''
        )
 GO 

INSERT  INTO dbo.NguoiDung
        ( maNguoiDung ,
          taiKhoan ,
          matKhau ,
		   email,
          hoTen ,
          dienThoai ,
          vaiTro ,
          trangThai
        )
VALUES  ( 'ND001' ,
          'admin' ,
          '123' ,
		   'tridbps08177@fpt.edu.vn',
          N'Đổ Bảo Trị' ,
          '0911111111' ,
          'Administration' ,
          1
        )
INSERT  INTO dbo.NguoiDung
        ( maNguoiDung ,
          taiKhoan ,
          matKhau ,

email,
          hoTen ,
		  
          dienThoai ,
          vaiTro ,
          trangThai
        )
VALUES  ( 'ND002' ,
          'user1' ,
          '123' ,
		    'nghianhps08235@fpt.edu.vn',
          N'Nguyễn Hiếu Nghĩa' ,
          '0922222222' ,
          'Staff' ,
          1
        )
INSERT  INTO dbo.NguoiDung
        ( maNguoiDung ,
          taiKhoan ,
          matKhau ,
		  email,
          hoTen ,
          dienThoai ,
          vaiTro ,
          trangThai
        )
VALUES  ( 'ND003' ,
          'user2' ,
          '123' ,
		  'phongthps08236@fpt.edu.vn',
          N'Trần Huỳnh Phông' ,
          '0933333333' ,
          'Staff' ,
          0
        )
 GO
 INSERT  INTO dbo.NguoiDung
        ( maNguoiDung ,
          taiKhoan ,
          matKhau ,
		  email,
          hoTen ,
          dienThoai ,
          vaiTro ,
          trangThai
        )
VALUES  ( 'ND004' ,
          'user3' ,
          '123' ,
		  'Hunglmps08234@fpt.edu.vn',
          N'Lê Minh Hùng' ,
          '0933333333' ,
          'Staff' ,
          0
        )
 GO

  INSERT  INTO dbo.NguoiDung
        ( maNguoiDung ,
          taiKhoan ,
          matKhau ,
		  email,
          hoTen ,
          dienThoai ,
          vaiTro ,
          trangThai
        )
VALUES  ( 'ND005' ,
          'user4' ,
          '123' ,
		  'datntps08165@fpt.edu.vn',
          N'Nguyễn Tiến Đạt' ,
          '0933343333' ,
          'Staff' ,
          0
        )
 GO
   INSERT  INTO dbo.NguoiDung
        ( maNguoiDung ,
          taiKhoan ,
          matKhau ,
		  email,
          hoTen ,
          dienThoai ,
          vaiTro ,
          trangThai
        )
VALUES  ( 'ND006' ,
          'user5' ,
          '123' ,
		  'quangntmps08166@fpt.edu.vn',
          N'Nguyễn Thị Minh Quang' ,
          '0933343333' ,
          'Staff' ,
          0
        )
 GO
 
 

 INSERT INTO dbo.KhachHang
         ( maKh ,
           tenKh ,
           matKhau ,
           email ,
           dienThoai ,
           diaChi ,
		   trangThai,
           diemThuong
         )
 VALUES  ( 'KH000' ,
           N'Khách lẻ' , 
           N'123' , 
           '' , 
           '' , 
           N'' ,
		   0,
           0 
         )
INSERT  INTO dbo.KhachHang
        ( maKh ,
          tenKh ,
          matKhau ,
          email ,
          dienThoai ,
          diaChi ,
		  trangThai,
          diemThuong
        )
VALUES  ( 'KH001' ,
          N'Nguyễn Minh Nghĩa' ,
          '123' ,
          'nghiamn@gmail.com' ,
          '0811111111' ,
          N'Quận 1' ,
		  1,
          500
        )
INSERT  INTO dbo.KhachHang
        ( maKh ,
          tenKh ,
          matKhau ,
          email ,
          dienThoai ,
          diaChi ,
		   trangThai,
          diemThuong
        )
VALUES  ( 'KH002' ,
          N'Đổ Văn Trị' ,
          '123' ,
          'tridbps08177@fpt.edu.vn' ,
          '012345678910' ,
          N'Quận 8' ,
		  1,
          590
        )
INSERT  INTO dbo.KhachHang
        ( maKh ,
          tenKh ,
          matKhau ,
          email ,
          dienThoai ,
          diaChi ,
		   trangThai,
          diemThuong
        )
VALUES  ( 'KH003' ,
          N'Phạm Minh Hùng' ,
          '123' ,
          'hungpm@gmail.com' ,
          '0615236985' ,
          N'Quận Bình Tân' ,
		  0,
          0
        )
INSERT  INTO dbo.KhachHang
        ( maKh ,
          tenKh ,
          matKhau ,
          email ,
          dienThoai ,
          diaChi ,
		   trangThai,
          diemThuong
        )
VALUES  ( 'KH004' ,
          N'Ngọc Hưng' ,
          '123' ,
          NULL ,
          '0753215863' ,
          N'Thái Nguyên' ,
		  1,
          0
        )
INSERT  INTO dbo.KhachHang
        ( maKh ,
          tenKh ,
          matKhau ,
          email ,
          dienThoai ,
          diaChi ,
		   trangThai,
          diemThuong
        )
VALUES  ( 'KH005' ,
          N'Nguyễn Phát Thanh' ,
          '123' ,
          'thanhnp@gmail.com' ,
          '0687125832' ,
          N'Huyện Bình Chánh' ,
		  1,
          520
        )
 GO
 
INSERT  INTO dbo.LoaiSanPham
        ( maLoai, tenLoai )
VALUES  ( 'ML001', N'Coffee' ) 
INSERT  INTO dbo.LoaiSanPham
        ( maLoai, tenLoai )
VALUES  ( 'ML002', N'Tea' ) 
INSERT  INTO dbo.LoaiSanPham
        ( maLoai, tenLoai )
VALUES  ( 'ML003', N'BanhMi' ) 
INSERT  INTO dbo.LoaiSanPham
        ( maLoai, tenLoai )
VALUES  ( 'ML004', N'BanhNgot' ) 
INSERT  INTO dbo.LoaiSanPham
        ( maLoai, tenLoai )
VALUES  ( 'ML005', N'Freeze' ) 
GO

-- Sản phẩm được bán ra với giá của size nhỏ nhất
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP001' ,
          'ML001' ,
          N'Americano(44)' ,
          44000 ,
          1 ,
          'Americano(44).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP002' ,
          'ML001' ,
          N'Cappuchino(54)' ,
          54000 ,
          1 ,
          'Cappuchino(54).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP003' ,
          'ML001' ,
          N'Caramel Macchiato(59)' ,
          59000 ,
          1 ,
          'CaramelMacchiato(59).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP004' ,
          'ML001' ,
          N'Espersso(44)' ,
          44000 ,
          1 ,
          'Espersso(44).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP005' ,
          'ML001' ,
          N'Latte(54)' ,
          54000 ,
          1 ,
          'Latte(54).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP006' ,
          'ML001' ,
          N'Mocho Macchiato(59)' ,
          59000 ,
          1 ,
          'MochoMacchiato(59).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP007' ,
          'ML001' ,
          N'Phin Đen Đá(29)' ,
          29000 ,
          1 ,
          'PhinDenDa(29).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP008' ,
          'ML001' ,
          N'Phin Đen Nóng(29)' ,
          29000 ,
          1 ,
          'PhinDenNong(29).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP009' ,
          'ML001' ,
          N'Phin Sữa Nóng(29)' ,
          29000 ,
          1 ,
          'PhinSuaNong(29).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP010' ,
          'ML001' ,
          N'Phin Sữa Đá(29)' ,
          29000 ,
          1 ,
          'PhinSuaDa(29).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP011' ,
          'ML005' ,
          N'Caramel Phin Freeze(49)' ,
          49000 ,
          1 ,
          'CaramelPhinFreeze(49).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP012' ,
          'ML005' ,
          N'Classic Phin Freeze(49)' ,
          49000 ,
          1 ,
          'ClassicPhinFreeze(49).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP013' ,
          'ML005' ,
          N'Cookies & Cream(49)' ,
          49000 ,
          1 ,
          'Cookies&Cream(49).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP014' ,
          'ML005' ,
          N'Freeze Chocolate(49)' ,
          49000 ,
          1 ,
          'FreezeChocolate(49).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP015' ,
          'ML005' ,
          N'Freeze Trà Xanh(49)' ,
          49000 ,
          1 ,
          'FreezeTraXanh(49).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP016' ,
          'ML002' ,
          N'Trà Sen Vàng(39)' ,
          39000 ,
          1 ,
          'TraSenVang(39).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP017' ,
          'ML002' ,
          N'Trà Thạch Đào(39)' ,
          39000 ,
          1 ,
          'TraThachDao(39).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP018' ,
          'ML002' ,
          N'Trà Thạch Vải(39)' ,
          39000 ,
          1 ,
          'TraThachVai(39).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP019' ,
          'ML002' ,
          N'Trà Thanh Đào(39)' ,
          39000 ,
          1 ,
          'TraThanhDao(39).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP020' ,
          'ML003' ,
          N'Chả Lụa Xá Xíu(19)' ,
          19000 ,
          1 ,
          'ChaLuaXaXiu(19).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP021' ,
          'ML003' ,
          N'Gà Xé Nước Tương(19)' ,
          19000 ,
          1 ,
          'GaXeNuocTuong(19).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP022' ,
          'ML003' ,
          N'Thịt Nương(19)' ,
          19000 ,
          1 ,
          'ThitNuong(19).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP023' ,
          'ML003' ,
          N'Xíu Mại(19)' ,
          19000 ,
          1 ,
          'XiuMai(19).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP024' ,
          'ML004' ,
          N'Bánh Chuối(19)' ,
          19000 ,
          1 ,
          'BanhChuoi(19).jpg'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP025' ,
          'ML004' ,
          N'Chocolate HighLand(29)' ,
          29000 ,
          1 ,
          'ChocolateHighLand(29).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP026' ,
          'ML004' ,
          N'Mousse CaCao(29)' ,
          29000 ,
          1 ,
          'MousseCaCao(29).png'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP027' ,
          'ML004' ,
          N'Caramel Phô Mai(29))' ,
          29000 ,
          1 ,
          'CaramelPhoMai(29).jpg'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP028' ,
          'ML004' ,
          N'Phô Mai Chanh Dây(29)' ,
          29000 ,
          1 ,
          'PhoMaiChanhDay(29).jpg'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP029' ,
          'ML004' ,
          N'Phô Mai Coffee(29)' ,
          29000 ,
          1 ,
          'PhoMaiCoffee(29).jpg'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP030' ,
          'ML004' ,
          N'Phô Mai Trà Xanh(29)' ,
          29000 ,
          1 ,
          'PhoMaiTraXanh(29).jpg'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP031' ,
          'ML004' ,
          N'Tiramisu(29)' ,
          29000 ,
          1 ,
          'Tiramisu(29).jpg'
        )
INSERT  INTO dbo.SanPham
        ( maSp ,
          maLoai ,
          tenSp ,
          giaBan ,
          trangThai ,
          hinhAnh
        )
VALUES  ( 'SP032' ,
          'ML004' ,
          N'Coffee 1kg(235)' ,
          235000 ,
          1 ,
          'Coffee1kg(235).png'
        )
GO


INSERT  INTO dbo.SizeSP
        ( maSize, tenSize, heSo )
VALUES  ( 'M', N'Vừa', 1 )
INSERT  INTO dbo.SizeSP
        ( maSize, tenSize, heSo )
VALUES  ( 'L', N'Lớn', 1.2 )
INSERT  INTO dbo.SizeSP
        ( maSize, tenSize, heSo )
VALUES  ( 'XL', N'Siêu lớn', 1.5 )
GO


INSERT  INTO dbo.NhaCungCap
        ( maNhaCungCap ,
          tenNhaCungCap ,
          dienThoai ,
          diaChi ,
          trangThai
        )
VALUES  ( 'NCC001' ,
          N'Công Ty A' ,
          '0586326954' ,
          N'Long An' ,
          1
        )
INSERT  INTO dbo.NhaCungCap
        ( maNhaCungCap ,
          tenNhaCungCap ,
          dienThoai ,
          diaChi ,
          trangThai
        )
VALUES  ( 'NCC002' ,
          N'Công Ty B' ,
          '0586326950' ,
          N'Quận 10' ,
          0
        )
INSERT  INTO dbo.NhaCungCap
        ( maNhaCungCap ,
          tenNhaCungCap ,
          dienThoai ,
          diaChi ,
          trangThai
        )
VALUES  ( 'NCC003' ,
          N'Công Ty C' ,
          '0586326955' ,
          N'Tây Ninh' ,
          1
        )
INSERT  INTO dbo.NhaCungCap
        ( maNhaCungCap ,
          tenNhaCungCap ,
          dienThoai ,
          diaChi ,
          trangThai
        )
VALUES  ( 'NCC004' ,
          N'Công Ty D' ,
          '0586326520' ,
          N'Quận Thủ Đức' ,
          1
        )
INSERT  INTO dbo.NhaCungCap
        ( maNhaCungCap ,
          tenNhaCungCap ,
          dienThoai ,
          diaChi ,
          trangThai
        )
VALUES  ( 'NCC005' ,
          N'Công Ty E' ,
          '0584826944' ,
          N'Long An' ,
          0
        )
GO

INSERT  INTO dbo.Extra
        ( id, ten, gia )
VALUES  ( 'EX001', N'Thêm Kem', 10000 )
INSERT  INTO dbo.Extra
        ( id, ten, gia )
VALUES  ( 'EX002', N'Không Đường', 0 )
INSERT  INTO dbo.Extra
        ( id, ten, gia )
VALUES  ( 'EX003', N'Ít Đường', 0 )
INSERT  INTO dbo.Extra
        ( id, ten, gia )
VALUES  ( 'EX004', N'Ít Đá', 0 )
INSERT  INTO dbo.Extra
        ( id, ten, gia )
VALUES  ( 'EX005', N'One Shot', 15000 )
GO

CREATE VIEW LichSuBanHang
AS
    SELECT  tenSp ,
            giaBan ,
            soLuong ,
            ngayHD ,
            tongTien
    FROM    dbo.HoaDon ,
            dbo.CTHoaDon ,
            dbo.SanPham
    WHERE   CTHoaDon.maHD = HoaDon.maHD
            AND CTHoaDon.maSp = SanPham.maSp
	GO
 
SELECT  *
FROM    dbo.LichSuBanHang
GO 

INSERT  dbo.HoaDon
VALUES  ( 'HD001', 'ND001', 'KH001', 0, GETDATE(), 500, 1 )
GO
INSERT  dbo.CTHoaDon
VALUES  ( 'HD001', 'SP001', 'M', 'EX001', 2 )
GO

INSERT  dbo.HoaDon
VALUES  ( 'HD002', 'ND003', 'KH003', 0, GETDATE(), 5000, 1 )
GO
INSERT  dbo.CTHoaDon
VALUES  ( 'HD002', 'SP003', 'XL', 'EX003', 5 )
GO   
INSERT  dbo.HoaDon
VALUES  ( 'HD003', 'ND001', 'KH001', 0, GETDATE(), 400, 1 )
GO
INSERT  dbo.CTHoaDon
VALUES  ( 'HD003', 'SP001', 'M', 'EX001', 2 )
GO

CREATE PROCEDURE SanPhamBanChay
AS
    SELECT  CTHoaDon.maSp ,
            tenSp ,
            SUM(soLuong) AS tongSoLuong
    FROM    dbo.CTHoaDon ,
            dbo.SanPham
    WHERE   CTHoaDon.maSp = SanPham.maSp
    GROUP BY CTHoaDon.maSp ,
            tenSp
    ORDER BY tongSoLuong DESC
GO

EXEC dbo.SanPhamBanChay
GO

CREATE PROCEDURE SoLuongDatMuaTrenWeb
AS
    SELECT  COUNT(maHD) AS soluong
    FROM    dbo.HoaDon
    WHERE   trangThai = 0
GO 
EXEC dbo.SoLuongDatMuaTrenWeb
 GO 
CREATE PROCEDURE DoanhThuTheoSP
AS
    SELECT  CTHoaDon.maSp ,
            tenSp ,
            giaBan ,
            SUM(soLuong) AS soLuong ,
            SUM(tongTien) AS doanhThu
    FROM    dbo.HoaDon ,
            dbo.CTHoaDon ,
            dbo.SanPham
    WHERE   CTHoaDon.maHD = HoaDon.maHD
            AND CTHoaDon.maSp = SanPham.maSp
    GROUP BY CTHoaDon.maSp ,
            tenSp ,
            giaBan
    ORDER BY doanhThu DESC
GO

EXEC dbo.DoanhThuTheoSP

SELECT  *
FROM    dbo.HoaDon
SELECT  *
FROM    dbo.CTHoaDon
SELECT  maNguoiDung ,
        GETDATE() AS Times
FROM    dbo.NguoiDung;
GO 
CREATE PROC HoaDonChuaThanhToan
AS
    SELECT  dbo.HoaDon.maHD ,
            tenSp ,
            CTHoaDon.maSize ,
            giaBan ,
            tenKh ,
            diaChi ,
            dienThoai ,
            tongTien ,
            HoaDon.trangThai
    FROM    dbo.HoaDon
            JOIN dbo.CTHoaDon ON CTHoaDon.maHD = HoaDon.maHD
            JOIN dbo.SanPham ON SanPham.maSp = CTHoaDon.maSp
            JOIN dbo.SizeSP ON SizeSP.maSize = CTHoaDon.maSize
            JOIN dbo.KhachHang ON KhachHang.maKh = HoaDon.maKH
    WHERE   HoaDon.trangThai = 0
GO 

EXEC HoaDonChuaThanhToan
GO 

SELECT  *
FROM    dbo.KhachHang
GO

CREATE PROC KhachDatOnline
AS

    SELECT  maHD ,
            tenKh ,
            dienThoai ,
            diaChi ,
            ngayHD ,
            tongTien,
			HoaDon.trangThai
    FROM    dbo.HoaDon
            JOIN dbo.KhachHang ON KhachHang.maKh = HoaDon.maKH
    WHERE   HoaDon.trangThai =0

GO 

CREATE PROC ChitietKHdatSP (@maHD varchar(10))
AS
BEGIN 
    SELECT  tenSp ,
            giaBan ,
            maSize ,
            soLuong ,
            hinhAnh,
			dbo.Extra.ten
    FROM    dbo.CTHoaDon JOIN dbo.Extra ON Extra.id = CTHoaDon.extra
            JOIN dbo.HoaDon ON HoaDon.maHD = CTHoaDon.maHD
            JOIN dbo.SanPham ON SanPham.maSp = CTHoaDon.maSp

    WHERE   CTHoaDon.maHD = @maHD
	END 
GO 




IF OBJECT_ID('BieuDoDoanhSo') IS NOT NULL
	DROP PROC BieuDoDoanhSo
GO
CREATE PROC BieuDoDoanhSo
	AS BEGIN
		 SELECT month(dbo.hoaDon.ngayHD),year(dbo.hoaDon.ngayHD) , SUM(tongTien) AS tongdoanhthu
                    		FROM dbo.hoaDon JOIN dbo.CTHoaDon
                    			ON CTHoaDon.maHD = hoaDon.maHD JOIN dbo.sanPham
                    				ON SanPham.maSp = CTHoaDon.maSp
                    					GROUP BY month(dbo.hoaDon.ngayHD),year(dbo.hoaDon.ngayHD)
	END
GO

EXEC BieuDoDoanhSo 


SELECT * FROM dbo.KhachHang
SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.CTHoaDon

INSERT INTO dbo.HoaDon
        ( maHD ,
          maNguoiDung ,
          maKH ,
          chietKhau ,
          ngayHD ,
          tongTien ,
          trangThai
        )
VALUES  ( 'HD057' , -- maHD - varchar(10)
          'ND001' , -- maNguoiDung - varchar(10)
          'KH002' , -- maKH - varchar(10)
          NULL , -- chietKhau - money
         '2019-02-22' , -- ngayHD - date
          200090 , -- tongTien - money
          1  -- trangThai - bit
        )

		GO 

		INSERT INTO dbo.CTHoaDon
		        ( maHD, maSp, maSize, extra, soLuong )
		VALUES  ( 'HD057', -- maHD - varchar(10)
		          'SP002', -- maSp - varchar(10)
		          'M', -- maSize - varchar(5)
		          'EX001', -- extra - varchar(10)
		          5  -- soLuong - int
		          )

				  GO 

		INSERT INTO dbo.HoaDon
        ( maHD ,
          maNguoiDung ,
          maKH ,
          chietKhau ,
          ngayHD ,
          tongTien ,
          trangThai
        )
VALUES  ( 'HD058' , -- maHD - varchar(10)
          'ND001' , -- maNguoiDung - varchar(10)
          'KH003' , -- maKH - varchar(10)
          NULL , -- chietKhau - money
         '2019-01-22' , -- ngayHD - date
          200090 , -- tongTien - money
          1  -- trangThai - bit
        )

		GO 

		
		INSERT INTO dbo.CTHoaDon
		        ( maHD, maSp, maSize, extra, soLuong )
		VALUES  ( 'HD058', -- maHD - varchar(10)
		          'SP004', -- maSp - varchar(10)
		          'M', -- maSize - varchar(5)
		          'EX001', -- extra - varchar(10)
		          2  -- soLuong - int
		          )

				  GO 

SELECT DISTINCT dbo.KhachHang.* FROM dbo.KhachHang 
JOIN dbo.HoaDon ON HoaDon.maKH = KhachHang.maKh 
WHERE  KhachHang.maKh  != 'KH000'

SELECT * FROM dbo.KhachHang
SELECT * FROM dbo.NguoiDung where taiKhoan ='admin'
--Bổ sung 

INSERT INTO dbo.Extra
        ( id, ten, gia )
VALUES  ( 'EX000', -- id - varchar(10)
          N'Trống', -- ten - nvarchar(25)
          0.0  -- gia - money
          )

		  GO 
		  SELECT * FROM dbo.HoaDon
		  INSERT INTO dbo.HoaDon
		          ( maHD ,
		            maNguoiDung ,
		            maKH ,
		            chietKhau ,
		            ngayHD ,
		            tongTien ,
		            trangThai
		          )
		  VALUES  ( 'HD073' , -- maHD - varchar(10)
		            'ND002' , -- maNguoiDung - varchar(10)
		            'KH000' , -- maKH - varchar(10)
		            NULL , -- chietKhau - money
		            '2018-01-01' , -- ngayHD - date
		            1540000 , -- tongTien - money
		            1  -- trangThai - bit
		          )

				  GO 
				    SELECT * FROM dbo.HoaDon
		  INSERT INTO dbo.HoaDon
		          ( maHD ,
		            maNguoiDung ,
		            maKH ,
		            chietKhau ,
		            ngayHD ,
		            tongTien ,
		            trangThai
		          )
		  VALUES  ( 'HD074' , -- maHD - varchar(10)
		            'ND002' , -- maNguoiDung - varchar(10)
		            'KH000' , -- maKH - varchar(10)
		            NULL , -- chietKhau - money
		            '2018-02-01' , -- ngayHD - date
		            1040000 , -- tongTien - money
		            1  -- trangThai - bit
		          )

				  GO 

				    INSERT INTO dbo.HoaDon
		          ( maHD ,
		            maNguoiDung ,
		            maKH ,
		            chietKhau ,
		            ngayHD ,
		            tongTien ,
		            trangThai
		          )
		  VALUES  ( 'HD076' , -- maHD - varchar(10)
		            'ND002' , -- maNguoiDung - varchar(10)
		            'KH000' , -- maKH - varchar(10)
		            NULL , -- chietKhau - money
		            '2018-03-07' , -- ngayHD - date
		            1040000 , -- tongTien - money
		            1  -- trangThai - bit
		          )
				  GO 
				  
				    INSERT INTO dbo.HoaDon
		          ( maHD ,
		            maNguoiDung ,
		            maKH ,
		            chietKhau ,
		            ngayHD ,
		            tongTien ,
		            trangThai
		          )
		  VALUES  ( 'HD077' , -- maHD - varchar(10)
		            'ND002' , -- maNguoiDung - varchar(10)
		            'KH000' , -- maKH - varchar(10)
		            NULL , -- chietKhau - money
		            '2019-03-07' , -- ngayHD - date
		            1040000 , -- tongTien - money
		            1  -- trangThai - bit
		          )
				  GO 
				  INSERT INTO dbo.CTHoaDon
				          ( maHD, maSp, maSize, extra, soLuong )
				  VALUES  ( 'HD073', -- maHD - varchar(10)
				            'SP001', -- maSp - varchar(10)
				            'XL', -- maSize - varchar(5)
				            'EX000', -- extra - varchar(10)
				            4  -- soLuong - int
				            )

							GO 
							 INSERT INTO dbo.CTHoaDon
				          ( maHD, maSp, maSize, extra, soLuong )
				  VALUES  ( 'HD074', -- maHD - varchar(10)
				            'SP002', -- maSp - varchar(10)
				            'M', -- maSize - varchar(5)
				            'EX000', -- extra - varchar(10)
				            3  -- soLuong - int
				            )

							GO 

								
							 INSERT INTO dbo.CTHoaDon
				          ( maHD, maSp, maSize, extra, soLuong )
				  VALUES  ( 'HD076', -- maHD - varchar(10)
				            'SP001', -- maSp - varchar(10)
				            'XL', -- maSize - varchar(5)
				            'EX000', -- extra - varchar(10)
				            4  -- soLuong - int
				            )

							

							GO
							
									 INSERT INTO dbo.CTHoaDon
				          ( maHD, maSp, maSize, extra, soLuong )
				  VALUES  ( 'HD077', -- maHD - varchar(10)
				            'SP006', -- maSp - varchar(10)
				            'XL', -- maSize - varchar(5)
				            'EX000', -- extra - varchar(10)
				            4  -- soLuong - int
				            ) 

							GO 
							INSERT INTO dbo.PhieuNhap
							        ( maPhieu ,
							          maNhaCungCap ,
							          nguoiNhap ,
							          ngayNhap ,
							          tongTien
							        )
							VALUES  ( 'MP001' , -- maPhieu - varchar(10)
							          'NCC001' , -- maNhaCungCap - varchar(10)
							          'ND001' , -- nguoiNhap - varchar(10)
							          GETDATE() , -- ngayNhap - date
							          700000  -- tongTien - money
							        )
									GO 
									INSERT INTO dbo.CTPhieuNhap
									        ( maPhieu, maHangHoa, soLuong )
									VALUES  ( 'MP001', -- maPhieu - varchar(10)
									          'HH001', -- maHangHoa - varchar(10)
									          6  -- soLuong - int
									          )
											  	INSERT INTO dbo.CTPhieuNhap
									        ( maPhieu, maHangHoa, soLuong )
									VALUES  ( 'MP001', -- maPhieu - varchar(10)
									          'HH003', -- maHangHoa - varchar(10)
									          2  -- soLuong - int
									          )
									INSERT INTO dbo.PhieuNhap
							        ( maPhieu ,
							          maNhaCungCap ,
							          nguoiNhap ,
							          ngayNhap ,
							          tongTien
							        )
							VALUES  ( 'MP002' , -- maPhieu - varchar(10)
							          'NCC002' , -- maNhaCungCap - varchar(10)
							          'ND002' , -- nguoiNhap - varchar(10)
							          GETDATE() , -- ngayNhap - date
							          700000  -- tongTien - money
							        )
									GO
                                    INSERT INTO dbo.CTPhieuNhap
                                            ( maPhieu, maHangHoa, soLuong )
                                    VALUES  ( 'MP002', -- maPhieu - varchar(10)
                                              'HH006', -- maHangHoa - varchar(10)
                                              6  -- soLuong - int
                                              )
											  GO
                              -- Sửa từ khúc này     
								
								SELECT * FROM dbo.KhachHang
								SELECT COUNT(maPhieu) FROM dbo.PhieuNhap
								GO 
						
								--PROC ctphieu cp tham so
								CREATE PROC proCTPhieuNhap(@maPhieu varchar(10)) 
								AS
                                BEGIN
								SELECT CTPhieuNhap.maPhieu,HangHoa.maHangHoa,tenHangHoa,donGia,tenNhaCungCap,diaChi, CTPhieuNhap.soLuong,tongTien,ngayNhap,nguoiNhap FROM dbo.CTPhieuNhap 
								JOIN dbo.HangHoa ON HangHoa.maHangHoa = CTPhieuNhap.maHangHoa 
								JOIN dbo.PhieuNhap ON
								PhieuNhap.maPhieu = CTPhieuNhap.maPhieu 
								JOIN dbo.NhaCungCap ON NhaCungCap.maNhaCungCap = PhieuNhap.maNhaCungCap
								WHERE CTPhieuNhap.maPhieu =@maPhieu
								END
								GO
                                
								--PROC ctphieu
								CREATE PROC proshowCTPhieuNhap
								AS
                                BEGIN
								SELECT CTPhieuNhap.maPhieu,HangHoa.maHangHoa,tenHangHoa,donGia,tenNhaCungCap,diaChi, CTPhieuNhap.soLuong,tongTien,ngayNhap,nguoiNhap FROM dbo.CTPhieuNhap 
								JOIN dbo.HangHoa ON HangHoa.maHangHoa = CTPhieuNhap.maHangHoa 
								JOIN dbo.PhieuNhap ON
								PhieuNhap.maPhieu = CTPhieuNhap.maPhieu 
								JOIN dbo.NhaCungCap ON NhaCungCap.maNhaCungCap = PhieuNhap.maNhaCungCap

								END
SELECT * FROM dbo.PhieuNhap
GO
SELECT * FROM  dbo.CTPhieuNhap