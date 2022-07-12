/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package hanoitower;

/**
 *
 * @author Gebruiker
 */
public class Hanoitower {

    public static void main(String[] args) {
        Sticks [] stickArray = new Sticks[3];
        Disks [] diskArray = new Disks[3];


        setBoard(stickArray, diskArray);
        printBoard(stickArray,diskArray);

        doSpel(diskArray.length, stickArray, diskArray);
    }

    private static void doSpel(int nDisk, Sticks [] stickArray,  Disks [] diskArray) {
        hanoi(nDisk, 1, 3, stickArray, diskArray);
    }

    private static void hanoi(int nDisk, int fromPeg, int toPeg, Sticks[] stickArray, Disks[] diskArray) {
        if(nDisk == 1){
            moveDisk(fromPeg -1, toPeg - 1, stickArray, diskArray);
            printBoard(stickArray, diskArray);
            System.out.println(" ");
        } else {
            int helpPeg = 6 - fromPeg - toPeg;

            //Step1
            hanoi(nDisk - 1, fromPeg, helpPeg, stickArray, diskArray);


            //Step2
            moveDisk(fromPeg -1, toPeg - 1, stickArray, diskArray);
            printBoard(stickArray, diskArray);
            System.out.println(" ");


            //Step3
            hanoi(nDisk - 1, helpPeg, toPeg, stickArray, diskArray);


            return;
        }

    }
        private static Sticks setSticks(Sticks stick, Disks[] diskArray) {
        stick = new Sticks(diskArray);
        return stick;
    }

    static Disks setDisks(Disks disk, int i, int numberOfSpace) {
        disk = new Disks(i, numberOfSpace);
        return disk;
    }

    private static void setBoard(Sticks[] stickArray, Disks[] diskArray) {
        for (int i = 0; i < stickArray.length; i++){
            stickArray[i] = setSticks(stickArray[i], diskArray);
        }

        for (int i = 0; i < diskArray.length; i++){
            int length = 1 + i + i;
            int numberOfSpace = diskArray.length - i;
            diskArray[i] = setDisks(diskArray[i], length, numberOfSpace);
            stickArray[0].disksHere.set(i, diskArray[i]);
        }
    }

    private static void printBoard(Sticks[] stickArray, Disks[] diskArray) {
        for (int i = 0; i < diskArray.length; i++){
            System.out.println(stickArray[0].disksHere.get(i).visualLength + " " + stickArray[1].disksHere.get(i).visualLength + " " + stickArray[2].disksHere.get(i).visualLength);
        }
    }

    private static Disks getMovingDisk(int fromPeg, Sticks[] stickArray, Disks[] diskArray) {
        for (int x = 0; x < diskArray.length; x++){
            if (stickArray[fromPeg].disksHere.get(x).visualLength.contains("x")){
                Disks movingDisk = stickArray[fromPeg].disksHere.get(x);
                Disks newDisk = new Disks(movingDisk.length, movingDisk.numberOfSpace);
                newDisk.visualLength = newDisk.visualLength.replaceAll("x", ".");
                stickArray[fromPeg].disksHere.set(x, newDisk);
                return movingDisk;
            }

        }
        return null;
    }

    private static void moveDisk(int fromPeg, int toPeg, Sticks[] stickArray, Disks[] diskArray) {
        Disks movingDisk = getMovingDisk(fromPeg, stickArray, diskArray);
        for (int y = diskArray.length-1; y >= 0; y--){
            if (!stickArray[toPeg].disksHere.get(y).visualLength.contains("x")){
                stickArray[toPeg].disksHere.set(y, movingDisk);
                break;

            }
        }
    }
}

