package team2935.oi;

import team2935.oi.GameController;

public class GameController_F310 extends GameController{

	public GameController_F310(int port) {
		super(port);
	}
	@Override
	public double getAxis_LeftX() {
		return super.joystick.getRawAxis(0);
	}
	@Override
	public double getAxis_LeftY(){
		return -super.joystick.getRawAxis(1);
	}
	@Override
	public double getAxis_RightX() {
		return super.joystick.getRawAxis(4);
	}
	@Override
	public double getAxis_RightY() {
		return -super.joystick.getRawAxis(5);
	}
	@Override
	public double getAxis_LeftTrigger() {
		return super.joystick.getRawAxis(2);
	}
	@Override
	public double getAxis_RightTrigger() {
		return super.joystick.getRawAxis(3);
	}
	@Override
	public boolean getButton_A(){
		if(super.joystick.getRawButton(1))
			return true;
		return false;
	}
	@Override
	public boolean getButton_B(){
		if(super.joystick.getRawButton(2))
			return true;
		return false;
	}
	@Override
	public boolean getButton_X(){
		if(super.joystick.getRawButton(3))
			return true;
		return false;
	}
	@Override
	public boolean getButton_Y(){
		if(super.joystick.getRawButton(4))
			return true;
		return false;
	}
	@Override
	public boolean getButton_LeftBumper(){
		if(super.joystick.getRawButton(5))
			return true;
		return false;
	}
	@Override
	public boolean getButton_RightBumper(){
		if(super.joystick.getRawButton(6))
			return true;
		return false;
	}
	@Override
	public boolean getButton_Start() {
		return super.joystick.getRawButton(7);
	}
	@Override
	public boolean getButton_Back() {
		return super.joystick.getRawButton(8);
	}
	
}
