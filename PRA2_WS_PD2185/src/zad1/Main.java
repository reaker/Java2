/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */

package zad1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {

  public static void main(String[] args) {
	  final int CNUM = 5; 
      
	    String gborders[] = { "West", "North", "East", "South", "Center" };
	    String fontA[]= {"Sans", "SansSerif", "Diagram", "Monospaced", "Arial"};
	    Color bgColor[]={Color.RED, Color.CYAN, Color.BLUE, Color.YELLOW, Color.GREEN};
	    Color fColor[]={Color.CYAN, Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED};
	    int fSize[]={21,13,15,17,19};
	    Border brdr[]= {BorderFactory.createEmptyBorder(), BorderFactory.createMatteBorder(5, 1, 15, 15, Color.cyan),BorderFactory.createLineBorder(Color.black),BorderFactory.createMatteBorder(5, 10, 5, 15, Color.blue),BorderFactory.createRaisedBevelBorder() };
	    String toolTips[]={"aaa","bbb","ccc","ddd","eee"};
	           
	    JFrame frame = new JFrame("Layouts show"); // okno i contentPane

	    frame.setLayout(new BorderLayout(0, 1));
	      
	      for (int j = 0; j < CNUM; j++) { 
	        JLabel l= new JLabel("P" + (j+1));
	        l.setBackground(bgColor[j]);
	        l.setForeground(fColor[j]);
	        l.setToolTipText(toolTips[j]); 
	        l.setBorder(brdr[j]);
	        l.setFont(new Font(fontA[j], Font.PLAIN, fSize[j]));;
	        frame.add(l, gborders[j]);                 
	      }
	     
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	  }
	  
}
