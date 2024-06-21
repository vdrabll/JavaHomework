package org.example.ExampleGame;

public class Ork extends Hero {
    int damage, defence, health;


    public Ork(int defence,  int health, int damage) {
        super(health);
        this.damage = damage;
        this.health = health;
        this.defence = defence;
    }

    public void fight(Human human) {
       if (this.defence > human.damage) {
           System.out.println("орк увернулся");
       } else {
           this.health -= damage - defence;
       }
    }

    public void drink() {
        this.health += 0.5 * health;
    }
}
