/**
  A concrete realization of a smelt strategy.

  @author team 'whatever'
  @version 1
  */
public class FiftyCentCoinSmelt implements SmeltStrategy {

    @Override
    public boolean smelt(AbstractCoin coin) {
        System.out.println("FiftyCentCoinSmelt: " + coin);
        return true;
    }

    @Override
    public String getSpecs() {
        return "Unknown";
    }
}

