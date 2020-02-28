package edu.blitstein.caih313.dataObject;

import java.io.Serializable;

public class Species implements Serializable
{
    private String name;
    private int population;
    private double growthRate;

    public Species(String name, int population, double growthRate) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        } else if (population < 0) {
            throw new IllegalArgumentException("population must be positive");
        }
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
    }

    @Override
    public String toString() {
        return ("{Name = " + name +
                ", Population = " + population +
                ", Growth rate = " + growthRate + "%}");
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getGrowthRate() {
        return growthRate;
    }
}