package bugong.jdbc;

import bugong.jdbc.annotation.Column;
import bugong.jdbc.annotation.Table;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

@Table("t_user")
public class User {

    @Column("name")
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) throws Exception {

        User user = new User();

        user.setUsername("bugong");
        user.setAge(1);

        Class<User> klass = (Class<User>)user.getClass();
        String tableName = klass.getSimpleName();

        if (klass.isAnnotationPresent(Table.class)) {

            tableName = klass.getAnnotation(Table.class).value();
        }

        System.out.println("table: " + tableName);

        BeanInfo beanInfo = Introspector.getBeanInfo(user.getClass(), Object.class);

        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor pd : pds) {

            String columnName = pd.getName();

            Field field = klass.getDeclaredField(columnName);

            if (field.isAnnotationPresent(Column.class)) {
                columnName = field.getAnnotation(Column.class).value();
            }

            System.out.printf("column: %s; value: %s;\n", columnName, pd.getReadMethod().invoke(user));
        }
    }
}
