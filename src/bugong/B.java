package bugong;

/**
 * Created by yanlv.yin on 2018/3/16.
 */
public class B extends A {

    private String code;

    public B(String code) {

        super(code);

        this.code = code;
        System.out.println("construct child, code is " +  this.code);
    }

    @Override
    public void say(String msg) {

        System.out.println("child: " + msg);
    }

    public void speak() {

        this.say("hello");
    }


    public static void main(String[] args) {

        B b = new B("y");

        b.speak();
    }
}
