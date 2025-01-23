public class ToolStore extends Normalloc{

    ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public  boolean getLocation() {
        System.out.println("Paraniz : " + player.getMoney());
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zirhlar");
        System.out.println("3 - Cikis");
        System.out.print("Seciminiz : ");
        int setool = input.nextInt();
        int setitemid;
        switch (setool){
            case 1:
                setitemid = weaponmenu();
                buyweapon(setitemid);
                break;
            case 2:
                setitemid = armormenu();
                buyarmor(setitemid);
                break;
            case 3:
                System.out.println("Cixis yapiliyor ...");
        }
        return true;
    }

    public int weaponmenu(){
        System.out.println("1 - Tapanca \t < Para : 25  Hasar : 2 >");
        System.out.println("2 - Kilic \t < Para : 35  Hasar : 3 >");
        System.out.println("3 - Tufek \t < Para : 45  Hasar : 7 >");
        System.out.println("4 - Cixis");
        System.out.print("Seciminiz : ");
        int seweopon = input.nextInt();
        return seweopon;
    }

    public void buyweapon(int id){
        int damage =0,price = 0;
        String wname = null;
        switch (id){
            case 1:
                damage = 2;
                price = 25;
                wname = "Tapanca";
                break;
            case 2:
                damage = 3;
                price = 35;
                wname = "Kilic";
                break;
            case 3:
                damage = 7;
                price = 45;
                wname = "Tufek";
                break;
            case 4:
                System.out.println("Cixis yapiliyor...");
                break;
            default:
                System.out.println("Gecersiz islem !!!");
                break;
        }

        if(price  > 0){
            if(player.getMoney() >= price){
                player.getInv().setWdamage(damage);
                player.getInv().setWname(wname);
                player.setMoney(player.getMoney() - price);
                System.out.println(wname + " satin aldiniz , onceki hasar : " + player.getDamage() + " yeni hasariniz : " + player.Totaldamage());
                System.out.println("Kalan para : " + player.getMoney());
            }else {
                System.out.println("Yetersiz para !!!");
            }
        }
    }

    public int armormenu(){
        System.out.println("1 - Hafif \t < Para : 15  Hasar : 1 >");
        System.out.println("2 - Orta \t < Para : 25  Hasar : 3 >");
        System.out.println("3 - Agir \t < Para : 40  Hasar : 5 >");
        System.out.println("4 - Cixis");
        System.out.print("Seciminiz : ");
        int searmor = input.nextInt();
        return searmor;
    }

    public void buyarmor(int id){
        int damage =0,price = 0;
        String wname = null;
        switch (id){
            case 1:
                damage = 1;
                price = 15;
                wname = "Hafif zirh";
                break;
            case 2:
                damage = 3;
                price = 25;
                wname = "Orta zirh";
                break;
            case 3:
                damage = 5;
                price = 40;
                wname = "Agir zirh";
                break;
            case 4:
                System.out.println("Cixis yapiliyor...");
                break;
            default:
                System.out.println("Gecersiz islem !!!");
                break;
        }

        if(price  > 0){
            if(player.getMoney() >= price){
                player.getInv().setArmor(damage);
                player.getInv().setAname(wname);
                player.setMoney(player.getMoney() - price);
                System.out.println(wname + " satin aldiniz , engellenen hasar : " + damage);
                System.out.println("Kalan para : " + player.getMoney());
            }else {
                System.out.println("Yetersiz para !!!");
            }
        }
    }
}
