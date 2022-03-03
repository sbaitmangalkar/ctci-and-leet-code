package com.sbaitman.ctci.stringsandarrays;

public class RotateMatrix {
    public static int[][] rotateMatrixClockWiseBy90Degrees(int[][] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        if(arr.length != arr[0].length) {
            System.out.println("Matrix is not a NxN matrix");
            return null;
        }

        int n = arr.length;
        //For each layer i
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - 1 - i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - j][i];
                arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
                arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
                arr[j][n - 1 - i] = temp;
            }
        }
        return arr;
    }

    public static void printMatrix(int[][]arr) {
        if(arr != null) {
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Input");
        printMatrix(arr);

        int[][]res = rotateMatrixClockWiseBy90Degrees(arr);
        System.out.println("Result");
        printMatrix(res);
    }
}
