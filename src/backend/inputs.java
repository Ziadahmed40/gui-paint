package backend;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class inputs  {
    private  JFrame p;
    private JTextField textField1;
    private JTextField textField2;
    private JButton setBorderColorButton;
    private JButton setFillColorButton;
    private JButton generateButton;
    private JPanel inputs_panel;
    private JPanel feild_panel;
    private JPanel inputs;
    public CompletableFuture<Boolean> vis;
    public  ArrayList <String> in;
    public double x;
    public boolean y=false;
    public boolean z=false;
    public   AtomicReference<Color>  colorfill;
    public   AtomicReference<Color>  colorborder;


    public inputs(double indicator){
        x=indicator;
         in=new ArrayList<>();
        vis=new CompletableFuture<>();
        p=new JFrame("inputs");
        p.setContentPane(this.inputs);
        p.setSize(700,700);
        p.setVisible(true);
        GridLayout layout = new GridLayout(6, 1);
        layout.setVgap(10);
        feild_panel.setLayout(layout);
        inputs_panel.setLayout(layout);
        ArrayList<JTextField> inn = null;
        if(x==2.0||x==2.1||x==1.1){
           inn=generate(2);
        }
        if(x==1.0){
            inn=generate(1);
        }
        if(x==4.0)
            inn=generate(4);
        label(x);
        ArrayList<JTextField> finalInn = inn;
        ArrayList<JTextField> finalInn1 = new ArrayList<>();
        finalInn1.addAll(inn);
        finalInn1.add(textField2);
        finalInn1.add(textField1);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b=validate(finalInn1);
                if(b){
                    in.add(textField2.getText());
                    in.add(textField1.getText());
                    for (JTextField f: finalInn) {
                        in.add(f.getText());
                    }
                    p.setVisible(false);
                    vis.complete(false);
                }
                else
                    JOptionPane.showMessageDialog(null,"please enter a valid input");

            }
        });
        p.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }
            @Override
            public void windowClosing(WindowEvent e) {
                in.add("don't do a thing");
                p.setVisible(false);
                vis.complete(false);
            }
            @Override
            public void windowClosed(WindowEvent e) {
            }
            @Override
            public void windowIconified(WindowEvent e) {
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
            }
            @Override
            public void windowActivated(WindowEvent e) {
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        setBorderColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtomicReference<Color> color= new AtomicReference<>(Color.blue);
                color.set(JColorChooser.showDialog(null, "select a color", color.get()));
                if(color.get() != null){
                  colorborder= color;
                  y=true;
                }
            }
        });
        setFillColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtomicReference<Color> color= new AtomicReference<>(Color.blue);
                color.set(JColorChooser.showDialog(null, "select a color", color.get()));
                if(color.get() != null){
                    colorfill= color;
                    z=true;
                }

            }
        });
    }
    public CompletableFuture<Boolean> visible(){
        return vis;
    }
    public ArrayList<JTextField> generate(int x){
        ArrayList<JTextField> f=new ArrayList<>();
        for (int i = 0; i < x; i++) {
            JTextField index=new JTextField(null,0);
            index.setMargin(new Insets(10, 10, 10 ,10));
            feild_panel.add(index);
            f.add(index);
        }
        p.update(p.getGraphics());
        feild_panel.validate();
        feild_panel.repaint();
        return f;
    }
    public void label(double x){
        if(x==1.0){
            JLabel l=new JLabel("side");
            inputs_panel.add(l);
        }
        if(x==1.1){
            JLabel l=new JLabel("horizontal radius");
            inputs_panel.add(l);
            JLabel l2=new JLabel("vertical radius");
            inputs_panel.add(l2);
        }
        JLabel l;
        if(x!=1&&x!=11){
            for (int i = 0; i < x; i++) {
                if(x==2.0){
                    if(i==0){
                        l=new JLabel("lenght");
                        inputs_panel.add(l);
                    }
                    if(i==1){
                        l=new JLabel("width");
                        inputs_panel.add(l);
                    }
                }
                if(x==2.1||x==4.0){
                    if(i==0){
                        l=new JLabel("x"+2);
                        inputs_panel.add(l);
                    }
                    if(i==1){
                        l=new JLabel("y"+2);
                        inputs_panel.add(l);
                        continue;
                    }
                    }
                    if(i==2&&x!=2.1){
                        l=new JLabel("x"+3);
                        inputs_panel.add(l);
                    }
                    if(i==3){
                        l=new JLabel("y"+3);
                        inputs_panel.add(l);
                    }
        }
        }
        p.update(p.getGraphics());
        inputs_panel.validate();
        inputs_panel.repaint();
    }
    public static  boolean check(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean validate(ArrayList<JTextField> x){
        boolean flag=true;
        for (JTextField i:x) {
            String s=i.getText();
           if(!check(s)){
              flag=false;
              break;
           }
           if(s.equals("")||Integer.parseInt(s)<0){
               flag=false;
               break;
           }
        }
       return flag;
    }
//                    while (s[2].equals("")||!check(s[2])||Integer.parseInt(s[2])<0||(Integer.parseInt(s[1])+Integer.parseInt(s[2])*2)>getLenght()||(Integer.parseInt(s[0])+Integer.parseInt(s[2])*2)>getWidth1())
//    public static void main(String[] args) {
//             new inputs(4);
//    }

}


