# Problem:
  Ball
  
  Given 8 balls aligned horizontally and numbered 1, 2, 3, 4, 5, 6, 7, 8 from left to right. We are going to perform the following N operations in the given order.

  - Exchange A1th ball from the left and B1th ball from the left.
  - Exchange A2th ball from the left and B2th ball from the left.
  - ...
  - Exchange ANth ball from the left and BNth ball from the left.

This series of N operations stated above will be one set.

Your task is to output the ultimate arrangement of these balls after repeating K sets.

## Input
Input will be given in the following format from Standard Input:

```
N K
A1 B1
A2 B2
:
AN BN
```
  - On the 1st line, integer N(1≦N≦50) represents the number of operations that are included in one set, and integer K(1≦K≦109) represents the number of sets. They are separated with a space.
  - On the following N lines, the operations to perform are given. Each line contains two integers Ai, Bi(1≦Ai, Bi≦8, Ai≠Bi) that represent the exchanges to be made. They are separated with a space.

## Partial Point
There will be partial scoring for this question.

Partial credit will be given for passing test cases where 1≦K≦1000.

## Output
The output should be a single line with the number for each ball in their final order, with a space between each number.

Make sure to insert a line break at the end of the output.

Do not put any extra space at the end of the output.

## Example (1):
### Input
```
4 2
1 2
2 3
3 4
4 1
```
### Output
```
1 4 2 3 5 6 7 8
```

You will perform 2 sets of 4 given operations, so you will perform 8 operations in total.

The flow of the operation is the following:

-  First, the balls are arranged as 1 2 3 4 5 6 7 8.
-  One will exchange the 1st ball from the left and the 2nd ball from the left. After this operation, the balls are arranged as 2 1 3 4 5 6 7 8.
-  One will exchange the 2nd ball from the left and the 3rd ball from the left. After this operation, the balls are arranged as 2 3 1 4 5 6 7 8.
-  One will exchange the 3rd ball from the left and the 4th ball from the left. After this operation, the balls are arranged as 2 3 4 1 5 6 7 8.
-  One will exchange the 4th ball from the left and the 1st ball from the left. After this operation, the balls are arranged as 1 3 4 2 5 6 7 8.
-  One will exchange the 1st ball from the left and the 2nd ball from the left. After this operation, the balls are arranged as 3 1 4 2 5 6 7 8.
-  One will exchange the 2nd ball from the left and the 3rd ball from the left. After this operation, the balls are arranged as 3 4 1 2 5 6 7 8.
-  One will exchange the 3rd ball from the left and the 4th ball from the left. After this operation, the balls are arranged as 3 4 2 1 5 6 7 8.
-  One will exchange the 4th ball from the left and the 1st ball from the left. After this operation, the balls are arranged as 1 4 2 3 5 6 7 8.

## Example (2):
### Input
```
16 1000000000
1 3
6 8
3 5
2 6
3 7
3 4
4 7
2 4
1 3
2 7
2 7
2 4
6 7
1 7
3 4
1 6
```

### Output
```
1 8 3 4 5 2 7 6
```

# Approach:
## Approach (1): [Map Solution]
  - Here we recognize that each operation is performing a swap of positions of the balls.
  - After we process all N operations, we should have some final mapping of what goes where.
  - We will use a Map<Integer, Integer> to track where the "original" position was mapped to.
    - i.e. We will initialize this map such that 0 -> 0, 1 -> 1, 2 -> 2, ..., 7 -> 7.
    - If the 3rd ball's final position is 6 then we will have the entry 2 -> 5.
  - Once we have processed all N operations and built this map, we will iterate K times and each time we will:
    - (1) Take the previous result and build a new one from it, using the map to extract from the old result.
  - One important optimization is to deal with extremely large values of K by considering all the possible cycle lengths and breaking K down by the LCM of them.  In this case that's K % (8 * 7 * 5 * 3).
  
## Approach (2): [Disjoint Cycle Form Solution]
  -

# Runtime Analysis:
##Definitions:
  - N is the number of operations in the set.
  - K is the number of times the set is applied.

##Overall:
### Approach(1):
  - Space: O(K), one array created each time we apply the set of operations.
  - Time: O(N) + O(K)

# Tags: Tricky, Disjoint Cycle Form, Mod, Optimization, Least Common Multiple, LCM, Review

# Notes:
  - [Map Solution] The optimization in dealing with large values of K.