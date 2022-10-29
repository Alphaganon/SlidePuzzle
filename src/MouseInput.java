import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
	
	private Game game;
	private boolean solved = false;
	
	public MouseInput(Game game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!solved) {
			int index = 0;
			if (!(e.getX() < 0 || e.getX() > game.dimension || e.getY() < 0 || e.getY() > game.dimension)) {
				index = (e.getY() - 35) / 100 * 4 + (e.getX() - 15) / 100;
			}
			if (Math.abs(game.blankPos - index) == 1 || Math.abs(game.blankPos - index) == 4) {
				game.swap(index, game.blankPos);
				game.blankPos = index;
			}
			game.window.redraw();
			if (game.isSolved()) {
				game.window.drawFullImage();
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

}
