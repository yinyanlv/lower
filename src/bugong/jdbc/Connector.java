package bugong.jdbc;

import bugong.jdbc.annotation.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by yanlv.yin on 2018/2/26.
 */
@Table("user")
public class Connector {

    public void connect() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yzone", "root", "111111");

        Statement stm = conn.createStatement();

        String table = this.getClass().getAnnotation(Table.class).value();

        ResultSet rs = stm.executeQuery("SELECT * FROM " + table);

        while (rs.next()) {

            String username = rs.getString(rs.findColumn("username"));
            System.out.println(username);
        }

        conn.close();
    }

    public static void main(String[] args) throws Exception {

        Connector c = new Connector();
        c.connect();
    }
}
