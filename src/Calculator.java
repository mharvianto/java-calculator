import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements MouseListener {
	
	JButton btn[] = new JButton[]{
			new JButton("AC"),
			new JButton("sqrt"),
			new JButton("%"),
			new JButton("x^2"),
			new JButton("7"),
			new JButton("8"),
			new JButton("9"),
			new JButton("÷"),
			new JButton("4"),
			new JButton("5"),
			new JButton("6"),
			new JButton("x"),
			new JButton("1"),
			new JButton("2"),
			new JButton("3"),
			new JButton("-"),
			new JButton("0"),
			new JButton("."),
			new JButton("="),
			new JButton("+")
	};
	Display display = new Display();
	
	JPanel buttonPanel = new JPanel();
	
	double old = 0;
	String op = null;
	
	public Calculator() {
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		buttonPanel.setLayout(new GridLayout(5, 4));
		for (int i = 0; i < btn.length; i++) {
			btn[i].setFont(new Font("Arial", Font.PLAIN, 20));
			btn[i].addMouseListener(this);
			buttonPanel.add(btn[i]);
		}
		add(buttonPanel);
		
		
		add(display, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// type cast () / convert type data
		JButton btn = (JButton)e.getSource();
		//JOptionPane.showMessageDialog(this, "Click " + btn.getText());
		if(isOperand(btn)){ // operand
			clickOperand(btn);
		}else if(btn.getText().equals("sqrt")){ // unary operation
			double temp = Double.parseDouble(display.getText());
			display.setText("" + Math.sqrt(temp));
		}else if(btn.getText().equals("%")){ // unary operation
			double temp = Double.parseDouble(display.getText());
			display.setText("" + (temp / 100));
		}else if(btn.getText().equals("x^2")){ // unary operation
			double temp = Double.parseDouble(display.getText());
			display.setText("" + (temp * temp));
		}else if(btn.getText().equals("+") || btn.getText().equals("-") || btn.getText().equals("x") 
				|| btn.getText().equals("÷")){ // binary operation
			old = Double.parseDouble(display.getText());
			op = btn.getText();
			display.setText("0");
		}else if(btn.getText().equals("=")){
			double temp = Double.parseDouble(display.getText());
			double result = 0;
			if(op.equals("+")){
				result = old + temp;
			}else if(op.equals("-")){
				result = old - temp;
			}else if(op.equals("x")){
				result = old * temp;
			}else if(op.equals("÷")){
				result = old / temp;
			}
			old = temp;
			display.setText("" + result);
		}else if(btn.getText().equals("AC")){
			old = 0;
			op = null;
			display.setText("0");
		}
	}

	private boolean isOperand(JButton btn) {
		return btn.getText().equals("0") || btn.getText().equals("1") || btn.getText().equals("2") 
				|| btn.getText().equals("3") || btn.getText().equals("4") || btn.getText().equals("5")
				|| btn.getText().equals("6") || btn.getText().equals("7") || btn.getText().equals("8")
				|| btn.getText().equals("9") || btn.getText().equals(".");
	}

	private void clickOperand(JButton btn) {
		if(display.getText().equals("0")){
			display.setText(btn.getText());
		}else{
			if(!(btn.getText().equals(".") && display.getText().contains("."))){
				display.setText(display.getText() + btn.getText());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
