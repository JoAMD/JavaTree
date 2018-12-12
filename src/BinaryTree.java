import java.util.Scanner;
import java.util.ArrayList;
//import java.lang.Math;

//geeksforgeeks level order traversal in java can be neater
public class BinaryTree{
	
	public static class node{
		int data;
		node l, r;
		
		public node(int data){
			this.data = data;
			l = r = null;
		}
	}
	
	public static class TreeFunctions{
		int i = 2;
		//ArrayList<Integer> a = new ArrayList<Integer>();
		int a, x = 0;
		public void makeNodeOnLevelx(node root, int height, ArrayList<Integer> treeData) {
			//System.out.println(x++);
			if(height == 1) {
				//System.out.println(root.data + " " + i);
				
				Scanner s = new Scanner(System.in);
				
				//a.add(s.nextInt());
				//a = s.nextInt();
				root.l = new node(treeData.get(i-1));
				i++;
				
				//a.add(s.nextInt());
				//a = s.nextInt();
				root.r = new node(treeData.get(i-1));
				i++;
				
				s.close();
				return;
			}
			makeNodeOnLevelx(root.l, height - 1, treeData);
			makeNodeOnLevelx(root.r, height - 1, treeData);
			return;
		}
		
		public void makeAllNodes(node root, int height, ArrayList<Integer> treeData) {
			for(int j = 0; j < height-1; ++j) {
				//System.out.println("Level number " + j);
				makeNodeOnLevelx(root, j + 1, treeData);
			}
		}
		
		public void printGivenLevel(node root, int level) {
			if(root == null) {
				return;
			}
			if(level == 1) {
				System.out.println(root.data);
				return;
			}
			printGivenLevel(root.l, level - 1);
			printGivenLevel(root.r, level - 1);
			
		}
		
		public void printfull(node root, int height) {
			for(int i = 0; i < height; ++i) {
				printGivenLevel(root, i + 1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		/*
		node root = new node(1);
		root.l = new node(2);
		root.r = new node(3);
		root.l.l = new node(4);
		root.l.r = new node(5);
		root.r.l = new node(6);
		root.r.r = new node(7);
		*/
		Scanner s = new Scanner(System.in);
		int height = s.nextInt();

		ArrayList<Integer> treeData = new ArrayList<Integer>();
		for(int i = 0; i < java.lang.Math.pow(2,height)-1; ++i) {	
			treeData.add(s.nextInt());
		}

		node root = new node(treeData.get(0));
		
		TreeFunctions f = new TreeFunctions();
		f.makeAllNodes(root, height, treeData);
		f.printfull(root, height);
		s.close();
	}
	
	
	
}