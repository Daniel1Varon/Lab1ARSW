package edu.eci.arsw.threads;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;

public class HostBlackListThread extends Thread{
    private int firstServer;
    private int lastServer;
    private String ipAddress;
    private LinkedList<Integer> blackListOcurrences = new LinkedList<>();
    HostBlacklistsDataSourceFacade skds;
    private int ocurrencesCount=0;
    public HostBlackListThread (int firstServer,int lastServer,String ipAddress,HostBlacklistsDataSourceFacade skds){
        this.firstServer=firstServer;
        this.lastServer=lastServer;
        this.ipAddress=ipAddress;
        this.skds=skds;
        this.ocurrencesCount=ocurrencesCount;
    }
    public void run(){
        for(int i = firstServer; i<lastServer; i++){
            
            if (skds.isInBlackListServer(i,this.ipAddress)){
                blackListOcurrences.add(i);
                ocurrencesCount++;
            }
        }
        
        
        
        
        
        
        System.out.println("ip"+ipAddress);
        System.out.println(ocurrencesCount);
        System.out.println(blackListOcurrences);
    }
}