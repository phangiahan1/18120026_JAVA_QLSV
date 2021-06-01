package swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class trangChu {
    Border dark_gray_border = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY);
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(237, 251, 255));
    private JButton đăngXuấtButton;
    private JLabel lbName;
    private JLabel label;
    private JLabel lbThongTin;
    private JLabel lbQLDKHP;
    private JLabel lbGiaoVu;
    private JLabel lbSV;
    private JLabel lbHP;
    private JLabel lbNH;
    private JLabel lbQLHP;
    private JLabel lbLH;
    private JLabel lbHK;
    private JPanel jpanelHd;
    private JPanel jpanelQl;
    private JPanel mainPanel;


    public trangChu() {
        addActionToMenuLabels();
    }

    public static void main(String[] args) {
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
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.WHITE);
    }
}
