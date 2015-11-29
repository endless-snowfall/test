# Problem:
  Rotation

  There is a string S=s1, s2, ..., sN with length N. To this string, suppose we are going to perform the following operation (“Rotation” in the rest of this question), M times with a given order.

  The following 3 integers will be given: L, R, K(1≦L≦R≦N, 1≦K≦100). We will rotate the substring sL, sL+1, ..., sR−1, sR in this string to the right for K letters. Specifically, we will rearrange the part of the string which is aligned as sL, sL+1, ..., sR−1, sR to sR, sL, sL+1, ..., sR−1 K times. This will not change the arrangement of the characters that are not included to the interval.

  You will be given M Rotations. Output the string that you will get after applying them to the string S．

# Input
  Input will be given in the following format from Standard Input:

```
  N
  S
  M
  L1 R1 K1
  L2 R2 K2
  :
  LM RM KM
```
  - To the 1st line, integer N(1≦N≦100), which represents the length of the string, will be given.
  - To the 2nd line, the string S (length of S equals N) will be given. S consist only lowercase letters (a-z).
  - To the 3rd line, integer M(1≦M≦100), which represents the number of times of rotation, will be given.
  - On M lines after 4th line, the information of these series of rotation will be given. To ith line among them, 3 integers Li, Ri, Ki(1≦Li≦Ri≦N, 1≦Ki≦100), which represents L, R, K on rotation that will take place on for the ith time.

## Output
  Output the result obtained after applying the M rotations to the string S.

  Make sure to insert a line break at the end of the output.

## Example (1):
### Input
```
5
abcde
2
2 4 1
1 5 2
```
### Output
```
ceadb
```

After the first operation, the string will be adbce. Then, after the second operation, the string will be ceadb.

## Example (2):
### Input
```
10
okbfkkvdis
20
7 10 63
8 8 7
7 10 58
4 10 26
3 5 75
3 4 60
6 9 21
1 10 15
3 3 81
7 10 20
7 8 37
2 3 34
3 9 8
2 2 63
6 10 1
1 8 95
5 7 94
3 4 27
5 7 32
4 7 60
```

### Output
```
vkidskofbk
```

# Approach:
## Approach (1): [Duplicate Rotation Substring]
  - Define the "net" rotation to be K % the length of the rotation substring.
  - If the rotation substring is "abcde" then the start of the rotated substring is either: "a", "b", "c", "d", or "e".
  - Therefore, if we take the rotation substring and append it to itself, we can safely extract the rotation as we'll never go out of bounds: "abcdeabcde".
  - The disadvantage of this approach is having to create the extra String.
  
## Approach (2): [Rotation Index]
  - Here we also need to know the "net" rotation.
  - But we use it to determine what substring to R we can retain to start the rotated substring, i.e. the latter half, which could be empty.
  - Then we append the former half, which could be the entire rotation substring.
  - There's an elegant observation here which interprets a rotation as a concatenation of a latter half in front of a former half, as above.
  - Magically in Java, you can substring an index out of bounds with itself to get an empty string.
  
# Runtime Analysis:
## Definitions:
  - M is the number of rotations to perform.

## Approach (1):
  - Space: O(7M) space, as four calls to substring, one StringBuilder, and one string concatenation are invoked per rotation.
  - Time: O(M) time

## Approach (2):
  - Space: O(5M) space, as four calls to substring and one StringBuilder are invoked per rotation.
  - Time: O(M) time

# Tags: Tricky, Test, Strings, Rotation

# Notes:  - 
  - Discovered this easter egg in Java String.substring:
    - Throws:
IndexOutOfBoundsException - if the beginIndex is negative, or **_endIndex is larger than the length of this String object_**, or beginIndex is larger than endIndex.