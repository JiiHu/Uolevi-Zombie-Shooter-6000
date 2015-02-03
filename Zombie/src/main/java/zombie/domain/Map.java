

package zombie.domain;

import java.util.ArrayList;

/**
 * Class contains information about the map on which actors move
 */
public class Map {
    
    private Tile[][] tiles;
    private int divider;
    private int width;
    private int height;
    
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.divider = 10;
        this.tiles = new Tile[width/divider][height/divider];
        for (int i = 0; i < (height / divider); i++) {
            for (int j = 0; j < (width / divider); j++) {
                this.tiles[j][i] = new Tile(j,i);
            }
        }
        makeNonMovableArea();
    }

    private void makeNonMovableArea() {
        int padding = 4;
        int minWidth = padding;
        int minHeight = padding;
        int maxWidth = (width / divider) - padding;
        int maxHeight = (height / divider) - padding;
        
        for (int row = 0; row < (height / divider); row++) {
            for (int col = 0; col < (width / divider); col++) {
                Tile tile = this.tiles[col][row];
                // padding around the sides which is unmovable
                if (row <= minHeight || col <= minWidth || row >= maxHeight || col >= maxWidth) {
                    tile.setWalkable(false);
                } 
                
            }
        }
    }
    
    /**
     * Method returns a piece of map on certain location
     * 
     * @param   x   locations place on X axis
     * @param   y   locations place on Y axis
     * @return Tile which is on the desired location
     */
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
    
    /**
     * Method returns Map's width in pixels
     * 
     * @return Map's width in pixels
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Method returns Map's height in pixels
     * 
     * @return Map's height in pixels
     */
    public int getHeight() {
        return height;
    }

    /**
     * Method returns the number which is used as divider to generate the map
     * <p>
     * For example, if the map is 1280 pixels wide and the divider
     * is 4, the map is made of 1280/4 = 320 horizontal Tiles
     * 
     * @return Number which is used as divider
     */
    public int getDivider() {
        return divider;
    }
    
    
    
}
