package bugong;

/**
 * Created by yanlv.yin on 2018/3/16.
 */
public class A {

    private String code;

    public A(String code) {

        this.code = code;
        System.out.println("construct super, code is " + this.code);
    }

    public void say(String msg) {
        System.out.println("super: " + msg);
    }
}
