/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymachine;

/**
 *
 * @author Kareem & Blake
 */
public class CPU {
    int opNum;
    int decNum[] = new int[4];
    char hexNum[] = new char[4];
    int dec;
    String hex;
    int num;
    public CPU()
    {
        
    }
    public void hexToDecimal(ToyMachine t, int a)
    {
       dec = Integer.parseInt(t.m.reg[a],16);
       
    }
    public void decToHex(ToyMachine t)
    {
        hex = Integer.toHexString(num);
    }
    public void main(String[] args)
    {
        
    }
    public void halt()
    {
       System.out.println("Sytstem stopped");
       opNum = 0; 
    }
    public void add(ToyMachine t, int destination, int a, int b)
    {
       this.hexToDecimal(t,a);
       num = dec;
       this.hexToDecimal(t, b);
       num = num + dec;
       this.decToHex(t);
       t.m.reg[destination] = hex;
       
       opNum = 1;
    }
    public void subtract(ToyMachine t, int d, int a, int b)
    {
        opNum = 2;
        this.hexToDecimal(t, a);
        num = dec;
        this.hexToDecimal(t, b);
        num = num - dec;
        this.decToHex(t);
        t.m.reg[d] = hex;
    }
    public void and(ToyMachine t, int d, int a, int b)
    {
        opNum = 3;
        if((Integer.parseInt(t.m.reg[a])) == (Integer.parseInt(t.m.reg[b])))
        {
            t.m.reg[d] = "0001";
        }
        else
        {
            t.m.reg[d] = "0000";
        }
    }
    public void xor(ToyMachine t, int d, int a, int b)
    {
        opNum = 4;
        if((Integer.parseInt(t.m.reg[a])) == (Integer.parseInt(t.m.reg[b])))
        {
           t.m.reg[a] = "0000";
        }
        else
        {
            t.m.reg[b] = "0001";
        }
    }
    public void leftShift(ToyMachine t, int a)
    {
        opNum = 5;
        this.hexToDecimal(t, a);
        num = dec;
        num = num/2;
        this.decToHex(t);
        t.m.reg[a] = hex;
    }
    public void rightShift(ToyMachine t, int a)
    {
        opNum = 6;
        this.hexToDecimal(t, a);
        num = dec;
        num = num*2;
        this.decToHex(t);
        t.m.reg[a] = hex;
        
    }
    public void loadAddr(ToyMachine t, int d)
    {
        opNum = 7;
       num = t.clock.count;
       this.decToHex(t);
       t.m.reg[d] = hex;
               
        
    }
    public void load(ToyMachine t, int d, int c)
    {
        t.m.reg[d] = t.m.mem[c];
        System.out.println(t.m.mem[c] + " memory address " + c);
        System.out.println(t.m.reg[d] + " register address " + d);
        opNum = 8;
       
    }
    public void store(ToyMachine t, int a, int d)
    {
        opNum = 9;
        t.m.mem[d] = t.m.reg[a];
                
    }
    public void loadIndirect(ToyMachine t, int a, int d)
    {
        opNum = 10;
        this.hexToDecimal(t, a);
        num = dec;
        t.m.reg[d] = t.m.mem[num];
    }
    public void storeIndirect(ToyMachine t, int a, int d)
    {
        opNum = 11;
        this.hexToDecimal(t,a);
        num = dec;
        t.m.mem[num] = t.m.reg[d];
    }
    public void branchZero(ToyMachine t, int a, int d)
    {
       opNum = 12; 
       if("0000".equals(t.m.reg[d]))
       {
           t.clock.count = a;
       }
    }
    public void branchPositive(ToyMachine t, int a, int b)
    {
        opNum = 13;
        this.hexToDecimal(t, b);
        num = dec;
        if(dec > 0)
        {
            t.clock.count = a;
        }
    }
    public void jumpReg(ToyMachine t, int a)
    {
        opNum = 14;
        this.hexToDecimal(t, a);
        num = dec;
        t.clock.count = num;
    }
    public void jumpLink(ToyMachine t, int a, int d)
    {
        opNum = 15;
        num = t.clock.count;
        this.decToHex(t);
        t.m.reg[d] = hex;
        
    }
   
   
}
