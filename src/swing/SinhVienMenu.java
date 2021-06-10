package swing;

import com.toedter.calendar.JDateChooser;
import dao.ClassStudentDAO;
import hibernate.AccountsStu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

public class SinhVienMenu {
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
    private JPanel jpanelQl;
    private JPanel mainMenu;
    private JPanel jpanelHd;
    private JPanel jpThongTin;
    private JLabel lbTen;
    private JLabel lbMk;
    private JLabel lbNS;
    private JLabel lbDC;
    private JLabel lbDt;
    private JLabel lbGT;
    private JButton btnEditThongTin;
    private JTextField tfTen;
    private JTextField tfNS;
    private JTextField tfDC;
    private JTextField tfDT;
    private JTextField tfGT;
    private JPasswordField tfMK;
    private JButton btnReTT;
    private JPanel jpDKHP;
    private JPanel jpSearchGiaoVu;
    private JPanel panel;
    private JTable tableGiaoVu;
    private JButton btnResetGV;
    private JTextField tTenGV;
    private JTextField tDcgv;
    private JTextField tDtgv;
    private JPasswordField tMkgv;
    private JButton btnDeleteGV;
    private JRadioButton raBtnNamgv;
    private JRadioButton raBtnNugv;
    private JPanel pnNgaySinhGV;
    private JButton btnEditGV;
    private JTextField tTaiKhoanGv;
    private JRadioButton raBtnAdmin;
    private JRadioButton raBtnGv;
    private JButton btnSaveGV;
    private JLabel lbThongTin;
    private JLabel lbGiaoVu;
    private JLabel label;
    private JButton btnDangXuat;
    private JLabel lbName;
    private JTextField tLop;
    private JPanel SinhVienMenu;

    public SinhVienMenu() {
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
    }

    public static void init(AccountsStu account) {
        acc = account;
        JFrame frame = new JFrame("SinhVienMenu");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new SinhVienMenu().mainMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
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
}
