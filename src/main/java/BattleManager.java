import java.util.HashMap;
import java.util.Map;

public class BattleManager {

    public Vendor runBattle(Vendor vendorOne, Vendor vendorTwo){
        int currentRound = 1;
        Map<String, Vendor> priorityMap = BattleUtilities.decideInitiative(vendorOne,vendorTwo);
        boolean neitherVendorsAreDead = true;
            while(neitherVendorsAreDead){
                new Round(priorityMap.get("First Attacker"), priorityMap.get("Second Attacker")).startRound(currentRound);
                if(BattleUtilities.vendorIsDead(vendorOne) || BattleUtilities.vendorIsDead(vendorTwo)){
                    neitherVendorsAreDead =false;
                    System.out.println("THE BATTLE IS OVER!");
                    return  returnLosingVendor(vendorOne,vendorTwo);
                }
                currentRound++;
                vendorOne.resetAttack();
                vendorTwo.resetAttack();
            }
        return  null;
    }

    public Vendor returnLosingVendor(Vendor vendorOne, Vendor vendorTwo){
        return  vendorOne.getHealth() <= 0? vendorOne : vendorTwo;
    }


    }

