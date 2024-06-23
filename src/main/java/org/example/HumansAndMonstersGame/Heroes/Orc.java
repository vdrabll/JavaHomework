package org.example.HumansAndMonstersGame.Heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.HumansAndMonstersGame.OrсInterface;
import org.example.HumansAndMonstersGame.Race;

import java.util.Random;
import java.util.Scanner;

@AllArgsConstructor
@Getter
@Setter
public class Orc implements OrсInterface {
    private int health, power;
    private boolean isAlive;
    private String name;

    @AllArgsConstructor
    @Getter
    private enum Phrases {
        attack("%s наносит удар! "),
        strongAttack("%s наносит сильный удар дубинкой! "),
        reflectDamege("Враг нападает ! Показатель здоровья снизилась на %d"),
        takeDamage("Ау! %s атаковали, его здоровье теперь: %d");

        private String phrase;
    }

    @Override
    public void strongAttack(int damage, Race opponent) {
        System.out.println(String.format(Phrases.strongAttack.getPhrase(), this.name));
        opponent.getAttacked(this.power / damage * 3);
    }

    @Override
    public void strongRoar(int damage, Race opponent) {
        System.out.println(String.format(Phrases.attack.getPhrase(), this.name));
        opponent.getAttacked(this.power / damage);
    }

    @Override
    public void getAttacked(int damage) {
        if (isAlive() == true) {
            this.health -= damage;
            System.out.println(String.format(Phrases.takeDamage.getPhrase(), this.name, this.health));
            if (this.health == 0) {
                this.isAlive = false;
            }
        }
    }

    @Override
    public void attack(int damage, Race opponent) {
        System.out.println(String.format(Phrases.attack.getPhrase(), this.name));
        opponent.getAttacked(damage * power / 2);
    }

    @Override
    public void makeMove(Race opponent) {
        System.out.println("Ваш ход! Выберете действие: \n 1) Нанести сильный удар \n 2) Нанести удар \n 3) Сильный рев");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                strongAttack(50, opponent);
                break;
            case "2":
                attack(25, opponent);
                break;
            case "3":
                strongRoar(20, opponent);
                break;
            default:
                System.out.println("Такой атаки не найдено :(");
                makeMove(opponent);
        }
    }

    @Override
    public void makeRandomMove(Race opponent) {
        switch (random.nextInt(0, 3)) {
            case 0:
                attack(25, opponent);
                break;
            case 1:
                strongRoar(20, opponent);
                break;
            case 2:
                strongAttack(50, opponent);
                break;
            default:
                attack(25, opponent);
        }
    }


}
