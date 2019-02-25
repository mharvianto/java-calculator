import java.awt.Font;

import javax.swing.JLabel;

public class Display extends JLabel {
	
	public Display() {
		super("0");
		this.setHorizontalAlignment(JLabel.RIGHT);
		this.setFont(new Font("Arial", Font.PLAIN, 30));
	}
	
	public void clear(){
		this.setText("0");
	}
	
	public double getValue(){
		return Double.parseDouble(this.getText());
	}
}
