
public class Controller implements Runnable{
    private Model model = new Model();
    private View view = new View();

    void play(){
                view.init();
                while(true) {
                    model.doStep();
                    view.refresh();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


    }


    @Override
    public void run() {
        play();
    }
}
