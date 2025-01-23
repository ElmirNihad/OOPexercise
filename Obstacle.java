import java.util.Random;

public class Obstacle {
    private String name;
    private int damage,heealthy,award,maxnumber;

    public Obstacle(String name, int damage, int heealthy, int award, int maxnumber) {
        this.name = name;
        this.damage = damage;
        this.heealthy = heealthy;
        this.award = award;
        this.maxnumber = maxnumber;
    }

    public int count(){
        Random rand = new Random();
        return rand.nextInt(maxnumber)+1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHeealthy() {
        return heealthy;
    }

    public void setHeealthy(int heealthy) {
        this.heealthy = heealthy;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getMaxnumber() {
        return maxnumber;
    }

    public void setMaxnumber(int maxnumber) {
        this.maxnumber = maxnumber;
    }
}
