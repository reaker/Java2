package zad2;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class JTextAndJList extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 8306444463088260779L;
	private	JPanel						topPanel;
	private	JList<String>				listBox;
	private JTextField					textBox;
	private DefaultListModel<String>	listModel;

	public JTextAndJList() {		
		setTitle("Z52: JList Demo");
		
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );
						
		listModel = new DefaultListModel<String>();
		
		listBox = new JList<String>();
		// Podpięcie modelu z danymi
		listBox.setModel(listModel);				
		// podpięcie ActionListenera obsługującego kliknięcia myszą na JListę
		listBox.addMouseListener( new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (
						// wymagane w zadaniu wciśnięcie ALT'a
						e.isAltDown() 
						
						// zabezpieczenie przed próbą usuwania z pustej listy lub spoza listy
						&& listBox.getSelectedIndex() >= 0
						) 
				{
				
					listModel.remove(listBox.getSelectedIndex());
					
				}
			}
		});
		
		textBox = new JTextField();
		// podpięcie ActionListenera obsługującego klawisze (obsługa ENTER'a)
		textBox.addKeyListener( new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent e)
            {
            	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            		listModel.addElement(textBox.getText());
            		textBox.setText("");
            	}
            }
		});
		
		topPanel.add(new JScrollPane(listBox));
		topPanel.add(textBox, BorderLayout.PAGE_END);		
	}
	


}