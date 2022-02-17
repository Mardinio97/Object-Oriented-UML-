package Model;

import java.util.ArrayList;

/**
 * The type Member.
 */
public class Member {

    private final ArrayList<Boat> boatArrayList;
    private String memberID;
    private String name;
    private String personalNumber;

    /**
     * Instantiates a new Member.
     */
    public Member() {
        this.name = getName();
        this.personalNumber = getPersonalNumber();
        this.memberID = getMemberID();
        this.boatArrayList = new ArrayList<>();


    }

    /**
     * Gets member id.
     *
     * @return the member id
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * Sets member id.
     *
     * @param memberID the member id
     */
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets personal number.
     *
     * @return the personal number
     */
    public String getPersonalNumber() {
        return personalNumber;
    }

    /**
     * Sets personal number.
     *
     * @param personalNumber the personal number
     */
    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    /**
     * Gets boat array list.
     *
     * @return the boat array list
     */
    public ArrayList<Boat> getBoatArrayList() {
        return this.boatArrayList;
    }


    /**
     * Add boat.
     *
     * @param boat the boat
     */
    public void addBoat(Boat boat) {

        this.boatArrayList.add(boat);

    }

    /**
     * Check boolean.
     *
     * @param registry the registry
     * @param memID    the mem id
     * @return the boolean
     */
    public boolean check(Registry registry, String memID) {

        for (Member member : registry.getMemberArrayList()) {
            if (member.getMemberID().equalsIgnoreCase(memID)) {

                return true;
            }

        }

        return false;
    }

    /**
     * Change boat.
     *
     * @param boatID  the boat id
     * @param bType   the b type
     * @param bLength the b length
     */
    public void changeBoat(String boatID, String bType, double bLength) {
        for (Boat boat : getBoatArrayList()) {
            if (boat.getBoatID().equalsIgnoreCase(boatID)) {
                boat.setBoatSize(bLength);
                boat.setBoatType(bType);
                int index = getBoatArrayList().indexOf(boat);
                boatArrayList.set(index,boat);
            }
        }
    }

    /**
     * Check boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean checkForBoat(String id) {
        boolean control = false;
        for (Boat b : getBoatArrayList()) {
            if (b.getBoatID().equalsIgnoreCase(id)) {
                control = true;

            }
        }
        return control;
    }

}




