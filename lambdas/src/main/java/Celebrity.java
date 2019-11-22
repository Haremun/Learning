public class Celebrity {
    private String name;
    private boolean canSing;
    private boolean canDance;

    public Celebrity(String name, boolean canSing, boolean canDance) {
        this.name = name;
        this.canSing = canSing;
        this.canDance = canDance;
    }

    public String getName() {
        return name;
    }

    public boolean canSing() {
        return canSing;
    }

    public boolean canDance() {
        return canDance;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "name='" + name + '\'' +
                ", canSing=" + canSing +
                ", canDance=" + canDance +
                '}';
    }
}
