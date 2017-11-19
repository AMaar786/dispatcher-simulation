package simpledispatcher;

import javax.swing.ImageIcon;

public final class Process implements Comparable<Process>{
    int pId;
    String status;
    int priority;
    ImageIcon readyIcon;
    ImageIcon killIcon;
    ImageIcon blockIcon;
    public static int pIdAssigner = 105;
    public static int newPriorityAssigner = 99999;
    
    public Process(int pId, String status, int priority) {
        this.pId = pId;
        this.status = status;
        this.priority = priority;
        this.readyIcon = getReadyIcon();
        this.killIcon = getKillIcon();
        this.blockIcon = getBlockIcon();
    }
    
    public void setReadyIcon(ImageIcon readyIcon) {
        this.readyIcon = readyIcon;
    }
     
    public int getpId() {
        return pId;
    }

    public ImageIcon getReadyIcon(){
        return new ImageIcon(new ImageIcon(getClass().getResource("tick.png")).getImage().getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH));
    }
    
    public ImageIcon getBlockIcon(){
        return new ImageIcon(new ImageIcon(getClass().getResource("cross.png")).getImage().getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH));
    }
    
    public ImageIcon getKillIcon(){
        return new ImageIcon(new ImageIcon(getClass().getResource("bin.png")).getImage().getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH));
    }
    
    public String getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
   public boolean equals(Process otherProcess){
       return this.getPriority() == otherProcess.getPriority();
   } 
    
    //implementing compareTo method needed by the priority Queue
    @Override
   public int compareTo(Process otherProcess ){
        if(this.equals(otherProcess))
            return 0;
        else if (getPriority() > otherProcess.getPriority())
            return 1;
        else
            return -1;
        
    }
   
    @Override
    public String toString() {
        return "Process{" + "pId=" + pId + ", status=" + status + ", priority=" + priority + '}';
    }
    
}
