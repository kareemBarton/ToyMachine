/*
 * @T Kareem Barton * Each line should be prefixed with  * 
 */
package toymachine;

/**
 *
 * @author Kareem & Blake
 */
public class load {
        int instruction;
        int opCode;
        int destination;
        int addrA;
        int addrB;
    public void decodeOpcode(ToyMachine t, int a)
    {
       
        if(t.m.mem[a].charAt(0) == '1')
    
        {
            instruction = 1;
        }
        else if(t.m.mem[a].charAt(0) == '0')
        {
           
            instruction = 0;
        }
        else if(t.m.mem[a].charAt(0) == '2')
        {
            instruction = 2;
           
        }
        else if(t.m.mem[a].charAt(0) == '3')
        {
            instruction = 3;
        }
        else if(t.m.mem[a].charAt(0) == '4')
        {
            instruction =  4;
        }
        else if(t.m.mem[a].charAt(0) == '5')
        {
           instruction = 5;
        }
        else if(t.m.mem[a].charAt(0) == '6')
        {
            instruction = 6;
        }
        else if(t.m.mem[a].charAt(0) == '7')
        {
            instruction = 7;
        }
        else if(t.m.mem[a].charAt(0) == '8')
        {
            instruction = 8;
            
        }
        else if(t.m.mem[a].charAt(0) == '9')
        {
            instruction = 9;
        }
        else if(t.m.mem[a].charAt(0) == 'A')
        {
            instruction = 10;
        }
        else if(t.m.mem[a].charAt(0) == 'B')
        {
           instruction = 11;
        }
        else if(t.m.mem[a].charAt(0) == 'C')
        {
            instruction = 12;
        }
        else if(t.m.mem[a].charAt(0) == 'D')
        {
            instruction = 13;
        }
        else if(t.m.mem[a].charAt(0) == 'E')
        {
           instruction = 14;
        }
        else if(t.m.mem[a].charAt(0) == 'F')
        {
            instruction = 15;
        }
        else
        {
            System.out.println("help");
        }
    }
    
    public void decodeAtChar(ToyMachine t, int l)
    {
        for(int a = 1; a <= 3; a++)
        {
            int partD;
            int partA;
            int partB;
            
                if(a == 1)
                {
                    partD = getCharValue(t.m.mem[l].charAt(a)); 
                    destination = partD;
                    
                   
                }
                if(a == 2)
                {
                    partA = getCharValue(t.m.mem[l].charAt(a));
                    addrA = partA;
                   
                    
                }
                if(a == 3)
                {
                    partB = getCharValue(t.m.mem[l].charAt(a));
                    addrB = partB;
                   
                    
                }
            
        }
    }
    public int getCharValue(char a)
    {
        int b;
        if(a == '1')
        {
          b = 1;
          return(b); 
        }
        else if(a == '0')
        {
           b = 0;
           return(b);
        }
        else if(a == '2')
        {
           b = 2;
           return(b);
        }
        else if(a == '3')
        {
           b = 3;
           return(b);
        }
        else if(a == '4')
        {
           b = 4;
           return(b); 
        }
        else if(a == '5')
        {
           b = 5;
           return(b);
        }
        else if(a == '6')
        {
            b = 6;
            return(b);
        }
        else if(a == '7')
        {
            b = 7;
            return(b);
        }
        else if(a == '8')
        {
            b = 8;
            return(b);
        }
        else if(a == '9')
        {
            b = 9;
            return(b);
        }
        else if(a == 'A')
        {
            b = 10;
            return(b);
        }
        else if(a == 'B')
        {
           b = 11;
           return(b);
        }
        else if(a == 'C')
        {
            b = 12;
            return(b);
        }
        else if(a == 'D')
        {
            b = 13;
            return(b);
        }
        else if(a == 'E')
        {
            b = 14;
           return(b);
        }
        else if(a == 'F')
        {
             b = 15;
            return(b);
        }
        else
        {
            System.out.println("help");
            return(0);
        }
    }
}
