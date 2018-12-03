
public class Statistics {

	int [] array = new int [100];
	int counter = -1;
	
	public void addValue(int value) {
		if(counter < 99) {		//fuer jedes eingefuegte element erhoehe counter 
			counter++;
			array[counter] = value;
		}
		else {
			SimpleIO.output("Neuer Wert kann nicht hinzugefügt werden.");
		}
	}
	
	public int getMinimum() {
		if(counter < 0) {
			SimpleIO.output("Keine Werte vorhanden!");		//wenn kein element im array return -1
			return -1;
		}
		else {
			int min = Integer.MAX_VALUE;
			for(int i = 0; i <= counter; i++) {
				if(array[i] < min) {		//wenn element im array kleiner als maxvalue ist dann ist das element neus min
					min = array[i];
				}
			}
			return min;
		}
	}
	
	public int getMaximum() {
		if(counter < 0) {
			SimpleIO.output("Keine Werte vorhanden!");
			return -1;
		}
		else {
			int max = Integer.MIN_VALUE;
			for(int i = 0; i <= counter; i++) {
				if(array[i] > max) {
					max = array[i];
				}
			}
			return max;
		}
	}
	
	public double getAverage() {
		if(counter < 0) {	
			SimpleIO.output("Keine Werte vorhanden!");
			return -1;
		}
		else {
			double average = 0;
			for(int i = 0; i <= counter; i++) {		//addiere alle elemente im array
				average = average + array[i];
			}
			average = average / (counter + 1);		//teile durch die anzal von elementen im array
			return average;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statistics statistics = new Statistics();
		statistics.addValue(2);
		statistics.addValue(105);
		statistics.addValue(-366);
		statistics.addValue(44);
		statistics.addValue(11);
		SimpleIO.output("Minimum: " + statistics.getMinimum()); 
		SimpleIO.output("Maximum: " + statistics.getMaximum()); 
		SimpleIO.output("Durchschnitt: " + statistics.getAverage());
	}

}
