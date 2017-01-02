/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */

package zad2;

import javax.swing.JFrame;

public class Main {
  public static void main(String ... args) {
  
	  // utworzenie instancji okna głównego aplikacji
	  JTextAndJList mainFrame = new JTextAndJList();
	  
	  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
      mainFrame.pack();
      mainFrame.setLocationByPlatform(true);
	  mainFrame.setVisible(true);
	  
  }
}