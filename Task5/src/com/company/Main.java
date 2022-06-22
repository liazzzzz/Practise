package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        LightBulb lightbulb = new LightBulb();
        lightbulb.setBulbColor(Color.red);
        System.out.println(lightbulb.getBulbColor());

        lightbulb.turnOnBulb();
        lightbulb.setBulbWorking(false);
        System.out.println(lightbulb.isBulbSwitchOn());

    }
}
