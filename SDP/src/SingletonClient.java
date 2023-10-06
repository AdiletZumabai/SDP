public class SingletonClient {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            // цикл создает 5 потоков
            Thread thread = new Thread(() -> {
                Singleton singleton = Singleton.getInstance();
                // несколько потоков может получить доступ к синглтону
                singleton.showMessage();
            });
            thread.start();
        }
    }
}
