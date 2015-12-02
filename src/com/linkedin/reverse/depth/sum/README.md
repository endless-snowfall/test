# Problem:
  Reverse Depth Sum
  
 - Given a nested list of integers, returns the sum of all integers in the list weighted by their reversed depth.
 - For example, given the list {{1,1},2,{1,1}} the deepest level is 2. Thus the function should return 8 (four 1's with weight 1, one 2 with weight 2)
 - Given the list {1,{4,{6}}} the function should return 17 (one 1 with weight 3, one 4 with weight 2, and one 6 with weight 1)
 
# Stub Code:
```
/**
 * This is the interface that represents nested lists.
 * You should not implement it, or speculate about its implementation.
 */
public interface NestedInteger
{
    /** @return true if this NestedInteger holds a single integer, rather than a nested list */
    boolean isInteger();
 
    /** @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list */
    Integer getInteger();
 
    /** @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return null if this NestedInteger holds a single integer */
    List<NestedInteger> getList();
}

/**
 * Implement this
 */
public int reverseDepthSum (List<NestedInteger> input) {
    ...
}
```
  
# Clarifications:
  - Are null/empty input valid? -> Assume no.
  - Are negative, zero, and positive values of Integers valid? -> Assume yes, furthermore all Java Integer values are valid.
  - Is there worry of integer overflow? -> Assume no.

# Approach:
## Approach (1): [Unimplemented]
  - Initially try to find the maximum depth by traversing the hierarchy.
  - Once we have that, we can recursively call a helper function decreasing the depth multiplier as we descend a level.
  - We would invoke the helper such that the first level was called with the value of maximumDepth.
  - This method involves doing an O(n) pass to derive the maximumDepth and a subsequent O(n) pass to do the summing.
  
## Approach (2): [Hint Given]
  - Initially I worked on implementing a non-reversed depth sum method as a starting point.
  - Then I was given the hint that: 3x + 2y + z = 4(x + y + z) - [(x + 2y + 3z)]
  - By inspection, the non-reversed depth sum yields the latter part of that formula (x + 2y + 3z).
  - But then how do we get the former part, which requires knowledge of both the maximumDepth and an unweightedSum.
  - The hack was to make them accessible at any level of recursion, alternatively we could have passed around a state object.

# Runtime Analysis:
##Definitions:
  - n is the number of NestedInteger's after "unboxing" everything.

##Overall:
### Approach (1):
  - Space: Constant
  - Time: O(2n)
  
### Approach (2):
  - Space: Constant
  - Time: O(n)

# Tags: Tricky, Recursion, Lists, Sum, Global Access

# Notes:
  - Amazing hint given: 3x + 2y + z = 4(x + y + z) - [(x + 2y + 3z)]
  