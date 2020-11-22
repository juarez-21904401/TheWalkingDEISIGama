package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class Equipa {
    int id;
    ArrayList<Criatura> exercito= new ArrayList<>();

    Equipa(int id, ArrayList<Criatura> exercito){
        this.id=id;
        this.exercito=exercito;
    }
    Equipa(){}
}
