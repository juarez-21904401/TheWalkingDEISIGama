package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class Criatura {
    int id;
    int idtipo;
    String nome;
    int x;
    int y;
    ArrayList<Humano> humano;
    ArrayList<Zombie> zombie;

    Criatura(ArrayList<Humano> humano, ArrayList<Zombie> zombie, int y , int x, int id, int idtipo){
        this.humano=humano;
        this.zombie=zombie;
        this.y=y;
        this.x=x;
        this.id=id;
        this.idtipo=idtipo;
    }
    Criatura(){}
}
