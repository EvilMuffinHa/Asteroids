import org.hl.engine.graphics.Mesh;
import org.hl.engine.math.lalg.Vector3f;
import org.hl.engine.objects.GameObject;

public class BackgroundObject extends GameObject {

	public BackgroundObject(String meshFileName, Vector3f position, Vector3f rotation, Vector3f scale) throws Exception {
		super(meshFileName, position, rotation, scale);
	}

	public BackgroundObject(String meshFileName, String texturePath, Vector3f position, Vector3f rotation, Vector3f scale) throws Exception {
		super(meshFileName, texturePath, position, rotation, scale);
	}

	@Override
	public void setPosition(Vector3f position) {
		System.err.println("You cannot move an immovable object! ");
		System.exit(1);
	}

	@Override
	public void setRotation(Vector3f rotation) {
		System.err.println("You cannot move an immovable object! ");
		System.exit(1);
	}

	@Override
	public void setScale(Vector3f scale) {
		System.err.println("You cannot move an immovable object! ");
		System.exit(1);
	}
}
