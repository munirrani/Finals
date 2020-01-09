package com.company;

import java.util.Scanner;

public class Year20162017Semester2 {

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

        

    }
}
