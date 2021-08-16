package com.AppMenu.TranslatorDAO;

import com.AppMenu.Database_Translator.Database_Translator;
import com.AppMenu.WordPairs.WordPairs;

public class TranslatorDAO {

    private final Database_Translator database_translator = new Database_Translator();

    {
        database_translator.addWords(new WordPairs("есть (в значении \" у меня есть\"", "have"));
        database_translator.addWords(new WordPairs("идти", "go"));
        database_translator.addWords(new WordPairs("нравится", "like"));
        database_translator.addWords(new WordPairs("кушать", "eat"));
        database_translator.addWords(new WordPairs("человек", "human"));
        database_translator.addWords(new WordPairs("собака", "dog"));
        database_translator.addWords(new WordPairs("кот", "cat"));
        database_translator.addWords(new WordPairs("смотреть", "watch"));
        database_translator.addWords(new WordPairs("красиво", "beautiful"));
        database_translator.addWords(new WordPairs("яблоко", "apple"));
        database_translator.addWords(new WordPairs("растение", "plant"));

    }

    public void printAll(){
        System.out.println("На русском || На английском");
        database_translator.getSize();

        for (WordPairs words: database_translator.getListWords()){
            System.out.println(words.getRuWord()+" || "+words.getEnWord());
        }
    }

    public Database_Translator getDatabase_translator(){
        return this.database_translator;
    }

    public int getSizeTranslator(){
        return database_translator.getSize();
    }

    public void addWords(String ruWord, String enWord){
        boolean check = false;

        for (WordPairs words: database_translator.getListWords()){
            if(words.getRuWord().equals(ruWord) && !words.getEnWord().equals(enWord)){
                System.out.println("Перевод слова "+ruWord+" на английском был перезаписан с "+words.getEnWord()+" на "+enWord);
                words.setEnWord(enWord);
                check = true;
                break;
            }

            if(words.getEnWord().equals(enWord) && !words.getRuWord().equals(ruWord)){
                System.out.println("Перевод слова "+enWord+"  на русском был перезаписан с "+words.getRuWord()+" на "+ruWord);
                words.setRuWord(ruWord);
                check = true;
                break;
            }

            if(words.getEnWord().equals(enWord) && words.getRuWord().equals(ruWord)){
                System.out.println("В словаре уже есть этот перевод");
                check = true;
                break;
            }

        }

        if(!check){
            database_translator.addWords(new WordPairs(ruWord, enWord));
        }

    }

    public String findEnWord(String ruWord){
        for (WordPairs words: database_translator.getListWords()){
            if(words.getRuWord().equals(ruWord)){
                return words.getEnWord();
            }
        }
        return "Слово не найдено";
    }

    public String findRuWord(String enWord){
        for (WordPairs words: database_translator.getListWords()){
            if(words.getEnWord().equals(enWord)){
                return  words.getRuWord();
            }
        }
        return "Слово не найдено";
    }

    public boolean checkCommonWord(Database_Translator database_translator, String word){
        for (WordPairs words: database_translator.getListWords()){
            if (words.getEnWord().equals(word) || words.getRuWord().equals(word)){
                return true;
            }
        }
        return false;
    }



}
