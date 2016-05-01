package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Created by matthew on 01/05/16.
 */
public class ConfigLoader
{
    public static Config loadConfig(String path) throws NoSuchElementException, IOException
    {
        int propertyCount = 0;
        Config config = new Config();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            for(String line; (line = br.readLine()) != null; ) {
                line = line.trim();
                if(line.toCharArray()[0] == '#') continue;
                if (line.length() >= 3)
                {
                    String[] parts = line.split("=");
                    if (parts.length >1)
                    {
                        String name = parts[0].trim();
                        String value;
                        if (parts.length==2)
                        {
                            value = parts[1].trim();
                        }
                        else
                        {
                            StringJoiner sj = new StringJoiner("=");
                            for(int i=1; i<parts.length; i++) sj.add(parts[i]);
                            value = sj.toString().trim();
                        }
                        config.addProperty(name, value);
                        propertyCount++;
                    }
                }
            }
        }
        if (propertyCount>0) return config;
        throw new NoSuchElementException();
    }
}
