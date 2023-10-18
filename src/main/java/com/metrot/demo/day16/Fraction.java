package com.metrot.demo.day16;

import java.math.BigInteger;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public int getNumerator(){
        return this.numerator;
    }

    public void setNumerator (int numerator){
        this.numerator=numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public void setDenominator (int denominator){
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can not be zero");
        }
        this.denominator = denominator;

    }

    public static int greatestCommonDivisor(int num1, int num2){
        BigInteger i = BigInteger.valueOf(num1).gcd(BigInteger.valueOf(num2));
        int gcd = Integer.parseInt(i.toString());
        return gcd;
    }

    public Fraction simplify() {
        int gcd = greatestCommonDivisor(this.numerator, this.denominator);
        Fraction simplifiedFraction = new Fraction(this.numerator / gcd, this.denominator / gcd);
        if(simplifiedFraction.numerator >= 0 && simplifiedFraction.denominator < 0
                || simplifiedFraction.numerator < 0 && simplifiedFraction.denominator < 0) {
            simplifiedFraction.numerator *= -1;
            simplifiedFraction.denominator *= -1;
        }
        return simplifiedFraction;
    }

    public String mixedNumber() {
        String simplifiedFraction = "";
        Fraction fraction = simplify();
        if (fraction.getDenominator() == 1) {
            simplifiedFraction = fraction.getNumerator() + "";
        } else if (fraction.getNumerator() == 1) {
            simplifiedFraction = fraction.toString();
        } else if (fraction.getNumerator() == 0) {
            simplifiedFraction = 0 + "";
        } else if (Math.abs(fraction.getNumerator()) < Math.abs(fraction.getDenominator())) {
            simplifiedFraction = fraction.getNumerator() + "/" + fraction.getDenominator();
        } else if ((fraction.getNumerator() > fraction.getDenominator() || fraction.getNumerator() < fraction.getDenominator()) && (fraction.getNumerator() < 0 || fraction.getDenominator() < 0) && Math.abs(getNumerator()) > Math.abs(fraction.getDenominator())) {
            simplifiedFraction = (fraction.getNumerator() / fraction.getDenominator()) + " " + (Math.abs(fraction.getNumerator()) % fraction.getDenominator()) + "/" + Math.abs(fraction.getDenominator());
        } else if (fraction.getNumerator() > fraction.getDenominator()) {
            simplifiedFraction = (fraction.getNumerator() / fraction.getDenominator()) + " " + (fraction.getNumerator() % fraction.getDenominator()) + "/" + (fraction.getDenominator());
        }
        return simplifiedFraction;
    }
}
