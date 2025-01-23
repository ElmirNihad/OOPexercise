import java.util.Scanner;

public class Player {
    private int damage,healthy,money,rhealthy;
    private String name,cname;
    private Inventory inv;
    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectcha(){
        switch (chamenu()){
            case 1 :
                initplayer("Samuray",5,21,15);
                break;
            case 2 :
                initplayer("Okcu",7,18,20);
                break;
            case 3 :
                initplayer("Sovalye",8,24,5);
                break;
            default:
                initplayer("Samuray",5,21,15);
                break;
        }
        System.out.println("Karakteriniz basariyla secildi !");
        System.out.println("Karakteriniz : " + getCname() + " Hasari : " + getDamage() + " Sagligi : " + getHealthy() + " Parasi : " + getMoney());
    }

    public void initplayer(String cname, int damage, int healthy, int money){
        setCname(cname);
        setDamage(damage);
        setHealthy(healthy);
        setMoney(money);
        setRhealthy(healthy);
    }

    public int chamenu(){
        System.out.println("Lutfen bir karakter seciniz : ");
        System.out.println(" \t 1 - Samuray \t Hasar : 5 \t Saglik : 21 \t Para : 15");
        System.out.println(" \t 2 - Okcu \t Hasar : 7 \t Saglik : 18 \t Para : 20");
        System.out.println(" \t 3 - Sovalye \t Hasar : 8 \t Saglik : 24 \t Para : 5");
        System.out.print("Seciminiz : ");
        int choice = input.nextInt();
        if(choice < 1 || choice > 3){
            System.out.println("Gecersiz giris , lutfen tekrar deneyin");
            chamenu();
        }
        return choice;
    }

    public int Totaldamage(){
        return getDamage() + getInv().getWdamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getRhealthy() {
        return rhealthy;
    }

    public void setRhealthy(int rhealthy) {
        this.rhealthy = rhealthy;
    }
}
