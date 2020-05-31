import org.hl.engine.math.lalg.Vector3f;

public class Star extends BackgroundObject {

	public Star(String meshFileName, String texturePath) throws Exception {
		super(meshFileName, texturePath, new Vector3f((float)Math.random()*80 - 40, 0, (float)Math.random()*80 - 40), new Vector3f(0, 0, 0), new Vector3f(0.2f, 0.2f, 0.2f));
	}
}
