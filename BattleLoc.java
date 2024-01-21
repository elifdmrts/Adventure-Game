import javax.swing.plaf.synth.Region;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan Buradasınız:" + this.getName());
        System.out.println("Dikkat " + obsNumber + " tane " + this.getObstacle().getName() + " Çıkabilir!");
        System.out.print("{S}avaş veya {K}aç : ");
        String selectCase = scanner.nextLine().toUpperCase();
        if (selectCase.equals("S") && conbat(obsNumber)) {

            System.out.println(this.getName() + " Tüm Düşmanları Yendiniz!");
            return true;
        }

        if (this.getPlayer().getHealthy() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }
        return true;
    }


    public boolean conbat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealthy(this.getObstacle().getOrjinalHealty());
            playerStats();
            obstacleStarts(i);
            while (this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealthy() > 0) {
                System.out.print("{V}ur veya {K}aç: ");
                String selectConbat = scanner.nextLine().toUpperCase();
                if (selectConbat.equals("V")) {
                    System.out.println();
                    if (Math.random() < 0.5) {
                        System.out.println("İlk hamleyi yapacak olan Siz");

                        System.out.println("Siz Vurdunuz!");
                        this.getObstacle().setHealthy(this.getObstacle().getHealthy() - this.getPlayer().getTotalDamage());
                        afterWit();
                        if (this.getPlayer().getHealthy() <= 0) {
                            System.out.println("Öldünüz!");
                            return false;
                        }
                    } else {
                        System.out.println("İlk hamleyi yapacak olan Canavar");
                        System.out.println("Canavar Size Vurdu!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                        afterWit();
                        if (this.getPlayer().getHealthy() <= 0) {
                            System.out.println("Öldünüz!");
                            return false;
                        }
                    }

                } else {
                    return false;
                }

            }
            if (this.getObstacle().getHealthy() < this.getPlayer().getHealthy()) {
                int count = 0;
                System.out.println("Düşmanı yendiniz.");
                System.out.println(this.getObstacle().getMoney() + " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
                if (i == obsNumber && this.getObstacle().getName().equals("Zombi")) {
                    this.getPlayer().getInventory().setFood(true);
                    count++;
                    System.out.println("Tebrikler yemek kazandınız.");
                    this.getPlayer().getInventory().setFoodCount(count);
                } else if (i == obsNumber && this.getObstacle().getName().equals("Vampir")) {
                    this.getPlayer().getInventory().setFireWood(true);
                    count++;
                    System.out.println("Tebrikler odun kazandınız.");
                    this.getPlayer().getInventory().setFireWoodCount(count);
                } else if (i == obsNumber && this.getObstacle().getName().equals("Ayı")) {
                    this.getPlayer().getInventory().setWater(true);
                    count++;
                    System.out.println("Tebrikler su kazandınız.");
                    this.getPlayer().getInventory().setWaterCount(count);

                } else if (i == obsNumber && this.getObstacle().getName().equals("Yılan")) {
                    kazancHesapla();
                }

            }

        }
        return true;

    }

    public void afterWit() {
        System.out.println("Canınız: " + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealthy());
        System.out.println("----------------");
    }

    public void playerStats() {
        System.out.println();
        System.out.println("Oyuncu Değerleri: ");
        System.out.println("---------------------------------- ");
        System.out.println("Sağlık: " + this.getPlayer().getHealthy());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Para: " + this.getPlayer().getMoney());


    }

    public void obstacleStarts(int i) {
        System.out.println();
        System.out.println(i + "." + this.getObstacle().getName() + "Değerleri: ");
        System.out.println("----------------------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealthy());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getMoney());


    }


    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }


    public static void kazancHesapla() {
        Random random = new Random();
        double kazanmaIhtimali = random.nextDouble() * 100; // 0 ile 100 arasında rastgele bir sayı

        if (kazanmaIhtimali <= 15) {
            System.out.println("Silah kazandınız!");
        } else if (kazanmaIhtimali <= 35) {
            System.out.println("Tüfek kazandınız!");
        } else if (kazanmaIhtimali <= 65) {
            System.out.println("Kılıç kazandınız!");
        } else if (kazanmaIhtimali <= 115) {
            System.out.println("Tabanca kazandınız!");
        } else if (kazanmaIhtimali <= 130) {
            System.out.println("Zırh kazandınız!");
        } else if (kazanmaIhtimali <= 150) {
            System.out.println("Ağır Zırh kazandınız!");
        } else if (kazanmaIhtimali <= 180) {
            System.out.println("Orta Zırh kazandınız!");
        } else if (kazanmaIhtimali <= 230) {
            System.out.println("Hafif Zırh kazandınız!");
        } else if (kazanmaIhtimali <= 255) {
            System.out.println("25 Para kazandınız!");
        } else if (kazanmaIhtimali <= 275) {
            System.out.println("10 Para kazandınız!");
        } else if (kazanmaIhtimali <= 305) {
            System.out.println("5 Para kazandınız!");
        } else if (kazanmaIhtimali <= 355) {
            System.out.println("1 Para kazandınız!");
        } else {
            System.out.println("Hiçbir şey kazanamadınız.");
        }
    }

    public void setObstacle(Obstacle obstacle) {

        this.obstacle = obstacle;
    }

    public String getAward() {


        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
}
