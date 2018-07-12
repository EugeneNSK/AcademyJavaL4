package com.jcourse.zonov.data;

import com.jcourse.zonov.exception.BaseException;

import java.io.*;
import java.util.*;

public class FileParser {

    private static List<String> wordList = new ArrayList<>();
    private static Map<String, Long> wordMapStringLong = new HashMap<>();
    private static Map<WordCounter, Long> wordMapObjLong = new LinkedHashMap<>();
    private static Map<String, WordCounter> wordMapStringObj = new LinkedHashMap<>();

    public static void parse(String fileName) throws BaseException, IOException {

        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(fileName)))) {


            StringBuffer stringBuffer = new StringBuffer();

            int read = 0;
            while (read != -1) {
                read = r.read();
                char c = (char) read; //считали символ
                if (Character.isLetterOrDigit(c)) {  //проверка: число/буква?
                    stringBuffer.append(c);
                }
                else if (stringBuffer.length() != 0) { //нужна проверка на наличии символов, иначе будут вноситься пустые элементы
//                        wordList.add(stringBuffer.toString());
//                        wordMapStringLong.merge (stringBuffer.toString(), 1L, (prev, initial) -> prev + initial);
//                        wordMapObjLong.merge (new WordCounter(stringBuffer.toString()), 1L, (prev, initial) -> prev + initial);
                    wordMapStringObj.merge(stringBuffer.toString(), new WordCounter(stringBuffer.toString()), (prev, initial) -> prev.addCount(prev));
                    stringBuffer.setLength(0);
                }

            }
        }
        catch (FileNotFoundException e) {
            throw new BaseException("Ошибка считывания данных из файла " + fileName);
        }
    }


    public static List<String> getWordList() {
        return wordList;
    }

    public static Map<String, Long> getWordMapStringLong() {
        return wordMapStringLong;
    }

    public static Map<WordCounter, Long> getWordMapObjLong() {
        return wordMapObjLong;
    }

    public static Map<String, WordCounter> getWordMapStringObj() {
        return wordMapStringObj;
    }

}
