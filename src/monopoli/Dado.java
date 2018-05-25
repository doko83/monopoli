package monopoli;

public class Dado {
    private final static String line1[]={"###","##O","##O","O#0","O#0","O#0"};
    private final static String line2[]={"#O#","###","#O#","###","#O#","O#0"};
    private final static String line3[]={"###","O##","O##","O#O","O#0","O#0"};
  
    public int lanciaDado()
    {
       
        int n = (int)(Math.random()*6);
        System.out.println(line1[n]);
        System.out.println(line2[n]);
        System.out.println(line3[n]);
        return n+1;
    }   
}
