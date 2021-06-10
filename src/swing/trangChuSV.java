package swing;

import com.toedter.calendar.JDateChooser;
import dao.AccountDAO;
import dao.ClassStudentDAO;
import dao.CourseDAO;
import dao.SinhVienHocPhanDAO;
import hibernate.AccountsStu;
import hibernate.Course;
import hibernate.StudentDkhp;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.List;

public class trangChuSV {
    private static AccountsStu acc;
    private static JFrame close;
    Border dark_gray_border = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY);
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(237, 251, 255));
    //datechosser gv
    JDateChooser dateChooserGv;
    Calendar today = Calendar.getInstance();
    //create array of jLabel
    JLabel[] menuLabels = new JLabel[2];
    //creat array of jPanel
    JPanel[] menuPanels = new JPanel[2];
    private JPanel mainPanelSV;
    private JPanel jpThongTin;
    private JTextField tfTen;
    private JTextField tfNS;
    private JTextField tfDC;
    private JTextField tfDT;
    private JTextField tfGT;
    private JPasswordField tfMK;
    private JLabel label;
    private JButton btnDangXuat;
    private JLabel lbName;
    private JLabel lbThongTin;
    private JLabel lbGiaoVu;
    private JPanel jpDKHP;
    private JButton btnEditThongTin;
    private JButton btnReTT;
    private JPanel jpanelQl;
    private JTextField tLop;
    private JTable tableHocPhan;
    private JLabel lbTen;
    private JLabel lbMk;
    private JLabel lbNS;
    private JLabel lbDC;
    private JLabel lbDt;
    private JLabel lbGT;
    private JTextField tPhongHocHP;
    private JTextField tMaMonHP;
    private JTextField tSoSlotHP;
    private JButton btnAddHP;
    private JPanel panelHocPhan;
    private JTextField tTenMonHp;
    private JTextField tTenGV;
    private JTextField tSoTinChi;
    private JTextField tThu;
    private JTextField tCa;
    private JPanel panelMonDaDK;
    private JTable tableHPdaDK;
    private JButton btnDelHP;
    //cho bang đăng ký hp
    private Course selectedHocPhan;
    private int selectedIndexHocPhan;

    //cho bang đăng ký hp
    private Course selectedHocPhanEx;
    private int selectedIndexHocPhanEx;


    public trangChuSV() {
        //Khởi tạo dữ liệu ban đầu, cho bảng thông tin cá nhân
        initALL();
        //btn Thông tin cá nhân
        btnEditThongTin.addActionListener(e -> {
            editThongTinCaNhanSV.init(acc);
        });
        btnReTT.addActionListener(e -> {
            update1(acc);
        });
        btnDangXuat.addActionListener(e -> {
            close.dispose();
            dangNhap.init();
        });

        showTableHocPhan();
        showTableHocPhanDadk();

        tableHocPhan.getSelectionModel().addListSelectionListener(e -> {
            if (!tableHocPhan.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Course> rshp = CourseDAO.getAllCourses();
                selectedIndexHocPhan = tableHocPhan.convertRowIndexToModel(tableHocPhan.getSelectedRow());
                selectedHocPhan = rshp.get(selectedIndexHocPhan);
                if (selectedHocPhan != null) {
                    tMaMonHP.setText(selectedHocPhan.get_monHoc().getFidMh());
                    tTenMonHp.setText(selectedHocPhan.get_monHoc().getfTenMh());
                    tTenGV.setText(AccountDAO.getAccount(selectedHocPhan.getfMaGv()).getfHoTen());
                    tPhongHocHP.setText(selectedHocPhan.getfPhongHoc());
                    tSoTinChi.setText(String.valueOf(selectedHocPhan.get_monHoc().getfSoTinChi()));
                    tSoSlotHP.setText(String.valueOf(selectedHocPhan.getfSoSlot()));
                    tThu.setText(selectedHocPhan.getfThuHoc());
                    tCa.setText(String.valueOf(selectedHocPhan.getfCaHoc()));
                }
            }
        });
        tableHPdaDK.getSelectionModel().addListSelectionListener(e -> {
            if (!tableHPdaDK.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Course> rshp1 = CourseDAO.getAllCourses();
                selectedIndexHocPhanEx = tableHPdaDK.convertRowIndexToModel(tableHPdaDK.getSelectedRow());
                selectedHocPhanEx = rshp1.get(selectedIndexHocPhanEx);
                if (selectedHocPhanEx != null) {
                    tMaMonHP.setText(selectedHocPhanEx.get_monHoc().getFidMh());
                    tTenMonHp.setText(selectedHocPhanEx.get_monHoc().getfTenMh());
                    tTenGV.setText(AccountDAO.getAccount(selectedHocPhanEx.getfMaGv()).getfHoTen());
                    tPhongHocHP.setText(selectedHocPhanEx.getfPhongHoc());
                    tSoTinChi.setText(String.valueOf(selectedHocPhanEx.get_monHoc().getfSoTinChi()));
                    tSoSlotHP.setText(String.valueOf(selectedHocPhanEx.getfSoSlot()));
                    tThu.setText(selectedHocPhanEx.getfThuHoc());
                    tCa.setText(String.valueOf(selectedHocPhanEx.getfCaHoc()));
                }
            }
        });
        btnAddHP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<Course> rshp = CourseDAO.getAllCourses();
                selectedIndexHocPhan = tableHocPhan.convertRowIndexToModel(tableHocPhan.getSelectedRow());
                selectedHocPhan = rshp.get(selectedIndexHocPhan);

                StudentDkhp studentDkhp = new StudentDkhp();
                studentDkhp.setfMaCourse(selectedHocPhan.getfMaHp());
                studentDkhp.setfMaTK(acc.getfMaTkSV());

                if (SinhVienHocPhanDAO.isExisted(studentDkhp)) {
                    showDialogAgain("Học phần đã được đăng ký");
                } else {
                    SinhVienHocPhanDAO.save(studentDkhp);
                    showDialogAgain("Đăng ký thành công");
                    panelHocPhan.removeAll();
                    showTableHocPhan();
                    panelMonDaDK.removeAll();
                    showTableHocPhanDadk();
                }
            }
        });
    }

    public static void init(AccountsStu account) {
        acc = account;
        JFrame frame = new JFrame("trangChuSV");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new trangChuSV().mainPanelSV);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);

        close = frame;
        frame.setVisible(true);
    }

    //------------------------Các hàm cho panel Thông tin cá nhân-------------------------------------------------------
    //Update thong tin ca nhan
    public static void update() {
        acc = ClassStudentDAO.getAccByName(acc.getfMaTkSV());
    }

    //------------------------Các hàm init------------------------------------------------------------------------------
    //Hàm init Trang chủ + Thông tin cá nhân
    public void initALL() {
        //set text cho thong tin ca nhan

        addActionToMenuLabels();
        lbName.setText(acc.getfTaiKhoan());
        tfDC.setText(acc.getfDiaChi());
        tfDT.setText(acc.getfDienThoai());
        tfGT.setText(acc.getfGioiTinh());
        tfNS.setText("" + acc.getfNgaySinh());
        tfTen.setText(acc.getfHoTen());
        tfMK.setText(acc.getfPass());
        tLop.setText(acc.get_lopHoc().getfTenLh());
        //main menu
        menuLabels[0] = lbThongTin;
        menuLabels[1] = lbGiaoVu;
        //main panel
        menuPanels[0] = jpThongTin;
        menuPanels[1] = jpDKHP;
    }

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
                            case "Đăng ký học phần":
                                showPAnel(jpDKHP);
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

    private void showDialogAgain(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    public void update1(AccountsStu acc) {
        acc = ClassStudentDAO.getAccByName(acc.getfMaTkSV());

        lbName.setText(acc.getfTaiKhoan());
        tfDC.setText(acc.getfDiaChi());
        tfDT.setText(acc.getfDienThoai());
        tfGT.setText(acc.getfGioiTinh());
        tfNS.setText("" + acc.getfNgaySinh());
        tfTen.setText(acc.getfHoTen());
        tfMK.setText(acc.getfPass());
    }

    public void showTableHocPhan() {
        String[] columnsDKHP = new String[]{"Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Thứ học", "Ca học", "Số slot"};
        TableModel dataModelHP = new
                AbstractTableModel() {
                    List<Course> listDkhp = SinhVienHocPhanDAO.getAllCoursesHienTaiChuaDk(acc.getfMaTkSV());

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

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        if (columnIndex < 1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                };
        panelHocPhan.setLayout(new BorderLayout());
        panelHocPhan.add(tableHocPhan, BorderLayout.CENTER);
        panelHocPhan.add(new JScrollPane(tableHocPhan));
        panelHocPhan.add(tableHocPhan.getTableHeader(), BorderLayout.NORTH);
        tableHocPhan.setAutoCreateRowSorter(true);
        tableHocPhan.setModel(dataModelHP);
    }

    public void showTableHocPhanDadk() {
        String[] columnsDKHP = new String[]{"Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Thứ học", "Ca học", "Số slot"};
        TableModel dataModelHPdaDk = new
                AbstractTableModel() {
                    List<Course> listDkhp = SinhVienHocPhanDAO.getAllCoursesHienTaiDaDk(acc.getfMaTkSV());

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

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        if (columnIndex < 1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                };
        panelMonDaDK.setLayout(new BorderLayout());
        panelMonDaDK.add(tableHPdaDK, BorderLayout.CENTER);
        panelMonDaDK.add(new JScrollPane(tableHPdaDK));
        panelMonDaDK.add(tableHPdaDK.getTableHeader(), BorderLayout.NORTH);
        tableHPdaDK.setAutoCreateRowSorter(true);
        tableHPdaDK.setModel(dataModelHPdaDk);
    }
}

