package backend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;

public class options {
    private JButton borderButton;
    private JButton innerAreaButton;
    private JPanel jpanel1;
    private  JFrame p;
    public String s="";
    public CompletableFuture<Boolean> vis;

    public options(){
       p =new JFrame("options");
        p.setContentPane(this.jpanel1);
        p.setSize(300,300);
        p.setVisible(true);
        vis=new CompletableFuture<>();
        borderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = s.concat("border");
                p.setVisible(false);
                vis.complete(false);
            }
        });
        innerAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s =s.concat("innerarea");
                p.setVisible(false);
                vis.complete(false);
            }
        });

    }
    public CompletableFuture<Boolean> visible(){
          return vis;
    }

}
