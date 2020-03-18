import java.util.Random;

public class Voiture implements Runnable {

    private final static Random ALEATOIRE = new Random();
    private final static int LONGUEUR_MAX_ETAPE = 100;
    private String nomPilote;
    private String couleur;
    private int longeurCourse;

    public Voiture(String nom,String couleur) {
        nomPilote = nom;
        this.couleur = couleur;
    }

    public void faireUneCourse(int distance) throws InterruptedException {
        longeurCourse = distance;
        Thread t = new Thread(this);
        t.start();
    }

    public void signifierArrivee() {
        System.out.println(this + " viens de finir la course");
    }

    public String toString() {
        return nomPilote + " (voiture " + couleur + ")";
    }


    @Override
    public void run() {
        int distanceParcourue = ALEATOIRE.nextInt(LONGUEUR_MAX_ETAPE);

        while(distanceParcourue < 100) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int avancement = ALEATOIRE.nextInt(LONGUEUR_MAX_ETAPE);
            distanceParcourue += avancement;

            System.out.println("La voiture " + couleur + " pilotée par " + nomPilote + " a avancé de " + avancement + "m et a déjà parcouru " + distanceParcourue + "m.");
        }

        signifierArrivee();
    }
}
