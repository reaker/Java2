/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */

package zad3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBackground implements ActionListener {

	protected JTextArea handler;

	/**
	 * @param handler
	 */
	public ListenerBackground(JTextArea handler) {
		this.handler = handler;
	}

	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		MyIcon icon = (MyIcon) item.getIcon();
		handler.setBackground(icon.getColor());
	}
}