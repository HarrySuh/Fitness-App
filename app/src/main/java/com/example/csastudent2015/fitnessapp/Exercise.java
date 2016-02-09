package com.example.csastudent2015.fitnessapp;

/**
 * Created by csastudent2015 on 1/12/16.
 */
public class Exercise {
    private int closeWeight;
    private double calories;
    private double hours;

    public Exercise(double minutes)
    {
        int weight = (int)BodyInfo.get().getWeight();
        int low = Math.abs(weight - 130);
        int med = Math.abs(weight - 155);
        int high = Math.abs(weight - 180);
        int extreme = Math.abs(weight - 205);
        int lowMed = Math.min(low, med);
        int highExtreme = Math.min(high, extreme);
        closeWeight = weight-Math.min(lowMed, highExtreme);
        hours = minutes/60;
    }

    //aerobics, basketball, cycling, running, swimming, walking
    public void burn(String exercise) {
        if (closeWeight == 130) {
            if (exercise.equals("Aerobics")) {
                calories += 384 * hours;
            }
            if (exercise.equals("Basketball, shooting baskets")) {
                calories += 266 * hours;
            }
            if (exercise.equals("Cycling, 10mph, leisure bicycling")) {
                calories += 236 * hours;
            }
            if (exercise.equals("Running, 5 mph (12 minute mile)")) {
                calories += 472 * hours;
            }
            if (exercise.equals("Running, 10 mph (6 min mile)")) {
                calories += 944 * hours;
            }
            if (exercise.equals("Swimming laps, freestyle, fast")) {
                calories += 590 * hours;
            }
            if (exercise.equals("Walking 3.0 mph, moderate")) {
                calories += 195 * hours;
            }
        }

        if (closeWeight == 155) {
            if (exercise.equals("Aerobics")) {
                calories += 457 * hours;
            }
            if (exercise.equals("Basketball, shooting baskets")) {
                calories += 317 * hours;
            }
            if (exercise.equals("Cycling, 10mph, leisure bicycling")) {
                calories += 281 * hours;
            }
            if (exercise.equals("Running, 5 mph (12 minute mile)")) {
                calories += 563 * hours;
            }
            if (exercise.equals("Running, 10 mph (6 min mile)")) {
                calories += 1126 * hours;
            }
            if (exercise.equals("Swimming laps, freestyle, fast")) {
                calories += 704 * hours;
            }
            if (exercise.equals("Walking 3.0 mph, moderate")) {
                calories += 232 * hours;
            }
        }

        if (closeWeight == 180) {
            if (exercise.equals("Aerobics")) {
                calories += 531 * hours;
            }
            if (exercise.equals("Basketball, shooting baskets")) {
                calories += 368 * hours;
            }
            if (exercise.equals("Cycling, 10mph, leisure bicycling")) {
                calories += 327 * hours;
            }
            if (exercise.equals("Running, 5 mph (12 minute mile)")) {
                calories += 563 * hours;
            }
            if (exercise.equals("Running, 10 mph (6 min mile)")) {
                calories += 1308 * hours;
            }
            if (exercise.equals("Swimming laps, freestyle, fast")) {
                calories += 817 * hours;
            }
            if (exercise.equals("Walking 3.0 mph, moderate")) {
                calories += 270 * hours;
            }
        }

        if (closeWeight == 205) {
            if (exercise.equals("Aerobics")) {
                calories += 605 * hours;
            }
            if (exercise.equals("Basketball, shooting baskets")) {
                calories += 419 * hours;
            }
            if (exercise.equals("Cycling, 10mph, leisure bicycling")) {
                calories += 372 * hours;
            }
            if (exercise.equals("Running, 5 mph (12 minute mile)")) {
                calories += 765 * hours;
            }
            if (exercise.equals("Running, 10 mph (6 min mile)")) {
                calories += 1489 * hours;
            }
            if (exercise.equals("Swimming laps, freestyle, fast")) {
                calories += 931 * hours;
            }
            if (exercise.equals("Walking 3.0 mph, moderate")) {
                calories += 307 * hours;
            }

        }

    }

    public double getCalories()
    {
        return calories;
    }

}
