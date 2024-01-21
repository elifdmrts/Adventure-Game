import java.util.Random;

public class Snake extends Obstacle{



    public Snake() {
        super(4,"Yılan",randomObstacleNumber(),12,0);


    }
    public static int randomObstacleNumber() {
        int min = 3;
        int max = 6;

        Random random = new Random();
        int rastgeleHasar = random.nextInt((max - min) + 1) + min;
        return rastgeleHasar;
    }

}
