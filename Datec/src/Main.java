import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class Main {
	static ImageIcon img;
	static Pan p=new Pan();
	static JFrame f=new JFrame("Date Calculator");
	static Date d;
	static SimpleDateFormat std;
	static JMenu m =new JMenu("File");
	static JMenuBar mb=new JMenuBar();
	static JMenuItem mi1=new JMenuItem("Exit");
	static JMenuItem mi2=new JMenuItem("New");
	static JLabel l;

	public static void main(String args[]) throws MalformedURLException {
		setup(f);
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame nf=new JFrame("Date Calculator");
					try {
						setup(nf);
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}		
			}			
		});		
	}
	public static void setup(JFrame f) throws MalformedURLException {
		mi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fi=new JFrame();
				JPanel p2=new JPanel();
				p2.setLayout(null);
				JLabel li=new JLabel( "Are you sure you want to quit?");
				JButton con=new JButton("Yes");
				li.setBounds(50,0, 200, 50);
				con.setBounds(75,70, 100, 25);
				p2.add(li);p2.add(con);
				fi.add(p2);
				fi.setVisible(true);
				fi.setLocationRelativeTo(null);
				fi.setSize(270,150);
				con.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						fi.setVisible(false);
						f.setVisible(false);
						f.dispose();
					}
				});
				
			}
		});		
		m.add(mi2);m.add(mi1);
		mb.add(m);
		f.setJMenuBar(mb);
		d=new Date();
		std=new SimpleDateFormat("HH");
		int hour=Integer.parseInt(std.format(d));
		Load la=new Load();
		p.add(la);
		URL url;
		if(hour>17||hour<6) 
			url=new URL("https://i.ibb.co/TTVfWst/skr.png");
		else 
			url=new URL("https://i.ibb.co/z68svcc/day.png");	
		img=new ImageIcon(url);
		l=new JLabel(img);
		p.add(l);
		l.setBounds(0, 0, 550, 500);
		f.add(p);
		f.setSize(550,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
	}

}
