package swing;

import dao.AccountDAO;
import dao.ClassStudentDAO;
import hibernate.Accounts;
import hibernate.AccountsStu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class dangNhap {
    private static JFrame close;
    List<Accounts> rs = AccountDAO.getAllAccounts();
    List<AccountsStu> rs1 = ClassStudentDAO.getAllAcc();
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
                AccountsStu accountsStu = null;
                if (username.trim().equals("")) {
                    showDialogAgain("Vui lòng điền tài khoản!!!");
                } else if (password.trim().equals("")) {
                    showDialogAgain("Vui lòng điền mật khẩu!!!");
                } else {
                    int kt = 0;
                    for (Accounts item : rs) {
                        if (item.getfTaiKhoan().equals(username)) {
                            kt = 1;
                            if (item.getfPass().equals(password)) {
                                showDialogAgain("Đăng nhập thành công");
                                accounts = item;
                                close.dispose();
                                trangChu.init(accounts);
                            } else {
                                showDialogAgain("Sai mật khẩu");
                                txtPass.setText("");
                            }
                            break;
                        }
                    }
                    for (AccountsStu item : rs1) {
                        if (item.getfTaiKhoan().equals(username)) {
                            kt = 1;
                            if (item.getfPass().equals(password)) {
                                showDialogAgain("Đăng nhập thành công");
                                accountsStu = item;
                                close.dispose();
                                trangChuSV.init(accountsStu);
                            } else {
                                showDialogAgain("Sai mật khẩu");
                                txtPass.setText("");
                            }
                            break;
                        }
                    }
                    if (kt == 0) {
                        showDialogAgain("Tài khoản không tồn tại");
                        txtPass.setText("");
                        txtTaiKhoan.setText("");
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
    private void showDialogAgain(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    public static void init() {
        JFrame frame = new JFrame("dangNhap");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new dangNhap().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        close = frame;
    }

}
