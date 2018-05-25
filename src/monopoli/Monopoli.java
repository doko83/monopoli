package monopoli;
import java.util.*;

public class Monopoli {
    
    private final static String  MESS_TITOLO = "Dai un nome alla partita > ";
    private final static String  MESS_TURNO = "Turno PLAYER ";
    
    private final static String  MESS_GIOCATORI = "Inserisci numero giogatori (2-6) > ";
    private final static String[]  GIOCATORI = {"A","B","C","D","E","F"};
    
    static Tabellone tabellone= null;

    public static void main(String[] args) {
       String nomePartita="";
       int numGiocatori=0;
       scriviStringa(MESS_TITOLO);
       nomePartita=leggiStringa();
       while(nomePartita.length()==0)
       {
           scriviStringa("NOME PARTITA INVALIDO!\n");
           scriviStringa(MESS_TITOLO);
           nomePartita=leggiStringa();
       }
       scriviStringa(MESS_GIOCATORI);
       numGiocatori=leggiNumero();
       while ((numGiocatori<2) || (numGiocatori>6))
       {
           scriviStringa("NUMERO GIOCATORI INVALIDO!\n");
           scriviStringa(MESS_GIOCATORI);
           numGiocatori=leggiNumero();
       }
        Tabellone tabellone=new Tabellone(nomePartita,numGiocatori);
        tabellone.initTabellone(numGiocatori);
        tabellone.stampaTabellone(numGiocatori);
        int ordine[]=ordine(numGiocatori);
        for(int round=1;round<=20;round++)
        {
            String spacer;
            if(round<10)
                spacer="#########";
            else
                spacer="########";
            System.out.println("###########################");
            System.out.println("######### TURNO "+round+" "+spacer);

            System.out.println("###########################");                   
            for(int i=0;i<numGiocatori;i++)
            {
                int numGiocatore=ordine[i];
                scriviStringa(MESS_TURNO);
                System.out.print((numGiocatore+1)+"("+GIOCATORI[numGiocatore]+") - CELLA CORRENTE: "+tabellone.trovaPosizioneAttuale(GIOCATORI[numGiocatore])+" > LANCI I DADI? ");
                String zzz=leggiStringa();
                int lancio=lanciaDado();
                System.out.println("PLAYER "+(numGiocatore+1)+"("+GIOCATORI[numGiocatore]+") muove di "+lancio);
                tabellone.aggiornaPosizione(GIOCATORI[numGiocatore], lancio);

            }
        }
        System.out.println("\nGAME OVER AMIGOS\n");
    }//fine main
    
    
    public static int[] ordine(int num)
    {
        int[] luckyArray = new Random().ints(0, num).distinct().limit(num).toArray();
        System.out.println("##########################");
        System.out.print("Ordine dei turni di gioco: ");
        for (int i=0;i<luckyArray.length;i++)
        {
            System.out.print(GIOCATORI[luckyArray[i]]+" ");
        }
        System.out.println("\n##########################\n");
        return luckyArray;
    }

    public static int lanciaDado()
    {
        Dado dado = new Dado();
        System.out.println("Primo lancio");
        int v1=dado.lanciaDado();
        System.out.println("Secondo lancio");
        int v2=dado.lanciaDado();
        return v1+v2;
    }
    
    public static void scriviStringa(String s)
    {
        System.out.print(s);
    }
    public static String leggiStringa()
    {
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            return s;          
    }
    public static int leggiNumero()
    {
            int n=0;
            Scanner input = new Scanner(System.in);
            try
            {
                n = input.nextInt();
            }
            catch(InputMismatchException e)
            {
                return 0;
            }
            
            return n;          
    }
}
