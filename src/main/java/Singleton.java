public class Singleton {
    private static volatile Singleton _INSTANCE;

    private Singleton() {}

    public static Singleton getInstance(){
        if(_INSTANCE == null) {
            synchronized(Singleton.class) {
                if(_INSTANCE == null) {
                    _INSTANCE = new Singleton();
                }
            }
        }

        return _INSTANCE;
    }

    static void main() {
        Singleton.getInstance().call();
    }

    public void call() {
        System.out.println("called calling method...");
    }
}
