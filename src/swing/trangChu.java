package swing;

import com.toedter.calendar.JDateChooser;
import dao.AccountDAO;
import dao.SemesterDAO;
import dao.SubjectDAO;
import hibernate.Accounts;
import hibernate.Semester;
import hibernate.Subjects;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class trangChu {
    private static Accounts acc = null;
    java.util.List<Accounts> rs = AccountDAO.getAllAccounts();
    java.util.List<Accounts> rsGV = null;

    Border dark_gray_border = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY);
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(237, 251, 255));
    //datechosser gv
    JDateChooser dateChooserGv;
    Calendar today = Calendar.getInstance();

    //datechooser hk
    JDateChooser dateChooserBD;
    JDateChooser dateChooserKT;
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
    //cho bang môn học
    private Subjects selectedSub;
    private int selectedIndexSub;
    //cho bang môn học
    private Semester selectedSem;
    private int selectedIndexSem;

    public trangChu() {
        //Khởi tạo dữ liệu ban đầu, cho bảng thông tin cá nhân
        initALL();
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
                resetTxt();
            } else {
                showDialogAgain("Edit không hoàn thành!!!");
                resetTxt();
            }
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
                    resetTxt();
                } else {
                    showDialogAgain("Xóa không hoàn thành!!!");
                    resetTxt();
                }
            }
        });

        //Khởi tạo dữ liệu cho bảng sinh viên

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
                showDialogAgain("Tài khoản không tồn tại!!!");
            } else {
                if (showDialogDelete()) {
                    SubjectDAO.deleteSub(selectedSub);
                    showDialogAgain("Xóa thành công!!!");
                    panelMH.removeAll();
                    showTableMonHoc();
                    tTenMH.setText("");
                    tMaMH.setText("");
                } else {
                    showDialogAgain("Xóa không hoàn thành!!!");
                    tTenMH.setText("");
                    tMaMH.setText("");
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
                    tNamHK.setText("");
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
    }

    //Hàm init ban đầu
    public static void init(Accounts account) {
        acc = account;
        JFrame frame = new JFrame("trangChu");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new trangChu().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
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
        dateChooserGv = new JDateChooser(today.getTime());
        dateChooserGv.setDateFormatString("yyyy-MM-dd");
        pnNgaySinhGV.add(dateChooserGv);
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
        String[] columnsLop = new String[]{"STT", "Tên HK", "Năm học", "Ngày bắt đầu", "Ngày kết thúc", "Học kì hiện tại"};

    }
}
