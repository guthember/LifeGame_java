/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lifegame;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author tanar
 */
public class CellComponent extends JButton implements ActionListener
{
    private boolean alive;
    private ArrayList<CellComponent> neighbours;
    
    
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        
        if (alive) {
            this.setBackground(Color.white);
        }
        else {
            this.setBackground(Color.black);
        }
    }

    public CellComponent() {
        neighbours = new ArrayList<CellComponent>();
        this.setAlive(false);
        this.addActionListener(this);
        this.setForeground(Color.red);
    }

    public void addNeighbour(CellComponent c){
        neighbours.add(c);
    }
    
    public void updateNeighbourNumber(){
        int count = this.neighbours.size();
        this.setText("Sz:"+count);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.setAlive(!this.isAlive());
    }
    
    
}
