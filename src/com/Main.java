package com;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    static void startGame() {
        UserInterface UI = new UserInterface();
        while (true) {
            switch (UI.mainMenu()) {
                case 1 -> inGame(UI);
                case 2 -> System.exit(0);
            }
        }
    }

    static void inGame(UserInterface UI){
        GameLogic gameLogic = new GameLogic();
        int countOfMistakes = 0;
        while(true) {
            String userInputtedLetter = UI.inputLetter();
            if(gameLogic.alreadyEnteredLetterCheck(userInputtedLetter)){
                UI.printError("Ранее вы уже вводили данную букву");
            }else {
                if (!gameLogic.letterInWordCheck(userInputtedLetter)) {
                    countOfMistakes++;
                }
            }
            UI.printGameState(gameLogic.getMaskedWord(), countOfMistakes);
            if(gameLogic.maskedInGameWordMatchCheck()) {
                userWinGame(UI);
                return;
            }

            if(countOfMistakes == 6){
                userLostGame(UI, gameLogic.getInGameWord());
                return;
            }
        }
    }

    static void userWinGame(UserInterface UI){
        UI.printEndGame();
    }

    static void userLostGame(UserInterface UI, String inGameWord){
        UI.printEndGame(inGameWord);
    }

}
