public class Round {

    private Vendor firstAttacker;
    private Vendor secondAttackor;

    public Round(Vendor firstAttacker, Vendor secondAttackor) {
        this.firstAttacker = firstAttacker;
        this.secondAttackor = secondAttackor;
    }

    public void startRound(int roundNumber){
        System.out.println(LoggingUtilty.getRoundStartEventLog(roundNumber));
        boolean roundIsActive = true;
        while (roundIsActive){
            try {
                if((firstAttacker.getAttacks() > 0) || (secondAttackor.getAttacks() > 0)){
                    firstAttacker.attack(secondAttackor);
                    secondAttackor.attack(firstAttacker);
                }
                else {
                    roundIsActive = false;
                }

            } catch (BattleIsOverException e){
                System.out.println(e.getMessage());
                roundIsActive = false;
            }

        }
    }
}
