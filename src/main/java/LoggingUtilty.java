public class LoggingUtilty {
    public static String getAttackEventLog(Vendor attackingVendor, Vendor defendingVendor, Integer defendingVendorHealthBeforeHit){
        String generatedAttackLog = attackingVendor.getName() + " hits " + defendingVendor.getName() + " for " +
                (defendingVendorHealthBeforeHit - defendingVendor.getHealth()) + " damage (" + defendingVendorHealthBeforeHit + " -> " + defendingVendor.getHealth() + ")";
        return generatedAttackLog;
    }

    public static String getMissedAttackEventLog(Vendor attackingVendor, Vendor defendingVendor){
        String generatedAttackLog = attackingVendor.getName() + "'s attack narrowly misses " + defendingVendor.getName() + ".";
        return generatedAttackLog;
    }

    public static String getRoundStartEventLog(int roundNumber){
        return "STARTING ROUND " + roundNumber + ".";

    }

    public static String getTournamentWinnerEeventLog(Vendor winningVendor){
        return  winningVendor.getName().toUpperCase() + " HAS WON THE TOURNAMENT!!!";
    }

}
