package zad3;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class InteractiveTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 50152112062425292L;	

	public static final int AUTHOR_INDEX = 0;
    public static final int TITLE_INDEX = 1;
    public static final int PRICE_INDEX = 2;
    public static final int HIDDEN_INDEX = 3;
	
    protected String[] columnNames;
    protected Vector<Book> dataVector;

    public InteractiveTableModel(String[] columnNames) {
        this.columnNames = columnNames;
        dataVector = new Vector<Book>();
    }    
    
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public boolean isCellEditable(int row, int column) {
        if (column == HIDDEN_INDEX) return false;
        else return true;
    }
        
	public Class<?> getColumnClass(int column) {
        switch (column) {
            case AUTHOR_INDEX:
            case TITLE_INDEX:            
               return String.class;
               
            case PRICE_INDEX:
            	return Double.class;
            	
            default:
               return Object.class;
        }
    }
    
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return dataVector.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
        Book book = dataVector.get(row);
        switch (column) {
            case AUTHOR_INDEX:
               return book.getAuthor();
            case TITLE_INDEX:
               return book.getTitle();
            case PRICE_INDEX:
               return book.getPrice();
            default:
               return new Object();
        }        		
	}
	
	public void setValueAt(Object value, int row, int column) {
        Book book = dataVector.get(row);
        switch (column) {
            case AUTHOR_INDEX:
               book.setAuthor((String)value);
               break;
            case TITLE_INDEX:
               book.setTitle((String)value);
               break;
            case PRICE_INDEX:
               book.setPrice((Double)value);
               break;
            default:
               System.out.println("invalid index");
        }
        fireTableCellUpdated(row, column);		
	}
	
	public boolean hasEmptyRow() {
        if (dataVector.size() == 0) return false;
        Book book = dataVector.get(dataVector.size() - 1);
        if (book.getAuthor().trim().equals("") &&
           book.getTitle().trim().equals("") &&
           book.getPrice() == 0)
        {
           return true;
        }
        else return false;
    }

    public void addEmptyRow() {
        dataVector.add(new Book());
        fireTableRowsInserted(
           dataVector.size() - 1,
           dataVector.size() - 1);
    }
    
    public void addRow(Book book) {
    	dataVector.add(book);
        fireTableRowsInserted(
                dataVector.size() - 1,
                dataVector.size() - 1);
    	
    }
    
    public void deleteRowAt(int index) {
    	dataVector.remove(index);
    	fireTableRowsDeleted(index, index);
    }
    
    public void deleteAllRows() {
    	dataVector.removeAllElements();
    	addEmptyRow();
    	fireTableRowsDeleted(0, getRowCount());       	
    }
	
}