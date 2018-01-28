package team2935.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;

public class GameControllerDriveCommand extends Command {

	public GameControllerDriveCommand() {
		requires(Robot.chassisSubsystem);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}
	
	protected void execute() {
		double leftSpeed = Robot.m_oi.getLeftDriveSpeed();
		double rightSpeed = Robot.m_oi.getRightDriveSpeed();
		
	    Robot.chassisSubsystem.setLeftMotorSpeeds(leftSpeed);
	    Robot.chassisSubsystem.setRightMotorSpeeds(rightSpeed);
				
	}
	
	protected boolean isFinished() {
		return false;
	}
	// Called once after isFinished returns true
	
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	
	protected void interrupted() {
	}
}
