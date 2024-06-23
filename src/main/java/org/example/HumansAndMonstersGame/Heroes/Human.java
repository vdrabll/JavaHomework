package org.example.HumansAndMonstersGame.Heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.HumansAndMonstersGame.HumanInterface;
import org.example.HumansAndMonstersGame.Race;

import java.util.Scanner;

@AllArgsConstructor
@Getter
@Setter
public class Human implements HumanInterface {
    private int health, power, armor;
    private String name;
    private boolean isAlive;
    private int healingPotions = 3;

    @AllArgsConstructor
    @Getter
    private enum Phrases {
        noPotion("Зелий нет :( Придется выживать на том, что есть"),
        havePotion("*Выпивает зелье* Теперь %s чувствует себя лучше! Его здоровье увеличивается на 30 баллов! \n Осталось %d зелий."),
        attack("%s готовится нанести удар! "),
        reflectDamege("Враг нападает человека ! Но %s удалось отразить атаку!Броня снизилась на %d"),
        takeDamage("Ау! %s не смог отразить удар и здоровье теперь: %d");
        private String phrase;
    }

    @Override
    public void drinkHealingPotion() {
        if (this.healingPotions != 0) {
            this.healingPotions--;
            this.health += 30;
            System.out.println(String.format(Phrases.havePotion.phrase, this.name, this.healingPotions));
        } else {
            System.out.println(String.format(Phrases.noPotion.phrase));
        }
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void attack(int damage, Race opponent) {
        opponent.getAttacked(this.power / damage * 2);
    }

    @Override
    public void makeMove(Race opponent) {
        System.out.println("Ваш ход! Выберете действие: \n 1) Нанести удар \n 2) Воспользоваться зельем здоровья ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                attack(30, opponent);
                break;
            case "2":
                drinkHealingPotion();
                break;
            default:
                System.out.println("Такой атаки не найдено :(");
                makeMove(opponent);
        }
    }

    @Override
    public void makeRandomMove(Race opponent) {
        switch (random.nextInt(0,2)) {
            case 0:
                attack(25, opponent);
                break;
            case 1:
                drinkHealingPotion();
                break;

            default:
                attack(25, opponent);
        }
    }

    public void getAttacked(int damage) {
        System.out.println();
        if (this.armor > damage & this.armor != 0) {
            this.armor -= this.armor - damage;
            System.out.println(String.format(Phrases.reflectDamege.phrase, this.name, this.armor));
        } else {
            this.health -= damage;
            System.out.println(String.format(Phrases.takeDamage.phrase, this.name, this.health));
        }
    }
}
