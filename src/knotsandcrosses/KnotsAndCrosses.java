/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knotsandcrosses;

import java.util.Scanner;

/**
 *
 * @author oem
 */
public class KnotsAndCrosses {



    int shot;
    int[] tabH= new int[]{0,0,0,0,0,0,0,0,0};
    int numberOfFullFields=0;
    
    /**
     * @param args the command line arguments
     */
    
     
    public static void main(String[] args) {
        // TODO code application logic here
        KnotsAndCrosses game = new KnotsAndCrosses();
        boolean gameOver = false;
        
        game.drawTab();
        
        while(gameOver==false){
            //int a = game.wherePutO();
            //if(game.checkIfEmpty(a) && game.getNumberOfFullFields()<9){
            game.shooting();
            game.putX(game.getShot());
            game.setNumberOfFullFields(game.getNumberOfFullFields()+1);
                     //   game.czyKtosWygamel();
            //game.wherePutO();
            if(game.getNumberOfFullFields()>=9){
                break;
            }
            game.putO(game.wherePutO());
            game.setNumberOfFullFields(game.getNumberOfFullFields()+1);
            game.drawTab();
            System.out.println("number of full fields: " + game.getNumberOfFullFields());
               // game.czyKtosWygamel();
            if(game.getNumberOfFullFields()>=9){
                gameOver=true;
            }
            //Another condition to check if the game is finished.
        }
        System.out.println("Game Over");
        game.whoWon();          
        game.drawTab();
    }   
    // some silly comment
    public void drawTab(){
        for(int i=0;i<9;i++){
            switch (tabH[i]) {
                case -1:
                    System.out.print("O ");
                    break;
                case 1:
                    System.out.print("X ");
                    break;
                default:
                    System.out.print(i+1 + " ");
                    break;
            }
            if(i%3==2){
                System.out.print("\n");
            }
        }
    }
    
    public void whoWon(){
        if(ThreeXInLine()){
            System.out.println("Congratulations! You won!!!");
        }else if(ThreeOInLine()){
            System.out.println("I'm sorry, you lost ;(");
        }else{
            System.out.println("It's a draw!");
        }
    }
    
    public int getNumberOfFullFields(){
        return numberOfFullFields;
    }
    
    public void setNumberOfFullFields(int num){
        this.numberOfFullFields=num;
    }
    
    public int getShot(){
        return shot;
    }
    
    public void putShot(int shot){
        this.shot=shot;
    }
    
    public void incrementNumberOfFullFields(){
        this.numberOfFullFields++;
    }
    
    public void shooting(){
        Scanner input= new Scanner(System.in);
        this.shot=0;
        while(this.getNumberOfFullFields()<9 && checkIfEmpty(this.shot)==false){
            System.out.println("Would you mind to put X Sir?");
            this.shot = input.nextInt();
        }
     //   return shot;
        System.out.println("You chose to put X in field "+ this.shot);    
    }
    
  /*  public int whereX(){
        Scanner input= new Scanner(System.in);
        System.out.println("Would you mind to put X Sir?");
        shot = input.nextInt();
        return shot;
    } */
    
    // Check if the space is empty.
    public boolean checkIfEmpty(int shot){
        return 0<shot && shot<10 && tabH[shot-1]==0;       
    }
    
    public void putX(int shot){
        this.tabH[shot-1]=1;
       // tabH[shot-1]=10;
        
    }
    
    public void putO(int place){
        this.tabH[place]=-1;
       // tabH[shot-1]=10;
        
    }
    
    public int wherePutO(){
        if(oneXInCorner()){return wherePutO(6);
        }else if(TwoOInLine()){return wherePutO(5);
        }else if(TwoXInLine() && tabH[wherePutO(1)]==0){return wherePutO(1);
        }else if(xOnCross() && tabH[wherePutO(2)]==0){return wherePutO(2);
        }else if(xInCorner() && tabH[wherePutO(3)]==0){return wherePutO(3);
        }else if(xInMiddle() && tabH[wherePutO(9)]==0){return wherePutO(9);
        }else if(oOnCross() && tabH[wherePutO(6)]==0){return wherePutO(6);
        }else if(oInCorner() && tabH[wherePutO(7)]==0){return wherePutO(7);
        }else if(oInMiddle() && tabH[wherePutO(9)]==0){return wherePutO(9);
        }else{return wherePutO(9);}
    }
    

    public boolean oneXInCorner(){
        return this.getNumberOfFullFields()==1 && (tabH[0]==1 || tabH[2]==1 || tabH[6]==1 || tabH[8]==1);
    }
    public boolean TwoXInLine(){
        
        
        //Two X in one row
        for(int i=0;i<9;i+=3){
            if(tabH[i]+tabH[i+1]+tabH[i+2]==2){
                return true;
            }
        }            

        //two X in one columne        
        for(int i=0;i<3;i++){
            if(tabH[i]+tabH[3+i]+tabH[6+i]==2){
                return true;
            }
        }
        
        //two X in diagonal
        return tabH[0]+tabH[4]+tabH[8]==2 || tabH[2]+tabH[4]+tabH[6]==2;
    }
    
    public boolean xOnCross(){
               
        //If there are two X-es in the middle cross 25846 (arms)
        return tabH[1]+tabH[3]+tabH[5]+tabH[7]>=2 && tabH[4]==0;
    }
    public boolean xInCorner(){
        return tabH[0]==1 || tabH[2]==1 || tabH[6]==1 || tabH[8]==1;
    }
    public boolean xInMiddle(){
        return tabH[4]==1;
        //In this case, there should be just one X in the tabH, and no circles.
    }
    public boolean TwoOInLine(){
        
        //Two O in one row
        for(int i=0;i<9;i+=3){
            if(tabH[i]+tabH[i+1]+tabH[i+2]==-2){
                return true;
            }
        }            

        //two X in one columne        
        for(int i=0;i<3;i++){
            if(tabH[i]+tabH[3+i]+tabH[6+i]==-2){
                return true;
            }
        }
        
        //two O in diagonal
        return tabH[0]+tabH[4]+tabH[8]==-2 || tabH[2]+tabH[4]+tabH[6]==-2;
    }
    public boolean oOnCross(){
        return tabH[1]+tabH[3]+tabH[5]+tabH[7]<=-2 && tabH[4]==0;    
    }
    public boolean oInCorner(){
        return tabH[0]==-1 || tabH[2]==-1 || tabH[6]==-1 || tabH[8]==-1;
    }
    public boolean oInMiddle(){
        return tabH[4]==-1;
    }
    
    public int wherePutO(int i){
        switch(i){
            
            // For two X in row
            case 1:
                for(int a=0;a<9;a+=3){
                    if(tabH[a]+tabH[a+1]+tabH[a+2]==2){
                        for(int b=0;b<3;b++){
                            if(tabH[a+b]==0){
                                return a+b;
                            }
                        }    
                    }
                }            

                //For two X in column 
                for(int a=0;a<3;a++){
                    if(tabH[a]+tabH[a+3]+tabH[a+6]==2){
                        for(int b=0;b<9;b+=3){
                            if(tabH[a+b]==0){
                                return a+b;
                            }
                        }
                    }
                }
                

                // Sprawdzamy, if there are two X-es at a diagonal
                
                if(tabH[0]+tabH[4]+tabH[8]==2){
                    if(tabH[0]==0){
                        return 0;
                    }else if(tabH[4]==0){
                        return 4;
                    }else if(tabH[8]==0){
                        return 8;
                    }

                }else if(tabH[2]+tabH[4]+tabH[6]==2){
                    if(tabH[2]==0){
                        return 2;
                    }else if(tabH[4]==0){
                        return 4;
                    }else if(tabH[6]==0){
                        return 6;
                    }
                }


                
            // Case - two X in arms of the cross 13457   
            case 2:
                return 4;
                
            // X in a corner
            case 3:
                if(tabH[0]==1){
                    return 8;
                }else if(tabH[2]==1){
                    return 6;
                }else if(tabH[6]==1){
                    return 2;
                }else if(tabH[8]==1){
                    return 0;
                }
                
            // X in middle    
            case 4:
                return 0;
                
                //two O in line
            case 5:
                // two O in row
                for(int a=0;a<9;a+=3){
                    if(tabH[a]+tabH[a+1]+tabH[a+2]==-2){
                         for(int b=0;b<3;b++){
                            if(tabH[a+b]==0){
                                return a+b;
                            }
                        }
                    }
                }
                            
        
                //two O in column       
                for(int a=0;a<3;a++){
                    if(tabH[a]+tabH[3+a]+tabH[6+a]==-2){
                        for(int b=0;b<9;b+=3){
                                if(tabH[a+b]==0){
                                    return a+b;
                                }
                            }

                    }
                }    
        
                // two O in diagonal
                if(tabH[0]+tabH[4]+tabH[8]==-2){
                    if(tabH[0]==0){
                        return 0;
                    }else if(tabH[4]==0){
                        return 4;
                    }else if(tabH[8]==0){
                        return 8;
                    }

                }else if(tabH[2]+tabH[4]+tabH[6]==-2){
                    if(tabH[2]==0){
                        return 2;
                    }else if(tabH[4]==0){
                        return 4;
                    }else if(tabH[6]==0){
                        return 6;
                    }
                }

               
                
                
                               
                //two O in the cross 13457 
            case 6:
                return 4;
                
                //O in corner
            case 7:
                if(tabH[0]==-1){
                    return 8;
                }else if(tabH[2]==-1){
                    return 6;
                }else if(tabH[6]==-1){
                    return 2;
                }else {
                    return 0;
                }
               
                //O in middle
            case 8:
                return 0;
                
                //Put O wherever
            default:
                for(int j=0;j<8;j++){
                    if(tabH[j]==0){
                        return j;
                    }
                }
                return 8;
        }
    //return 8;
    }
   
    
    public boolean ThreeXInLine(){
        
        
        //Three X in one row
        for(int i=0;i<9;i+=3){
            if(tabH[i]+tabH[i+1]+tabH[i+2]==3){
                return true;
            }
        }            

        //three X in one columne        
        for(int i=0;i<3;i++){
            if(tabH[i]+tabH[3+i]+tabH[6+i]==3){
                return true;
            }
            
        }
        
        //three X in diagonal
        
        return tabH[0]+tabH[4]+tabH[8]==3 || tabH[2]+tabH[4]+tabH[6]==3;
    }
    
    
    public boolean ThreeOInLine(){
        
        
        //Three X in one row
        for(int i=0;i<9;i+=3){
            if(tabH[i]+tabH[i+1]+tabH[i+2]==-3){
                return true;
            }
        }            

        //three X in one columne        
        for(int i=0;i<3;i++){
            if(tabH[i]+tabH[3+i]+tabH[6+i]==-3){
                return true;
            }
            
        }
        
        //three X in diagonal
        
        return tabH[0]+tabH[4]+tabH[8]==-3 || tabH[2]+tabH[4]+tabH[6]==-3;
    }
    
}
