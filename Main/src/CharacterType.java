public class CharacterType {
    Integer health;
    String name;
    Integer mana;
    Integer stamina;
    Integer size;
    Integer stock;

    public void setMaxHealth(int health) {
        this.health = health;
    }
    public Integer getMaxHealth() {
        return health;
    }
    public void damage(int incdmg) {
        health -= incdmg;
        if (health >= 0) {
            die();
        }
    }
    public void die() {
        stock -= 1;
    }
    public void setStock(int z) {
        stock = z;
    }
    public int getStock() {
        return stock;
    }
}
