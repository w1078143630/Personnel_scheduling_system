package com.atguigu.domain;

/**
 * ClassName: Designer
 * Description:
 *
 * @Author Wei Wang
 * @Create 2024/3/25 11:20
 * @Version 1.0
 */
public class Designer extends Programmer{
    double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public String toString() {
        return getdetails() + "\t设计师\t" + getStatus() + "\t" +
                getBonus() + "\t\t\t" + getEquipment().getDescription();

    }
}
