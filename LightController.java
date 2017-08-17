
public class LightController
{
	public enum State {
		OFF,
		ON,
		DIM
	};
	
	public Gui display;
	State state;
	int numTicks;
	
	public void connect(Gui display)
	{
		this.display = display;
	}
	
	public void init()
	{
		numTicks = 0;
		state = State.OFF;
		display.setLightbulb("img/off.jpg");
	}
	
	public void press()
	{
		numTicks = 0;
		state = State.ON;
		display.setLightbulb("img/on.jpg");
	}


	public void tick()
	{
		numTicks++;
		System.out.print("\t\r" + numTicks + " ticks");
		switch(state)
		{
			case OFF:
				break;
			case ON:
				if (numTicks >= 5)
				{
					state = State.DIM;
					numTicks = 0;
					display.setLightbulb("img/dim.png");
				}
				break;
			case DIM:
				if (numTicks >= 2)
				{
					state = State.OFF;
					numTicks = 0;
					display.setLightbulb("img/off.jpg");
				}
				break;
			default:
				System.out.println("What the fuck");
		}
	}
}
