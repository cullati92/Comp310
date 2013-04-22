import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashmap<T> extends LList {
	
	private static int TABLE_SIZE = 25;
	
	
	private LList<Node>[] theLists;
	
	//constructor
	public Hashmap(){
		
		this(TABLE_SIZE);
	}	
	//constructor
	public Hashmap(int size){
		theLists = new LList[ nextPrime(size)];
		for(int i=0;i< theLists.length;i++)
			theLists[i] = new LList<Node>();
	}
	
	//finds next prime
	private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }
	
	//checks if number is prime
	private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }
	
	
	
	//inserts node into linked list of hashtable
	public void insert(Node w){
		int c = 1;
		LList<Node> chain = theLists[myhash(w)];
		System.out.println(w);
		System.out.println(chain.contains(w));
		
			if(!chain.contains(w)){
				chain.add(w, c);
				
			}else if(chain.contains(w)){

					chain.update(w);
					
			}
		
	}
	
	//calculates hash code
	public int myhash(Node x){
		int hash = x.getData().hashCode();
		
		hash %= TABLE_SIZE;
		if(hash < 0)
			hash += TABLE_SIZE;
		//System.out.println(hash);
		return hash;
	}
	
	
	//calls insert method
	public void run(String s){
		Node n= new Node(s, 1);
		System.out.println(s);
		insert(n);
	}

	//prints out string represeentation of object
	public String toString(){
		String s = "Hashtable.";
		for(int i=0;i<TABLE_SIZE;i++){
			System.out.println("Displaying chain " + i + " index.");
			theLists[i].display();
		}
		return s;
	}
	
	
	
	
	
	public class HashEntry<T> {
        private T key;
        private int value;
        
        //constructor for  entries
        HashEntry(T key, int value) {
              this.key = key;
              this.value = value;
        }     
   
        //accessor for key
        public T getKey() {
              return key;
        }
   
        //accessor for value
        public int getValue() {
              return value;
        }

        //outputs information about entries
        public String toString() {
        	
            String s = "<Item(";
            s += this.getKey() + "," + this.getValue() + ")>";
            return s;
        }
    }
	
	public static void main(String args[]){
		Hashmap hash = new Hashmap();
		try{	//catches ioexception
			FileInputStream fstream = new FileInputStream("new.txt"); //gets data from file
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			while((str = br.readLine()) != null){ 
				str = str.replaceAll("\\. "," ");//removes periods with space after
				str = str.replaceAll("\\."," ");//removes periods
				String[] words = str.split(" ");    //splits up words into their own string
				for (String word : words)  //loops through words
				{  
					word = word.toLowerCase();	
					
					hash.run(word);//adds words to hash table
					     
				}
			}
			br.close();//closes infile
			System.out.println("Here are the words with their corresponding occurences: " + hash); //outputs data
			
		}catch(IOException e){	//catches illegal operation
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}	
	
	
	
}
