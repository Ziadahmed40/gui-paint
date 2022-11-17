import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  backend.*;
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
        final int[] i = {0};
        final int[] j = {0};
        final int[] k = {0};
        final int[] n = {0};
        navigator nav=new navigator();
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               i[0]++;
                String []s = new String[3];
                s[0] = JOptionPane.showInputDialog("PLEASE ENTER X");
                s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
                s[2]=JOptionPane.showInputDialog("PLEASE ENTER RADIUS");
                circle c=new circle(Double.parseDouble(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2]),"circle"+ i[0]);
                c.draw(draw_panel.getGraphics());
                nav.addShape(c);
                comboBox1.addItem(c.getname());

            }
        });
        lineSegmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j[0]++;
                String []s = new String[4];
                s[0]= JOptionPane.showInputDialog("PLEASE ENTER X1");
                s[1]=JOptionPane.showInputDialog("PLEASE ENTER y1");
                s[2]= JOptionPane.showInputDialog("PLEASE ENTER X2");
                s[3]= JOptionPane.showInputDialog("PLEASE ENTER Y2");
                line_segment l=new line_segment(Double.parseDouble(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2]),Double.parseDouble(s[3]),"line_segment"+ j[0]);
                l.draw(draw_panel.getGraphics());
                nav.addShape(l);
                comboBox1.addItem(l.getname());
            }
        });
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k[0]++;
                String []s = new String[3];
              s[0] = JOptionPane.showInputDialog("PLEASE ENTER X");
                s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
                s[2]=JOptionPane.showInputDialog("PLEASE ENTER S");
                rectangle r=new rectangle(Double.parseDouble(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2]),Double.parseDouble(s[2]),"square"+ k[0]);
                r.draw(draw_panel.getGraphics());
                nav.addShape(r);
                comboBox1.addItem(r.getname());
            }
        });
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n[0]++;
                String []s = new String[4];
               s[0]= JOptionPane.showInputDialog("PLEASE ENTER X");
                s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
               s[2]= JOptionPane.showInputDialog("PLEASE ENTER LENGTH");
              s[3]=  JOptionPane.showInputDialog("PLEASE ENTER WIDTH");
              rectangle r=new rectangle(Double.parseDouble(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2]),Double.parseDouble(s[3]),"rectangle"+ n[0]);
              r.draw(draw_panel.getGraphics());
                nav.addShape(r);
                comboBox1.addItem(r.getname());
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String s= comboBox1.getSelectedItem().toString();
              nav.setKey(s);
              nav.refresh(draw_panel.getGraphics());
              nav.removeShape(nav.returnshape(s));
              comboBox1.removeItem(s);
                for (shape shape:nav.getshapes()) {
                    shape.draw(draw_panel.getGraphics());
                }
                nav.resetkey();


            }
        });
        colorizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s= comboBox1.getSelectedItem().toString();
                Color color=Color.blue;
                color= JColorChooser.showDialog(null,"select a color",color);
                nav.setKey(s);
                var returnshape = nav.returnshape(s);
                nav.resetkey();
                returnshape.setFillColor(color);
                returnshape.draw(draw_panel.getGraphics());
            }
        });
    }
    public static void main(String[] args) {
            new paint();
    }
}

