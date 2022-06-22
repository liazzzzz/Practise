package com.company;

import java.awt.*;

public class LightBulb {

    private Color color;
    private boolean isSwitchOn;
    private boolean isBroken;

    public LightBulb() {
        isSwitchOn = false;
        isBroken = false;
    }

    public LightBulb(Color color) {
        this.color = color;
        isSwitchOn = false;
        isBroken = false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (this.color == null) {
            this.color = color;
        }
    }

    public boolean isSwitchOn() {
        return isSwitchOn;
    }

    public void turnOn() {
        if (!isBroken()) {
            isSwitchOn = true;
        }
    }

    public void turnOff() {
        isSwitchOn = false;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void brokeBulb() {
        isBroken = true;
        isSwitchOn = false;
    }

    public void fixBulb() {
        isBroken = false;
    }

    public void showState() {
        System.out.println("Цвет лампочки: " + color.toString());
        if (isSwitchOn) {
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
