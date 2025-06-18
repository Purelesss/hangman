package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {
    private final String inGameWord;
    private String maskedWord;
    private final ArrayList <String> enteredLetters = new ArrayList<>();
    GameLogic(){
        this.inGameWord = getRandomInGameWord();
        this.maskedWord = createMaskedWord(this.inGameWord);
    }

    private String getRandomInGameWord(){
        Random random = new Random();
        try {
            List<String> word = Files.readAllLines(Paths.get("words.txt"));
            return word.get(random.nextInt(word.size()));
        } catch (IOException exception) {
            return null;
        }
    }

    private String createMaskedWord(String inGameWord){
        return "_".repeat(inGameWord.length());
    }

    String getMaskedWord() {
        return maskedWord;
    }

    private void openLetter(String letter){
        char[] maskedWordArr = maskedWord.toCharArray();
        for(int i = 0; i < maskedWord.length(); i++){
            if(inGameWord.toLowerCase().charAt(i) == letter.toLowerCase().charAt(0)){
                maskedWordArr[i] = inGameWord.charAt(i);
            }
        }
        maskedWord = new String(maskedWordArr);
    }

    boolean letterInWordCheck(String letter){
        if(inGameWord.toLowerCase().contains(letter.toLowerCase())){
            openLetter(letter);
            enteredLetters.add(letter.toLowerCase());
            return true;
        }
        enteredLetters.add(letter.toLowerCase());
        return false;
    }

    boolean alreadyEnteredLetterCheck(String letter){
        return enteredLetters.contains(letter.toLowerCase());
    }

    boolean maskedInGameWordMatchCheck(){
        return maskedWord.equals(inGameWord);
    }

    String getInGameWord(){
        return inGameWord;
    }

}
