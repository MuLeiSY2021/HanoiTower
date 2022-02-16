package com.company;

public class Pole {
    private final Disc[] discs;
    private final int id;
    private int height;

    //--------------------------------------//
    public Pole(Disc[] discs, int id, int height) {
        this.discs = discs;
        this.id = id;
        this.height = height;
    }

    public Disc getUpDisc(Disc disc) {
        if (disc.getIndex() == discs.length) {
            return null;
        } else {
            return discs[disc.getIndex() + 1];
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Disc[] getDiscs() {
        return discs;
    }

    public int getId() {
        return id;
    }
}
