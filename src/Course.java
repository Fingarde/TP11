import java.util.LinkedList;
import java.util.List;

public class Course  {
    private int distancePiste;
    private List<Voiture> concurrents = new LinkedList<>();

    public Course(int distance){
        distancePiste=distance;
    }

    public void inscrire(Voiture v){
        concurrents.add(v);
    }

    public void lancerLaCourse() throws InterruptedException {

        Thread moi = new Thread(() -> {
            for(Voiture v : concurrents){

                Thread thread = new Thread(v);

                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        moi.start();
        moi.join();


        System.out.println("Course finie");

    }

}
