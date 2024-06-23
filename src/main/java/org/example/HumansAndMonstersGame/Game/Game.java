package org.example.HumansAndMonstersGame.Game;

import org.example.HumansAndMonstersGame.Heroes.Elf;
import org.example.HumansAndMonstersGame.Heroes.Human;
import org.example.HumansAndMonstersGame.Heroes.Orc;
import org.example.HumansAndMonstersGame.Race;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static public Game sheared = new Game();

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        Race[] characters = chooseCharacters();
        Race playerCharacter;
        Race opponent;

        playerCharacter = characters[0];
        opponent = characters[1];

        while (playerCharacter.getHealth() > 0 && opponent.getHealth() > 0) {
            playerCharacter.makeMove(opponent);
            if (playerCharacter.getHealth() <= 0 && opponent.getHealth() <= 0) {
               break;
            }
            opponent.makeRandomMove(playerCharacter);
        }
    }

    private Race[] chooseCharacters() {
        Race playerCharacter;
        Race opponent;
        Race[] characters = new Race[2];

        System.out.println("Добро пожаловать в игру! Введите имя персонажа:");
        String name = scanner.nextLine();
        System.out.println("Введите номер желаемого персонажа: \n 1) Человек \n 2) Орк \n 3) Эльф ");
        String race = scanner.nextLine();
        playerCharacter = createCharacter(race, name);
        System.out.println("Выберете противника!  \n 1) Человек \n 2) Орк \n 3) Эльф");
        String oponentName = scanner.nextLine();
        opponent = createCharacter(oponentName, "Zlodey");

        characters[0] = playerCharacter;
        characters[1] = opponent;
        return characters;
    }

    private Race createCharacter(String race, String name) {
        switch (race) {
            case ("1"):
                System.out.println("Вы выбрали Человека! Люди не имеют особенных способностей, но имеют доспехи, защищающие их и несколько зелий здоровья.");
                return new Human(
                        randomInt(50, 100),
                        randomInt(20, 50),
                        randomInt(10, 30),
                        name,
                        true,
                        3);
            case ("2"):
                System.out.println("Вы выбрали Орка! Орки обладают повышенным здоровьем и силой однако не могут использовать зелья.");
                return new Orc(
                        randomInt(100, 150),
                        randomInt(30, 60),
                        true,
                        name
                );
            case ("3"):
                System.out.println("Вы выбрали Эльфа! Эльфы имеют самое слабое здоровье, но могут использовать магические атаки и магию лечения");
                return new Elf(
                        randomInt(50, 90),
                        randomInt(30, 50),
                        randomInt(50, 100),
                        name,
                        true,
                        3
                );
            default:
                System.out.println("Такого персонажа в списке нет :( ");
                chooseCharacters();
        }
        return null;
    }

    private static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}


