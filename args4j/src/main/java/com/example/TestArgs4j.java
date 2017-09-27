package com.example;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.util.Date;

public class TestArgs4j {
    public static void main(String[] args) {

        args = new String[] { "-dst", "to dst", "-enable", "-text", "rensanning", "-f", "c:/aa.txt", "-b", "-s", "10", "-D", "key1=value1" , "-D", "key2=value2"};

        CmdCommandOption option  = new CmdCommandOption();
        CmdLineParser parser = new CmdLineParser(option);

        try {

            if (args.length == 0){
                showHelp(parser);
                return;
            }

            parser.parseArgument(args);
            parser.printUsage(System.out);
            System.out.println();

            System.out.println(option.src);
            System.out.println(option.dst);
            System.out.println(option.enable);

            // check the options have been set correctly
            System.out.println(option.text);
            System.out.println(option.file.getName());
            if(option.bol) {
                System.out.println(new Date());
            }
            System.out.println(option.size);
            System.out.println(option.properties.get("key1"));
            System.out.println(option.properties.get("key2"));



        }catch (CmdLineException cle){
            System.out.println("Command line error: " + cle.getMessage());
            showHelp(parser);
            return;
        }catch (Exception e){
            System.out.println("Error in main: " + e.getMessage());
            e.printStackTrace();
            return;
        }

    }

    public static void showHelp(CmdLineParser parser){
        System.out.println("LDA [options ...] [arguments...]");
        parser.printUsage(System.out);
    }
}
