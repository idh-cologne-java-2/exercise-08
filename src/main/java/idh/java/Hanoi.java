package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
    Stack<Integer> leftStack = new Stack<>();
    Stack<Integer> middleStack = new Stack<>();
    Stack<Integer> rightStack = new Stack<>();
    public Hanoi() {
        int i = 8;

        leftStack.push(9);
        while (leftStack.peek() != 1) {
            leftStack.push(i--);
        }
    }


    private void movePiece(char from, char to) {

        Stack<Integer> source;
        Stack<Integer> destination;

        switch (from) {
            case 'l' -> source = leftStack;
            case 'm' -> source = middleStack;
            case 'r' -> source = rightStack;
            default -> throw new RuntimeException();
        }

        switch (to) {
            case 'l' -> destination = leftStack;
            case 'm' -> destination = middleStack;
            case 'r' -> destination = rightStack;
            default -> throw new RuntimeException();
        }

        //Abfrage ob Stack source leer ist
        if (source.empty()) {
            System.out.println("Der Stapel ist leer!");
            return;
        }

        //Abfrage falls Zielstab leer oder oberste Scheibe von Source kleiner als Scheibe auf Destination
        if (destination.isEmpty() || source.peek() < destination.peek()) {
            destination.push(source.pop());
            return;
        }

        //Abfrage falls Source Scheibe größer als Zielscheibe
        if (source.peek() > destination.peek()) {
            System.out.println("Du darfst keine größere auf eine kleinere Scheibe tun");
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
        return leftStack.iterator();

    }

    private Iterator<Integer> getMiddleDescendingIterator() {
        return middleStack.iterator();


    }

    private Iterator<Integer> getRightDescendingIterator() {
        return rightStack.iterator();

    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("  |\n l|");
        Iterator<Integer> iter;
        iter = this.getLeftDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n m|");
        iter = this.getMiddleDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n r|");
        iter = this.getRightDescendingIterator();
        while (iter.hasNext()) {
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

        System.out.println(this);

        movePieces(leftStack.size(), 'l', 'r', 'm');

        System.out.println(this);
    }

    private void movePieces(int numberofPieces, char from, char to, char util) {

        if (numberofPieces == 0) {
            return;
        }

        movePieces(numberofPieces - 1, from, util, to);

        movePiece(from, to);

        System.out.println("Bewege Scheibe " + numberofPieces + " von " + from + " nach " + to);

        movePieces(numberofPieces - 1, util, to, from);


    }

}
