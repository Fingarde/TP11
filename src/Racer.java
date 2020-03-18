public class Racer {

    public static void main(String[] args) throws InterruptedException {

        Voiture voiture = new Voiture("Denis","Jaune");
        Voiture voiture1 = new Voiture("Cyril","Bleu");
        Voiture voiture2 = new Voiture("Antoine","Rose");

        Course course = new Course(200);
        course.inscrire(voiture);
        course.inscrire(voiture1);
        course.inscrire(voiture2);

        course.lancerLaCourse();
    }
}
