class Solution {
    public String simplifyPath(String path) {
        Deque<String> st=new ArrayDeque<>();
        for(String a:path.split("/")){
            if(a.equals("..")){
                
                st.poll();
            }
            else if(a.length()>0&&!a.equals(".")){
                st.push(a);
               
            }
        }
        StringBuilder res=new StringBuilder();
        for(String a:st){
            res.insert(0,a).insert(0,"/");
        }
        
        return res.isEmpty()?"/":res.toString();
    }
}
