# Concave Polygon

https://www.hackerrank.com/challenges/lambda-march-concave-polygon/problem

You are given the cartesian coordinates of a set of points in a  plane (in no particular order). Each of these points is a corner point of some Polygon, , which is not self-intersecting in nature. Can you determine whether or not  is a concave polygon?

### Input Format

The first line contains an integer, , denoting the number of points. 
The  subsequent lines each contain  space-separated integers denoting the respective  and  coordinates of a point.

### Constraints

3 <= N <= 1000

0 <= x, y <= 1000

### Output Format

Print  if  is a concave polygon; otherwise, print .

#### Sample Input

```
4
0 0
0 1  
1 1  
1 0
```

#### Sample Output

```
NO
```

#### Explanation

The given polygon is a square, and each of its  internal angles are . As none of these are over , the polygon is not concave and we print .
