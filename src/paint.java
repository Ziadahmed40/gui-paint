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
                s[0]= JOptionPane.showInputDialog("PLEASE ENTER X");
                while (s[0]==null||s[0].equals("")||Integer.parseInt(s[0])<0||Integer.parseInt(s[0])>900){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than or 900)");
                    s[0]= JOptionPane.showInputDialog("PLEASE ENTER X");
                }
                s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
                while (s[1]==null||s[1].equals("")||Integer.parseInt(s[1])<0||Integer.parseInt(s[1])>500){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than 500)");
                    s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
                }
                s[2]=JOptionPane.showInputDialog("PLEASE ENTER RADIUS");
                while (s[2]==null||s[2].equals("")||Integer.parseInt(s[2])<0||(Integer.parseInt(s[1])+Integer.parseInt(s[2])*2)>500||(Integer.parseInt(s[0])+Integer.parseInt(s[2])*2)>900){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller radius to see this circle)");
                    s[2]=JOptionPane.showInputDialog("PLEASE ENTER RADIUS");
                }
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
                while (s[0]==null||s[0].equals("")||Integer.parseInt(s[0])<0||Integer.parseInt(s[0])>900){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than or 900)");
                    s[0]= JOptionPane.showInputDialog("PLEASE ENTER X1");
                }
                s[1]=JOptionPane.showInputDialog("PLEASE ENTER y1");
                while (s[1]==null||s[1].equals("")||Integer.parseInt(s[1])<0||Integer.parseInt(s[1])>500){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than 500)");
                    s[1]=JOptionPane.showInputDialog("PLEASE ENTER y1");
                }
                s[2]= JOptionPane.showInputDialog("PLEASE ENTER X2");
                while (s[2]==null||s[2].equals("")||Integer.parseInt(s[2])<0||(Integer.parseInt(s[0])+Integer.parseInt(s[2]))>900){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller width to see this line segment)");
                    s[2]= JOptionPane.showInputDialog("PLEASE ENTER X2");
                }
                s[3]= JOptionPane.showInputDialog("PLEASE ENTER Y2");
                while (s[3]==null||s[3].equals("")||Integer.parseInt(s[3])<0||(Integer.parseInt(s[1])+Integer.parseInt(s[3]))>500){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller length to see this line segment)");
                    s[3]= JOptionPane.showInputDialog("PLEASE ENTER Y2");
                }
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
                s[0]= JOptionPane.showInputDialog("PLEASE ENTER X");
                while (s[0]==null ||s[0].equals("")||Integer.parseInt(s[0])<0||Integer.parseInt(s[0])>900){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than or 900)");
                    s[0]= JOptionPane.showInputDialog("PLEASE ENTER X");
                }
                s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
                while (s[1]==null||s[1].equals("")||Integer.parseInt(s[1])<0||Integer.parseInt(s[1])>500){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than 500)");
                    s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
                }
                s[2]=JOptionPane.showInputDialog("PLEASE ENTER S");
                while (s[2]==null||s[2].equals("")||Integer.parseInt(s[2])<0||(Integer.parseInt(s[1])+Integer.parseInt(s[2]))>500||(Integer.parseInt(s[0])+Integer.parseInt(s[2]))>900){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller length to see this square)");
                    s[2]=JOptionPane.showInputDialog("PLEASE ENTER S");
                }

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
                while (s[0]==null||s[0].equals("")||Integer.parseInt(s[0])<0||Integer.parseInt(s[0])>900){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than or 900)");
                    s[0]= JOptionPane.showInputDialog("PLEASE ENTER X");
                }
                s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
                while (s[1]==null||s[1].equals("")||Integer.parseInt(s[1])<0||Integer.parseInt(s[1])>500){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than 500)");
                    s[1]=JOptionPane.showInputDialog("PLEASE ENTER y");
                }
               s[2]= JOptionPane.showInputDialog("PLEASE ENTER LENGTH");
                while (s[2]==null||s[2].equals("")||Integer.parseInt(s[2])<0||(Integer.parseInt(s[1])+Integer.parseInt(s[2]))>500){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller length to see this rectangle)");
                    s[2]= JOptionPane.showInputDialog("PLEASE ENTER LENGTH");
                }
              s[3]=  JOptionPane.showInputDialog("PLEASE ENTER WIDTH");
                while (s[3]==null||s[3].equals("")||Integer.parseInt(s[3])<0||(Integer.parseInt(s[0])+Integer.parseInt(s[3]))>900){
                    JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller width to see this rectangle)");
                    s[3]=  JOptionPane.showInputDialog("PLEASE ENTER WIDTH");
                }
              rectangle r=new rectangle(Double.parseDouble(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2]),Double.parseDouble(s[3]),"rectangle"+ n[0]);
              r.draw(draw_panel.getGraphics());
                nav.addShape(r);
                comboBox1.addItem(r.getname());
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
              String s= comboBox1.getSelectedItem().toString();
              nav.setKey(s);
              nav.refresh(draw_panel.getGraphics());
              nav.removeShape(nav.returnshape(s));
              comboBox1.removeItem(s);
                for (shape shape:nav.getshapes()) {
                    shape.draw(draw_panel.getGraphics());
                }
                nav.resetkey();
                }catch (NullPointerException E){
                    JOptionPane.showMessageDialog(null,"there is no figures ..please create one in order to make operations");
                }

            }
        });
        colorizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   String s= comboBox1.getSelectedItem().toString();
                   Color color=Color.blue;
                   color= JColorChooser.showDialog(null,"select a color",color);
                   nav.setKey(s);
                   var returnshape = nav.returnshape(s);
                   nav.resetkey();
                   returnshape.setFillColor(color);
                   returnshape.draw(draw_panel.getGraphics());
               }catch (NullPointerException E){
                   JOptionPane.showMessageDialog(null,"please, create a figure to colorize it");
               }


            }
        });
    }
    public static void main(String[] args) {
            new paint();
    }
}

