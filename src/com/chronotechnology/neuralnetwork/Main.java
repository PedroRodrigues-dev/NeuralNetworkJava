/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronotechnology.neuralnetwork;

import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author pedro
 */
public class Main {
    
    // One time code
    private static void setup(){
        Main.createFrameCanva(500,500,Color.BLACK);
        
        NeuralNetwork nn = new NeuralNetwork(1,3,5);
        double[] arr = {1,2}; 
        nn.feedforward(arr);
    }
    
    // 30 fps code
    private static void draw(){
        
    }
    
    // Attributes
    public static boolean debug;
    
    // Main method
    public static void main(String[] args) {       
        // Start
        Main.setup();
        Main.start();
    }
    
    // Tick
    public static void start(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 30.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		for(;;) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
                                Main.draw();
				delta--;
			}
		}

	}
    
    // Create frame and canva
    private static void createFrameCanva(int width, int height, Color color) {
        JFrame frame = new JFrame("NeuralNetwork");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(width, height);
        Canvas canva = new Canvas();
        canva.setSize(width, height);
        frame.add(canva);
        frame.setVisible(true);
        canva.setBackground(color);
    }
    
}
