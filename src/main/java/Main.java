import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vendor> vendorArrayList = CSVParser.parseCSV(null);
        for(int i = 0; i < 100; i++){
            System.out.println(BattleUtilities.getCalculatedDamage( vendorArrayList.get(0)));
        }
    }
}
