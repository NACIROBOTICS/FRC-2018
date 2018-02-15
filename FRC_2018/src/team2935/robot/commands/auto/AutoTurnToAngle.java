package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;

/**
 *
 */


public class AutoTurnToAngle extends Command {
	private double targetAngle;

    public AutoTurnToAngle(double targetAngle) {
    	requires(Robot.chassisSubsystem);
    	 this.targetAngle = targetAngle;
    	 
    }

    // Called just before this Command runs the first time
    protected void initialize() {Robot.chassisSubsystem.resetGyro();}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(targetAngle>180) {
    	Robot.chassisSubsystem.setLeftMotorSpeeds(0.5);
    	Robot.chassisSubsystem.setRightMotorSpeeds(-0.5);
    	}
    	else if(targetAngle<180) {
    		Robot.chassisSubsystem.setLeftMotorSpeeds(-0.5);
        	Robot.chassisSubsystem.setRightMotorSpeeds(0.5);
    		
    	}
     }
    
    	
    
    	
    

    // Make this return true when this Command no longer needs to run execute()
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
