/**
  A concrete realization of a smelt strategy.

  @author team 'whatever'
  @version 1
  */
public class TwoPenceCoinSmelt implements SmeltStrategy {

    @Override
    public boolean smelt(AbstractCoin coin) {
        System.out.println("TwoPenceCoinSmelt: " + coin);
        return true;
    }

    @Override
    public String getSpecs() {
        return "Cu plated steel";
    }
}

