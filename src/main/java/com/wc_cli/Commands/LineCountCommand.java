package com.wc_cli.Commands;

import com.wc_cli.utils.FileReaderUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LineCountCommand {

    public static Integer execute(String arg) throws IOException {
        int lineCount = 0;
        InputStream inputStream = FileReaderUtils.getStream(arg);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while(reader.readLine()!=null){
            lineCount+=1;
        }
        return lineCount;
    }
}
