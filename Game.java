import java.util.Scanner;

public class Game {

    public void start() {

        System.out.println("Oyunumuza Hoşgeldiniz :)");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı Adınızı Giriniz: ");
        String playername = scanner.nextLine();
        Player player = new Player(playername);
        System.out.println(player.getName() + " Macera Oyununa Hoşgeldin!");

        player.selectChar();
        Location location = null;
        while (true) {
            player.printinfo();
            System.out.println();
            System.out.println("**************** Bölgeler: **************** ");
            System.out.println();
            System.out.println("1-)Güvenli Ev --> Güvenli Bölge, Düşman Yoktur.");
            System.out.println("2-)Eşya Dükkanı --> Silah veya Zırh Satın Alabilirsiniz.");
            System.out.println("3-)Mağara --> Ödül <Yemek>, Dikkat Zombi Çıkabilir.");
            System.out.println("4-)Orman --> Ödül <Odun>, Dikkat Vampir Çıkabilir.");
            System.out.println("5-)Nehir --> Ödül <Su>, Dikkat Ayı Çıkabilir.");
            System.out.println("6-)Maden--> Ödül <Süpriz>, Dikkat Yılan Çıkabilir.");
            System.out.println("0-)Çıkış Yap --> Oyunu Sonlandır.");
            System.out.print("Lütfen Bir Bölge Seçiniz: ");
            int loc = scanner.nextInt();

            while (loc<-1 &&  loc>7 ) {
                System.out.print("Yanlış Bir Giriş Yaptınız. Bölgeyi Tekrardan Seçiniz:  ");
                loc = scanner.nextInt();
            }
            System.out.println();

            switch (loc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Toolstore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                case 6:
                    location=new Coal(player);
                    break;

            }
            if (location==null){
                System.out.println("Oyun Bitti.");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }

        }


    }

}
