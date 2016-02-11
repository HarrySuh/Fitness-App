package com.example.csastudent2015.fitnessapp;

/**
 * Created by csastudent2015 on 1/12/16.
 */
public class BodyInfo {
    private double weight;
    private double height;
    private static BodyInfo sBodyInfo;

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;

    }
    public void setHeight(double height){
        this.height = height;
    }


    public double getBmi() {
      if(height >= 0 && weight >= 0) {
          return (weight * 0.45) / (Math.pow(height * 0.025, 2));
      }
        else
      {
          return 0;
      }

    }
    public static BodyInfo get(){
        if(sBodyInfo == null){
            sBodyInfo = new BodyInfo();
        }
        return sBodyInfo;
    }




    public String BmiStatus(double bmi) {

            if (bmi < 18.5) {
                return("You are underweight for your size. Try to eat more and build your muscles. Aim to get a BMI between 18.5 to 24.9.");
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                return("You have a healthy BMI. Maintain this BMI."); }
            else if(bmi >= 25 && bmi < 30.0 ){
                return("You are overweight. Try to exercise and maintain a healthy diet. Aim to get a BMI between 18.5 to 24.9.");
            }
            else{
                return("You are obese. Focus on exercise, diet, and find a doctor. Consider calling 1-800-GET-THIN");
        }






    }
}



