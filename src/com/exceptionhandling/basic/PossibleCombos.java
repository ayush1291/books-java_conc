package com.exceptionhandling.basic;

//comment / unomment each block to see
public class PossibleCombos {

	public static void main(String[] args){
		int a = 0;
		
		//not allowed  - only try
//		try {
//			a=0/0;
//		}
		
		//not allowed - multiple try with single catch
//		try{
//			a=0/0;
//		}try{
//			a=0/0;
//		}catch (Exception e){
//			System.out.println(e);
//		}
		
		
		//allowed : one try with multiple catch
//		try{
//			a=0/0;
//		}		
//		catch (ArithmeticException e){
//			System.out.println(e);
//		}		catch (IndexOutOfBoundsException e){
//			System.out.println(e);
//		}
//		catch (Exception e){
//			System.out.println(e);
//		}
		
		//allowed : try with finally
//		try{
//			a=0/0;
//		}		
//		finally{
//			System.out.println("finalllyyyy");
//		}
		
		//not allowed : multiple finally
//		try{
//			a=0/0;
//		}		
//		catch (ArithmeticException e){
//			System.out.println(e);
//		}		catch (IndexOutOfBoundsException e){
//			System.out.println(e);
//		}
//		catch (Exception e){
//			System.out.println(e);
//		}
//		finally{
//			System.out.println("finalllyyyy");
//		}
//		finally{
//			System.out.println("finalllyyyy");
//		}
		
		
		//not allowed : try with multiple finally
//		try{
//			a=0/0;
//		}		
//		finally{
//			System.out.println("finalllyyyy");
//		}
//		finally{
//			System.out.println("finalllyyyy");
//		}
		
		
		//allowed : multiple try catch
//		try{
//		a=0/0;
//		}		
//		catch (ArithmeticException e){
//			System.out.println(e);
//		}		catch (IndexOutOfBoundsException e){
//			System.out.println(e);
//		}
//		catch (Exception e){
//			System.out.println(e);
//		}try{
//		a=0/0;
//		}		
//		catch (ArithmeticException e){
//			System.out.println(e);
//		}		catch (IndexOutOfBoundsException e){
//			System.out.println(e);
//		}
//		catch (Exception e){
//			System.out.println(e);
//		}
//		finally {
//			System.out.println("finally");
//		}
		
	}
}
