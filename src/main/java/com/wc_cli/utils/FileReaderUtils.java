package com.wc_cli.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtils {

    public static InputStream getStream(String filePathOrText) throws IOException {
        InputStream inputStream;
        try {
            inputStream = Files.newInputStream(Paths.get(filePathOrText));
        } catch (IOException e){
            inputStream = new ByteArrayInputStream(filePathOrText.getBytes());
        } catch (Exception e){
            String fileName = "pipeInput.txt";
            inputStream = Files.newInputStream(Paths.get(fileName));
        }
        return  inputStream;
    }

    public static void savePipedInput() throws IOException {
        // As this is a blocking read we need to check
        // if we have input then only proceed, System.in.available()!=0
        if(System.in.available()!=0) {
            StringBuilder inputText = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    inputText.append(line).append('\n');
                }
            }
            createOrRecreateFile(inputText.toString());
        }
    }

    public static void createOrRecreateFile(String content) {
        // Define the file name
        String fileName = "pipeInput.txt";

        // Create a File object
        File file = new File(fileName);
        FileWriter fileWriter = null;
        try {
            // Create or overwrite the file
            fileWriter = new FileWriter(file);
            // Write the content to the file
            fileWriter.write(content.trim());
            //System.out.println("File created/recreated and content written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("An error occurred while creating or writing to the file.");
        } finally {
            // Close the FileWriter
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
