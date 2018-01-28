/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team2935.robot;

import com.torontocodingcollective.oi.TAxis;
import com.torontocodingcollective.oi.TGameController_Logitech;
import com.torontocodingcollective.oi.TStick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public TGameController_Logitech driverController;
	//public AutoSelector autoSelector;
	public OI(){
		//autoSelector = new AutoSelector();
		driverController = new TGameController_Logitech(RobotMap.DRIVE_CONTROLLER);
	}
	/*public boolean isDriverAction() {
		 return driverController.isControllerActivated();
	} */
	public double getLeftDriveSpeed(){
	    return driverController.getAxis(TStick.LEFT, TAxis.Y);
	}
	public double getRightDriveSpeed(){
	    return driverController.getAxis(TStick.RIGHT, TAxis.Y);
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	//Joystick stick = new Joystick(0);
	// Button button = new JoystickButton(stick, 1);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
