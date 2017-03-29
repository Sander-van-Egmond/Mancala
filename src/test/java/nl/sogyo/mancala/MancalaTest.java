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
    	Assert.assertEquals(5, bakje.getBuurman(2).getInhoud());
    }
    
    @Test
    public void buurman5heeft4stenenNaBeurt(){
    	SubBakje bakje = new SubBakje();
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(5).getInhoud());
    }
    
    @Test
    public void buurman6IsKalaha(){
    	SubBakje bakje = new SubBakje();
    	bakje.startBeurt();
    	Assert.assertTrue(bakje.getBuurman(6) instanceof Kalaha);
    }
    
    @Test
    public void alsStartBeurtBij3deBakjeDanHeeftKalaha1Steen(){
    	SubBakje bakje = new SubBakje(3);
    	bakje.startBeurt();
    	Assert.assertEquals(1, bakje.getBuurman(4).getInhoud());
    }
}
