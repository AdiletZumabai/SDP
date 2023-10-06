public class Singleton {

    private static Singleton instance;

    //  содержит единственный экземпляр класса Singleton
    private Singleton() {}

    public static synchronized Singleton getInstance() {
       // используется для получения единственного экземпляра класса Singleton.
        if (instance == null) {
            // проверяется существует ли уже экземпляр класса Singleton.
            instance = new Singleton();
            // создается новый экземпляр класса Singleton
        }
        return instance;
    }// возвращает или созданный ранее экземпляр или новый экземпляр


    public void showMessage() {
        System.out.println("Hello from Singleton!");
    // демонстрирует функциональность







    }
}

