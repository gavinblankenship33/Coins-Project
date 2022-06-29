import java.util.Random;

/**
  MintHelper

  We can't use the template pattern in Mint.java because that would make way
  too much sense.

  The methods refer to a parameter named 'self', which would be analogous to
  'this' were we able to use the template pattern.

  @author hottellbt
  @version this assignment is giving me pain edition
  */
public abstract class MintHelper {

    // failure simulation: the return value of failure
    private static final AbstractCoin NULL_COIN = NullCoin.getInstance();

    // failure simulation: the source of randomness
    // our source of chance for random failures
    private static final Random RANDOM = new Random();

    private static final String STR_OK = "OK";
    private static final String STR_FAIL = "FAILED";
    private static final String STR_SKIP = "SKIPPED";

    private static final String STR_STAGE_SMELT = "Smelting.....";
    private static final String STR_STAGE_INSPE = "Inspecting...";
    private static final String STR_STAGE_SMOOT = "Smoothing....";
    private static final String STR_STAGE_BUFFI = "Buffing......";
    private static final String STR_STAGE_IMPRI = "Imprinting...";

    /**
      makeCoin

      Mints a coin based on the given name.

      Manufacturing includes four steps:

      1. Manufacture (smelts the metal)
      2. Inspection (imperfect impressions, etc)
      3. Smoothing
      4. Buffing

      Manufacturing is unique to every country, but the other three steps are
      the same everywhere.

      @param self the mint we are using
      @param denomination the value of the coin in the local currency.
      @return a coin that has gone through the entire process.
      */
    public static AbstractCoin makeCoin(Mint self, double denomination) {
        System.out.println(self + " is minting a coin valued at "
                + denomination);

        // create base coin to be modified over time
        AbstractCoin coin = self.createBaseCoin(denomination);

        // defensive: if our subclass acts out of line and returns null, we
        // are prepared to step in here and put things back on track by
        // introducing our null object
        if (coin == null) {
            coin = NULL_COIN;
        }

        // smelting
        coin = smeltCoin(coin);

        // imprinting
        coin = imprintCoin(coin);

        // inspection
        coin = inspectCoin(coin);

        // smoothing
        coin = smoothCoin(coin);

        // buffing
        coin = buffCoin(coin);

        // end result
        return coin;
    }

    /**
      smeltCoin

      Smelts a coin.

      @param coin the coin to smelt

      @return a newly made coin object
      */
    private static  AbstractCoin smeltCoin(AbstractCoin coin) {
        System.out.println(STR_STAGE_SMELT);
        boolean success = coin.smelt();

        System.out.print("Smelt specification: ");
        System.out.println(coin.getSmeltSpecs());

        if (!success) {
            return NULL_COIN;
        }
        return coin;
    }
    
    /**
      inspectCoin
      
      Inspects a coin.

      @param coin the coin to inspect
      @return the inspected coin, or a NullCoin if the inspection failed.
      */
    private static AbstractCoin inspectCoin(AbstractCoin coin) {
        System.out.print(STR_STAGE_INSPE);
        return simulateFailure(12, coin);
    }

    /**
      polishCoin

      Polishes a coin.

      @param coin the coin to polish
      @return the polished coin, or a NullCoin if the polishing failed.
      */
    private static AbstractCoin smoothCoin(AbstractCoin coin) {
        System.out.print(STR_STAGE_SMOOT);
        return simulateFailure(1000, coin);
    }

    /**
      buffCoin

      Buffs a coin.

      @param coin the coin to buff
      @return the buffed coin, or a NullCoin if the buffing failed.
      */
    private static AbstractCoin buffCoin(AbstractCoin coin) {
        System.out.print(STR_STAGE_BUFFI);
        return simulateFailure(1000, coin);
    }
    
    /**
      imprintCoin

      Imprints a coin.

      @param coin the coin to imprint
      @return the imprinted coin, or a NullCoin if the imprinting failed.
      */
    private static AbstractCoin imprintCoin(AbstractCoin coin) {
        System.out.println(STR_STAGE_IMPRI);
        boolean success = coin.imprint();
        if (!success) {
            return NULL_COIN;
        }
        return coin;
    }

    /**
      simulateFailure

      Simulates failure as a 1/n chance.

      @param chance the value of n above
      @param coin the coin that could fail

      @return coin if things go smoothly, or NULL_COIN otherwise.
      */
    private static AbstractCoin simulateFailure(int chance, AbstractCoin coin) {

        if (coin == NULL_COIN) {
            // this coin is already ruined!
            System.out.println(STR_SKIP);
            return coin;
        }

        if (RANDOM.nextInt(chance) == 0) {
            System.out.println(STR_FAIL);
            return NULL_COIN;
        }
        else {
            System.out.println(STR_OK);
            return coin;
        }
    }

}
