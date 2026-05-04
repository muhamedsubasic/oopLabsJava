package CollectionsAndLambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClubMember implements Comparable<ClubMember> {
    private String name;
    private int height;

    public ClubMember(String name, int height){
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(ClubMember other){
        return Integer.compare(this.height, other.height);
    }

    @Override
    public String toString(){
        return this.name + "(" + this.height + " cm)";
    }
}

class Mainn {
    public static void main(String[] args) {
        List<ClubMember> members = new ArrayList<>();
        members.add(new ClubMember("John", 180));
        members.add(new ClubMember("Emma", 165));
        members.add(new ClubMember("Liam", 175));
        members.add(new ClubMember("Sophia", 170));

        System.out.println("Before sorting: " + members);
        Collections.sort(members);
        System.out.println("After sorting by height: " + members);

        // Binary search for height 170
        ClubMember searchKey = new ClubMember("", 170);
        int index = Collections.binarySearch(members, searchKey);
        if (index >= 0) {
            System.out.println("Found member with height 170: " + members.get(index));
        } else {
            System.out.println("Height 170 not found");
        }
    }
}
