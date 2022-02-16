package com.company;

import java.util.Objects;

public class Disc {
    private final int id;
    private int index;
    private Pole pole;

    //-----------------------------//

    public Disc(int id, int index, Pole pole) {
        this.id = id;
        this.index = index;
        this.pole = pole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disc disc = (Disc) o;
        return id == disc.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getLv() {
        return pole.getHeight() - index;
    }

    public Pole getPole() {
        return pole;
    }

    public void setPole(Pole pole) {
        this.pole = pole;
    }

    public int getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
