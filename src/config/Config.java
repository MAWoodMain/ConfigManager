package config;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by matthew on 01/05/16.
 */
public class Config
{
    private final HashMap<String, String> properties;

    Config()
    {
        properties = new HashMap<>();
    }

    void addProperty(String name, String value)
    {
        properties.put(name, value);
    }

    public String getProperty(String name) throws NoSuchElementException
    {
        for (String property:properties.keySet())
        {
            if (property.equals(name)) return properties.get(property);
        }
        throw new NoSuchElementException();
    }

    public Set<String> getProperties()
    {
        return properties.keySet();
    }
}
