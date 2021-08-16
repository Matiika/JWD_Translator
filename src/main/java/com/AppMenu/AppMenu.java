package com.AppMenu;

import java.util.Scanner;
import com.AppMenu.TranslatorDAO.Quiz;
import com.AppMenu.OperationImpl.OperationImpl;

public class AppMenu {
    Scanner sc = new Scanner(System.in);
    Quiz quiz = new Quiz();
    OperationImpl operationImpl = new OperationImpl();

    public static final int EXIT = 0, ADD_WORDS = 1, TRANSLATE_FROM_ENGLISH = 2,
            TRANSLATE_FROM_RUSSIAN = 3, SIZE = 4, PRINT_ALL = 5, QUIZ = 6;


    public void start(){
      int answer=999;
        while (answer!=0){
           answer=loopChoose();

            switch (answer){
                case EXIT:
                    System.out.println("App closes.");
                    break;
                case ADD_WORDS:
                    operationImpl.addWords();
                    break;
                case TRANSLATE_FROM_ENGLISH:
                    operationImpl.translateEnToRu();
                    break;
                case TRANSLATE_FROM_RUSSIAN:
                    operationImpl.translateRuToEn();
                    break;
                case SIZE:
                    operationImpl.size();
                    break;
                case PRINT_ALL:
                    operationImpl.printAllWords();
                    break;
                case QUIZ:
                    quiz.startQuiz();
                    break;
                default:
                    System.out.println("Такого вариант нет");
            }

        }


    }

    public int loopChoose(){
        System.out.println("Что желаете сделать с словарем:" +
                "\n 0 - Выйти" +
                "\n 1 - Добавить перевод" +
                "\n 2 - Перевести с английского на русский" +
                "\n 3 - Перевести с русского на английского" +
                "\n 4 - Вывести количество слов" +
                "\n 5 - Вывести все слова" +
                "\n 6 - Начать квиз");


        return sc.nextInt();
    }


}
