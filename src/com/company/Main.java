package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HanoiTower hanoiTower = new HanoiTower(input.nextInt());
        hanoiTower.PrnHanoiTower();
        hanoiTower.MovDiscPile(hanoiTower.getDisc(hanoiTower.getHeight()), hanoiTower.getPoles()[2]);
    }
    ///vsdvsdvsdv
}



