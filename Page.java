//Name: Willis, Alexandra
//Project: PA-2 (Page Replacement Algorithms)
//File: Page.java
//Instructor: Feng Chen
//Class: cs4103-sp15
//LogonID: cs410386

public class Page {
	
	private int ident;
	private long lastTimeAccessed;
	public int referenceBit;
	public Page next;
	
	public Page(){
		lastTimeAccessed = System.currentTimeMillis();
		ident = -1;
		referenceBit = 0;
	}
	
	public Page(int i){
		lastTimeAccessed = System.currentTimeMillis();
		ident = i;
		referenceBit = 0;
	}
	
	public void setTime(long l){
		lastTimeAccessed = l;
	}
	
	public long getTime(){
		return lastTimeAccessed;
	}
	
	public int getIdent(){
		return ident;
	}
	
	

}
