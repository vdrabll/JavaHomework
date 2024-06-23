package org.example.HumansAndMonstersGame;

import java.util.Random;
import java.util.Scanner;

/* Интрефейс для базовых функций всех расс */
public interface Race {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();


    public void getAttacked(int damage);

    String getName();

    int getHealth();

    int getPower();

    boolean isAlive();

    void attack(int damage, Race opponent);

    void makeMove(Race opponent);

    void makeRandomMove(Race opponent);


}
