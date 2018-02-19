package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;

public class AutoIntakeCube extends Command {
	
	double timeout;
	
    public AutoIntakeCube(double timeout) {
       requires(Robot.intakeSubsystem);
       this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intakeSubsystem.runIntake(-0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timeSinceInitialized() >= timeout){return true;}
        return false;}

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
