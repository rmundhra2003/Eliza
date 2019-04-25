package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
Program to create an interactive chat-bot type program. Eliza is a therapist program that interacts with the user.
Your program will need to evaluate what the user asks and turn the user's input into a question that sounds like the
therapist really cares.
Sample hedges:

Please tell me more
Many of my patients tell me the same thing
It is getting late, maybe we had better quit
Sample qualifiers:

Why do you say that
You seem to think that
So, you are concerned that
Replacements:

replace i with you
replace me with you
replace my with your
replace am with are


When the user enters a statement the program responds in one of two ways:

1. With a randomly chosen hedge, such as "Please tell me more"

2. By changing some keywords  in the user's input string an appending this string to a randomly chosen qualifier.
   To get a random item from an array, select a random number for one of the array index values and use the value at that
   index for your qualifier.
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner keyboard = new Scanner(System.in);
        String inputStr = "y";
        int iterations = 0;
        System.out.print("Good day. What is your problem? Enter your response here or Q to quit: ");
        inputStr = keyboard.nextLine();

        //Loop through until user enters "Q" and respond by calling method replaceTokens()
        while(!(inputStr.equalsIgnoreCase("Q")) &&
                !(inputStr.equalsIgnoreCase("I am feeling great"))) {
            String response = replaceTokens(inputStr, iterations);
            //System.out.print(""+response +"\n");
            keyboard.nextLine();
            iterations++;
            System.out.print("Enter your response here or Q to quit: ");
            inputStr = keyboard.nextLine();
        }
    }
    /*Method to replace tokens and responds to user input
     *
        When the user enters a statement the program responds in one of two ways:

        1. With a randomly chosen hedge, such as "Please tell me more"

        2. By changing some keywords  in the user's input string an appending this string to a randomly chosen qualifier.
           To get a random item from an array, select a random number for one of the array index values and use the value at that
           index for your qualifier.
     */
    public static String replaceTokens(String str, int iterations) {
        String returnStr = "";
        String [] strArray = str.split(" ");
        for(String s :strArray) {
            if(s.equalsIgnoreCase("i")) {
                //replace with you
                if(returnStr.equals(""))
                    returnStr = returnStr.concat("You ");
                else
                    returnStr = returnStr.concat("you ");
            }
            else if(s.equalsIgnoreCase("me")) {
                //replace with you
                if(returnStr.equals(""))
                    returnStr = returnStr.concat("You ");
                else
                    returnStr = returnStr.concat("you ");
            }
            else if(s.equalsIgnoreCase("my")) {
                //replace with your
                if(returnStr.equals(""))
                    returnStr = returnStr.concat("Your ");
                else
                    returnStr = returnStr.concat("your ");
            }
            else if(s.equalsIgnoreCase("am")) {
                //replace with are
                if(returnStr.equals(""))
                    returnStr = returnStr.concat("Are ");
                else
                    returnStr = returnStr.concat("are ");
            } else {
                //append the string to returnStr
                returnStr = returnStr.concat(s);
                returnStr = returnStr.concat(" ");
            }
        }
        returnStr = returnStr.toLowerCase();
        if (iterations %2 == 0) {
            printFromQualifiers(iterations);
            System.out.println(" " + returnStr + "?");
        }
        else
            printFromHedgeArray(iterations);
        return returnStr;

    }
    /*
       Method to print from qualifiers randomly:
        Why do you say that
        You seem to think that
        So, you are concerned that

     */
    public static void printFromQualifiers(int iterations) {
        ArrayList<String> qualifierArray = new ArrayList<String>();
        Random random = new Random();
        qualifierArray.add("Why do you say that");
        qualifierArray.add("You seem to think that");
        qualifierArray.add("So, you are concerned that");

        Collections.shuffle(qualifierArray);

        System.out.print(""+qualifierArray.get(1));
    }
    /*
       Method to print from hedges randomly:
        Please tell me more
        Many of my patients tell me the same thing
        It is getting late, maybe we had better quit
     */
    public static void printFromHedgeArray(int iterations) {
        ArrayList<String> hedgeArray = new ArrayList<String>();

        hedgeArray.add("Please tell me more");
        hedgeArray.add("Many of my patients tell me the same thing");
        hedgeArray.add("It is getting late, maybe we had better quit");

        if(iterations == 2)
            System.out.println(""+hedgeArray.get(0));
        else {
            Random random = new Random();
            int index = random.nextInt(3);
            if(index == 0) index++;
            System.out.println("" +hedgeArray.get(index));
        }

    }
}

