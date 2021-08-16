package com.AppMenu.Database_Translator;

import com.AppMenu.WordPairs.WordPairs;

import java.util.ArrayList;
import java.util.List;

public class Database_Translator {

    private List<WordPairs> translator = new ArrayList<WordPairs>();

    public WordPairs getPairs(int request){
        return translator.get(request);
    }

    public List<WordPairs> getListWords(){
        return translator;
    }

    public void remove(int i){
        this.translator.remove(i);
    }

    public String getEnWord(int request){
        return translator.get(request).getEnWord();
    }

    public String getRuWord(int request){
        return translator.get(request).getRuWord();
    }

    public int getSize(){
        return this.translator.size();
    }

    public WordPairs wordPairsByIndex(int index){
        return new WordPairs(translator.get(index).getRuWord(), translator.get(index).getEnWord());
    }



    public void addWords(WordPairs words) {
        this.translator.add(words);
    }



}
