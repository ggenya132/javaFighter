public class Vendor {

    private   String name;
    private   Integer health;
    private   Integer damage;
    private   Integer attacks;
    private   Integer dodge ;
    private   Integer critical;
    private   Integer initiative ;
    private   Integer originalAttacks;

    public Vendor(String name, Integer health, Integer damage, Integer attacks, Integer dodge, Integer critical, Integer initiative) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.attacks = attacks;
        this.dodge = dodge;
        this.critical = critical;
        this.initiative = initiative;
        this.originalAttacks = attacks;
    }

    public void resetAttack(){
        attacks = originalAttacks;
    }

    public void attack(Vendor defendingVendor) throws BattleIsOverException{

        if(BattleUtilities.vendorCanAttack(this)){
            setAttacks(getAttacks()-1);

            if(BattleUtilities.vendorIsHit(defendingVendor)){
                Integer healthBeforeAttack = defendingVendor.getHealth();
                defendingVendor.takeDamage(BattleUtilities.getCalculatedDamage(this));
                System.out.println(LoggingUtilty.getAttackEventLog(this,defendingVendor,healthBeforeAttack));
            } else {
                System.out.println(LoggingUtilty.getMissedAttackEventLog(this,defendingVendor));
            }

        }


    }

    public void takeDamage(Integer damage) throws BattleIsOverException{
        setHealth(getHealth() - damage);
        if(BattleUtilities.vendorIsDead(this)){
            throw new VendorHasDiedException(getName() + " has fallen in battle.");
        }
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getAttacks() {
        return attacks;
    }

    public void setAttacks(Integer attacks) {
        this.attacks = attacks;
    }

    public Integer getDodge() {
        return dodge;
    }

    public void setDodge(Integer dodge) {
        this.dodge = dodge;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Name: " + name + "\n");
        stringBuilder.append("Health: " + health + "\n");
        stringBuilder.append("Damage: " + damage + "\n");
        stringBuilder.append("Attacks: " + attacks + "\n");
        stringBuilder.append("Dodge: " + dodge + "\n");
        stringBuilder.append("Critical: " + critical + "\n");
        stringBuilder.append("Initiative: " + initiative + "\n");

        return stringBuilder.toString();

    }
}
