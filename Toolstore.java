public class Toolstore extends NormalLoc {

    public Toolstore(Player player) {
        super(player, "Magaza");

    }

    @Override
    boolean onLocation() {
        boolean showMenu = true;
        System.out.println("Magazaya Hoşgeldiniz!");
        while (showMenu) {
            System.out.println("1-) Silahlar");
            System.out.println("2-) Zırhlar");
            System.out.println("3-) Çıkış Yap");
            System.out.println("Seçiminiz: ");
            int selectcase = scanner.nextInt();
            while (selectcase != 1 && selectcase != 2 && selectcase != 3) {
                System.out.print("Yanlış Bir Giriş Yaptınız. Tekrar Giriniz:  ");
                selectcase = scanner.nextInt();
            }
            switch (selectcase) {
                case 1:
                    printweapon();
                    buyWeapon();
                    break;
                case 2:
                    printarmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar Bekleriz :)");
                    showMenu = false;
                    break;
            }


        }
        return true;
    }


    public void printweapon() {
        System.out.println("------- Silahlar -------");

        for (Weapon weapon : Weapon.weapons()) {
            System.out.println( weapon.getId() +"-)"+
                    "\tSilah:" + weapon.getName() +
                    "\t\tHasar:" + weapon.getDamage() +
                    "\tPara:" + weapon.getMoney());
        }
        System.out.println("0-)Çıkış Yap");
    }

    public void buyWeapon() {
        System.out.print("Bir Silah Seçiniz: ");
        int weaponsearch = scanner.nextInt();
        System.out.println();
        while (weaponsearch != 0 && weaponsearch != 1 && weaponsearch != 2 && weaponsearch != 3) {
            System.out.print("Yanlış Bir Giriş Yaptınız. Tekrar Giriniz:  ");
            weaponsearch = scanner.nextInt();
        }
        if (weaponsearch != 0) {
            Weapon selectweapon = Weapon.getWeaponObjByID(weaponsearch);
            if (selectweapon.getMoney() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli Bakiyeniz bulunmamaktadır.");
            } else {
                //satın almanın gerçekleştiği yer
                System.out.println(selectweapon.getName() + " Silahını Satın Aldınız!");
                int balance = this.getPlayer().getMoney() - selectweapon.getMoney();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectweapon);

            }


        }
    }

    public void printarmor() {
        System.out.println("------- Zırhlar -------");

        for (Armor armor : Armor.armors()) {
            System.out.println( armor.getId() +"-)"+
                    "\tEtkisi:" + armor.getName() +
                    "\t\tEngelleme:" + armor.getBlock() +
                    "\t\tPara:" + armor.getMoney());

        }
        System.out.println("0-)Çıkış Yap");
    }

    public void buyArmor() {
        System.out.print("Bir Zırh Seçiniz: ");
        int armorsearch = scanner.nextInt();
        System.out.println();
        while (armorsearch != 0 && armorsearch != 1 && armorsearch != 2 && armorsearch != 3) {
            System.out.print("Yanlış Bir Giriş Yaptınız. Tekrar Giriniz: ");
            armorsearch = scanner.nextInt();
        }
        if (armorsearch != 0) {
            Armor selectarmor = Armor.getArmorObjByID(armorsearch);
            if (selectarmor.getMoney() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli Bakiyeniz bulunmamaktadır.");
            } else {
                //satın almanın gerçekleştiği yer
                System.out.println(selectarmor.getName() + " Zırhınızı Satın Aldınız!");
                int balance = this.getPlayer().getMoney() - selectarmor.getMoney();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectarmor);

            }
        }
    }
}
