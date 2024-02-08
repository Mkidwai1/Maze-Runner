package Maze_DS;

import DataStructures.EmptyCollectionException;
import asset.AbstractMouse;
import grid.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Mouse class for the MazeRunner application.
 * @author unknown
 */
public class Mouse extends AbstractMouse {

    private ArrayListStack<Location> crumbs;

    /**
     * Default Constructor of Mouse object.
     */
    public Mouse() {
        super();
        crumbs = new ArrayListStack<>();
        crumbs.push(this.getLocation());
    }

    /**
     * Constructor used for the purposes of unit testing.
     * @param crmbs a previously existing stack of crumbs
     */
    public Mouse(ArrayListStack<Location> crmbs) {
        this.crumbs = crmbs;
        crumbs.push(this.getLocation());
    }

    /**
     * Determines which adjacent locations are empty for the mouse to traverse.
     *
     * @return a list of traversable empty locations
     */
    @Override
    protected List<Location> getEmptyLocations() {
        List<Location> emptyLocations = new ArrayList<>(4);

        // Create a list of locations adjacent to the mouse
        List<Location> adjacentLocations = getAdjacentLocations();

        // Examine each location adjacent to the mouse
        Location location;
        for (int i = 0; i < adjacentLocations.size(); i++) {
            location = adjacentLocations.get(i);

            // The location is valid if it can be traversed
            if (canTraverse(location)) {
                // If adjacent to cheese, go directly to it and find cheese
                if (seesCheeseAt(location)) {
                    moveTo(location);
                    foundCheese();
                    return emptyLocations;
                }

                /* Add the location to the empty locations list if it is not a 
                rock and has not been visited */
                if (!seesRockAt(location) && !hasVisited(location)) {
                    emptyLocations.add(location);
                }
            } else {
                /* Visited locations and rocks are considered invalid and 
                should be removed from the list of adjacent locations */
                adjacentLocations.remove(location);
            }
        }
        return emptyLocations;
    }

    /**
     * Controls the logic of how the mouse will move.
     *
     * @param emptyLocations a list of traversable empty locations
     */
    @Override
    public void move(List<Location> emptyLocations) {
    // Check if there are empty locations to move to
    if (!emptyLocations.isEmpty()) {
        // Get the current location of the mouse
        Location currentLocation = getLocation();
        
        // Push the current location to the crumbs stack
        crumbs.push(currentLocation);
        
        // Create a Random object
        Random random = new Random();
        
        // Generate a random integer in the range [0, emptyLocations.size() - 1]
        int randomIndex = random.nextInt(emptyLocations.size());
        
        // Move to a random empty location
        moveTo(emptyLocations.get(randomIndex));
    } else {
        // If there are no empty locations:
        try {
            // Pop the last visited location and save it to a variable
            Location previousLocation = crumbs.pop();
            
            // Move to the previous location
            moveTo(previousLocation);
        } catch (EmptyCollectionException ex) {
        }
    }
}


    /**
     * Determines whether the mouse has already visited this location.
     *
     * @param location the location to check
     * @return true if the mouse has visited this location
     */
    @Override
    public boolean hasVisited(Location location) {
        boolean visited = false;
        try {
            Location l = crumbs.peek();
            if (l == location) {
                visited = true;
            }
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
        }
        return visited;
    }

    /**
     * Instructs the mouse to move to the specified location.
     *
     * @param location the location to move to
     */
    @Override
    public void moveTo(Location location) {
        super.moveTo(location);
    }

    /**
     * Accessor method for crumbs field for the purposes of unit testing.
     *
     * @return the mouse's stack of crumbs
     */
    public ArrayListStack<Location> getCrumbs() {
        return crumbs;
    }

    /**
     * Generates a list of adjacent locations.
     *
     * @return the list of adjacent locations
     */
    @Override
    protected List<Location> getAdjacentLocations() {
        return super.getAdjacentLocations();
    }

    /**
     * Gets the current location of the mouse.
     *
     * @return the current location of the mouse
     */
    @Override
    public Location getLocation() {
        return super.getLocation();
    }

    /**
     * Checks whether the mouse can traverse a location.
     *
     * @param location the location to check
     * @return whether the mouse can traverse the location
     */
    @Override
    protected boolean canTraverse(Location location) {
        return super.canTraverse(location);
    }

    /**
     * Checks whether the mouse sees cheese at a location.
     *
     * @param location the location to check
     * @return whether the mouse sees cheese at the location
     */
    @Override
    protected boolean seesCheeseAt(Location location) {
        return super.seesCheeseAt(location);
    }

    /**
     * Checks whether the mouse sees a rock at a location.
     *
     * @param location the location to check
     * @return whether the mouse sees a rock at the location
     */
    @Override
    protected boolean seesRockAt(Location location) {
        return super.seesRockAt(location);
    }

    /**
     * Performed when cheese has been found by the mouse to complete the maze
     * run.
     */
    private void foundCheese() {
        super.setFoundCheese(true);
    }

}
