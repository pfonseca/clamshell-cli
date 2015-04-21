import java.util.Arrays;
import java.util.regex.Pattern;


public class Principal {

	public static void main(String[] args) {
		
		String query = "paulo ..";
		
		
		Pattern respondsTo = Pattern.compile("(.*)");
		
		System.out.println(respondsTo.matcher(query).matches());
		
		String[] tokens = query.trim().split("\\s+");
		String[] ars = Arrays.copyOfRange(tokens, 1, tokens.length);
		
		for(String t:ars){
			System.out.println(t);
		}
	}

}
