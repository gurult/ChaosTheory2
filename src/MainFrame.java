import java.awt.BorderLayout;
import javax.swing.JFrame;


public class MainFrame extends JFrame {
		
	private static final long serialVersionUID = 1L;
	
	private final int WIN_WIDTH = 450;
	private final int WIN_HEIGHT = 550;
	
	private DrawPanel drawPanel; 
	
	public MainFrame(){
		
		// Initialization
		
		super("Chaos Theory 2");
		setSize(WIN_WIDTH, WIN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		// init draw panel
		
		drawPanel = new DrawPanel();
		drawPanel.setSize(700, 500);
		// layout manager
		
		//setLayout(new BorderLayout());
		//add(drawPanel, BorderLayout.CENTER);
		add(drawPanel);
		// 
	}
}
