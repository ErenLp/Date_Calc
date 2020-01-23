import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pan extends JPanel{
	JButton conf;
	JLabel info,cdate,resdate,res,load;
	JComboBox <String>cb1;
	JComboBox <String>cb2;
	JComboBox <String>cb3;
	JComboBox <String>cb11;
	JComboBox <String>cb22;
	JComboBox <String>cb33;
	JComboBox <String>cbHour;
	JComboBox <String>cbMin;
	String month="",day="",year="",hours="",hour,min,sec,hourRb="",minRb="";
	SimpleDateFormat formatter;
	JLabel specific;
	JRadioButton rb1,rb2,rb3;
	int w=20,flag=0,x=0;
	int r=0,g=165,b=0;
	public Pan() {
		conf=new JButton("Confirm");
		this.setLayout(null);
		String[] cb1Items=new String[13];
		cb1Items[0]="";
		for(int i=1;i<13;i++) {
			String t=Integer.toString(i);
			cb1Items[i]=t;
		}
		cb1=new JComboBox<String>(cb1Items);
		String []cb2Items=new String[32];
		for(int i=1;i<32;i++) {
			String t=Integer.toString(i);
			cb2Items[i]=t;
		}
		cb2Items[0]="";
		String []cb3Items=new String[73];
		int a=72;
		for(int i=1950;i<2022;i++) {
			String t=Integer.toString(i);
			cb3Items[a--]=t;
		}
		cb3Items[0]="";
		cb3=new JComboBox<String>(cb3Items);
		cb2=new JComboBox<String>(cb2Items);
		cb1.setBounds(100, 150,100,50);
		this.add(cb1);
		cb2.setBounds(220, 150, 100, 50);
		this.add(cb2);
		cb3.setBounds(340, 150, 100, 50);
		this.add(cb3);
		conf.setBounds(250, 250, 150, 40);
		this.add(conf);
		cb1.setVisible(false);cb2.setVisible(false);cb3.setVisible(false);
		info=new JLabel("   Months                Days                Years");
		info.setFont(new Font("SansSerif",Font.PLAIN,17));
		info.setForeground(Color.GREEN);
		info.setBounds(100, 100, 400,50);
		info.setVisible(true);
		this.add(info);
		Date d=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM");  
		String monthd=formatter.format(d);
		formatter=new SimpleDateFormat("dd");
		String dayd=formatter.format(d); 
		formatter=new SimpleDateFormat("yyyy");
		String yeard=formatter.format(d); 
		specific=new JLabel();
		specific.setBounds(170, 70, 200, 50);
		specific.setFont(new Font("Arial",Font.BOLD,22));
		this.add(specific);

		Timer tim=new Timer(1000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date ad=new Date();
				SimpleDateFormat formatter=new SimpleDateFormat("HH");
				hour=formatter.format(ad); 
				formatter=new SimpleDateFormat("mm");
				min=formatter.format(ad); 
				formatter=new SimpleDateFormat("ss");
				sec=formatter.format(ad); 
				specific.setText("    "+hour+" : "+min+" : "+sec);
				specific.setFont(new Font("SerifSan",Font.ITALIC,30));
				int r=(int)(Math.random()*255+1);
				int g=(int)(Math.random()*255+1);
				int b=(int)(Math.random()*255+1);
				specific.setForeground(new Color(r,g,b));				
			}
		});
		tim.start();
		cdate=new JLabel("Current Date - "+ monthd+"/"+dayd+"/"+yeard);
		cdate.setFont(new Font("Arial",Font.TYPE1_FONT,26));
		cdate.setForeground(Color.YELLOW);
		cdate.setBounds(125, 10, 400, 50);
		this.add(cdate);
		resdate=new JLabel();
		resdate.setForeground(Color.red);
		resdate.setFont(new Font("Arial",Font.BOLD,21));
		resdate.setBounds(125, 350, 400, 50);
		this.add(resdate);
		res=new JLabel();
		res.setForeground(Color.blue);
		res.setFont(new Font("Arial",Font.BOLD,21));
		res.setBounds(125, 400, 400, 50);
		this.add(res);
		cb1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==1) {
					month="";
					month+=arg0.getItem();
				}
			}
		});
		cb2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==1) {
					day="";
					day+=arg0.getItem();
				}
			}
			
		});
		cb3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==1) {
					year="";
					year+=arg0.getItem();
				}
			}
			
		});
		conf.setFont(new Font("SansSerif",Font.BOLD,14));
		
		cb11=new JComboBox<String>(cb1Items);
		cb22=new JComboBox<String>(cb2Items);
		cb33=new JComboBox<String>(cb3Items);
		this.add(cb11);	this.add(cb22);	this.add(cb33);
		rb1=new JRadioButton("From now to date entered");
		rb1.setBounds(0, 250,200, 25);

		
		this.add(rb1);		
		rb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rb2.isSelected()==true||rb3.isSelected()==true)
				{
					rb2.setSelected(false);
					rb3.setSelected(false);
				}
				cb1.setBounds(100, 150,100,50);
				cb2.setBounds(220, 150,100,50);
				cb3.setBounds(340, 150,100,50);
				cb1.setVisible(true);
				cb2.setVisible(true);
				cb3.setVisible(true);
				cbHour.setVisible(false);
				cbMin.setVisible(false);
				cb11.setVisible(false);
				cb22.setVisible(false);
				cb33.setVisible(false);
				info.setText("   Months                Days                Years");
				conf.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("IN");
						if(month!=""&&day!=""&&year!="") {
							int yeardd=Integer.parseInt(yeard);
							int yearr=Integer.parseInt(year);
							int monthdd=Integer.parseInt(monthd);
							int monthh=Integer.parseInt(month);
							int daydd=Integer.parseInt(dayd);
							int dayy=Integer.parseInt(day);
							int diff;
							if((yeardd-yearr)<0) 
								yearr=(yeardd-yearr)*-1;								
							else
								yearr=yeardd-yearr;
							System.out.println((monthdd-monthh));
							if((monthdd-monthh)<0) {
								
								yearr-=1;
								System.out.println(yearr);
								monthh=12+(monthdd-monthh);
							}
							else 
								monthh=monthdd-monthh;
							if((daydd-dayy)<0) {
								monthh-=1;
								dayy=30+(daydd-dayy);
							}
							else 
								dayy=daydd-dayy;
							System.out.println("2.."+yearr);
							diff=yearr*365+monthh*30+dayy;
							System.out.println("3.."+yearr);
							resdate.setText(Integer.toString(diff)+" days.");
							res.setText(yearr+" year(s)    "+monthh+" month(s)    "+dayy+" day(s)");
							}
							else 
								resdate.setText("Please select a date...");		
						
					}
					
				});		
			}			
		});			
		
		rb2=new JRadioButton("Date entered to another date");
		rb2.setBounds(0, 270,200, 25);
		this.add(rb2);
		
		rb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rb1.isSelected()==true||rb3.isSelected()==true)
				{
					rb1.setSelected(false);
					rb3.setSelected(false);
				}
				if(rb2.isSelected()) {
					cb11.setVisible(true);
					cb22.setVisible(true);
					cb33.setVisible(true);
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cbHour.setVisible(false);
					cbMin.setVisible(false);
					cb1.setBounds(100, 150,100,25);
					cb2.setBounds(220, 150,100,25);
					cb3.setBounds(340, 150,100,25);
					cb11.setBounds(100, 200,100,25);
					cb22.setBounds(220, 200,100,25);
					cb33.setBounds(340, 200,100,25);
					rb2.setSelected(true);
					info.setText("   Months                Days                Years");
					conf.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(month!=""&&day!=""&&year!=""&&cb33.getSelectedItem().toString()!=""&&cb11.getSelectedItem().toString()!=""&&cb22.getSelectedItem().toString()!="") {
								int yeardd=Integer.parseInt(cb33.getSelectedItem().toString());
								int yearr=Integer.parseInt(year);
								int monthdd=Integer.parseInt(cb11.getSelectedItem().toString());
								int monthh=Integer.parseInt(month);
								int daydd=Integer.parseInt(cb22.getSelectedItem().toString());
								int dayy=Integer.parseInt(day);
								int diff;
								if((yeardd-yearr)<0) 
									yearr=(yeardd-yearr)*-1;								
								else
									yearr=yeardd-yearr;
								if((monthdd-monthh)<0) {
									yearr-=1;
									monthh=12+(monthdd-monthh);
								}
								else 
									monthh=monthdd-monthh;
								if((daydd-dayy)<0) {
									monthh-=1;
									dayy=30+(daydd-dayy);
								}
								else 
									dayy=daydd-dayy;
								diff=yearr*365+monthh*30+dayy;
								resdate.setText(Integer.toString(diff)+" days.");
								res.setText(yearr+" year(s)    "+monthh+" month(s)    "+dayy+" day(s)");
								}
								else 
									resdate.setText("Please select a date...");		
							
						}
						
					});
				}
			}			
		});			
		
		rb3=new JRadioButton("Hour difference");
		rb3.setBounds(0, 290,200, 25);
		this.add(rb3);
		String[] cbHourItems=new String[25];
		String[] cbMinItems=new String[61];
		for(int i=0;i<25;i++) {
			cbHourItems[i]=Integer.toString(i);
		}
		for(int i=0;i<61;i++) {
			cbMinItems[i]=Integer.toString(i);
		}
		cbHour=new JComboBox<String>(cbHourItems);
		cbMin=new JComboBox<String>(cbMinItems);
		this.add(cbHour);this.add(cbMin);
		rb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rb1.isSelected()==true||rb2.isSelected()==true)
				{
					rb2.setSelected(false);
					rb1.setSelected(false);
				}					
				cb1.setVisible(false);
				cb2.setVisible(false);
				cb3.setVisible(false);
				cb11.setVisible(false);
				cb22.setVisible(false);
				cb33.setVisible(false);
				cbMin.setVisible(true);
				cbHour.setVisible(true);
				info.setText("   Hours                Mins");
				cbHour.setBounds(100, 150,100,50);
				cbMin.setBounds(225, 150, 100, 50);
				conf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hourRb=cbHour.getSelectedItem().toString();
						minRb=cbMin.getSelectedItem().toString();
						int hourDiff=Integer.parseInt(hourRb)-Integer.parseInt(hour);
						int minDiff=Integer.parseInt(minRb)-Integer.parseInt(min);
						if(hourDiff<0&&minDiff>0) {
							hourDiff*=-1;
						}
						if(hourDiff<0&&minDiff<0) {
							hourDiff*=-1;
							hourDiff-=1;
							minDiff=Integer.parseInt(min)-Integer.parseInt(minRb);
						}
						if(minDiff<0) {
							minDiff=60-Integer.parseInt(min)+Integer.parseInt(minRb);
							hourDiff-=1;
						}
						res.setText(hourDiff+"     hour(s)     "+minDiff+" minute(s)");
					}
				});
			}
		});
		rb1.setBackground(Color.cyan);
		rb2.setBackground(Color.cyan);
		rb3.setBackground(Color.cyan);
	}
}

