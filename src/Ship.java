import org.hl.engine.io.Input;
import org.hl.engine.math.lalg.Vector3f;
import org.hl.engine.objects.GameObject;

public class Ship extends MovableObject {
	public Ship(Input i) throws Exception {
		super("resources/ship/ship.mesh", new Vector3f(0, 3, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), i);
	}
}
