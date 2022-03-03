package com.sbaitman.ctci.stringsandarrays;

public class SetZeroMatrix {
    public static int[][] setZerosWithoutExtraSpace(int[][] arr) {
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        //Check if first row has zeros
        for(int j = 0; j < arr[0].length; j ++) {
            if(arr[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        //Check if first col has zeros
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        //Check if rest of the array has zeros and change them
        for(int i = 1; i< arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        //Nullify row based on values in first column
        for(int i = 1; i < arr.length; i++) {
            if(arr[i][0] == 0) {
                nullifyRow(arr, i);
            }
        }

        //Nullify column based on values in first row
        for(int j = 1; j < arr[0].length; j++) {
            if(arr[0][j] == 0) {
                nullifyColumn(arr, j);
            }
        }

        if(firstRowHasZero) {
            nullifyRow(arr, 0);
        }

        if(firstColumnHasZero) {
            nullifyColumn(arr, 0);
        }
        return arr;
    }

    private static void nullifyRow(int[][] arr, int row) {
        for(int j = 0; j < arr.length; j++) {
            arr[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] arr, int column) {
        for(int i = 0; i < arr[0].length; i++) {
            arr[i][column] = 0;
        }
    }

    public static int[][] setZerosWithExtraSpace(int[][] arr) {
        boolean[] rows = new boolean[arr.length];
        boolean[] columns = new boolean[arr[0].length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    rows[i] = true;
                    columns[i] = true;
                }
            }
        }

        //Nullify rows
        for(int i = 0; i < rows.length; i++) {
            if(rows[i]) {
                nullifyRow(arr, i);
            }
        }

        //Nullify columns
        for(int j = 0; j < columns.length; j++) {
            if(columns[j]) {
                nullifyColumn(arr, j);
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
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("Input");
        printMatrix(arr);
        System.out.println("Output");
        int[][] res = setZerosWithoutExtraSpace(arr);
        printMatrix(res);
    }
}
