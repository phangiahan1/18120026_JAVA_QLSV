package swing;

import dao.AccountDAO;
import hibernate.Accounts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class dangNhap {
    List<Accounts> rs = AccountDAO.getAllAccounts();
    private JPanel mainPanel;
    private JButton btnDangNhap;
    private JButton btnQuenMK;
    private JButton btnThoat;
    private JPasswordField txtPass;
    private JTextField txtTaiKhoan;
    private JButton btnX;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;


    public dangNhap() {
        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtTaiKhoan.getText();
                String password = String.valueOf(txtPass.getPassword());
                System.out.println(password);
                Accounts accounts = null;
                if (username.trim().equals("")) {
                    showDialogAgain("Vui lòng điền tài khoản!!!");
                } else if (password.trim().equals("")) {
                    showDialogAgain("Vui lòng điền mật khẩu!!!");
                } else {
                    for (Accounts item : rs) {
                        System.out.println(item.toString());
                        if (item.getfTaiKhoan().equals(username)) {
                            if (item.getfPass().equals(password)) {
                                showDialogAgain("Đăng nhập thành công");
                                accounts = item;
                            } else {
                                showDialogAgain("Sai mật khẩu");
                            }
                            break;
                        }
                    }
                    if (accounts == null) {
                        showDialogAgain("Tài khoản không tồn tại");
                    }
                }
            }
        });
        btnX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        btnThoat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "!!! Hành động này sẽ lưu thông tin xuống CDSL !!!", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    private void showDialogAgain(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
    // jf test
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("dangNhap");
//        frame.setLocationRelativeTo(null);
//        frame.setContentPane(new dangNhap().mainPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
