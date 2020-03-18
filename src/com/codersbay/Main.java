package com.codersbay;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter the number of generations you want to play:");

        int[][] lifeArray = new int[20][20];
        int[][] newGenerationArray = new int[20][20];
        Scanner scan = new Scanner(System.in);
        int generations = scan.nextInt();

        //create Start pattern
        lifeArray[9][10] = 1;
        lifeArray[10][9] = 1;
        lifeArray[10][10] = 1;
        lifeArray[10][11] = 1;
        lifeArray[11][9] = 1;
        lifeArray[11][11] = 1;
        lifeArray[12][10] = 1;

        printArray(lifeArray);

        for (int i = 0; i <= generations; i++) {

            copyArray(lifeArray, newGenerationArray);

            for (int x = 0; x < lifeArray.length - 1; x++) {
                for (int y = 1; y < lifeArray[i].length - 1; y++) {
                    int neighbors = lifeArray[x - 1][y - 1] + lifeArray[x - 1][y] + lifeArray[x - 1][y + 1] + lifeArray[x][y - 1] +
                            lifeArray[x][y + 1] + lifeArray[x + 1][y - 1] + lifeArray[x + 1][y] + lifeArray[x + 1][y + 1];
                    if (lifeArray[x][y] == 0 && neighbors == 3) {
                        newGenerationArray[x][y] = 1;
                    } else if (lifeArray[x][y] == 1 && neighbors == 2) {
                        newGenerationArray[x][y] = 0;
                    } else if (lifeArray[x][y] == 1 && neighbors < 2) {
                        newGenerationArray[x][y] = 1;
                    } else if (lifeArray[x][y] == 1 && neighbors == 3) {
                        newGenerationArray[x][y] = 1;
                    } else if (lifeArray[x][y] == 1 && neighbors > 3) {
                        newGenerationArray[x][y] = 0;
                    }
                }

            }

            printArray(newGenerationArray);

        }

    }

    private static void copyArray(int[][] lifeArray, int[][] newGenerationArray) {
        for (int i = 0; i < lifeArray.length; i++) {
            for (int k = 0; k < lifeArray[i].length; k++) {
                lifeArray[i][k] = newGenerationArray[i][k];
            }
        }
    }

    private static void printArray(int[][] lifeArray) {
        for (int i = 0; i < lifeArray.length; i++) {
            for (int k = 0; k < lifeArray[i].length; k++) {
                if (lifeArray[i][k] == 1) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

}

