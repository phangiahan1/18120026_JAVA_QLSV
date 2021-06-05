package swing;

import com.toedter.calendar.JDateChooser;
import dao.AccountDAO;
import hibernate.Accounts;

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
    private JTable table1;
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
    private javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    //cho bang giao vu
    private Accounts selectedAcc;
    private int selectedIndex;

    public trangChu() {

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
        //Danh cho thong tin ca nhan
        btnEditThongTin.addActionListener(e -> editThongTinCaNhan.init(acc));
        btnReTT.addActionListener(e -> update());
//Danh cho bang Giao vu
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
        //add JDateChooser
        dateChooserGv = new JDateChooser(today.getTime());
        dateChooserGv.setDateFormatString("yyyy-MM-dd");
        pnNgaySinhGV.add(dateChooserGv);

        btnEditGV.addActionListener(e -> {
            java.util.List<Accounts> rsGV2 = AccountDAO.getAllAccountsGV();
            selectedIndex = table1.convertRowIndexToModel(table1.getSelectedRow());
            selectedAcc = rsGV2.get(selectedIndex);
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
            selectedIndex = table1.convertRowIndexToModel(table1.getSelectedRow());
            selectedAcc = rsGV1.get(selectedIndex);
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
        });
        table1.getSelectionModel().addListSelectionListener(e -> {
            if (!table1.getSelectionModel().isSelectionEmpty()) {
                java.util.List<Accounts> rsGV1 = AccountDAO.getAllAccountsGV();
                selectedIndex = table1.convertRowIndexToModel(table1.getSelectedRow());
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
    }

    //show table giao vu
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
        panel.add(table1, BorderLayout.CENTER);
        panel.add(new JScrollPane(table1));
        panel.add(table1.getTableHeader(), BorderLayout.NORTH);
        table1.setAutoCreateRowSorter(true);
        table1.setModel(dataModelGV);
    }

    public static void init(Accounts account) {
        acc = account;
        JFrame frame = new JFrame("trangChu");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new trangChu().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

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

    //show panel khi click chon label tuong ung
    public void showPAnel(JPanel jPanel) {
        for (JPanel jp : menuPanels) {
            jp.setVisible(false);
        }
        jPanel.setVisible(true);

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

    private void showDialogAgain(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

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


}
