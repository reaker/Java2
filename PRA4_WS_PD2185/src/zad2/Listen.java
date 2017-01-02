package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Listen implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Change value of: "+arg0.getPropertyName()+" from: "+arg0.getOldValue()+" to: "+arg0.getNewValue());
	}

}
