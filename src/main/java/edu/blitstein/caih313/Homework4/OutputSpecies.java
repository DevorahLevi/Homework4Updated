package edu.blitstein.caih313.Homework4;

import java.io.*;
import java.util.Scanner;
import edu.blitstein.caih313.dataObject.Species;

public class OutputSpecies
{
    static Species[] initSpecies;

    //reads a file, with which it instantiates initSpecies
    public static void instantiateSpecies()
    {
        String fileName = "src/main/resources/species.txt";

        Scanner inputStream = null;
        try {
            File file = new File(fileName);
            inputStream = new Scanner(file);
            initSpecies = new Species[3];
            int count = -1;
            while (inputStream.hasNextLine()) {
                count++;
                String line = inputStream.nextLine();
                String[] dataArray = line.split(",");
                String name = dataArray[0];
                int population = Integer.parseInt(dataArray[1]);
                double growthRate = Double.parseDouble(dataArray[2]);
                Species species = new Species(name, population, growthRate);
                initSpecies[count] = species;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void writeOutputBinary()
    {
        String fileName = "src/main/resources/speciesBinaryOutput.dat";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream (new FileOutputStream(fileName))){
            objectOutputStream.writeObject (initSpecies);
        } catch (FileNotFoundException e) {
            System.out.println ("FileNotFoundException thrown writing to file " + fileName + ":" + e.getMessage());
        } catch (IOException e) {
            System.out.println ("IOException thrown writing to file " + fileName + ":" + e.getMessage());
        }
        System.out.println ("Array written to file " + fileName + " and file is closed.");
    }

    public static void main(String[] args)
    {
        OutputSpecies.instantiateSpecies();
        OutputSpecies.writeOutputBinary();
    }
}
