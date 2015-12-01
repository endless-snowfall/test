# Problem:
  Construction
  
  There are N islands that are numbered from 1 to N. For Q days, either one of the following two queries will be given every day. Write a program that processes them in given order.

  (Query 1) build A B

  Construct a bridge that will allow one to cross between island A and island B in both directions. At the point this query is given, it is guaranteed that there is no existing bridge between island A and island B. Initially, no bridge has been constructed between any islands.

  (Query 2) check A B

  - Determine whether one can get from island A to island B by crossing any number of bridges.
  - If one can do so, a) output the construction date for the oldest bridge out of all the bridges one crosses.
  - In the case that there are several routes, find the route in which the oldest bridge you need to cross is the newest among any alternative route. Then, b) demolish the oldest bridge defined above. This bridge will no longer exist after demolition.
  
# Input:
Input will be given in the following format from Standard Input:

```
N Q
Query1
Query2
:
QueryQ
```

  - On the 1st line, integer N(1≦N≦50), which represents the number of islands, and integer Q(1≦Q≦500), the number of days that queries are given, will be given. They are separated by space.
  - From 2nd line to Q th line, the information of each day’s queries will be given. Among them, on the i(1≦i≦Q) th line, the content of query Queryi on the i th day is written. Queryi is given either in the format of build A B or check A B (1≦A,B≦N and A≠B). At the point that the query of the build A Bformat is given, there is no existing bridge between A and B.

# Output:
Each time the check A B format is given, if one can get from island A to island B, define the construction date of the oldest bridge as X, and output as the YES X format. If not, output NO.

Make sure to insert a line break at the end of the output.

# Example (1):
## Input:
```
5 7
build 1 2
check 1 2
build 2 3
check 1 2
build 3 4
check 2 4
check 1 5
```

## Output:
```
YES 1
NO
YES 3
NO
```

# Example (2):
## Input:
```
3 7
build 1 3
build 1 2
build 2 3
check 1 3
check 1 3
check 1 3
check 2 3
```

## Output:
```
YES 2
YES 1
NO
YES 3
```

# Example (3):
## Input:
```
5 30
build 1 5
build 3 4
build 4 5
build 5 2
build 3 1
check 5 2
build 3 5
build 2 5
build 3 2
build 4 2
build 4 1
check 4 1
build 1 2
build 4 1
check 1 5
build 5 2
check 5 3
build 2 3
check 5 1
build 2 1
check 2 3
build 2 3
check 3 1
build 2 1
check 3 5
build 5 2
check 5 1
build 1 2
check 4 5
build 1 4
```

## Output:
```
YES 4
YES 11
YES 8
YES 9
YES 13
YES 18
YES 20
YES 16
YES 24
YES 14
```

# Approach:
  - 

# Runtime Analysis:
##Definitions:
  - 

##Breakdown:
  - 

##Overall:
  - Space: 
  - Time: 

# Tags: Tricky, Graph, Unfinished

# Notes:
  - TODO: The current solution seems to have duplicated paths when computing all possible paths...