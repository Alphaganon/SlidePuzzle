import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Window extends JFrame{

	private static final long serialVersionUID = -8249750416507306783L;
	public JPanel panel = new JPanel();
	public Tile[] tiles;

	public BufferedImage fullImage;
	
	public Window(int width, int height, Tile[] tiles, BufferedImage img) {
		super("Slide Puzzle");
		this.tiles = tiles;
		this.fullImage = img;
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		panel.setLayout(new GridLayout(4, 4));
		
		for(Tile tile : tiles) {
				panel.add(tile);
		}
		this.setContentPane(panel);
	}
	
	public void redraw() {
		panel.removeAll();
		for(Tile tile : tiles) {
			panel.add(tile);
		}
		revalidate();
		repaint();
	}

	public void drawFullImage() {
		panel.removeAll();
		panel.setLayout(new GridLayout(1, 1));
		JLabel imgLabel = new JLabel(new ImageIcon(fullImage));
		panel.add(imgLabel);
		panel.revalidate();
		panel.repaint();
	}
}
