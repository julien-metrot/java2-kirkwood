package com.metrot.demo.day16;

import com.metrot.demo.day16.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    @Test
    public void defaultConstructor() {
        String expected = "1/1";
        String actual = new Fraction().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void parameterizedConstructor() {
        Fraction fraction = new Fraction(27, 6);
        String expected = "27/6";
        String actual = fraction.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void getNumerator() {
        int expected = 1;
        int actual = new Fraction().getNumerator();
        assertEquals(expected, actual);
        assertEquals(27, new Fraction(27, 6).getNumerator());
    }

    @Test
    public void getDenominator() {
        assertEquals(1, new Fraction().getDenominator());
        assertEquals(6, new Fraction(27, 6).getDenominator());
    }

    @Test
    public void setDenominator() {
        int expected = 30;
        Fraction fraction = new Fraction();
        fraction.setDenominator(30);
        int actual = fraction.getDenominator();
        assertEquals(expected, actual);
        assertThrows(Exception.class, () -> fraction.setDenominator(0));
    }

    @Test
    public void setNumerator() {
        int expected = 30;
        Fraction fraction = new Fraction();
        fraction.setNumerator(30);
        int actual = fraction.getNumerator();
        assertEquals(expected, actual);
    }

    @Test
    public void greatestCommonFactor() {
        int actual = Fraction.greatestCommonDivisor(75, 45);
        int expected = 15;
        assertTrue(expected == actual);
        assertEquals(2, Fraction.greatestCommonDivisor(2, 4));
        assertTrue(1 == Fraction.greatestCommonDivisor(5, 7));
    }

    @Test
    public void testDoubles() {
        double expected = 3.3;
        double actual = 1.1 + 2.2;
        assertEquals(expected, actual, 0.01); // delta is for rounding
    }

    @Test
    public void simplify() {
        // Fraction 1
        Fraction fraction1 = new Fraction(75, 45);
        String expected1 = "5/3";
        String actual1 = fraction1.simplify().toString();
        assertEquals(expected1, actual1);

        // Fraction 2
        Fraction fraction2 = new Fraction(2, 4);
        String expected2 = "1/2";
        String actual2 = fraction2.simplify().toString();
        assertEquals(expected2, actual2);

        // Fraction 3
        Fraction fraction3 = new Fraction(5, 7);
        String expected3 = "5/7";
        String actual3 = fraction3.simplify().toString();
        assertTrue(expected3.equals(actual3));

        // Fraction 4
        Fraction fraction4 = new Fraction(-2, 4);
        String expected4 = "-1/2";
        String actual4 = fraction4.simplify().toString();
        assertTrue(expected4.equals(actual4));

        // Fraction 5
        Fraction fraction5 = new Fraction(2, -4).simplify();
        assertEquals(fraction5.getNumerator(), -1);
        assertTrue(fraction5.getDenominator() == 2);

        // Fraction 6
        Fraction fraction6 = new Fraction(-2, -4).simplify();
        assertEquals(fraction6.getNumerator(), 1);
        assertTrue(fraction6.getDenominator() == 2);
    }

    @Test
    public void mixedNumber() {
        Fraction fraction1 = new Fraction(4, 1);
        assertEquals("4", fraction1.mixedNumber());
        Fraction fraction2 = new Fraction(0, 4);
        assertEquals("0", fraction2.mixedNumber());
        Fraction fraction3 = new Fraction(4, 4);
        assertEquals("1", fraction3.mixedNumber());
        Fraction fraction4 = new Fraction(8, 4);
        assertEquals("2", fraction4.mixedNumber());
        Fraction fraction5 = new Fraction(4, 8);
        assertEquals("1/2", fraction5.mixedNumber());
        Fraction fraction6 = new Fraction(13, 5);
        assertEquals("2 3/5", fraction6.mixedNumber());
        Fraction fraction7 = new Fraction(-13, 5);
        assertEquals("-2 3/5", fraction7.mixedNumber());
        Fraction fraction8 = new Fraction(13, -5);
        assertEquals("-2 3/5", fraction8.mixedNumber());
        Fraction fraction9 = new Fraction(-13, -5);
        assertEquals("2 3/5", fraction9.mixedNumber());
        Fraction fraction10 = new Fraction(-4, -5);
        assertEquals("4/5", fraction10.mixedNumber());
    }
}