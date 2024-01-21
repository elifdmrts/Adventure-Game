public class Inventory {

    private Weapon weapon;
    private Armor armor;

    private boolean water;
    private int waterCount;
    private boolean food;
    private int foodCount;
    private boolean fireWood;
    private int fireWoodCount;
    private int money;









    public Inventory() {

        this.weapon = new Weapon(-1, "Yumruk", 0, 0);
        this.armor = new Armor(-1, "Paçavra", 0, 0);
        this.water = false;
        this.food = false;
        this.fireWood = false;
        this.waterCount = 0;
        this.foodCount = 0;
        this.fireWoodCount = 0;
        this.money=money;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Armor getArmor() {
        return armor;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(int waterCount) {
        this.waterCount = waterCount;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public boolean isFireWood() {
        return fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }

    public int getFireWoodCount() {
        return fireWoodCount;
    }

    public void setFireWoodCount(int fireWoodCount) {
        this.fireWoodCount = fireWoodCount;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
