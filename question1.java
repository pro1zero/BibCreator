package assign2;
import java.util.*;
public class question1 {
	
	static class twoStacks{
		static int[] stack = null;
		Scanner scan = null;
		final int pivot = -1;
		static int topFront = -1;
		static int topRear = -1;
		
		public twoStacks(){
			scan = new Scanner(System.in);
			System.out.print("Please enter the size(EVEN) of the main array: ");
			int size = scan.nextInt();
			try {
				stack = new int[size];
			}catch(Exception e) {
				System.out.println(e);
			}
			topFront = 0;
			topRear = stack.length - 1;
			Arrays.fill(stack, Integer.MIN_VALUE);
			scan.close();
		}
		
		public static void pushFront(int n) throws Exception {
			if(topFront < stack.length - 1  && stack[topFront] == Integer.MIN_VALUE) {
				stack[topFront] = n;
				topFront += 1;
				return;
			}
			throw new Exception("Stack 1 Overflowed!");
		}
		
		public static int popFront() throws Exception {
			if(topFront > 0) {
				topFront -= 1;
				int element = stack[topFront];
				stack[topFront] = Integer.MIN_VALUE;
				return element;
			}
			throw new Exception("Stack 1 Underflowed!");
		}
		
		public static void pushRear(int n) throws Exception {
			if(topRear > 1 && stack[topRear] == Integer.MIN_VALUE) { 
				stack[topRear] = n;
				topRear -= 1;
				return;
			}
			throw new Exception("Stack 2 Overflowed!");
		}
		
		public static int popRear() throws Exception {
			if(topRear < stack.length - 1) {
				topRear += 1;
				int element = stack[topRear];
				stack[topRear] = Integer.MIN_VALUE;
				return element;
			}
			throw new Exception("Stack 2 Underflowed!");
		}
	}
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		twoStacks ts = new twoStacks();
		try {
			twoStacks.pushFront(1);
			twoStacks.pushRear(9);
			twoStacks.pushFront(1);
			twoStacks.pushRear(9);
			twoStacks.pushFront(1);
			twoStacks.pushRear(9);
			twoStacks.popFront();
			twoStacks.pushRear(9);
			twoStacks.popFront();
			twoStacks.pushRear(9);
			twoStacks.pushRear(8);
		}catch(Exception e) {System.out.println(e);}
	}

}
