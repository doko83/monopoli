package monopoli;

import java.util.Vector;

public class Cella {
    private final static String[]  GIOCATORI = {"A","B","C","D","E","F"};
    String possessore;
    private Vector<String> listaPassanti;
    String passante;
    String colore;
    String nome;
    int numero;
    boolean speciale;
    
    public Cella() { }
    public Cella(int n)
    {
        this.numero=n;
        listaPassanti=new Vector<String>();
    }

    public void addPassanti(int n)
    {
        for(int i=0; i<n; i++)
            this.listaPassanti.add(GIOCATORI[i]);
    }
    
    public int leggiNumero()
    {
        return this.numero;
    }
    
    public String leggiPassanti(String nome)
    {
        for (int i=0; i< this.listaPassanti.size();i++)
        {
            String s=this.listaPassanti.get(i);
            if(nome==s)
                return s;
        }   
        return "";
    }
    
    public void rimuoviPassante(String nome)
    {
        for (int i=0; i< this.listaPassanti.size();i++)
        {
            String s=this.listaPassanti.get(i);
            if(nome==s)
            {
                this.listaPassanti.remove(i);
            }
        }
    }
        
    public void aggiornaPassante(String s)
    {
        this.listaPassanti.add(s);
    }
    
    public String leggiPassante()
    {
        return this.passante;
    }
    
    public void disegnaCella()
    {
        int num=this.leggiNumero();
        if (num<10)
            System.out.print("|  "+num+" |");
        else
            System.out.print("| "+num+" |");
    }
    public void posizioneCella()
    {
        String p=this.leggiPassante();
        System.out.print("| "+p+" |");
    }
     
    public void spaziaCella()
    {
        System.out.print("      ");
    }
    
 
    
}  //fineclasse
            
    

