import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paint extends JFrame{
    private JPanel panel1;
    private JButton circleButton;
    private JButton lineSegmentButton;
    private JButton squareButton;
    private JButton rectangleButton;
    private JButton colorizeButton;
    private JButton deleteButton;
    private JComboBox comboBox1;
    private JPanel draw_panel;
    private JPanel fig_choice_panel;
    private JPanel option_panel;
    private  JFrame p;
    paint(){
       p=new JFrame("mini_paint");
        p.setVisible(true);
        p.setContentPane(this.panel1);
        p.setSize(900,600);
        p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.option_panel.setSize(100,900);
        this.draw_panel.setSize(900,500);
        this.fig_choice_panel.setSize(800,200);

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog("PLEASE ENTER X");
                JOptionPane.showInputDialog("PLEASE ENTER y");
                JOptionPane.showInputDialog("PLEASE ENTER RADIUS");
            }
        });
        lineSegmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog("PLEASE ENTER X1");
                JOptionPane.showInputDialog("PLEASE ENTER y1");
                JOptionPane.showInputDialog("PLEASE ENTER X2");
                JOptionPane.showInputDialog("PLEASE ENTER Y2");
            }
        });
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog("PLEASE ENTER X");
                JOptionPane.showInputDialog("PLEASE ENTER y");
                JOptionPane.showInputDialog("PLEASE ENTER S");
            }
        });
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog("PLEASE ENTER X");
                JOptionPane.showInputDialog("PLEASE ENTER y");
                JOptionPane.showInputDialog("PLEASE ENTER LENGTH");
                JOptionPane.showInputDialog("PLEASE ENTER WIDTH");
            }
        });
    }
    public static void main(String[] args) {
            paint p=new paint();
    }
}

