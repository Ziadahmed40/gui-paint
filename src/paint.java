import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import  backend.*;
public class paint extends JFrame  {
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
    private JButton triangle;
    private  JFrame p;
    private int width;
    private int lenght;
    paint(){
       p=new JFrame("mini_paint");
        p.setVisible(true);
        p.setContentPane(this.panel1);
        p.setSize(900,600);
        p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.option_panel.setSize(100,900);
        this.draw_panel.setSize(900,500);
        setLenght(500);
        setWidth(900);
        this.fig_choice_panel.setSize(800,200);
        final int[] i = {0};
        final int[] j = {0};
        final int[] k = {0};
        final int[] n = {0};
        final int[] t = {0};
        navigator nav=new navigator();
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(false);
                inputs ii=new inputs(1.1);
                ii.visible().whenComplete((Boolean vis ,Object X)->{
                    p.setVisible(true);
                    ArrayList<String> in=ii.in;
                    if(!in.get(0).equals("don't do a thing")){
                        i[0]++;
                        circle c=new circle(Double.parseDouble(in.get(0)),Double.parseDouble(in.get(1)),Double.parseDouble(in.get(2)),"circle"+ i[0]);
                        if(ii.y){
                            c.setColor( ii.colorborder.get());
                            System.out.println("HH");
                        }
                        if(ii.z){
                            c.sethelp("innerarea");
                            c.setFillColor(ii.colorfill.get());
                        }
                        c.draw(draw_panel.getGraphics());
                        nav.addShape(c);
                        comboBox1.addItem(c.getname());
                            redraw(nav);
                    }

                });
            }
        });
        lineSegmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String []s = new String[4];
//                  try {
//                      s[0]= JOptionPane.showInputDialog("PLEASE ENTER X1");
//                      while (s[0].equals("")||!check(s[0])||Integer.parseInt(s[0])<0||Integer.parseInt(s[0])>getWidth1()){
//                          JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than "+getWidth1());
//                          s[0]= JOptionPane.showInputDialog("PLEASE ENTER X1");
//                      }
//                      s[1]=JOptionPane.showInputDialog("PLEASE ENTER y1");
//                      while (s[1].equals("")||!check(s[1])||Integer.parseInt(s[1])<0||Integer.parseInt(s[1])>getLenght()){
//                          JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller than "+getLenght());
//                          s[1]=JOptionPane.showInputDialog("PLEASE ENTER y1");
//                      }
//                      s[2]= JOptionPane.showInputDialog("PLEASE ENTER X2");
//                      while (s[2].equals("")||!check(s[2])||Integer.parseInt(s[2])<0||(Integer.parseInt(s[0])+Integer.parseInt(s[2]))>getWidth1()){
//                          JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller width to see this line segment)");
//                          s[2]= JOptionPane.showInputDialog("PLEASE ENTER X2");
//                      }
//                      s[3]= JOptionPane.showInputDialog("PLEASE ENTER Y2");
//                      while (s[3].equals("")||!check(s[3])||Integer.parseInt(s[3])<0||(Integer.parseInt(s[1])+Integer.parseInt(s[3]))>getLenght()){
//                          JOptionPane.showMessageDialog(null,"please enter a valid input (postive , smaller length to see this line segment)");
//                          s[3]= JOptionPane.showInputDialog("PLEASE ENTER Y2");
//                      }
                      p.setVisible(false);
                      inputs ii=new inputs(2.1);
                      ii.visible().whenComplete((Boolean vis ,Object X)->{
                          p.setVisible(true);
                          ArrayList<String> in=ii.in;
                          if(!in.get(0).equals("don't do a thing")){
                              j[0]++;
                              line_segment l=new line_segment(Double.parseDouble(in.get(0)),Double.parseDouble(in.get(1)),Double.parseDouble(in.get(2)),Double.parseDouble(in.get(3)),"line_segment"+ j[0]);
                              if(ii.y){
                                  l.setColor( ii.colorborder.get());
                              }
                              if(ii.z){
                                  l.sethelp("innerarea");
                                  l.setFillColor(ii.colorfill.get());
                              }
                              l.draw(draw_panel.getGraphics());
                              nav.addShape(l);
                              comboBox1.addItem(l.getname());
                              redraw(nav);
                          }
                      });
            }
        });
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    p.setVisible(false);
                    inputs ii=new inputs(1.0);
                    ii.visible().whenComplete((Boolean vis ,Object X)->{
                        p.setVisible(true);
                        ArrayList<String> in=ii.in;
                        if(!in.get(0).equals("don't do a thing")){
                            k[0]++;
                            rectangle r=new rectangle(Double.parseDouble(in.get(0)),Double.parseDouble(in.get(1)),Double.parseDouble(in.get(2)),Double.parseDouble(in.get(2)),"square"+ k[0]);
                            if(ii.y){
                                r.setColor( ii.colorborder.get());
                            }
                            if(ii.z){
                                r.sethelp("innerarea");
                                r.setFillColor(ii.colorfill.get());
                            }
                            r.draw(draw_panel.getGraphics());
                            nav.addShape(r);
                            comboBox1.addItem(r.getname());
                            redraw(nav);
                        }

                    });
            }
        });
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    p.setVisible(false);
                    inputs i=new inputs(2.0);
                    i.visible().whenComplete((Boolean vis ,Object X)->{
                        p.setVisible(true);
                        ArrayList<String> in=i.in;
                        if(!in.get(0).equals("don't do a thing")){
                            n[0]++;
                            rectangle r=new rectangle(Double.parseDouble(in.get(0)),Double.parseDouble(in.get(1)),Double.parseDouble(in.get(2)),Double.parseDouble(in.get(3)),"rectangle"+ n[0]);
                            if(i.y){
                                r.setColor( i.colorborder.get());
                            }
                            if(i.z){
                                r.sethelp("innerarea");
                                r.setFillColor(i.colorfill.get());
                            }
                            r.draw(draw_panel.getGraphics());
                            nav.addShape(r);
                            comboBox1.addItem(r.getname());
                            redraw(nav);
                        }
                    });
            }
        });
        triangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(false);
                inputs ii=new inputs(4);
                ii.visible().whenComplete((Boolean vis ,Object X)->{
                    p.setVisible(true);
                    ArrayList<String> in=ii.in;
                    if(!in.get(0).equals("don't do a thing")){
                        t[0]++;
                        triangle tri=new triangle(Double.parseDouble(in.get(0)),Double.parseDouble(in.get(1)),Double.parseDouble(in.get(2)),Double.parseDouble(in.get(3)),Double.parseDouble(in.get(4)),Double.parseDouble(in.get(5)),"triangle"+ t[0]);
                        if(ii.y){
                            tri.setColor( ii.colorborder.get());
                        }
                        if(ii.z){
                            tri.sethelp("innerarea");
                            tri.setFillColor(ii.colorfill.get());
                        }
                        tri.draw(draw_panel.getGraphics());
                        nav.addShape(tri);
                        comboBox1.addItem(tri.getname());
                        redraw(nav);
                    }

                });
            }
        });
        p.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                redraw(nav);
                int delay = 100; //milliseconds
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        redraw(nav);
                    }
                };
                new Timer(delay, taskPerformer).start();
                redraw(nav);
                redraw(nav);
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
              draw_panel.getGraphics().clearRect(0,0,1900,1900);
                    redraw(nav);
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
                   AtomicReference<Color> color= new AtomicReference<>(Color.blue);
                    options o=new options();
                    o.visible().whenComplete((Boolean vis ,Object X)->
                            {
                                color.set(JColorChooser.showDialog(null, "select a color", color.get()));
                                if(color.get() != null){
                                    nav.setKey(s);
                                    var returnshape = nav.returnshape(s);
                                    nav.resetkey();
                                    if(o.s.equals("innerarea")){
                                        returnshape.sethelp(o.s);
                                        returnshape.setFillColor(color.get());
                                    }
                                    if(o.s.equals("border")){
                                        returnshape.sethelp(o.s);
                                        returnshape.setColor(color.get());
                                    }
                                    returnshape.draw(draw_panel.getGraphics());
                                    redraw(nav);
                                }
                            }
                            );

               }catch (NullPointerException E){
                   JOptionPane.showMessageDialog(null,"please, create a figure to colorize it");
               }
            }
        });
            draw_panel.addComponentListener(new ComponentAdapter() {
                public void componentResized (ComponentEvent e) {
                    Component c = (Component) e.getSource();
                   setWidth(c.getWidth());
                   setLenght(c.getHeight());
                    redraw(nav);
                    if(c.getWidth()<=365){
                        p.addComponentListener(new ComponentAdapter() {
                            public void componentResized (ComponentEvent e) {
                                redraw(nav);
                            }});
                    }
                }});
            p.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                }
                @Override
                public void windowClosing(WindowEvent e) {
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
                    redraw(nav);
                }
                @Override
                public void windowDeactivated(WindowEvent e) {
                    redraw(nav);
                }
            });
            draw_panel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    for (shape shape:nav.getshapes()) {
                        if( shape.Contains(e.getPoint())){
                            shape.setDraggingPoint(e.getPoint());
                            comboBox1.setSelectedItem(shape.getname());
                        }
                    }
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                }
                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            draw_panel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                   nav.refresh(draw_panel.getGraphics());
                   for (shape shape:nav.getshapes()) {
                       if (shape.getname().equals((comboBox1.getSelectedItem().toString()))&&shape.Contains(e.getPoint())){
                           shape.moveTo(e.getPoint());
                       }
                       shape.setDraggingPoint(e.getPoint());
                        shape.draw(draw_panel.getGraphics());
                  }
                }
                @Override
                public void mouseMoved(MouseEvent e) {
                }
            });

    }
    public  void redraw(navigator nav){
        for (shape shape:nav.getshapes()) {
            shape.draw(draw_panel.getGraphics());
        }
    }


    public void setWidth(int width) {
        this.width = width;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getLenght() {
        return lenght;
    }
    public int getWidth1() {
        return width;
    }


    public static void main(String[] args) {
            new paint();
    }
}

