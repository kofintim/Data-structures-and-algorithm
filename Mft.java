package qu;

import java.util.Scanner;

//Creating java class MFT
public class Mft {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
	
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\nThis program displays the various techniques in Operating Systems.");
		System.out.println("---------------------------------------------------------------------------------\n");
		System.out.println("1.MFT memory management technique.");
		System.out.println("2.MVT memory management technique.");
		System.out.println("3.WORST-FIT memory management technique.");
		System.out.println("4.BEST-FIT memory management technique.");
		System.out.println("5.FIRST-FIT memory management technique.");
		System.out.println("6.PAGING memory management technique.");
		System.out.println("7.First Come First Serverd SCHEDULING ALGORITHM.");
		System.out.println("8.Shortest Job First SCHEDULING ALGORITHM.");
		System.out.println("9.ROUND ROBIN CPU SCHUDULING ALGORITHM.");
		System.out.println("10.PRIORITY CPU SCHEDULING.");
		System.out.println("11.MULTI-LEVEL QUEUE SCHEDULING.");
		System.out.println("12.Bankers ALGORITHM.");
		System.out.println("13.FCFS DISK SCHEDULLING ALGORITHM.");
		System.out.println("14.SCAN DISK SCHEDULLING ALGORITHM.");
		System.out.println("15.C-SCAN FCFS DISK SCHEDULLING ALGORITHM.");
		System.out.print("\nPlease choose an option:");
		input = keyboard.nextInt();
		
		if(input == 1)
		{
			System.out.println("\nMFT MEMORY MANAGEMENT TECHNIQUE");
			//Declaring all the variables
			int totalMemory;
			int blockSize;
			int blockNumber;
			int numOfProcesses; 
			
			//Declaring and creating arrays
			int [] memoryProcesses = new int[20];
			int [] intFragmentation = new int[20];
			
			int tIntFragmentation = 0;
			int tExtFragmentation = 0;
			
			
			//Loop control variables
			int i,p = 0;
			
			//Creating Scanner objects to read inputs
			
			
			//Printing and getting inputs
			System.out.print("Enter the total memory available in Bytes:");
			totalMemory = keyboard.nextInt();
			
			System.out.print("Enter the block size in Bytes:");
			blockSize = keyboard.nextInt();
			
			//Calculating block number
			blockNumber = totalMemory/blockSize;
			
			//Calculating external fragmentation
			tExtFragmentation = totalMemory - blockNumber * blockSize;
			
			//Receiving the number of processes 
			System.out.print("Enter the number of processes:");
			numOfProcesses = keyboard.nextInt();
			
			//Loop that receives input according to the number of processes entered by the user
			for(i = 0; i < numOfProcesses ; i++)
			{
				//Since i=0 is the initial value it is incremented by 1 and iterated according to the number of processes
				System.out.print("Enter the memory required for process " + (i + 1) + ":");
				//During the loop's 1st iteration the user's 1st value is stored in [0] and i 
				//is incremented and the next value is placed in [1] during next iteration
				memoryProcesses[i] = keyboard.nextInt();
			}
			
			System.out.println("\nThe number of blocks available is memory = " + blockNumber);
			System.out.println("\nPROCESS   MEMORY REQUIRED\tALLOCATED\tINTERNAL FRAGMENTATION");
			//for loop for displaying table
			for(i = 0;i < numOfProcesses && p < blockNumber ; i++)
			{
				
				if(memoryProcesses[i] <= blockSize)
				{
					intFragmentation[i] = (blockSize - memoryProcesses[i]);
					 System.out.print(i + 1);
					 System.out.print("\t\t");
					 System.out.print(memoryProcesses[i]);
					 System.out.print("\t\t");
					 System.out.print("YES");
					 System.out.print("\t\t");
					 System.out.print(intFragmentation[i]);
					 System.out.print("\n");
					 p++;
					 tIntFragmentation = (intFragmentation[i] + tIntFragmentation);

		
				}
				
				else
				{
					 System.out.print(i + 1);
					 System.out.print("\t\t");
					 System.out.print(memoryProcesses[i]);
					 System.out.print("\t\t");
					 System.out.print("NO");
					 System.out.print("\t\t-----");
					 System.out.print("\n");
					
				}
				
			}
			if (numOfProcesses > i)
			{
				System.out.println("Memory is full, remaining process can not be accommodated ");
				System.out.print("\n");
			}
			
			System.out.println("Total External Fragmentation is " + tExtFragmentation);
			System.out.println("\nTotal Internal Fragmentation is " + tIntFragmentation);
			
		}
			
		else if(input ==2)
		{
			System.out.println("\nMVT MEMORY MANAGEMENT TECHNIQUE");
			//Declaring all variables
			int totalMemory;
			int temp;
			
			//memoryProcesses is an array reference variable
			int [] memoryProcesses = new int[10];
			int i,n=0;
			char choice = 'y';
			
			//Printing and getting inputs
			System.out.print("Enter the total memory available (in Bytes): ");
			totalMemory = keyboard.nextInt();
			
			//Storing the value of totalMemory into temp
			temp = totalMemory;
			
			for(i = 0 ; choice == 'y' ; i++,n++)
			{
				System.out.print("\nEnter the memory required for process "+ (i + 1) + " (in Bytes): ");
				
				//During the loop's 1st iteration the user's 1st value is stored in [0] and i 
				//is incremented and the next value is placed in [1] during next iteration.
				//This continues until all values have been stored in all of the elements of the array.
				memoryProcesses[i] = keyboard.nextInt();
				
					if(memoryProcesses[i]<=temp)
				{
						System.out.printf("\nMemory is allocated for Process "+(i+1));
						temp = temp - memoryProcesses[i];
				}
				
					else
				{
						System.out.println("\nMemory is Full");
						break;
				}
					
					System.out.print("\nDo you wish to continue(y/n)? ");
					
					/*//Because Scanner cannot read char,.next() returns 
					the next token/word in the input as a string and charAt(0)
					function returns the first character in that string.*/
					choice = keyboard.next().charAt(0);	
		    }
				System.out.print("\nTotal Memory Available = " + totalMemory);
				
				System.out.println("\n\nPROCESS   MEMORY ALLOCATED");
				
				//for loop for displaying table
				for(i=0;i<n;i++)
				
					/*
					 * System.out.print(i + 1); System.out.print("\t\t");
					 * System.out.print(memoryProcesses[i]); System.out.print("\t\t");
					 * System.out.print("\n");
					 */
					
					System.out.println((i+1)+"\t "+ memoryProcesses[i]);
				
				
				System.out.println("\n\nTotal Memory Allocated is " + (totalMemory - temp));
				System.out.print("Total External Fragmentation is " + temp);
	}
		
		else if(input==3) {
			System.out.println("\nWORST-FIT MEMORY MANAGEMENT TECHNIQUE");
			
			final int max = 25;
			int [] fragmentation = new int [max];
			int [] blockSize = new int [max] ;
			int [] sizeOfFiles = new int [max];
			//Loop control variable
			int i,j;
			
			int numOfBlocks;
			int numOfFiles;
			
			//Initializing variable temp
			int temp = 0;
			int [] bf = new int[max];
			int [] ff = new int[max];
			
			System.out.print("Enter the number of blocks:");
			numOfBlocks = keyboard.nextInt();
			
			System.out.print("Enter the number of files:");
			numOfFiles = keyboard.nextInt();
			
			System.out.println("\nEnter the size of the blocks:-");
			for( i = 1 ; i <= numOfBlocks ; i++) {
				System.out.print("Block " + i + ": ");
				blockSize[i] = keyboard.nextInt();	
			}
			
			System.out.println("\nEnter the size of the files:");
			for( i = 1 ; i <= numOfFiles ; i++) {
				System.out.print("File " + i + ": ");
				sizeOfFiles[i] = keyboard.nextInt();
			}
			for( i = 1 ; i <= numOfFiles ; i++)
			{
			
				for( j = 1 ; j <= numOfBlocks ; j++) {
					if ( bf[j] != 1) {
						temp = blockSize[j] - sizeOfFiles[i];
						if(temp>=0) {
							ff[i]=j;
							break;
							
						}
						
					}
					
				}
				fragmentation[i] = temp;
				bf[ff[i]]=1;	
			}
			System.out.println("\nFile Number     File Size\tBlock Number\tBlock Size     Fragmentation");
			for(i=1;i<=numOfFiles;i++) {
				
			     System.out.print(i);
				 System.out.print("\t\t");
				 System.out.print(sizeOfFiles[i]);
				 System.out.print("\t\t");
				 System.out.print(ff[i]);
				 System.out.print("\t\t");
				 System.out.print(blockSize[ff[i]]);
				 System.out.print("\t\t");
				 System.out.print(fragmentation[i]);
				 System.out.print("\n");
				  
			}
			
		}
		
		else if(input==4) {
			System.out.println("\nBEST-FIT MEMORY MANAGEMENT TECHNIQUE");
			final int max = 25;
			int [] fragmentation = new int [max];
			int [] blockSize = new int [max] ;
			int [] sizeOfFiles = new int [max];
			//Loop control variable
			int i,j;
			int lowest = 10000;
			int numOfBlocks;
			int numOfFiles;
			
			//Initializing variable
			int temp = 0;
			int [] bf = new int[max];
			int [] ff = new int[max];
			
			System.out.print("Enter the number of blocks:");
			numOfBlocks = keyboard.nextInt();
			
			System.out.print("Enter the number of files:");
			numOfFiles = keyboard.nextInt();
			
			System.out.println("\nEnter the size of the blocks:-");
			for( i = 1 ; i <= numOfBlocks ; i++) {
				System.out.print("Block " + i + ": ");
				blockSize[i] = keyboard.nextInt();	
			}
			
			System.out.println("\nEnter the size of the files:");
			for( i = 1 ; i <= numOfFiles ; i++) {
				System.out.print("File " + i + ": ");
				sizeOfFiles[i] = keyboard.nextInt();
			}
			for( i = 1 ; i <= numOfFiles ; i++)
			{
			
				for( j = 1 ; j <= numOfBlocks ; j++) {
					if ( bf[j] != 1) {
						temp = blockSize[j] - sizeOfFiles[i];
						if(temp>=0)
							if(lowest>temp){
							ff[i]=j;
							lowest=temp;
							
						}
						
					}
					
				}
				fragmentation[i] = lowest;
				bf[ff[i]]=1;
				lowest=10000;

			}
			System.out.println("\nFile Number     File Size\tBlock Number\tBlock Size     Fragmentation");
			for(i=1;i<=numOfFiles && ff[i]!=0;i++) {
				
			     System.out.print(i);
				 System.out.print("\t\t");
				 System.out.print(sizeOfFiles[i]);
				 System.out.print("\t\t");
				 System.out.print(ff[i]);
				 System.out.print("\t\t");
				 System.out.print(blockSize[ff[i]]);
				 System.out.print("\t\t");
				 System.out.print(fragmentation[i]);
				 System.out.print("\n");
				  
			}
		}
		
		else if(input==5) {
			System.out.println("\nFIRST-FIT MEMORY MANAGEMENT TECHNIQUE");
			//Declaring all variables
			final int max = 25;
			int [] fragmentation = new int [max];
			int [] blockSize = new int [max] ;
			int [] sizeOfFiles = new int [max];
			//Loop control variable
			int i,j;
			int highest = 0;
			int numOfBlocks;
			int numOfFiles;
			
			//Initializing variable
			int temp = 0;
			int [] bf = new int[max];
			int [] ff = new int[max];
			
			System.out.print("Enter the number of blocks:");
			numOfBlocks = keyboard.nextInt();
			
			System.out.print("Enter the number of files:");
			numOfFiles = keyboard.nextInt();
			
			System.out.println("\nEnter the size of the blocks:-");
			for( i = 1 ; i <= numOfBlocks ; i++) {
				System.out.print("Block " + i + ": ");
				blockSize[i] = keyboard.nextInt();	
			}
			
			System.out.println("\nEnter the size of the files:");
			for( i = 1 ; i <= numOfFiles ; i++) {
				System.out.print("File " + i + ": ");
				sizeOfFiles[i] = keyboard.nextInt();
			}
			
			for( i = 1 ; i <= numOfFiles ; i++)
			{
			
				for( j = 1 ; j <= numOfBlocks ; j++) {
					if ( bf[j] != 1) {
						temp = blockSize[j] - sizeOfFiles[i];
						if(temp>=0)
							if(highest<temp){
							ff[i]=j;
							highest=temp;
						}
					}
				}
				fragmentation[i] = highest;
				bf[ff[i]]=1;
				highest = 0;

			}
			System.out.println("\nFile Number     File Size\tBlock Number\tBlock Size     Fragmentation");
			for(i=1;i<=numOfFiles;i++) {
				
			     System.out.print(i);
				 System.out.print("\t\t");
				 System.out.print(sizeOfFiles[i]);
				 System.out.print("\t\t");
				 System.out.print(ff[i]);
				 System.out.print("\t\t");
				 System.out.print(blockSize[ff[i]]);
				 System.out.print("\t\t");
				 System.out.print(fragmentation[i]);
				 System.out.print("\n");
				  
			}
		}
		
		else if(input==6) {
			System.out.println("\nPAGING MEMORY MANAGEMENT TECHNIQUE");
			int memorySize, pageSize, memPages, tNumOfProcesses, remainingPages;
			//Loop control variables
			int i, j;
			int processNumber, pageNumber, physicalAddress, offset;
			int [] pagesForProcess = new int[10];
			int[][] pageTable = new int[10][20];
			
			
			//Reading memory size
			System.out.print("\nEnter the memory size: ");
			memorySize = keyboard.nextInt();
		
			//Reading the page size
			System.out.print("Enter the page size: ");
			pageSize = keyboard.nextInt();
			
			//Calculating the pages available in memory
			memPages = memorySize / pageSize;
			//Printing the pages available in memory
			System.out.print("The number of pages available in memory are -- " + memPages);
			
			//Reading the number of processes
			System.out.print("\nEnter the number of processes -- ");
			tNumOfProcesses = keyboard.nextInt();
			
			remainingPages = memPages;
			
			for( i = 1 ; i <= tNumOfProcesses ; i++) {
				System.out.print("\nEnter number of pages required for p[" + i +"]-- ");
				pagesForProcess[i] = keyboard.nextInt();
				
				if(pagesForProcess[i] >remainingPages) {
					System.out.print("\nMemory is Full");
					break;
				}
				remainingPages = remainingPages - pagesForProcess[i];
				
				System.out.print("Enter pagetable for p[" + i + "] ---");
				for( j = 0 ; j < pagesForProcess[i] ; j++) 
					pageTable[i][j]	= keyboard.nextInt();
			}
			System.out.print("\nEnter Logical Address to find Physical Address ");
			System.out.print("\nEnter the process number --");
			processNumber = keyboard.nextInt();
			System.out.print("\nEnter the Pagenumber --");
			pageNumber =  keyboard.nextInt();
			System.out.print("\nEnter the offset --");
			offset = keyboard.nextInt();
			
			if(processNumber > tNumOfProcesses  || pageNumber >= pagesForProcess[i] || offset >= pageSize)
				System.out.print("\nInvalid Process or Page Number or offset");
			
			else
			{
				//Calculating the physical Address
				physicalAddress = pageTable[processNumber][pageNumber] * pageSize + offset;
				System.out.print("\nThe Physical Address is -- " + physicalAddress);
			}
		}
		
		else if(input==7) {
			System.out.println("First Come First Serverd (FCFS) SCHEDULING ALGORITHM.");
			int [] burstTime  = new int [20];
			double [] waitingTime = new double [20];
			double [] turnaroundTime = new double[20];
			int i, numProcesses;
			double avgWaiting_time, avgTurnaroundTime;
			
			System.out.print("Enter the number of processes -- ");
			numProcesses = keyboard.nextInt();
			
			while(numProcesses<=0) {
			System.out.print("\nWrong input!\nPlease enter a valid number of processes:");
			numProcesses = keyboard.nextInt();
			}
			
			for(i = 0 ; i < numProcesses ; i++) {
				System.out.print("\nEnter Burst Time for Process " + i + " -- ");
			    burstTime[i] = keyboard.nextInt();
			    
				
				  while(burstTime[i]<0) {
				  System.out.print("\nWrong input!\nPlease valid burst time for Process " + i +" -- ");
				  burstTime[i] =keyboard.nextInt(); }
				 
			}
			
			waitingTime[0] = avgWaiting_time = 0;
			turnaroundTime[0] = avgTurnaroundTime = burstTime[0];
			
			
			for(i = 1 ; i < numProcesses ; i++)
			{
			waitingTime[i] = waitingTime[i-1] + burstTime[i-1];
			turnaroundTime[i] = turnaroundTime[i-1] + burstTime[i];
			
			avgWaiting_time = avgWaiting_time + waitingTime[i];
			avgTurnaroundTime = avgTurnaroundTime + turnaroundTime[i];
			}
			
			System.out.print("\nPROCESS \tBURST TIME \tWAITING TIME\tTURNAROUND TIME\n");
			for( i = 0 ; i < numProcesses ; i++) {
				 System.out.print("P"+i);
				 System.out.print("\t\t");
				 System.out.print(burstTime[i]);
				 System.out.print("\t\t");
				 System.out.print(waitingTime[i]);
				 System.out.print("\t\t");
				 System.out.print(turnaroundTime[i]);
				 System.out.print("\n");
				
			}
		}
		
		else if(input==8) {
			System.out.println("\nShortest Job First SCHEDULING ALGORITHM.");
			int [] p = new int [20];
			int [] burstTime = new int [20];
			double [] waitingTime = new double [20];
			double [] turnaroundTime = new double [20];
			int i, k, numProcesses, temp;
			double avgWaitingTime, avgTurnaroundTime;
				
			

			System.out.print("\nEnter the number of processes -- ");
			numProcesses = keyboard.nextInt();
			
			while(numProcesses<=0) {
				System.out.print("\nWrong input!\nPlease enter a valid number of processes: ");
				numProcesses = keyboard.nextInt();
				}
			
			for(i = 0 ; i < numProcesses ; i++) {
				p[i]=i;
				System.out.print("\nEnter Burst Time for Process " + i + " -- ");
			    burstTime[i] = keyboard.nextInt();   
			    
			    while(burstTime[i]<0) {
					  System.out.print("\nWrong input!\nPlease valid burst time for Process " + i +" -- ");
					  burstTime[i] =keyboard.nextInt(); }
			}
			
			for( i = 0 ; i < numProcesses ; i++)
				for( k = i + 1 ; k < numProcesses ; k++)
				if(burstTime[i]>burstTime[k])
				{
				temp=burstTime[i];
				burstTime[i]=burstTime[k];
				burstTime[k]=temp;
				temp=p[i];
				p[i]=p[k];
				p[k]=temp;
				}
			waitingTime[0] = avgWaitingTime = 0;
			turnaroundTime[0] = avgTurnaroundTime = burstTime[0];
				for( i = 1 ; i < numProcesses ; i++)
				{
				waitingTime[i] = waitingTime[i-1] + burstTime[i-1];
				turnaroundTime[i] = turnaroundTime[i-1] + burstTime[i];
				avgWaitingTime = avgWaitingTime + waitingTime[i];
				avgTurnaroundTime =avgTurnaroundTime + turnaroundTime[i];
				}
				
				System.out.print("\nPROCESS \tBURST TIME \tWAITING TIME\tTURNAROUND TIME\n");
				for( i = 0 ; i < numProcesses ; i++) {
					 System.out.print("P"+p[i]);
					 System.out.print("\t\t");
					 System.out.print(burstTime[i]);
					 System.out.print("\t\t");
					 System.out.print(waitingTime[i]);
					 System.out.print("\t\t");
					 System.out.print(turnaroundTime[i]);
					 System.out.print("\n");
			
		}
				System.out.print("\nAverage Waiting Time -- " + avgWaitingTime/numProcesses);	
				System.out.print("\nAverage Turnaround Time -- " + avgTurnaroundTime/numProcesses);
		}
		
		else if(input==9) {
			System.out.println("\nROUND ROBIN CPU SCHEDULING ALGORITHM");
			int i;
			int j;
			int numProcesses;
			int [] burstTime = new int[10];
			int [] waitingTime = new int[10];
			int [] turnaroundTime = new int[10];
			int timeSlice;
			int [] ct = new int[20];
			int max;
			float avgWaitingTime=0,avgTurnaroundTime=0,temp=0;

			System.out.print("Enter the number of processes -- ");
			numProcesses = keyboard.nextInt();
			System.out.print("\n");

			while(numProcesses<=0) {
				System.out.print("\nWrong input!\nPlease enter a valid number of processes: ");
				numProcesses = keyboard.nextInt();
				System.out.print("\n");
				}
			
			for(i = 0 ; i < numProcesses ; i++) {
				
				System.out.print("Enter Burst Time for Process " + (i+1) + " -- ");
			    burstTime[i] = keyboard.nextInt(); 
			    ct[i]=burstTime[i];

			    
			    while(burstTime[i]<0) {
			    System.out.print("\nWrong input!\nPlease valid burst time for Process " + (i+1) +" -- ");
				burstTime[i] =keyboard.nextInt();
				ct[i]=burstTime[i];
				System.out.print("\n");}
			}
			 System.out.print("\nEnter the size of time slice: ");
				timeSlice = keyboard.nextInt();
				max = burstTime[0];
				
				for( i = 1 ; i < numProcesses ; i++)
					if(max < burstTime[i])
						max = burstTime[i];
				
				for( j = 0 ; j < ((max/timeSlice) + 1) ; j++)
					for( i = 0 ; i < numProcesses ; i++)
						if( burstTime[i] != 0)
						if( burstTime[i] <= timeSlice)
							{
							turnaroundTime[i] = (int) (temp + burstTime[i]);
							temp = temp + burstTime[i];
							burstTime[i]= 0;
					        }
						else
							{
							burstTime[i]=burstTime[i]-timeSlice;
							temp = temp + timeSlice;
							}
				
				for( i = 0 ; i < numProcesses ; i++)
				 {
				waitingTime[i] = turnaroundTime[i] - ct[i];
				avgTurnaroundTime += turnaroundTime[i];
				avgWaitingTime += waitingTime[i];
				 }
				
				System.out.print("\nThe average Waiting Time -- " + String.format ("%2f",avgTurnaroundTime/numProcesses));	
				System.out.print("\nThe average Turnaround Time -- " + String.format("%2f",avgWaitingTime/numProcesses));
				System.out.print("\n");
				
				System.out.print("\nPROCESS \tBURST TIME \tWAITING TIME\tTURNAROUND TIME\n");
				for(i=0;i<numProcesses;i++) {
					 System.out.print(i+1);
					 System.out.print("\t\t");
					 System.out.print(ct[i]);
					 System.out.print("\t\t");
					 System.out.print(waitingTime[i]);
					 System.out.print("\t\t");
					 System.out.print(turnaroundTime[i]);
					 System.out.print("\n");
					}
			
		}
		
		else if(input==10) {
			
			System.out.println("\nPRIORITY CPU SCHEDULILNG");	
			int processes [] = new int[20];
			int burstTime [] = new int[20];
			int [] priorityOfProcesses= new int[20];
			int [] waitingTime = new int[20];
			int [] turnaroundTime = new int [20];
			int i, k;
			int numProcesses, temp;
			float avgWaitingTime, avgTurnaroundTime;
	
		
		System.out.print("Enter the number of processes --- ");
		numProcesses = keyboard.nextInt();
		
		while(numProcesses<=0) {
			System.out.print("\nWrong input!\nPlease enter a valid number of processes: ");
			numProcesses = keyboard.nextInt();
			}
		
		for(i=0;i<numProcesses;i++)
		{
		processes[i] = i;
		System.out.print("\nEnter the Burst Time & Priority of Process "+ i + " --- ");
		burstTime[i] = keyboard.nextInt();
		priorityOfProcesses[i] = keyboard.nextInt();
		}
		
		for(i=0;i<numProcesses;i++)
			for(k=i+1;k<numProcesses;k++)
			if(priorityOfProcesses[i] > priorityOfProcesses[k])
			{
				temp=processes[i];
				processes[i]=processes[k];
				processes[k]=temp;
				temp=burstTime[i];
				burstTime[i]=burstTime[k];
				burstTime[k]=temp;
				temp=priorityOfProcesses[i];
				priorityOfProcesses[i]=priorityOfProcesses[k];
				priorityOfProcesses[k]=temp;
				}
				avgWaitingTime = waitingTime[0] = 0;
				avgTurnaroundTime = turnaroundTime[0] = burstTime[0];
				
				for(i=1;i<numProcesses;i++)
				{
				waitingTime[i] = waitingTime[i-1] + burstTime[i-1];
				turnaroundTime[i] = turnaroundTime[i-1] + burstTime[i];
				avgWaitingTime = avgWaitingTime + waitingTime[i];
				avgTurnaroundTime = avgTurnaroundTime + turnaroundTime[i];
				}
				System.out.print("\nPROCESS \tPRIORITY \tBURST TIME \tWAITING TIME\tTURNAROUND TIME\n");
				for( i = 0 ; i < numProcesses ; i++) {
					 System.out.print(processes[i]);
					 System.out.print("\t\t");
					 System.out.print(priorityOfProcesses[i]);
					 System.out.print("\t\t");
					 System.out.print(burstTime[i]);
					 System.out.print("\t\t");
					 System.out.print(waitingTime[i]);
					 System.out.print("\t\t");
					 System.out.print(turnaroundTime[i]);
					 System.out.print("\n");	
				}
			System.out.print("\nAverage Waiting Time is --- " + avgWaitingTime/numProcesses);		
			System.out.print("\nAverage Turnaround Time is --- " + avgTurnaroundTime/numProcesses);
			
		}
		else if(input==11) {
			
			System.out.println("\nMULTI-LEVEL QUEUE SCHEDULING.");
				int process [] = new int [20];
				int	burstTime [] = new int [20];
				int	systemUserprocess [] = new int [20];
				int	wt [] = new int [20];
				int tat [] = new int[20];
				int i, k;
				int numProcesses, temp;
				float avgWaitingTime, avgTurnaroundTime;	
				
				System.out.print("Enter the number of processes --- ");
				numProcesses = keyboard.nextInt();
				
				while(numProcesses<=0) {
					System.out.print("\nWrong input!\nPlease enter a valid number of processes: ");
					numProcesses = keyboard.nextInt();
					}
				
				for(i=0;i<numProcesses;i++)
				{
				process[i] = i;
				System.out.print("\nEnter the Burst Time "+ i + " --- ");
				burstTime[i] = keyboard.nextInt();
				
				 while(burstTime[i]<0) {
					  System.out.print("\nWrong input!\nPlease valid burst time for Process " + i +" -- ");
					  burstTime[i] =keyboard.nextInt(); }
				 
				System.out.print("\nSystem/User Process (0/1) ? --- ");
				systemUserprocess[i] = keyboard.nextInt();
				
				while(systemUserprocess[i]<0 || systemUserprocess[i]>1) 
					//while(systemUserprocess !=1 || systemUserprocess!=0)
				{
					  System.out.print("\nWrong input!\nPlease enter valid value  -- ");
					  systemUserprocess[i] = keyboard.nextInt(); }
				}
				
				for(i=0;i<numProcesses;i++)
					for(k=i+1;k<numProcesses;k++)
					if(systemUserprocess[i] > systemUserprocess[k])
					{
					temp=process[i];
					process[i]=process[k];
					process[k]=temp;
					temp=burstTime[i];
					burstTime[i]=burstTime[k];
					burstTime[k]=temp;
					temp=systemUserprocess[i];
					systemUserprocess[i]=systemUserprocess[k];
					systemUserprocess[k]=temp;
					}
					avgWaitingTime = wt[0] = 0;
					avgTurnaroundTime = tat[0] = burstTime[0];
					for(i=1;i<numProcesses;i++)
					{
					wt[i] = wt[i-1] + burstTime[i-1];
					tat[i] = tat[i-1] + burstTime[i];	
					avgWaitingTime = avgWaitingTime + wt[i];
					avgTurnaroundTime = avgTurnaroundTime + tat[i];
					}
					
			System.out.print("\nPROCESS \tSYSTEM/USER PROCESS \tWAITING TIME \tWAITING TIME\tTURNAROUND TIME\n");
			for(i=0;i<numProcesses;i++) {
			 System.out.print(process[i]);
			 System.out.print("\t\t");
			 System.out.print(systemUserprocess[i]);
			 System.out.print("\t\t\t");
			 System.out.print(burstTime[i]);
			 System.out.print("\t\t");
			 System.out.print(wt[i]);
			 System.out.print("\t\t");
			 System.out.print(tat[i]);
			 System.out.print("\n\n");	
			 
			}
			System.out.print("\nAverage Waiting Time is --- " + avgWaitingTime/numProcesses);
			 System.out.print("\nAverage Waiting Time is --- " + avgTurnaroundTime/numProcesses);
			
		}
		
		else if(input==12) {
			
			class File {
				int[] all = new int[10];
				int[] max = new int[10];
				int[] need = new int[10];
				int flag;
			}
			
			System.out.println("\nBANKER'S ALGORITHM FOR DEADLOCK PREVENTION.");

				File[] f = new File[10];
				int fl;
				int i, j, k, p, b, n, r, g, cnt = 0, id, newr;
				int[] avail = new int[10];
				int[] seq = new int[10];

				System.out.print("Enter the number of processes -- ");
				n = keyboard.nextInt();

				while (n <= 0) {
					System.out.print("\nWrong input!\nPlease enter a valid number of processes -- ");
					n = keyboard.nextInt();
				}

				System.out.print("\nEnter number of resources -- ");
				r = keyboard.nextInt();
				//Rejects input which are 0 and below
				  while(r<=0) { 
					 System.out.print("\nWrong input!\nPlease enter a valid number of resources -- "); 
					 r = keyboard.nextInt();
					 }
				 
				for (i = 0; i < n; i++) {
					System.out.print("\nEnter details for P" + i );
					System.out.print("\nEnter allocation\t -- \t");
					for (j = 0; j < r; j++) 
						f[i].all[j] = keyboard.nextInt();
					
						System.out.print("Enter Max\t\t -- \t");
						for (j = 0; j < r; j++)
							f[i].max[j] = keyboard.nextInt();
						f[i].flag = 0;
					}

					System.out.print("\nEnter Available Resources\t -- \t");
					for (i = 0; i < r; i++)
						avail[i] = keyboard.nextInt();

					System.out.print("Enter New Request Details -- ");
					System.out.print("\nEnter pid \t -- \t");
					id = keyboard.nextInt();

					System.out.print("Enter Request for Resources \t -- \t");
					for (i = 0; i < r; i++) {
						newr = keyboard.nextInt();
						f[id].all[i] += newr;
						avail[i] = avail[i] - newr;
					}
					for (i = 0; i < n; i++) {
						for (j = 0; j < r; j++) {
							f[i].need[j] = f[i].max[j] - f[i].all[j];
							if (f[i].need[j] < 0)
								f[i].need[j] = 0;
						}
					}
					cnt = 0;
					fl = 0;
					while (cnt != n) {
						g = 0;
						for (j = 0; j < n; j++) {
							if (f[j].flag == 0) {
								b = 0;
								for (p = 0; p < r; p++) {
									if (avail[p] >= f[j].need[p])
										b = b + 1;
									else
										b = b - 1;
								}
								if (b == r) {
									System.out.print("\nP" + j + " is visited");
									seq[fl++] = j;
									f[j].flag = 1;

									for (k = 0; k < r; k++)
										avail[k] = avail[k] + f[j].all[k];
									cnt = cnt + 1;
									System.out.print("(");
									for (k = 0; k < r; k++)
										System.out.print(String.format("%3f", avail[k]));
									System.out.print(")");
									g = 1;
								}
							}
						}
						if (g == 0) {
							System.out.print("\n REQUEST NOT GRANTED -- DEADLOCK OCCURRED");
							System.out.print("\n SYSTEM IS IN UNSAFE STATE");
							// continue y;
						}
					}
					System.out.print("\nSYSTEM IS IN SAFE STATE");
					System.out.print("\nThe Safe Sequence is -- (");
					for (i = 0; i < fl; i++)
						System.out.print("P" + seq[i]);
					System.out.print(")");
					y: System.out.print("\nProcess\t\tAllocation\t\tMax\t\t\tNeed\n");
					for (i = 0; i < n; i++) {
						System.out.print("P" + i + "\t");
						for (j = 0; j < r; j++)
							System.out.print(String.format("%6d", f[i].all[j]));
						for (j = 0; j < r; j++)
							System.out.print(String.format("%6d", f[i].max[j]));
						for (j = 0; j < r; j++)
							System.out.print(String.format("%6d", f[i].need[j]));
						System.out.print("\n");
					}
			
			}
		else if(input==13) {
			System.out.println("\nFCFS DISK SCHEDULLING ALGORITHM.");
			
			int tracksTraversed [] = new int[20];
		    int numOfTracks;
		    //Loop control variables
		   int i, j;
		   int [] trackDifference = new int[20];
		   int tot=0;
		   float avgHeaderMvnt;
		   
		   System.out.print("Enter the number of tracks -- ");
			numOfTracks = keyboard.nextInt();
			
			while (numOfTracks < 0) {
				System.out.print("\nWrong input!\nPlease enter a valid number of processes -- ");
				numOfTracks = keyboard.nextInt();
			}
				
				System.out.print("\nEnter the tracks to be traversed -- ");
				for(i=2;i<numOfTracks+2;i++)
				tracksTraversed[i] = keyboard.nextInt();
				
				for(i = 1 ; i < numOfTracks+1 ; i++)
				 {
				 trackDifference[i] = tracksTraversed[i+1] - tracksTraversed[i];
				 if(trackDifference[i] < 0)
				 trackDifference[i] = trackDifference[i] * (-1);
				 }
				 for(i = 1 ; i < numOfTracks+1 ; i++)
				 tot+=trackDifference[i];
				 avgHeaderMvnt=(float)tot/numOfTracks;
				 System.out.print("Tracks traversed\tDifference between tracks\n");
				 
				 for(i = 1 ; i < numOfTracks+1 ; i++) {
				 //System.out.print(i+1);
				 //System.out.print("\t\t");
				 System.out.print(tracksTraversed[i]);
				 System.out.print("\t\t");
				 System.out.print(trackDifference[i]);
				 System.out.print("\n");
				 }
				 System.out.print("\nAverage header movements: "+ avgHeaderMvnt);
		}
			
	
		else if(input==14) {
			System.out.println("\nSCAN DISK SCHEDULLING ALGORITHM.");
			int [] t = new int [20];
			int [] d = new int [20];
			int h , i, n, temp, k;
			int [] atr = new int [20];
			int tot, p, sum=0;
			int j = 0;
			
			System.out.print("Enter the number of tracks -- ");
			n = keyboard.nextInt();
					
			System.out.print("\nEnter the position of head -- ");
			h = keyboard.nextInt();
			t[0]=0;
			t[1]=h;
			
			System.out.print("\nEnter the tracks to be traveresed -- ");
			for(i=2;i<n+2;i++)
			t[i] = keyboard.nextInt();
			
			for(i = 0 ; i < n+2 ; i++)
				{
			for(j=0;j<(n+2)-i-1;j++) {
			 if(t[j]>t[j+1]) {
			temp = t[j];
			t[j] = t[j+1];
			t[j+1] = temp;
			}
			 	}
					}
			
			for( i = 0 ; i < n+2 ; i++)
			if(t[i]==h)
			j = i;
			k = i;
			p = 0;
			
			while(t[j] != 0) {
			atr[p]=t[j];
			 j--;
			 p++;
				}
			 atr[p]=t[j];
			 
			 for(p = k+1 ; p<n+2 ; p++ , k++)
				 atr[p]=t[k+1];
			 
			for(j=0;j<n+1;j++)
			{
				if(atr[j]>atr[j+1])
					d[j]=atr[j]-atr[j+1];
				
				else
					d[j]=atr[j+1]-atr[j];
					sum+=d[j];
			 }
			
			System.out.print("Tracks traversed\tDifference between tracks\n");
			 
			 for(i = 1 ; i < n ; i++) {
			 //System.out.print(i+1);
			 //System.out.print("\t\t");
			 System.out.print(t[i]);
			 System.out.print("\t\t\t");
			 System.out.print(d[i]);
			 System.out.print("\n");
			 }
			System.out.print("\nAverage header movements "+ (float)sum/n);
		}
			
		
		else if(input==15) {
			System.out.println("\nC-SCAN FCFS DISK SCHEDULLING ALGORITHM.");
				int []t = new int [20];
				int d [] = new int[20];
				int h, i, j = 0;
				int n, temp, k;
				int [] atr = new int [20];
				int tot, p, sum=0;
				
				System.out.print("Enter the no of tracks to be traveresed -- ");
				n = keyboard.nextInt();
				System.out.print("Enter the position of head -- ");
				h = keyboard.nextInt();
				t[0]=0;
				t[1]=h;
				System.out.print("Enter total tracks -- ");
				tot = keyboard.nextInt();
				t[2]=tot-1;
				
				System.out.print("Enter the tracks -- ");
				for(i=3;i<=n+2;i++)
					
				t[i] = keyboard.nextInt();
				for(i=0;i<=n+2;i++)
				for(j=0;j<=(n+2)-i-1;j++)
				if(t[j]>t[j+1])
				{
				temp=t[j];
				t[j]=t[j+1];
				t[j+1]=temp;
				}
				 for(i=0;i<=n+2;i++) {
				if(t[i]==h)
				j=i;
				 break;
				 }
				p=0;
				while(t[j]!=tot-1)
				 {
				 atr[p]=t[j];
				 j++;
				 p++;
				 }
				 atr[p]=t[j];
				 p++;
				 i=0;
				 while(p!=(n+3) && t[i]!=t[h])
				 {
				atr[p]=t[i];
				i++;
				p++;
				}
				for(j=0;j<n+2;j++)
				{
				 if(atr[j]>atr[j+1])
				 d[j]=atr[j]-atr[j+1];
				else
				d[j]=atr[j+1]-atr[j];
				sum+=d[j];

				}
				System.out.print("total header movements "+sum);
				System.out.print("avg is " +(float)sum/n);
				
		}
		
		
		
		
			
		}
	
	

		/*
		else
		{
			while( input < 1 || input > 15 )
			{
				//Error checking with while loop
				System.out.println("\nInvalid value!!");
				System.out.print("Please enter a valid option:");
				input = keyboard.nextInt();
				main(args);
				
			}*/
		
		}
		
		
		
		
		
		



