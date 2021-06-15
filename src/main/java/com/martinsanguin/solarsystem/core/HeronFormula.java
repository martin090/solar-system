package com.martinsanguin.solarsystem.core;

public class HeronFormula {
    public static double calculateArea(double perimeter, double side1, double side2, double side3){
        double semiPerimeter = perimeter / 2;
        double area = Math.sqrt(semiPerimeter
                * (semiPerimeter - side1)
                * (semiPerimeter - side2)
                * (semiPerimeter - side3));
        return area;
    }
}
