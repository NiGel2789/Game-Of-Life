import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                // Initializes an instance of the GUI
                createAndShowGUI();

            }
        });
    }
    
    // GUI Handler
    private static void createAndShowGUI() {
        System.out.println("Initializing Game State. Game is visualized? "+
                SwingUtilities.isEventDispatchThread());
         
        // Game main frame
        JFrame f = new JFrame("Game of Life!");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initializes grid instance
        Grid grid = new Grid();
        f.add(grid);
        
        // Button Panel
        JPanel panel = new JPanel();

        // Explanation Button
        JButton send = new JButton("Explanation");

        // Explanation Button Handler
        send.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JFrame g = new JFrame();
                g.setSize(400, 400);
                JPanel explanationPanel = new JPanel();
                JLabel instr1 = new JLabel("<html> The Game of Life is not your typical computer game. It is a cellular automaton, and was invented by Cambridge mathematician John Conway. <br><br>This game became widely known when it was mentioned in an article published by Scientific American in 1970. <br>It consists of a collection of cells which, based on a few mathematical rules, can live, die or multiply. Depending on the initial conditions, the cells form various <br>patterns throughout the course of the game.<html>", SwingConstants.LEFT);
    
                
                explanationPanel.add(instr1);
               
                
                g.getContentPane().add(BorderLayout.NORTH, explanationPanel);
                g.pack();
                g.setVisible(true);
            }  
        });
        
        // Start Button
        JButton start = new JButton("Start");

        // Start Button Handler
            // to-do

        // Next Button
        JButton next = new JButton("Next");

        // Start Button Handler
            // to-do
        
        // Clear Button
        JButton clear = new JButton("Clear");

        // Clear Button Handler
        clear.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                grid.clearAllSquares();
            }  
        }); 

        // Adding all buttons to action panel 
        panel.add(send); 
        panel.add(start);
        panel.add(next);
        panel.add(clear);

        // Placing button panel at the bottom of the main JFrame
        f.getContentPane().add(BorderLayout.SOUTH, panel);
        f.pack();

        // Set all to visible
        f.setVisible(true);
    }
}

// Grid class
class Grid extends JPanel {

    // Rounded values of X and Y (for array access)
    private int roundedX = 0;
    private int roundedY = 0;

    // Color variable for coloring / uncoloring a square
    private Color color;

    // 2D Array to store states of each square
    private int arr[][] = new int[15][15];

    // Default Constructor
    public Grid() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        // Setting default color to WHITE
        color = Color.WHITE;
        
        // Handler for mouse click
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

    // Handler to recolor square based on state in arr
    private void recolorSquare(int x, int y, int roundedX, int roundedY) {
        System.out.println("Repainting square at " + x + " , " + y);
        
        // If space is unpopulated,
        if(arr[roundedX][roundedY] == 0)
        {
            color = Color.YELLOW;
            arr[roundedX][roundedY] = 1;
        }

        // If space is populated
        else
        {
            color = Color.WHITE;
            arr[roundedX][roundedY] = 0;
        }

        repaint(x,y, 20,20);
    }

    // Sets main frame window to 400x400
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    // Clear functionality, sets all squares back to WHITE
    public void clearAllSquares() {
        color = Color.WHITE;
        repaint();
    }

    // Painting components
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