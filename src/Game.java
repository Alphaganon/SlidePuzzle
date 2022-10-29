import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Game {
	
	public final int dimension = 400;
	
	public static final int cols = 4, rows = 4, nbTiles = cols * rows - 1;
	
	private Tile[] tiles = new Tile[cols * rows];
	
	private Tile blankTile;
	
	public int blankPos = nbTiles;
	
	public static BufferedImage img;
	
	public Window window;

	public Game() {
		try {
			img = ImageIO.read(new File("./src/resource/Alphaganon.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < nbTiles; i++) {
			tiles[i] = new Tile(i, img);
		}
		blankTile = new Tile(nbTiles, img);
		tiles[nbTiles] = blankTile;
		shuffle(tiles);
		while(!solvable()) {
			shuffle(tiles);
		}
		window = new Window(dimension+15, dimension+35, tiles, img);
		window.addMouseListener(new MouseInput(this));
		
	}
	
	void shuffle(Tile[] a) {
	    Random random = new Random();
	    int n = nbTiles;
	    while(n>1) {
	    	int i = random.nextInt(n--);
	    	Tile tmp = tiles[i];
	    	tiles[i] = tiles[n];
	    	tiles[n] = tmp;
	    }
	}
	
	private boolean solvable() {
		int inv = 0;
		for(int i = 0; i < nbTiles; i++) {
			for(int j = 0; j < i; j++) {
				if(tiles[j].index < tiles[i].index) {
					inv++;
				}
			}
		}
		return inv%2 == 1;
	}
	
	public void swap(int i, int j) {
		Tile tmp = tiles[i];
		tiles[i] = tiles[j];
		tiles[i].index = i;
		tiles[j] = tmp;
		tiles[j].index = j;
	}

	public boolean isSolved() {
		for (Tile tile : tiles) {
			if(tile.initialIndex != tile.index) return false;
		}
		return true;
	}
	
	
	public static void main(String args[]) {
		new Game();
	}

}
