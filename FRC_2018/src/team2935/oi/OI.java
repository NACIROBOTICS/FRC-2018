/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team2935.oi;

import com.torontocodingcollective.oi.TAxis;
import com.torontocodingcollective.oi.TButton;
import com.torontocodingcollective.oi.TGameController_Logitech;
import com.torontocodingcollective.oi.TStick;
import com.torontocodingcollective.oi.TTrigger;

import edu.wpi.first.wpilibj.DriverStation;
import team2935.robot.Robot;
import team2935.robot.RobotMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public TGameController_Logitech driverController;

	public OI() {
		driverController = new TGameController_Logitech(RobotMap.DRIVE_CONTROLLER);
	}
	public char getSwitchSide() {
		return DriverStation.getInstance().getGameSpecificMessage().charAt(0);
	}
	public char getScaleSide() {
		return DriverStation.getInstance().getGameSpecificMessage().charAt(1);
	}
	public char getOppSwitchSide() {
		return DriverStation.getInstance().getGameSpecificMessage().charAt(2);
	}
	// tank
	public double getLeftDriveSpeed() {
		return driverController.getAxis(TStick.RIGHT, TAxis.Y); //NOT MISTAKE DONT CHANGE
	}

	public double getRightDriveSpeed() {
		return driverController.getAxis(TStick.LEFT, TAxis.Y);//NOT MISTAKE DONT CHANGE
	}

	// arcade
	public double getFowardDriveSpeed() {
		return driverController.getAxis(TStick.LEFT, TAxis.Y);
	}

	public double getTurnDriveSpeed() {
		return -driverController.getAxis(TStick.LEFT, TAxis.X); //NOT MISTAKE DONT CHANGE
	}

	public boolean getDriveMode() {
		return driverController.getButton(TButton.Y);
	}

	public boolean getArmUp() {
		return driverController.getButton(TTrigger.LEFT);
	}

	public boolean getArmDown() {
		return driverController.getButton(TTrigger.RIGHT);
	}

	public boolean getIntakeIn() {
		return driverController.getButton(TButton.RIGHT_BUMPER);
	}

	public boolean getIntakeOut() {
		return driverController.getButton(TButton.LEFT_BUMPER);
	}

	public boolean getSpinIntake() {
		return driverController.getButton(TButton.A);
	}

	public boolean getOpenIntake() {return (getIntakeOut() && getIntakeIn());}

	public boolean isLeftShifter() {
		return driverController.getButton(TStick.LEFT);
	}

	public boolean isRightShifter() {
		return driverController.getButton(TStick.RIGHT);
	}
	public boolean getTankShift() {
		return (isLeftShifter() && isRightShifter());
	}
	public boolean getArcadeShift() {
		return isLeftShifter();
	}
	public void updateSmartDashboard() {
		Robot.chassisSubsystem.updatePeriodic();
		Robot.armSubsystem.updatePeriodic();
		Robot.intakeSubsystem.updatePeriodic();
	}

}
