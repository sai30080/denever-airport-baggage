package com.denver.baggagerouting;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class TestRunner {
	private static Logger log = Logger.getLogger(TestRunner.class.getName());
	

	@Test
    public void testMain(){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        EntryProgram.main(new String [] {"src/test/Input.txt"});
        //Visualize the program with One departure and One Bag
     //   EntryProgram.main(new String [] {"src/test/Input1.txt"});
        String output=bos.toString(); 
        System.out.println(output);
        log.info(output);
        assertNotNull(output);
        
        //Expected Output
      /*  0001 Concourse_A_Ticketing A5 A1 : 11
        0002 A5 A1 A2 A3 A4 : 9
        0003 A2 A1 : 1
        0004 A8 A9 A10 A5 : 6
        0005 A7 A8 A9 A10 A5 BaggageClaim : 12*/

    }
}
