package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TWDGameManager {

       public TWDGameManager(){}

        int turno;
       int inicial=0;
       ArrayList<Humano> todosHumanos= new ArrayList<>();
       ArrayList<Zombie> todosZombies= new ArrayList<>();
       ArrayList<Criatura> todasCriaturas=new ArrayList<>();
       ArrayList<Equipapamento> todosEquipamentos= new ArrayList<>();
       Criatura freddy= new Criatura();
       Equipapamento armas = new Equipapamento();

       int linha1 = 0;
       int coluna = 0;
       int [][]matriz= new int [linha1][coluna];

       //Feitoo
    public boolean startGame(File ficheiroInicial) {

        try {
            Scanner leitorFicheiro = new Scanner(new
                    FileInputStream(ficheiroInicial));
            // enquanto o ficheiro tiver linhas não-lidas
            while (leitorFicheiro.hasNextLine()) {
                Equipa equipa1 = new Equipa();
                // ler uma linha do ficheiro
                String linha = leitorFicheiro.nextLine();
                // partir a linha no caractere separador
                if (linha.contains(" : ")) {
                    String dados[] = linha.split(" : ");
                    if (dados.length == 5) {
                       // Criatura Freddy = new Criatura();
                        freddy.id = Integer.parseInt(dados[0]);
                        freddy.idtipo = Integer.parseInt(dados[1]);
                        freddy.nome = dados[2];
                        freddy.x = Integer.parseInt(dados[3]);
                        freddy.y = Integer.parseInt(dados[4]);
                        todasCriaturas.add(freddy);
                        if(Integer.parseInt(dados[0])==1){
                            Humano Mreddy= new Humano();
                            Mreddy.nome= freddy.nome;
                            Mreddy.x= freddy.x;
                            Mreddy.y= freddy.y;
                            Mreddy.id= freddy.id;
                            todosHumanos.add(Mreddy);
                        }
                        if(Integer.parseInt(dados[0])==0){
                            Zombie paciente= new Zombie();
                            paciente.y= freddy.y;
                            paciente.x= freddy.x;
                            paciente.nome= freddy.nome;
                            paciente.id=freddy.id;
                            todosZombies.add(paciente);
                        }

                    }
                    if (dados.length == 4) {
                        armas.id = Integer.parseInt(dados[0]);
                        armas.idtipo = Integer.parseInt(dados[1]);
                        armas.x = Integer.parseInt(dados[2]);
                        armas.y = Integer.parseInt(dados[3]);
                        todosEquipamentos.add(armas);
                    }
                } else {
                    int count = 0;
                    String dados[] = linha.split(" ");
                    if (dados.length == 2) {
                        coluna = Integer.parseInt(dados[0]);
                        linha1   = Integer.parseInt(dados[1]);

                    }
                    if (dados.length == 1) {
                        if (Integer.parseInt(dados[0]) == 1 || Integer.parseInt(dados[0]) == 0) {
                            equipa1.id = Integer.parseInt(dados[0]);
                            inicial=Integer.parseInt(dados[0]);
                        }

                        if (Integer.parseInt(dados[0]) > 1 && count == 1) {
                            ///Quantidade de equipamentos
                            for (int i = 0; i < Integer.parseInt(dados[0]); i++) {
                                Equipapamento faca = new Equipapamento();
                            }

                            if (Integer.parseInt(dados[0]) > 1 && count == 0) {
                                //Quanridade de Criaturas
                                for (int i = 0; i < Integer.parseInt(dados[0]); i++) {
                                    Criatura jose = new Criatura();
                                }
                                count++;
                            }
                        }
                    }
                }
            }
            leitorFicheiro.close();
            return true;
        } catch (FileNotFoundException exception) {
            return false;
        }
    }


    //Feito
    public int[] getWorldSize(){
        int valor[] = new int[2];
        valor[0]=linha1;
        valor[1]=coluna;
          return valor;
    }

    //Feito
    public int getInitialTeam(){
    return inicial;
    }

    //Feito
    public List<Humano> getHumans(){
        return todosHumanos;
    }

    //Feito
    public List<Zombie> getZombies(){
        return todosZombies;
    }

  ///Quase Feito
    public boolean move(int xO, int yO, int xD, int yD){

          if(turno < 6 ){
              if(xO >= 0 && yO >= 0 && xD <= 5 & yO <=5){
                  if(xD >= 0 && yD >= 0 && xO <= 5 & yO <=5){
                      //Caso seja um humano
                      for(int i=0; i < todosHumanos.size();i++){
                          if(todosHumanos.get(i).x==xO && todosHumanos.get(i).y==yO){
                              //Caso tenha um equipamento na posicao
                              if(todosHumanos.get(i).equipapamento.size()==0) {
                                  for (int k = 0; k < todosEquipamentos.size(); k++) {
                                      if (todosEquipamentos.get(k).y == yD && todosEquipamentos.get(k).x == xD) {
                                          todosHumanos.get(i).equipapamento.add(armas);
                                          todosHumanos.get(i).y = yD;
                                          todosHumanos.get(i).x = xD;
                                          turno++;
                                          todosHumanos.get(i).quantidadeequipamentos++;
                                          return true;
                                      }
                                  }
                              }
                                      //Caso ele ja tenha um equipamento
                                      if(todosHumanos.get(i).equipapamento.size()>0){
                                          for(int j=0; j < todosEquipamentos.size(); j++){
                                              if(todosEquipamentos.get(j).y==yD && todosEquipamentos.get(j).x==xD){
                                                  todosHumanos.get(i).equipapamento.remove(armas.y==yO && armas.x==xO);
                                                  todosHumanos.get(i).equipapamento.add(armas);
                                                  todosHumanos.get(i).y=yD;
                                                  todosHumanos.get(i).x=xD;
                                                  turno++;
                                                  todosHumanos.get(i).quantidadeequipamentos++;
                                                  return true;
                                              }

                                              //Caso não tenha  equipamento na posicao em que ele vai
                                              if(todosEquipamentos.get(j).y!=yD || todosEquipamentos.get(j).x!=xD){
                                                  todosHumanos.get(i).y=yD;
                                                  todosHumanos.get(i).x=xD;
                                                  turno++;
                                                  todosHumanos.get(i).quantidadeequipamentos++;
                                                  return true;
                                              }
                                             }
                                          }
                                  }
                              }

                      //Caso seja um Zombie
                      for(int i=0; i < todosZombies.size();i++){
                          if(todosZombies.get(i).x==xO && todosZombies.get(i).y==yO){
                              for(int j=0; j < todosEquipamentos.size(); j++){
                                  //Caso tenha um equipamento na posicao
                                  if(todosEquipamentos.get(j).x==xD && todosEquipamentos.get(j).y==yD){
                                      todosEquipamentos.remove(armas.x==xD && armas.y==yD);
                                      todosZombies.get(i).x=xD;
                                      todosZombies.get(i).y=yD;
                                      turno++;
                                      todosZombies.get(i).quantidadedestruidos++;
                                      return true;
                                  }
                                  //Caso não tenha um equipamento na posicao
                                  if(todosEquipamentos.get(j).x!=xD || todosEquipamentos.get(j).y!=yD){
                                      todosZombies.get(i).x=xD;
                                      todosZombies.get(i).y=yD;
                                      turno++;
                                      todosZombies.get(i).quantidadedestruidos++;
                                      return true;
                                  }
                              }


                          }
                      }
                 /*
                   for(int i=0; i < todosHumanos.size(); i++){
                       if(todosHumanos.get(i).y==yD && todosHumanos.get(i).x==xD ){
                           return  false;
                       }
                       if(todosZombies.get(i).y==yD && todosZombies.get(i).x==xD ){
                           return  false;
                       }
                       if(todosHumanos.get(i).y!=yD && todosHumanos.get(i).x!=xD ){
                           return  true;
                       }
                       if(todosZombies.get(i).y!=yD && todosZombies.get(i).x!=xD ){
                           return  true;
                       }
                   }
                  */
                  }
                  return false;
              }
              return false;
          }
          return false;
    }

    //FEITO
    public boolean gameIsOver(){
       if(turno==6){
           return true;
       }
        return false;
    }

    //FEITO///
    public List<String> getAuthors(){


           String nome= "Joao";
        ArrayList<String>ihoi= new ArrayList<>();
        ihoi.add(nome);

        return ihoi;
    }


    public int getCurrentTeamId(){

           return 1;
    }
    //Feito!!
    public int getElementId(int x, int y){
     for(int i=0; i < todosZombies.size();i++){
            if(todosZombies.get(i).x==x && todosZombies.get(i).y==y){
            return todosZombies.get(i).getId();
             }
     }
        for(int i=0; i < todosHumanos.size();i++){
            if(todosHumanos.get(i).x==x && todosHumanos.get(i).y==y){
                return todosHumanos.get(i).getId();
            }
        }
         return 0;
    }

    //Mal Feito
    public List<String> getSurvivors(){
        ArrayList<String>Sobreviventes= new ArrayList<>();
        String vivo;
        String morto;
        String turno1;
       /*
        for(int i=0; i < todasCriaturas.size(); i++){
            nome=""+todasCriaturas.get(i).id+" "+todosHumanos.get(i).nome;

        }
       */
        turno1=""+turno;
        Sobreviventes.add(turno1);
        for(int i=0; i < todosHumanos.size(); i++){
            vivo=""+todosHumanos.get(i).id+" "+todosHumanos.get(i).nome;
            Sobreviventes.add(vivo);
        }
        for(int i=0; i < todosZombies.size(); i++){
            morto=""+todosZombies.get(i).id+" "+todosZombies.get(i).nome;
            Sobreviventes.add(morto);

        }
      return Sobreviventes;


    }

    //Feito
    public boolean isDay() {
        if (turno % 2 == 0) {
            return true;
        }
        return false;
    }
    //Feito
    public boolean hasEquipment(int creatureId, int equipmentTypeId){
        for(int i=0; i< todasCriaturas.size(); i++){
            //Percorrer as criaturas e verificar se o id delas é = ao creatureId
            if(todasCriaturas.get(i).id== creatureId){
                //Ver qual é o tipo da Criatura
                if(todasCriaturas.get(i).idtipo==0){
                    //depois ver a lista de zombies qual é o Zombie com o mesmo id da criatura
                   for(int j=0; j < todosZombies.size();i++){
                       if(todosZombies.get(j).id==todasCriaturas.get(i).id){
                           //Percorrer a lista de equipamentos
                           for(int k=0; k < todosEquipamentos.size(); k++){
                               //Ver o Zombie que tem o id type do equipamento = ao quipmentTypeId
                               if(todosZombies.get(j).equipapamento.get(k).idtipo==equipmentTypeId){
                                   return true;
                               }
                           }
                       }
                    }
                }
                if(todasCriaturas.get(i).idtipo==1){
                    //depois ver a lista de Humanos qual é o Zombie com o mesmo id da criatura
                    for(int j=0; j < todosHumanos.size();i++){
                        if(todosHumanos.get(j).id==todasCriaturas.get(i).id){
                            //Percorrer a lista de equipamentos
                            for(int k=0; k < todosEquipamentos.size(); k++){
                                //Ver o Humanos que tem o id type do equipamento = ao quipmentTypeId
                                if(todosHumanos.get(j).equipapamento.get(k).idtipo==equipmentTypeId){
                                    return true;
                                }
                            }
                        }
                    }
                }


            }
        }
           return false;
    }
}
