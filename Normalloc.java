public abstract class Normalloc extends Location {


    Normalloc(Player player,String name) {
        super(player);
        this.name=name;
    }

    @Override
    public boolean getLocation() {
        return true;
    }
}
