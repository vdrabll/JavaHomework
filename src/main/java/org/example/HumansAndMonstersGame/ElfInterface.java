package org.example.HumansAndMonstersGame;

public interface ElfInterface extends Race {
    void healWithMagic();
    void drinkManaPotion();
    void attackWithMagic(int damage, Race opponent);
}
