import org.hl.engine.math.lalg.Vector3f;

public class Plane extends BackgroundObject {
	public Plane() throws Exception {
		super("resources/plane/plane.mesh", new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1));
	}
}
