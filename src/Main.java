import org.hl.engine.graphics.Renderer;
import org.hl.engine.graphics.Shader;
import org.hl.engine.io.Display;
import org.hl.engine.io.Input;
import org.hl.engine.math.lalg.Vector3f;
import org.hl.engine.objects.FirstPersonCamera;
import org.hl.engine.objects.GameObject;
import org.hl.engine.objects.TopDownCamera;
import org.lwjgl.glfw.GLFW;

class Main implements Game {

	/* Private Variables */


	// Display
	public Display display;
	public int WIDTH = 1280;
	public int HEIGHT = 760;
	public String windowName = "Asteroids";
	public float fov = 70;
	public float near = 0.1f;
	public float far = 1000f;

	// Camera
	TopDownCamera camera = new TopDownCamera(new Vector3f(0, 30, 0));

	// Debugging
	FirstPersonCamera debugCamera = new FirstPersonCamera(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), 0.2f, 0.15f);

	// Shader
	public Shader shader;

	// Renderer
	public Renderer renderer;

	// Input
	public Input i;

	// Objects
	public Ship ship;
	public Plane plane;

	// Stars
	public StarWhite[] starw = new StarWhite[30];
	public StarYellow[] stary = new StarYellow[30];

	/* Private Variables */


	public static void main(String[] args) throws Exception {
		new Main().run();
	}


	Main() throws Exception {
	}

	@Override
	public void setup() throws Exception {

		// Initializing the display
		display = new Display(WIDTH, HEIGHT, windowName, fov, near, far);
		display.create();

		// Initializing the shader
		shader = new Shader(Shader.VERTEXSHADER, Shader.FRAGSHADER);

		// Intializing renderer
		renderer = new Renderer(display, shader);

		// Background color
		display.setBackgroundColor(0f, 0f, 0f);

		// Setting up input
		i = new Input(display);

		// Creating objects
		ship = new Ship(i);
		ship.create();
		plane = new Plane();
		plane.create();
		for (int i = 0; i < stary.length; i ++) {
			stary[i] = new StarYellow();
			stary[i].create();
		}
		for (int i = 0; i < starw.length; i ++) {
			starw[i] = new StarWhite();
			starw[i].create();
		}

		// Creating the shader
		shader.create();

		// Creating debugging camera
		debugCamera.create(i);



	}

	@Override
	public void loop() throws Exception {


		// Updating the display
		int frames = display.update();
		/*
		if (i.keyPress(GLFW.GLFW_KEY_ESCAPE)) {
			display.shouldClose();
		}


		if (display.isLocked()) {
			debugCamera.standardKeybindUpdate();
		}
		if (i.buttonPress(GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
			display.mouseState(true);
		} else if (i.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) {
			display.mouseState(false);
		}

		renderer.renderMesh(ship, debugCamera);
		renderer.renderMesh(plane, debugCamera);
		for (StarYellow s : stary) {
			renderer.renderMesh(s, debugCamera);
		}
		for (StarWhite s : starw) {
			renderer.renderMesh(s, debugCamera);
		}

		 */
		renderer.renderMesh(ship, camera);
		renderer.renderMesh(plane, camera);
		for (StarYellow s : stary) {
			renderer.renderMesh(s, camera);
		}
		for (StarWhite s : starw) {
			renderer.renderMesh(s, camera);
		}

		ship.update();

		// Resetting the display
		display.reset();

		// Resetting the input
		i.reset();

	}

	@Override
	public void close() throws Exception {
		display.destroy();
		shader.destroy();
		ship.destroy();
		plane.destroy();
		for (StarYellow s : stary) {
			s.destroy();
		}
		for (StarWhite s : starw) {
			s.destroy();
		}

	}

	@Override
	public void run() throws Exception {

		setup();
		while (!display.shouldClose()) {
			loop();
		}

		close();

	}
}