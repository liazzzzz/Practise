package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        LightBulb lightbulb = new LightBulb(Color.black);
        lightbulb.turnOn();
        lightbulb.showState();

    }
}
