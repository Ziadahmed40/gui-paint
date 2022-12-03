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
        if(x==2.0||x==2.1){
           inn=generate(2);
        }
        if(x==1.0||x==1.1){
            inn=generate(1);
        }
        if(x==4.0)
            inn=generate(4);
        label(x);
        ArrayList<JTextField> finalInn = inn;
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean b=validate(finalInn);
                if(b){
                    in.add(textField2.getText());
                    in.add(textField1.getText());
                    for (JTextField f: finalInn) {
                        in.add(f.getText());
                    }
                    for (String S: in) {
                        System.out.println(S);
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
            JLabel l=new JLabel("radius");
            inputs_panel.add(l);
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
        for (JTextField i:x) {
            String s=i.getText();
           if(!check(s)){
               return false;
           }
           if(s.equals("")||Integer.parseInt(s)<0){
               return false;
           }
        }
       return true;
    }
//                    while (s[2].equals("")||!check(s[2])||Integer.parseInt(s[2])<0||(Integer.parseInt(s[1])+Integer.parseInt(s[2])*2)>getLenght()||(Integer.parseInt(s[0])+Integer.parseInt(s[2])*2)>getWidth1())
//    public static void main(String[] args) {
//             new inputs(4);
//    }

}


