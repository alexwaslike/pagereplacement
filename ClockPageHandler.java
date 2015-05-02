//Name: Willis, Alexandra
//Project: PA-2 (Page Replacement Algorithms)
//File: ClockPageHandler.java
//Instructor: Feng Chen
//Class: cs4103-sp15
//LogonID: cs410386

public class ClockPageHandler {
	
	private Page[] pageFrames;
	
	private int currentPageLoc;
	
	public ClockPageHandler(int n){
		pageFrames = new Page[n];
		currentPageLoc = 0;
	}
	
	// Return boolean indicates whether or not a page was swapped
	//		false = page was already in pageFrames
	//		true = page was swapped in to pageFrames
	public boolean SwapIn(Page p){
		
		
		while( pageFrames[currentPageLoc] != null ){
			// if IDs are same, leave it be
			if( pageFrames[currentPageLoc].getIdent() == p.getIdent() ){
				pageFrames[currentPageLoc].referenceBit = 1;
				return false;
			}
			// if reference bit = 0, swap
			if( pageFrames[currentPageLoc].referenceBit == 0 ){
				p.next = pageFrames[currentPageLoc].next;
				pageFrames[currentPageLoc] = p;
				p.referenceBit = 1;
				return true;
			}
			else{
				//set reference bit = 0
				pageFrames[currentPageLoc].referenceBit = 0;
				//move on to next page
				if(currentPageLoc == pageFrames.length-1)
					currentPageLoc = 0;
				else
					currentPageLoc ++;
			}
		}
		
		// if the current location is empty, put p in the current position
		if(pageFrames[currentPageLoc] == null){
			// set p.next to the head (if p is not already the head)
			if(pageFrames[0] != null)
				p.next = pageFrames[0];
			pageFrames[currentPageLoc] = p;
			return true;
		}
		
		
		return false;
	}
	
	public Page[] getPageFrames(){
		return pageFrames;
	}
	
}
