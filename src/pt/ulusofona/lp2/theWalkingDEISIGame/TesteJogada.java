package pt.ulusofona.lp2.theWalkingDEISIGame;

import org.junit.Assert;
import org.junit.Test;

public class TesteJogada {
    TWDGameManager experienca;
    @Test
    public void  MoveDireita(){
        boolean esperado= true;

        int xO=3;
        int yO=2;
        int xD=4;
        int yD=2;
        boolean obtido= experienca.move(xO,yO,xD,yD);
        Assert.assertEquals(esperado,obtido);
    }
    public void  MoveEsquerda(){
        boolean esperado= true;

        int xO=3;
        int yO=2;
        int xD=2;
        int yD=2;
        boolean obtido= experienca.move(xO,yO,xD,yD);
        Assert.assertEquals(esperado,obtido);
    }
    public void  MoveCima(){
        boolean esperado= true;

        int xO=3;
        int yO=2;
        int xD=2;
        int yD=3;
        boolean obtido= experienca.move(xO,yO,xD,yD);
        Assert.assertEquals(esperado,obtido);
    }
    public void  MoveBaixo(){
        boolean esperado= true;

        int xO=3;
        int yO=2;
        int xD=2;
        int yD=1;
        boolean obtido= experienca.move(xO,yO,xD,yD);
        Assert.assertEquals(esperado,obtido);
    }

}
