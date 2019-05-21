/*
Title: Encryption and Decryption of Characters
@author: Seow Hui Yin
Date: 25/02/2018
File Name: AsgmtQ2.java

Purpose: The purpose of this program is to encrypt 
a word or sentence and decrypt the code of the 
previously encrypted sentence.

Input: The user is required to enter 40 characters in
one line in different order from the 40 characters displayed

Output: The program will display encryption and decryption message
from user input.
 */

import java.util.Scanner;

public class AsgmtQ2 {

   public static void main(String[] argv)
    {
        studentInfo();
        Scanner keyboard = new Scanner(System.in);
        String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!., ";
        String mapping;

        System.out.println("26 Upper Case Letters(A-Z),10 Digits(0-9),3 Punctuation Marks(.,!),and 1 Space Character(' ').");
        System.out.println("The 40 characters are: ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,! ");
        System.out.println("Enter 40 Characters and scramble randomly: "); //Prompt user to enter 40 valid characters in random
        mapping = keyboard.nextLine().toUpperCase(); //To uppercase,remove error for small case
        
        //Run this if mapping is valid
        if (isValidMapping(mapping,original))
        {
            System.out.println("\nEnter a sentence: "); //Prompt user to input word or sentence
            String msg = keyboard.nextLine().toUpperCase();
            
            //Loop to encrypt and decrypt message if input is valid
            while (msg.length() !=0)
            {
                String enMsg = encrypt(original, mapping, msg.toUpperCase());
                System.out.println("a) Encrypted message: " + enMsg); //Display encrypted message
                String deMsg = decrypt(original,mapping,enMsg);
                System.out.println("b) Decrypted message: " + deMsg);//Display decrypted message
                System.out.println("\nEnter next sentence:");//Prompt user to enter next message to encrypt
                msg = keyboard.nextLine();
            }
        }
        else
        {
            //Display error message if mapping is invalid
            System.out.println("The mapping is invalid!");
        }
 
    }
    //Method to encrypt message input by user
   //map character to the target character and return target 
    public static String encrypt(String original, String mapping, String msg)
    {
        String result = "";

        for (int i = 0; i < msg.length(); i++)
        {
            char Char = msg.charAt(i);
            int loc = original.indexOf(Char); 
            
            if (loc >= 0)
            {
                char replacement = mapping.charAt(loc);
                result = result + replacement;
            }
            
            else
            {
                result = result + Char;
            }
        }
        return result; //Return encrypt message
        }
    
    //Method to decrypt the previous encrypted message
   //map character to the target character and return target
    public static String decrypt(String original, String mapping, String msg)
    {
        String result = "";
        for (int i = 0; i< msg.length(); i++)
        {
            char Char = msg.charAt(i);
            int loc = mapping.indexOf(Char);
            
            if (loc >= 0)
            {
                char replacement = original.charAt(loc);
                result = result + replacement;
            }
            else
            {
                result = result + Char;
            }
        }
        return result; //Return decrypted message
}
    //Method to check if the mapping string is valid
    public static boolean isValidMapping(String mapping, String original)
    {
        //if mapping characters is less than 40, is invalid
        if(mapping.length() != 40)
        {
            return false;
        }
        int i = 0;
        while(i < mapping.length())
        {
            char Char = mapping.charAt(i); 
            //Check for invalid characters
            if (original.indexOf(Char) == -1)
            {
                return false;
            }
            //Check for duplicate characters  
            for (int j=0; j<40; j++)
            {
                char c = mapping.charAt(i);
                char s = mapping.charAt(j);
                String sub = mapping.substring(i);
                String subs = mapping.substring(j);
                //Compare each character to one index after another to check for duplicate characters
                if (sub.indexOf(c) != subs.lastIndexOf(s)) //Check if two indexes are equal
                {
                    return false;
                }
            }
            i++;
        }
        return true;
        }
    
//Display student information
    public static void studentInfo() 
    {
        System.out.println("Name:Seow Hui Yin");
        System.out.println("Student number:33255186");
        System.out.println("Mode of enrolment:External");
        System.out.println("Tutor name:Mr.Chong");
        System.out.println("Tutorial attendance day:Tuesday");
        System.out.println("Time:8.30pm to 10.30pm");
        System.out.println(" ");
    }
}