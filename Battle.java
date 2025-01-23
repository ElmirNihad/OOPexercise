public abstract class Battle extends Location {
    Obstacle obstacle;
    String award;
    Battle(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;
    }

    @Override
    public boolean getLocation() {
        int obscount = obstacle.count();
        System.out.println("Su an buradasiniz : " + name);
        System.out.println("Dikkatli ol burada " + obscount + " tane " + obstacle.getName() + " var!!!");
        System.out.print("<S>avas ve ya <K>ac : ");
        String selcase = input.nextLine();
        selcase = selcase.toUpperCase();
        if(selcase.equals("S")) {
            if (combat(obscount)){
                System.out.println(name + " bolgesindeki tum dusmani temizlediniz.");
                if (this.award.equals("Food") && player.getInv().isFood() == false){
                    System.out.println("Food kazandiniz ! ");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Odun") && player.getInv().isFirewood() == false) {
                    System.out.println("Odun kazandiniz ! ");
                    player.getInv().setFirewood(true);
                } else if (this.award.equals("Su") && player.getInv().isWater() == false) {
                    System.out.println("Su kazandiniz !");
                    player.getInv().setWater(true);
                }
                return true;
            }else if(player.getHealthy() <=0) {
                System.out.println("Kaybetdiniz (:");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int count){
        for (int i = 0; i < count; i++) {
            int can = obstacle.getHeealthy();
            playerstats();
            enemyrstats();
            while (player.getHealthy() >= 0 && obstacle.getHeealthy() >= 0){
                System.out.print("<V>ur ve ya <K>ac : ");
                String sec = input.nextLine();
                sec = sec.toUpperCase();
                if (sec.equals("V")) {
                    System.out.println("Siz vurdunuz !");
                    obstacle.setHeealthy(obstacle.getHeealthy() - player.Totaldamage());
                   afterhit();
                    System.out.println();
                    if (obstacle.getHeealthy() > 0){
                        System.out.println("Canavar size vurdu !");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterhit();
                    }
                }else{
                    return false;
                }
            }
            if (obstacle.getHeealthy() <= 0 && player.getHealthy() > 0) {
                System.out.println("Canavari oldurdunuz !");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Guncel paraniz : " + player.getMoney());
                obstacle.setHeealthy(can);
            }else {
                return false;
            }
        }
        return true;
    }

    public void playerstats(){
        System.out.println("Oyuncu bilgileri\n-----------------------------");
        System.out.println("Can : " + player.getHealthy());
        System.out.println("Hasar : " + player.Totaldamage());
        System.out.println("Para : " + player.getMoney());
        if (player.getInv().getWdamage() > 0){
            System.out.println("Silah : " + player.getInv().getWname());
        }
        if ((player.getInv().getArmor() > 0)){
            System.out.println("Zirh : " + player.getInv().getAname());
        }
    }

    public void enemyrstats(){
        System.out.println("\n Dusman degerleri\n------------------------------");
        System.out.println("Can : " + obstacle.getHeealthy());
        System.out.println("Hasar : " + obstacle.getDamage());
        System.out.println("Odul : " + obstacle.getAward());
    }

    public void afterhit(){
        System.out.println("Oyuncu cani : " + player.getHealthy());
        System.out.println("Canavarin cani : " + obstacle.getHeealthy());
    }
}
