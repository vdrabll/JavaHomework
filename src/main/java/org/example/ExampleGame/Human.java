package org.example.ExampleGame;

public class Human extends Hero {
    int defence, damage, health;

    public Human(int defence, int damage, int health) {
        super(health);
        this.defence = defence;
        this.damage = damage;
        this.health = health;
    }

    public void fight(int damage) {
        int actualDamage = defence - damage;
        if (actualDamage <= 0 ) {
            actualDamage = 5;
            this.health -= actualDamage;
        } else {
            this.health -= damage;
        }
        if (isDead()) {
            System.out.println("смерть F4");
        }
    }

    public void drink() {
        this.health += 0.5 * health;
    }
}

