package Learning.ModifiedBinarySearch;

/*
We have a list of versions of software from 1 ... n, A bad version in the list indicates all the version
after that are bad, Lets say there are 5 versions

[false, true, true, true, true, true, true,true]
[1,2,3,4,5,6,7,8]

n = 8
bad = 6 -> this is the bad version given to us but we need to find the first bad version.

assume result = 6 // since this the first bad version based on input

low = 1
high = 6
mid = (low+high) / 2

if mid is bad then we update result to mid and keep on searching in the upper half
if mid is not bad then we move towards the later version i.e lower half


Completed in leetcode because there is a parent class that needs to be implemented

For big number to calculate mid -  low+(high-low)/2


 */
public class FirstBadVersion {
}
