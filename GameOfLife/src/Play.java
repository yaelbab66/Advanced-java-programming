import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Play {
	private final int MATRIX_SIZE = 10;
	private LifeMatrix m;
	
	public Play(){
		int play;
		m = new LifeMatrix(MATRIX_SIZE);
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel p = new MyPanel();
		p.setWidth(m.getWidth());
		p.setHeight(m.getHeight());
		p.buildMatrix(frame, p, m);
		play = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
		while(play == 0){
			m.buildNextLife();
			p.buildMatrix(frame, p, m);
			
			play = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
			
		}
	}
	
	
}
