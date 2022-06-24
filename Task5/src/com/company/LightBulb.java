package com.company;

import java.awt.*;

public class LightBulb {

    private Color color;
    private boolean isOn;
    private boolean isBroken;

    public LightBulb(Color color) {
        this.color = color;
        isOn = false;
        isBroken = false;
    }

    public Color getColor() {
        return color;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        if (!isBroken()) {
            isOn = true;
        }
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void brokeBulb() {
        isBroken = true;
        isOn = false;
    }

    public void fixBulb() {
        isBroken = false;
    }

    public void showState() {
        System.out.println("Цвет лампочки: " + color.toString());
        if (isOn) {
            System.out.println("Лампочка работает");
        } else {
            if (isBroken) {
                System.out.println("Лампочка сломана");
            } else {
                System.out.println("Лампочка выключена");
            }
        }
    }

}
