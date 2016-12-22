import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window extends JFrame implements ActionListener{
    private Container pane;
    private JTextField displayTemp;
    
    public Window() {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	JButton toC = new JButton("to Celsius");
	toC.addActionListener(this);
	toC.setActionCommand("toC");
	
	JButton toF = new JButton("to Fahrenheit");
	toF.addActionListener(this);
	toF.setActionCommand("toF");
	
        displayTemp = new JTextField("100", 12);

	pane.add(toC);
	pane.add(toF);
	pane.add(displayTemp);
    }

    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();
	
	if (event.equals("toC")) {
	    double c = Double.parseDouble(displayTemp.getText());
	    c = Temperature.toC(c);
	    displayTemp.setText("" + c);
	}
	
	if (event.equals("toF")) {
	    double f = Double.parseDouble(displayTemp.getText());
	    f = Temperature.toF(f);
	    displayTemp.setText("" + f);
	}
    }

    public static void main(String[] args) {
	Window g = new Window();
	g.setVisible(true);
    }
}
