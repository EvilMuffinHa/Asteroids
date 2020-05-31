import org.hl.engine.io.Input;
import org.hl.engine.math.lalg.Vector2f;
import org.hl.engine.math.lalg.Vector3f;
import org.hl.engine.objects.GameObject;
import org.lwjgl.glfw.GLFW;

public class MovableObject extends GameObject {

	// Taking input

	private Input i;



	public MovableObject(String meshFileName, Vector3f position, Vector3f rotation, Vector3f scale, Input i) throws Exception {
		super(meshFileName, position, rotation, scale);
		this.i = i;
	}

	public void update() {
		Vector3f objectRotation = getRotation();
		Vector3f objectPosition = getPosition();

		float rotY = objectRotation.getY();
		Vector2f position = new Vector2f((float)Math.cos(Math.toRadians(rotY)), (float)-Math.sin(Math.toRadians(rotY)));

		float speed = 5;

		if (i.isKeyDown(GLFW.GLFW_KEY_W)) {
			setPosition(Vector3f.add(objectPosition, new Vector3f(position.getX() / speed, 0, position.getY() / speed)));
		}
		if (i.isKeyDown(GLFW.GLFW_KEY_A)) {
			setRotation(Vector3f.add(objectRotation, new Vector3f(0, speed, 0)));
		}
		if (i.isKeyDown(GLFW.GLFW_KEY_D)) {
			setRotation(Vector3f.sub(objectRotation, new Vector3f(0, speed, 0)));
		}

		float xDist = 30;
		float zDist = 18;

		if (objectPosition.getX() > xDist) {
			setPosition(Vector3f.sub(objectPosition, new Vector3f(xDist*2, 0, 0)));
		}


		if (objectPosition.getX() < -xDist) {
			setPosition(Vector3f.add(objectPosition, new Vector3f(xDist*2, 0, 0)));
		}


		if (objectPosition.getZ() > zDist) {
			setPosition(Vector3f.sub(objectPosition, new Vector3f(0, 0, zDist*2)));
		}


		if (objectPosition.getZ() < -zDist) {
			setPosition(Vector3f.add(objectPosition, new Vector3f(0, 0, zDist*2)));
		}


		i.reset();
	}

}
