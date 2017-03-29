package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;

public class MancalaTest {

    @Test
    public void inhoudIs0BijStartBeurt(){
    	SubBakje bakje = new SubBakje();
    	bakje.startBeurt();
        Assert.assertEquals(0, bakje.getInhoud());
    }
    
    @Test
    public void getBuurmanReturnEenNieuwSubBakjeObject(){
    	SubBakje bakje = new SubBakje();
    	bakje.getBuurman();
    	Assert.assertNotEquals(bakje, bakje.getBuurman());
    }
    
    @Test
    public void geefDoorZorgtVoorBuurmanPlus1(){
    	SubBakje bakje = new SubBakje();
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman().getInhoud());
    }
    
    @Test
    public void BuurmanVanBuurmanHeeftOokplus1(){
    	SubBakje bakje = new SubBakje();
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void buurman5heeft4stenenNaBeurt(){
    	SubBakje bakje = new SubBakje();
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(5).getInhoud());

    }
}
