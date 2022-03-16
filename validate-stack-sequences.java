//leetcode.com/problems/validate-stack-sequences/

///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\

//Approach 1: O(1) space solution.
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      
        int i=0;
        int j=0;
        
        int size=0;
        int n=pushed.length;
      
        while(i<n&&j<n){
            
            ++size;
            
            if(pushed[i]!=popped[j]){
              // ++i;
            }else{
                int k=i;
                while(k>=0&&pushed[k]==popped[j]){
                  
                    if(pushed[k]!=-1){
                        --size;
                        ++j;
                        pushed[k]=-1;
                    }
                  
                    while(k>=0&&pushed[k]==-1){
                        --k;
                    }
                }
                //++i;
            }
          ++i;
        }
        
        return size==0;
    }
}
///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\

//Approach 2: O(n) space solution, stack implementation
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0;
        int j=0;
        
        int size=0;
        int n=pushed.length;
        Deque<Integer> st=new ArrayDeque<>();
        
    
        while(i<n&&j<n){
            st.push(pushed[i]);
            if(st.peek()==popped[j]){
                while(!st.isEmpty()&&st.peek()==popped[j]){
                    st.pop();
                    ++j;
                }
                
            }
            ++i;
        }
        
        return st.isEmpty();
    }
}
///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\

//Alternate approach 2:
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      
        int i=0;
        int j=0;
      
        for(int num:pushed){
            pushed[i++]=num;
            while(i>0&&pushed[i-1]==popped[j]){
                --i;
                ++j;
            }
          
        }
        
        return i==0;
    }
}

