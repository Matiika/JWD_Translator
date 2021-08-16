package com.AppMenu.TranslatorDAO;

import com.AppMenu.Database_Translator.Database_Translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Quiz {
    Scanner sc = new Scanner(System.in);
    TranslatorDAO temp = new TranslatorDAO();


    public void startQuiz(){
        ArrayList<Integer> randomForQuiz = new ArrayList<Integer>();

        System.out.println("Игра начинается. Переведите слова");

        randomForQuiz = getRandomForQuiz();
        Database_Translator wordPairsforQuiz = new Database_Translator();

        for (Integer i: randomForQuiz){
            wordPairsforQuiz.addWords(temp.getDatabase_translator().getPairs(i));
        }


        answers(wordPairsforQuiz);

    }

    public ArrayList<Integer> getRandomForQuiz() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random randomGenerator = new Random();
        while (numbers.size() < 5) {

            int random = randomGenerator.nextInt(temp.getSizeTranslator());
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }

    public void answers(Database_Translator wordPairsforQuiz){

        List<Integer> wrongAnswers = new ArrayList<>();
        int sizePersentage = 0;

        for (int i=0; i<wordPairsforQuiz.getSize(); i++){
            System.out.println(wordPairsforQuiz.getRuWord(i)+"?");
            if (sc.next().equals(temp.findEnWord(wordPairsforQuiz.getRuWord(i)))){
                System.out.println("Правильно");
            } else {
                System.out.println("Неправильно");
                wrongAnswers.add(i);
                sizePersentage++;
            }
        }

        System.out.println("Итоги теста");
        double percentage = ((wordPairsforQuiz.getSize()-sizePersentage) * 100/ wordPairsforQuiz.getSize());

        System.out.println("Процент правильных ответов: "+percentage+"%");

        System.out.println("Правильные ответы на ошибки");
        for (Integer i: wrongAnswers){
            System.out.println(wordPairsforQuiz.getRuWord(i)+" переводится как "+wordPairsforQuiz.getEnWord(i));
        }



    }



}
