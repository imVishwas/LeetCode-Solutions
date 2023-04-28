/*
 *
 * #839. Similar String Groups
 * 
 *

Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?

 

Example 1:

Input: strs = ["tars","rats","arts","star"]
Output: 2
Example 2:

Input: strs = ["omv","ovm"]
Output: 1
 

Constraints:

1 <= strs.length <= 300
1 <= strs[i].length <= 300
strs[i] consists of lowercase letters only.
All words in strs have the same length and are anagrams of each other.

*/




class Solution {
  public int numSimilarGroups(String[] A) {
    int ans = 0;
    boolean[] seen = new boolean[A.length];

    for (int i = 0; i < A.length; ++i)
      if (!seen[i]) {
        dfs(A, i, seen);
        ++ans;
      }

    return ans;
  }

  private void dfs(final String[] A, int i, boolean[] seen) {
    seen[i] = true;
    for (int j = 0; j < A.length; ++j)
      if (!seen[j] && isSimilar(A[i], A[j]))
        dfs(A, j, seen);
  }

  private boolean isSimilar(final String X, final String Y) {
    int diff = 0;
    for (int i = 0; i < X.length(); ++i)
      if (X.charAt(i) != Y.charAt(i) && ++diff > 2)
        return false;
    return true;
  }
}