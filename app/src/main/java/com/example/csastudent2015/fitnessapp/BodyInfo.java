package com.example.csastudent2015.fitnessapp;

/**
 * Created by csastudent2015 on 1/12/16.
 */
public class BodyInfo {
    private static double weight;
    private double height;
    public double getHeight()
    {
        return height;
    }
   public static double getWeight()
   {
       return weight;
   }


public double getBmi(){
    weight = weight * 0.45;
    height = height * 0.025;
    height = Math.pow(height, 2);
    return weight/height ;

}


}



