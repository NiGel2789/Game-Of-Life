//import javax.swing.*;  
//import java.awt.*;
//import java.awt.event.*;

/*public class App extends JFrame implements ActionListener { 

    public App() 
    {
        //JFrame f=new JFrame("Game of Life");//creating instance of JFrame  
                
        //JButton b=new JButton("click");//creating instance of JButton  
        //b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
                
        //f.add(b);//adding button in JFrame  
                
        setSize(650,400); 
        setVisible(true);
    }

    public void paint( Graphics g )    
    {  
        for ( int x = 30; x <= 300; x += 30 )
        for ( int y = 30; y <= 300; y += 30 ) 
        g.fillRect( x, y, 30, 30 );
    } 

    
    public static void main(String[] args) { 

        App f = new App();
        //JPanel grid = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton send = new JButton("Explanation");
        send.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JFrame g = new JFrame();
                JPanel explanationPanel = new JPanel();
                JLabel explanationLabel = new JLabel("Goddamn this is really annoying to work with");
                explanationPanel.add(explanationLabel);
                g.getContentPane().add(BorderLayout.NORTH, explanationPanel);
                g.setVisible(true);
            }  
        });    
        JButton start = new JButton("Start");
        JButton next = new JButton("Next");
        JButton clear = new JButton("Clear");

        panel.add(send); 
        panel.add(start);
        panel.add(next);
        panel.add(clear);

        f.getContentPane().add(BorderLayout.SOUTH, panel);
        //f.getContentPane().add(BorderLayout.CENTER, grid);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    } 
}  */

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {

        System.out.println("Initializing Game State. Game is visualized? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Game of Life!");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grid grid = new Grid();
        f.add(grid);
        
        JPanel panel = new JPanel();
        JButton send = new JButton("Explanation");
        send.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JFrame g = new JFrame();
                g.setSize(400, 400);
                JPanel explanationPanel = new JPanel();
                JTextField instr1 = new JTextField("The Game of Life is not your typical computer game.");
                JTextField instr2 = new JTextField("It is a cellular automaton, and was invented by Cambridge mathematician John Conway.");
                JTextField instr3 = new JTextField("This game became widely known when it was mentioned in an article published by Scientific American in 1970. It consists of a collection of cells which, based on a few mathematical rules, can live, die or multiply."); 
                JTextField instr4 = new JTextField("Depending on the initial conditions, the cells form various patterns throughout the course of the game.");
                explanationPanel.add(instr1);
                explanationPanel.add(instr2);
                explanationPanel.add(instr3);
                explanationPanel.add(instr4);
                g.getContentPane().add(BorderLayout.NORTH, explanationPanel);
                g.pack();
                g.setVisible(true);
            }  
        });    
        JButton start = new JButton("Start");
        JButton next = new JButton("Next");
        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                grid.clearAllSquares();
            }  
        }); 

        panel.add(send); 
        panel.add(start);
        panel.add(next);
        panel.add(clear);

        f.getContentPane().add(BorderLayout.SOUTH, panel);
        f.pack();
        f.setVisible(true);
    }
}

class Grid extends JPanel {

    private int roundedX = 0;
    private int roundedY = 0;

    private Color color;

    private int arr[][] = new int[15][15];

    public Grid() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        color = Color.WHITE;
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                //moveSquare(e.getX(),e.getY());
                System.out.println("Recoloring square at (" + e.getX() + " , " + e.getY() + ").");
                roundedX = ((e.getX() - 50)/20);
                roundedY = ((e.getY() - 50)/20);
                System.out.println("Array position is (" + roundedX + " , " + roundedY + ").");
                recolorSquare((roundedX*20)+50, (roundedY*20)+50, roundedX, roundedY);
            }
        });
    }

    private void recolorSquare(int x, int y, int roundedX, int roundedY) {
        System.out.println("Repainting square at " + x + " , " + y);
        
        if(arr[roundedX][roundedY] == 0)
        {
            color = Color.YELLOW;
            arr[roundedX][roundedY] = 1;
        }

        else
        {
            color = Color.WHITE;
            arr[roundedX][roundedY] = 0;
        }

        repaint(x,y, 20,20);
    }

    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    public void clearAllSquares() {
        color = Color.WHITE;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        // Draw Text
        g.drawString("Game of Life",157,30);

        // Draws Grid (15x14)
        for (int x = 50; x < 350; x+=20)
        {
            for (int y = 50; y < 330; y+=20)
            {
                g.setColor(color);
                g.fillRect(x,y,20,20);
                g.setColor(Color.BLACK);
                g.drawRect(x,y,20,20);
            }
        }
    }  
}