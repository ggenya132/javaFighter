import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {

    private static final Integer indexOfName = 0;
    private static final Integer indexOfHealth = 1;
    private static final Integer indexOfDamage = 2;
    private static final Integer indexOfAttacks = 3;
    private static final Integer indexOfDodge = 4;
    private static final Integer indexOfCritical = 5;
    private static final Integer indexOfInitiative = 6;


    public static ArrayList<Vendor> parseCSV(String pathToResource){
        ArrayList<Vendor> vendors = new ArrayList<Vendor>();
        String csvFile = "C:\\Users\\Genya\\fighterTest\\src\\main\\resources\\VendorFighters\\vendor_fighters.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));

            //Skip first line of file
            skipFirstLineOfFile(br);

            while ((line = br.readLine()) != null) {



                String[] vendorValues = line.split(cvsSplitBy);
               String name = vendorValues[indexOfName];
               Integer health  = Integer.parseInt(vendorValues[indexOfHealth]);

                Integer damage = Integer.parseInt(vendorValues[indexOfDamage]);

                Integer attacks = Integer.parseInt(vendorValues[indexOfAttacks]);

                Integer dodge = Integer.parseInt(vendorValues[indexOfDodge]);

                Integer critical =  Integer.parseInt(vendorValues[indexOfCritical]);
                Integer initiative = Integer.parseInt(vendorValues[indexOfInitiative]);
                vendors.add(new Vendor(name,health,damage,attacks,dodge,critical,initiative));







            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(vendors);
        return vendors;
    }

    private static  void skipFirstLineOfFile(BufferedReader bufferedReader) throws IOException{
        bufferedReader.readLine();
    }
}

//to do break into helper methods
