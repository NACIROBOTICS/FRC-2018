package team2935.oi;

import edu.wpi.first.wpilibj.Joystick;

public class GameController{
	protected Joystick joystick;
	private int port;
	
	public GameController(int port){
		this.port = port;
		joystick = new Joystick(this.port);
	}
	public double getAxis_LeftX(){return 0.0;}
	public double getAxis_LeftY(){return 0.0;}
	public double getAxis_RightX(){return 0.0;}
	public double getAxis_RightY(){return 0.0;}
	public double getAxis_LeftTrigger(){return 0.0;}
	public double getAxis_RightTrigger(){return 0.0;}
	
	public boolean getButton_A(){return false;}
	public boolean getButton_B(){return false;}
	public boolean getButton_X(){return false;}
	public boolean getButton_Y(){return false;}
	public boolean getButton_LeftTrigger(){return false;}
	public boolean getButton_RightTrigger(){return false;}
	public boolean getButton_LeftBumper(){return false;}
	public boolean getButton_RightBumper(){return false;}
	public boolean getButton_Start(){return false;}
	public boolean getButton_Back(){return false;}
}
