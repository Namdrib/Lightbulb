public class LightController
{
	public enum State {
		OFF,
		ON,
		DIM
	};
	
	public Gui display;
	private State state;
	private int numTicks;
	
	public void connect(Gui display)
	{
		this.display = display;
	}
	
	public void init()
	{
		setStates(0, State.OFF, "img/off.jpg");
	}
	
	public void press()
	{
		setStates(0, State.ON, "img/on.jpg");
	}
	
	private void setStates(int numTicks, State state, String img)
	{
		this.numTicks = numTicks;
		this.state = state;
		display.setLightbulb(img);
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
					setStates(0, State.DIM, "img/dim.png");
				}
				break;
			case DIM:
				if (numTicks >= 2)
				{
					setStates(0, State.OFF, "img/off.jpg");
				}
				break;
			default:
				System.out.println("What the fuck");
		}
	}
}
