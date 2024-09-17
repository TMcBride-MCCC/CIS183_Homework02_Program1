package com.example.cis183_homework02_program1;

public class RGB
{
    //redVal, greenVal, blueVal, hexVal, rgb
    private int redVal;
    private int greenVal;
    private int blueVal;
    private String hexVal;
    private String rgb;

    //Constructor
    public RGB()
    {

    }

    //Overloaded constructor
    public RGB(int r, int g, int b, String h, String c)
    {
        redVal = r;
        greenVal = g;
        blueVal = b;
        hexVal = h;
        rgb = c;
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

    public String getRgb()
    {
        return rgb;
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

    public void setRgb(String rgb)
    {
        this.rgb = rgb;
    }
}
