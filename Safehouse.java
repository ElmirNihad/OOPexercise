public class Safehouse extends Normalloc{

    Safehouse(Player player) {
        super(player, "Guvenli Ev" );
    }

    @Override
    public boolean getLocation() {
        player.setHealthy(player.getRhealthy());
        System.out.println("Suan Guvenli Evdesiniz ...");
        System.out.println("Iyilesdiniz !!!");
        return true;
    }
}
