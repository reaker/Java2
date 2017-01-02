/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */

/**
Stworzyć tabelę (JTable), pokazującą książki.
Książka ma:

autora
tytul
cenę
okładkę (obrazek)
 
Informacja o książkach ma być wczytana z pliku. (a obrazki z plkiów graficznych  z tego samego katalogu)

Należy zapewnić:

możliwość edycji cen w tabeli (w komórce)
możlwiość dodawania i usuwania wierszy do/z  tabeli z poziomu GUI.*/

package zad3;

import javax.swing.JFrame;


public class Main {
  public static void main(String ... args) {
  
	  Z53JTableDemo mainFrame = new Z53JTableDemo();
	  
	  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
      mainFrame.pack();
      mainFrame.setLocationByPlatform(true);
	  mainFrame.setVisible(true);
	  
  }
}