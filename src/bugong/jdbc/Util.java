package bugong.jdbc;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yanlv.yin on 2018/3/6.
 */
public class Util {

    public static void load() {
        try {
            Properties p = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream in = loader.getResourceAsStream("db.properties");

            p.load(in);
            System.out.println(p.getProperty("username"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Util.load();
    }
}
