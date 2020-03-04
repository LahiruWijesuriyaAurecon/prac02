package hero;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnhancedHuman extends SuperHero {
    /* Represent the superhero's powers as a set, to eliminate duplicates
     * and because the power's order is unimportant
     */
    private Set<SuperPower> allPowers;
    private int sumOfPowers = 0;
    private boolean enhanced;

    /**
     * A superhero of the "enhanced human" variety begins life with no
     * superpowers and a mortal identity, but also has an "enhanced"
     * (super) identity, in which he/she acquires several superpowers.
     *
     * @param normalIdentity the superhero's initial, mortal identity
     * @param enhancedIdentity the superhero's "enhanced" identity,
     * when transformed
     * @param acquiredPowers the superpowers the hero acquires when in
     * his/her "enhanced" identity
     */
    public EnhancedHuman(String normalIdentity, String enhancedIdentity,
                         SuperPower[] acquiredPowers) {
        super(normalIdentity, enhancedIdentity);
        allPowers = new HashSet<SuperPower>(Arrays.asList(acquiredPowers));
        for (SuperPower power: acquiredPowers) {
            sumOfPowers += power.getValue();
        };
        enhanced = false;
    }

    @Override
    public boolean hasPower(SuperPower queriedPower) {
        return enhanced && allPowers.contains(queriedPower);
    }

    @Override
    public int totalPower() {
        return (enhanced ? sumOfPowers : 0);
    }

    @Override
    public String currentIdentity() {
        return null;
    }

    @Override
    public void switchIdentity() {
        super.switchIdentity();
        enhanced = !enhanced;
    }
}
