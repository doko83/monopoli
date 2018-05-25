package monopoli;

import java.util.Vector;

public class Tabellone {
    private final static String[]  GIOCATORI = {"A","B","C","D","E","F"};
    
    private Vector<Cella> listaCelle;
    String nome;
    int giocatori;
    
    public Tabellone() {}
    public Tabellone(String pnome, int pgiocatori)
    {
        this.nome=pnome;
        this.giocatori=pgiocatori;
        listaCelle=new Vector<Cella>(); 
    }
    
    public void setInizio(int n)
    {
        Cella cella=listaCelle.get(0);
        cella.addPassanti(n);

    }
  
    public void initTabellone(int num)
    {
        
        for(int i=0; i<40;i++)
        {
            Cella cella=new Cella(i);
            listaCelle.add(cella);
        }
           setInizio(num);
    }

    public void stampaTabellone(int num)
    {
        Cella cella=null;
        for(int i=0; i<11;i++)
        {
            cella=listaCelle.get(i);
            cella.disegnaCella();
        }
        System.out.println("\n");
        int d=11;
        for(int l=39; l>=31; l--)
        {
            cella=listaCelle.get(l);
            cella.disegnaCella();
            
            for(int s=0;s<9;s++)
                    cella.spaziaCella();
          
            cella=listaCelle.get(d);
            cella.disegnaCella();  
            System.out.println("\n");
            d=d+1;
        }
        for(int l=30; l>=20; l--)
        {
            cella=listaCelle.get(l);
            cella.disegnaCella();
        }
        System.out.println("\n");
    }
    
    public int trovaPosizioneAttuale(String giocatore)
    {
        Cella cella=null;
        for(int i=0; i<listaCelle.size();i++)
        {
            cella=listaCelle.get(i);
            
            if(cella.leggiPassanti(giocatore)==giocatore)
                return cella.leggiNumero();
        }
        return 0;
    }
    
    public void aggiornaPosizione(String giocatore, int avanzamento)
    {
        int posAttuale=trovaPosizioneAttuale(giocatore);
        Cella cella=listaCelle.get(posAttuale);
        cella.rimuoviPassante(giocatore);
        int posNuova=posAttuale+avanzamento;
        if(posNuova>=39)
        {
            System.out.println("##########################################################");
            System.out.println("###### IL GIOCATORE "+giocatore+" VINCE e RIPARTE DALLA CELLA 0 ######");
            System.out.println("##########################################################");
            cella=listaCelle.get(0);
            cella.aggiornaPassante(giocatore);
        }
        else
        {
            cella=listaCelle.get(posNuova);
            cella.aggiornaPassante(giocatore);
        }
        
    }
       
}


            

