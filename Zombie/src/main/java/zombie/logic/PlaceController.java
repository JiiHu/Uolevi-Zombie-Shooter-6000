

package zombie.logic;

import java.util.ArrayList;
import java.util.Random;
import zombie.domain.Place;

/**
 * Class is used to create places so that zombies can spawn from them
 */
public class PlaceController {
    
    private ArrayList<Place> places;
    private Random random;
    
    public PlaceController() {
        random = new Random(22);
        places = new ArrayList<Place>();
        generatePlaces();
    }

    private void generatePlaces() {
        int amount = 10;
        // values are hardcoded with the presumption
        // that the map size is 1280x720 pixels
        int[][] coordinates = { {40,50},
                                {40,400},
                                {40,650},
                                {100,40},
                                {500,40},
                                {1200,40},
                                {1230,600},
                                {1230,40},
                                {800,660},
                                {200,660}
                                };
                
        for (int i = 0; i < amount; i++) {
            int[] coords = coordinates[i];
            addPlace(coords[0], coords[1]);
        }
    }
    
    private void addPlace(int x, int y) {
        Place p = new Place(x, y);
        places.add(p);
    }
    
    /**
     * Method returns random place
     * 
     * @return random place
     */
    public Place getRandomPlace() {
        int size = places.size();
        int i = random.nextInt(size);
        return places.get(i);
    }
    
    
}
