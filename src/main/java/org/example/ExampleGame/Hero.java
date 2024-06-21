package org.example.ExampleGame;

public abstract class Hero {
    int health;

    public Hero(int health) {
        this.health = health;
    }


    public boolean isDead() {
        return health >= 0;
    }
    
}
