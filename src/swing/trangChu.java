package swing;

import hibernate.Accounts;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class trangChu {
    private static Accounts acc = null;
    Border dark_gray_border = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY);
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(237, 251, 255));
    //create array of jLabel
    JLabel[] menuLabels = new JLabel[9];
    private JLabel lbName;
    private JLabel label;
    private JLabel lbThongTin;
    private JLabel lbQLDKHP;
    private JLabel lbGiaoVu;
    private JLabel lbSV;
    private JLabel lbHP;
    private JButton btnDangXuat;
    private JLabel lbQLHP;
    private JLabel lbLH;
    private JLabel lbHK;
    private JPanel jpanelHd;
    private JPanel jpanelQl;
    private JPanel mainPanel;
    private JLabel lbMH;
    private JPanel jpThongTin;
    private JButton btnEditThongTin;
    private JTextField tfTen;
    private JTextField tfNS;
    private JTextField tfDC;
    private JTextField tfDT;
    private JTextField tfGT;
    private JPasswordField tfMK;
    private JPanel jpGiaoVu;
    private JLabel lbTen;
    private JLabel lbMk;
    private JLabel lbNS;
    private JLabel lbDC;
    private JLabel lbDt;
    private JLabel lbGT;


    public trangChu() {
        lbName.setText(acc.getfTaiKhoan());
        tfDC.setText(acc.getfDiaChi());
        tfDT.setText(acc.getfDienThoai());
        tfGT.setText(acc.getfGioiTinh());
        tfNS.setText("" + acc.getfNgaySinh());
        tfTen.setText(acc.getfHoTen());
        tfMK.setText(acc.getfPass());


        menuLabels[0] = lbThongTin;
        menuLabels[1] = lbGiaoVu;
        menuLabels[2] = lbSV;
        menuLabels[3] = lbMH;
        menuLabels[4] = lbHK;
        menuLabels[5] = lbLH;
        menuLabels[6] = lbQLHP;
        menuLabels[7] = lbHP;
        menuLabels[8] = lbQLDKHP;

        addActionToMenuLabels();

        btnEditThongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editThongTinCaNhan.init(acc);

            }
        });
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

    public void addActionToMenuLabels() {
        Component[] components = jpanelQl.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setLabelBackround(label);

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
}
