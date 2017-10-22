
public class Permutation {
	public static void main(String []args){

		//permute("abc");
		
		String word = "0123456789";
		System.out.println(word.substring(5));
		System.out.println(word.substring(0,4));

	}
	public static void permute(String word){
		permute(word, "");
	}
	public static void permute(String word, String precede){

		if(word.length()==0)
			System.out.println(precede);
		else{

			for(int i = 0; i<word.length();i++){

				String newWord = word.substring(0,i) + word.substring(i+1);

				String newPrecede = precede + word.charAt(i);

				permute(newWord,newPrecede);
			}
		}


	}

}
