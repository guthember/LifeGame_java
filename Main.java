/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lifegame;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author tanar
 */
public class Main {
    
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        GridLayout layout = new GridLayout(10, 10);
        CellComponent[][] world = new CellComponent[10][10];
        window.setLayout(layout);
        
        MakeWorld(window, world);
        AddNeighbours(world);
        
        window.setSize(500, 500);
        window.setTitle("Life Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        
    }
    
    private static void SetNeighbourSafely(CellComponent[][] w, CellComponent c, 
            int row, int column){
        if ((row >=0) && (column >=0) && (row < 10) && (column < 10)) {
            c.addNeighbour(w[row][column]);
        }
    }
    
    
    private static void AddNeighbours(CellComponent[][] world){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CellComponent c = world[i][j];
                
                //left lower
                SetNeighbourSafely(world, c, i-1, j-1);
                //lower
                SetNeighbourSafely(world, c, i-1, j);
                //right lower
                SetNeighbourSafely(world, c, i-1, j+1);
                //left
                SetNeighbourSafely(world, c, i, j-1);
                //right
                SetNeighbourSafely(world, c, i, j+1);
                //left upper
                SetNeighbourSafely(world, c, i+1, j-1);
                //upper
                SetNeighbourSafely(world, c, i+1, j);
                //right upper
                SetNeighbourSafely(world, c, i+1, j+1);
                
                c.updateNeighbourNumber();
            }
        }
    }
    
    private static void MakeWorld(JFrame window, CellComponent[][] world)
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CellComponent c = new CellComponent();
                world[i][j] = c;
                window.add(c);
            }
        }
    }
}
