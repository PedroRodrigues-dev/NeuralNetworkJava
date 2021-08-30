/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronotechnology.neuralnetwork;

/**
 *
 * @author pedro
 */
public class NeuralNetwork {
    // Nodes
    private final int i_nodes;
    private final int h_nodes; 
    private final int o_nodes;
    
    // Bias
    private final Matrix bias_ih;
    private final Matrix bias_ho;
    
    // Weigths
    private final Matrix weigths_ih;
    private final Matrix weigths_ho;
    
    // In -> hi -> out
    private Matrix input;
    private Matrix hidden;
    private Matrix output;
    
    public NeuralNetwork(int i_nodes, int h_nodes, int o_nodes){
           this.i_nodes = i_nodes;
           this.h_nodes = h_nodes;
           this.o_nodes = o_nodes;
           
           this.bias_ih = new Matrix(this.h_nodes, 1);
           this.bias_ih.randomize();
           this.bias_ho = new Matrix(this.o_nodes, 1);
           this.bias_ho.randomize();
           
           this.weigths_ih = new Matrix(this.h_nodes, this.i_nodes);
           this.weigths_ih.randomize();
           
           this.weigths_ho = new Matrix(this.o_nodes, this.h_nodes);
           this.weigths_ho.randomize();
            
    }
    
    public void feedforward(double[] input){
        // INPUT -> HIDDEN
        this.input = Matrix.arrayToMatrix(input);
        this.hidden = Matrix.multiply(this.weigths_ih, this.input);
        this.hidden = Matrix.add(hidden, this.bias_ih); 
        this.sigmoid(hidden);

        // HIDDEN -> OUTPUT
        this.output = Matrix.multiply(this.weigths_ho, this.hidden);
        this.output = Matrix.add(output, this.bias_ho); 
        this.sigmoid(output);
        
        this.output.view();
    }
    
    // Sigmoid
    private void sigmoid(Matrix A){
        for (int i = 0; i < A.getRows(); i++) {
            for (int j = 0; j < A.getCols(); j++) {
                A.setData(i,j,1/(1+euler(-A.getData(i, j))));
            }
        }
    }
    
    // Euler
    private double euler(double x){
        double E = Math.E;
        double Exp = Math.pow(E, x);
        return Exp; 
    }
    
}
