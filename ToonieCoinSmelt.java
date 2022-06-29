/**
  A concrete realization of a smelt strategy.

  @author team 'whatever'
  @version 1
  */
public class ToonieCoinSmelt implements SmeltStrategy {

    @Override
    public boolean smelt(AbstractCoin coin) {
        System.out.println("ToonieCoinSmelt: " + coin);
        return true;
    }

    @Override
    public String getSpecs() {
        return "Unknown";
    }
}

