package example;

import config.Config;
import config.ConfigLoader;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Created by matthew on 01/05/16.
 */
class Test
{
    public static void main(String[] args)
    {
        System.out.println("Test 1: Actual config file");
        System.out.println();
        test("configs/test.config");
        System.out.println();
        System.out.println("Test 2: Empty config file");
        System.out.println();
        test("configs/empty.config");
        System.out.println();
        System.out.println("Test 3: Non existent config file");
        System.out.println();
        test("configs/nonExistent.config");
    }

    private static void test(String path)
    {
        try
        {
            Config config = ConfigLoader.loadConfig(path);
            for (String property:config.getProperties())
                System.out.println(property + " : " + config.getProperty(property));
        }
        catch (NoSuchElementException e)
        {
            System.out.println("No elements");
        }
        catch (IOException e)
        {
            System.out.println("Error loading file");
            System.out.println(e.toString());
        }
    }
}
