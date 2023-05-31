package org.example;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTimeStamper {
    public static void main(String[] args) {
        final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        File dbFolder = new File(args[0]); //The containing folder

        File[] files = dbFolder.listFiles();
        //To play around with the regex expression, use: https://regex101.com/
        Pattern fileNamePattern = Pattern.compile("([RUV]\\d+_(x)+__[-\\w]+\\.sql)");
        Matcher regexMatcher;
        if(files == null || files.length == 0) {
            System.out.println("No files found");
            return;
        }
        for(File file : files) {
            regexMatcher = fileNamePattern.matcher(file.getName());
            if(regexMatcher.find()){
                String timeStamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
                //This returns the parent folder of `file`
                // String absPath = file.getAbsoluteFile().getParent();
                String newFileName = file.getName().replaceAll("(?i)_(x)+__", ("_" + timeStamp + "__"));
                String newAbsPath = dbFolder.getPath() + "/" + newFileName;
                file.renameTo(new File(newAbsPath));
            }
        }
    }
}