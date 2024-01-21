public class SafeHouse extends NormalLoc {


    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
        System.out.println("Güvenli Eve Hoşgeldiniz!");
        System.out.println("Canınız Yenilenmiştir");
        this.getPlayer().setHealthy(this.getPlayer().getOrjinalHealty());

    }


    @Override
    public boolean onLocation() {
        // Tüm ödüller toplandı mı kontrolü
        if (getPlayer().getInventory().getFoodCount() == 1 && getPlayer().getInventory().getWaterCount() == 1 && getPlayer().getInventory().getFireWoodCount() == 1) {
            System.out.println("Oyunu kazandınız.");
            return false;
        } else {
            System.out.println("Oyunu kazanmak için tüm bölgelerin ödüllerini toplayıp tekrar güvenli eve dön.");
    }
        return true;
    }
}







