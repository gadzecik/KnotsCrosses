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



/* Poprawki:
    KĂłĹ‚ko nie moĹĽe nadpisaÄ‡ Xa !!
    
    
    */    
    int[] tablica = new int[]{1,2,3,4,5,6,7,8,9};
    int strzal;
    int[] tabH;
    int liczbaZnakow=0;
    /**
     * @param args the command line arguments
     */
    
    KnotsAndCrosses(){
        //Zbudujemy tablice pomocniczÄ…
            tabH = new int[9];
            for(int i=0;i<tablica.length;i++){
                if(tablica[i]>0 && tablica[i]<10){
                    tabH[i]=1;
                }else{tabH[i]=tablica[i];}
            }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        KnotsAndCrosses gra = new KnotsAndCrosses();
        gra.rysujTablice();
        
        //inna pÄ™tla!!... bo potem siÄ™ gra nie koĹ„czy
        for(int i=0;i<5;i++){
            int a = gra.whereX();
            if(gra.checkX(a) && gra.getLiczbaZnakow()<9){
                gra.wstawX(a);
                gra.incrementLiczbaZnakow();
             //   gra.czyKtosWygral();
                gra.wstawO();
                gra.incrementLiczbaZnakow();
                gra.rysujTablice();
               // gra.czyKtosWygral();
            }else if(gra.getLiczbaZnakow()==9 ){
                System.out.println("Koniec gry");
                break;
            }else{
                i--;
            //u coĹ› dopisaÄ‡.. ĹĽeby sprawdzaĹ‚, czy tablica jest peĹ‚na...!
            }
     //   gra.ktoWygral();    
           
        }
    }
    
    public void rysujTablice(){
        for(int i=0;i<9;i++){
            switch (tablica[i]) {
                case 0:
                    System.out.print("O ");
                    break;
                case 10:
                    System.out.print("X ");
                    break;
                default:
                    System.out.print(tablica[i]+ " ");
                    break;
            }
            if(i%3==2){
                System.out.print("\n");
            }
        }
    }
    
    public int getLiczbaZnakow(){
        return liczbaZnakow;
    }
    
    public void incrementLiczbaZnakow(){
        this.liczbaZnakow++;
    }
    
    public int whereX(){
        Scanner input= new Scanner(System.in);
        System.out.println("Would you mind to put X Sir?");
        strzal = input.nextInt();
        return strzal;
    }
    
    public boolean checkX(int strzal){
        return 0<strzal && strzal<10 && tabH[strzal-1]==1;       
    }
    
    public void wstawX(int strzal){
        this.tablica[strzal-1]=10;
        tabH[strzal-1]=10;
        
    }
    
    public void wstawO(){
        if(czyDwaO(tablica)){wstawKolko(5);
        }else if(czyDwaX(tablica)){wstawKolko(1);
        }else if(czyKrzyz(tablica)){wstawKolko(2);
        }else if(czyXwRogu(tablica)){wstawKolko(3);
        }else if(czySrodek(tablica)){wstawKolko(4);
        }else if(czyKrzyzO(tablica)){wstawKolko(6);
        }else if(czyOwRogu(tablica)){wstawKolko(7);
        }else if(czySrodekO(tablica)){wstawKolko(8);
        }else{wstawKolko(9);}
    }
        
    public boolean czyDwaX(int[] tab){
        
        
        if(tab.length==9){
            // Sprawdzamy, czy sÄ… dwa X w jednym wierszu;
            for(int i=0;i<9;i+=3){
                if(tab[i]*tab[i+1]*tab[i+2]>0 &&  tab[i]*tab[i+1]*tab[i+2]%100==0){
                    return true;
                }
            }            
        
            //Sprawdzamy, czy sÄ… dwa X w jednej kolumnie;        
            for(int i=0;i<3;i++){
                if(tab[i]*tab[3+i]*tab[6+i]>0 &&  tab[i]*tab[3+i]*tab[6+i]%100==0){
                    return true;
                }
            }    
        
            // Sprawdzamy, czy sÄ… dwa X na przekÄ…tnej;
            if((tab[0]*tab[4]*tab[8]>0 && tab[0]*tab[4]*tab[8]%100==0) || (tab[2]*tab[4]*tab[6]>0 && tab[2]*tab[4]*tab[6]%100==0)){
                return true;
            }
        
        }
        return false;
    }
    
    public boolean czyKrzyz(int[] tab){
        if(tab.length==9){
            
            //JeĹ›li na krzyĹĽu 25846 sÄ… dwa krzyĹĽyki w ramionach, to suma tych wyrazĂłw w tabH wynosi co najmniej 20
            return tabH[1]+tabH[3]+tabH[4]+tabH[5]+tabH[7]>20 && tabH[4]==1;
        
        }
        return false;
    }
    public boolean czyXwRogu(int[] tab){
        return tab[0]==10 || tab[2]==10 || tab[6]==10 || tab[8]==10;
    }
    public boolean czySrodek(int[] tab){
        return tab[4]==10;
        //uwaga, w tym przypadku powinien byÄ‡ tylko 1 krzyzyk na tablicy i zadnego kolka
    }
    public boolean czyDwaO(int[] tab){
        // Teraz lamiemy zasadÄ™, ĹĽeby nie powtarzaÄ‡ kodu... potem do tego wrĂłcimy
        if(tab.length==9){
            for(int i=0;i<9;i+=3){
                if(tabH[i]+tabH[i+1]+tabH[i+2]==1){
                    return true;
                }
            }            
        
            //Sprawdzamy, czy sÄ… dwa X w jednej kolumnie;        
            for(int i=0;i<3;i++){
                if(tabH[i]+tabH[3+i]+tabH[6+i]==1){
                    return true;
                }
            }    
        
            // Sprawdzamy, czy sÄ… dwa X na przekÄ…tnej;
            if(tabH[0]+tabH[4]+tabH[8]==1 || tabH[2]+tabH[4]+tabH[6]==1){
                return true;
            }
        
        }
        return false;
    }
    public boolean czyKrzyzO(int[] tab){
        return (tabH[1]+tabH[3]+tabH[5]+tabH[7]==2 || tabH[1]+tabH[3]+tabH[5]+tabH[7]==11) && tabH[4]==1;
        
    }
    public boolean czyOwRogu(int[] tab){
        return tabH[0]+tabH[2]+tabH[6]+tabH[8]<3;
    }
    public boolean czySrodekO(int[] tab){
        return tabH[4]==0;
    }
    
    public void wstawKolko(int i){
        switch(i){
            
            // Dla opcji 2 krzyzyki w linii
            case 1:
                for(int a=0;a<9;a+=3){
                    if(tablica[a]*tablica[a+1]*tablica[a+2]>0 &&  tablica[a]*tablica[a+1]*tablica[a+2]%100==0){
                        for(int b=0;b<3;b++){
                            if(tabH[a+b]==1){
                                tablica[a+b]=0;
                                tabH[a+b]=0;
                                break;
                            }
                        }
                        
                    }
                }            

                //Sprawdzamy, czy sÄ… dwa X w jednej kolumnie;        
                for(int a=0;a<3;a++){
                    if(tablica[a]*tablica[a+3]*tablica[a+6]>0 &&  tablica[a]*tablica[3+a]*tablica[6+a]%100==0){
                        for(int b=0;b<9;b+=3){
                            if(tabH[a+b]==1){
                                tablica[a+b]=0;
                                tabH[a+b]=0;
                                break;
                            }
                        }
                    }
                }    

                // Sprawdzamy, czy sÄ… dwa X na przekÄ…tnej;
                if(tablica[0]*tablica[4]*tablica[8]>0 && tablica[0]*tablica[4]*tablica[8]%100==0){
                    if(tabH[0]==1){
                        tablica[0]=0;
                        tabH[0]=0;
                        break;
                    }else if(tabH[4]==1){
                        tablica[4]=0;
                        tabH[4]=0;
                        break;
                    }else if(tabH[8]==1){
                        tablica[8]=0;
                        tabH[8]=0;
                        break;
                    }
                    
                }else if(tablica[2]*tablica[4]*tablica[6]>0 && tablica[2]*tablica[4]*tablica[6]%100==0){
                    if(tabH[2]==1){
                        tablica[2]=0;
                        tabH[2]=0;
                        break;
                    }else if(tabH[4]==1){
                        tablica[4]=0;
                        tabH[4]=0;
                        break;
                    }else if(tabH[6]==1){
                        tablica[6]=0;
                        tabH[6]=0;
                        break;
                    }
                }
                
                
                break;
                
            // Dla opcji dwa X w ramionach krzyza 13457    
            case 2:
                tablica[4]=0;
                tabH[4]=0;
                break;
                
            // Dla opcji X w rogu
            case 3:
                if(tablica[0]==10){
                    tablica[8]=0;
                    tabH[8]=0;
                }else if(tablica[2]==10){
                    tablica[6]=0;
                    tabH[6]=0;
                }else if(tablica[6]==10){
                    tablica[2]=0;
                    tabH[2]=0;
                }else if(tablica[8]==10){
                    tablica[0]=0;
                    tabH[0]=0;
                }
                break;
                
            // Dla krzyzyka na srodku    
            case 4:
                tablica[0]=0;
                tabH[0]=0;
                break;
                
                //Dla opcji dwa O
            case 5:
                // Najpierw sprawdzamy wiersze
                for(int a=0;a<9;a+=3){
                    if(tabH[a]+tabH[a+1]+tabH[a+2]==1){
                         for(int b=0;b<3;b++){
                            if(tabH[a+b]==1){
                                tablica[a+b]=0;
                                tabH[a+b]=0;
                                break;
                            }
                        }
                    }
                }
                            
        
            //Sprawdzamy, czy sÄ… dwa O w jednej kolumnie;        
            for(int a=0;a<3;a++){
                if(tabH[a]+tabH[3+a]+tabH[6+a]==1){
                    for(int b=0;b<9;b+=3){
                            if(tabH[a+b]==1){
                                tablica[a+b]=0;
                                tabH[a+b]=0;
                                break;
                            }
                        }
                    
                }
            }    
        
            // Sprawdzamy, czy sÄ… dwa O na przekÄ…tnej;
            if(tabH[0]+tabH[4]+tabH[8]==1 || tabH[2]+tabH[4]+tabH[6]==1){
                if(tabH[0]==1){
                    tablica[0]=0;
                    tabH[0]=0;
                    break;
                }else if(tabH[4]==1){
                    tablica[4]=0;
                    tabH[4]=0;
                    break;
                }else if(tabH[8]==1){
                    tablica[8]=0;
                    tabH[8]=0;
                    break;
                }
                    
            }else if(tablica[2]*tablica[4]*tablica[6]>0 && tablica[2]*tablica[4]*tablica[6]%100==0){
                if(tabH[2]==1){
                    tablica[2]=0;
                    tabH[2]=0;
                    break;
                }else if(tabH[4]==1){
                    tablica[4]=0;
                    tabH[4]=0;
                    break;
                }else if(tabH[6]==1){
                    tablica[6]=0;
                    tabH[6]=0;
                    break;
                }
            }
                
                
                break;
                
                
                               
                //Dla opcji dwa O w ramionach krzyza
            case 6:
                tablica[4]=0;
                tabH[4]=0;
                break;
                
                //Dla opcji O w rogu
            case 7:
                if(tablica[0]==0){
                    tablica[8]=0;
                    tabH[8]=0;
                }else if(tablica[2]==0){
                    tablica[6]=0;
                    tabH[6]=0;
                }else if(tablica[6]==0){
                    tablica[2]=0;
                    tabH[2]=0;
                }else {
                    tablica[0]=0;
                    tabH[0]=0;
                }
                break;
                
                //Dla opcji O na Ĺ›rodku
            case 8:
                tablica[4]=0;
                tabH[4]=0;
                break;
                
                //Wstaw O w wolne miejsce
            default:
                for(int j=0;j<9;j++){
                    if(tabH[j]==1){
                        tablica[j]=0;
                        tabH[j]=0;
                        break;
                    }
                }
        }
    
    }
   
    
}
