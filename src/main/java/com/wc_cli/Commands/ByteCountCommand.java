package com.wc_cli.Commands;

import com.wc_cli.utils.FileReaderUtils;

import java.io.*;

public class ByteCountCommand implements Command {
    public static Integer execute(String arg) throws IOException {
        byte[] byteArray = new byte[1024];
        InputStream inputStream = FileReaderUtils.getStream(arg);
        int byteCount = 0;
        int bufferCount = 0;
        while((bufferCount=inputStream.read(byteArray))!=-1){
            byteCount+=bufferCount;
        }
        return byteCount;
    }
}
