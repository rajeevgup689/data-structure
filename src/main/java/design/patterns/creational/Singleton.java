package design.patterns.creational;

public class Singleton implements Cloneable {
    private static volatile Singleton _instance;

    // private constructor
    private Singleton() {}

    public static Singleton get_instance() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                if (_instance == null) {
                    _instance = new Singleton();
                }
            }
        }

        return _instance;
    }

    // no setter


    // to prevent modification using reflection
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
}