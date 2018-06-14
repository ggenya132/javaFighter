import java.util.HashMap;
import java.util.Map;

public class BattleManager {

    public void vendorAttacks(Vendor attackingVendor, Vendor defendingVendor){

        attackingVendor.setAttacks(attackingVendor.getAttacks()-1);

        if(BattleUtilities.vendorIsHit(defendingVendor)){
            Integer healthBeforeAttack = defendingVendor.getHealth();
            defendingVendor.setHealth(healthBeforeAttack - BattleUtilities.getCalculatedDamage(attackingVendor));

            System.out.println(LoggingUtilty.getAttackEventLog(attackingVendor,defendingVendor,healthBeforeAttack));

        } else {
            System.out.println(LoggingUtilty.getMissedAttackEventLog(attackingVendor,defendingVendor));
        }
    }


    public void runBattle(Vendor vendorOne, Vendor vendorTwo){
        Map<String, Vendor> priorityMap = BattleUtilities.decideInitiative(vendorOne,vendorTwo);
        boolean neitherVendorsAreDead = true;
            while(neitherVendorsAreDead){
                        try {
                    vendorAttacks(priorityMap.get("First Attacker"), priorityMap.get("Second Attacker"));
                    checkVitals(vendorOne, vendorTwo);
                    vendorAttacks(priorityMap.get("Second Attacker"), priorityMap.get("First Attacker"));
                } catch (BattleIsOverException battleIsOverException){
                    System.out.println("BATTLE IS OVER!");
                    neitherVendorsAreDead = false;
                }

            }

    }
    public void runRound(){

    }

    public void checkVitals(Vendor vendorOne, Vendor vendorTwo) throws BattleIsOverException{
        if((BattleUtilities.vendorIsDead(vendorOne) || BattleUtilities.vendorIsDead(vendorTwo)) || (!BattleUtilities.vendorCanAttack(vendorOne) || !BattleUtilities.vendorCanAttack(vendorTwo))){
            throw new BattleIsOverException();
        }
    }
}
