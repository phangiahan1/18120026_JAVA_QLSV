drop
database qlsv;
create
database qlsv;
use
qlsv;

create table accounts
(
    f_maTK      int not null auto_increment primary key,
    f_taiKhoan  nvarchar(10) not null,
    f_pass      nvarchar(255) not null,
    f_hoTen     nvarchar(255) not null,
    f_ngaySinh  date,
    f_type      int not null,
    f_diaChi    nvarchar(255),
    f_dienThoai nvarchar(12),
    f_gioiTinh  nvarchar(5) check (f_gioiTinh = N'Nam' or f_gioiTinh = N'Nữ')
);

insert into accounts
values (1, 'AD001', '1234', N'Nguyễn Văn A', '1988/6/22', 1, '', '', N'Nam');
insert into accounts
values (2, 'AD002', '1234', N'Trần VĂn B', '1988/6/22', 1, '', '', N'Nam');

insert into accounts
values (3, 'GV001', '1234', N'Đỗ Thị C', '1988/6/22', 2, '', '', N'Nữ');
insert into accounts
values (4, 'GV002', '1234', N'Đỗ Thị D', '1988/6/22', 2, '', '', N'Nữ');
insert into accounts
values (5, 'GV003', '1234', N'Phan Gia Ngân', '2000/6/22', 2, '', '', N'Nữ');

create table class
(
    f_maLH    int not null auto_increment primary key,
    f_tenLH   nvarchar(10),
    f_tongSV  int,
    f_tongNam int,
    f_tongNu  int
);

insert into class
values (1, '18CTT1', 0, 0, 0);
insert into class
values (2, '18CTT2', 0, 0, 0);
insert into class
values (3, '18CTT3', 0, 0, 0);
insert into class
values (4, '18CTT4', 0, 0, 0);
insert into class
values (5, '18CNS1', 0, 0, 0);
insert into class
values (6, '18HH1', 0, 0, 0);
insert into class
values (7, '18CNTN', 0, 0, 0);
insert into class
values (8, '18TH1', 0, 0, 0);

create table accountsStu
(
    f_maTKSV    int not null auto_increment primary key,
    f_taiKhoan  nvarchar(10) not null,
    f_pass      nvarchar(255) not null,
    f_hoTen     nvarchar(255) not null,
    f_ngaySinh  date,
    f_type      int not null,
    f_diaChi    nvarchar(255),
    f_dienThoai nvarchar(12),
    f_gioiTinh  nvarchar(5) check (f_gioiTinh = N'Nam' or f_gioiTinh = N'Nữ'),
    f_maLH      int not null,
    foreign key (f_maLH) references class (f_maLH) on delete cascade
);

insert into accountsStu
values (1, '18120021', '1234', N'Phan Gia Hân', '2000/6/22', 3, '', '', N'Nữ', 1);
insert into accountsStu
values (2, '18120022', '1234', N'Nguyễn Thị Thu Hằng', '2000/6/22', 3, '', '', N'Nữ', 1);
insert into accountsStu
values (3, '18120023', '1234', N'Nguyễn Nam', '2000/6/22', 3, '', '', N'Nam', 1);
insert into accountsStu
values (4, '18120024', '1234', N'Phan Gia Ngọc', '2000/6/22', 3, '', '', N'Nữ', 2);
insert into accountsStu
values (5, '18120025', '1234', N'Nguyễn Nam Dương', '2000/6/22', 3, '', '', N'Nam', 2);
insert into accountsStu
values (6, '18120026', '1234', N'Phan Gia Hân', '2000/6/22', 3, '', '', N'Nữ', 2);
insert into accountsStu
values (7, '18120027', '1234', N'Nguyễn Thị Thu Hằng', '2000/6/22', 3, '', '', N'Nữ', 2);
insert into accountsStu
values (8, '18120028', '1234', N'Nguyễn Nam', '2000/6/22', 3, '', '', N'Nam', 2);
insert into accountsStu
values (9, '18120026', '1234', N'Phan Gia Ngọc', '2000/6/22', 3, '', '', N'Nữ', 3);
insert into accountsStu
values (10, '18120028', '1234', N'Nguyễn Nam Dương', '2000/6/22', 3, '', '', N'Nam', 3);
insert into accountsStu
values (11, '18120029', '1234', N'Nguyễn Nam Nam', '2000/6/22', 3, '', '', N'Nam', 4);
insert into accountsStu
values (12, '18120030', '1234', N'Phan Thị Ngọc', '2000/6/22', 3, '', '', N'Nữ', 4);
insert into accountsStu
values (13, '18120031', '1234', N'Nguyễn Thị Thu', '2000/6/22', 3, '', '', N'Nữ', 5);
insert into accountsStu
values (14, '18120032', '1234', N'Nguyễn Trần Khánh Vân', '2000/6/22', 3, '', '', N'Nữ', 6);
insert into accountsStu
values (15, '18120033', '1234', N'Trần Thị Gia Hân', '2000/6/22', 3, '', '', N'Nữ', 7);
insert into accountsStu
values (16, '18120034', '1234', N'Nguyễn Thu Hằng', '2000/6/22', 3, '', '', N'Nữ', 8);
insert into accountsStu
values (17, '18120035', '1234', N'Trần Khánh Nam', '2000/6/22', 3, '', '', N'Nam', 1);
insert into accountsStu
values (18, '18120036', '1234', N'Phan Thị Hân', '2000/6/22', 3, '', '', N'Nữ', 8);
insert into accountsStu
values (19, '18120037', '1234', N'Nguyễn Thị Thu Ngọc', '2000/6/22', 3, '', '', N'Nữ', 7);
insert into accountsStu
values (20, '18120038', '1234', N'Nguyễn Nam Trai', '2000/6/22', 3, '', '', N'Nam', 6);
insert into accountsStu
values (21, '18120039', '1234', N'Phan Gia Hân', '2000/6/22', 3, '', '', N'Nữ', 6);
insert into accountsStu
values (22, '18120040', '1234', N'Nguyễn Thị Thu Hằng', '2000/6/22', 3, '', '', N'Nữ', 6);
insert into accountsStu
values (23, '18120041', '1234', N'Nguyễn Nam', '2000/6/22', 3, '', '', N'Nam', 4);
insert into accountsStu
values (24, '18120042', '1234', N'Phan Gia Ngọc', '2000/6/22', 3, '', '', N'Nữ', 5);
insert into accountsStu
values (25, '18120043', '1234', N'Nguyễn Nam Dương', '2000/6/22', 3, '', '', N'Nam', 5);
insert into accountsStu
values (26, '18120044', '1234', N'Nguyễn Nam Nam', '2000/6/22', 3, '', '', N'Nam', 4);
insert into accountsStu
values (27, '18120045', '1234', N'Phan Thị Ngọc', '2000/6/22', 3, '', '', N'Nữ', 7);
insert into accountsStu
values (28, '18120046', '1234', N'Nguyễn Thị Thu', '2000/6/22', 3, '', '', N'Nữ', 7);
insert into accountsStu
values (29, '18120047', '1234', N'Nguyễn Trần Khánh Vân', '2000/6/22', 3, '', '', N'Nữ', 7);
insert into accountsStu
values (30, '18120048', '1234', N'Trần Thị Gia Hân', '2000/6/22', 3, '', '', N'Nữ', 4);
insert into accountsStu
values (31, '18120049', '1234', N'Nguyễn Thu Hằng', '2000/6/22', 3, '', '', N'Nữ', 4);
insert into accountsStu
values (32, '18120050', '1234', N'Trần Khánh Nam', '2000/6/22', 3, '', '', N'Nam', 5);
insert into accountsStu
values (33, '18120051', '1234', N'Phan Thị Hân', '2000/6/22', 3, '', '', N'Nữ', 2);
insert into accountsStu
values (34, '18120052', '1234', N'Nguyễn Thị Thu Ngọc', '2000/6/22', 3, '', '', N'Nữ', 2);
insert into accountsStu
values (35, '18120053', '1234', N'Nguyễn Nam Trai', '2000/6/22', 3, '', '', N'Nam', 4);

create table subjects
(
    f_maMH     int not null auto_increment primary key,
    f_idMH     nvarchar(255) not null,
    f_tenMH    nvarchar(255) not null,
    f_soTinChi int not null
);

insert into subjects
values (1, 'MH001', 'Phương pháp tính', 4);
insert into subjects
values (2, 'MH002', 'Lập trình Java', 4);
insert into subjects
values (3, 'MH003', 'Quy hoạch tuyến tính', 4);
insert into subjects
values (4, 'MH004', 'Thiết kế phần mềm', 4);
insert into subjects
values (5, 'MH005', 'Phân tích yêu cầu phần mềm', 4);
insert into subjects
values (6, 'MH006', 'Sinh học đạc cương 1', 3);
insert into subjects
values (7, 'MH007', 'Vật lý đại cương 1', 3);
insert into subjects
values (8, 'MH008', 'Kiến tập nghề nghiệp', 2);
insert into subjects
values (9, 'MH009', 'Toán tổ hợp', 3);
insert into subjects
values (10, 'MH010', 'Thể dục', 2);



-- create table class_student(
-- 	f_maC_S int not null auto_increment primary key,
-- 	f_maTK int not null,
--     f_maLH int not null,
--     foreign key (f_maTK) references accounts(f_maTK) on delete cascade,
--     foreign key (f_maLH) references class(f_maLH) on delete cascade
-- );

-- insert into class_student(f_maTK,f_maLH) values(6,1);
-- insert into class_student(f_maTK,f_maLH) values(7,1);
-- insert into class_student(f_maTK,f_maLH) values(8,4);
-- insert into class_student(f_maTK,f_maLH) values(9,8);
-- insert into class_student(f_maTK,f_maLH) values(10,1);
-- insert into class_student(f_maTK,f_maLH) values(11,2);
-- insert into class_student(f_maTK,f_maLH) values(12,8);
-- insert into class_student(f_maTK,f_maLH) values(13,1);
-- insert into class_student(f_maTK,f_maLH) values(14,1);
-- insert into class_student(f_maTK,f_maLH) values(15,1);
-- insert into class_student(f_maTK,f_maLH) values(16,1);
-- insert into class_student(f_maTK,f_maLH) values(17,8);
-- insert into class_student(f_maTK,f_maLH) values(18,1);
-- insert into class_student(f_maTK,f_maLH) values(19,1);
-- insert into class_student(f_maTK,f_maLH) values(20,1);
-- insert into class_student(f_maTK,f_maLH) values(21,1);
-- insert into class_student(f_maTK,f_maLH) values(22,1);
-- insert into class_student(f_maTK,f_maLH) values(23,1);
-- insert into class_student(f_maTK,f_maLH) values(24,1);
-- insert into class_student(f_maTK,f_maLH) values(25,3);
-- insert into class_student(f_maTK,f_maLH) values(26,4);
-- insert into class_student(f_maTK,f_maLH) values(27,5);
-- insert into class_student(f_maTK,f_maLH) values(28,6);
-- insert into class_student(f_maTK,f_maLH) values(29,3);
-- insert into class_student(f_maTK,f_maLH) values(30,1);
-- insert into class_student(f_maTK,f_maLH) values(31,1);
-- insert into class_student(f_maTK,f_maLH) values(32,3);
-- insert into class_student(f_maTK,f_maLH) values(33,1);
-- insert into class_student(f_maTK,f_maLH) values(34,1);
-- insert into class_student(f_maTK,f_maLH) values(35,7);

create table semester
(
    f_maHK      int  not null auto_increment primary key,
    f_tenHK     nvarchar(5) check (f_tenHK = 'HK1' or f_tenHK = 'HK2' or f_tenHK = 'HK3'),
    f_namHoc    nvarchar(15) not null,
    f_ngayBD    date not null,
    f_ngayKT    date not null,
    f_HKhienTai int
);
insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK1', '2020-2021', '2020/9/1', '2021/1/31', 0);
insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK2', '2020-2021', '2021/3/1', '2021/6/30', 1);
insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK3', '2020-2021', '2021/7/1', '2021/8/31', 0);

insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK1', '2021-2022', '2021/9/1', '2022/1/31', 0);
insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK2', '2021-2022', '2022/3/1', '2022/6/30', 0);
insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK3', '2021-2022', '2022/7/1', '2022/8/31', 0);

insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK1', '2022-2023', '2022/9/1', '2023/1/31', 0);
insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK2', '2022-2023', '2023/3/1', '2023/6/30', 0);
insert into semester(f_tenHK, f_namHoc, f_ngayBD, f_ngayKT, f_HKhienTai)
values ('HK3', '2022-2023', '2023/7/1', '2023/8/31', 0);

create table dkhp
(
    f_maDKHP   int not null auto_increment primary key,
    f_maHK     int not null,
    f_ngayDBDK date,
    f_ngayKTDK date,
    foreign key (f_maHK) references semester (f_maHK)
);
insert into dkhp
values (1, 2, '2021/2/20', '2021/2/27');
insert into dkhp
values (2, 1, '2020/8/20', '2020/8/27');
insert into dkhp
values (3, 2, '2021/3/1', '2021/3/7');

create table course
(
    f_maHP     int not null auto_increment primary key,
    f_maHK     int not null,
    f_maMH     int not null,
    f_idGV     int not null,
    f_phongHoc nvarchar(255),
    f_caHoc    int,
    f_thuHoc   nvarchar(255),
    foreign key (f_maHK) references semester (f_maHK) on delete cascade,
    foreign key (f_maMH) references subjects (f_maMH) on delete cascade,
    foreign key (f_idGV) references accounts (f_maTK) on delete cascade
);

insert into course
values (1, 1, 1, 3, 'E108', 1, N'Thứ 2');
insert into course
values (2, 1, 2, 3, 'E101', 1, N'Thứ 4');
insert into course
values (3, 1, 3, 3, 'E102', 1, N'Thứ 5');
insert into course
values (4, 1, 4, 4, 'E103', 1, N'Thứ 2');
insert into course
values (5, 1, 5, 4, 'E104', 1, N'Thứ 7');
insert into course
values (6, 1, 5, 4, 'E105', 1, N'Thứ 2');
insert into course
values (7, 1, 7, 5, 'E208', 1, N'Thứ 4');
insert into course
values (8, 1, 8, 5, 'E408', 1, N'Thứ 2,Thứ 5');
insert into course
values (9, 1, 9, 5, 'E108', 1, N'Thứ 3');
insert into course
values (10, 1, 10, 5, 'E208', 1, N'Thứ 2,Thứ 7');

create table student_dkhp
(
    f_maHSHP   int not null auto_increment primary key,
    f_maCourse int not null,
    f_maTKSV   int not null,
    foreign key (f_maCourse) references course (f_maHP) on delete cascade,
    foreign key (f_maTKSV) references accountsStu (f_maTKSV) on delete cascade
);
