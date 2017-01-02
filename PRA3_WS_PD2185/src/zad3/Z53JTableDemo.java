package zad3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Z53JTableDemo extends JFrame {

	private static final long serialVersionUID = -7724610014099235711L;

	private	JPanel						topPanel;
	private JTable						table;	
	private InteractiveTableModel 		tableModel;
	private JScrollPane					scroller;
	private JMenuBar 					mnuBar;
	private JMenu						mnuFile;
	private JMenuItem					mnuFileOpen, mnuFileSave, mnuFileExit;	

	public static final String[] columnNames = {
        "Autor", "Tytuł", "Cena", ""
    };
	
	public Z53JTableDemo() {		
		setTitle("Z53: JTable Demo");
		
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );
		
		tableModel = new InteractiveTableModel(columnNames);
		
		tableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
	                 int column = e.getColumn();
	                 int row = e.getFirstRow();
	                 table.setColumnSelectionInterval(column + 1, column + 1);
	                 table.setRowSelectionInterval(row, row);
	             }				
			}
			
		} );
        table = new JTable();
        table.setModel(tableModel);
        table.setSurrendersFocusOnKeystroke(true);
        if (!tableModel.hasEmptyRow()) {
            tableModel.addEmptyRow();
        }
        
        // obsługa usuwania podobnie jak w zadaniu 5.2 - przez kliknięcie myszką z przyciśniętym Alt'em
        table.addMouseListener( new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (
						// wymagane wciśnięcie ALT'a
						e.isAltDown() 
						
						// zabezpieczenie przed próbą usuwania z pustej listy lub spoza listy
						&& table.getSelectedRow() >= 0
						) 
				{
				
					tableModel.deleteRowAt(table.getSelectedRow());
					
				}
			}
		});
        
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));
        TableColumn hidden = table.getColumnModel().getColumn(InteractiveTableModel.HIDDEN_INDEX);
        hidden.setMinWidth(2);
        hidden.setPreferredWidth(2);
        hidden.setMaxWidth(2);
        hidden.setCellRenderer( new InteractiveRenderer(InteractiveTableModel.HIDDEN_INDEX) );

        
        mnuBar = new JMenuBar();
        mnuFile = new JMenu("Plik");
        mnuFile.setMnemonic(KeyEvent.VK_P);
        mnuFileOpen = new JMenuItem("Otwórz");
        mnuFileOpen.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {								
				
				JFileChooser fileDialog = new JFileChooser(System.getProperty("user.dir"));	
								
				int returnVal = fileDialog.showOpenDialog((Component) e.getSource());
				File file=null;
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fileDialog.getSelectedFile();
					
					tableModel.deleteAllRows();
					
					try {
						BufferedReader in = new BufferedReader(new FileReader(file));
						String line = in.readLine();
						while(line != null) {							
							String[] listStr = line.split("\\|"); 
							tableModel.addRow(new Book(listStr[0], listStr[1], Double.parseDouble(listStr[2])));
						   line = in.readLine();
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					tableModel.deleteRowAt(0);
					tableModel.addEmptyRow();
				}
				
			}});
        mnuFileOpen.setMnemonic(KeyEvent.VK_O);
        mnuFileSave = new JMenuItem("Zapisz jako");
        mnuFileSave.setMnemonic(KeyEvent.VK_Z);
        mnuFileSave.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileDialog = new JFileChooser(System.getProperty("user.dir"));
				
				int retVal = fileDialog.showSaveDialog((Component) e.getSource());
				File fileToSave=null;
				if (retVal == JFileChooser.APPROVE_OPTION) {
					fileToSave = fileDialog.getSelectedFile();				
				}
				
				try {
		            if (fileToSave == null) {
		                return;
		            }
		            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileToSave));
		            for(int a=0; a<tableModel.getRowCount()-1; a++) {
		            	outFile.write(
		            			tableModel.getValueAt(a, InteractiveTableModel.AUTHOR_INDEX)+"|"+
		            			tableModel.getValueAt(a, InteractiveTableModel.TITLE_INDEX)+"|"+
		            			tableModel.getValueAt(a, InteractiveTableModel.PRICE_INDEX)+"\n"
		            			);
		            }

		            outFile.close();
		            setTitle(fileToSave.getName());
		        } catch (IOException ex) {
		        	ex.printStackTrace();
		        }
				
			}
        	
        });
        mnuFileExit = new JMenuItem("Wyjście");
        mnuFileExit.setMnemonic(KeyEvent.VK_W);
        mnuFileExit.setAccelerator(KeyStroke.getKeyStroke("control X"));
        mnuFileExit.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
				
			}
        	
        });
        
        mnuBar.add(mnuFile);
        mnuFile.add(mnuFileOpen);
        mnuFile.add(mnuFileSave);
        mnuFile.addSeparator();
        mnuFile.add(mnuFileExit);
        
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
        add(mnuBar, BorderLayout.NORTH);
	}
	
    public void highlightLastRow(int row) {
        int lastrow = tableModel.getRowCount();
        if (row == lastrow - 1) {
            table.setRowSelectionInterval(lastrow - 1, lastrow - 1);
        } else {
            table.setRowSelectionInterval(row + 1, row + 1);
        }

        table.setColumnSelectionInterval(0, 0);
    }

    class InteractiveRenderer extends DefaultTableCellRenderer {

    	private static final long serialVersionUID = 1981623364435822203L;
		protected int interactiveColumn;

        public InteractiveRenderer(int interactiveColumn) {
            this.interactiveColumn = interactiveColumn;
        }

        public Component getTableCellRendererComponent(JTable table,
           Object value, boolean isSelected, boolean hasFocus, int row,
           int column)
        {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == interactiveColumn && hasFocus) {
                if ((Z53JTableDemo.this.tableModel.getRowCount() - 1) == row &&
                   !Z53JTableDemo.this.tableModel.hasEmptyRow())
                {
                    Z53JTableDemo.this.tableModel.addEmptyRow();
                }

                highlightLastRow(row);
            }

            return c;
        }
    }
}