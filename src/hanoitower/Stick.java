/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hanoitower;

import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public class Sticks {
    ArrayList<Disks> disksHere =  new ArrayList<>();


    public Sticks(Disks[] diskArray) {
        for (int i = 0; i < diskArray.length; i++){
            int length = 1 + i + i;
            int numberOfSpace = diskArray.length - i;
            Disks disk = new Disks (length, numberOfSpace);
            disk.visualLength =  disk.visualLength.replaceAll("x", ".");
            disksHere.add(disk);

        }
    }


}