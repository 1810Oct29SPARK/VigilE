package CodeChallenge;

public class MinimumMutations {
	
	public int minMutation (String start, String end, String[]bank) {
		int counter = 0; 
		
		return counter;
	}
	
	
	
	// solutions below were copied for reference to see how it was done
	// and commented out because I didn't want to use them and didn't understand how they worked. 
	
//	public class Solution {
//		 public int minMutation(String start, String end, String[] bank) {
//		        
//		 	HashSet set = new HashSet();
//			//convert bank into set for faster lookup        
//		    for(String b: bank){
//		      set.add(b);
//		    }
//		       
//			 // check if end is not in bank, it means there is no solution
//		     if(!set.contains(end)){ 
//		        return -1;
//		     }
//		        
//		     //queue to check on each muatated word
//		     Queue<Container> queue = new LinkedList<Container>();
//		       
//		     //set allowed characters to mutate words.
//		     char [] mutationChar = {'A','C','G','T'};
//		     
//		     //here setting 0 steps away value in container   
//		     queue.add(new Container(0,start));
//		        
//		     while(!queue.isEmpty()){
//		            
//		        Container con = queue.remove();
//		        set.remove(con.words);
//		            
//		        String words = con.words;
//		            
//		        for(int i=0; i<words.length(); i++){        
//		            for(int j=0; j<mutationChar.length; j++){
//		                    
//		                StringBuilder str = new StringBuilder(words);
//		                    
//		                 if(str.charAt(i) == mutationChar[j]){
//		                    continue;
//		                 }    
//		                    
//		                 str.setCharAt(i,mutationChar[j]);
//		                    
//		                 if(!set.contains(str.toString())){
//		                     continue;
//		                 }
//		                    
//		                    
//		                  if(str.toString().equals(end)){
//		                        return con.steps+1;
//		                  }else{
//		             queue.add(new Container(con.steps+1,str.toString()));
//		                    }
//		                }
//		                
//		            }
//		            
//		            
//		        }
//		    return -1;    
//		    }
//		}
//		 
//		class Container{
//		    String words;
//		    int steps;
//		    
//		    public Container(int steps,String words){
//		        this.words = words;
//		        this.steps = steps;
//		    }
//		}
	
}
