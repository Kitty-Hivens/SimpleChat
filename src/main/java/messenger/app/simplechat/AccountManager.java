package messenger.app.simplechat;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AccountManager {

    private static final String ACCOUNT_FILE = "accounts.json";

    public List<String> loadAccounts() {
        try (FileReader reader = new FileReader(ACCOUNT_FILE)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public void saveAccounts(List<String> accounts) {
        try (FileWriter writer = new FileWriter(ACCOUNT_FILE)) {
            Gson gson = new Gson();
            gson.toJson(accounts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
