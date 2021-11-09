package it.unibo.oop.lab.collections1;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	private static final int TO_MS = 1_000_000;
	private static final int INIT_VALUE = 1000;
    private static final int LAST_VALUE = 2000;
    private static final int HEAD_INSERT_ELEMS = 1_00_000;
    private static final int TIMES = 1000;
    
    private static final long AFRICA_NUM_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_NUM_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_NUM_POPULATION = 0L;
    private static final long ASIA_NUM_POPULATION = 4_298_723_000L;
    private static final long EUROPE_NUM_POPULATION = 742_452_000L;
    private static final long OCEANIA_NUM_POPULATION = 38_304_000L;
   
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

    	final List<Integer> arrayList = new ArrayList<>();
    	
    	for(int i = INIT_VALUE;i < LAST_VALUE;i++) {
    		arrayList.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

    	List<Integer> linkedList = new LinkedList<>(arrayList);
    	        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

    	final Integer tmp = arrayList.get(arrayList.size() - 1);
    	arrayList.set((arrayList.size() - 1) , arrayList.get(0));
    	arrayList.set(0 , tmp);
        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	System.out.print("[");
    	for(final int app : arrayList) {
    		System.out.print(app +" ");
    	}
    	System.out.println("]");
    	    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	//Insert elements in the head of the ArrayList and measure the time
    	long time = System.nanoTime();
    	
    	for(int i = 0; i < HEAD_INSERT_ELEMS; i++) {
    		arrayList.add(i);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("Time to insert:"+ HEAD_INSERT_ELEMS 
    			+ " elements in the head of the ArrayList is: "+ time
    			+ "ns (" + (time / TO_MS) + "ms)");
    	
    	//Insert elements in the head of the LinkedList and measure the time
    	time = System.nanoTime();
    	
    	for(int i = 0; i < HEAD_INSERT_ELEMS; i++) {
    		linkedList.add(i);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("Time to insert:"+ HEAD_INSERT_ELEMS 
    			+ " elements in the head of the LinkedList is: "+ time
    			+ "ns (" + (time / TO_MS) + "ms)");
        
    	/*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	//Read elements in the middle of the ArrayList and measure the time
    	System.out.println("Element read "+ TIMES +" times in the ArrayList"
    			+ "is: " +  arrayList.get(arrayList.size() / 2));
    	
    	time = System.nanoTime();
    	
    	for(int i = 0; i < TIMES; i++) {
    		arrayList.get(arrayList.size() / 2);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Time to read "+ TIMES 
    			+ " elements int the middle of the ArrayList is "+ time
    			+ "ns (" + (time / TO_MS) + "ms)");
    	
    	//Read elements in the middle of the LinkedList and measure the time
    	System.out.println("Element read "+ TIMES +" times in the LinkedList"
    			+ "is: " +  linkedList.get(linkedList.size() / 2));
    	
    	time = System.nanoTime();
    	
    	for(int i = 0; i < TIMES; i++) {
    		linkedList.get(linkedList.size() / 2);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Time to read "+ TIMES 
    			+ " elements int the middle of the LinkedList is "+ time
    			+ "ns (" + (time / TO_MS) + "ms)");
    	    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	Map<String, Long> map = new HashMap<>();
    	
    	map.put("Africa", AFRICA_NUM_POPULATION);
    	map.put("Americas", AMERICAS_NUM_POPULATION);
    	map.put("Antarctica", ANTARCTICA_NUM_POPULATION);
    	map.put("Asia", ASIA_NUM_POPULATION);
    	map.put("Europe", EUROPE_NUM_POPULATION);
    	map.put("Oceania", OCEANIA_NUM_POPULATION);
    	 	
        /*
         * 8) Compute the population of the world
         */
    	long worldpopulation = 0;
    	for(final var app: map.values()) {
    		 worldpopulation += app;
    	}
    	System.out.println("The population of the world is: "+ worldpopulation);
    }
}
