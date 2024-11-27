package model;

public class Base {

    private int PV;
    private boolean position;
    private int money;

    public Base(int PV, boolean position, int money) {
        this.PV = PV;
        this.position = position;
        this.money = money;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public boolean isPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void removeMoney(int money) {
        this.money -= money;
    }

    public boolean isAlive() {
        return PV > 0;
    }
}
