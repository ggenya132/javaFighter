import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vendor> vendorArrayList = CSVParser.parseCSV(null);
        BattleManager battleManager = new BattleManager();
        battleManager.runBattle(vendorArrayList.get(0), vendorArrayList.get(1));
    }
}
