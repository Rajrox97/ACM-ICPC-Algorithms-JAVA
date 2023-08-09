class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hm = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String ch = String.valueOf(arr);
            if(hm.containsKey(ch)){
                List<String>s = hm.get(ch);
                s.add(strs[i]);
                hm.put(ch,s);
            }
            else{
                List<String>s = new ArrayList<String>();
                s.add(strs[i]);
                hm.put(ch,s);
            }

        }
        List<List<String>> st = new ArrayList<>();
        
        for (Map.Entry<String,List<String>> mapElement : hm.entrySet()) {
            
 
            st.add(mapElement.getValue());
            
        }
        return st;
        
    }
}

/*
Approach
This Java code is an implementation of a function groupAnagrams that takes an array of strings strs as input and groups the anagrams together. Anagrams are words that have the same characters but in a different order.

Let's go through the code step by step:
Create a HashMap called hm, where the key is a sorted string representation of each word (anagram), and the value is a list of strings representing the anagrams.

Iterate through each string in the strs array.

Convert the current string strs[i] to a character array arr.

Sort the character array arr using Arrays.sort(arr). This will arrange the characters in ascending order, making anagrams have the same sorted representation.

Convert the sorted character array arr back to a string ch using String.valueOf(arr).

Check if the hm already contains the key ch. If yes, then it means we have already encountered an anagram of the current string. We get the corresponding list of anagrams using hm.get(ch) and add the current string strs[i] to that list. Then, we update the hm with the updated list.

If the hm does not contain the key ch, it means we have not encountered this anagram before. In that case, we create a new list, add the current string strs[i] to it, and put it in the hm with the key ch.

After processing all strings in the strs array, we have a hashmap hm with keys as sorted anagrams and values as lists of strings containing the anagrams.

Create a new List called st to store the final result.

Iterate through each entry in the hm using a for-each loop (for (Map.Entry<String,List> mapElement : hm.entrySet())).

Get the value (list of anagrams) corresponding to the current key (sorted anagram) using mapElement.getValue() and add it to the st list.

After iterating through all entries in the hm, the st list will contain lists of anagrams grouped together.

Return the st list, which contains the groups of anagrams.

The overall time complexity of this solution is O(N * K * log K), where N is the number of strings in the input array strs, and K is the maximum length of a string in strs. The reason for this complexity is that we are sorting each string, which takes O(K * log K) time, and we do this for each of the N strings in the array.

Complexity
Let's analyze the time and space complexity of the given solution:

Time Complexity:

The first loop iterates through each string in the strs array. This loop has a time complexity of O(N), where N is the number of strings in the array.
Inside the loop, we convert each string to a character array and then sort it using Arrays.sort(arr). Sorting takes O(K * log K) time, where K is the maximum length of a string in the array.
For each iteration of the loop, we perform sorting, which contributes O(K * log K) time complexity.
The second loop iterates through the hm hashmap, which has at most N entries (N unique anagram keys).
Inside this loop, we add each list of anagrams to the final result list. This operation takes O(M) time, where M is the number of anagrams for each key (can vary but is overall bounded by N).
Putting it all together, the overall time complexity is:
O(N) * (O(K * log K) + O(M)) = O(N * K * log K + N * M)

In the worst case, when all the strings in the array are anagrams of each other, M can be equal to N (each key in the hashmap has a list of N anagrams). In such cases, the time complexity simplifies to:

O(N * K * log K + N * N) = O(N^2 + N * K * log K)

However, it's important to note that the average case time complexity can be much better since the distribution of anagrams and the lengths of strings can vary.

Space Complexity:

The space complexity is mainly affected by the hm hashmap, which can have at most N entries (unique anagram keys). Each entry stores a list of anagrams, which, in the worst case, can have N strings.
The space required for the hm hashmap is O(N * N) = O(N^2), considering the worst-case scenario where all strings are anagrams of each other.
The st list of lists stores all the anagram groups, but since it is only a representation of the data already in hm, it doesn't contribute to additional space complexity.
The space required for character arrays, strings, and other variables is negligible compared to the hashmap and the result list.
Therefore, the overall space complexity is O(N^2), considering the worst-case scenario with all strings being anagrams of each other.

In summary, the time complexity of the solution is approximately O(N * K * log K + N * M), and the space complexity is O(N^2).
*/