package Property;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader
{
    public static String path=System.getProperty("user.dir")+"/src/test/Resources/config.properites";
    public static String readFile(String keyValue)
    {
        FileReader fis;
        Properties prop;
        String text="";
        try {
            fis=new FileReader(path);
            prop=new Properties();
            prop.load(fis);
            text=prop.getProperty(keyValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
