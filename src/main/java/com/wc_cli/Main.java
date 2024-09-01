package com.wc_cli;

import com.wc_cli.Commands.ByteCountCommand;
import com.wc_cli.Commands.CharCountCommand;
import com.wc_cli.Commands.LineCountCommand;
import com.wc_cli.Commands.WordCountCommand;
import com.wc_cli.enums.CLIOption;
import com.wc_cli.utils.FileReaderUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CLIParser optionParser = new CLIParser().process(args);
        FileReaderUtils.savePipedInput();

        if(optionParser.hasOption(CLIOption.ByteCount.getLongOpt())){
            System.out.println(ByteCountCommand.execute(optionParser.getOptionValue(CLIOption.ByteCount.getLongOpt())));
        } else if (optionParser.hasOption(CLIOption.CharacterCount.getLongOpt())) {
            System.out.println(CharCountCommand.execute(optionParser.getOptionValue(CLIOption.CharacterCount.getLongOpt())));
        } else if (optionParser.hasOption(CLIOption.LineCount.getLongOpt())) {
            System.out.println(LineCountCommand.execute(optionParser.getOptionValue(CLIOption.LineCount.getLongOpt())));
        } else if(optionParser.hasOption(CLIOption.WordCount.getLongOpt())) {
            System.out.println(WordCountCommand.execute(optionParser.getOptionValue(CLIOption.WordCount.getLongOpt())));
        }else{
            for(String path: optionParser.cmd.getArgs()){
                System.out.print("BC::"+ByteCountCommand.execute(path) + "\t");
                System.out.print("CC::"+CharCountCommand.execute(path)+ "\t");
                System.out.print("LC::"+LineCountCommand.execute(path)+ "\t");
                System.out.print("WC::"+WordCountCommand.execute(path));
            }
        }
    }
}
