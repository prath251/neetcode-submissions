class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }   
        List<Integer> [] bucket=new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            int number=entry.getKey();
            int frequency=entry.getValue();
            if(bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();

            }
            bucket[frequency].add(number);
        }
        int [] result=new int[k];
        int index=0;
        for(int i=bucket.length-1;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    result[index]=num;
                    index++;
                    if(index==k){
                        break;
                    }
                }
            }
        }
        return result;
    }
}
