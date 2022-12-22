package codes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Game implements Serializable{
    private int game_Score=0; // Designe le meuileure score réaliser dans le jeu
    private String nom_joueur=""; // Designe Le nom du meuilleur joueur
    private Partie partie;//Partie de jeu
    private final String FILE_NAME = "test.dat";
    private  ArrayList<Partie> PartieList;// Une arraylist ou on sauvegarde les partie afin les sauvgarder dans un fichier
    BufferedReader br;
    private Image img;
    
    public Game() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void sauvegarde() {//Permet de sauvegarder une partie
        File f = new File(FILE_NAME);
        f.delete();
        try {
            f.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
            oos.writeObject(PartieList);
            oos.writeBoolean(img != null);
        if (img != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", oos);
        }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public int ReprendreBestscore(String nomj){
        int max=0;
        reprendre();
        for (Partie partie : PartieList){
            if ((partie.getJoueur().getScore_act()>max)&&(partie.getJoueur().getNom().equals(nomj))){
                max=partie.getJoueur().getScore_act();
            }
        }
        return max;
    }
    @SuppressWarnings("unchecked")
    public void reprendre_partie(String nompartie) {//Permet de reprendre une partie spécifier
        File f = new File(FILE_NAME);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f)))
            {
                PartieList = (ArrayList<Partie>) ois.readObject();
                for (Partie par : PartieList){
                    if (par.getNomPartie().equals(nompartie)){
                        this.partie=par;
                        break;
                    }
                }
            } catch (IOException e) {
                f.delete();
                e.printStackTrace();
            } catch (ClassNotFoundException e) {                
                e.printStackTrace();
                f.delete();
            }
        }
        else
        {
            PartieList = new ArrayList<Partie>();
        }
    }

    @SuppressWarnings("unchecked")
    public void reprendre() {//Permet de remprendre une partie deja enregistrer
        File f = new File(FILE_NAME);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f)))
            {
                PartieList = (ArrayList<Partie>) ois.readObject();
            } catch (IOException e) {
                f.delete();
                e.printStackTrace();
            } catch (ClassNotFoundException e) {                
                e.printStackTrace();
                f.delete();
            }
        }
        else
        {
            PartieList = new ArrayList<Partie>();
        }
    }

    public void quitter () throws IOException{//Permet de quitter le jeu carrément
        sauvegarde();
        if (br!=null){
            br.close();
        }
        System.exit(0);
    }
    public Boolean New_game (String nomj,String nompar) throws IOException{ // Permet de commencer le jeu
            reprendre();
            boolean existe=false;
            for (Partie prtie : PartieList){
                if (prtie.getNomPartie().equals(nompar)){existe=true;}
            }
            if(existe==false){
                Joueur j1 = new Joueur(nomj);
                this.partie = new Partie(nompar, j1);
                this.partie.getPlateau().CreatePlateau();
                PartieList.add(this.partie);
                sauvegarde();
            }
        return existe;
    }
    public void Affichage(){
        // reprendre();
        System.out.println("Nom du partie: "+this.partie.getNomPartie()+" Nom du joueur: "+this.partie.getJoueur().getNom());
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public  ArrayList<Partie> getPartieList() {
        return PartieList;
    }

    public int getGame_Score() {
        return game_Score;
    }

    public void setGame_Score(int game_Score) {
        this.game_Score = game_Score;
    }
    
    public void Game_scoreMaj(){//fonction qui permet de mettre a jour le score du jeu a battre
        for(Partie partie : PartieList){
            if (partie.getJoueur().getScore_act()>this.game_Score){
                this.game_Score=partie.getJoueur().getScore_act();
                this.nom_joueur=partie.getJoueur().getNom();
            }
        }
    }
    public int Rep_Scorejou(String nomj){//Fonction qui permet de reprendre le score de joueur
        int max=-8000;
        for (Partie part : this.PartieList){
            if (part.getJoueur().getNom().equals(nomj)){
                if(part.getJoueur().getScore_act()>max){
                    max=part.getJoueur().getScore_act();
                    part.getJoueur().setBest_score(max);
                }
            }
        }
        return max;
    }

    public String getNom_joueur() {//Permet de donner le nom joueur qui a le meilleure score
        return nom_joueur;
    }
    public void SetBestGamer(Joueur joueur){//Permet de donnez le meilleur joueur
        if (joueur.getBest_score()>this.game_Score){
            this.game_Score=joueur.getBest_score();
            this.nom_joueur=joueur.getNom();
        }
    }
    
      
}