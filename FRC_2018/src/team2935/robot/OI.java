/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team2935.robot;

import com.toronto.oi.T_Trigger;
import com.torontocodingcollective.oi.TAxis;
import com.torontocodingcollective.oi.TButton;
import com.torontocodingcollective.oi.TGameController_Logitech;
import com.torontocodingcollective.oi.TStick;
import com.torontocodingcollective.oi.TTrigger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public TGameController_Logitech driverController;
	public OI(){driverController = new TGameController_Logitech(RobotMap.DRIVE_CONTROLLER);}
	//tank
	public double getLeftDriveSpeed(){return driverController.getAxis(TStick.LEFT, TAxis.Y);}
	public double getRightDriveSpeed(){return driverController.getAxis(TStick.RIGHT, TAxis.Y);}
	//arcade
	public double getFowardDriveSpeed(){return driverController.getAxis(TStick.LEFT, TAxis.Y);}
	public double getTurnDriveSpeed(){return driverController.getAxis(TStick.LEFT, TAxis.X);}
	
	public boolean getDriveMode(){return driverController.getButton(TButton.Y);}
	
	public boolean getArmUp(){return driverController.getButton(TButton.B);}
	
	public boolean getArmDown(){return driverController.getButton(TButton.A);}
	
	public boolean getIntakeIn() {return driverController.getButton(TButton.LEFT_BUMPER);}
	
	public boolean getIntakeOut() {return driverController.getButton(TButton.RIGHT_BUMPER);	}
	
	public boolean isShifting() {return driverController.getButton(TButton.X);}
	
	public boolean OpenIntake() {return driverController.getButton(TStick.LEFT);}

	public boolean closeIntake() {return driverController.getButton(TButton.NINE);}

	
	 public void updateSmartDashboard(){
		 SmartDashboard.putString("driverController",driverController.toString());
		 Robot.chassisSubsystem.updatePeriodic();
		 Robot.armSubsystem.updatePeriodic();
		 Robot.intakeSubsystem.updatePeriodic();
		 SmartDashboard.putNumber("RightTicks", Robot.chassisSubsystem.getRightEncoderDistance());
		 SmartDashboard.putNumber("LeftTicks", Robot.chassisSubsystem.getLeftEncoderDistance());
		 SmartDashboard.putNumber("Angle",Robot.chassisSubsystem.getAngle());
 }
	
	
}
	
	