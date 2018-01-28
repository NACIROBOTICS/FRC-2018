/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team2935.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//DRIVETRAIN
	public static final int DRIVE_LEFT_MOTOR1 = 1;
	public static final int DRIVE_LEFT_MOTOR2 = 2;
	public static final int DRIVE_LEFT_MOTOR3 = 3;
	public static final int DRIVE_RIGHT_MOTOR1 = 6;
	public static final int DRIVE_RIGHT_MOTOR2 = 7;
	public static final int DRIVE_RIGHT_MOTOR3= 8;
	
	//SOLENOIDS
	public static final int SOLENOID_SHIFTER_HIGH = 0;
	public static final int SOLENOID_SHIFTER_LOW = 1;
	
	//USB ports for joy-sticks
	public static final int DRIVE_CONTROLLER = 0;
		
}
