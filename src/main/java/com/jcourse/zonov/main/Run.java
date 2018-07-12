package com.jcourse.zonov.main;

import com.jcourse.zonov.data.FileParserBuff;
import com.jcourse.zonov.data.FileWriter;
import com.jcourse.zonov.data.WordCounter;
import com.jcourse.zonov.exception.BaseException;

import java.io.IOException;
import java.util.*;

public class Run {

    public static void main(String[] args) throws BaseException, IOException {

        System.out.println("Для анализа содержимого введите имя файла");
        Scanner sc = new Scanner(System.in);

        String fileName = sc.next();
        FileParserBuff.parse(fileName);

//        System.out.println("-------------------------<String>------------------------------------");
//
//        for (String d: FileParserBuff.getWordList()){
//            System.out.println("Считано: "+ d);
//        }
//        System.out.println("-------------------------<String, Long>------------------------------------");
//
//        Iterator<Map.Entry<String, Long>> itr = FileParserBuff.getWordMapStringLong().entrySet().iterator();
//
//        while (itr.hasNext()) {
//            Map.Entry<String, Long> entry = itr.next();
//            String key = entry.getKey();
//            Long val =  entry.getValue();
//            System.out.println("key: " + key + " | " + "val: "+ val);
//        }


//        System.out.println("-------------------------<Obj, Long>----------------------------------");
//
//        Iterator<Map.Entry<WordCounter, Long>> itr2 = FileParserBuff.getWordMapObjLong().entrySet().iterator();
//
//        while (itr2.hasNext()) {
//            Map.Entry<WordCounter, Long> entry = itr2.next();
//            WordCounter key = entry.getKey();
//            Long val =  entry.getValue();
//            System.out.println(key.getWord() + " : "+ key.getCount() + " | Long: " + val );
//        }


        System.out.println("-------------------------<String,Obj>----------------------------------");

        List<WordCounter> wordCounterList = new ArrayList<>();

        for (Map.Entry<String, WordCounter> entry : FileParserBuff.getWordMapStringObj().entrySet()) {
            String key = entry.getKey();
            WordCounter val = entry.getValue();
            wordCounterList.add(val);
//            System.out.println("String: " + key + " : | " + "Obj.word: " + val.getWord() + " Obj.count: " + val.getCount());
        }


        Collections.sort(wordCounterList); //сортировка через переопределенный метод compareTo в WordCounter

        for (WordCounter wc: wordCounterList){
            System.out.println(wc);
        }

        FileWriter.saveToFile(wordCounterList);

    }
}
