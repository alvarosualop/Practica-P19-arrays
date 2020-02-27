package practica.extra.pkg19;

import java.util.Arrays;
import java.util.Scanner;

public class PracticaExtra19 {

    static Scanner keyboard = new Scanner(System.in);
    static int Nmaxteams;
    static String[] arrayteams;
    static int[] arraypoints;
    static int[] arraygoals;
    static int[] arraygoalsrecived;

    public static void main(String[] args) {
        keyboard.useDelimiter("\n");//permite espacios en el input por el user usando keyboard

        int option = -1;

        do {
            userMenu();
            option = keyboard.nextInt();
            switch (option) {
                case 1:

                    System.out.println("How many teams are in the competition?: ");
                    Nmaxteams = keyboard.nextInt();

                    arrayteams = new String[Nmaxteams];
                    arraygoals = new int[Nmaxteams];
                    arraypoints = new int[Nmaxteams];
                    arraygoalsrecived = new int[Nmaxteams];
                    arraypoints = new int[Nmaxteams];

                    for (int i = 0; i < arrayteams.length; i++) {
                        System.out.println("What is the name of team [" + i + "] ?: ");
                        arrayteams[i] = keyboard.next();
                        System.out.println("How many goals has marked this team?: ");
                        arraygoals[i] = keyboard.nextInt();
                        System.out.println("How many goals has been marked to this team?: ");
                        arraygoalsrecived[i] = keyboard.nextInt();
                        System.out.println("How many points has this team?:");
                        arraypoints[i] = keyboard.nextInt();

                    }

                    break;
                case 2:

                    viewWinner(arrayteams, arraygoals, arraypoints);

                    break;

                case 3:

                    viewSecondpos(arrayteams, arraygoals, arraypoints);

                    break;

                case 4:

                    viewBestDefensor(arrayteams, arraygoalsrecived);

                    break;

                case 5:

                    viewBestgoals(arrayteams, arraygoals);

                    break;

                case 6:

                    viewAverage(arrayteams, arraygoals, arraygoalsrecived);

                    break;

                case 7:

                    viewTeamdesc(arrayteams, arraypoints);

                    break;

                case 8:

                    viewEx1(arrayteams, arraygoals, arraygoalsrecived, arraypoints);

                case 10:

                    System.out.println("Thanks for correct my practice.");
                    break;

                default:
                    System.out.println("Error. Try again.");
            }
        } while (option != 10);
    }

    private static void userMenu() {
        System.out.println("Excersise 1: Input teams data");
        System.out.println("Excersise 2: View winner team");
        System.out.println("Excersise 3: View team in second position");
        System.out.println("Excersise 4: Best team defending");
        System.out.println("Excersise 5: Best team marking goals");
        System.out.println("Excersise 6: Goals average.");
        System.out.println("Excersise 7: Teams descend");
        System.out.println("Excersise 8: View all results");
        System.out.println("Excersise 10: Exit from the application");
        System.out.print("Try your option: ");
    }

    private static void viewEx1(String[] arrayteams, int[] arraygoals, int[] arraygoalsrecived1, int[] arraypoints1) {
        for (int i = 0; i < arrayteams.length; i++) {
            System.out.println("The team " + arrayteams[i] + " has marked " + arraygoals[i] + " goals");
            System.out.println("The team " + arrayteams[i] + " has been recived " + arraygoalsrecived[i] + " goals");
            System.out.println("The team " + arrayteams[i] + " has " + arraypoints[i] + " points");
        }
    }

    private static void viewWinner(String[] arrayteams, int[] arraygoals, int[] arraypoints1) {

        int winner = 0;
        int positionMax = 0;
        for (int i = 0; i < arrayteams.length; i++) {
            if (arraypoints[i] > winner) {
                winner = arraypoints[i];
                positionMax = i;
            }
        }

        System.out.println("The winner team is " + arrayteams[positionMax] + " with " + arraypoints[positionMax] + " points.");
    }

    private static void viewSecondpos(String[] arrayteams, int[] arraygoals, int[] arraypoints) {
        int secondplace = 0;
        int secondposition = 0;
        for (int i = 0; i < arrayteams.length; i++) {
            if (arraypoints[i] < secondplace && arraypoints[i] > secondposition) {
                secondplace = arraypoints[i];
                secondposition = i;
            }
        }

        System.out.println("The team on the second position is " + arrayteams[secondposition] + " with " + arraypoints[secondposition] + " points");

    }

    private static void viewBestDefensor(String[] arrayteams, int[] arraygoalsrecived) {

        int defensor = 0;
        int positionDef = 0;

        for (int i = 0; i < arrayteams.length; i++) {
            if (arraygoalsrecived[i] < defensor) {
                defensor = arraygoalsrecived[i];
                positionDef = i;
            }
        }
        System.out.println("The best defensor team is " + arrayteams[positionDef] + " with " + arraygoalsrecived[positionDef] + " goals.");

    }

    private static void viewBestgoals(String[] arrayteams, int[] arraygoals) {

        int bestmarker = 0;
        int positionMark = 0;

        for (int i = 0; i < arrayteams.length; i++) {
            if (arraygoals[i] > bestmarker) {
                bestmarker = arraygoals[i];
                positionMark = i;
            }
        }
        System.out.println("The team who has marked more goals was " + arrayteams[positionMark] + " with " + arraygoals[positionMark] + " goals.");
    }

    private static void viewAverage(String[] arrayteams, int[] arraygoals, int[] arraygoalsrecived) {

        int averagegoalsmark = 0;
        int averagegoalsreceived = 0;
        int sum = 0;

        for (int i = 0; i < arrayteams.length; i++) {
            averagegoalsmark = arraygoals[i];
            averagegoalsreceived = arraygoalsrecived[i];
        }
        averagegoalsmark ++;
        float averagemark = averagegoalsmark / arrayteams.length;
        float averagereceived = averagegoalsreceived / arrayteams.length;

        System.out.println("The average of the goals marked is " + averagemark + " goals and the average of the goals received is " + averagereceived + " goals.");
    }

    private static void viewTeamdesc(String[] arrayteams, int[] arraypoints) {

        System.out.println("Input the name of the team that you want to know if go out from classification: ");

        int loser = 0;
        int teaminput = keyboard.nextInt();
        for (int i = 0; i < arrayteams.length; i++) {
            if (arraypoints[i] < teaminput) {
                loser = arraypoints[i];
                System.out.println("The team " + teaminput + " goes out from the classification.");
            } else {
                System.out.println("The team " + teaminput + " keeps on the classification.");
            }
        }

    }
}
