import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.spi.FileTypeDetector;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import  backend.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    private JButton copyButton;
    private JMenu file;
    private JMenuItem save;
    private JMenuItem load;
    private  JFrame p;
    private int width;
    private int lenght;
    Point resize ;
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

        final ArrayList<rectangle> rec=new ArrayList<>();
         navigator nav = new navigator();
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
                        circle c=new circle(Double.parseDouble(in.get(0)),Double.parseDouble(in.get(1)),Double.parseDouble(in.get(2)),Double.parseDouble(in.get(3)),"circle"+ i[0]);
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
                            System.out.println(Arrays.toString(r.points()));
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
                    nav.refresh(draw_panel.getGraphics());
                    redraw(nav);
                    for ( rectangle r:rec) {
                        r.draw(draw_panel.getGraphics());
                    }

                }
                @Override
                public void mousePressed(MouseEvent e) {
                    boolean x=false;
                    for (shape shape: nav.getshapes()) {
                        if( shape.Contains(e.getPoint())){
                            shape.setDraggingPoint(e.getPoint());
                            comboBox1.setSelectedItem(shape.getname());
                        }
                    }
                    backend.shape[] f= nav.getshapes();
                    ArrayList<AbstractShapeClass> f1=new ArrayList<>();
                    for (shape sh:f) {
                        f1.add((AbstractShapeClass) sh );
                    }
                    for (AbstractShapeClass shape: f1) {
                        if( shape.Contains(e.getPoint())){
                            if(x==false){
                            x=true;
                            rec.removeAll(rec);
                            }else {
                                rec.removeAll(rec);
                            }
                            comboBox1.setSelectedItem(shape.getname());
                            Point[] point = shape.points();
                            for (Point point1 : point) {
                                //Rectangle2D.Double r1= new Rectangle2D.Double(point1.x,point1.y,10,10);
                                rectangle r1=new rectangle(point1.x,point1.y,10,10,"");
                                r1.setColor(Color.black);
                                r1.setFillColor(Color.black);
                                r1.sethelp("innerarea");
                                //r1.draw(draw_panel.getGraphics());
                                rec.add(r1);
                            }
                        }
                    }
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    resize =null;
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
                        backend.shape[] f = nav.getshapes();
                        ArrayList<AbstractShapeClass> f1 = new ArrayList<>();
                        for (shape sh : f) {
                            f1.add((AbstractShapeClass) sh);
                        }
                        for (AbstractShapeClass shape : f1) {
                            for (rectangle r : rec) {
                                if (shape.getname().equals((comboBox1.getSelectedItem().toString())) && r.Contains(e.getPoint())) {
                                    resize =r.getPosition();
                                   shape.resize(resize,e.getPoint());
                                   nav.refresh(draw_panel.getGraphics());
                                    shape.draw(draw_panel.getGraphics());
                                }
                            }
                        }
                   nav.refresh(draw_panel.getGraphics());
                   for (shape shape: nav.getshapes()) {
                       if (resize ==null&&shape.getname().equals((comboBox1.getSelectedItem().toString()))&&shape.Contains(e.getPoint())){
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

            save.setAccelerator(KeyStroke.getKeyStroke(
                    java.awt.event.KeyEvent.VK_S,
                    InputEvent.CTRL_MASK));
             load.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L,
                InputEvent.CTRL_MASK));
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    backend.shape[] f= nav.getshapes();
                    ArrayList<AbstractShapeClass> f1=new ArrayList<>();
                    for (shape sh:f) {
                      f1.add((AbstractShapeClass) sh );
                    }
                    JsonArray array=new JsonArray();
                    for (AbstractShapeClass  x:f1) {
                        JsonObject o=new JsonObject();
                        o.put("name",x.getname());
                        String oo=x.getname();
                        o.put("x1",x.getPosition().x);
                        o.put("y1",x.getPosition().y);
                        if(oo.charAt(0)=='c'){
                           o.put("horizontalradius",x.geter().get(0)) ;
                            o.put("verticalradius",x.geter().get(1)) ;
                        }
                        if(oo.charAt(0)=='s'){
                            o.put("side",x.geter().get(0));
                        }
                        if(oo.charAt(0)=='t'){
                            o.put("x2",x.geter().get(0)) ;
                            o.put("y2",x.geter().get(1)) ;
                            o.put("x3",x.geter().get(2)) ;
                            o.put("y3",x.geter().get(3)) ;
                        }
                        if(oo.charAt(0)=='r'){
                            o.put("lenght",x.geter().get(0)) ;
                            o.put("width",x.geter().get(1)) ;
                        }
                        if(oo.charAt(0)=='l'){
                            o.put("x2",x.geter().get(0));
                            o.put("y2",x.geter().get(1));
                        }
                        o.put("help",x.getHelp());
                        var r=x.getColor().getRed();
                        var g=x.getColor().getGreen();
                        var b=x.getColor().getBlue();
                        String hex = String.format("#%02x%02x%02x", r, g, b);
                        o.put("boardercolor",hex);
                        if(x.getFillColor()!=null){
                        r=x.getFillColor().getRed();
                         g=x.getFillColor().getGreen();
                         b=x.getFillColor().getBlue();
                        hex = String.format("#%02x%02x%02x", r, g, b);
                        o.put("fillcolor",hex);
                        }
                        JsonObject set=new JsonObject();
                        set.put("shape",o);
                        array.add(set);
                    }
                    JFileChooser fileChooser=new JFileChooser(new File("C:\\Users\\zeyad\\Desktop\\computer communication\\compu 2nd year\\first term\\programming 2\\lap\\paint"));
                    fileChooser.setDialogTitle("save drawings");
                    fileChooser.setFileFilter(new FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            if (f.isDirectory()) {
                                return true;
                            } else {
                                return f.getName().toLowerCase().endsWith(".json");
                            }
                        }
                        @Override
                        public String getDescription() {
                            return "json file (*.json)";
                        }
                    });
                  int result=  fileChooser.showSaveDialog(null);
                  if(result==JFileChooser.APPROVE_OPTION){
                      File file1=fileChooser.getSelectedFile();
                        try{
                            FileWriter fs=new FileWriter(file1.getPath());
                            fs.write(array.toJson());
                            fs.flush();
                            fs.close();
                        }catch (IOException I){
                        }
                  }
                }
            });
            load.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser=new JFileChooser(new File("C:\\Users\\zeyad\\Desktop\\computer communication\\compu 2nd year\\first term\\programming 2\\lap\\paint"));
                     fileChooser.setDialogTitle ("Open a File");
                    fileChooser.setFileFilter(new FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            if (f.isDirectory()) {
                                return true;
                            } else {
                                return f.getName().toLowerCase().endsWith(".json");
                            }
                        }
                        @Override
                        public String getDescription() {
                            return "json file (*.json)";
                        }
                    });
                    int result = fileChooser.showOpenDialog(null) ;
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File f = fileChooser.getSelectedFile();
                        try (Scanner reader = new Scanner(f))
                        {
                            String S="";
                            while (reader.hasNextLine()){
                                S=S.concat(reader.nextLine());
                            }
                            JsonArray shapeList = Jsoner.deserialize(S,new JsonArray());
                            //System.out.println(shapeList);
                             nav.refresh(draw_panel.getGraphics());
                            for ( shape shape: nav.getshapes()) {
                                nav.setKey(shape.getname());
                                nav.removeShape(shape);
                                nav.resetkey();
                            }
                            comboBox1.removeAllItems();
                            t[0]=0;
                            i[0]=0;
                            j[0]=0;
                            k[0]=0;
                            n[0]=0;
                            for ( Object shape :shapeList ) {
                               ArrayList<String>s= parseshapeObject((JsonObject) shape);
                                if(s.get(0).charAt(0)=='c'){
                                    i[0]++;
                                    circle c =new circle(Double.parseDouble(s.get(4)),Double.parseDouble(s.get(5)),Double.parseDouble(s.get(6)),Double.parseDouble(s.get(7)),s.get(0));
                                   if(s.get(3) != null){
                                       c.sethelp(s.get(3));
                                   }
                                    try {
                                       c.setFillColor(Color.decode(s.get(1)));
                                     c.x=true;}
                                   catch (NullPointerException E){
                                   }
                                      try { c.setColor(Color.decode(s.get(2)));
                                   }catch (NullPointerException N){}
                                    c.draw(draw_panel.getGraphics());
                                    nav.addShape(c);
                                    comboBox1.addItem(c.getname());
                                }
                                if(s.get(0).charAt(0)=='s'){
                                    k[0]++;
                                    rectangle rec =new rectangle(Double.parseDouble(s.get(4)),Double.parseDouble(s.get(5)),Double.parseDouble(s.get(6)),Double.parseDouble(s.get(6)),s.get(0));
                                    if(s.get(3) != null){
                                        rec.sethelp(s.get(3));
                                        rec.x=true;
                                    }
                                    try {
                                        rec.setFillColor(Color.decode(s.get(1)));
                                    }catch (NullPointerException E){
                                    }try {rec.setColor(Color.decode(s.get(2)));
                                    }catch (NullPointerException E){
                                    }

                                    rec.draw(draw_panel.getGraphics());
                                    nav.addShape(rec);
                                    comboBox1.addItem(s.get(0));
                                }
                                if(s.get(0).charAt(0)=='t'){
                                    t[0]++;
                                    triangle tri=new triangle(Double.parseDouble(s.get(4)),Double.parseDouble(s.get(5)),Double.parseDouble(s.get(6)),Double.parseDouble(s.get(7)),Double.parseDouble(s.get(8)),Double.parseDouble(s.get(9)),s.get(0));
                                    if(s.get(3) != null){
                                    tri.sethelp(s.get(3));
                                    }
                                    try{
                                        tri.setFillColor(Color.decode(s.get(1)));
                                        tri.x=true;
                                    }catch (NullPointerException E){
                                    }
                                    try{tri.setColor(Color.decode(s.get(2)));
                                    }catch (NullPointerException E){
                                    }

                                    tri.draw(draw_panel.getGraphics());
                                    nav.addShape(tri);
                                    comboBox1.addItem(s.get(0));
                                }
                                if(s.get(0).charAt(0)=='r') {
                                    n[0]++;
                                    rectangle rec = new rectangle(Double.parseDouble(s.get(4)), Double.parseDouble(s.get(5)), Double.parseDouble(s.get(6)), Double.parseDouble(s.get(7)), s.get(0));
                                    if (s.get(3) != null ) {
                                        rec.sethelp(s.get(3));
                                    }
                                    try {
                                        rec.setFillColor(Color.decode(s.get(1)));
                                        rec.x=true;
                                    } catch (NullPointerException E) {
                                    }
                                     try{  rec.setColor(Color.decode(s.get(2)));
                                    }catch (NullPointerException E){
                                    }
                                    rec.draw(draw_panel.getGraphics());
                                    nav.addShape(rec);
                                    comboBox1.addItem(s.get(0));
                                }
                                if(s.get(0).charAt(0)=='l'){
                                    j[0]++;
                                    line_segment l =new line_segment(Double.parseDouble(s.get(4)),Double.parseDouble(s.get(5)),Double.parseDouble(s.get(6)),Double.parseDouble(s.get(7)),s.get(0));
                                    if(s.get(3) != null){
                                    l.sethelp(s.get(3));
                                    }
                                    try {
                                        l.setFillColor(Color.decode(s.get(1)));
                                        l.x=true;
                                    }catch (NullPointerException E){
                                    }try{  l.setColor(Color.decode(s.get(2)));
                                    }catch (NullPointerException E){
                                    }
                                    l.draw(draw_panel.getGraphics());
                                    nav.addShape(l);
                                    comboBox1.addItem(s.get(0));
                                }

                            }
                        }catch ( Exception exception){

                        }

                    }}
            });
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String s= comboBox1.getSelectedItem().toString();
                            {
                                    nav.setKey(s);
                                Class<? extends backend.shape> a = nav.returnshape(s).getClass();
                                    nav.resetkey();
                                java.util.List<Constructor<?>> x;
                              x= Arrays.stream(a.getConstructors()).toList();
                             Constructor<?> p= x.get(0);
                             var returnshape =(AbstractShapeClass) nav.returnshape(s);
                              String oo=returnshape.getname();
                              AbstractShapeClass c = null;
                              if(oo.charAt(0)=='c'){
                                  i[0]++;
                                  oo="circle"+i[0];
                                   c= (AbstractShapeClass)p.newInstance((int)returnshape.getPosition().getX(),(int)returnshape.getPosition().getY(),returnshape.geter().get(0),returnshape.geter().get(1),oo);
                              }
                              if(oo.charAt(0)=='s'){
                                  k[0]++;
                                  oo="square"+k[0];
                                  c= (AbstractShapeClass)p.newInstance((int)returnshape.getPosition().getX(),(int)returnshape.getPosition().getY(),returnshape.geter().get(0),returnshape.geter().get(1),oo);
                                }
                                if(oo.charAt(0)=='t'){
                                    t[0]++;
                                    oo="triangle"+t[0];
                                    c= (AbstractShapeClass)p.newInstance((int)returnshape.getPosition().getX(),(int)returnshape.getPosition().getY(),returnshape.geter().get(0),returnshape.geter().get(1),returnshape.geter().get(2),returnshape.geter().get(3),oo);
                                }
                                if(oo.charAt(0)=='r'){
                                    n[0]++;
                                    oo="rectangle"+n[0];
                                    c= (AbstractShapeClass)p.newInstance((int)returnshape.getPosition().getX(),(int)returnshape.getPosition().getY(),returnshape.geter().get(0),returnshape.geter().get(1),oo);
                                }
                                if(oo.charAt(0)=='l'){
                                    j[0]++;
                                    oo="linesegment"+j[0];
                                    c= (AbstractShapeClass)p.newInstance((int)returnshape.getPosition().getX(),(int)returnshape.getPosition().getY(),returnshape.geter().get(0),returnshape.geter().get(1),oo);
                                }
                                try {
                                    assert c != null;
                                    c.setColor(returnshape.getColor());
                                    if(returnshape.x&& !Objects.equals(returnshape.getHelp(), "")){
                                        c.sethelp("border");
                                    }
                                    c.x=false;
                                }catch(NullPointerException N){}
                                try {
                                    if(returnshape.getFillColor()!=null){
                                    c.setFillColor(returnshape.getFillColor());
                                    c.x=true;
                                    c.sethelp("innerarea");
                                    }
                                }catch (NullPointerException M){
                                    c.sethelp(returnshape.getHelp());
                                }
                                c.sethelp(returnshape.getHelp());
                             c.draw(draw_panel.getGraphics());
                             nav.addShape(c);
                             comboBox1.addItem(c.getname());
                                }

                }catch (NullPointerException E){
                    JOptionPane.showMessageDialog(null,"please, create a figure to copy it");
                } catch (InstantiationException | InvocationTargetException |
                         IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public  void redraw(navigator nav){
        for (shape shape:nav.getshapes()) {
            shape.draw(draw_panel.getGraphics());
        }
    }
    public ArrayList<String> parseshapeObject(JsonObject shapes)
    {
        ArrayList<String>s=new ArrayList<>();
        JsonObject shape = (JsonObject) shapes.get("shape");
        String Name = (String) shape.get("name");
        s.add(Name);
        String fillcolor =  shape.getString("fillcolor");
        s.add(fillcolor);
        String boardercolor =  shape.getString("boardercolor");
        s.add(boardercolor);
        String help =  shape.getString("help");
        s.add(help );
        String x1 =  shape.getString("x1");
        s.add(x1);
        String y1 =  shape.getString("y1");
        s.add(y1);
        if(Name.charAt(0)=='c'){
            String horizontalradius =  shape.getString("horizontalradius");
            s.add(horizontalradius);
            String verticalradius =  shape.getString("verticalradius");
            s.add(verticalradius);
        }
        if(Name.charAt(0)=='s'){
            String verticalradius =  shape.getString("side");
            s.add(verticalradius);
        }
        if(Name.charAt(0)=='t'){
            String x2 =  shape.getString("x2");
            s.add(x2);
            String y2 =  shape.getString("y2");
            s.add(y2);
            String x3 =  shape.getString("x3");
            s.add(x3);
            String y3 =  shape.getString("y3");
            s.add(y3);
        }
        if(Name.charAt(0)=='r'){
            String lenght =  shape.getString("lenght");
            s.add(lenght);
            String width =  shape.getString("width");
            s.add(width);
        }
        if(Name.charAt(0)=='l'){
            String x2 =  shape.getString("x2");
            s.add(x2);
            String y2 =  shape.getString("y2");
            s.add(y2);;
        }
        return s;
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

