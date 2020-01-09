package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Year20162017Semester2 {

    // Q3 variables
    static int n;
    static int[] numbers;

    Year20162017Semester2() {
        /*
        Q2
        Write a program that asks a user to enter the number of teams, their team names,
        and their scores based on the table below. Then, display the team names and their scores
        in descending order with the highest team score first. (Save the program in the Main.java file.
        Copy this file to your exam account directory and rename as [matricNumberQ2.java; example: WIA160001Q2.java].
        */
        int numberOfTeams;
        String[] team = new String[10];
        int[] score = new int[10];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of teams: ");
        numberOfTeams = scanner.nextInt();
        scanner.nextLine();
        int n = 0;
        while (n < numberOfTeams) {
            System.out.print("Enter the team " + (n+1) + " name: ");
            team[n] = scanner.nextLine();
            System.out.print("Enter the team " + (n+1) + " score: ");
            score[n] = scanner.nextInt();
            scanner.nextLine();
            n++;
        }

        int scoreTemp;
        String teamTemp;

        //Sort
        for (int i = 0; i < numberOfTeams; i++) {
            for (int j = 0; j < numberOfTeams; j++) {
                if (j == numberOfTeams - 1) continue;
                if (score[j] < score[j+1]) {
                    scoreTemp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = scoreTemp;

                    teamTemp = team[j];
                    team[j] = team[j+1];
                    team[j+1] = teamTemp;
                }
            }
        }

        System.out.println("List of team with the highest team score first");
        for (int i = 0; i < numberOfTeams; i++) {
            System.out.print(team[i] + " (" + score[i] + ") |" );
        }
        System.out.println();


        /*
        Q3
        Write a program that asks a user to enter an integer value, n. Based on this integer value,
        the program should generate a set of random values within the range of 0-10000.
        Store these values in an array. Then, create FOUR methods to perform the following actions.
        - Display the set of integers in the array.
        - Get the minimum number.
        - Display the approximation of each integer value to the nearest hundred.
        - Display each integer in the array in a reverse order.
         */
        scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        n = scanner.nextInt();

        numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(10000+1);
        }

        displayNumbers();
        displayMinimumNumber();
        displayApproximationToHundred();
        displayInReverseOrder();

        /*
        Q4
        In Q4.dat:
        25/3/2017
        29/2/2100
        19/1/2017
        31/9/2015
        29/2/2016
         */
        String line;
        String[] values;
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("Q4.dat")));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                values = line.split("/");
                DayOfTheWeek dayOfTheWeek = new DayOfTheWeek(
                        Integer.valueOf(values[0]), Integer.valueOf(values[1]), Integer.valueOf(values[2])
                );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void displayNumbers() {
        System.out.print("The random integer : ");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    private static void displayMinimumNumber() {
        int num = 10000;
        for (int i = 0; i < n; i++) {
            if (numbers[i] < num) num = numbers[i];
        }
        System.out.println("Minimum number : " + num);
    }

    private static void displayApproximationToHundred() {
        System.out.print("The approximation of the integer to the nearest hundred : ");
        for (int i = 0; i < n; i++) {
            // 53 -> 100
            // 42 -> 0
            // 123 -> 100
            // 450 -> 500
            // 1234 -> 1200
            // 10000 -> 10000
            int digits = 0;
            int number;
            int tenths;
            for (int a = numbers[i]; a > 0; a /= 10) digits++;

            if (digits == 5) { // 10000 only
                number = 10000;
            } else if (digits <= 2) { // 0 - 99
                if (numbers[i] < 50) {
                    number = 0;
                } else {
                    number = 100;
                }
            } else { // digits 3 and 4
                number = numbers[i];
                tenths = number % 100;
                number = number - tenths;
                if (tenths >= 50) {
                    number += 100;
                }
            }
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void displayInReverseOrder() {
        System.out.print("The random integer in reverse order: ");
        String value;
        for (int i = 0; i < n; i++) {
            value = String.valueOf(numbers[i]);

            String newValue = "";
            for (int j = value.length() - 1; j >= 0; j--) {
                newValue = newValue.concat(String.valueOf(value.charAt(j)));
            }
            System.out.print(newValue + " ");
        }
        System.out.println();
    }
}
