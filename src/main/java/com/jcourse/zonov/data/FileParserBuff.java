package com.jcourse.zonov.data;

import com.jcourse.zonov.exception.BaseException;

import java.io.*;
import java.util.*;

public class FileParserBuff {
    private static List<String> listOfWords = new ArrayList<>();
    private static Map<String, Long> wordMap = new HashMap<>();
    private static Map<WordCounter, Long> wordMapObj = new LinkedHashMap<>();
    private static int totalCount;

    public static void parse(String fileName) throws BaseException, IOException {
        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(fileName)))){

            StringBuffer stringBuffer = new StringBuffer();

            int read = 0;
            while (read != -1){
                char[] buffer = new char[4096];
                read = r.read(buffer);
                for (char c : buffer) {
                    if(Character.isLetterOrDigit(c)) {  //проверка: число/буква?
                        stringBuffer.append(c);
                    }
                    else if(stringBuffer.length()!=0){ //нужна проверка на наличии символов, иначе будут вноситься пустые элементы
                        totalCount++;
//                        listOfWords.add(stringBuffer.toString());
//                        wordMap.merge (stringBuffer.toString(), 1L, (prev, initial) -> prev + initial);
                        wordMapObj.merge (new WordCounter(stringBuffer.toString()), 1L, (prev, initial) -> prev + initial);

                        stringBuffer.setLength(0);
                    }

                }
            }

        }
        catch (FileNotFoundException e) {
            throw new BaseException("Ошибка считывания данных из файла " + fileName);
        }
    }


    public static List<String> getListOfWords() {
        return listOfWords;
    }

    public static Map<String, Long> getWordMap() {
        return wordMap;
    }

    public static Map<WordCounter, Long> getWordMapObj() {
        return wordMapObj;
    }


    public static int getTotalCount() {
        return totalCount;
    }
}
