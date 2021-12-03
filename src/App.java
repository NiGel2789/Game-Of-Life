import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class App{
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

        // Loads up the instruction page
        send.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JFrame g = new JFrame();
                g.setBounds(400,400,600,600);
                
                JPanel explanationPanel = new JPanel();
                JScrollPane scrPane = new JScrollPane(explanationPanel);
                explanationPanel.setLayout(new BoxLayout(explanationPanel, BoxLayout.PAGE_AXIS));

                JLabel instr1 = new JLabel("<html> The Game of Life is not your typical computer game. It is a cellular automaton, and was invented by Cambridge mathematician John Conway. <br><br>This game became widely known when it was mentioned in an article published by Scientific American in 1970. <br>It consists of a collection of cells which, based on a few mathematical rules, can live, die or multiply. Depending on the initial conditions, the cells form various <br>patterns throughout the course of the game.<html>", SwingConstants.LEFT);
                JLabel rules = new JLabel("<html><br><br><b>RULES</b><br><br> <b>For a space that is populated:<b><br> <html>");
                
                JLabel rule1 = new JLabel("<html>Each cell with one or no neighbors dies, as if by solitude.");
                
                
                JLabel rule2 = new JLabel("<html>Each cell with four or more neighbors dies, as if by overpopulation.<html>");

                JLabel rule3 = new JLabel("<html>Each cell with two or three neighbors survives.<html>");

                JLabel instr2 = new JLabel("<html>For a space that is empty or unpopulated<html>");

                JLabel rule4 = new JLabel("<html>Each cell with three neighbors becomes populated.<html>");
                
                instr1.setBorder(new EmptyBorder(20,5,0,0));//top,left,bottom,right
                rules.setBorder(new EmptyBorder(5,5,10,0));//top,left,bottom,right
                rule1.setBorder(new EmptyBorder(0,5,0,0));//top,left,bottom,right
                rule2.setBorder(new EmptyBorder(0,5,0,0));//top,left,bottom,right
                rule3.setBorder(new EmptyBorder(0,5,0,0));//top,left,bottom,right
                rule4.setBorder(new EmptyBorder(0,5,0,0));//top,left,bottom,right
                instr2.setBorder(new EmptyBorder(0,5,0,0));//top,left,bottom,right

                explanationPanel.add(instr1);
                explanationPanel.add(rules);
                explanationPanel.add(rule1);
                BufferedImage myPicture1;
                BufferedImage myPicture2;
                BufferedImage redo;
                try {
                    myPicture1 = ImageIO.read(getClass().getResource("/instructionvisuals/noneighbor1.png"));
                    JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
                    redo = ImageIO.read(getClass().getResource("/instructionvisuals/redo.png"));
                    JLabel picLabel2 = new JLabel(new ImageIcon(redo));
                    myPicture2 = ImageIO.read(getClass().getResource("/instructionvisuals/noneighbor2.png"));
                    JLabel picLabel3 = new JLabel(new ImageIcon(myPicture2));
                    picLabel1.setBorder(new EmptyBorder(10,10,0,0));//top,left,bottom,right
                    picLabel2.setBorder(new EmptyBorder(0,20,0,0));//top,left,bottom,right
                    picLabel3.setBorder(new EmptyBorder(0,10,10,0));//top,left,bottom,right
                    explanationPanel.add(picLabel1);
                    explanationPanel.add(picLabel2);
                    explanationPanel.add(picLabel3);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                explanationPanel.add(rule2);
                try {
                    myPicture1 = ImageIO.read(getClass().getResource("/instructionvisuals/4neighbor1.png"));
                    JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
                    redo = ImageIO.read(getClass().getResource("/instructionvisuals/redo.png"));
                    JLabel picLabel2 = new JLabel(new ImageIcon(redo));
                    myPicture2 = ImageIO.read(getClass().getResource("/instructionvisuals/4neighbor2.png"));
                    JLabel picLabel3 = new JLabel(new ImageIcon(myPicture2));
                    picLabel1.setBorder(new EmptyBorder(10,10,0,0));//top,left,bottom,right
                    picLabel2.setBorder(new EmptyBorder(0,20,0,0));//top,left,bottom,right
                    picLabel3.setBorder(new EmptyBorder(0,10,10,0));//top,left,bottom,right
                    explanationPanel.add(picLabel1);
                    explanationPanel.add(picLabel2);
                    explanationPanel.add(picLabel3);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                explanationPanel.add(rule3);
                try {
                    myPicture1 = ImageIO.read(getClass().getResource("/instructionvisuals/2or3neighbor1.png"));
                    JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
                    redo = ImageIO.read(getClass().getResource("/instructionvisuals/redo.png"));
                    JLabel picLabel2 = new JLabel(new ImageIcon(redo));
                    myPicture2 = ImageIO.read(getClass().getResource("/instructionvisuals/2or3neighbor2.png"));
                    JLabel picLabel3 = new JLabel(new ImageIcon(myPicture2));
                    picLabel1.setBorder(new EmptyBorder(10,10,0,0));//top,left,bottom,right
                    picLabel2.setBorder(new EmptyBorder(0,20,0,0));//top,left,bottom,right
                    picLabel3.setBorder(new EmptyBorder(0,10,10,0));//top,left,bottom,right
                    explanationPanel.add(picLabel1);
                    explanationPanel.add(picLabel2);
                    explanationPanel.add(picLabel3);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                explanationPanel.add(instr2);
                explanationPanel.add(rule4);
                try {
                    myPicture1 = ImageIO.read(getClass().getResource("/instructionvisuals/empty1.png"));
                    JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
                    redo = ImageIO.read(getClass().getResource("/instructionvisuals/redo.png"));
                    JLabel picLabel2 = new JLabel(new ImageIcon(redo));
                    myPicture2 = ImageIO.read(getClass().getResource("/instructionvisuals/empty2.png"));
                    JLabel picLabel3 = new JLabel(new ImageIcon(myPicture2));
                    picLabel1.setBorder(new EmptyBorder(10,10,0,0));//top,left,bottom,right
                    picLabel2.setBorder(new EmptyBorder(0,20,0,0));//top,left,bottom,right
                    picLabel3.setBorder(new EmptyBorder(0,10,10,0));//top,left,bottom,right
                    explanationPanel.add(picLabel1);
                    explanationPanel.add(picLabel2);
                    explanationPanel.add(picLabel3);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
                g.getContentPane().add(BorderLayout.NORTH, explanationPanel);
                g.pack();
                g.setVisible(true);
            }  
        });
        
        // Start Button
        JButton start = new JButton("Start");

        // Start Button Handler
        start.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                // call calculate generation while there exists a 
                // populated square
                grid.fetchCurrentData(1);

            }
        });

        // Next Button
        JButton next = new JButton("Next");

        // Next Button Handler
        next.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                grid.fetchCurrentData(0);
            }
        });
        
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
    public Color color;

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
        for (int a = 0; a < 15; a++)
        {
            for (int b = 0; b < 15; b++)
            {
                arr[a][b] = 0;
            }
        }

        color = Color.WHITE;
        repaint();
    }
    
    int XPos = 0;
    int YPos = 0;
    int j = 0;

    // Main Function (starts the process)
    // Next generation will be run thru CalculateNeighbors
    public void fetchCurrentData(int flag){
        //flag = getButton();
        boolean repeat = false;

        if (flag == 0)
        {
            j = 1;
        }

        else {
            j = 999;
        }

        for (int die4u = 0; die4u < j; die4u++) {
            repeat = false;
            int[][] nextGenerationGrid = new int[15][15];
            nextGenerationGrid = calculateNeighbours(nextGenerationGrid, arr);
            arr = nextGenerationGrid;
            //flag = getButton();
            // Repainting based on new array
            for (int eggs = 0; eggs < 15; eggs++)
            {
                for (int chicken = 0; chicken < 15; chicken++)
                {
                    if (arr[eggs][chicken] == 1)
                    {
                        repeat = true;
                    }
                }
            }


            //System.out.println(color)

            for (int x = 0; x < 15; x++)
            {
                for (int y = 0; y < 15; y++)
                {   
                    if (arr[x][y] == 1)
                    {
                        //System.out.println("PAINTING!");
                        color = Color.YELLOW;
                        XPos = (x*20)+50;
                        YPos = (y*20)+50;
                        
                        paintImmediately(XPos,YPos,20,20);
                        //repaint(50,50,20,20);
                    }

                    else if (arr[x][y] == 0)
                    {
                        //System.out.println("PAINTING!");
                        color = Color.WHITE;
                        XPos = (x*20)+50;
                        YPos = (y*20)+50;
                        
                        paintImmediately(XPos,YPos,20,20);
                        //repaint(50,50,20,20);
                    }
                }
            }
            
            if (!repeat)
            {
                break;
            }
        }
    }

    //private boolean getButton() {
        /* get the value of button. When start is pressed make the valye b == True and when the stop button is pressed change its value to False */
       // boolean b = true; // Get the value here
        //return b;
   // }

    // 2nd Step
    private int[][] calculateNeighbours(int[][] nextGenerationGrid, int[][] originalGrid) {
        // iterate through all cells and calculate the each cell's neighbors
        for(int i=0; i < 15; i++){
            for(int j=0; j< 15; j++){
                nextGenerationGrid[i][j] = getSumOfNeighnors(originalGrid, 15, 15, i, j);
                //System.out.print(nextGenerationGrid[i][j] + " ");
                // WORKS TILL HERE
            }
            //System.out.println("");
        }

        //System.out.println("OG GRID");

        /*for(int i=0; i < 15; i++){
            for(int j=0; j< 15; j++){
               //originalGrid[i][j] = getSumOfNeighnors(originalGrid, 15, 15, i, j);
                //System.out.print(originalGrid[i][j] + " ");
                // WORKS TILL HERE
            }
            //System.out.println("");
        }*/
        
        return checkFinalAliveOrDead(nextGenerationGrid,originalGrid); // returns resulting next generation grid
    }
    
    // 100% WORKS 
    private int getSumOfNeighnors(int[][] originalGrid, int height, int width, int i, int j) {
        int sum = 0;
        // logic to calculate the total number of neighbors
        if (i != 0 && j != 0){
            if(originalGrid[i-1][j-1] == 1) { // 1st neighbor
                sum++;
            }
        }
        if (i != 0){
            if(originalGrid[i -1][j] == 1){ // 2nd neighbor
                sum++;
            }
        }
        if (i != 0 && j != width -1){//3
            if(originalGrid[i-1][j+1] == 1){ // 3rd neighbor
                sum++;
            }
        }
        if (j != 0){
            if(originalGrid[i][j-1] == 1){ // 4th neighbor
                sum++;
            }
        }
        if (j != width -1){
            if(originalGrid[i][j+1] == 1){ // 5th neighbor
                sum++;
            }
        }
        if (i != height -1 && j != 0){
            if(originalGrid[i +1][j-1] == 1){ // 6th neighbor
                sum++;
            }
        }
        if (i != height -1){
            if(originalGrid[i +1][j] == 1){ // 7th neighbor
                sum++;
            }
        }
        if (i != height -1 && j != width -1){
            if(originalGrid[i+1][j+1] == 1){ // 8th neighbor
                sum++;
            }
        }
        return sum;
    }

    // 3rd step
    // WORKS I THINK
    private int[][] checkFinalAliveOrDead(int[][] nextGenerationGrid1,int[][] originalGrid) {
        // check the number of neighbors and decide if the cell should live or die

        // Rules
        // System.out.println("NEXT GEN GRID YO");
        for(int i=0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(nextGenerationGrid1[i][j] < 2 && originalGrid[i][j] == 1){
                    nextGenerationGrid1[i][j] = 0;
                }
                else if(nextGenerationGrid1[i][j] > 3 && originalGrid[i][j] == 1){
                    nextGenerationGrid1[i][j] = 0;
                }
                else if(nextGenerationGrid1[i][j] == 3 && originalGrid[i][j] == 1){
                    nextGenerationGrid1[i][j] = 1;
                }
                else if(nextGenerationGrid1[i][j] == 2 && originalGrid[i][j] == 1){
                    nextGenerationGrid1[i][j] = 1;
                }
                else if(nextGenerationGrid1[i][j] == 3 && originalGrid[i][j] == 0){
                    nextGenerationGrid1[i][j] = 1;
                }
                else {
                    nextGenerationGrid1[i][j] = 0;
                }

                //System.out.print(nextGenerationGrid1[i][j] + " ");
            }
            //System.out.println();
        }
        return nextGenerationGrid1;
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

