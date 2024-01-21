import java.util.Random;

public class Coal extends BattleLoc{
    public Coal(Player player) {
        super(player,"Maden",new Snake()," Para, Silah veya Zırh",randomLocNumber());
    }

    public static int randomLocNumber() {
        int min = 1;
        int max = 5;

        Random random = new Random();
        int rastgeleYılan = random.nextInt((max - min) + 1) + min;
        return rastgeleYılan;
    }

}










