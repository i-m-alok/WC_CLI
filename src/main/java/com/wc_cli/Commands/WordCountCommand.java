package com.wc_cli.Commands;

import com.wc_cli.utils.FileReaderUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WordCountCommand implements Command {
    public static Integer execute(String arg) throws IOException {
        int wordCount = 0;

        InputStream inputStream = FileReaderUtils.getStream(arg);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        int chars;
        boolean isWord = false;
        while((chars=reader.read())!=-1){
            if(Character.isWhitespace(chars)) {
                if (isWord) wordCount += 1;
                isWord=false;
            } else{
                isWord=true;
            }
        }
        if (isWord) wordCount += 1;
        return wordCount;
    }
}
