
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class UniqueVisitors {

    public static void main(String[] args) {

        // List of login names containing repeated users
        List<String> loginNames = new ArrayList<>();

        loginNames.add("mann");
        loginNames.add("rahul");
        loginNames.add("priya");
        loginNames.add("mann");
        loginNames.add("jay");
        loginNames.add("rahul");
        loginNames.add("krish");

        // HashSet stores only unique usernames
        HashSet<String> uniqueUsers = new HashSet<>(loginNames);

        // LinkedHashSet preserves first-seen order
        LinkedHashSet<String> orderedUsers =
                new LinkedHashSet<>(loginNames);

        // Display total unique visitors
        System.out.println("Total unique visitors: "
                + uniqueUsers.size());

        System.out.println("\nFirst three distinct visitors:");

        // Print the first three unique usernames
        int count = 0;

        for (String user : orderedUsers) {

            if (count == 3) {
                break;
            }

            System.out.println(user);
            count++;
        }
    }
}
