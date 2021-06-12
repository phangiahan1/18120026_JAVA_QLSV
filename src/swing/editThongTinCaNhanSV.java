package swing;

import com.toedter.calendar.JDateChooser;
import dao.ClassStudentDAO;
import hibernate.AccountsStu;

import javax.swing.*;


public class editThongTinCaNhanSV {
    private static AccountsStu acc = null;
    private static JFrame close;
    private static boolean reset = false;
    JDateChooser dateChooser;
    private JPanel jpThongTin;
    private JLabel lbTen;
    private JLabel lbMk;
    private JLabel lbNS;
    private JLabel lbDC;
    private JLabel lbDt;
    private JLabel lbGT;
    private JButton btnLuu;
    private JTextField tfTen;
    private JTextField tfDC;
    private JTextField tfDT;
    private JPasswordField tfMK;
    private JRadioButton namRadioButton;
    private JRadioButton nuRadioButton;
    private JButton btnThoat;
    private JPasswordField tfMKA;
    private JPanel mainPanel;
    private JPanel pnNgaySinh;


    public editThongTinCaNhanSV() {
        mainPanel.setSize(10000, 10000);
        dateChooser = new JDateChooser(acc.getfNgaySinh());
        dateChooser.setDateFormatString("yyyy-MM-dd");
        pnNgaySinh.add(dateChooser);


        tfDC.setText(acc.getfDiaChi());
        tfDT.setText(acc.getfDienThoai());


        tfTen.setText(acc.getfHoTen());
        tfMK.setText(acc.getfPass());
        tfMKA.setText(acc.getfPass());
        if (acc.getfGioiTinh().equals("Nam")) {
            namRadioButton.setSelected(true);
            nuRadioButton.setSelected(false);
        } else {
            nuRadioButton.setSelected(true);
            namRadioButton.setSelected(false);
        }
        ButtonGroup bg = new ButtonGroup();
        bg.add(namRadioButton);
        bg.add(nuRadioButton);

        btnLuu.addActionListener(e -> {
            //Kiểm tra mk trùng khớp nhau ko
            String mk = String.valueOf(tfMK.getPassword());

            if (String.valueOf(tfMK.getPassword()).equals(String.valueOf(tfMKA.getPassword()))) {
                if (showDialog()) {
                    acc.setfPass(String.valueOf(tfMK.getPassword()));
                    acc.setfDiaChi(tfDC.getText());
                    acc.setfDienThoai(tfDT.getText());
                    java.util.Date utilDate = dateChooser.getDate();
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    acc.setfNgaySinh(sqlDate);

                    if (showDialog()) {
                        ClassStudentDAO.updateAccount(acc);
                        showDialogAgain("Update thành công!");
                        showDialogAgain("Chọn làm mới để cập nhật lại thông tin");
                        close.dispose();
                    } else showDialogAgain("Update không thành công!!!");

                    close.dispose();
                    reset = true;
                }
            } else {
                showDialogAgain("Mật khẩu nhập sai!!!");
                tfMK.setText("");
                tfMKA.setText("");
            }
        });
        btnThoat.addActionListener(e -> {
            close.dispose();
        });
    }

    public static void init(AccountsStu account) {
        acc = account;
        JFrame frame = new JFrame("editThongTinCaNhanSV");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new editThongTinCaNhanSV().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.pack();
        frame.setVisible(true);
        close = frame;
    }

    public static boolean reset() {
        return reset;
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "!!! Hành động này sẽ lưu thông tin xuống CDSL !!!", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    private void showDialogAgain(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
}

