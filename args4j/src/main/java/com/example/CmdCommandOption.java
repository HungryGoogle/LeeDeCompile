package com.example;

import org.kohsuke.args4j.Option;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 2017/9/27.
 */

public class CmdCommandOption {
    @Option(name="-src", usage="input src")
    public String src = "";

    @Option(name="-dst", usage="input dst")
    public String dst = "";

    @Option(name="-enable", usage="bool value. enable.")
    public boolean enable = true;

    @Option(name = "-t", aliases = "-text", usage = "use given information(String)")
    public String text;

    @Option(name = "-b", usage = "display current time(boolean)")
    public boolean bol = false;

    @Option(name = "-s", aliases = "-size", usage = "use given size(Integer)")
    public int size = 0;

    @Option(name = "-f", aliases = { "-file" }, metaVar = "<file>", usage = "use given file(File)")
    public File file;

    public Map<String, String> properties = new HashMap<String, String>();
    @Option(name = "-D", metaVar = "<property>=<value>", usage = "use value for given property(property=value)")
    public void setProperty(final String property) {
        String[] arr = property.split("=");
        properties.put(arr[0], arr[1]);
    }
}
