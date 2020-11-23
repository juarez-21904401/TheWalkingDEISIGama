package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class Zombie {
    int id;
    String nomeequipa;
    String nome;
    ArrayList<Equipapamento> equipapamento;
    int x;
    int y;
    int quantidadedestruidos;
    Zombie(int id,String nome_equipa,String nome, ArrayList<Equipapamento> equipapamento, int x, int y, int quantidadedestruidos){
        this.nomeequipa= nome_equipa;
        this.id=id;
        this.equipapamento=equipapamento;
        this.x=x;
        this.y=y;
        this.nome=nome;
        this.quantidadedestruidos=quantidadedestruidos;

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

        return id+" | Humano | Os Outros | "+nome+" "+quantidadedestruidos+" @ ("+x+", "+y+ ")";

    }
}
