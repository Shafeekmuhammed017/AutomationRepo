package Config;

import java.io.*;
import java.util.Properties;

public class propertiesFile {
    static Properties prop = new Properties();
    static String projectpath = System.getProperty("user.dir");

    public static void main(String[] args) throws FileNotFoundException {
        getproperties();
        setproperties();
        getproperties();

    }

    public static void getproperties() throws FileNotFoundException {
        try {


            FileInputStream fis = new FileInputStream(projectpath + "/src/test/com.Training/Config/config.properties");
            prop.load(fis);
            String browsername = prop.getProperty("browser");
            System.out.println("Browser is :       "+browsername);

        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
    public static void setproperties() throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(projectpath + "/src/test/com.Training/Config/config.properties");
            prop.setProperty("browser","chrome");
            prop.setProperty("Name","Shafeek Muhammed");
            prop.setProperty("Result :","PASS");
            prop.store(fos,"Stores values in property files");
        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
}
