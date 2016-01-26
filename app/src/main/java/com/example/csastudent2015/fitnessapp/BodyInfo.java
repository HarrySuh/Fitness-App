package com.example.csastudent2015.fitnessapp;

/**
 * Created by csastudent2015 on 1/12/16.
 */
public class BodyInfo {
    private double weight;
    private double height;
    private static BodyInfo sBodyInfo;

    public static BodyInfo get(){
       if (sBodyInfo == null) {
           sBodyInfo = new BodyInfo();
       }
        return sBodyInfo;
       }



    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }


    public double getBmi() {
        weight = weight * 0.45;
        height = height * 0.025;
        height = Math.pow(height, 2);
        return weight / height;

    }

    public String BmiStatus(double bmi) {

            if (bmi < 18.5) {
                return("You are a little underweight. Try to eat a little more and do some strength work. Aim to get a bmi of 18.5 to 24.9.");
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                return("You are in the healthy bmi range. Maintain this bmi."); }
            else if(bmi >= 25 && bmi < 30.0 ){
                return("You are a little overweight. Try to do some more cardio work and exercise more. Aim to get a bmi of 18.5 to 24.9.");
            }
            else{
                return("You are in the obesity zone. Really focus on exercising more. ");
        }






    }
}



