package bugong;

public enum Type {

    A(0, "a"), B(1, "b"), C(3, "c");

    private int code;
    private String value;

    Type(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {

        return code;
    }

    String getValue() {

        return value;
    }
}