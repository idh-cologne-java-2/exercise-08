Softwaretechnologie: Java 2

# Übung 8


Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen.

## Aufgabe 1

Die ["Türme von Hanoi"](https://de.wikipedia.org/wiki/Türme_von_Hanoi) kennen wir ja bereits aus Übung 6. Heute wollen wir das Programm so erweitern, dass es auch (automatisch) gelöst wird. Dafür verwenden wir eine rekursive Strategie:

1. Wir wissen, wie wir eine Scheibe (`n=1`) von einem Stab auf einen anderen verschieben können (Basisfall)
2. Wenn wir einen Turm aus `n` (mit `n>1`) Scheiben von Stab `l` auf Stab `r` verschieben wollen, können wir a) `n-1` Scheiben von `l` auf `m` legen, b) die eine übrige Scheibe von `l` auf `r` legen, und c) `n-1` Scheiben von `m` auf `r` legen. Dabei handelt es sich dann um den Rekursionsschritt, der allerdings aus mehreren Einzelschritten besteht.

Implementieren Sie dieses Verfahren in Java! Sie finden dazu die Referenzlösung von Übung 6 in der Klasse `idh.java.Hanoi`. Diese ist außerdem erweitert um eine Methode `runAutomatically()`, die wir statt der alten Methode `run()` innerhalb der `main()`-Funktion aufrufen.

In der Methode `runAutomatically()` finden Sie bereit eine Implementierung, die darin besteht, dass wir die Methode `movePieces()` aufrufen. Dies ist die rekursive Methode, die Sie implementieren sollen. 

Es macht das Leben leichter, sich den aktuellen Zustand der Türme anschauen zu können. Sie können dazu jederzeit die Zeile `System.out.println(this);` einfügen, um die "ASCII-Art"-Repräsentation der Türme zu sehen.


Hinweise:

- Für das verschieben einer einzelnen Scheibe sollte ausschließlich die Methode `movePiece(from, to)` verwendet werden. 

- Jeder einzelne Schritt sollte natürlich legal sein, d.h. den Anforderungen an das Spiel genügen.


----

Wenn Sie fertig sind, committen Sie alle Ihre Änderungen am Quellcode, und pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). 