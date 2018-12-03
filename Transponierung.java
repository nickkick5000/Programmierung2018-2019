
public class Transponierung {

	public static void transponieren() {
		int zeilen = 0;
		int spalten = 0;
		
		zeilen = SimpleIO.getInt("Wie viele Zeilen hat die Matrix?");
		while(zeilen < 1) {
			zeilen = SimpleIO.getInt("Wie viele Zeilen hat die Matrix?");
		}
		
		spalten = SimpleIO.getInt("Wie viele Spalten hat die Matrix?");
		while(spalten < 1) {
			spalten = SimpleIO.getInt("Wie viele Spalten hat die Matrix?");
		}
		
		int [][] matrix = new int [zeilen][spalten];
		int eingabe = 0;
		
		for(int i = 0; i < zeilen; i++) {
			for(int k = 0; k < spalten; k++) {		//durchlaufe erst alle spalten, dann zeilen
				eingabe = SimpleIO.getInt("Wie lautet die Zahl fuer die Position" + "(" + (i + 1) + "," + (k + 1) + ")");
				matrix [i][k] = eingabe;
			}
		}
		
		int [][] transponiert = new int [spalten][zeilen];	//transponiertes array
		
		for(int i = 0; i < zeilen; i++) {
			for(int k = 0; k < spalten; k++) {
				transponiert[k][i] = matrix [i][k];		//durchlaufe vom alten array die spalten vom neuen array die zeilen
			}
		}
		
		System.out.println("Matrix:");		//ausgabe der matrix
		
		for(int[] a : matrix) {
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		
		System.out.println("Transponierte Matrix:");
		
		for(int[] a : transponiert) {
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		transponieren();
	}
}
