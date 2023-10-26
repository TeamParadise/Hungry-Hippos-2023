// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

/** Add your docs here. */
public class LEDProfiles {
    
    private final AddressableLED ledStrip;
    private final AddressableLEDBuffer ledBuffer;

    public LEDProfiles(int led, int ledB){
        System.out.println("Led Port: " + led + "Led Length: " + ledB);
        ledStrip = new AddressableLED(led);
        ledBuffer = new AddressableLEDBuffer(ledB);
        ledStrip.setLength(ledBuffer.getLength());
        ledStrip.setData(ledBuffer);
        ledStrip.start();
    }

    public void halfFront(Color color, Color color2) {
        for (var i = 0; i < ledBuffer.getLength(); i++) {
            if (i > (ledBuffer.getLength() / 4) && i < (ledBuffer.getLength() - (ledBuffer.getLength() / 4))) {
                ledBuffer.setLED(i, color);
            } else {
                ledBuffer.setLED(i, color2);
            }
        }
        ledStrip.setData(ledBuffer);
    }

    public void setAll(Color color) {
        for (var i = 0; i < ledBuffer.getLength(); i++) {
          ledBuffer.setLED(i, color);
        }
        ledStrip.setData(ledBuffer);
    }
}