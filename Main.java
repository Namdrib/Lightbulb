import java.util.Timer;
import java.util.TimerTask;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		LightController controller = new LightController();
		Gui display = new Gui();

		// Connect the components together
		display.connect(controller);
		controller.connect(display);

		// Initalise the components
		display.init();
		controller.init();

		Timer t = new Timer();
		Ticker ticker = new Ticker(controller);
		t.scheduleAtFixedRate(ticker, 0, 1000);
	}

	private static class Ticker extends TimerTask
	{
		LightController controller;

		public Ticker(LightController controller)
		{
			this.controller = controller;
		}

		public void run()
		{
			controller.tick();
		}
	}
}
