package com.jcourse.zonov.data;

import com.jcourse.zonov.exception.BaseException;

import java.io.*;
import java.util.List;

public class FileWriterBuff {

    public static void saveToFile(List<WordCounter> wc) throws BaseException {

        try (Writer out = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("csv")),"UTF-8")) {

            StringBuffer stringBuffer = new StringBuffer();
            int totalCount = WordCounter.getTotalCount();

            for (int i=0; i < wc.size(); i++){
                String word = wc.get(i).getWord();
                int count = wc.get(i).getCount();
                int countProc = 100*count/totalCount;

                stringBuffer.append(word).append(',').append(count).append(',').append(countProc).append('%').append("\n");
                out.write(stringBuffer.toString());
                stringBuffer.setLength(0);
            }

        } catch (FileNotFoundException e) {
            throw new BaseException("Файл для записи не найден");
        } catch (IOException e) {
            throw new BaseException("Ошибка ввода/вывода");
        }
    }

}
