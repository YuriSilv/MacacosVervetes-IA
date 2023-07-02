package Sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static BufferedImage spriteSheet;
	public static BufferedImage player;
	public static BufferedImage tigre;
	public static BufferedImage cobra;
	public static BufferedImage aguia;
	public static BufferedImage floor;
	
	public SpriteSheet() {
		try {
			spriteSheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		player = SpriteSheet.getSprite(0, 0, 32, 32);
		tigre = SpriteSheet.getSprite(32, 0, 32, 32);
		cobra = SpriteSheet.getSprite(96, 0, 32, 32);
		aguia = SpriteSheet.getSprite(64, 0, 32, 32);
		floor = SpriteSheet.getSprite(0, 32, 32, 32);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x, y, width, height);
	}
	
}
