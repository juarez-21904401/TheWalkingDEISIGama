package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class Humano {
    int id;
    String nome;
    String nome_equipa;
    ArrayList<Equipapamento> equipapamento;
    int x;
    int y;
    int quantidade_equipamentos;



     Humano(int id ,String nome, String nome_equipa, ArrayList<Equipapamento> equipapamento, int x, int y, int quantidade_equipamentos){
        this.id=id;
        this.nome=nome;
        this.nome_equipa=nome_equipa;
        this.equipapamento=equipapamento;
        this.x=x;
        this.y=y;
        this.quantidade_equipamentos=quantidade_equipamentos;
    }
    Humano(){}


    public int getId(){

         return id;
    }

    public String getImagePNG(){
           String nome_Zombie="Itachi.jpg";
         return nome;
    }

    public String toString(){

        // “<ID> | <Tipo> | <Nome Equipa> |
//<Nome> <Equipamentos> @ (<x>,
                //<y>)”

            return id+" | Humano | "+nome_equipa+" | "+quantidade_equipamentos+" @ ("+x+","+y+")";


    }

}
