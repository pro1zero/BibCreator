package assign2;
import java.util.*;

public class question2 {
	
	static class maxStack{
		static List<Map<String, Integer>> maxStack = new ArrayList<Map<String, Integer>>();
		static List<Integer> stack = new ArrayList<>();
		
		public static int peek() {
			return stack.get(stack.size() - 1);
		}
		
		public static int pop() {
			maxStack.remove(maxStack.size() - 1);
			return stack.remove(stack.size() - 1);
		}
		
		public static void push(int number) {
			Map<String, Integer> newMax = new HashMap<String, Integer>();
			newMax.put("max", number);
			if(maxStack.size() > 0) {
				Map<String, Integer> lastMax = new HashMap<String, Integer>(maxStack.get(maxStack.size() - 1));
				newMax.replace("max", Math.max(lastMax.get("max"), number));
			}
			maxStack.add(newMax);
			stack.add(number);
		}
		
		public static int getMax() {
			return maxStack.get(maxStack.size() - 1).get("max");
		}
	}
	public static void main(String[] args) {
		
	}
}
