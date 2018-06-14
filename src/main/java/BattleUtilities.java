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
    boolean vendorCanAttack(Vendor attackingVendor){
        return attackingVendor.getAttacks() > 0;
    }
}
