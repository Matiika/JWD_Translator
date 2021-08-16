package com.AppMenu.OperationImpl;

import com.AppMenu.OperationsInt.OperationsInt;
import com.AppMenu.TranslatorDAO.TranslatorDAO;

import java.util.Scanner;


public class OperationImpl implements OperationsInt {
    Scanner sc = new Scanner(System.in);
    TranslatorDAO temp = new TranslatorDAO();
    String ruWord;
    String enWord;

    @Override
    public void addWords() {
        System.out.println("Введите слово на русском: ");
        ruWord = sc.next();

        System.out.println("Введите слово на английском: ");
        enWord = sc.next();

        temp.addWords(ruWord, enWord);

    }

    @Override
    public void translateEnToRu() {
        System.out.println("Введите слово на русском для перевода: ");
         ruWord = sc.next();

        System.out.println("Перевод слова: "+temp.findEnWord(ruWord));

    }

    @Override
    public void translateRuToEn() {
        System.out.println("Введите слово на английском для перевода: ");
        enWord = sc.next();

        System.out.println("Перевод слова: "+temp.findRuWord(enWord));
    }

    @Override
    public void size() {
        System.out.println("Количество пар слов: "+temp.getSizeTranslator());
    }

    @Override
    public void printAllWords() {
        System.out.println("Все пары слов в словаре: ");
        temp.printAll();
    }

    @Override
    public void startQuiz() {
        startQuiz();
    }
}
