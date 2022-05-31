package idh.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tree<T>  {

	//irgendein Wert mit dem Datentyp T
	T value;
	//Menge von etwas (Kindern bzw. B�ume) mit dem Datentyp des collection Frameworks T
	Set<Tree<T>> children;
	
	//Konstruktor mit der Menge children die am Anfang leer ist
	public Tree(T value) {
		this.value = value;
		this.children = new HashSet<Tree<T>>();
	}
	
	public Tree(T value, Collection<Tree<T>> children) {
		this.value = value;
		this.children = new HashSet<Tree<T>>(children);
	}
	
	//gibt den Wert zur�ck
	public T get() {
		return value;
	}

	//einen neuen value und ersetzen value
	public void set(T value) {
		this.value = value;
	}

	//gibt die Kinder zur�ck
	public Set<Tree<T>> children() {
		return children;
	}
	
	//der Reihe nach die Elemente ausgeben
	public void dfs(int index) {
		//einen leeren stringbuilder erstellen, um die Einr�ckung sp�ter mit Leerzeichen zu machen
		StringBuilder st = new StringBuilder();
		//in einer Schleife �ber index iterieren. Bei jedem durchgang f�gt der stringbuilder Leerzeichen hinzu
		for(int i = 0; i < index; i++) {
			st.append("  ");
		}
		//aktuellen Knoten an den String anf�gen
		st.append(this.value);
		//aktuellen Knoten mit gebautem String ausgeben
		System.out.println(st);
		
		//mit Schleife �ber alle Kinder iterieren
		for (Tree<T> child : children) {
			//f�r jedes Kind die dfs (sich selbst) Methode aufrufen und index um 1 erh�hen
			child.dfs(index +1);
		}
	}
	
	
	public static void main(String[] args) {

		//erzeugt Baumknoten
		Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle");
		Tree<String> ebike = new Tree<String>("e-bike");
		Tree<String> tandem = new Tree<String>("tandem");
		Tree<String> bike = new Tree<String>("bike");
		Tree<String> buggy = new Tree<String>("buggy");
		

		//in die children Menge einf�gen
		wheeled_vehicle.children().add(bike);
		wheeled_vehicle.children().add(buggy);
		bike.children().add(tandem);
		bike.children().add(ebike);
		
		//fang bei 0 an damit der root (wheeled vehicle) keine Einr�ckung hat
		wheeled_vehicle.dfs(0);
	}

}
