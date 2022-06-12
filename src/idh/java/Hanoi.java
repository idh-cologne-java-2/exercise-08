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
	
	private void movePiece(char from, char to) {
		Integer piece = null;
		switch(from) {
		case 'l': piece = left.remove(); break;
		case 'm': piece = middle.remove(); break;
		case 'r': piece = right.remove(); break;
		}
		
		switch(to) {
		case 'l': left.addFirst(piece); break;
		case 'm': middle.addFirst(piece); break;
		case 'r': right.addFirst(piece); break;
		}
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
		
		int i = 0;
		
		if(numberOfPieces == i) 	
		{
			return;
		}
		
		numberOfPieces = numberOfPieces-1;
		
		movePieces(numberOfPieces, from, util, to);
		
		movePiece(from, to);
		
		System.out.println(this);
		
		movePieces(numberOfPieces, util, to, from);
		
	}
	
	

}