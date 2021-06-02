package swing;

import com.toedter.calendar.JDateChooser;
import hibernate.Accounts;

import javax.swing.*;


public class editThongTinCaNhan {
    private static Accounts acc = null;
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
        dateChooser = new JDateChooser(acc.getfNgaySinh());
        dateChooser.setDateFormatString("dd/MM/yyyy");
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


    }


    public static void init(Accounts account) {
        acc = account;
        JFrame frame = new JFrame("editThongTinCaNhan");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new editThongTinCaNhan().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

