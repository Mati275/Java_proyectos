package visuals;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;

public class SubJPanel extends JPanel{

	public SubJPanel() {
		super();
	}
	
	
	/**
	 * Gets its preferredSize in relation with the width and height of the object if it has a parent container
	 * @param multWidth
	 * @param multHeight
	 * @return
	 */
	
    public Dimension getPreferredSize( double multWidth, double multHeight ) {
        Container parent = getParent();
        if (parent != null) {
            // Ejemplo: 50% del ancho, 20% del alto
            int w = (int) (parent.getBounds().getWidth() * multWidth);
            int h = (int) (parent.getBounds().getHeight() * multHeight);
            return new Dimension(w, h);
        }
        return super.getPreferredSize();
    }
	
}
