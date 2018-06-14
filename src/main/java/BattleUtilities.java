import java.util.HashMap;
import java.util.Map;

public class BattleUtilities {

    public static boolean hitIsCritical(Vendor attackingVendor){
      return attackingVendor.getCritical() >  Math.ceil(Math.random() * 100);
    }

    public static Integer getCalculatedDamage(Vendor vendor){
        return  (int) (hitIsCritical(vendor) ? vendor.getDamage() * 2 : vendor.getDamage());
    }

    public static boolean vendorIsHit(Vendor defendingVendor){
        return defendingVendor.getDodge() >  Math.ceil(Math.random() * 100);
    }
    public static  boolean vendorCanAttack(Vendor attackingVendor){
        return attackingVendor.getAttacks() > 0;
    }

   public  static  boolean vendorIsDead(Vendor defendingVendor){
        return  defendingVendor.getHealth() <= 0;
    }

   public  static Map<String, Vendor> decideInitiative(Vendor vendorOne, Vendor vendorTwo){
       HashMap<String, Vendor> attackPriorityMap = new HashMap<String, Vendor>();

        Integer vendorOneRoll = ((int) Math.ceil(Math.random() * 6)) + vendorOne.getInitiative();
       Integer vendorTwoRoll = ((int) Math.ceil(Math.random() * 6)) + vendorTwo.getInitiative();

         if(vendorOneRoll > vendorTwoRoll){
             attackPriorityMap.put("First Attacker", vendorOne);
             attackPriorityMap.put("Second Attacker", vendorTwo);
         }
         else {
             attackPriorityMap.put("First Attacker", vendorTwo);
             attackPriorityMap.put("Second Attacker", vendorOne);
         }
         return attackPriorityMap;
    }

}
