package org.factapi.random.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class FileUtil {
    public String readFile(int num)  {
        try {

            ClassPathResource resource = new ClassPathResource("facts/fact"+num+".txt");
            InputStream inputStream = resource.getInputStream();

            String everything = IOUtils.toString(inputStream);
            inputStream.close();
            return everything;
        }
        catch (Exception e) {
            throw  new RuntimeException("Что-то не то");
        }

    }
    public int getFactsCount(){
        URL resource = FileUtil.class.getClassLoader().getResource("facts");;
        File count;
        try {
            count = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return count.list().length;
    }

    public boolean writeToLogFile(String str)  {
        try {
            ClassPathResource resource = new ClassPathResource("log.txt");
            try(FileWriter fileWriter = new FileWriter(resource.getPath(),true)){
                fileWriter.write(str + "\n");
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }
}
