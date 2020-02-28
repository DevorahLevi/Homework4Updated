package edu.blitstein.caih313.Homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountLinesWords
{
    public static void main(String[] args)
    {
        String homeFolder = System.getenv("HOMEPATH");
        String fileName = homeFolder + "/Box/Java/Homework4/RhetoricExercise.txt";
        System.out.println("The file " + fileName + "\ncontains the following lines:\n");

        Scanner inputStream = null;
        int totalWords = 0, totalLines = 0; int totalCharacters = 0;
        try
        {
            File file = new File(fileName);
            inputStream = new Scanner(file);
            while (inputStream.hasNextLine())
            {
                String line = inputStream.nextLine();
                totalLines++;
                String [] array = line.split(" ");
                totalWords += array.length;

                //finds the amount of non-blank characters
                for (int i = 0; i < array.length; i++)
                {
                    totalCharacters += array[i].length();
                }
            }
            System.out.println("Total Words: " + totalWords);
            System.out.println("Total Lines: " + totalLines);
            System.out.println("Total Characters: " + totalCharacters);
        } catch (FileNotFoundException e)
        {
            System.out.println("Error opening the file " + fileName + ": " + e.getMessage());
        } finally
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
        }
    }
}
