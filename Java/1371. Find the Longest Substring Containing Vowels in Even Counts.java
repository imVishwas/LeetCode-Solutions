/*
# 1371. Find the Longest Substring Containing Vowels in Even Counts


Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.

 
Example 1:
Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.

Example 2:
Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.

Example 3:
Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
 

Constraints:

1 <= s.length <= 5 x 10^5
s contains only lowercase English letters.
*/






class Solution {
    public int findTheLongestSubstring(String s) {
        final String kVowels = "aeiou";
        int ans = 0;
        int prefix = 0; // the binary prefix
        Map<Integer, Integer> prefixToIndex = new HashMap<>();
        prefixToIndex.put(0, -1);

        for (int i = 0; i < s.length(); ++i) {
            final int index = kVowels.indexOf(s.charAt(i));
            if (index != -1)
                prefix ^= 1 << index;
            prefixToIndex.putIfAbsent(prefix, i);
            ans = Math.max(ans, i - prefixToIndex.get(prefix));
        }

        return ans;
    }
}