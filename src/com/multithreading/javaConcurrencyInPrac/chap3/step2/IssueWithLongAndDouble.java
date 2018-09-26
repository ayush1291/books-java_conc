package com.multithreading.javaConcurrencyInPrac.chap3.step2;


//For Java memory model all fetch and store operations are atomic. 
//But for long and double, these are TWO 32-32 bit operations

//When u read a stale value....its still okiee as that value was once present ****(Out of thin air safety)
//but here, there is a possibility that u read 32 high bits written by one thread, and lower one by the other thread
public class IssueWithLongAndDouble {

	long a; //INCORRECT
	
	volatile long A; // Compiler/runtime are notified that Since the variable is SHARED, operations on It are NOt reordered
	
	//Volatile : No locking while accessing, so they are lighter weight sync mechanism than synchronization
	
	//reading a volatile is similar to entering a synchronized block, all variables visible to Thread A, prior to writing,
	//are visible to thread B, post reading
	
	//writing a volatile is similar to exiting a synchronized block
	
	//avoid much dependence on volatile.....egs indicating imp life cycle event occurred (initialization / shutdown),
	// status/interruption flag-- check this point
	
	//use when
	//1. locking is not required while accessing
	//2. Only 1 thread updates the value
	//3. variable does not participate in invariants with other variables
	
}
