-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dbo.CTHoaDon`
--

DROP TABLE IF EXISTS `dbo.CTHoaDon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.CTHoaDon` (
  `maCTHD` int(11) DEFAULT NULL,
  `maHD` varchar(5) DEFAULT NULL,
  `maSp` varchar(5) DEFAULT NULL,
  `maSize` varchar(2) DEFAULT NULL,
  `extra` varchar(5) DEFAULT NULL,
  `soLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.CTHoaDon`
--

LOCK TABLES `dbo.CTHoaDon` WRITE;
/*!40000 ALTER TABLE `dbo.CTHoaDon` DISABLE KEYS */;
INSERT INTO `dbo.CTHoaDon` VALUES (1,'HD001','SP001','M','EX001',2),(2,'HD002','SP003','XL','EX003',5),(3,'HD003','SP001','M','EX001',2),(4,'HD004','SP001','M','EX002',2),(5,'HD004','SP005','XL','EX004',2),(6,'HD004','SP002','M','EX001',3),(7,'HD057','SP002','M','EX001',5),(8,'HD058','SP004','M','EX001',2),(9,'HD073','SP001','XL','EX000',4),(10,'HD074','SP002','M','EX000',3),(11,'HD076','SP001','XL','EX000',4),(12,'HD077','SP006','XL','EX000',4),(13,'HD078','SP009','M','EX002',4),(14,'HD079','SP008','M','EX000',4),(15,'HD080','SP009','M','EX002',2);
/*!40000 ALTER TABLE `dbo.CTHoaDon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.CTPhieuNhap`
--

DROP TABLE IF EXISTS `dbo.CTPhieuNhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.CTPhieuNhap` (
  `maCTPhieuNhap` int(11) DEFAULT NULL,
  `maPhieu` varchar(5) DEFAULT NULL,
  `maHangHoa` varchar(5) DEFAULT NULL,
  `soLuong` decimal(2,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.CTPhieuNhap`
--

LOCK TABLES `dbo.CTPhieuNhap` WRITE;
/*!40000 ALTER TABLE `dbo.CTPhieuNhap` DISABLE KEYS */;
INSERT INTO `dbo.CTPhieuNhap` VALUES (1,'MP001','HH001',6.0),(2,'MP001','HH003',2.0),(3,'MP002','HH006',6.0);
/*!40000 ALTER TABLE `dbo.CTPhieuNhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.Extra`
--

DROP TABLE IF EXISTS `dbo.Extra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.Extra` (
  `id` varchar(5) DEFAULT NULL,
  `ten` varchar(12) DEFAULT NULL,
  `gia` decimal(9,4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.Extra`
--

LOCK TABLES `dbo.Extra` WRITE;
/*!40000 ALTER TABLE `dbo.Extra` DISABLE KEYS */;
INSERT INTO `dbo.Extra` VALUES ('EX000','Trống',0.0000),('EX001','Thêm Kem',10000.0000),('EX002','Không Đường',0.0000),('EX003','Ít Đường',0.0000),('EX004','Ít Đá',0.0000),('EX005','One Shot',15000.0000),('EX006','Thêm Caffee',5000.0000),('EX007','Thêm Sữa',5000.0000);
/*!40000 ALTER TABLE `dbo.Extra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.HangHoa`
--

DROP TABLE IF EXISTS `dbo.HangHoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.HangHoa` (
  `maHangHoa` varchar(5) DEFAULT NULL,
  `tenHangHoa` varchar(29) DEFAULT NULL,
  `donViTinh` varchar(4) DEFAULT NULL,
  `soLuong` decimal(3,1) DEFAULT NULL,
  `donGia` decimal(10,4) DEFAULT NULL,
  `moTa` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.HangHoa`
--

LOCK TABLES `dbo.HangHoa` WRITE;
/*!40000 ALTER TABLE `dbo.HangHoa` DISABLE KEYS */;
INSERT INTO `dbo.HangHoa` VALUES ('HH001','Bánh Mì Chả Lựa Xá Xíu','Cái',10.0,150000.0000,''),('HH002','Bánh Mì Gà Xé Nước Tương','Cái',10.0,150000.0000,''),('HH003','Bánh Mì Thịt Nướng','Cái',10.0,150000.0000,''),('HH004','Bánh Mì Xíu Mại ','Cái',10.0,15000.0000,''),('HH005','Coffee','Kg',10.0,250000.0000,''),('HH006','Trà B','Hộp',15.0,40000.0000,''),('HH007','Sữa Tươi Không Đường ','Hộp',15.0,50000.0000,''),('HH008','Kem Béo Thực Vật RICH ','Hộp',15.0,30000.0000,''),('HH009','Kem Làm Bánh RICH ','Hộp',15.0,70000.0000,''),('HH010','Bánh Oreo ','Hộp',5.0,15000.0000,''),('HH011','Bánh Chuối ','Cái',5.0,15000.0000,''),('HH012','Bánh Chocolate HighLand ','Cái',5.0,15000.0000,''),('HH013','Bánh Mousse CaCao ','Cái',5.0,15000.0000,''),('HH014','Bánh Caramel Phô Mai ','Cái',5.0,15000.0000,''),('HH015','Bánh Phô Mai Chanh Dây ','Cái',5.0,15000.0000,''),('HH016','Bánh Phô Mai Trà Xanh ','Cái',5.0,15000.0000,''),('HH017','Bánh Tiramisu ','Cái',5.0,15000.0000,''),('HH018','Hạt Sen Khô','Kg',2.0,200000.0000,''),('HH019','Hạt Lựu Khô ','Kg',1.0,80000.0000,''),('HH020','Đào Ngâm ','Hộp',2.0,60000.0000,''),('HH021','Vải Ngâm ','Hộp',2.0,70000.0000,'');
/*!40000 ALTER TABLE `dbo.HangHoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.HoaDon`
--

DROP TABLE IF EXISTS `dbo.HoaDon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.HoaDon` (
  `maHD` varchar(5) DEFAULT NULL,
  `maNguoiDung` varchar(5) DEFAULT NULL,
  `maKH` varchar(5) DEFAULT NULL,
  `chietKhau` varchar(6) DEFAULT NULL,
  `ngayHD` varchar(10) DEFAULT NULL,
  `tongTien` decimal(11,4) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.HoaDon`
--

LOCK TABLES `dbo.HoaDon` WRITE;
/*!40000 ALTER TABLE `dbo.HoaDon` DISABLE KEYS */;
INSERT INTO `dbo.HoaDon` VALUES ('HD001','ND001','KH001','0.0000','2019-04-18',500.0000,1),('HD002','ND003','KH003','0.0000','2019-04-18',5000.0000,1),('HD003','ND001','KH001','0.0000','2019-04-18',400.0000,1),('HD004','ND003','KH001','0.0000','2019-03-14',12500.0000,1),('HD057','ND001','KH002','','2019-02-22',200090.0000,1),('HD058','ND001','KH003','','2019-01-22',200090.0000,1),('HD073','ND002','KH000','','2018-01-01',1540000.0000,1),('HD074','ND002','KH000','','2018-02-01',1040000.0000,1),('HD076','ND002','KH000','','2018-03-07',1040000.0000,1),('HD077','ND002','KH000','','2019-03-07',5040000.0000,1),('HD078','ND002','KH001','','2017-01-07',1240000.0000,1),('HD079','ND002','KH001','','2017-02-07',2240000.0000,1),('HD080','ND002','KH001','','2017-03-07',2140000.0000,1);
/*!40000 ALTER TABLE `dbo.HoaDon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.KhachHang`
--

DROP TABLE IF EXISTS `dbo.KhachHang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.KhachHang` (
  `maKh` varchar(5) DEFAULT NULL,
  `tenKh` varchar(19) DEFAULT NULL,
  `matKhau` int(11) DEFAULT NULL,
  `email` varchar(23) DEFAULT NULL,
  `dienThoai` varchar(12) DEFAULT NULL,
  `diaChi` varchar(19) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL,
  `diemThuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.KhachHang`
--

LOCK TABLES `dbo.KhachHang` WRITE;
/*!40000 ALTER TABLE `dbo.KhachHang` DISABLE KEYS */;
INSERT INTO `dbo.KhachHang` VALUES ('KH000','Khách lẻ',123,'','','',0,0),('KH001','Nguyễn Minh Nghĩa',123,'nghiamn@gmail.com','0811111111','Quận 1',1,500),('KH002','Đổ Văn Trị',123,'tridbps08177@fpt.edu.vn','012345678910','Quận 8',1,590),('KH003','Phạm Minh Hùng',123,'hungpm@gmail.com','0615236985','Quận Bình Tân',0,0),('KH004','Ngọc Hưng',123,'','0753215863','Thái Nguyên',1,0),('KH005','Nguyễn Phát Thanh',123,'thanhnp@gmail.com','0687125832','Huyện Bình Chánh',1,520);
/*!40000 ALTER TABLE `dbo.KhachHang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.LoaiSanPham`
--

DROP TABLE IF EXISTS `dbo.LoaiSanPham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.LoaiSanPham` (
  `maLoai` varchar(5) DEFAULT NULL,
  `tenLoai` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.LoaiSanPham`
--

LOCK TABLES `dbo.LoaiSanPham` WRITE;
/*!40000 ALTER TABLE `dbo.LoaiSanPham` DISABLE KEYS */;
INSERT INTO `dbo.LoaiSanPham` VALUES ('ML001','Coffee'),('ML002','Tea'),('ML003','BanhMi'),('ML004','BanhNgot'),('ML005','Freeze');
/*!40000 ALTER TABLE `dbo.LoaiSanPham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.NguoiDung`
--

DROP TABLE IF EXISTS `dbo.NguoiDung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.NguoiDung` (
  `maNguoiDung` varchar(5) DEFAULT NULL,
  `taiKhoan` varchar(5) DEFAULT NULL,
  `matKhau` int(11) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `hoTen` varchar(21) DEFAULT NULL,
  `dienThoai` int(11) DEFAULT NULL,
  `vaiTro` varchar(14) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.NguoiDung`
--

LOCK TABLES `dbo.NguoiDung` WRITE;
/*!40000 ALTER TABLE `dbo.NguoiDung` DISABLE KEYS */;
INSERT INTO `dbo.NguoiDung` VALUES ('ND001','admin',123,'tridbps08177@fpt.edu.vn','Đổ Bảo Trị',911111111,'Administration',1),('ND002','user1',123,'nghianhps08235@fpt.edu.vn','Nguyễn Hiếu Nghĩa',922222222,'Staff',1),('ND003','user2',123,'phongthps08236@fpt.edu.vn','Trần Huỳnh Phông',933333333,'Staff',0),('ND004','user3',123,'Hunglmps08234@fpt.edu.vn','Lê Minh Hùng',933333333,'Staff',0),('ND005','user4',123,'datntps08165@fpt.edu.vn','Nguyễn Tiến Đạt',933343333,'Staff',0),('ND006','user5',123,'quangntmps08166@fpt.edu.vn','Nguyễn Thị Minh Quang',933343333,'Staff',0);
/*!40000 ALTER TABLE `dbo.NguoiDung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.NhaCungCap`
--

DROP TABLE IF EXISTS `dbo.NhaCungCap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.NhaCungCap` (
  `maNhaCungCap` varchar(6) DEFAULT NULL,
  `tenNhaCungCap` varchar(38) DEFAULT NULL,
  `dienThoai` int(11) DEFAULT NULL,
  `diaChi` varchar(15) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.NhaCungCap`
--

LOCK TABLES `dbo.NhaCungCap` WRITE;
/*!40000 ALTER TABLE `dbo.NhaCungCap` DISABLE KEYS */;
INSERT INTO `dbo.NhaCungCap` VALUES ('NCC001','Công Ty Sản Xuất Bánh Kẹo Nguyễn Nghĩa',586326954,'Long An',1),('NCC002','Công Ty Trung Nguyên',586326950,'Quận 10',0),('NCC003','Công Ty Trá Lá Dứa',586326955,'Tây Ninh',1),('NCC004','Công Ty Sản Xuất Tiêu Thụ Đường',586326520,'Quận Thủ Đức',1),('NCC005','Công Ty Coffee Hà Nội',584826944,'Long An',0);
/*!40000 ALTER TABLE `dbo.NhaCungCap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.PhieuNhap`
--

DROP TABLE IF EXISTS `dbo.PhieuNhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.PhieuNhap` (
  `maPhieu` varchar(5) DEFAULT NULL,
  `maNhaCungCap` varchar(6) DEFAULT NULL,
  `nguoiNhap` varchar(5) DEFAULT NULL,
  `ngayNhap` varchar(10) DEFAULT NULL,
  `tongTien` decimal(10,4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.PhieuNhap`
--

LOCK TABLES `dbo.PhieuNhap` WRITE;
/*!40000 ALTER TABLE `dbo.PhieuNhap` DISABLE KEYS */;
INSERT INTO `dbo.PhieuNhap` VALUES ('MP001','NCC001','ND001','2019-04-18',700000.0000),('MP002','NCC002','ND002','2019-04-18',700000.0000);
/*!40000 ALTER TABLE `dbo.PhieuNhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.SanPham`
--

DROP TABLE IF EXISTS `dbo.SanPham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.SanPham` (
  `maSp` varchar(5) DEFAULT NULL,
  `maLoai` varchar(5) DEFAULT NULL,
  `tenSp` varchar(23) DEFAULT NULL,
  `giaBan` decimal(10,4) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL,
  `hinhAnh` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.SanPham`
--

LOCK TABLES `dbo.SanPham` WRITE;
/*!40000 ALTER TABLE `dbo.SanPham` DISABLE KEYS */;
INSERT INTO `dbo.SanPham` VALUES ('SP001','ML001','Americano(44)',44000.0000,1,'Americano(44).png'),('SP002','ML001','Cappuchino(54)',54000.0000,1,'Cappuchino(54).png'),('SP003','ML001','Caramel Macchiato(59)',59000.0000,1,'CaramelMacchiato(59).png'),('SP004','ML001','Espersso(44)',44000.0000,1,'Espersso(44).png'),('SP005','ML001','Latte(54)',54000.0000,1,'Latte(54).png'),('SP006','ML001','Mocho Macchiato(59)',59000.0000,1,'MochoMacchiato(59).png'),('SP007','ML001','Phin Đen Đá(29)',29000.0000,1,'PhinDenDa(29).png'),('SP008','ML001','Phin Đen Nóng(29)',29000.0000,1,'PhinDenNong(29).png'),('SP009','ML001','Phin Sữa Nóng(29)',29000.0000,1,'PhinSuaNong(29).png'),('SP010','ML001','Phin Sữa Đá(29)',29000.0000,1,'PhinSuaDa(29).png'),('SP011','ML005','Caramel Phin Freeze(49)',49000.0000,1,'CaramelPhinFreeze(49).png'),('SP012','ML005','Classic Phin Freeze(49)',49000.0000,1,'ClassicPhinFreeze(49).png'),('SP013','ML005','Cookies & Cream(49)',49000.0000,1,'Cookies&Cream(49).png'),('SP014','ML005','Freeze Chocolate(49)',49000.0000,1,'FreezeChocolate(49).png'),('SP015','ML005','Freeze Trà Xanh(49)',49000.0000,1,'FreezeTraXanh(49).png'),('SP016','ML002','Trà Sen Vàng(39)',39000.0000,1,'TraSenVang(39).png'),('SP017','ML002','Trà Thạch Đào(39)',39000.0000,1,'TraThachDao(39).png'),('SP018','ML002','Trà Thạch Vải(39)',39000.0000,1,'TraThachVai(39).png'),('SP019','ML002','Trà Thanh Đào(39)',39000.0000,1,'TraThanhDao(39).png'),('SP020','ML003','Chả Lụa Xá Xíu(19)',19000.0000,1,'ChaLuaXaXiu(19).png'),('SP021','ML003','Gà Xé Nước Tương(19)',19000.0000,1,'GaXeNuocTuong(19).png'),('SP022','ML003','Thịt Nương(19)',19000.0000,1,'ThitNuong(19).png'),('SP023','ML003','Xíu Mại(19)',19000.0000,1,'XiuMai(19).png'),('SP024','ML004','Bánh Chuối(19)',19000.0000,1,'BanhChuoi(19).jpg'),('SP025','ML004','Chocolate HighLand(29)',29000.0000,1,'ChocolateHighLand(29).png'),('SP026','ML004','Mousse CaCao(29)',29000.0000,1,'MousseCaCao(29).png'),('SP027','ML004','Caramel Phô Mai(29))',29000.0000,1,'CaramelPhoMai(29).jpg'),('SP028','ML004','Phô Mai Chanh Dây(29)',29000.0000,1,'PhoMaiChanhDay(29).jpg'),('SP029','ML004','Phô Mai Coffee(29)',29000.0000,1,'PhoMaiCoffee(29).jpg'),('SP030','ML004','Phô Mai Trà Xanh(29)',29000.0000,1,'PhoMaiTraXanh(29).jpg'),('SP031','ML004','Tiramisu(29)',29000.0000,1,'Tiramisu(29).jpg'),('SP032','ML004','Coffee 1kg(235)',235000.0000,1,'Coffee1kg(235).png');
/*!40000 ALTER TABLE `dbo.SanPham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.SizeSP`
--

DROP TABLE IF EXISTS `dbo.SizeSP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.SizeSP` (
  `maSize` varchar(2) DEFAULT NULL,
  `tenSize` varchar(8) DEFAULT NULL,
  `heSo` decimal(2,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.SizeSP`
--

LOCK TABLES `dbo.SizeSP` WRITE;
/*!40000 ALTER TABLE `dbo.SizeSP` DISABLE KEYS */;
INSERT INTO `dbo.SizeSP` VALUES ('L','Lớn',1.2),('M','Vừa',1.0),('XL','Siêu lớn',1.5);
/*!40000 ALTER TABLE `dbo.SizeSP` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-08 22:53:52
