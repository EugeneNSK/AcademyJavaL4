package com.jcourse.zonov.data;

import com.jcourse.zonov.exception.BaseException;

import java.io.*;
import java.util.*;

public class FileParser {

    private static Reader r;
    private static List<String> listOfWords = new ArrayList<>();

    public static void parse(String s) throws BaseException, IOException {

        try {

            r = new InputStreamReader(new BufferedInputStream(new FileInputStream(s)));

        } catch (FileNotFoundException e) {
            throw new BaseException("Ошибка считывания данных из файла " + s);
        }


        StringBuffer stringBuffer = new StringBuffer();

        while (r.ready()){
            char c = (char)r.read(); //считали символ
            if(Character.isLetterOrDigit(c)){  //проверка: число/буква?
                stringBuffer.append(c);
            }
            else if(stringBuffer.length()!=0){ //нужна проверка на наличии символов, иначе будут вноситься пустые элементы
//                listOfWords.add(stringBuffer.toString());
//                WordCounter.putWord(stringBuffer.toString());
                stringBuffer.delete(0,stringBuffer.length());
            }
        }
    }

    public static List<String> getListOfWords() {
        return listOfWords;
    }
}
