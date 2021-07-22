
import java.awt.Graphics;
import java.util.Random;

public class Firework {
	public static final int GRAVITY = 1;
	Spark[] sparks;
	public boolean dead = false;

	public Firework() {
		sparks = new Spark[100];

		for (int i = 0; i < sparks.length; i++) {
			sparks[i] = new Spark(50, 50);
		}
	}

	public void launch() {

		for (int i = 0; i < sparks.length; i++) {
			sparks[i].x = 800;
			sparks[i].y = 800;
		}
	}

	public void updateSparks() {

		for (int i = 0; i < sparks.length; i++) {

			Spark s = sparks[i];
			s.x += s.xVelocity;
			s.y += s.yVelocity;
			s.yVelocity += GRAVITY;

			if (s.yVelocity >= 0 && !s.fire) {
				Random r = new Random();
				s.xVelocity = r.nextInt(40) - 20;
				s.yVelocity += -r.nextInt(10) - 5;
				s.size = r.nextInt(7) + 2;
				s.fire = true;
			}

			if (s.y >= FireworkDisplay.HEIGHT) {
				s.dead = true;
			}
		}

		for (int i = 0; i < sparks.length; i++) {
			if (!sparks[i].dead) {
				dead = false;
				break;
			}
			dead = true;
		}
	}

	public void drawSparks(Graphics g) {

		for (int i = 0; i < sparks.length; i++) {
			g.setColor(sparks[i].color);
			g.fillOval(sparks[i].x, sparks[i].y, sparks[i].size, sparks[i].size);
		}
	}
}
