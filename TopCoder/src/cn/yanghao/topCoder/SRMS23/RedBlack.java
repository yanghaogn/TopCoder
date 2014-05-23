package cn.yanghao.topCoder.SRMS23;
/*
 * 
Problem Statement
    
Balanced binary search trees are among the most studied data structures in computer science. However, implementing them can be rather tricky. Most designs of balanced binary search trees are based on the same four basic transformations--left single rotations, right single rotations, left double rotations, and right double rotations--but differ in exactly when and where these transformations are applied.
Red-black trees are one of the most popular kinds of balanced binary search trees. In a red-black tree, every node is colored either red or black, and no red node is allowed to have a red parent. In addition, every path from the root to a leaf contains the same number of black nodes. Most books on data structures contain a description of how to maintain the red-black properties, based on the usual four rotations. In this problem, we will consider a simpler scheme for maintaining red-black trees, based on a single transformation, called a twist.
Inserting a new key into a red-black tree proceeds in two phases: a search phase followed by a rebalancing phase. In the search phase, you start at the root and walk down the tree, going left when the new key is smaller than the key at the current node and going right when the new key is larger than the key at the current node. (You may assume the new key will not be equal to the key at the current node.) When the search reaches the bottom of the tree, the new key is added as a new child of the last node in the search path, on the left or right, as appropriate. The new node is always a leaf and is always colored red.
If the new node's parent is also red, then we now have a violation of the rule that no red node may have a red parent. The job of the rebalancing phase is to detect such situations, and to correct them using a transformation called a twist. A twist involves the red node, its red parent, and its black grandparent. There are four possible configurations for these three nodes, shown below:
     (Blk) z         (Blk) z               x (Blk)         x (Blk)
          / \             / \             / \             / \
   (Red) y   T4    (Red) x   T4         T1   z (Red)    T1   y (Red)
        / \             / \                 / \             / \
 (Red) x   T3         T1   y (Red)   (Red) y   T4         T2   z (Red)
      / \                 / \             / \                 / \
    T1   T2             T2   T3         T2   T3             T3   T4
where T1, T2, T3, and T4 are subtrees (possibly empty). All four configurations are rewritten to exactly the same shape:
                             (Red) y
                                  / \
                                 /   \
                          (Blk) x     z (Blk)
                               / \   / \
                              T1 T2 T3 T4  
After the twist, y's parent may be red, so the process continues until there are no more positions where a twist can be applied. Note that there will never be more than one red node with a red parent at the same time.
There is one last case to worry about. It is possible to have a red node with a red parent, but with no grandparent because the parent is the root. A twist cannot be applied without the grandparent, so to protect against this case, we color the root black at the end of every insert.
Given a sequence of numbers to be inserted one at a time into an initially empty red-black tree, your task is to determine the total number of twists that occur during the inserts.
As an example, consider the steps involved in inserting the numbers {1,2,3}. Initially the tree is empty, so when we insert the 1 node, it becomes the new root. The new node starts out red, but, because it is the root, it is recolored black at the end of the insert. The tree now looks like
            1 (Blk)
When we insert the 2 node, it goes on the right. The new node is colored red.
            1 (Blk)
             \
              2 (Red)
When we insert the 3 node, it again goes on the right and is colored red.
            1 (Blk)
             \
              2 (Red)
               \
                3 (Red)
The new node starts out red, but it has a red parent, so a twist is necessary. After the twist, the tree looks like
            2 (Red)
           / \
    (Blk) 1   3 (Blk)
However, the root is recolored black at the end of every insert, so the final tree is
            2 (Blk)
           / \
    (Blk) 1   3 (Blk)
Altogether, this series of inserts requires 1 twist, so your method should return 1.
Definition
    
Class:
RedBlack
Method:
numTwists
Parameters:
int[]
Returns:
int
Method signature:
int numTwists(int[] keys)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
keys contains between 1 and 50 elements, inclusive.
-
keys is a permutation of the numbers between 1 and n, inclusive, where n is the length of keys.
Examples
0)

    
{ 1,2,3 }
Returns: 1
The example above.
1)

    
{ 1,2,3,4,5,6,7 }
Returns: 4
One twist happens when we insert the 3, and another happens when we insert the 5, leaving
            2 (Blk)
           / \
    (Blk) 1   4 (Red)
             / \
      (Blk) 3   5 (Blk)
When we insert the 7, we initially get
            2 (Blk)
           / \
    (Blk) 1   4 (Red)
             / \
      (Blk) 3   5 (Blk)
                 \
                  6 (Red)
                   \
                    7 (Red)
but the 7 node has a red parent, so we do a twist
            2 (Blk)
           / \
    (Blk) 1   4 (Red)
             / \
      (Blk) 3   6 (Red)
               / \
        (Blk) 5   7 (Blk)
Now, the 6 node has a red parent, so we do another twist.
            4 (Red)
           / \
          /   \
   (Blk) 2     6 (Blk)
        / \   / \
       1   3 5   7   <--- all four leaves are black
At the end of the insert, we recolor the root black.
            4 (Blk)
           / \
          /   \
   (Blk) 2     6 (Blk)
        / \   / \
       1   3 5   7   <--- all four leaves are black
Altogether, 4 twists were required.
2)

    
{ 7,1,4,6,3,5,2 }
Returns: 3

3)

    
{ 5,10,15,14,3,4,11,2,1,12,6,9,7,13,8 }
Returns: 11

4)

    
{ 6,8,10,12,4,2,18,14,16,19,7,15,9,17,13,5,11,3,1 }
Returns: 5

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class RedBlack {
	public static class Node {
		int value;
		boolean isRed;
		Node left;
		Node right;
		Node parent;

		Node(int value) {
			this.value = value;
			isRed = true;
			left = null;
			right = null;
			parent = null;
		}

		void swap(Node T) {
 
			int t = value;
			value = T.value;
			T.value = t;
		}
	}

	public void insert(Node root, Node t) {
		while (true) {
			if (t.value < root.value) {
				if (null == root.left) {
					root.left = t;
					t.parent = root;
					return;
				}
				root=root.left;
			}
			if (t.value > root.value) {
				if (null == root.right) {
					root.right = t;
					t.parent = root;
					return;
				} 
				root=root.right;
			}
		}
	}
	void print(Node root){
		if(null==root)
			return;
		if(root==root.parent){
			//System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			System.exit(0);
			}
		if(root.isRed)
			System.out.print("R"+root.value);
		else
			System.out.print(root.value);
		System.out.print(":\t");
		if(null!=root.left){
			if(root.left.isRed)
				System.out.print("R"+root.left.value);
			else
				System.out.print(root.left.value);
		}
		System.out.print(",\t");
		if(null!=root.right){
			if(root.right.isRed)
				System.out.print("R"+root.right.value);
			else
				System.out.print(root.right.value);
		}
		//System.out.println();
		print(root.left);
		print(root.right);
		
	}
	public int numTwists(int[] keys) {
		if (null == keys || keys.length < 3)
			return 0;
		Node root = null;
		int numTwist = 0;
		for (int key : keys) {
			Node T3 = new Node(key);
			if (null == root) {
				root = T3;
				root.isRed = false;
				continue;
			}
			insert(root, T3);
			while (T3.isRed && T3.parent.isRed) {
				Node T2 = T3.parent;
				Node T1 = T2.parent;
				if (T1.isRed) {
					T3 = T2;
					continue;
				}
				//System.out.println("之前");
			//	print(root);
				if (T1.left == T2 && T2.left == T3) {
					Node x = T1.right;
					Node y = T2.right;
					T1.swap(T2);
					T1.left = T3;
					T3.parent = T1;
					T1.right = T2;
					T2.parent = T1;
					
				
					T2.left = y;
					T2.right = x;
					if (null != x) {
						x.parent = T2;
					}
					if (null != y) {
						y.parent = T2;
					}
					//System.out.println("T1.left == T2 && T2.left == T3");
					 
				} else if (T1.left == T2 && T2.right == T3) {
					Node x = T1.right;
					Node y = T3.left;
					Node z = T3.right;
					T1.swap(T3);
					T1.right = T3;
					T3.parent = T1;
					T2.right = y;
					if (null != y)
						y.parent = T2;
					T3.left = z;
					if (null != z)
						z.parent = T3;
					T3.right = x;
					if (null != x)
						x.parent = T3;
					//System.out.println("T1.left == T2 && T2.right == T3");
					 
				} else if (T1.right == T2 && T2.left == T3) {
					Node x = T1.left;
					Node y = T3.left;
					Node z = T3.right;
					Node w = T2.right;
					T1.swap(T3);
					T1.left = T3;
					T3.parent = T1;
					T3.left = x;
					if (null != x)
						x.parent = T3;
					T3.right = y;
					if (null != y)
						y.parent = T3;
					T2.left = z;
					if (null != z)
						z.parent = T2;
					T2.right = w;
					if (null != w)
						w.parent = T2;
					//System.out.println("T1.right == T2 && T2.left == T3");
					 
				} else if (T1.right == T2 && T2.right == T3) {
					Node x = T1.left;
					Node y = T2.left;
					T1.swap(T2);
					
					T1.left = T2;
					T2.parent = T1;
					T1.right=T3;
					T3.parent=T1;
					T2.left = x;
					T2.right = y;
					if (null != x)
						x.parent = T2;
					if (null != y)
						y.parent = T2;
					//System.out.println("T1.right == T2 && T2.right == T3");
					
				}
				T1.isRed = true;
				T2.isRed = false;
				T3.isRed = false;
				T3 = T1;
				root.isRed = false;
				numTwist++;
				//print(root);
				//System.out.println("T3:"+T3.value);
			}
		}
		return numTwist;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// { 5,10,15,14,3,4,11,2,1,12,6,9,7,13,8 }
		int[] keys ={ 1,2,3 }; 
				//{ 6, 8, 10, 12, 4, 2, 18, 14, 16, 19, 7, 15, 9, 17, 13, 5,
				//11, 3, 1 };
		System.out.println(new RedBlack().numTwists(keys));
	}

}
