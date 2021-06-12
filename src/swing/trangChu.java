package swing;

import com.toedter.calendar.JDateChooser;
import dao.*;
import hibernate.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class trangChu {
    private static JFrame close;
    private static Accounts acc = null;
    java.util.List<Accounts> rs = AccountDAO.getAllAccounts();
    java.util.List<Accounts> rsGV = null;

    Border dark_gray_border = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY);
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(237, 251, 255));
    //datechosser gv
    JDateChooser dateChooserGv;
    Calendar today = Calendar.getInstance();

    //datechosser sv
    JDateChooser dateChooserSv;

    //datechooser hk
    JDateChooser dateChooserBD;
    JDateChooser dateChooserKT;

    //datechooser dkhp
    JDateChooser dateChooserBDdkhp;
    JDateChooser dateChooserKTdkhp;

    JDateChooser dateChooserBDdkhp1;
    JDateChooser dateChooserKTdkhp1;
    //create array of jLabel
    JLabel[] menuLabels = new JLabel[9];
    //creat array of jPanel
    JPanel[] menuPanels = new JPanel[9];
    private JLabel lbName;
    private JLabel label;
    private JLabel lbThongTin;
    private JLabel lbSV_HP;
    private JLabel lbGiaoVu;
    private JLabel lbSV;
    private JLabel lbDKHP;
    private JLabel lbQLHP;
    private JLabel lbLH;
    private JLabel lbHK;
    private JPanel jpanelHd;
    private JPanel jpanelQl;
    private JPanel mainPanel;
    private JLabel lbMH;
    private JPanel jpThongTin;

    private JTextField tfTen;
    private JTextField tfNS;
    private JTextField tfDC;
    private JTextField tfDT;
    private JTextField tfGT;
    private JPasswordField tfMK;
    //lb
    private JPanel jpGiaoVu;
    private JLabel lbTen;
    private JLabel lbMk;
    private JLabel lbNS;
    private JLabel lbDC;
    private JLabel lbDt;
    private JLabel lbGT;
    //btn
    private JButton btnDangXuat;
    private JButton btnEditThongTin;
    private JButton btnReTT;
    private JPanel jpSV;
    private JPanel jpMonHoc;
    private JPanel jpHK;
    private JPanel jpLopHoc;
    private JPanel jpHP;
    private JPanel jpDKHP;
    private JPanel jpSVHP;
    private JPanel jpSearchGiaoVu;
    ButtonGroup bgmh = new ButtonGroup();
    private JPanel panel;
    private JPasswordField tMkagv;
    private JRadioButton raBtnNamgv;
    private JRadioButton raBtnNugv;
    private JPanel pnNgaySinhGV;
    private JButton btnUpdateGV;
    private JButton btnSaveGV;
    private JButton btnDeleteGV;
    private JButton btnEditGV;
    private JButton btnResetGV;
    private JTextField tTenGV;
    private JPasswordField tMkgv;
    private JTextField tDcgv;
    private JTextField tDtgv;
    private JTextField tTaiKhoanGv;
    private JRadioButton raBtnAdmin;
    private JRadioButton raBtnGv;
    private JTable tableGiaoVu;
    private JTable tableMonhoc;
    private JPanel jpSearchMonhoc;
    private JPanel panelMonhoc;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a6RadioButton;
    private JRadioButton a5RadioButton;
    private JRadioButton a4RadioButton;
    private JRadioButton a3RadioButton;
    private JButton btnResetMH;
    private JButton btnEditMH;
    private JButton btnSaveMH;
    private JButton btnDeleteMH;
    private JTextField tMaMH;
    private JTextField tTenMH;
    private JLabel lMaMH;
    private JLabel lTenMH;
    private JLabel lbSTTMH;
    private JPanel panelMH;
    private JPanel ngayBDHK;
    private JPanel ngayKTHK;
    private JRadioButton HK1RadioButton;
    private JRadioButton HK2RadioButton;
    private JRadioButton HK3RadioButton;
    private JTable tableHK;
    private JPanel panelHK;
    private JTextField tNamHK;
    private JButton btnAddHK;
    private JButton btnEditHK;
    private JButton btnDeleteHK;
    private javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    //cho bang giao vu
    private Accounts selectedAcc;
    private int selectedIndex;
    private JButton btnSetHKHT;
    private JTable tableLopHoc;
    private JPanel panelLH;
    private JTextField tTenLop;
    private JButton btnResetLop;
    private JButton btnAddLop;
    private JButton btnDeleteLop;
    private JTextField tTongSV;
    private JTextField tTongNam;
    private JTextField tTongNu;
    private JTable tableSinhVien;
    private JPanel panelSearchSVtheoLop;
    private JTextField tTaiKhoanSV;
    private JTextField tTenSV;
    private JPasswordField tMKSV;
    private JPanel panelNgaySinhSV;
    private JTextField tDiaChiSV;
    private JTextField tDTSinhVien;
    private JRadioButton raNamSV;
    private JRadioButton raNuSV;
    private JTable tableHocPhan;
    private JPanel panelHocPhan;
    private JButton btnXoaDkhp;
    private JButton btnResetDkhp;
    private JButton btnThemDkhp;
    private JTextField tTenNamHoc_Dkhp;
    private JPanel panelNgayBDKHP;
    private JPanel panelNgayKTDKHP;
    private JRadioButton raHK1_Dkhp;
    private JRadioButton raHK2_Dkhp;
    private JRadioButton raHK3_Dkhp;
    private JTable tableDKHP;
    private JPanel panelDKHP;
    private JTextField tTenGiaoVienHP;
    private JRadioButton rahpT2;
    private JRadioButton rahpT5;
    private JRadioButton rahpT3;
    private JRadioButton rahpT6;
    private JRadioButton rahpT4;
    private JRadioButton rahpT7;
    private JTextField tPhongHocHP;
    private JRadioButton raCa1;
    private JRadioButton raCa2;
    private JRadioButton raCa3;
    private JComboBox comboBoxTenMon;
    private JButton btnResetHP;
    private JButton btnAddHP;
    private JButton btnDelHP;
    private JTextField tMaMonHP;
    private JRadioButton raCa4;
    private JComboBox comboSoTinChi;
    private JTextField tSoSlotHP;
    private JComboBox comboTenGiaoVien;
    private JPanel panelSinhVien;
    private JComboBox comboTenLop;
    private JTextField tSearchSV;
    private JTable tableMonCuaSV;
    private JPanel panelMonCuaSV;
    private JButton btnThemSV;
    private JButton btnXoaSV;
    private JButton btnResetSV;
    private JPanel panelNgayBDkhpHT;
    private JPanel panelNgayKTkhpHT;
    private JTable tableHPSvDk;
    private JPanel panelHPSvDk;
    private JPanel panelHPSvDkSearch;
    private JTextField tSVHPsearch;
    private JButton btnResetMKGV;
    private JTextField tSearchGV;
    private JTextField tSearchMonHoc;
    private JPanel pnSV;
    private JButton btnResetMKSV;
    private JButton btnSuaSV;
    private JTextField tGiaoVuSearch;
    //cho bang môn học
    private Subjects selectedSub;
    private int selectedIndexSub;
    //cho bang môn học
    private Semester selectedSem;
    private int selectedIndexSem;
    //cho bang môn học
    private Clazz selectedClass;
    private int selectedIndexClass;
    //cho bang đăng ký dkhp
    private Dkhp selectedDkhp;
    private int selectedIndexDkhp;
    //cho bang đăng ký hp
    private Course selectedHocPhan;
    private int selectedIndexHocPhan;
    //cho bang sinh viên
    private AccountsStu selectedSV;
    private int selectedIndexSV;
    //Search sv
    private TableRowSorter sorter;
    private TableRowSorter sorter1;
    private TableRowSorter sorter2;
    private TableRowSorter sorter3;


    public trangChu() {
        //Khởi tạo dữ liệu ban đầu, cho bảng thông tin cá nhân
        initALL();
        btnDangXuat.addActionListener(e -> {
            close.dispose();
            dangNhap.init();
        });
        //btn Thông tin cá nhân
        btnEditThongTin.addActionListener(e -> {
            editThongTinCaNhan.init(acc);
        });
        btnReTT.addActionListener(e -> {
            update();
            panel.removeAll();
            showTableGiaoVu();
        });

        //Khởi tạo dữ liệu cho bảng giáo vụ
        initGiaoVu();
        tableGiaoVu.getSelectionModel().addListSelectionListener(e -> {
            if (!tableGiaoVu.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Accounts> rsGV1 = AccountDAO.getAllAccountsGV();
                selectedIndex = tableGiaoVu.convertRowIndexToModel(tableGiaoVu.getSelectedRow());
                selectedAcc = rsGV1.get(selectedIndex);
                if (selectedAcc != null) {
                    tTaiKhoanGv.setText(selectedAcc.getfTaiKhoan());
                    tTenGV.setText(selectedAcc.getfHoTen());
                    tMkgv.setText(selectedAcc.getfPass());
                    tDtgv.setText(selectedAcc.getfDienThoai());
                    tDcgv.setText(selectedAcc.getfDiaChi());
                    if (selectedAcc.getfGioiTinh().equals("Nam")) {
                        raBtnNamgv.setSelected(true);
                        raBtnNugv.setSelected(false);
                    } else {
                        raBtnNugv.setSelected(true);
                        raBtnNamgv.setSelected(false);
                    }
                    if (selectedAcc.getfType() == 1) {
                        raBtnAdmin.setSelected(true);
                        raBtnGv.setSelected(false);
                    } else {
                        raBtnGv.setSelected(true);
                        raBtnAdmin.setSelected(false);
                    }
                    dateChooserGv.setDate(selectedAcc.getfNgaySinh());
                }
            }
        });
        ////btn Giáo vụ
        btnEditGV.addActionListener(e -> {
            java.util.List<Accounts> rsGV2 = AccountDAO.getAllAccountsGV();
            selectedIndex = tableGiaoVu.convertRowIndexToModel(tableGiaoVu.getSelectedRow());
            selectedAcc = rsGV2.get(selectedIndex);
            if (tTenGV.getText().equals("") || String.valueOf(tMkgv.getPassword()).equals("") || tTaiKhoanGv.getText().equals("")) {
                showDialogAgain("Cần nhập đầy đủ: Tài khoản, Mật khẩu, Loại");
            } else {
                selectedAcc.setfPass(String.valueOf(tMkgv.getPassword()));
                selectedAcc.setfDienThoai(tDtgv.getText());
                selectedAcc.setfDiaChi(tDcgv.getText());
                selectedAcc.setfHoTen(tTenGV.getText());
                selectedAcc.setfTaiKhoan(tTaiKhoanGv.getText());
                java.util.Date utilDate = dateChooserGv.getDate();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                selectedAcc.setfNgaySinh(sqlDate);
                if (raBtnNamgv.isSelected()) {
                    selectedAcc.setfGioiTinh("Nam");
                }
                if (raBtnNugv.isSelected()) {
                    selectedAcc.setfGioiTinh("Nữ");
                }
                if (raBtnAdmin.isSelected()) {
                    selectedAcc.setfType(1);
                }
                if (raBtnGv.isSelected()) {
                    selectedAcc.setfType(2);
                }
            }

            if (showDialog()) {
                AccountDAO.updateAccount(selectedAcc);
                showDialogAgain("Edit thành công!!!");
                panel.removeAll();
                showTableGiaoVu();
                initCourse();
                resetTxt();
            } else {
                showDialogAgain("Edit không hoàn thành!!!");
                resetTxt();
            }
        });
        btnResetMKGV.addActionListener(e -> {
            java.util.List<Accounts> rsGV2 = AccountDAO.getAllAccountsGV();
            selectedIndex = tableGiaoVu.convertRowIndexToModel(tableGiaoVu.getSelectedRow());
            selectedAcc = rsGV2.get(selectedIndex);
            if (tTenGV.getText().equals("") || String.valueOf(tMkgv.getPassword()).equals("") || tTaiKhoanGv.getText().equals("")) {
                showDialogAgain("Cần nhập đầy đủ: Tài khoản, Mật khẩu, Loại");
            } else {
                selectedAcc.setfPass("1234");
            }
            AccountDAO.updateAccount(selectedAcc);
            showDialogAgain("Reset mật khẩu thành 1234 !!!");
            panel.removeAll();
            showTableGiaoVu();
            initCourse();
            resetTxt();
        });
        btnResetGV.addActionListener(e -> {
            resetTxt();
        });
        btnSaveGV.addActionListener(e -> {
            Accounts accNew = new Accounts();
            accNew.setfPass(String.valueOf(tMkgv.getPassword()));
            accNew.setfDienThoai(tDtgv.getText());
            accNew.setfDiaChi(tDcgv.getText());
            accNew.setfHoTen(tTenGV.getText());
            accNew.setfTaiKhoan(tTaiKhoanGv.getText());
            java.util.Date utilDate = dateChooserGv.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            accNew.setfNgaySinh(sqlDate);
            if (raBtnNamgv.isSelected()) {
                accNew.setfGioiTinh("Nam");
            }
            if (raBtnNugv.isSelected()) {
                accNew.setfGioiTinh("Nữ");
            }
            if (raBtnAdmin.isSelected()) {
                accNew.setfType(1);
            }
            if (raBtnGv.isSelected()) {
                accNew.setfType(2);
            }
            if (tTenGV.getText().equals("") || String.valueOf(tMkgv.getPassword()).equals("") || tTaiKhoanGv.getText().equals("")) {
                showDialogAgain("Cần nhập đầy đủ: Tài khoản, Mật khẩu, Loại");
            } else {
                if (AccountDAO.isExistedAcc(accNew)) {
                    showDialogAgain("Tài khoản đã tồn tại!!!");
                    resetTxt();
                } else {
                    if (showDialog()) {
                        AccountDAO.saveAccount(accNew);
                        showDialogAgain("Lưu thành công!!!");
                        panel.removeAll();
                        showTableGiaoVu();
                        initCourse();
                        resetTxt();
                    } else {
                        showDialogAgain("Lưu không thành công!!!");
                        resetTxt();
                    }
                }
            }
        });
        btnDeleteGV.addActionListener(e -> {
            java.util.List<Accounts> rsGV1 = AccountDAO.getAllAccountsGV();
            selectedIndex = tableGiaoVu.convertRowIndexToModel(tableGiaoVu.getSelectedRow());
            selectedAcc = rsGV1.get(selectedIndex);

            if (!AccountDAO.isExistedAcc(selectedAcc)) {
                showDialogAgain("Tài khoản không tồn tại!!!");
            } else {
                if (showDialogDelete()) {
                    AccountDAO.deleteAccount(selectedAcc);
                    showDialogAgain("Xóa thành công!!!");
                    panel.removeAll();
                    showTableGiaoVu();
                    initCourse();
                    resetTxt();
                } else {
                    showDialogAgain("Xóa không hoàn thành!!!");
                    resetTxt();
                }
            }
        });

        //Khởi tạo dữ liệu cho bảng môn học
        initMonHoc();
        tableMonhoc.getSelectionModel().addListSelectionListener(e -> {
            if (!tableMonhoc.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Subjects> rsMH = SubjectDAO.getAllSubjects();
                selectedIndexSub = tableMonhoc.convertRowIndexToModel(tableMonhoc.getSelectedRow());
                selectedSub = rsMH.get(selectedIndexSub);
                if (selectedSub != null) {
                    tMaMH.setText(selectedSub.getFidMh());
                    tTenMH.setText(selectedSub.getfTenMh());
                    if (selectedSub.getfSoTinChi() == 1) {
                        a1RadioButton.setSelected(true);
                    }
                    if (selectedSub.getfSoTinChi() == 2) {
                        a2RadioButton.setSelected(true);
                    }
                    if (selectedSub.getfSoTinChi() == 3) {
                        a3RadioButton.setSelected(true);
                    }
                    if (selectedSub.getfSoTinChi() == 4) {
                        a4RadioButton.setSelected(true);
                    }
                    if (selectedSub.getfSoTinChi() == 5) {
                        a5RadioButton.setSelected(true);
                    }
                    if (selectedSub.getfSoTinChi() == 6) {
                        a6RadioButton.setSelected(true);
                    }
                }
            }
        });
        ////btn Môn học
        btnResetMH.addActionListener(e -> {
            tTenMH.setText("");
            tMaMH.setText("");
        });
        btnSaveMH.addActionListener(e -> {
            Subjects newSub = new Subjects();

            newSub.setFidMh(tMaMH.getText());
            newSub.setfTenMh(tTenMH.getText());
            if (a1RadioButton.isSelected()) {
                newSub.setfSoTinChi(1);
            }
            if (a2RadioButton.isSelected()) {
                newSub.setfSoTinChi(2);
            }
            if (a3RadioButton.isSelected()) {
                newSub.setfSoTinChi(3);
            }
            if (a4RadioButton.isSelected()) {
                newSub.setfSoTinChi(4);
            }
            if (a5RadioButton.isSelected()) {
                newSub.setfSoTinChi(5);
            }
            if (a6RadioButton.isSelected()) {
                newSub.setfSoTinChi(6);
            }
            if (tMaMH.getText().equals("") || tTenMH.getText().equals("")) {
                showDialogAgain("Cần nhập đầy đủ: MÃ môn học, Tên môn học, Số tín chỉ");
            } else {
                if (SubjectDAO.isExistedSub(newSub)) {
                    showDialogAgain("Môn học đã tồn tại!!!");
                    tTenMH.setText("");
                    tMaMH.setText("");
                } else {
                    if (showDialog()) {
                        SubjectDAO.saveSub(newSub);
                        showDialogAgain("Lưu thành công!!!");
                        panelMH.removeAll();
                        showTableMonHoc();
                        initCourse();
                        tTenMH.setText("");
                        tMaMH.setText("");
                    } else {
                        showDialogAgain("Lưu không thành công!!!");
                        tTenMH.setText("");
                        tMaMH.setText("");
                    }
                }
            }
        });
        btnDeleteMH.addActionListener(e -> {
            java.util.List<Subjects> rsSU1 = SubjectDAO.getAllSubjects();
            selectedIndexSub = tableMonhoc.convertRowIndexToModel(tableMonhoc.getSelectedRow());
            selectedSub = rsSU1.get(selectedIndexSub);

            if (!SubjectDAO.isExistedSub(selectedSub)) {
                showDialogAgain("Môn học không tồn tại!!!");
            } else {
                if (CourseDAO.isCourseHt(selectedSub)) {
                    showDialogAgain("Môn học đang được đăng ký trong kì hiện tại, Không thể xóa");
                } else {
                    if (showDialogDelete()) {
                        SubjectDAO.deleteSub(selectedSub);
                        showDialogAgain("Xóa thành công!!!");
                        panelMH.removeAll();
                        showTableMonHoc();
                        initCourse();
                        tTenMH.setText("");
                        tMaMH.setText("");
                    } else {
                        showDialogAgain("Xóa không hoàn thành!!!");
                        tTenMH.setText("");
                        tMaMH.setText("");
                    }
                }
            }
        });
        btnEditMH.addActionListener(e -> {
            java.util.List<Subjects> rsSU1 = SubjectDAO.getAllSubjects();
            selectedIndexSub = tableMonhoc.convertRowIndexToModel(tableMonhoc.getSelectedRow());
            selectedSub = rsSU1.get(selectedIndexSub);

            if (tMaMH.getText().equals("") || tTenMH.getText().equals("")) {
                showDialogAgain("Vui lòng điền đầy đủ dữ liệu");
            } else {
                selectedSub.setFidMh(tMaMH.getText());
                selectedSub.setfTenMh(tTenMH.getText());
                if (a1RadioButton.isSelected()) {
                    selectedSub.setfSoTinChi(1);
                }
                if (a2RadioButton.isSelected()) {
                    selectedSub.setfSoTinChi(2);
                }
                if (a3RadioButton.isSelected()) {
                    selectedSub.setfSoTinChi(3);
                }
                if (a4RadioButton.isSelected()) {
                    selectedSub.setfSoTinChi(4);
                }
                if (a5RadioButton.isSelected()) {
                    selectedSub.setfSoTinChi(5);
                }
                if (a6RadioButton.isSelected()) {
                    selectedSub.setfSoTinChi(6);
                }

                if (showDialog()) {
                    SubjectDAO.updateSub(selectedSub);
                    showDialogAgain("Edit thành công!!!");
                    panelMH.removeAll();
                    showTableMonHoc();
                    initCourse();
                    tTenMH.setText("");
                    tMaMH.setText("");
                } else {
                    showDialogAgain("Edit không hoàn thành!!!");
                    tTenMH.setText("");
                    tMaMH.setText("");
                }
            }


        });

        //Khởi tạo dữ liệu học kì
        initHocKi();
        tableHK.getSelectionModel().addListSelectionListener(e -> {
            if (!tableHK.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Semester> rsHK = SemesterDAO.getAllSemester();
                selectedIndexSem = tableHK.convertRowIndexToModel(tableHK.getSelectedRow());
                selectedSem = rsHK.get(selectedIndexSem);
                if (selectedSem != null) {
                    tNamHK.setText(selectedSem.getfNamHoc());
                    if (selectedSem.getfTenHk().equals("HK1")) {
                        HK1RadioButton.setSelected(true);
                    }
                    if (selectedSem.getfTenHk().equals("HK2")) {
                        HK2RadioButton.setSelected(true);
                    }
                    if (selectedSem.getfTenHk().equals("HK3")) {
                        HK3RadioButton.setSelected(true);
                    }
                    dateChooserBD.setDate(selectedSem.getfNgayBd());
                    dateChooserKT.setDate(selectedSem.getfNgayKt());
                }
            }
        });
        btnSetHKHT.addActionListener(e -> {
            java.util.List<Semester> rsHK = SemesterDAO.getAllSemester();
            selectedIndexSem = tableHK.convertRowIndexToModel(tableHK.getSelectedRow());
            selectedSem = rsHK.get(selectedIndexSem);

            if (SemesterDAO.findHocKiHienTai().equals(selectedSem)) {
                showDialogAgain("Học kì đã là học kì hiện tại");
                tNamHK.setText("");
            } else {
                if (showDialogSetHocKi()) {
                    SemesterDAO.setHocKiHienTai(selectedSem);
                    showDialogAgain("Set học kì hiện tại thành công");
                    panelHK.removeAll();
                    showTableHocKi();
                    panelHocPhan.removeAll();
                    showTableHocPhan();
                    panelDKHP.removeAll();
                    showTableDKHP();
                    tNamHK.setText("");

                    //mới thêm
                    panelMonCuaSV.removeAll();
                    showTableSinhVienMonDaDK(selectedSV.getfMaTkSV());
                } else {
                    showDialogAgain("Set học kì hiện tại không thành công");
                    tNamHK.setText("");
                }
            }
        });
        btnEditHK.addActionListener(e -> {
            java.util.List<Semester> rsHK1 = SemesterDAO.getAllSemester();
            selectedIndexSem = tableHK.convertRowIndexToModel(tableHK.getSelectedRow());
            selectedSem = rsHK1.get(selectedIndexSem);

            if (tNamHK.getText().equals("")) {
                showDialogAgain("Vui lòng điền đầy đủ dữ liệu");
            } else {
                selectedSem.setfNamHoc(tNamHK.getText());
                java.util.Date dateBD = dateChooserBD.getDate();
                java.sql.Date sqlDateBD = new java.sql.Date(dateBD.getTime());
                selectedSem.setfNgayBd(sqlDateBD);
                java.util.Date dateKT = dateChooserKT.getDate();
                java.sql.Date sqlDateKT = new java.sql.Date(dateKT.getTime());
                selectedSem.setfNgayKt(sqlDateKT);
                if (HK1RadioButton.isSelected()) {
                    selectedSem.setfTenHk("HK1");
                }
                if (HK2RadioButton.isSelected()) {
                    selectedSem.setfTenHk("HK2");
                }
                if (HK3RadioButton.isSelected()) {
                    selectedSem.setfTenHk("HK3");
                }

                if (showDialog()) {
                    SemesterDAO.updateSemester(selectedSem);
                    panelHK.removeAll();
                    showTableHocKi();
                    tNamHK.setText("");
                } else {
                    showDialogAgain("Chỉnh sửa không thành công");
                    tNamHK.setText("");
                }
            }
        });
        btnAddHK.addActionListener(e -> {
            Semester semester = new Semester();
            semester.setfNamHoc(tNamHK.getText());
            java.util.Date dateBD = dateChooserBD.getDate();
            java.sql.Date sqlDateBD = new java.sql.Date(dateBD.getTime());
            semester.setfNgayBd(sqlDateBD);
            java.util.Date dateKT = dateChooserKT.getDate();
            java.sql.Date sqlDateKT = new java.sql.Date(dateKT.getTime());
            semester.setfNgayKt(sqlDateKT);
            semester.setfHKhienTai(0);
            if (HK1RadioButton.isSelected()) {
                semester.setfTenHk("HK1");
            }
            if (HK2RadioButton.isSelected()) {
                semester.setfTenHk("HK2");
            }
            if (HK3RadioButton.isSelected()) {
                semester.setfTenHk("HK3");
            }

            if (tNamHK.getText().equals("")) {
                showDialogAgain("Vui lòng điền đầy đủ thông tin");
            } else {
                if (showDialog()) {
                    if (SemesterDAO.saveSem(semester)) {
                        showDialogAgain("Lưu học kì thành công");
                        panelHK.removeAll();
                        showTableHocKi();
                        tNamHK.setText("");
                    } else {
                        showDialogAgain("Lưu không thành công");
                    }
                } else {
                    showDialogAgain("Lưu không thành công");
                }
            }
        });
        btnDeleteHK.addActionListener(e -> {
            java.util.List<Semester> rsHK2 = SemesterDAO.getAllSemester();
            selectedIndexSem = tableHK.convertRowIndexToModel(tableHK.getSelectedRow());
            selectedSem = rsHK2.get(selectedIndexSem);

            if (showDialogDelete()) {
                SemesterDAO.deleteSem(selectedSem);
                showDialogAgain("Xóa thành công");
                panelHK.removeAll();
                showTableHocKi();
                tNamHK.setText("");
            } else {
                showDialogAgain("Xóa không thành công");
            }
        });

        //Khởi tạo dữ liệu cho lớp
        showTableLop();
        tableLopHoc.getSelectionModel().addListSelectionListener(e -> {
            if (!tableLopHoc.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Clazz> rsLop = ClazzDAO.getAllClass();
                selectedIndexClass = tableLopHoc.convertRowIndexToModel(tableLopHoc.getSelectedRow());
                selectedClass = rsLop.get(selectedIndexClass);
                if (selectedClass != null) {
                    tTenLop.setText(selectedClass.getfTenLh());
                    tTongSV.setText(String.valueOf(selectedClass.getF_tongSV()));
                    tTongNam.setText(String.valueOf(selectedClass.getF_tongNam()));
                    tTongNu.setText(String.valueOf(selectedClass.getF_tongNu()));
                }
            }
        });
        btnResetLop.addActionListener(e -> {
            tTenLop.setText("");
            tTongSV.setText("");
            tTongNam.setText("");
            tTongNu.setText("");
        });
        btnAddLop.addActionListener(e -> {
            Clazz clazz = new Clazz();
            clazz.setF_tongSV(0);
            clazz.setF_tongNu(0);
            clazz.setF_tongNam(0);

            if (tTenLop.getText().equals("")) {
                showDialogAgain("Vui lòng nhập tên lớp");
            } else {
                if (ClazzDAO.isExists(tTenLop.getText())) {
                    showDialogAgain("Lớp đã tồn tại");
                    tTenLop.setText("");
                    tTongNu.setText("");
                    tTongNam.setText("");
                    tTongSV.setText("");
                } else {
                    clazz.setfTenLh(tTenLop.getText());
                    if (showDialog()) {
                        if (ClazzDAO.saveLop(clazz)) {
                            showDialogAgain("Thêm lớp thành công");
                            comboTenLop.addItem(tTenLop.getText());
                            panelLH.removeAll();
                            tTenLop.setText("");
                            tTongNu.setText("");
                            tTongNam.setText("");
                            tTongSV.setText("");
                            showTableLop();

                        } else {
                            showDialogAgain("Thêm không thành công");
                        }
                    } else {
                        showDialogAgain("Thêm không thành công");
                    }
                }

            }

        });
        btnDeleteLop.addActionListener(e -> {
            java.util.List<Clazz> rsLop1 = ClazzDAO.getAllClass();
            selectedIndexClass = tableLopHoc.convertRowIndexToModel(tableLopHoc.getSelectedRow());
            selectedClass = rsLop1.get(selectedIndexClass);

            if (selectedClass.getF_tongSV() != 0) {
                showDialogAgain("Lớp học có học sinh không thể xóa");
            } else {
                if (showDialogDelete()) {
                    if (ClazzDAO.deleteLop(selectedClass)) {
                        showDialogAgain("Xóa thành công");
                        comboTenLop.removeItem(tTenLop.getText());
                        panelLH.removeAll();
                        tTenLop.setText("");
                        tTongNu.setText("");
                        tTongNam.setText("");
                        tTongSV.setText("");
                        showTableLop();

                    } else {
                        showDialogAgain("Xóa không thành công");
                    }
                } else {
                    showDialogAgain("Xóa không thành công");
                }
            }
        });

        //Khởi tạo dữ liệu cho ddkhp
        initDKHP();
        tableDKHP.getSelectionModel().addListSelectionListener(e -> {
            if (!tableDKHP.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Dkhp> rsDkhp = DkhpDAO.getAllDKHP();
                selectedIndexDkhp = tableDKHP.convertRowIndexToModel(tableDKHP.getSelectedRow());
                selectedDkhp = rsDkhp.get(selectedIndexDkhp);
                if (selectedDkhp != null) {
                    if (selectedDkhp.get_hocki().getfTenHk().equals("HK1")) {
                        raHK1_Dkhp.setSelected(true);
                    }
                    if (selectedDkhp.get_hocki().getfTenHk().equals("HK2")) {
                        raHK2_Dkhp.setSelected(true);
                    }
                    if (selectedDkhp.get_hocki().getfTenHk().equals("HK3")) {
                        raHK3_Dkhp.setSelected(true);
                    }
                    tTenNamHoc_Dkhp.setText(selectedDkhp.get_hocki().getfNamHoc());
                    dateChooserBDdkhp.setDate(selectedDkhp.getfNgayDbdk());
                    dateChooserKTdkhp.setDate(selectedDkhp.getfNgayKtdk());
                }
            }
        });
        btnResetDkhp.addActionListener(e -> {
            resetTXTdkhp();
        });
        btnXoaDkhp.addActionListener(e -> {
            java.util.List<Dkhp> rsdkhp1 = DkhpDAO.getAllDKHP();
            selectedIndexDkhp = tableDKHP.convertRowIndexToModel(tableDKHP.getSelectedRow());
            selectedDkhp = rsdkhp1.get(selectedIndexDkhp);
            if (DkhpDAO.getKiDKHP().getfMaDkhp() == selectedDkhp.getfMaDkhp()) {
                showDialogAgain("Kì đăng ký đang diễn ra không thể xóa");
            } else {
                if (showDialogDelete()) {
                    DkhpDAO.deleteDkhp(selectedDkhp);
                    panelDKHP.removeAll();
                    showTableDKHP();
                    resetTXTdkhp();
                } else showDialogAgain("Xóa không thành công");
            }
        });
        btnThemDkhp.addActionListener(e -> {
            Dkhp dkhp = new Dkhp();
            dkhp.set_hocki(SemesterDAO.findHocKiHienTai());
            dkhp.setfMaHK(SemesterDAO.findHocKiHienTai().getfMaHk());
            java.util.Date utilDateSV = dateChooserBDdkhp1.getDate();
            java.sql.Date sqlDatebd = new java.sql.Date(utilDateSV.getTime());
            dkhp.setfNgayDbdk(sqlDatebd);
            java.util.Date utilDateSV1 = dateChooserKTdkhp1.getDate();
            java.sql.Date sqlDatekt = new java.sql.Date(utilDateSV1.getTime());
            dkhp.setfNgayKtdk(sqlDatekt);
            if (DkhpDAO.getKiDKHP() != null) {
                showDialogAgain("Học kì đã có kì kì đăng kí học phần");
            } else {
                if (showDialog()) {
                    if (DkhpDAO.saveSemDkhp(dkhp)) {
                        showDialogAgain("Thêm thành công");
                        panelDKHP.removeAll();
                        showTableDKHP();
                    }
                }
            }

        });

        //Khởi tạo dữ liệu bảng hoc phần
        initCourse();
        tableHocPhan.getSelectionModel().addListSelectionListener(e -> {
            if (!tableHocPhan.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Course> rshp = CourseDAO.getAllCoursesHienTai();
                selectedIndexHocPhan = tableHocPhan.convertRowIndexToModel(tableHocPhan.getSelectedRow());
                selectedHocPhan = rshp.get(selectedIndexHocPhan);
                if (selectedHocPhan != null) {
                    tMaMonHP.setText(selectedHocPhan.get_monHoc().getFidMh());
                    comboBoxTenMon.setSelectedItem(selectedHocPhan.get_monHoc().getfTenMh());
//                    tTenGiaoVienHP.setText(AccountDAO.getAccount(selectedHocPhan.getfMaGv()).getfHoTen());
                    comboTenGiaoVien.setSelectedItem(AccountDAO.getAccount(selectedHocPhan.getfMaGv()).getfHoTen());
                    tPhongHocHP.setText(selectedHocPhan.getfPhongHoc());
                    comboSoTinChi.setSelectedItem(selectedHocPhan.get_monHoc().getfSoTinChi());
                    tSoSlotHP.setText(String.valueOf(selectedHocPhan.getfSoSlot()));
                    if (selectedHocPhan.getfThuHoc().equals("Thứ 2")) rahpT2.setSelected(true);
                    if (selectedHocPhan.getfThuHoc().equals("Thứ 3")) rahpT3.setSelected(true);
                    if (selectedHocPhan.getfThuHoc().equals("Thứ 4")) rahpT4.setSelected(true);
                    if (selectedHocPhan.getfThuHoc().equals("Thứ 5")) rahpT5.setSelected(true);
                    if (selectedHocPhan.getfThuHoc().equals("Thứ 6")) rahpT6.setSelected(true);
                    if (selectedHocPhan.getfThuHoc().equals("Thứ 7")) rahpT7.setSelected(true);

                    if (selectedHocPhan.getfCaHoc() == 1) raCa1.setSelected(true);
                    if (selectedHocPhan.getfCaHoc() == 2) raCa2.setSelected(true);
                    if (selectedHocPhan.getfCaHoc() == 3) raCa3.setSelected(true);
                    if (selectedHocPhan.getfCaHoc() == 4) raCa4.setSelected(true);

                }
            }
        });
        btnResetHP.addActionListener(e -> {
            ResetTxtHocPhan();
        });
        btnAddHP.addActionListener(e -> {
            Course course = new Course();

            course.setfSoSlot(Integer.parseInt(tSoSlotHP.getText()));

            course.set_monHoc(SubjectDAO.getByTen(comboBoxTenMon.getSelectedItem().toString()));
            course.set_hocKi(SemesterDAO.findHocKiHienTai());

            if (raCa1.isSelected()) course.setfCaHoc(1);
            if (raCa2.isSelected()) course.setfCaHoc(2);
            if (raCa3.isSelected()) course.setfCaHoc(3);
            if (raCa4.isSelected()) course.setfCaHoc(4);

            if (rahpT2.isSelected()) course.setfThuHoc("Thứ 2");
            if (rahpT3.isSelected()) course.setfThuHoc("Thứ 3");
            if (rahpT4.isSelected()) course.setfThuHoc("Thứ 4");
            if (rahpT5.isSelected()) course.setfThuHoc("Thứ 5");
            if (rahpT6.isSelected()) course.setfThuHoc("Thứ 6");
            if (rahpT7.isSelected()) course.setfThuHoc("Thứ 7");

            Accounts accounts = AccountDAO.getAccountbyName(comboTenGiaoVien.getSelectedItem().toString());

            course.setfMaGv(accounts.getfMaTk());
            course.setfMaHk(SemesterDAO.findHocKiHienTai().getfMaHk());
            course.setfPhongHoc(tPhongHocHP.getText());
            course.setfMaMH(SubjectDAO.getByTen(comboBoxTenMon.getSelectedItem().toString()).getfMaMh());

            if (tPhongHocHP.getText().equals("") || comboSoTinChi.getSelectedItem().toString().equals("")
                    || comboBoxTenMon.getSelectedItem().toString().equals("") || comboTenGiaoVien.getSelectedItem().toString().equals("")
                    || tSoSlotHP.getText().equals("")) {
                showDialogAgain("Vui lòng điền đầy đủ thông tin");
            } else {
                if (!CourseDAO.isExisted(course)) {
                    if (showDialog()) {
                        if (CourseDAO.saveCourse(course)) {
                            showDialogAgain("Thêm học thành công");
                            panelHocPhan.removeAll();
                            showTableHocPhan();
                            ResetTxtHocPhan();
                        } else showDialogAgain("Thêm học phần không thành công");
                    } else showDialogAgain("Thêm học phần không thành công");
                } else showDialogAgain("Học phần đã tồn tại");
            }

        });
        btnDelHP.addActionListener(e -> {
            java.util.List<Course> rshp2 = CourseDAO.getAllCoursesHienTai();
            selectedIndexHocPhan = tableHocPhan.convertRowIndexToModel(tableHocPhan.getSelectedRow());
            selectedHocPhan = rshp2.get(selectedIndexHocPhan);

//            if (selectedHocPhan.getF_tongSV() != 0) {
//                showDialogAgain("Lớp học có học sinh không thể xóa");
//            } else {
            if (showDialogDelete()) {
                CourseDAO.deleteCourse(selectedHocPhan);
                showDialogAgain("Xóa thành công");
                panelHocPhan.removeAll();
                showTableHocPhan();
                ResetTxtHocPhan();
            } else {
                showDialogAgain("Xóa không thành công");
            }
            //}
        });

        //Khởi tạo dữ liệu cho bảng sinh viên
        initSinhVien();
        tableSinhVien.getSelectionModel().addListSelectionListener(e -> {
            if (!tableSinhVien.getSelectionModel().isSelectionEmpty()) {
                java.util.List<AccountsStu> rssv = ClassStudentDAO.getAllAcc();
                selectedIndexSV = tableSinhVien.convertRowIndexToModel(tableSinhVien.getSelectedRow());
                selectedSV = rssv.get(selectedIndexSV);
                if (selectedSV != null) {
                    tTaiKhoanSV.setText(selectedSV.getfTaiKhoan());
                    tTenSV.setText(selectedSV.getfHoTen());
                    tMKSV.setText(selectedSV.getfPass());
                    comboTenLop.setSelectedItem(selectedSV.get_lopHoc().getfTenLh());
                    dateChooserSv.setDate(selectedSV.getfNgaySinh());
                    tDiaChiSV.setText(selectedSV.getfDiaChi());
                    tDTSinhVien.setText(selectedSV.getfDienThoai());
                    if (selectedSV.getfGioiTinh().equals("Nam")) {
                        raNamSV.setSelected(true);
                    } else raNuSV.setSelected(true);
                }
                panelMonCuaSV.removeAll();
                showTableSinhVienMonDaDK(selectedSV.getfMaTkSV());
            }
        });
        btnThemSV.addActionListener(e -> {
            AccountsStu accountsStu = new AccountsStu();
            accountsStu.setfHoTen(tTenSV.getText());
            accountsStu.setfTaiKhoan(tTaiKhoanSV.getText());
            accountsStu.setfType(3);
            accountsStu.setfPass(String.valueOf(tMKSV.getPassword()));
            accountsStu.setfDienThoai(tDTSinhVien.getText());
            accountsStu.setfDiaChi(tDiaChiSV.getText());
            if (raNamSV.isSelected())
                accountsStu.setfGioiTinh("Nam");
            else
                accountsStu.setfGioiTinh("Nữ");
            java.util.Date utilDateSV = dateChooserSv.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDateSV.getTime());
            accountsStu.setfNgaySinh(sqlDate);
            accountsStu.set_lopHoc(ClazzDAO.getClassTen(comboTenLop.getSelectedItem().toString()));
            accountsStu.setfMaLop(ClazzDAO.getClassTen(comboTenLop.getSelectedItem().toString()).getfMaLh());
            if (tTenSV.getText().equals("") || String.valueOf(tMKSV.getPassword()).equals("") || comboTenLop.getSelectedItem().toString().equals("")) {
                showDialogAgain("Vui lòng nhập đầy đủ thông tin");
            } else {
                if (ClassStudentDAO.isExistedAcc(accountsStu)) {
                    showDialogAgain("Tài khoản đã tồn tại");
                } else {
                    if (showDialog()) {
                        if (ClassStudentDAO.saveAccount(accountsStu)) {
                            showDialogAgain("Thên thành công");
                            panelSinhVien.removeAll();
                            showTableSinhVienAll();
                            panelLH.removeAll();
                            showTableLop();
                            resetTxtSinhVien();
                        } else showDialogAgain("Thêm sinh viên thất bại");
                    } else showDialogAgain("Thêm sinh viên thất bại");
                }
            }
        });
        btnXoaSV.addActionListener(e -> {
            java.util.List<AccountsStu> rssv = ClassStudentDAO.getAllAcc();
            selectedIndexSV = tableSinhVien.convertRowIndexToModel(tableSinhVien.getSelectedRow());
            selectedSV = rssv.get(selectedIndexSV);

            if (selectedSV != null) {
                if (showDialogDelete()) {
                    ClassStudentDAO.deleteAccount(selectedSV);
                    showDialogAgain("Xóa thành công");
                    panelSinhVien.removeAll();
                    showTableSinhVienAll();
                    panelLH.removeAll();
                    showTableLop();
                    resetTxtSinhVien();
                } else showDialogAgain("Xóa không thành công");
            }
        });
        btnSuaSV.addActionListener(e -> {
            java.util.List<AccountsStu> rssv = ClassStudentDAO.getAllAcc();
            selectedIndexSV = tableSinhVien.convertRowIndexToModel(tableSinhVien.getSelectedRow());
            selectedSV = rssv.get(selectedIndexSV);

            selectedSV.setfHoTen(tTenSV.getText());
            selectedSV.setfTaiKhoan(tTaiKhoanSV.getText());
            selectedSV.setfPass(String.valueOf(tMKSV.getPassword()));
            selectedSV.setfDienThoai(tDTSinhVien.getText());
            selectedSV.setfDiaChi(tDiaChiSV.getText());
            if (raNamSV.isSelected())
                selectedSV.setfGioiTinh("Nam");
            else
                selectedSV.setfGioiTinh("Nữ");
            java.util.Date utilDateSV = dateChooserSv.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDateSV.getTime());
            selectedSV.setfNgaySinh(sqlDate);
            selectedSV.set_lopHoc(ClazzDAO.getClassTen(comboTenLop.getSelectedItem().toString()));
            selectedSV.setfMaLop(ClazzDAO.getClassTen(comboTenLop.getSelectedItem().toString()).getfMaLh());
            if (tTenSV.getText().equals("") || String.valueOf(tMKSV.getPassword()).equals("") || comboTenLop.getSelectedItem().toString().equals("")) {
                showDialogAgain("Vui lòng nhập đầy đủ thông tin");
            } else {
                if (showDialog()) {
                    ClassStudentDAO.updateAccount(selectedSV);
                    showDialogAgain("Sửa thành công");
                    panelSinhVien.removeAll();
                    showTableSinhVienAll();
                    panelLH.removeAll();
                    showTableLop();
                    resetTxtSinhVien();
                } else showDialogAgain("Sửa sinh viên thất bại");
            }
        });
        btnResetSV.addActionListener(e -> {
            resetTxtSinhVien();
        });
        btnResetMKSV.addActionListener(e -> {
            java.util.List<AccountsStu> rssv = ClassStudentDAO.getAllAcc();
            selectedIndexSV = tableSinhVien.convertRowIndexToModel(tableSinhVien.getSelectedRow());
            selectedSV = rssv.get(selectedIndexSV);
            selectedSV.setfPass("1234");

            if (selectedSV != null) {
                ClassStudentDAO.updateAccount(selectedSV);
                showDialogAgain("Reset mật khẩu thành 1234");
                panelSinhVien.removeAll();
                showTableSinhVienAll();
                panelLH.removeAll();
                showTableLop();
                resetTxtSinhVien();
            }

        });

        //Kiểm tra sv đăng ký học phần
        initSvDkHp();

    }

    //Hàm init ban đầu
    public static void init(Accounts account) {
        acc = account;
        JFrame frame = new JFrame("trangChu");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new trangChu().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        close = frame;
        frame.setVisible(true);
    }

    //------------------------Các hàm init------------------------------------------------------------------------------
    //Hàm init Trang chủ + Thông tin cá nhân
    public void initALL() {
        //set text cho thong tin ca nhan
        lbName.setText(acc.getfTaiKhoan());
        tfDC.setText(acc.getfDiaChi());
        tfDT.setText(acc.getfDienThoai());
        tfGT.setText(acc.getfGioiTinh());
        tfNS.setText("" + acc.getfNgaySinh());
        tfTen.setText(acc.getfHoTen());
        tfMK.setText(acc.getfPass());
        //main menu
        menuLabels[0] = lbThongTin;
        menuLabels[1] = lbGiaoVu;
        menuLabels[2] = lbSV;
        menuLabels[3] = lbMH;
        menuLabels[4] = lbHK;
        menuLabels[5] = lbLH;
        menuLabels[6] = lbQLHP;
        menuLabels[7] = lbDKHP;
        menuLabels[8] = lbSV_HP;
        //main panel
        menuPanels[0] = jpThongTin;
        menuPanels[1] = jpGiaoVu;
        menuPanels[2] = jpSV;
        menuPanels[3] = jpMonHoc;
        menuPanels[4] = jpHK;
        menuPanels[5] = jpLopHoc;
        menuPanels[6] = jpHP;
        menuPanels[7] = jpDKHP;
        menuPanels[8] = jpSVHP;
    }

    //init Giáo vụ
    public void initGiaoVu() {
        showTableGiaoVu();

        addActionToMenuLabels();
        showPAnel(jpThongTin);
        //add radio button
        ButtonGroup bggv = new ButtonGroup();
        bggv.add(raBtnNamgv);
        bggv.add(raBtnNugv);

        ButtonGroup loaiGv = new ButtonGroup();
        loaiGv.add(raBtnAdmin);
        loaiGv.add(raBtnGv);

        raBtnAdmin.setSelected(true);
        raBtnNamgv.setSelected(true);

        //add JDateChooser
        dateChooserSv = new JDateChooser(today.getTime());
        dateChooserSv.setDateFormatString("yyyy-MM-dd");
        panelNgaySinhSV.add(dateChooserSv);

        //thêm search
        tSearchGV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(tSearchGV.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(tSearchGV.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(tSearchGV.getText());
            }

            public void search(String str) {
                if (str.length() == 0) {
                    sorter2.setRowFilter(null);
                } else {
                    sorter2.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });
    }

    //init Giáo vụ
    public void initMonHoc() {
        showTableMonHoc();
        //add radio button
        bgmh.add(a1RadioButton);
        bgmh.add(a2RadioButton);
        bgmh.add(a3RadioButton);
        bgmh.add(a4RadioButton);
        bgmh.add(a5RadioButton);
        bgmh.add(a6RadioButton);

        a1RadioButton.setSelected(true);

        tSearchMonHoc.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(tSearchMonHoc.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(tSearchMonHoc.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(tSearchMonHoc.getText());
            }

            public void search(String str) {
                if (str.length() == 0) {
                    sorter3.setRowFilter(null);
                } else {
                    sorter3.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });
    }

    //init Học kì
    public void initHocKi() {
        showTableHocKi();
        ButtonGroup bghk = new ButtonGroup();
        //add radio button
        bghk.add(HK1RadioButton);
        bghk.add(HK2RadioButton);
        bghk.add(HK3RadioButton);

        HK1RadioButton.setSelected(true);

        dateChooserBD = new JDateChooser(today.getTime());
        dateChooserKT = new JDateChooser(today.getTime());
        dateChooserBD.setDateFormatString("yyyy-MM-dd");
        dateChooserKT.setDateFormatString("yyyy-MM-dd");
        ngayBDHK.add(dateChooserBD);
        ngayKTHK.add(dateChooserKT);
    }

    //init các kì đkhp
    public void initDKHP() {
        showTableDKHP();
        ButtonGroup dkhp = new ButtonGroup();
        dkhp.add(raHK1_Dkhp);
        dkhp.add(raHK2_Dkhp);
        dkhp.add(raHK3_Dkhp);
        raHK1_Dkhp.setSelected(true);

        dateChooserBDdkhp = new JDateChooser(today.getTime());
        dateChooserKTdkhp = new JDateChooser(today.getTime());
        dateChooserBDdkhp.setDateFormatString("yyyy-MM-dd");
        dateChooserKTdkhp.setDateFormatString("yyyy-MM-dd");
        panelNgayBDKHP.add(dateChooserBDdkhp);
        panelNgayKTDKHP.add(dateChooserKTdkhp);

        dateChooserBDdkhp1 = new JDateChooser(today.getTime());
        dateChooserKTdkhp1 = new JDateChooser(today.getTime());
        dateChooserBDdkhp1.setDateFormatString("yyyy-MM-dd");
        dateChooserKTdkhp1.setDateFormatString("yyyy-MM-dd");
        panelNgayBDkhpHT.add(dateChooserBDdkhp1);
        panelNgayKTkhpHT.add(dateChooserKTdkhp1);
    }

    //init Courses
    public void initCourse() {
        showTableHocPhan();
        for (Subjects subjects : SubjectDAO.getAllSubjects()) {
            comboBoxTenMon.addItem(subjects.getfTenMh());
        }
        tSoSlotHP.setText("120");
        ActionListener actionListenerForTenMon = e -> {
            String s = (String) comboBoxTenMon.getSelectedItem();
            comboSoTinChi.setSelectedItem(SubjectDAO.getByTen(s).getfSoTinChi());
            tMaMonHP.setText(SubjectDAO.getByTen(s).getFidMh());
        };
        comboBoxTenMon.addActionListener(actionListenerForTenMon);
        for (int i = 1; i < 7; i++) {
            comboSoTinChi.addItem(i);
        }


        for (Accounts accounts : AccountDAO.getAllAccountsGiaoVien()) {
            comboTenGiaoVien.addItem(accounts.getfHoTen());
        }

        ButtonGroup buttonGroupCaHoc = new ButtonGroup();
        buttonGroupCaHoc.add(raCa1);
        buttonGroupCaHoc.add(raCa2);
        buttonGroupCaHoc.add(raCa3);
        buttonGroupCaHoc.add(raCa4);
        ButtonGroup buttonGroupThuHoc = new ButtonGroup();
        buttonGroupThuHoc.add(rahpT2);
        buttonGroupThuHoc.add(rahpT3);
        buttonGroupThuHoc.add(rahpT4);
        buttonGroupThuHoc.add(rahpT5);
        buttonGroupThuHoc.add(rahpT6);
        buttonGroupThuHoc.add(rahpT7);

        PlainDocument doc = (PlainDocument) tSoSlotHP.getDocument();
        doc.setDocumentFilter(new MyIntFilter());
    }

    //init Sinh Viên
    public void initSinhVien() {
        showTableSinhVienAll();
        //add JDateChooser
        dateChooserGv = new JDateChooser(today.getTime());
        dateChooserGv.setDateFormatString("yyyy-MM-dd");
        pnNgaySinhGV.add(dateChooserGv);

        ButtonGroup g = new ButtonGroup();
        g.add(raNamSV);
        g.add(raNuSV);
        raNamSV.setSelected(true);

        for (Clazz clazz : ClazzDAO.getAllClass()) {
            comboTenLop.addItem(clazz.getfTenLh());
        }

        tSearchSV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(tSearchSV.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(tSearchSV.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(tSearchSV.getText());
            }

            public void search(String str) {
                if (str.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });
    }

    //init Kiểm tra sv đã đăng ký học phần
    public void initSvDkHp() {
        showTableSinhVienHocPhan();
        tSVHPsearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(tSVHPsearch.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(tSVHPsearch.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(tSVHPsearch.getText());
            }

            public void search(String str) {
                if (str.length() == 0) {
                    sorter1.setRowFilter(null);
                } else {
                    sorter1.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });
    }

    //------------------------Các hàm và menu Panel---------------------------------------------------------------------
    public void addActionToMenuLabels() {
        Component[] components = jpanelQl.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setLabelBackround(label);
                        switch (label.getText().trim()) {
                            case "Thông tin cá nhân":
                                showPAnel(jpThongTin);
                                break;
                            case "Quản lý Giáo vụ":
                                showPAnel(jpGiaoVu);
                                break;
                            case "Quản lý Sinh Viên":
                                showPAnel(jpSV);
                                break;
                            case "Quản lý Môn học":
                                showPAnel(jpMonHoc);
                                break;
                            case "Quản lý học kì":
                                showPAnel(jpHK);
                                break;
                            case "Quản lý Lớp học":
                                showPAnel(jpLopHoc);
                                break;
                            case "Quản lý Học phần":
                                showPAnel(jpHP);
                                break;
                            case "Quản lý ĐKHP":
                                showPAnel(jpDKHP);
                                break;
                            case "Quản lý SV_HP":
                                showPAnel(jpSVHP);
                                break;
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setBorder(dark_gray_border);

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setBorder(default_border);

                    }
                });
            }
        }
    }

    public void setLabelBackround(JLabel label) {
        for (JLabel menuItem : menuLabels) {
            menuItem.setBackground(new Color(237, 251, 255));
            menuItem.setForeground(new Color(37, 75, 122));
        }
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.WHITE);
    }

    //show panel khi click chon label tuong ung
    public void showPAnel(JPanel jPanel) {
        for (JPanel jp : menuPanels) {
            jp.setVisible(false);
        }
        jPanel.setVisible(true);

    }

    //------------------------Các hàm chung-----------------------------------------------------------------------------
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "!!! Hành động này sẽ lưu thông tin xuống CDSL !!!", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    private boolean showDialogDelete() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "!!! Hành động này sẽ xóa thông tin trong CDSL !!!", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    private boolean showDialogSetHocKi() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "!!! Học kì sẽ được mặc định là học kì hiện tại !!!", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    private void showDialogAgain(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    //------------------------Các hàm cho panel Thông tin cá nhân-------------------------------------------------------
    //Update thong tin ca nhan
    public void update() {
        acc = AccountDAO.getAccount(acc.getfMaTk());

        lbName.setText(acc.getfTaiKhoan());
        tfDC.setText(acc.getfDiaChi());
        tfDT.setText(acc.getfDienThoai());
        tfGT.setText(acc.getfGioiTinh());
        tfNS.setText("" + acc.getfNgaySinh());
        tfTen.setText(acc.getfHoTen());
        tfMK.setText(acc.getfPass());
        System.out.println("đã vô đây");
    }

    //------------------------Các hàm cho quản lý giáo vụ---------------------------------------------------------------
    //show table giáo vụ
    public void showTableGiaoVu() {
        String[] columnsGV = new String[]{"STT", "Tài khoản", "Mật khẩu", "Họ tên", "Ngày sinh", "Địa chỉ", "SDT", "Giới tính", "Loại"};
        TableModel dataModelGV = new
                AbstractTableModel() {
                    List<Accounts> rsGVrsGV = AccountDAO.getAllAccountsGV();

                    public String getColumnName(int columnIndex) {
                        return columnsGV[columnIndex];
                    }

                    public int getColumnCount() {
                        return 9;
                    }

                    public int getRowCount() {
                        return rsGVrsGV.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Accounts si = rsGVrsGV.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.getfMaTk();
                            case 1:
                                return si.getfTaiKhoan();
                            case 2:
                                return si.getfPass();
                            case 3:
                                return si.getfHoTen();
                            case 4:
                                return si.getfNgaySinh();
                            case 5:
                                return si.getfDiaChi();
                            case 6:
                                return si.getfDienThoai();
                            case 7:
                                return si.getfGioiTinh();
                            case 8:
                                return si.getfType();
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                            case 8:
                                return Integer.class;
                            case 1:
                            case 2:
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                                return String.class;
                            case 4:
                                return Date.class;
                        }
                        return null;
                    }
                };
        panel.setLayout(new BorderLayout());
        panel.add(tableGiaoVu, BorderLayout.CENTER);
        panel.add(new JScrollPane(tableGiaoVu));
        panel.add(tableGiaoVu.getTableHeader(), BorderLayout.NORTH);
        tableGiaoVu.setAutoCreateRowSorter(true);
        tableGiaoVu.setModel(dataModelGV);

        //add search
        sorter2 = new TableRowSorter<>(dataModelGV);
        tableGiaoVu.setRowSorter(sorter2);
    }

    //reset txt giáo vụ
    public void resetTxt() {
        tMkgv.setText("");
        tDcgv.setText("");
        tDtgv.setText("");
        tTaiKhoanGv.setText("");
        tTenGV.setText("");
        raBtnGv.setSelected(false);
        raBtnAdmin.setSelected(false);
        raBtnNugv.setSelected(false);
        raBtnNamgv.setSelected(false);
    }

    //------------------------Các hàm cho quản lý sinh viên-------------------------------------------------------------
    public void showTableSinhVienAll() {
        String[] columnsSV = new String[]{"STT", "Tên học sinh", "Tên Lớp"};
        TableModel dataModelLop = new
                AbstractTableModel() {
                    List<AccountsStu> listSV = ClassStudentDAO.getAllAcc();
                    //List<AccountsStu> listSV = ClassStudentDAO.getAcc_Lop(lop);

                    public String getColumnName(int columnIndex) {
                        return columnsSV[columnIndex];
                    }

                    public int getColumnCount() {
                        return 3;
                    }

                    public int getRowCount() {
                        return listSV.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        AccountsStu si = listSV.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.getfMaTkSV();
                            //return rowIndex+1;
                            case 1:
                                return si.getfHoTen();
                            case 2:
                                return si.get_lopHoc().getfTenLh();
//                            case 3:
//                                CheckboxGroup checkboxGroup = new CheckboxGroup();
//                                //for get môn học
//                                //Check môn đk
//                                return checkboxGroup;
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                                return Integer.class;
                            case 1:
                            case 2:
                                return String.class;
//                            case 3:
//                                return CheckboxGroup.class;
                        }
                        return null;
                    }
                };
        panelSinhVien.setLayout(new BorderLayout());
        panelSinhVien.add(tableSinhVien, BorderLayout.CENTER);
        panelSinhVien.add(new JScrollPane(tableSinhVien));
        panelSinhVien.add(tableSinhVien.getTableHeader(), BorderLayout.NORTH);
        tableSinhVien.setAutoCreateRowSorter(true);
        tableSinhVien.setModel(dataModelLop);

        //add search
        sorter = new TableRowSorter<>(dataModelLop);
        tableSinhVien.setRowSorter(sorter);

    }

    public void showTableSinhVienMonDaDK(int maSV) {
        String[] columnsSV_Mon = new String[]{"Mã môn", "Tên môn", "Số tín chỉ"};
        TableModel dataModelLop_mon = new
                AbstractTableModel() {
                    List<Course> listSV_mon = SinhVienHocPhanDAO.getAllCoursesHienTaiDaDk(maSV);

                    //List<AccountsStu> listSV = ClassStudentDAO.getAcc_Lop(lop);
                    public String getColumnName(int columnIndex) {
                        return columnsSV_Mon[columnIndex];
                    }

                    public int getColumnCount() {
                        return 3;
                    }

                    public int getRowCount() {
                        return listSV_mon.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Course si = listSV_mon.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.get_monHoc().getFidMh();
                            case 1:
                                return si.get_monHoc().getfTenMh();
                            case 2:
                                return si.get_monHoc().getfSoTinChi();
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 2:
                                return Integer.class;
                            case 0:
                            case 1:
                                return String.class;
                        }
                        return null;
                    }
                };
        panelMonCuaSV.setLayout(new BorderLayout());
        panelMonCuaSV.add(tableMonCuaSV, BorderLayout.CENTER);
        panelMonCuaSV.add(new JScrollPane(tableMonCuaSV));
        panelMonCuaSV.add(tableMonCuaSV.getTableHeader(), BorderLayout.NORTH);
        tableMonCuaSV.setAutoCreateRowSorter(true);
        tableMonCuaSV.setModel(dataModelLop_mon);
    }

    public void resetTxtSinhVien() {
        tMKSV.setText("");
        tTenSV.setText("");
        tDiaChiSV.setText("");
        tDTSinhVien.setText("");
        tTaiKhoanSV.setText("");
    }

    //------------------------Các hàm cho quản lý Môn học---------------------------------------------------------------
    //show table giáo vụ
    public void showTableMonHoc() {
        String[] columnsMH = new String[]{"STT", "Mã môn", "Tên môn", "Số tín chỉ"};
        TableModel dataModelMH = new
                AbstractTableModel() {
                    List<Subjects> listMH = SubjectDAO.getAllSubjects();

                    public String getColumnName(int columnIndex) {
                        return columnsMH[columnIndex];
                    }

                    public int getColumnCount() {
                        return 4;
                    }

                    public int getRowCount() {
                        return listMH.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Subjects si = listMH.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.getfMaMh();
                            case 1:
                                return si.getFidMh();
                            case 2:
                                return si.getfTenMh();
                            case 3:
                                return si.getfSoTinChi();
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                            case 3:
                                return Integer.class;
                            case 1:
                            case 2:
                                return String.class;
                        }
                        return null;
                    }
                };
        panelMH.setLayout(new BorderLayout());
        panelMH.add(tableMonhoc, BorderLayout.CENTER);
        panelMH.add(new JScrollPane(tableMonhoc));
        panelMH.add(tableMonhoc.getTableHeader(), BorderLayout.NORTH);
        tableMonhoc.setAutoCreateRowSorter(true);
        tableMonhoc.setModel(dataModelMH);

        //add search
        sorter3 = new TableRowSorter<>(dataModelMH);
        tableMonhoc.setRowSorter(sorter3);
    }

    //------------------------Các hàm cho quản lý Học kì----------------------------------------------------------------
    //show table học kì
    public void showTableHocKi() {
        String[] columnsHK = new String[]{"STT", "Tên HK", "Năm học", "Ngày bắt đầu", "Ngày kết thúc", "Học kì hiện tại"};
        TableModel dataModelHK = new
                AbstractTableModel() {
                    List<Semester> listHK = SemesterDAO.getAllSemester();

                    public String getColumnName(int columnIndex) {
                        return columnsHK[columnIndex];
                    }

                    public int getColumnCount() {
                        return 6;
                    }

                    public int getRowCount() {
                        return listHK.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Semester si = listHK.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.getfMaHk();
                            case 1:
                                return si.getfTenHk();
                            case 2:
                                return si.getfNamHoc();
                            case 3:
                                return si.getfNgayBd();
                            case 4:
                                return si.getfNgayKt();
                            case 5:
                                return si.getfHKhienTai();
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                            case 5:
                                return Integer.class;
                            case 1:
                            case 2:
                                return String.class;
                            case 3:
                            case 4:
                                return Date.class;
                        }
                        return null;
                    }
                };
        panelHK.setLayout(new BorderLayout());
        panelHK.add(tableHK, BorderLayout.CENTER);
        panelHK.add(new JScrollPane(tableHK));
        panelHK.add(tableHK.getTableHeader(), BorderLayout.NORTH);
        tableHK.setAutoCreateRowSorter(true);
        tableHK.setModel(dataModelHK);
    }

    //------------------------Các hàm cho quản lý Lop Học----------------------------------------------------------------
    //show table học kì
    public void showTableLop() {
        String[] columnsLop = new String[]{"STT", "Tên lớp", "Tổng sinh viên", "Tổng nam", "Tổng nữ"};
        TableModel dataModelLop = new
                AbstractTableModel() {
                    List<Clazz> listLop = ClazzDAO.getAllClass();

                    public String getColumnName(int columnIndex) {
                        return columnsLop[columnIndex];
                    }

                    public int getColumnCount() {
                        return 5;
                    }

                    public int getRowCount() {
                        return listLop.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Clazz si = listLop.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.getfMaLh();
                            case 1:
                                return si.getfTenLh();
                            case 2:
                                return si.getF_tongSV();
                            case 3:
                                return si.getF_tongNam();
                            case 4:
                                return si.getF_tongNu();
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                            case 2:
                            case 3:
                            case 4:
                                return Integer.class;
                            case 1:
                                return String.class;
                        }
                        return null;
                    }
                };
        panelLH.setLayout(new BorderLayout());
        panelLH.add(tableLopHoc, BorderLayout.CENTER);
        panelLH.add(new JScrollPane(tableLopHoc));
        panelLH.add(tableLopHoc.getTableHeader(), BorderLayout.NORTH);
        tableLopHoc.setAutoCreateRowSorter(true);
        tableLopHoc.setModel(dataModelLop);

    }

    private boolean showDialogLopHocCoSV() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "!!! Lớp học này có sinh viên. Bạn có muốn xóa !!!", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    //------------------------Các hàm cho quản lý ĐKHP------------------------------------------------------------------
    //show table học kì
    public void showTableDKHP() {
        String[] columnsDKHP = new String[]{"STT", "Tên HK", "Năm học", "Ngày bắt đầu đăng ký", "Ngày kết thúc đăng ký"};
        TableModel dataModelDKHP = new
                AbstractTableModel() {
                    List<Dkhp> listDkhp = DkhpDAO.getAllDKHP();

                    public String getColumnName(int columnIndex) {
                        return columnsDKHP[columnIndex];
                    }

                    public int getColumnCount() {
                        return 5;
                    }

                    public int getRowCount() {
                        return listDkhp.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Dkhp si = listDkhp.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.getfMaDkhp();
                            case 1:
                                return si.get_hocki().getfTenHk();
                            case 2:
                                return si.get_hocki().getfNamHoc();
                            case 3:
                                return si.getfNgayDbdk();
                            case 4:
                                return si.getfMaDkhp();
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                                return Integer.class;
                            case 1:
                            case 2:
                                return String.class;
                            case 3:
                            case 4:
                                return Date.class;
                        }
                        return null;
                    }
                };
        panelDKHP.setLayout(new BorderLayout());
        panelDKHP.add(tableDKHP, BorderLayout.CENTER);
        panelDKHP.add(new JScrollPane(tableDKHP));
        panelDKHP.add(tableDKHP.getTableHeader(), BorderLayout.NORTH);
        tableDKHP.setAutoCreateRowSorter(true);
        tableDKHP.setModel(dataModelDKHP);
    }

    public void resetTXTdkhp() {
        tTenNamHoc_Dkhp.setText("");
        raHK1_Dkhp.setSelected(true);
        dateChooserKTdkhp.setDate(today.getTime());
        dateChooserBDdkhp.setDate(today.getTime());
    }

    //------------------------Các hàm cho quản lý Hoc phan--------------------------------------------------------------
    //show table học kì
    public void showTableHocPhan() {
        String[] columnsDKHP = new String[]{"Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Thứ học", "Ca học", "Số slot"};
        TableModel dataModelHP = new
                AbstractTableModel() {
                    List<Course> listDkhp = CourseDAO.getAllCoursesHienTai();

                    public String getColumnName(int columnIndex) {
                        return columnsDKHP[columnIndex];
                    }

                    public int getColumnCount() {
                        return 7;
                    }

                    public int getRowCount() {
                        return listDkhp.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Course si = listDkhp.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.get_monHoc().getFidMh();
                            case 1:
                                return si.get_monHoc().getfTenMh();
                            case 2:
                                return si.get_monHoc().getfSoTinChi();
                            case 3:
                                return AccountDAO.getAccount(si.getfMaGv()).getfHoTen();
                            case 4:
                                return si.getfThuHoc();
                            case 5:
                                return si.getfCaHoc();
                            case 6:
                                return si.getfSoSlot();
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 5:
                            case 2:
                            case 6:
                                return Integer.class;
                            case 0:
                            case 1:
                            case 4:
                            case 3:
                                return String.class;
                        }
                        return null;
                    }
                };
        panelHocPhan.setLayout(new BorderLayout());
        panelHocPhan.add(tableHocPhan, BorderLayout.CENTER);
        panelHocPhan.add(new JScrollPane(tableHocPhan));
        panelHocPhan.add(tableHocPhan.getTableHeader(), BorderLayout.NORTH);
        tableHocPhan.setAutoCreateRowSorter(true);
        tableHocPhan.setModel(dataModelHP);
    }

    public void ResetTxtHocPhan() {
        tMaMonHP.setText("");
        tPhongHocHP.setText("");
        comboSoTinChi.setSelectedIndex(-1);
        comboTenGiaoVien.setSelectedIndex(-1);
        comboBoxTenMon.setSelectedItem(null);
        tSoSlotHP.setText("");
        rahpT2.setSelected(true);
        raCa1.setSelected(true);
    }

    //------------------------Các hàm cho quản lý Hoc phan SV đã đăng ký------------------------------------------------
    //show table học kì
    public void showTableSinhVienHocPhan(String tenMon) {
        String[] columnsSV = new String[]{"MSSV", "Tên sinh viên", "Tên môn", "Tên giáo viên", "Thời gian học", "Ngày đăng ký HP"};
        TableModel dataModelLop_Hp = new
                AbstractTableModel() {
                    List<AccountsStu> listSV = SinhVienHocPhanDAO.getAllSvdaHPdaDkHtTheoTen(tenMon);

                    public String getColumnName(int columnIndex) {
                        return columnsSV[columnIndex];
                    }

                    public int getColumnCount() {
                        return 6;
                    }

                    public int getRowCount() {
                        return listSV.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        AccountsStu si = listSV.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return si.getfTaiKhoan();
                            //return rowIndex+1;
                            case 1:
                                return si.getfHoTen();
                            case 2:
                                return tenMon;
                            case 3:
                                return AccountDAO.getAccount(SinhVienHocPhanDAO.findSV_TenMonHoc(si.getfMaTkSV(), tenMon).getfMaGv()).getfHoTen();
                            case 4:
                                return SinhVienHocPhanDAO.findSV_TenMonHoc(si.getfMaTkSV(), tenMon).getfCaHoc() + "-" + SinhVienHocPhanDAO.findSV_TenMonHoc(si.getfMaTkSV(), tenMon).getfThuHoc();
                            case 5:
                                return SinhVienHocPhanDAO.findSv_MaHP(si.getfMaTkSV(), SinhVienHocPhanDAO.findSV_TenMonHoc(si.getfMaTkSV(), tenMon).getfMaHp()).getFngayDKhp();

                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                            case 1:
                            case 2:
                            case 4:
                            case 5:
                                return String.class;
                        }
                        return null;
                    }
                };
        panelHPSvDk.setLayout(new BorderLayout());
        panelHPSvDk.add(tableHPSvDk, BorderLayout.CENTER);
        panelHPSvDk.add(new JScrollPane(tableHPSvDk));
        panelHPSvDk.add(tableHPSvDk.getTableHeader(), BorderLayout.NORTH);
        tableHPSvDk.setAutoCreateRowSorter(true);
        tableHPSvDk.setModel(dataModelLop_Hp);
    }

    public void showTableSinhVienHocPhan() {
        String[] columnsDKHP = new String[]{"MSSV", "Tên sinh viên", "Tên môn", "Tên giáo viên", "Thời gian học", "Ngày đăng ký HP"};
        TableModel dataModelHP = new
                AbstractTableModel() {
                    List<StudentDkhp> listDkhp = SinhVienHocPhanDAO.getAll();

                    public String getColumnName(int columnIndex) {
                        return columnsDKHP[columnIndex];
                    }

                    public int getColumnCount() {
                        return 6;
                    }

                    public int getRowCount() {
                        return listDkhp.size();
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        StudentDkhp si = listDkhp.get(rowIndex);
                        switch (columnIndex) {
                            case 0:
                                return ClassStudentDAO.getAccByName(si.getfMaTK()).getfTaiKhoan();
                            case 1:
                                return ClassStudentDAO.getAccByName(si.getfMaTK()).getfHoTen();
                            case 2:
                                return CourseDAO.get(si.getfMaCourse()).get_monHoc().getfTenMh();
                            case 3:
                                return AccountDAO.getAccount(CourseDAO.get(si.getfMaCourse()).getfMaGv()).getfHoTen();
                            case 4:
                                return CourseDAO.get(si.getfMaCourse()).getfThuHoc();
                            case 5:
                                return si.getFngayDKhp();
                        }
                        return null;
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        switch (columnIndex) {
                            case 2:
                            case 0:
                            case 1:
                            case 4:
                            case 3:
                                return String.class;
                            case 5:
                                return Date.class;
                        }
                        return null;
                    }
                };
        panelHPSvDk.setLayout(new BorderLayout());
        panelHPSvDk.add(tableHPSvDk, BorderLayout.CENTER);
        panelHPSvDk.add(new JScrollPane(tableHPSvDk));
        panelHPSvDk.add(tableHPSvDk.getTableHeader(), BorderLayout.NORTH);
        tableHPSvDk.setAutoCreateRowSorter(true);
        tableHPSvDk.setModel(dataModelHP);

        //add search
        sorter1 = new TableRowSorter<>(dataModelHP);
        tableHPSvDk.setRowSorter(sorter1);
    }

    //Code tham kháo https://stackoverflow.com/questions/11093326/restricting-jtextfield-input-to-integers
    //Dùng để chỉ cho phép nhập số vào khung Số slot môn học
    class MyIntFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string,
                                 AttributeSet attr) throws BadLocationException {

            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            sb.append(doc.getText(0, doc.getLength()));
            sb.insert(offset, string);

            if (test(sb.toString())) {
                super.insertString(fb, offset, string, attr);
            } else {
                // warn the user and don't allow the insert
            }
        }

        private boolean test(String text) {
            try {
                Integer.parseInt(text);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text,
                            AttributeSet attrs) throws BadLocationException {

            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            sb.append(doc.getText(0, doc.getLength()));
            sb.replace(offset, offset + length, text);

            if (test(sb.toString())) {
                super.replace(fb, offset, length, text, attrs);
            } else {
                // warn the user and don't allow the insert
            }

        }

        @Override
        public void remove(FilterBypass fb, int offset, int length)
                throws BadLocationException {
            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            sb.append(doc.getText(0, doc.getLength()));
            sb.delete(offset, offset + length);

//            if (test(sb.toString())) {
//                super.remove(fb, offset, length);
//            } else {
//                // warn the user and don't allow the insert
//            }
            if (sb.toString().length() == 0) {
                super.replace(fb, offset, length, "", null);
            } else {
                if (test(sb.toString())) {
                    super.remove(fb, offset, length);
                } else {
                    // warn the user and don't allow the insert
                }
            }
        }
    }
}
