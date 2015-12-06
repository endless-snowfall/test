# Problem:
  Count Land Masses
  
  Given a representation of a map which is comprised of "cells" of land and ocean, count the number of "land masses" on the map.
  
  A "land mass" is a contiguously connected collection of land cells that are connected to horizontal and vertical neighboring land cells.
  
# Example (1):

```
0, 0
0, 0
```

Has no land masses.

# Example (2):

```
0, 0, 0
0, 1, 0
0, 0, 0
```

Has one land mass.

# Example (3):

```
1, 0, 0
0, 0, 0
0, 0, 1
```

Has two land masses.

# Example (3):

```
1, 0, 0
0, 1, 0
0, 0, 1
```

Has one land mass.
  
# Clarifications:
  - Are null/empty input valid? -> Assume yes and the result is zero.
  - What if two land cells are connected diagonally? -> They are disjoint land masses, see Example (4).
  
# Approach:
  - Guard against edge cases above.
  - Ocean cells are somewhat disregardable since they cannot attribute to the result.
  - Once we discover a land cell, we know that our result will increase by 1 but we do not know the shape or form of the land mass the cell is a part of.
  - We will "sink" the entire land mass by "crawling" from the initially discovered land cell.
  - As we crawl we need to:
    - Check to ensure that we are still within the boundaries of the map.
    - Guard against the cell having already been sunken (by another neighbor for complex maps).
    - Immediately sink the land cell, making it ocean.
    - Sink the cell's horizontal and vertical neighbors.

# Runtime Analysis:
##Definitions:
  - r is the number of rows in the map.
  - c is the number of columns in the map.
  - n is the total number of cells in the map (r x c).
  - the unit of cost will be defined as each access of a cell, [Ri, Ci]

##Breakdown:
  - Each cell could be discovered once by the main discovery loop.
  - Each cell could also be told to "sink" by its four neighbors.
  - Therefore each cell has an upper bound of 5x accesses.

##Overall:
  - Space: Constant
  - Time: O(5n)

# Tags: Tricky, Review, Matrix, Arrays, Linear

# Notes:
  - 