/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package hanoitower;
import java.util.ArrayList;


/**
 *
 * @author Gebruiker
 */
public class Hanoitower {

    public static void main(String[] args) {
        Sticks [] stickArray = new Sticks[3];
        Disks [] diskArray = new Disks[3];
        GameInfo gameInfo = new GameInfo();


        setBoard(stickArray, diskArray);
        printBoard(stickArray,diskArray);

        doSpel(diskArray.length, stickArray, diskArray, gameInfo);
    }

    private static void doSpel(int nDisk, Sticks [] stickArray,  Disks [] diskArray, GameInfo gameInfo) {
        hanoi(nDisk, 1, 3, stickArray, diskArray, gameInfo);
    }

    private static void hanoi(int nDisk, int fromPeg, int toPeg, Sticks[] stickArray, Disks[] diskArray, GameInfo gameInfo) {
        if(nDisk == 1){
            moveTheDisk(nDisk -1, fromPeg, toPeg, stickArray, diskArray, gameInfo);
        } else {
            int helpPeg = 6 - fromPeg - toPeg;

            //Step1
            hanoi(nDisk - 1, fromPeg, helpPeg, stickArray, diskArray, gameInfo);


            //Step2
            getMovingDisk(gameInfo, fromPeg - 1, stickArray, diskArray);
            tryColumn(gameInfo, toPeg - 1, stickArray, diskArray);
            printBoard(stickArray, diskArray);
            System.out.println(" ");


            //Step3
            hanoi(nDisk - 1, helpPeg, toPeg, stickArray, diskArray, gameInfo);


            return;
        }

    }

    private static void moveTheDisk(int i, int fromPeg, int helpPeg, Sticks[] stickArray, Disks[] diskArray, GameInfo gameInfo) {
        getMovingDisk(gameInfo, fromPeg-1, stickArray,diskArray);
        tryColumn(gameInfo, helpPeg-1, stickArray, diskArray);
        printBoard(stickArray,diskArray);
        System.out.println(" ");
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

    private static void getMovingDisk(GameInfo gameInfo, int i, Sticks[] stickArray, Disks[] diskArray) {
        for (int x = 0; x < diskArray.length; x++){
            if (stickArray[i].disksHere.get(x).visualLength.contains("x")){
                gameInfo.movingDisk = stickArray[i].disksHere.get(x);
                Disks newDisk = new Disks(gameInfo.movingDisk.length, gameInfo.movingDisk.numberOfSpace);
                newDisk.visualLength = newDisk.visualLength.replaceAll("x", ".");
                stickArray[i].disksHere.set(x, newDisk);
                break;
            }

        }
    }

    private static void tryColumn(GameInfo gameInfo, int i, Sticks[] stickArray, Disks[] diskArray) {
        for (int y = diskArray.length-1; y >= 0; y--){
            if (!stickArray[i].disksHere.get(y).visualLength.contains("x")){
                stickArray[i].disksHere.set(y, gameInfo.movingDisk);
                break;

            }
        }
    }
}

