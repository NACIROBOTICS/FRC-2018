package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;

/**
 *
 */
public class AutoRaiseArm extends Command {
   
	double Timeout;
	
    public AutoRaiseArm(double Timeout) {
       requires(Robot.armSubsystem);
       this.Timeout = Timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.armSubsystem.runArmUp(0.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timeSinceInitialized()>Timeout) {return true;}
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
