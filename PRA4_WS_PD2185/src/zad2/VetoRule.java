package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class VetoRule implements VetoableChangeListener {

	@Override
	public void vetoableChange(PropertyChangeEvent arg0) throws PropertyVetoException {
		// TODO Auto-generated method stub
		if(arg0.getPropertyName().equals("price")&&(Double)arg0.getNewValue()<1000.0)
			throw new PropertyVetoException("Price change to: "+(Double)arg0.getNewValue()+" not allowed", arg0);
	}

}
