package com.example.cis183_homework02_program1;

public class ColorInfo
{
    //redVal, greenValHex, blueVal, hexVal,
    private int redVal;
    private int greenVal;
    private int blueVal;
    private String hexVal;
    private double brightness;

    //Constructor
    public ColorInfo()
    {

    }

    //Overloaded constructor
    public ColorInfo(int r, int g, int b, String h, double br)
    {
        redVal = r;
        greenVal = g;
        blueVal = b;
        hexVal = h;
        brightness = br;
    }

    //======================================================
    //GETTERS
    //======================================================

    public int getRedVal()
    {
        return redVal;
    }

    public int getGreenVal()
    {
        return greenVal;
    }

    public int getBlueVal()
    {
        return blueVal;
    }

    public String getHexVal()
    {
        return hexVal;
    }

    public double getBrightness()
    {
        return brightness;
    }

//======================================================
    //SETTERS
    //======================================================

    public void setRedVal(int redVal)
    {
        this.redVal = redVal;
    }

    public void setGreenVal(int greenVal)
    {
        this.greenVal = greenVal;
    }

    public void setBlueVal(int blueVal)
    {
        this.blueVal = blueVal;
    }

    public void setHexVal(String hexVal)
    {
        this.hexVal = hexVal;
    }

    public void setBrightness(double brightness)
    {
        this.brightness = brightness;
    }
}
