package View;

import Model.Member;
import Model.Registry;

/**
 * The type Return info.
 */
public class ReturnInfo {


    /**
     * Show info string.
     *
     * @param registry the registry
     * @return the string
     */
    public String showInfo(Registry registry) {
        StringBuilder saveTo = new StringBuilder();


        for (int i = 0; i < registry.getMemberArrayList().size(); i++) {
            saveTo.append("ID: ").append(registry.getMemberArrayList().get(i).getMemberID()).append(System.getProperty("line.separator")).append("Name: ").
                    append(registry.getMemberArrayList().get(i).getName()).append(System.getProperty("line.separator")).append("Personal Number: ").
                    append(registry.getMemberArrayList().get(i).getPersonalNumber()).append("\n");
            saveTo.append("\n" + "------------------------------------------------------------" + "\n");


        }
        saveTo.append(System.getProperty("line.separator"));
        for (Member member : registry.getMemberArrayList()) {
            for (int i = 0; i < member.getBoatArrayList().size(); i++) {
                saveTo.append("\n");
                saveTo.append("Boat id: ").append(member.getBoatArrayList().get(i).getBoatID()).append("\n").
                        append("Size: ").append(member.getBoatArrayList().get(i).getBoatSize()).append("\n").
                        append("Type: ").append(member.getBoatArrayList().get(i).getBoatType()).append("\n");
                saveTo.append("\n" + "------------------------------------------------------------").append(System.getProperty("line.separator"));

            }

        }
        return saveTo.toString();
    }

    /**
     * Gets member details.
     *
     * @param userId   the user id
     * @param registry the registry
     * @return the member details
     */
    public String getMemberDetails(String userId, Registry registry) {
        try
        {
            var member = registry.getMember(userId);
            return "ID: " + member.getMemberID() + System.getProperty("line.separator") + "Name: " + member.getName() + System.getProperty("line.separator") + "Personal Number: " + member.getPersonalNumber();
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    /**
     * Display compact list string.
     *
     * @param registry the registry
     * @param member   the member
     * @return the string
     */
    public String displayCompactList(Registry registry, Member member) {
        StringBuilder saveTo = new StringBuilder();

        for (int i = 0; i < registry.getMemberArrayList().size(); i++) {

            saveTo.append("\n");
            saveTo.append("\nNumber of boats: ").append(registry.getNumOfBoats(registry.getMemberArrayList().get(i).getName(), registry.getMemberArrayList(), member)).
                    append(("\nID: " + registry.getMemberArrayList().get(i).getMemberID() + System.getProperty("line.separator") + "Name: " +
                            registry.getMemberArrayList().get(i).getName() + System.getProperty("line.separator")));

        }

        return saveTo.toString();
    }

    /**
     * Result.
     */
    public void result() {
        System.out.println("registration was successful");
    }
}
