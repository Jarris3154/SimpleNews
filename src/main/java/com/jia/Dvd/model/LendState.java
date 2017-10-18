package com.jia.Dvd.model;

public enum LendState {
    已借出(0), 可借(1);

    private int index;

    LendState(int index) {
        this.index = index;
    }

    public String getName() {
        return name();
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
