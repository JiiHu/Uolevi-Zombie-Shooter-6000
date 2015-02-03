

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
        this.divider = 4;
        this.tiles = new Tile[width/divider][height/divider];
        for (int i = 0; i < (height / divider); i++) {
            for (int j = 0; j < (width / divider); j++) {
                this.tiles[j][i] = new Tile(j,i);
            }
        }
        makeNonMovableArea();
    }
    
    /**
     * Method returns a piece of map on certain location
     * 
     * @param   x   locations place on X axis
     * @param   y   locations place on Y axis
     * @return tile which is on the desired location
     */
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDivider() {
        return divider;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    private void makeNonMovableArea() {
        int padding = 10;
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
    
    
    
}
