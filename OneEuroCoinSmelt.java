/**
  A concrete realization of a smelt strategy.

  @author team 'whatever'
  @version 1
  */
public class OneEuroCoinSmelt implements SmeltStrategy {

    @Override
    public boolean smelt(AbstractCoin coin) {
        System.out.println("OneEuroCoinSmelt: " + coin);
        return true;
    }

    @Override
    public String getSpecs() {
        return "Unknown";
    }
}

