/*
 * Author: Annya Evans-Martinez
 * 
 * Runs junit tests
 *
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnnyaTests{
   static Data database = Data.getInstance();
   static Terminal terminal = new Terminal();
   static Program program = new Program();
   @Before
   public void setUp(){
       terminal.prompt("Test File");
   }
   @Test
   public void test1() {
	   
   }
   @Test
   public void test2() {
	   
   }
   @Test
   public void test3() {
	   
   }
}