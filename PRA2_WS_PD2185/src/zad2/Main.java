/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */


/**/
package zad2;

import static java.awt.Color.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements ActionListener {

	static int counter=0;
	
  String[] ctab = { "Red", "Yellow", "Blue" };
  Color[] color = { RED, YELLOW, BLUE, CYAN, BLACK, YELLOW  };

  public Main() {
    super("GUI");
    setLayout(new FlowLayout());

    
      JButton b = new JButton("Przycisk");
      b.setActionCommand(""+2);
      b.addActionListener(this);
      add(b);
    
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
	counter++; 
	int wynik=counter%6;    
    getContentPane().setBackground(color[wynik]);
  
    }

  public static void main(String[] a) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Main();
      }
    });
  }
}