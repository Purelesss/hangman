package com;

import java.util.Scanner;

public class UserInterface {
    Scanner userInput = new Scanner(System.in);
    private final String[] gameStates = new String[] {
            """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,
                """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,

                """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,

                """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,

                """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,

                """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,

                """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """
    };

    int mainMenu(){
        while(true) {
            System.out.println("1. Начать новую игру");
            System.out.println("2. Выйти из приложения");
            String userChoose = userInput.nextLine();
            if(userChoose.equals("1") || userChoose.equals("2")){
                return Integer.parseInt(userChoose);
            }else{
                printError("Некорректный пункт меню");
            }
        }
    }

    void printGameState(String maskedWord, int countOfMistakes){
        System.out.println(gameStates[countOfMistakes]);
        System.out.println("Слово: " + maskedWord);
        System.out.println("Количество ошибок: " + countOfMistakes);
    }

    String inputLetter(){
        while (true){
            System.out.println("Введите букву: ");
            String userInputLetter = userInput.nextLine();
            if(userInputLetter.matches("[а-яА-ЯёЁ]")){
                return userInputLetter;
            }else{
                printError("Некорректный ввод, попробуйте еще раз");
            }
        }
    }

    void printError(String errorText){
        System.out.println("[Ошибка] " + errorText);
    }

    void printEndGame(){
        System.out.println("Вы победили!");
    }

    void printEndGame(String inGameWord){
        System.out.println("Вы проиграли!");
        System.out.println("Загадное слово было: " + inGameWord);
    }

}
