package Model;

/**
 * The type Boat.
 */
public class Boat {


    private final String ownerID;
    private String boatID;
    private double boatSize;
    private String boatType;


    /**
     * Instantiates a new Boat.
     *
     * @param ownerID  the owner id
     * @param boatSize the boat size
     * @param boatType the boat type
     */
    public Boat(String ownerID, double boatSize, String boatType) {


        this.boatSize = boatSize;
        this.boatType = boatType;
        this.ownerID = ownerID;

    }

    /**
     * Gets boat id.
     *
     * @return the boat id
     */
    public String getBoatID() {
        return boatID;
    }

    /**
     * Sets boat id.
     *
     * @param boatID the boat id
     */
    public void setBoatID(String boatID) {
        this.boatID = boatID;
    }


    /**
     * Gets boat size.
     *
     * @return the boat size
     */
    public double getBoatSize() {
        return boatSize;
    }

    /**
     * Sets boat size.
     *
     * @param boatSize the boat size
     */
    public void setBoatSize(double boatSize) {
        this.boatSize = boatSize;
    }

    /**
     * Gets boat type.
     *
     * @return the boat type
     */
    public String getBoatType() {
        return boatType;
    }

    /**
     * Sets boat type.
     *
     * @param boatType the boat type
     */
    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    /**
     * Gets owner id.
     *
     * @return the owner id
     */
    public String getOwnerID() {
        return ownerID;
    }

}
