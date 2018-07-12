package com.jcourse.zonov.data;

import com.jcourse.zonov.exception.BaseException;

import java.io.*;
import java.util.List;

public class FileWriter {

    public static void saveToFile(List<WordCounter> wc) throws BaseException {

        try (Writer out = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("csv")),"UTF-8")) {

            for (int i=0; i < wc.size(); i++){
                int count = wc.get(i).getCount();
                int totalCount = wc.get(i).getTotalCount();
                int countProc = 100*count/totalCount;

                out.write(wc.get(i).getWord());
                out.append(',');
                out.write(String.valueOf(count));
                out.append(',');
                out.write(String.valueOf(countProc));
                out.append('%');
                out.append("\n");
            }


        } catch (FileNotFoundException e) {
            throw new BaseException("Файл для записи не найден");
        } catch (IOException e) {
            throw new BaseException("Ошибка ввода/вывода");
        }
    }

}
