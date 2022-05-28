package idh.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tree<T>  {

	T value;
	private int depth;
	Set<Tree<T>> children;
	
	public Tree(T value) {
		this.value = value;
		this.depth = 0;
		this.children = new ChildSet<Tree<T>>(this.depth);
	}
	
	public Tree(T value, Collection<Tree<T>> children) {
		this.value = value;
		this.depth = 0;
		this.children = new ChildSet<Tree<T>>(children, this.depth);
	}
		
	public T get() {
		return value;
	}

	public void set(T value) {
		this.value = value;
	}

	public Set<Tree<T>> children() {
		return children;
	}
	
	public void setDepth(int newDepth) {
		this.depth = newDepth;
	}
	
	
	public void dfs() {
		String addedSpaces = new String();
		for (int i = 0; i < this.depth; i++) {
			addedSpaces.concat(" ");
		}
		System.out.println(addedSpaces + this.value);
		System.out.println(this.depth);
		for (Tree<T> child : children) {
			child.dfs();
		}
	}
	
	
	public static void main(String[] args) {
		
		Tree<String> ebike = new Tree<String>("e-bike");
		Tree<String> tandem = new Tree<String>("tandem");
		Tree<String> bike = new Tree<String>("bike");
		Tree<String> buggy = new Tree<String>("buggy");
		Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle");

		wheeled_vehicle.children().add(bike);
		wheeled_vehicle.children().add(buggy);
		bike.children().add(tandem);
		bike.children().add(ebike);
		
		wheeled_vehicle.dfs();
	}

}
