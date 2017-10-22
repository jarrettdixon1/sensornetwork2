import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*command line arguments
 * min
 * max
 * #
 * initial position
 * 
 */
public class DS {
    public static void main(String[] args){
	int min = Integer.parseInt(args[0]);
	int max = Integer.parseInt(args[1]);
	int number = Integer.parseInt(args[2]);
	int initialPosition = Integer.parseInt(args[3]);
	Generator gen1 = new Generator(number);
	int []arr = gen1.getCylinders();
	ArrayList<Integer> list = new ArrayList<>();
	for(int i : arr) list.add(i);
	
	
	System.out.println(" fcfs: ");fcfs(list,initialPosition,min,max);
	
	System.out.println("\n sstf: ");sstf(list,initialPosition,min,max);
	
	System.out.println("\n look: ");look(list,initialPosition,min,max);
	
	System.out.println("\n clook: ");clook(list,initialPosition,min,max);
	
	System.out.println("\n scan: ");scan(list,initialPosition,min,max);
	
	System.out.println("\n cscan: ");cscan(list,initialPosition,min,max);

    }
    public static void fcfs(ArrayList<Integer> list, int initial, int min, int max){
	System.out.print("Requests: ");
	printlist(list);
	ArrayList<Integer> newlist = new ArrayList<>();
	newlist.add(initial);
	newlist.addAll(list);
	System.out.print("Visited order: ");
	printlist(newlist);
	int distance = distanceoflist(newlist);
	System.out.println("Distance : " + distance);

    }
    public static void sstf(ArrayList<Integer> list, int initial,int min, int max){// finish this method
	ArrayList<Integer> newlist = new ArrayList<>();
	ArrayList<Integer> list1 = new ArrayList<>(list);
	System.out.print("Requests: ");
	printlist(list1);
	newlist.add(initial);
	int counter = 0;
	while( !list1.isEmpty() ){
	    int lastposition = newlist.get( newlist.size()-1 );
	    int mindistance = Math.abs( lastposition - list1.get(0) );
	    int minposition = 0;
	    for(int i = 0; i<list1.size(); i++){
		int currentindex = i;
		int currentposition = list1.get(i);
		int currentdistance = Math.abs( lastposition - currentposition);
		if( mindistance > currentdistance){
		    mindistance = currentdistance;
		    minposition = currentindex;  
		}
	    }
	    counter++;
	    newlist.add( list1.remove( minposition ) );
	}
	System.out.print("Visited order: ");
	printlist(newlist);
	int distance = distanceoflist(newlist);
	System.out.println("Distance : " + distance);
    }
    public static void look(ArrayList<Integer> list, int initial, int min, int max){//modified scan
	System.out.print("Requests: ");
	printlist(list);
	ArrayList<Integer> list1 = new ArrayList<>();
	ArrayList<Integer> list2 = new ArrayList<>();
	for(Integer i : list){
	    if(i < initial)
		list1.add(i);
	    else
		list2.add(i);
	}
	Collections.sort(list1);
	Collections.sort(list2);
	Collections.reverse(list1);
	list1.add(0,initial);
	list1.addAll(list2);
	System.out.print("Visited order: ");printlist(list1);
	System.out.println("Distance : " + distanceoflist(list1));

    }
    public static void scan(ArrayList<Integer> list, int initial, int min, int max){
	System.out.print("Requests: " ); printlist(list);
	ArrayList<Integer> list1 = new ArrayList<>();
	ArrayList<Integer> list2 = new ArrayList<>();
	for(Integer i : list){
	    if(i < initial)
		list1.add(i);
	    else
		list2.add(i);
	}
	Collections.sort(list1);
	Collections.sort(list2);
	Collections.reverse(list1);
	list1.add(0,initial);
	list2.add(0,min);
	
	list1.addAll(list2);
	System.out.print("Visited order: ");printlist(list1);
	System.out.println("Distance : " + distanceoflist(list1));
    }
    public static void clook(ArrayList<Integer> list, int initial, int min, int max){
	ArrayList<Integer> list1 = new ArrayList<>();
	ArrayList<Integer> list2 = new ArrayList<>();
	System.out.print("Requests: ");printlist(list);
	for(Integer i : list){
	    if(i < initial)
		list1.add(i);
	    else
		list2.add(i);
	}
	Collections.sort(list1);
	Collections.sort(list2);
	Collections.reverse(list1);
	Collections.reverse(list2);
	list1.add(0,initial);
	list1.addAll(list2);
	System.out.print("Visited order: ");printlist(list1);
	System.out.println("Distance : " + distanceoflist(list1));
    }
    public static void cscan(ArrayList<Integer> list, int initial,int min, int max){// modified cscan
	ArrayList<Integer> list1 = new ArrayList<>();
	ArrayList<Integer> list2 = new ArrayList<>();
	for(Integer i : list){
	    if(i < initial)
		list1.add(i);
	    else
		list2.add(i);
	}
	System.out.print("Requests: ");printlist(list);
	Collections.sort(list1);
	Collections.sort(list2);
	Collections.reverse(list1);
	Collections.reverse(list2);
	list1.add(0,initial);
	list2.add(0,max);
	list2.add(0,min);
	list1.addAll(list2);
	System.out.print("Visited order: ");printlist(list1);
	int distance = distanceoflist(list1);
	System.out.println("distance: " + distance);
	
    }
    public static void printlist(ArrayList<Integer> list){
	for(Integer i : list)
	    System.out.print(i+" ");
	System.out.println();
    }
    public static int distanceoflist(ArrayList<Integer> list){
	int sum = 0;

	for(int i = 1; i< list.size(); i++){
	    int dx = Math.abs(list.get(i)-list.get(i-1));
	    sum += dx;
	    
	}
	return sum;
    }
    public static class Generator{
	private static final int DEFAULT_SIZE = 100;
	private static final int RANGE = 99;

	int[] referenceString;

	public Generator() {
		this(DEFAULT_SIZE);
	}

	public Generator(int count) {
		if (count < 0)
			throw new IllegalArgumentException();

		java.util.Random generator = new java.util.Random();
		referenceString = new int[count];

		for (int i = 0; i < count; i++)
			referenceString[i] = generator.nextInt(RANGE + 1);
	}

	public int[] getCylinders() {
		return referenceString;
	}
}
    
}