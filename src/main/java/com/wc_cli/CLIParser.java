package com.wc_cli;

import com.wc_cli.enums.CLIOption;
import org.apache.commons.cli.*;

import java.util.Arrays;

public class CLIParser {

    CommandLine cmd;
    public CLIParser process(String[] args){

        Options options = new Options();

        for(CLIOption cliOption: CLIOption.values()){
            options.addOption(new Option(cliOption.getShortOpt(), cliOption.getLongOpt(), cliOption.isHasArg(), cliOption.getDescription()));
        }

        CommandLineParser commandLineParser = new DefaultParser();
        try {
            cmd = commandLineParser.parse(options, args);

        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            System.out.println(Arrays.toString(args));
            formatter.printHelp("Please the appropriate options", options);
            System.exit(0);
        }
        return this;
    }

    public String getOptionValue(String option){
        return cmd.getOptionValue(option);
    }

    public Boolean hasOption(String option){
        return cmd.hasOption(option);
    }

    public Boolean hasOption(char option){
        return cmd.hasOption(option);
    }

}
