package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {

	Deque<Integer> left = new LinkedList<Integer>();
	Deque<Integer> middle = new LinkedList<Integer>();
	Deque<Integer> right = new LinkedList<Integer>();
	
	public Hanoi() {
		for (int i = 3; i < 10; i++) {
			left.addLast(i);
		}
	}
	
	private void movePiece(char from, char to) throws IllegalMoveException {
		Deque<Integer> fromDeque = null;
		Deque<Integer> toDeque = null;
		switch(from) {
		case 'l': fromDeque = left; break;
		case 'm': fromDeque = middle; break;
		case 'r': fromDeque = right; break;
		}
		
		switch(to) {
		case 'l': toDeque = left; break;
		case 'm': toDeque = middle; break;
		case 'r': toDeque = right; break;
		}
		
		if (fromDeque.isEmpty()) throw new IllegalMoveException();
		if (toDeque.isEmpty()) {
			toDeque.addFirst(fromDeque.remove());
			return;
		}
		if (fromDeque.getLast() > toDeque.getLast()) {
			throw new IllegalMoveException();
		}
		toDeque.addFirst(fromDeque.remove());
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this);
				System.out.print("Enter source and target stick (will move top piece):");
				String s = br.readLine();
				if (s.matches("^([lmr])([lmr])$")) {
					char source = s.charAt(0);
					char target = s.charAt(1);
					movePiece(source, target);
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				e.printStackTrace();
			} 
		}
	}
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return left.descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return middle.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return right.descendingIterator();
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter;
		iter = this.getLeftDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = this.getMiddleDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = this.getRightDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |");
		return b.toString();
	}
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		// hanoi.run();
		hanoi.runAutomatically();
	}

	private void runAutomatically() {
		// we print out the initial situation
		System.out.println(this);

		// this is the entry point into the recursion
		movePieces(left.size(), 'l', 'r', 'm');
		
		// and in the end, we check that everything has been moved
		System.out.println(this);
	}
	
	private void movePieces(int numberOfPieces, char from, char to, char util) {
		Deque<Integer> toDeque = null;
		switch(to) {
		case 'l': toDeque = left; break;
		case 'm': toDeque = middle; break;
		case 'r': toDeque = right; break;
		}
		int originalSize = toDeque.size();
		char lastFrom = 0;
		char lastTo = 0;
		char[][] combos = {{'l','m'},{'l','r'},{'m','l'},{'m','r'},{'r','l'},{'r','m'}};
		while (true) {
			for (char[] combo : combos) {
				System.out.println(String.valueOf(combo));
				try {
					if (!(combo[0] == lastTo && combo[1] == lastFrom)) {
						this.movePiece(combo[0], combo[1]);
					}
					break;
				} catch (IllegalMoveException e) {
					
				}
			}
			System.out.println(this);
			if (toDeque.size() == originalSize + numberOfPieces) {
				return;
			}
		}
	}
	
	

}
