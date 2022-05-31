package idh.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tree<T> {

    T value;
    Set<Tree<T>> children;

    public Tree(T value) {
        this.value = value;
        this.children = new HashSet<>();
    }

    public Tree(T value, Collection<Tree<T>> children) {
        this.value = value;
        this.children = new HashSet<>(children);
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

    public void dfs(int indent) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < indent; i++) {
           str.append("  ");
        }
        str.append(this.value);
        System.out.println(str);

        for (Tree<T> child : children) {
            child.dfs(indent + 1);
        }
    }


    public static void main(String[] args) {

        Tree<String> ebike = new Tree<>("e-bike");
        Tree<String> tandem = new Tree<>("tandem");
        Tree<String> bike = new Tree<>("bike");
        Tree<String> buggy = new Tree<>("buggy");

        Tree<String> wheeled_vehicle = new Tree<>("wheeled vehicle");

        wheeled_vehicle.children().add(bike);
        wheeled_vehicle.children().add(buggy);
        bike.children().add(tandem);
        bike.children().add(ebike);

        wheeled_vehicle.dfs(0);
    }

}