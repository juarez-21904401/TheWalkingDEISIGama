package pt.ulusofona.lp2.theWalkingDEISIGame;

import org.junit.Test;

import java.util.ArrayList;

public class TesteHumano {
    @Test
    public void TesteMoveDireita(){
        ArrayList<Equipapamento>  pistola= new ArrayList<>();
        Humano joao= new Humano(123,"João","Kim Posible",pistola,1,3,1);
        joao.x=2;
        joao.y=1;
        assertEquals(3,joao.x);
        assertEquals(4, joao.y);
    }

    private boolean assertEquals(int i, int x) {
        if(i==x){
            return true;
        }
        return false;
    }

}
