import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Scanner;

public class Player {

    private int id;
    private int damage;
    private String name;
    private String charname;
    private int healthy;
    private int orjinalHealty;
    private int money;

    private Inventory inventory;
    private String award;

    private int location;


    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.award = String.valueOf(0);
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("----------------------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println(gameChar.getId() + "-)" +
                    "\tKarakter: " + gameChar.getName() +
                    "\t Hasar: " + gameChar.getDamage() +
                    "\t Sağlık: " + gameChar.getHealthy() +
                    "\t Para: " + gameChar.getMoney());
        }

        System.out.println("----------------------------------------------------------");
        System.out.print("Lütfen Bir Karakter Seçiniz: ");
        int selectChar = scanner.nextInt();
        System.out.println();
        while (selectChar != 1 && selectChar != 2 && selectChar != 3) {
            System.out.print("Yanlış Bir Giriş Yaptınız. 1., 2. veya 3. Karakteri seçiniz:  ");
            selectChar = scanner.nextInt();
        }
        System.out.println();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Hatalı giriş yaptınız. Oyuna Samuray olarak devam edeceksiniz");
                initPlayer(new Samurai());

        }

        System.out.println(this.getId() + "-)" +
                "\tKarakter: " + this.getCharname() +
                "\t Hasar: " + this.getDamage() +
                "\t Sağlık: " + this.getHealthy() +
                "\t Para: " + this.getMoney());

    }


    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealthy());
        this.setOrjinalHealty(gameChar.getHealthy());
        this.setMoney(gameChar.getMoney());
        this.setCharname(gameChar.getName());
        this.setId(gameChar.getId());


    }

    public void printinfo() {
        System.out.println("Silah:" + this.getInventory().getWeapon().getName() +
                "\t Zırh:" + this.getInventory().getArmor().getName() +
                "\t Bloklama:" + this.getInventory().getArmor().getBlock() +
                "\t Hasar: " + this.getTotalDamage() +
                "\t Sağlık: " + this.getHealthy() +
                "\t Para: " + this.getMoney()+
                "\t Yemek  : " + this.getInventory().getFoodCount() +
                "\t Odun  : " + this.getInventory().getFireWoodCount() +
                "\t Su : " + this.getInventory().getWaterCount());
        System.out.println("-----------------------------------------------------------");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

    }

    public String getAward() {

        return award;
    }

    public void setAward(String award) {

        this.award = award;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {

        return damage + this.getInventory().getWeapon().getDamage();

    }

    public int getTotalDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        if (healthy < 0) {
            healthy = 0;
        }
        this.healthy = healthy;
    }

    public int getMoney() {

        return money;

    }

    public void setMoney(int money) {

        this.money = money;

    }

    public String getCharname() {
        return charname;
    }

    public void setCharname(String charname) {
        this.charname = charname;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    public int getOrjinalHealty() {
        return orjinalHealty;
    }

    public void setOrjinalHealty(int orjinalHealty) {
        this.orjinalHealty = orjinalHealty;
    }
}