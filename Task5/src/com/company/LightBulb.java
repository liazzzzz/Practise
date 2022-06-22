package com.company;

import java.awt.*;

public class LightBulb {

    public Color bulbColor;
    public boolean bulbSwitchOn;
    public boolean bulbWorking;

    public LightBulb() {
        bulbColor = Color.white;
        bulbSwitchOn = false;
        bulbWorking = true;
    }

    public Color getBulbColor() {
        return bulbColor;
    }

    public void setBulbColor(Color bulbColor) {
        this.bulbColor = bulbColor;
    }

    public boolean isBulbSwitchOn() {
        return bulbSwitchOn;
    }

    public void turnOnBulb() {
        if (isBulbWorking()) {
            bulbSwitchOn = true;
            System.out.println("Лампочка включена");
        } else {
            System.out.println("Лампочка сломана");
        }
    }

    public void turnOffBulb() {
        bulbSwitchOn = false;
        System.out.println("Лампочка выключена");
    }

    public boolean isBulbWorking() {
        return bulbWorking;
    }

    public void setBulbWorking(boolean bulbWorking) {
        if (!bulbWorking) {
            bulbSwitchOn = false;
        }
        this.bulbWorking = bulbWorking;
    }

}
