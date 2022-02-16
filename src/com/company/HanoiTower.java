package com.company;

import java.util.HashMap;

public class HanoiTower {
    private static int height;
    private final Pole[] poles;
    private HashMap<Integer, Disc> discHashMap;

    public HanoiTower(int height) {
        HanoiTower.height = height;

        poles = new Pole[3];
        for (int i = 0; i < 3; i++) {
            Disc[] tem_discs = new Disc[height];
            Pole tem_pole = new Pole(tem_discs, i, 0);
            getPoles()[i] = tem_pole;
        }

        setDiscHashMap(new HashMap<>());
        for (int i = 0; i < height; i++) {
            Disc tem_disc = new Disc(height - i, i, poles[0]);
            poles[0].getDiscs()[i] = tem_disc;
            getDiscHashMap().put(tem_disc.getId(), tem_disc);
        }
        poles[0].setHeight(height);

    }

    //-----------------------------------------//
    public void MovDiscPile(Disc ptr_disc, Pole ptrPole) {
        Pole nowPole = ptr_disc.getPole();
        int index = 3 - (nowPole.getId() + ptrPole.getId());

        if (ptr_disc.getLv() == 1) {
            MovDisc(ptr_disc, ptrPole);
            PrnHanoiTower();
        } else {
            Disc upDisc = nowPole.getUpDisc(ptr_disc);
            MovDiscPile(upDisc, poles[index]);

            MovDisc(ptr_disc, ptrPole);
            PrnHanoiTower();

            MovDiscPile(upDisc, ptrPole);
        }
    }

    public Disc getDisc(int discId) {
        return discHashMap.get(discId);
    }

    public void MovDisc(Disc disc, Pole movToPole) {
        Pole nowPole = disc.getPole();
        nowPole.getDiscs()[disc.getIndex()] = null;
        nowPole.setHeight(nowPole.getHeight() - 1);

        disc.setPole(movToPole);
        disc.setIndex(movToPole.getHeight());

        movToPole.getDiscs()[movToPole.getHeight()] = disc;
        movToPole.setHeight(movToPole.getHeight() + 1);
    }

    public void PrnHanoiTower() {
        for (int i = height - 1; i > -1; i--) {
            for (Pole pole : poles) {
                System.out.print(" ");
                if (pole.getDiscs() != null && pole.getDiscs()[i] != null) {
                    System.out.printf("%d", pole.getDiscs()[i].getId());
                } else {
                    System.out.print("0");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Pole[] getPoles() {
        return poles;
    }

    public HashMap<Integer, Disc> getDiscHashMap() {
        return discHashMap;
    }

    public void setDiscHashMap(HashMap<Integer, Disc> discHashMap) {
        this.discHashMap = discHashMap;
    }

    public int getHeight() {
        return height;
    }

}
