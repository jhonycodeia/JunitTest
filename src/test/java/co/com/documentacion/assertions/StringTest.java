package co.com.documentacion.assertions;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	@Test
	public void test() {
		int i = 0;
	    long prev_time = System.nanoTime();
	    long time;
	    long memory;
	    
	    String tiempos = "";
	    String s = "";
	    memory = Runtime.getRuntime().freeMemory();

	    for( i = 0; i< 1000; i++){
	        s += "Blah" + i + "Blah";
	    }
	    time = System.nanoTime() - prev_time;
	    memory = memory-Runtime.getRuntime().freeMemory();

	    System.out.println("Time after for loop " + time+ " memoria "+memory);
	    
	    tiempos += "String : "+time+"    "+memory+"\n";
	    s= "";
	    prev_time = System.nanoTime();
	    memory = Runtime.getRuntime().freeMemory();
	    for( i = 0; i<1000; i++){
	        s += String.format("Blah %d Blah", i);
	    }
	    time = System.nanoTime() - prev_time;
	    memory = memory-Runtime.getRuntime().freeMemory();
	    System.out.println("Time after for loop "+ time+ " memoria "+memory);
	    
	    tiempos += "StringFormat : "+time+"    "+memory+"\n";
	    
	    prev_time = System.nanoTime();
	    memory = Runtime.getRuntime().freeMemory();
	    StringBuilder strbuilder = new StringBuilder();
	    for( i = 0; i<1000; i++){
	    	strbuilder.append("Blah ").append(i).append(" Blah");	        
	    }
	    time = System.nanoTime() - prev_time;
	    memory = memory-Runtime.getRuntime().freeMemory();
	    System.out.println("Time after for loop "+ time+ " memoria "+memory);
	    
	    tiempos += "StringBuilder : "+time+"    "+memory+"\n";
	    
	    System.out.println(tiempos);
	}

}
