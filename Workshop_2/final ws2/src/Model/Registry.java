package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Registry.
 */
public class Registry {
    private final ArrayList<Member> memberArrayList;


    /**
     * Instantiates a new Registry.
     */
    public Registry() {
        memberArrayList = new ArrayList<>();

    }


    /**
     * Gets member array list.
     *
     * @return the member array list
     */
    public ArrayList<Member> getMemberArrayList() {
        return memberArrayList;

    }

    /**
     * gets member
     * @param userId
     * @return member
     */
    public Member getMember(String userId) {
        for (Member member : memberArrayList) {
            if (member.getMemberID().equals(userId)) {
                return member;
            }
        }
        throw new RuntimeException("member does not exist");
    }

    /**
     * Add member.
     *
     * @param member the member
     */
    public void addMember(Member member) {

        memberArrayList.add(member);
    }


    /**
     * Gets boats by member.
     *
     * @param name    the name
     * @param members the members
     * @param member       the m
     * @return the boats by member
     */
    public int getNumOfBoats(String name, ArrayList<Member> members, Member member) {

        int number = 0;

        for (int i = 0; i < member.getBoatArrayList().size(); i++) {
            for (int j = 0; j < members.size(); j++) {
                if (member.getBoatArrayList().get(i).getOwnerID().equals(members.get(j).getMemberID()) && name.equals(members.get(j).getName())) {
                    number += 1;

                }
            }
        }

        return number;
    }

    /**
     * Member change member info boolean.
     *
     * @param id     the id
     * @param name   the name
     * @param perNum the per num
     * @return the boolean
     */
    public boolean memberChangeMemberInfo(String id, String name, String perNum) {

        for (Member member : memberArrayList) {
            if (member.getMemberID().equalsIgnoreCase(id)) {

                member.setName(name);
                member.setPersonalNumber(perNum);
                int index = memberArrayList.indexOf(member);
                memberArrayList.set(index, member);

            }
        }
        return true;

    }

    /**
     * Check boolean.
     *
     * @param memberId the member id
     * @return the boolean
     */
    public boolean check(String memberId) {
        for (Member member : memberArrayList) {
            if (member.getMemberID().equalsIgnoreCase(memberId)) {
                return true;
            }

        }
        return false;
    }

    /**
     * Remove boat boolean.
     *
     * @param boatID the boat id
     * @return the boolean
     */
    public boolean removeBoat(String boatID) {

        for (Member member : getMemberArrayList()) {
            if (member.getBoatArrayList().removeIf(boat -> boat.getBoatID().equalsIgnoreCase(boatID))) {
                return true;


            }

        }
        return false;
    }

    /**
     * Delete member boolean.
     *
     * @param personID the person id
     * @return the boolean
     */
    public boolean deleteMember(String personID) {

        return memberArrayList.removeIf(member -> member.getMemberID().equalsIgnoreCase(personID));

    }


    /**
     * Check duplicated boolean.
     *
     * @param num the num
     * @return the boolean
     */
    public boolean checkDuplicated(int num)   {
        boolean check = false;
        FileHandler fileHandler = new FileHandler();
        String p = fileHandler.fileReaderUser();
        String[] arr = p.split("\n");
        for (String s : arr) {

            if (s.contains(String.valueOf(num))) {
                check = true;

            }


        }
        return check;
    }

    /**
     * Generate int.
     *
     * @return the int
     */
    public int generate()  {
        boolean cont = true;
        int rnd = 0;
        while (cont) {
            Random random = new Random();
            rnd = random.nextInt(900) + 100;
            if (checkDuplicated(rnd)) {
                cont = true;


                rnd = random.nextInt(900) + 100;


            } else if (!checkDuplicated(rnd)) {
                cont = false;

            }

        }

        return rnd;

    }



}



