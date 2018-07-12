package com.jcourse.zonov.data;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class WordCounter implements Comparable <WordCounter>{
    private String word;
    private int count;
    private static int totalCount;



    public WordCounter(String word) {
        this.word = word;
        this.count++;
        totalCount++;
    }


    public WordCounter addCount (WordCounter wc){
        int tempCount = wc.getCount()+1;
        wc.setCount(tempCount);
        return wc;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCounter that = (WordCounter) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "WordCounter{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(WordCounter o) {
        if (this.count < o.getCount()){
            return 1;
        }
        else if(this.count > o.getCount()){
            return -1;
        }
        else return 0;    }
}

