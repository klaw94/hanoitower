/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hanoitower;

/**
 *
 * @author Gebruiker
 */
public class Disks {
    String visualLength;
    int length;
    String visualSpace;
    int numberOfSpace;

    public Disks(int numberOfLength, int numberOfSpace) {
        this.numberOfSpace = numberOfSpace;
        length = numberOfLength;

        for (int i = 0; i < numberOfSpace; i++){
            if (i == 0){
                visualSpace = " ";
            } else {
                visualSpace = visualSpace + " ";
            }
        }

        for (int i = 0; i <= numberOfLength; i++){
            if (i == 0){
                visualLength = visualSpace + "x";
            } else if (i == numberOfLength){
                visualLength = visualLength + "x" + visualSpace;
            } else {
                visualLength = visualLength + "x";
            }
        }
    }
}
