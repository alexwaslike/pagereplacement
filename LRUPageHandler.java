//Name: Willis, Alexandra
//Project: PA-2 (Page Replacement Algorithms)
//File: LRUPageHandler.java
//Instructor: Feng Chen
//Class: cs4103-sp15
//LogonID: cs410386

public class LRUPageHandler {
	
	// Array of available and taken page frames
	// default length 3
	private Page[] pageFrames;
	int numHits =0;
	int numMisses =0;
	int numAccesses =0;
	
	public LRUPageHandler(){
		pageFrames = new Page[3];
	}
	
	public LRUPageHandler(int n){
		pageFrames = new Page[n];
	}
	
	// Swaps in p for least recently used page ("LRU" page)
	// Return type indicates if page fault occured
	//		true = page fault occured (swapping did occur)
	//		false = page fault did not occur (swapping did not occur)
	public boolean SwapIn(Page p){
		
		p.setTime(System.currentTimeMillis());
		
		// n = location of least recently used page
		int n = 0;
		Page LRU = pageFrames[n];
		for(int i=0; i<pageFrames.length; i++){
			
			// if current spot is empty, set n to this location and leave loop
			if(pageFrames[i] == null){
				n = i;
				break;
			}
			
			// if current page's ident is same as this page's ident, 
			//		update pageFrames member's access time to current time
			//		& return false 
			//		(no swapping occured; page with ident already in pageFrames)
			if(pageFrames[i].getIdent() == p.getIdent()){
				numAccesses++;
				pageFrames[i].setTime(p.getTime());
				numHits++;
				return false;
			}
			
			// if the current page's time is longer ago 
			// than the currently assessed LRU page,
			//		set the LRU page to the current page
			if(pageFrames[i].getTime() < LRU.getTime()){
				numAccesses++;
				LRU = pageFrames[i];
				// also store the LRU page's location in n
				n = i;
			}
		}
		
		// now swap in p in the LRU's page's location
		pageFrames[n] = p;
		//	return true (swapping occured)
		numMisses++;
		return true;
	}
	
	public Page[] getPageFrames(){
		return pageFrames;
	}

}
