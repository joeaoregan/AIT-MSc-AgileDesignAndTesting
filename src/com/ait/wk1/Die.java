package com.ait.wk1;
public class Die
{
    private int value;
    private static int SIDES=6;

    public Die()
    {
       // this.value = 1;  // initialize value to 1
    }


    // roll the die
    public void roll()
    {
        value = (int) (Math.random() * SIDES);  // number from 0 to sides
        value++;
    }

    public int getValue()
    {
        return value;
    }
}