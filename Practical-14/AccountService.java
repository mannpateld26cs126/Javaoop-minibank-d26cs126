
import java.util.ArrayList;

public class AccountService {

    // ArrayList to store bank accounts
    private ArrayList<Account> accounts = new ArrayList<>();

    // Add a new account
    public void addAccount(Account account) {

        if (account == null) {
            throw new IllegalArgumentException(
                    "Account cannot be null.");
        }

        accounts.add(account);
        System.out.println("Account added successfully!");
    }

    // Return the total number of accounts
    public int getAccountCount() {
        return accounts.size();
    }

    // Display all accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (Account account : accounts) {
            account.displayAccount();
            System.out.println("--------------------");
        }
    }
}
