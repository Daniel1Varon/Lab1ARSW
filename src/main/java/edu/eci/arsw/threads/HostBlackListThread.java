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
    private int checkedListsCount=0;
    public HostBlackListThread (int firstServer,int lastServer,String ipAddress,HostBlacklistsDataSourceFacade skds){
        this.firstServer=firstServer;
        this.lastServer=lastServer;
        this.ipAddress=ipAddress;
        this.skds=skds;
    }
    public void run(){
        for(int i = firstServer; i<=lastServer; i++){
        	checkedListsCount++;
            if (skds.isInBlackListServer(i,this.ipAddress)){
                blackListOcurrences.add(i);
                ocurrencesCount++;
            }
        }
    }
    
    public int getOcurrencesCount() {return ocurrencesCount;}
    public int getCheckedListsCount() {return checkedListsCount;}
    public LinkedList<Integer> getBlackListOcurrences() {return blackListOcurrences;}
}