import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Load extends JLabel{
	int w=0;
	Load(){
		this.setBounds(170, 70, 230, 50);
		Timer t=new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
			
		});
		t.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(w>230)
			w=0;
		g.setColor(new Color(230,21,104));
		g.fill3DRect(0, 0, w++, 50, true);

	}
}
