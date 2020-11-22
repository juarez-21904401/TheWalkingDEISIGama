package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class Criatura {
    int id;
    int id_tipo;
    String nome;
    int x;
    int y;
    ArrayList<Humano> humano;
    ArrayList<Zombie> zombie;

    Criatura(ArrayList<Humano> humano, ArrayList<Zombie> zombie, int y , int x, int id, int id_tipo){
        this.humano=humano;
        this.zombie=zombie;
        this.y=y;
        this.x=x;
        this.id=id;
        this.id_tipo=id_tipo;
    }
    Criatura(){}
}
