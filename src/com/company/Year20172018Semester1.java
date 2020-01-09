package com.company;

import java.util.Scanner;

public class Year20172018Semester1 {

    /*
    Note: Just assume the final output is exactly the same as on the question paper. Goodluck!
     */

    Year20172018Semester1() {

        /*
        Q3
         */
        int fontSize, format;
        String fontType;
        int width, height, middleIndex;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter font size: ");
        fontSize = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter font type: ");
        fontType = scanner.nextLine();
        System.out.print("Enter format [1 - Vertical, 2 - Horizontal]: ");
        format = scanner.nextInt();

        /*
        When printing vertically (format 1)

            If font size 1, width is 3, height is 5
            If font size 3, width is 5, height is 9

            General formula:
                width = n + 2
                height = 2n + 3

            Printing by each row: First, middle, last
            Printing by each column: First and last

        When printing horizontally (format 2)

            If font size 1, width is 5, height is 2
            If font size 4, width is 11, height is 6

            General formula:
                 width = 2n + 3
                 height = n + 2

            Printing by each row: First and last
            Printing by each column: First, middle, last
         */


        if (format == 1) {
            width = fontSize + 2;
            height = 2 * fontSize + 3;
            middleIndex = height / 2;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 || i == middleIndex || i == height - 1) {
                        System.out.print(fontType);
                    } else {
                        if (j == 0 || j == width - 1) {
                            System.out.print(fontType);
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        } else {
            width = 2 * fontSize + 3;
            height = fontSize + 2;
            middleIndex = width / 2;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 || i == height - 1) {
                        System.out.print(fontType);
                    } else {
                        if (j == 0 || j == middleIndex || j == width - 1) {
                            System.out.print(fontType);
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }

    }
}
