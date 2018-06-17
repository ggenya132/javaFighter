import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TournamentManager {

    private BattleManager battleManager;

    public TournamentManager(List<Vendor> contestants) {
        this.contestants = contestants;
        this.battleManager = new BattleManager();
    }

    private  List<Vendor> contestants;

    public Vendor startTournament(){

        Collections.shuffle(contestants);
        while(fightersAreCompeting()){
            for(int indexOfCurrentFighter = 0;  indexOfCurrentFighter < contestants.size() - 1; indexOfCurrentFighter++){
             Vendor losingVendor = battleManager.runBattle(contestants.get(indexOfCurrentFighter), contestants.get(indexOfCurrentFighter + 1));
                removeLosingVendorFromTournamnent(losingVendor);
            }

        }
        System.out.println( LoggingUtilty.getTournamentWinnerEeventLog(contestants.get(0)));

        return contestants.get(0);
    }

    public void removeLosingVendorFromTournamnent(Vendor losingVendor){
        contestants.remove(losingVendor);
    }

public boolean    fightersAreCompeting(){
        return contestants.size() > 1;
}

}
