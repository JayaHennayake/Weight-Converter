package kilossubscriber;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import kilospublisher.KilogramsCalculator;
import kilospublisher.KilogramsConverter;

@SuppressWarnings("serial")
public class KilogramsDisplay extends JFrame{
	
	private KilogramsConverter converter;
	
	private JPanel panel;
	private JLabel lable, type, inL;
	
	@SuppressWarnings("rawtypes")
	private JComboBox box;
	private JTextField in, out;
	private JButton convertBtn;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					KilogramsDisplay display = new KilogramsDisplay();
					display.setVisible(true);
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public KilogramsDisplay() throws HeadlessException {
		converter =  new KilogramsCalculator();
		setResizable(false);
		setTitle("Weight Converter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(180, 150, 650, 500);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		panel.setVisible(true);
		
		lable = new JLabel("Kilograms Converter");
		lable.setFont(new Font("Algerian", Font.BOLD, 30));
		lable.setBounds(140, 25, 380, 50);
		lable.setForeground(Color.darkGray);
		panel.add(lable);
		
		box = new JComboBox();
		box.setFont(new Font("Arial Nova", Font.PLAIN, 15));
		box.setBounds(250, 100, 180, 40);
		box.setBackground(Color.WHITE);
		
		box.addItem("Kilograms to Pounds");
		box.addItem("Kilograms to Stones");
		box.addItem("Kilograms to Grams");
		box.addItem("Kilograms to Ounce");
		
		panel.add(box);
		
		in = new JTextField();
		in.setHorizontalAlignment(SwingConstants.CENTER);
		in.setFont(new Font("Arial Nova", Font.PLAIN, 15));
		in.setBounds(250, 180, 180, 40);
		panel.add(in);
		
		convertBtn = new JButton("Convert ");
		convertBtn.setFont(new Font("Arial Nova", Font.PLAIN, 20));
		convertBtn.setBounds(150, 250, 150, 50);
		convertBtn.setBackground(Color.white);
		convertBtn.setBorder(new LineBorder(Color.blue, 2));
		panel.add(convertBtn);
		
		out = new JTextField();
		out.setHorizontalAlignment(SwingConstants.CENTER);
		out.setFont(new Font("Arial Nova", Font.PLAIN, 15));
		out.setBounds(250, 350, 180, 50);
		out.setEditable(isDisplayable());
		out.setBackground(Color.white);
		panel.add(out);
		
		type = new JLabel("Select Convert Type :");
		type.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		type.setBounds(90, 95, 400, 50);
		type.setForeground(Color.black);
		panel.add(type);
		
		inL = new JLabel("Enter Your Value :");
		inL.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		inL.setBounds(90, 175, 400, 50);
		inL.setForeground(Color.black);
		panel.add(inL);
		
		convertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = in.getText();
				String unit = String.valueOf(box.getSelectedItem());
				String output = "";
				
				if (input.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);
					
				} else {
					try {
						float val = Float.parseFloat(input);
						if (unit.equalsIgnoreCase("Kilograms to Pounds")) {
							output = String.valueOf(converter.KilogramsToPounds(val));
							
						}else if(unit.equalsIgnoreCase("Kilograms to Stones")){
							output = String.valueOf(converter.KilogramsToStones(val));
							
						}else if(unit.equalsIgnoreCase("Kilograms to Grams")){
							output = String.valueOf(converter.KilogramsToGrams(val));
							
						}else {
							output = String.valueOf(converter.KilogramsToOunce(val));
							
						}
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Please Enter Numbers", "Empty Field Alert", JOptionPane.OK_OPTION);
					}
				}
				
				out.setText(output);
			}
		});
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Arial Nova", Font.PLAIN, 20));
		clearBtn.setBounds(360, 250, 150, 50);
		clearBtn.setBackground(Color.white);
		clearBtn.setBorder(new LineBorder(Color.red, 2));
		panel.add(clearBtn);
		
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				in.setText("");
				out.setText("");
			}
		});
	}
	
}
