package lab05; //Camellia and Rebecca

import java.util.Scanner;

public class Life {

    public void startGrid(String start, boolean[][] cell, int width, int height) {                                                                          
        
        String[] nextLn = start.split("\n");                                                                                                                
                                                                                                                                                            
        String[][] single = new String[height][];                                                                                                           
        int maxWidth = (cell[30].length - width) / 2;                                                                                                       
        int maxHeight = (cell.length - height) / 2;                                                                                                         
                                                                                                                                                            
        // separates each character per line and adds it in array form                                                                                       
        for (int i = 0; i < nextLn.length; i++) {                                                                                                            
            single[i] = nextLn[i].split("");                                                                                                                
        }           
        
        // adds * into array                                                                                                                                
        for (int i = 0; i < single.length; i++) {                                                                                                           
            for (int j = 0; j < single[i].length; j++) {                                                                                                    
                if (single[i][j].equals("*"))                                                                                                               
                    cell[i + maxHeight][j + maxWidth] = true;                                                                                               
            }                                                                                                                                               
        }
    }                                                                                                                                                       
                                                                                                                                                            
    public void updateCells(boolean[][] grid) {                                                                                                              
        int neighboringCells = 0;                                                                                                                           
                                                                                                                                                            
        // copies cell, so that if we change cell to have the asterisks, then it won't affect the other cells                                                                                                                      
        boolean[][] originalGrid = new boolean[60][200];                                                                                                         
                                                                                                                                                            
        for (int i = 0; i < grid.length; i++) {                                                                                                             
            for (int j = 0; j < grid[i].length; j++) {                                                                                                      
                originalGrid[i][j] = grid[i][j];                                                                                                                 
            }                                                                                                                                               
        }                                                                                                                                                   
                                                                                                                                                            
        //updates the grid                                                                                                                                          
        for (int i = 0; i < grid.length; i++) {                                                                                                             
            for (int j = 0; j < grid[i].length; j++) {                                                                                                      
                neighboringCells = 0;                                                                                                                       
                                                                                                                                                            
                if (j > 0) { // in case j becomes less than the available index, this stops the error                                                       
                    if (i < originalGrid.length - 1) { // this stops the Indexoutofbounds error for i                                                            
                        if (originalGrid[i + 1][j - 1]) {                                                                                                        
                            neighboringCells++;                                                                                                             
                        }                                                                                                                                   
                    }
                    
                    if (originalGrid[i][j - 1]) {                                                                                                                
                        neighboringCells++;                                                                                                                 
                    }
                    
                    if (i > 0) { // negative index error for i                                                                                              
                        if (originalGrid[i - 1][j - 1]) {                                                                                                        
                            neighboringCells++;                                                                                                             
                        }                                                                                                                                   
                    }                                                                                                                                       
                }                                                                                                                                           
                if (j < originalGrid[i].length - 1) { // this stops the Indexoutofbounds error for j                                                             
                    if (i < originalGrid.length - 1) { // this stops the Indexoutofbounds error for i                                                            
                        if (originalGrid[i + 1][j + 1]) {                                                                                                        
                            neighboringCells++;                                                                                                             
                        }                                                                                                                                   
                    }
                    
                    if (originalGrid[i][j + 1]) {                                                                                                                
                        neighboringCells++;                                                                                                                 
                    }
                    
                    if (i > 0) { // negative index error for i                                                                                              
                        if (originalGrid[i - 1][j + 1]) {                                                                                                        
                            neighboringCells++;                                                                                                             
                        }                                                                                                                                   
                    }                                                                                                                                       
                }                                                                                                                                           
                                                                                                                                                            
                if (i < originalGrid.length - 1) { // this stops the Indexoutofbounds error for i                                                                
                    if (originalGrid[i + 1][j]) {                                                                                                                
                        neighboringCells++;                                                                                                                 
                    }                                                                                                                                       
                }
                
                if (i > 0) { // negative index for i                                                                                                        
                    if (originalGrid[i - 1][j]) {                                                                                                                
                        neighboringCells++;                                                                                                                 
                // finding neighbors terminated                                                                                                             
                    }                                                                                                                                       
                }                                                                                                                                           
                                                                                                                                                            
                // if statement = true, updates to have or not have asterisk                                                                                
                if (grid[i][j] && (neighboringCells < 2 || neighboringCells > 3)) {                                                                         
                    grid[i][j] = false;
                    
                } else if (!grid[i][j] && neighboringCells == 3) {                                                                                          
                    grid[i][j] = true;                                                                                                                      
                }                                                                                                                                           
            }                                                                                                                                               
        }                                                                                                                                                   
    }                                                                                                                                                       
                                                                                                                                                            
    public void printCells(boolean[][] grid) { //prints the cells onto the screen                                                                            
        for (int i = 0; i < grid.length; i++) {                                                                                                             
            for (int j = 0; j < grid[i].length; j++) {                                                                                                      
                if (grid[i][j]) {                                                                                                                           
                    System.out.print("*");
                    
                } else {                                                                                                                                    
                    System.out.print(" ");                                                                                                                  
                }                                                                                                                                           
            }                                                                                                                                               
            System.out.println();                                                                                                                           
        }                                                                                                                                                   
    }                                                                                                                                                       
                                                                                                                                                            
    public static void main(String[] args) {                                                                                                                
        Scanner sc = new Scanner(System.in);                                                                                                             
        Life life = new Life();                                                                                                                             
                                                                                                                                                            
        boolean[][] grid = new boolean[60][200]; //size of the grid                                                                                         
        String startingCells, temp = "", choice;                                                                                                            
        int n = 1, numLine = 0, largestWidth = 0;                                                                                                           
                                                                                                                                                            
        // default                                                                                                                                          
        for (int i = 0; i < grid.length; i++) {                                                                                                             
            for (int j = 0; j < grid[i].length; j++) {                                                                                                      
                grid[i][j] = false;                                                                                                                         
            }                                                                                                                                               
        }                                                                                                                                                   
                                                                                                                                                            
        System.out.println("Enter starting arrangement of spaces, asterisks and returns, followed by a line with the letter \"Q\" to start the simulator:");
                                                                                                                                                            
        startingCells = sc.nextLine();                                                                                                                   
        while (!startingCells.equals("Q")) {                                                                                                                
            if (largestWidth < startingCells.length())                                                                                                      
                largestWidth = startingCells.length();                                                                                                      
            numLine++;                                                                                                                                      
            temp += startingCells + "\n";                                                                                                                   
            startingCells = sc.nextLine();                                                                                                               
        } 
        
        startingCells = temp;                                                                                                                               
                                                                                                                                                            
        life.startGrid(startingCells, grid, largestWidth, numLine);                                                                                         
                                                                                                                                                            
        System.out.println("-------------------\n");
                                                                                                                                                            
        boolean forever = false;                                                                                                                            
                                                                                                                                                            
        while ((forever) || (n > 0)) {                                                                                                                      
            life.printCells(grid);                                                                                                                           
            life.updateCells(grid);                                                                                                                          
                                                                                                                                                            
            n--;                                                                                                                                            
            if ((!forever) && (n == 0)) {                                                                                                                   
                System.out.println("Input g for \"go forever\", an integer n for n generations, or enter for the next step:");                              
                choice = sc.nextLine();                                                                                                                  
                                                                                                                                                            
                try {                                                                                                                                       
                    n = Integer.parseInt(choice);
                    
                } catch (NumberFormatException e) {                                                                                                         
                    if (choice.equals("g")) {                                                                                                               
                        forever = true;
                        
                    } else if (choice.equals("")) {                                                                                                         
                        n = 1;
                        
                	} else {                                                                                                                                
                        System.out.println();                                                                                                               
                    }                                                                                                                                       
                }                                                                                                                                           
            }                                                                                                                                               
        }                                                                                                                                                   
    }                                                                                                                                                       
                                                                                                                                                            
}                                                                                                                                                                                        