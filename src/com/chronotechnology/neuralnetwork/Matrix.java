/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronotechnology.neuralnetwork;

import java.util.Random;

/**
 *
 * @author pedro
 */
public final class Matrix {

    // Declarations
    private final int rows;
    private final int cols;
    private final double[][] data;
    private final Random random = new Random();

    // Constructor
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = 0;
            }
        }
    }

    // Array to Matrix
    public static Matrix arrayToMatrix(double[] arr) {
        int rows = arr.length;
        int cols = 1;
        Matrix R = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                R.data[i][j] = arr[i];
            }
        }
        return R;
    }

    // Randomize
    public void randomize() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                data[i][j] = random.nextDouble();
            }
        }
    }

    // Operations 
    public static Matrix add(Matrix A, Matrix B) {
        Matrix R = new Matrix(A.rows, A.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < A.cols; j++) {
                R.data[i][j] = A.data[i][j] + B.data[i][j];
            }
        }
        return R;
    }

    public static Matrix multiply(Matrix A, Matrix B) {
        Matrix R = new Matrix(A.rows, B.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < B.cols; j++) {
                double sum = 0;
                for (int k = 0; k < A.cols; k++) {
                    double elm1 = A.data[i][k];
                    double elm2 = B.data[k][j];
                    sum += elm1 * elm2;
                    R.data[i][j] = sum;
                }
            }
        }
        return R;
    }

    // Debug
    public void view() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(" " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Getters and Setters
    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }
    
    public double getData(int i, int j){
        return this.data[i][j];
    }
    
    public void setData(int i , int j, double value){
        this.data[i][j] = value;
    }
}
