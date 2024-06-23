package org.example.HumansAndMonstersGame.Heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.HumansAndMonstersGame.ElfInterface;
import org.example.HumansAndMonstersGame.Race;

import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class Elf implements ElfInterface {
    private int health, power, mana;
    private String name;
    private boolean isAlive;
    private int manaPotion = 3;

    @AllArgsConstructor
    @Getter
    private enum Phrases {
        heal("%s использует целебную магию! Его здоровье: %d"),
        drinkPotion("%s использует зелье маны, уровень маны повышен: %d"),
        magicAttack("%s наносит удар силами природы! Сильное землетрясение повергает противника"),
        reflectDamege("Враг нападает ! Показатель здоровья снизился до %d"),
        noMana("Недостаточно маны :( "),
        noPotions("Недостаточно зелий маны :( ");

        private String phrase;
    }

    @Override
    public void healWithMagic() {
        if (this.mana >= 0) {
            this.health += power / health * 2;
            System.out.println(String.format(Phrases.heal.getPhrase(), this.name, this.health));
        } else {
            System.out.println(Phrases.noMana.getPhrase());
        }
    }

    @Override
    public void drinkManaPotion() {
        if (this.manaPotion >= 0) {
            this.manaPotion--;
            this.health += 50;
            System.out.println(String.format(Phrases.drinkPotion.getPhrase(), this.name, this.mana));
        } else {
            System.out.println(String.format(Phrases.noPotions.getPhrase()));
        }
    }


    @Override
    public void attackWithMagic(int damage, Race opponent) {
        int neededMana = damage / 2;
        if (this.mana >= neededMana) {
            this.mana -= neededMana;
            opponent.getAttacked(damage * 2);
            System.out.println(String.format(Phrases.magicAttack.getPhrase(), this.name));
        } else {
            System.out.println(Phrases.noMana.getPhrase());
        }
    }

    @Override
    public void getAttacked(int damage) {
        if (isAlive != false) {
            this.health -= damage;
            System.out.println(String.format(Phrases.reflectDamege.getPhrase(), this.health));
        }
    }

    @Override
    public void attack(int damage, Race opponent) {
        opponent.getAttacked(power * 2);
    }

    @Override
    public void makeMove(Race opponent) {
        System.out.println("Ваш ход! Выберете действие: \n 1) Использовать магию исцеления \n 2) Нанести удар \n 3) Воспользоваться зельем маны\n 4) Атаковать природной магией");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                healWithMagic();
                break;
            case 2:
                attack(25, opponent);
                break;
            case 3:
                drinkManaPotion();
                break;
            case 4:
                attackWithMagic(35, opponent);
                break;
            default:
                System.out.println("Такой атаки не найдено :(");
                makeMove(opponent);
        }
    }

    @Override
    public void makeRandomMove(Race opponent) {
        switch (random.nextInt(0, 4)) {
            case 0:
                healWithMagic();
                break;
            case 1:
                attack(25, opponent);
                break;
            case 2:
                drinkManaPotion();
                break;
            case 3:
                attackWithMagic(35, opponent);
                break;
            default:
                System.out.println("Такой атаки не найдено :(");
                makeMove(opponent);
        }

    }
}
