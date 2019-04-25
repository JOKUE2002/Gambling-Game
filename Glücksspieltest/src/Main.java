import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {

	final int total = 10000;

	int gamesWon = 0;

	Random ran = new Random();

	Thread game = new Thread() {
		public void run() {
			double konto = 100.0;
			for (int i = 0; i < 100; i++) {
				boolean b = ran.nextBoolean();
				if (b) {
					konto *= 1.5;
				} else {
					konto *= 0.6;
				}
			}
			if (konto >= 100.0) {
				gamesWon++;
				System.out.println("W");
			} else {
				System.out.println("L");
			}
		}
	};

	public Main(String filename) {
		long beg = System.currentTimeMillis();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(".//" + filename + ".csv"));
			
			bw.write(" " + ";" + "MultiThreading" + ";" + "No MultiThreading");
			
			for(int m = 1; m < total; m++) {
				long mt = MultiThreading(m);
				long nmt = NoMultiThreading(m);
				
				bw.write(m + ";" + mt + ";" + nmt);
			}
			
			bw.close();
		} catch (Exception e) {
			
		}
		
		long end = System.currentTimeMillis();
		
		JOptionPane.showMessageDialog(null, "Total runtime: " + (end - beg) + "\nWith " + total + " iterations.");
	}

	/**
	 * WITH Multithreading
	 * @param Number of games to play
	 * @return Time (in ms) of calculation
	 */
	private long MultiThreading(int max) {
		long beg = System.currentTimeMillis();

		for (int i = 0; i < max; i++) {
			Thread thr = new Thread() {
				public void run() {
					double konto = 100.0;
					for (int i = 0; i < 100; i++) {
						boolean b = ran.nextBoolean();
						if (b) {
							konto *= 1.5;
						} else {
							konto *= 0.6;
						}
					}
					if (konto >= 100.0) {
						gamesWon++;
					}
					// System.out.println("Thread" + getName() + " ended");
				}
			};
			thr.setName("Nr.: " + i);
			thr.start();
		}

		double percentage = (double) gamesWon / (double) max * 100.0;

		long end = System.currentTimeMillis();

//		System.out.println(" ----- ENDED ----- ");
//		System.out.println(percentage + " %");
//		System.out.println(gamesWon);

		return (end - beg);
	}

	/**
	 * 
	 * WITHOUT MultiThreading
	 * @param Number of games to play
	 * @return Time (in ms) of calculation
	 */
	private long NoMultiThreading(int max) {
		long beg = System.currentTimeMillis();

		for (int i = 0; i < max; i++) {

			double konto = 100.0;
			for (int j = 0; j < 100; j++) {
				boolean b = ran.nextBoolean();
				if (b) {
					konto *= 1.5;
				} else {
					konto *= 0.6;
				}
			}
			if (konto >= 100.0) {
				gamesWon++;
			}
			// System.out.println("Thread" + getName() + " ended");

		}

		double percentage = (double) gamesWon / (double) max * 100.0;

		long end = System.currentTimeMillis();

//		System.out.println(" ----- ENDED ----- ");
//		System.out.println(percentage + " %");
//		System.out.println(gamesWon);

		return (end - beg);
	}

	public static void main(String[] args) {
		new Main(JOptionPane.showInputDialog("FileName","Test"));
	}

}
