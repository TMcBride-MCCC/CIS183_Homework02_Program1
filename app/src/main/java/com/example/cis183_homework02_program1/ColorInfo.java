package com.example.cis183_homework02_program1;

public class ColorInfo
{
    //redVal, greenValHex, blueVal, hexVal, rgb
    private int redVal;
    private int greenVal;
    private int blueVal;
    private String hexVal;

    //Constructor
    public ColorInfo()
    {

    }

    //Overloaded constructor
    public ColorInfo(int r, int g, int b, String h, String c)
    {
        redVal = r;
        greenVal = g;
        blueVal = b;
        hexVal = h;
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

}
