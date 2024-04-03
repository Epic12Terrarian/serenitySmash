import java.awt.Color;

public abstract class GameMap {
    private int[][] map = new int[800][600];
    private Color skyColor;

    public Color getColor() {
        return skyColor;
    }
    public int[][] getMap() {
        return map;
    } 
}
