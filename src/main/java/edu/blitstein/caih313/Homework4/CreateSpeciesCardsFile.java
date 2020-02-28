package edu.blitstein.caih313.Homework4;

import java.io.*;

import edu.blitstein.caih313.dataObject.Species;

public class CreateSpeciesCardsFile
{
    public static Species [] readBinarySpeciesInput()
    {
        String fileName = "src/main/resources/speciesBinaryOutput.dat";
        Species[] readFromFileSpecies = null;
        try (ObjectInputStream inputStream = new ObjectInputStream (new FileInputStream(fileName))) {
            readFromFileSpecies = (Species[]) inputStream.readObject ();
        } catch (Exception e) {
            System.out.println ("Error reading file " + fileName + ": " + e.getMessage());
        }
        return readFromFileSpecies;
    }

    public static void createCards(Species [] array)
    {
        String fileName = "src/main/resources/speciesCards.txt";
        PrintWriter printWriter = null;
        try
        {
            printWriter = new PrintWriter(fileName);
            for (int i = 0; i < array.length; i++)
            {
                printWriter.println("Name: " + array[i].getName());
                printWriter.println("Population: " + array[i].getPopulation());
                printWriter.println("Growth Rate: " + array[i].getGrowthRate() + "%");
                printWriter.println();
                printWriter.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public static void main(String[] args)
    {
        Species [] speciesArray;
        speciesArray = CreateSpeciesCardsFile.readBinarySpeciesInput();
        CreateSpeciesCardsFile.createCards(speciesArray);
    }
}
