package com.wc_cli.Commands;

import com.wc_cli.utils.FileReaderUtils;

import java.io.*;

public class CharCountCommand {
    public static Integer execute(String arg) throws IOException {
        int charCount = 0;
        InputStream inputStream = FileReaderUtils.getStream(arg);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while(reader.read()!=-1){
            charCount+=1;
        }
        return charCount;
    }
}
