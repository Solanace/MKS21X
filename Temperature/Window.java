import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    private Container frame;

    private JButton toC;
    private JButton toF;
    private JTextField displayTemp;

    public Window() {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	toC = new JButton("to Celsius");
	toF = new JButton("to Fahrenheit");
