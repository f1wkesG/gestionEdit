package com.exam.gestionEdit.dtos;

public class NumeroDTO {
    private int num;
    private boolean boucle;

    public NumeroDTO() {
    }

    public NumeroDTO(int num, boolean boucle) {
        this.num = num;
        this.boucle = boucle;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isBoucle() {
        return boucle;
    }

    public void setBoucle(boolean boucle) {
        this.boucle = boucle;
    }
}
