import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Tile extends JPanel{

	private static final long serialVersionUID = -8612199927815970580L;
	
	BufferedImage image;
	
	public int col, row, index, initialIndex;
	
	public Tile(int index, BufferedImage img) {
		super();
		this.index = index;
		this.initialIndex = index;
		this.col = index / Game.cols;
		this.row = index % Game.rows;
		if(index != Game.nbTiles) {
			image = img.getSubimage(row*100, col*100, 100, 100);
		}		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
		g.drawRect(0, 0, 100, 100);
	}
	
	
	
}
