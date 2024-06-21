package org.example;

import org.example.ExampleGame.Human;
import org.example.ExampleGame.Ork;

import java.util.Scanner;


public class Main {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Human garry = new Human(25,20, 100);
        Ork ork = new Ork(30, 150, 20);

        while (!garry.isDead() || !ork.isDead()) {
            System.out.println("орк наносит удар ");
            garry.fight(100);
        }
    }

}
