//Name: Willis, Alexandra
//Project: PA-2 (Page Replacement Algorithms)
//File: Main.java
//Instructor: Feng Chen
//Class: cs4103-sp15
//LogonID: cs410386

import java.util.Scanner;

public class Main {
	
	public static final int[] inputNums = {0, 1, 2, 3, 2, 4, 5, 3, 4, 1, 6, 3, 7,                                   8, 7, 8, 4, 9, 7, 8, 1, 2, 9, 5, 4, 5, 0, 2};
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter LRU or CLOCK: ");
		String alg = input.nextLine();
		System.out.println("Enter number of page frames: ");
		int num = input.nextInt();
		
		if(alg.equals("LRU")){
			
			// create handler with desired number of page frames accessible
			LRUPageHandler handler = new LRUPageHandler(num);
			
			// run through input nums and swap in all pages
			int faults = 0;
			for( int i=0; i<inputNums.length; i++ ){
				
				// if swapping results in a page fault, add to page fault count
				if( handler.SwapIn( new Page(inputNums[i]) ) )
					faults ++;
				
				// print out current page frames
				Page[] frames = handler.getPageFrames();
				System.out.print("\nPage frames: [");
				for( int j=0; j<frames.length; j++ )
					if(frames[j] != null )
                        System.out.print(frames[j].getIdent());
				System.out.print("]");
			}
			
			// output
			System.out.println("\nNumber of faults: " + faults
							+ "\nNumber of page accesses: " + handler.numAccesses
							+ "\nNumber of page hits: " + handler.numHits
							+ "\nNumber of page misses: " + handler.numMisses);
		
        }
		else if(alg.equals("CLOCK")){
			
			ClockPageHandler handler = new ClockPageHandler(num);
			
			// run through input nums and swap in all pages
			int faults = 0;
			for( int i=0; i<inputNums.length; i++ ){
							
				// if swapping results in a page fault, add to page fault count
				if( handler.SwapIn( new Page(inputNums[i]) ) )
					faults ++;
								
				// print out current page frames
				Page[] frames = handler.getPageFrames();
				System.out.print("\nPage frames: [");
				for( int j=0; j<frames.length; j++ )
					if(frames[j] != null ) System.out.print(frames[j].getIdent());
					System.out.print("]");
			}
					
			// output
			System.out.println("\nNumber of faults: " + faults);
			
		}
		
		input.close();

	}

}
