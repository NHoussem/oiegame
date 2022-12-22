package codes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.scene.image.Image;
public class Plateau implements Serializable {
    private Case tab_cases[] = new Case[100];
    private ArrayList<String> tab_imgs = new ArrayList<>();//Tableau des images utilisé dans cases images
    private ArrayList<String> corr_imgName = new ArrayList<>();//Tableau qui contient le nom d'image correcte dans chaque case image
    private ArrayList<String> corr_imgId = new ArrayList<>();//tableau qui contient l'emplacement d'image correcte dans chaque case d'image
    public Plateau(){

    }
    public void LoadTabimg() throws IOException{//Fonction qui permet de remplir le tableau des images appartir d'un dossier des iamges
        File directory= new File("src/Image2");
        File[] f = directory.listFiles();
        for (File file : f) {
            if (file != null && file.getName().toLowerCase().endsWith(".jpg") ){
                this.tab_imgs.add(file.getCanonicalPath());
                }
            }
            this.corr_imgName.add("FootBall");this.corr_imgId.add("button4");
            
            this.corr_imgName.add("Bannana");this.corr_imgId.add("button2");
            
            this.corr_imgName.add("brocoli");this.corr_imgId.add("button1");
            this.corr_imgName.add("Bus");this.corr_imgId.add("button1");
            this.corr_imgName.add("Shark" );this.corr_imgId.add("button3");
            this.corr_imgName.add("butterfly");this.corr_imgId.add("button2");
            this.corr_imgName.add("Fish");this.corr_imgId.add("button2");
            this.corr_imgName.add("Shoes");this.corr_imgId.add("button2");
            this.corr_imgName.add("Japan flag");this.corr_imgId.add("button3");
    }

    public Case[] CreatePlateau(){ // permet de remplir le plateau avec les cases demandées (1,5,5,5,5,5,73,1)(+)=100
        this.tab_cases[0]=new CaseDepart(1);
        int cpt=0,cpt2=0;
        try {
            this.LoadTabimg();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i=1; i<99; i++){
            if(i<6){this.tab_cases[i]=new CaseBonus(i+1);}
            else if(6<=i & i<11){this.tab_cases[i]=new CaseMalus(i+1);}
            else if(11<=i & i<16){this.tab_cases[i]=new CaseSaut(i+1);}
            else if(16<=i & i<21){this.tab_cases[i]=new CaseDef(i+1);}
            else if(21<=i & i<26){this.tab_cases[i]=new CaseImage(i+1);
                while(cpt<4){
                    ((CaseImage)this.tab_cases[i]).getTab_img().ImporteImg(this.tab_imgs.get(0));
                    this.tab_imgs.remove(0);
                    cpt++;
                    cpt2++;
                }
                ((CaseImage)this.tab_cases[i]).getTab_img().setMot(this.corr_imgName.get(0));
                ((CaseImage)this.tab_cases[i]).getTab_img().setCorrid(this.corr_imgId.get(0));
                this.corr_imgId.remove(0);
                this.corr_imgName.remove(0);
                cpt=0;
            }
            else {this.tab_cases[i]=new CaseParcours(i+1);}
            
        }
        this.tab_cases[99]=new CaseFin(100);
        Distrub_cases(this.tab_cases);
        return this.tab_cases;   
    }
    public void Distrub_cases(Case[] tab_case){// Permet de distruber les cases du tableau d'une façon aléatoire 
        List<Case> liste = Arrays.asList(tab_case);
		Collections.shuffle(liste);
		liste.toArray(tab_case);
        this.tab_cases=tab_case;
        CaseDepart case2= new CaseDepart(1);
        CaseFin case4= new CaseFin(100);
        Case case3;
        int cpt=0;
        for (Case cas: tab_case){
            if (cas.getClass()==case2.getClass()){
                case3=this.tab_cases[0];
                this.tab_cases[0]=cas;
                this.tab_cases[cpt]=case3;
            }
            if (cas.getClass()==case4.getClass()){
                case3=this.tab_cases[99];
                this.tab_cases[99]=cas;
                this.tab_cases[cpt]=case3;
            }
            if(cas.getClass()!=case2.getClass() & cas.getClass()!=case4.getClass()){
                this.tab_cases[cpt].setE_num_case(cpt+1);
            }
            cpt++;
        }
    }

    public void Affichage(){
        for (Case cs:tab_cases){
            System.out.println(cs.getClass());
        }
    }
    public Case getcases(int num_case) {
        return this.tab_cases[num_case];
    }
    public void NewimgTocase(CaseImage caseimg){//Fonction qui permet de changer les images dans le cas ou une case image et re parcouru
        if(this.tab_imgs.size()==0){
            try {
                LoadTabimg();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{
            caseimg.getTab_img().getTbimg().clear();
            int cpt=0;
            while(cpt<4){
                caseimg.getTab_img().ImporteImg(this.tab_imgs.get(0));
                this.tab_imgs.remove(this.tab_imgs.get(0));
                cpt++;
            }
            caseimg.getTab_img().setMot(this.corr_imgName.get(0));
            caseimg.getTab_img().setCorrid(this.corr_imgId.get(0));
            this.corr_imgId.remove(this.corr_imgId.get(0));
            this.corr_imgName.remove(this.corr_imgName.get(0));

        }
    }
    public ArrayList<String> getTab_imgs() {
        return tab_imgs;
    }
    public void setTab_imgs(ArrayList<String> tab_imgs) {
        this.tab_imgs = tab_imgs;
    }
    public void Affichtabimg(){
        for (String st:this.tab_imgs){
            System.out.println(st);
        }
    }
    public void getTab_cases() {
       for (Case cs: tab_cases){
           System.out.println(cs);
       }
    }
    
    
}
