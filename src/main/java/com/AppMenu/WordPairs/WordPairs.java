package com.AppMenu.WordPairs;

import java.util.Objects;

public class WordPairs {

    private String ruWord;
    private String enWord;

    public WordPairs(String ruWord, String enWord) {
        this.ruWord = ruWord;
        this.enWord = enWord;
    }

    public void setRuWord(String ruWord) {
        this.ruWord = ruWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getRuWord() {
        return ruWord;
    }

    public String getEnWord(){
        return enWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordPairs wordPairs = (WordPairs) o;
        return Objects.equals(ruWord, wordPairs.ruWord) &&
                Objects.equals(enWord, wordPairs.enWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruWord, enWord);
    }

    @Override
    public String toString() {
        return "com.AppMenu.WordPairs{" +
                "ruWord='" + ruWord + '\'' +
                ", enWord='" + enWord + '\'' +
                '}';
    }
}
