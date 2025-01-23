import java.util.Scanner;

public  class Game {
    Player player;
    Location location;
    Scanner input = new Scanner(System.in);

    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Macera Oyununa Hosgeldiniz ! ");
        System.out.print("Kullanici adinizi giriniz : ");
        String playername = input.nextLine();
        player = new Player(playername);
        player.selectcha();
        start();
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("==============================================");
            System.out.println();
            System.out.println("Gitmek istediginiz yeri seciniz : ");
            System.out.println("1 - Guvenli Ev --> Guvenli bir mekan,dusman yok.");
            System.out.println("2 - Magara --> Karsiniza zombi cika bilir !!!!");
            System.out.println("3 - Orman --> Karsiniza vampir cika bilir !!!!");
            System.out.println("4 - Nehir --> Karsiniza ayi cika bilir !!!!");
            System.out.println("5 - Magaza --> Silah ve ya zirh ala bilirsiniz.");
            System.out.print("Seciminizi yapiniz : ");
            int selectoin = input.nextInt();
            if(selectoin < 1 || selectoin > 5){
                System.out.println("Gecersiz islem , lutfen tekrar seciniz ...");
                start();
            }
            switch (selectoin){
                case 1:
                    location = new Safehouse(player);
                    break;
                case 2:
                    location = new Magara(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
            }

                if (player.getInv().isFood() && player.getInv().isFirewood() && player.getInv().isWater()){
                    System.out.println("Tebrikler , oyunu kazandiniz ! ");
                    break;
                }
            if (!location.getLocation()){
                System.out.println("Oyun bitti !!!");
                break;
            }
        }
    }
}
