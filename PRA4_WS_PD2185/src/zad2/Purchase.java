/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */

package zad2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

public class Purchase implements Serializable {
	public Purchase(){
		this(null, null, 0);
	}
	private String prod; //prosta
	public synchronized void setProd(String newProd){
		String oldProd =  prod;
		prod = newProd;
		chg.firePropertyChange("data", oldProd, newProd);
	}
	public synchronized String getProd(){
		return prod;
	}
	
	
	private PropertyChangeSupport chg = new PropertyChangeSupport(this);
	private String data; //bound
	public synchronized void setData(String newData) {
		String oldData =  data;
		data = newData;
		chg.firePropertyChange("data", oldData, newData);
	}
	public synchronized String getData(){
		return data;
	}
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		chg.addPropertyChangeListener(l);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
		chg.removePropertyChangeListener(l);
	}
	
	private VetoableChangeSupport veto = new VetoableChangeSupport(this);
	private Double price; //constrained
	public synchronized void setPrice(Double newPrice)  throws PropertyVetoException {
		Double oldPrice = price;
		veto.fireVetoableChange("price", oldPrice, newPrice);
		price = newPrice;
		chg.firePropertyChange("price", oldPrice, newPrice);
	}
	public synchronized Double getPrice(){
		return price;
	}
	public synchronized void addVetoableChangeListener(VetoableChangeListener l) {
		veto.addVetoableChangeListener(l);
	}
	public synchronized void removeVetoableChangeListener(VetoableChangeListener l) {
		veto.removeVetoableChangeListener(l);
	}
	
	public Purchase(String string, String string2, double d) {
		setProd(string);
		setData(string2);
		price = d;
	}
	@Override
	public String toString() {
	  return getClass().getSimpleName() + " [prod="+prod+", data="+data+", price="+price+"]";
	}
}
