


package toymachine;

/**
 *
 * @author Kareem
 */
public class ToyMachine implements Runnable
{

    /**
     * @param args the command line arguments
     */
    String program[];
    public Memory m;
    public load loading;
    int instruction;
    int opCode;
    int destination;
    int addrA;
    int addrB;
    PC clock;
    CPU c;
    Boolean run = true;
    int n;
    int nb;
    ToyMachineGui gui;
    changeProgram change;

    /**
     *
     */
    public ToyMachine()
     {
       program = new String[16];
       program[0] = "0000";
       program[1] = "0000";
       program[2] = "0000";
       program[3] = "0000";
       program[4] = "0000";
       program[5] = "0000";
       program[6] = "0000";
       program[7] = "0000";
       program[8] = "0000";
       program[9] = "0000";
       program[10] = "0000";
       program[11] = "0000";
       program[12] = "0000";
       program[13] = "0000";
       program[14] = "0000";
       program[15] = "0000";
         
         
     }

    /**
     *
     */
    @Override
     public void run()
     {
       gui = new ToyMachineGui(this);
       gui.setVisible(true);
       this.runn();
     }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
    ToyMachine r = new ToyMachine();
    
    javax.swing.SwingUtilities.invokeLater(r);
   }

    /**
     *
     */
    public void runn()
      {

        this.resetMem();
        this.resetReg();
        this.StartCpu();
        this.startClock();
        this.loadProgram();
       

      }

    /**
     *
     */
    public void call()
    {
        this.getInstrction();
        this.executeInstruction();
        this.clock.incrementClock();
    }

    /**
     *
     */
    public void resetMem()
    {
        m = new Memory();
        int a;

        for(a = 0; a < 272; a++)
        {

                m.mem[a] = "0000";
                System.out.println(m.mem[a]);
           System.out.println("set" + a);
        }
        System.out.println("Finished with Memory clear");

    }

    /**
     *
     */
    public void resetReg()
    {
        int a;
        for(a = 0; a < 16; a++)
        {
          m.reg[a] = "0000";
          System.out.println(m.reg[a]);
        }
        System.out.println("Finished with Register clear");
    }

    /**
     *
     */
    public void StartCpu()
    {
        c = new CPU();
    }

    /**
     *
     */
    public void startClock()
    {
        clock = new PC();

    }

    /**
     *
     */
    public void loadProgram()
    {
      
       int memAddress = 0;

      for(int i = 0; i < program.length ;i++)
        {
            if( memAddress <= 10)
            {
               m.mem[memAddress] = program[i];
               memAddress++;
            }
            else
            {
                m.mem[memAddress] = program[i];
                memAddress++;
            }

        }

    }

    /**
     *
     */
    public void getInstrction()
    {
        loading = new load();
        if(clock.count >= 10)
        {
        loading.decodeOpcode(this, clock.count);
        instruction = loading.instruction;
        System.out.println("opcode = " + instruction);
        loading.decodeAtChar(this, clock.count);
        destination = loading.destination;
        System.out.println("destination = " + destination);
        addrA = loading.addrA;
        addrB = loading.addrB;
        System.out.println(addrA + " " + addrB);
        }
        else
        {
            
        }
    }

    /**
     *
     */
    public void executeInstruction()
    {
        // at the moment operations using iF#2 are using iF#1
        switch(instruction)
        {
            case 1:
                c.add(this, destination, addrA, addrB);
                System.out.println(m.reg[destination]);
                break;
            case 2:
                c.subtract(this, destination, addrA, addrB);
                System.out.println(m.reg[destination]);
                break;
            case 3:
                c.and(this, destination, addrA, addrB);
                System.out.println(m.reg[destination]);
                break;
            case 4:
                c.xor(this, destination, addrA, addrB);
                break;
            case 5:
                c.leftShift(this, addrA);
                break;
            case 6:
                c.rightShift(this, addrA);
                break;
            case 7:
                c.loadAddr(this, destination);
                break;
            case 8:
                c.load(this, destination, addrA);
                break;
            case 9:
                c.store(this, addrA, addrA);
                break;
            case 10:
                c.loadIndirect(this, addrA, destination);
                break;
            case 11:
                c.storeIndirect(this, addrA, destination);
                break;
            case 12:
                c.branchZero(this,addrA, destination);
                break;
            case 13:
                c.branchPositive(this, addrA, destination);
                break;
            case 14:
                c.jumpReg(this, addrA);
                break;
            case 15:
                c.jumpLink(this, addrA, destination);
                break;
            default:

        }
    }

    /**
     *
     * @return
     */
    public int returnClockCount()
    {
        return(this.clock.count);
    }

    /**
     *
     * @return
     */
    public int returnOpcode()
    {
        return(this.instruction);
    }
}








