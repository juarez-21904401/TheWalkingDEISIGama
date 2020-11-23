package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class Humano {
    int id;
    String nome;
    String nomeequipa;
    ArrayList<Equipapamento> equipapamento;
    int x;
    int y;
    int quantidadeequipamentos;



     Humano(int id ,String nome, String nomeequipa, ArrayList<Equipapamento> equipapamento, int x, int y, int quantidadeequipamentos){
        this.id=id;
        this.nome=nome;
        this.nomeequipa=nomeequipa;
        this.equipapamento=equipapamento;
        this.x=x;
        this.y=y;
        this.quantidadeequipamentos=quantidadeequipamentos;
    }
    Humano(){}


    public int getId(){

         return id;
    }

    public String getImagePNG(){
           String nomeZombie="Itachi.jpg";
         return nome;
    }

    public String toString(){

        // “<ID> | <Tipo> | <Nome Equipa> |
//<Nome> <Equipamentos> @ (<x>,
                //<y>)”

            return id+" | Humano | "+nomeequipa+" | "+nome+" | "+quantidadeequipamentos+" @ ("+x+","+y+ ")";


    }

}
