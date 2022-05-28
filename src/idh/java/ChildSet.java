package idh.java;

import java.util.Collection;
import java.util.HashSet;

public class ChildSet<T> extends HashSet<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int depth;

	public ChildSet(int depth) {
		super();
		this.setDepth(depth);
	}

	public ChildSet(Collection<T> children, int depth) {
		super(children);
		this.setDepth(depth);
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	 
	public boolean add(Tree<T> t) {
		if (!super.add(t)) return false;
		t.setDepth(this.depth+1);
	}
}
