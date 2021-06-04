package swing;

import com.toedter.calendar.JDateChooser;
import dao.AccountDAO;
import hibernate.Accounts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class editThongTinCaNhan {
    private static Accounts acc = null;
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


    public editThongTinCaNhan() {
        mainPanel.setSize(10000, 10000);
        dateChooser = new JDateChooser(acc.getfNgaySinh());
        dateChooser.setDateFormatString("yyyy-MM-dd");
        pnNgaySinh.add(dateChooser);


        tfDC.setText(acc.getfDiaChi());
        tfDT.setText(acc.getfDienThoai());
        //tfGT.setText(acc.getfGioiTinh());
        //tfNS.setText(""+acc.getfNgaySinh());
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


        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Kiểm tra mk trùng khớp nhau ko
                String mk = String.valueOf(tfMK.getPassword());

                if (String.valueOf(tfMK.getPassword()).equals(String.valueOf(tfMKA.getPassword()))) {
                    if (showDialog()) {
                        AccountDAO.UpdateThongTin(acc.getfMaTk(), mk, acc.getfNgaySinh(), tfDT.getText(), tfDC.getText(), 1);
                        close.dispose();
                        reset = true;
                    }
                } else {
                    showDialogAgain("Mật khẩu nhập sai!!!");
                    tfMK.setText("");
                    tfMKA.setText("");
                }
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void init(Accounts account) {
        acc = account;
        JFrame frame = new JFrame("editThongTinCaNhan");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new editThongTinCaNhan().mainPanel);
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

