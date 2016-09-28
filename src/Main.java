
public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();
        Thread t = new Thread(controller);
        t.start();
    }
}
