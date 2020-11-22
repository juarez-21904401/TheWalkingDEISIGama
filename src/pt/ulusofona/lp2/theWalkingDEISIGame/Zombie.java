package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class Zombie {
    int id;
    String nome_equipa;
    String nome;
    ArrayList<Equipapamento> equipapamento;
    int x;
    int y;
    int quantidade_destruidos;
    Zombie(int id,String nome_equipa,String nome, ArrayList<Equipapamento> equipapamento, int x, int y, int quantidade_destruidos){
        this.nome_equipa= nome_equipa;
        this.id=id;
        this.equipapamento=equipapamento;
        this.x=x;
        this.y=y;
        this.nome=nome;
        this.quantidade_destruidos=quantidade_destruidos;

    }
    Zombie(){}

    public int getId(){

        return id;
    }

    public String getImagePNG(){
        String nome="Zombie.png";
        return  "nome";
    }

    public String toString(){

            return id+" | Humano | "+nome_equipa+" | "+nome+" | "+quantidade_destruidos+" @ ("+x+","+y+")";

    }
}
