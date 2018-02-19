package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import team2935.PID.GyroPIDController;
import team2935.robot.Robot;

public class TurnToAngle extends Command {
	private double targetAngle;
	private double timeout;
	private GyroPIDController pidController = new GyroPIDController(0.2);
	
    public TurnToAngle(double targetAngle, double timeout) {
        requires(Robot.chassisSubsystem);
        this.targetAngle = targetAngle;
        this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pidController.adjustAngle(targetAngle, Robot.chassisSubsystem.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timeSinceInitialized() > timeout){ return true; }
        
        return (!(Robot.chassisSubsystem.getAngle() < targetAngle-2) && !(Robot.chassisSubsystem.getAngle() > targetAngle+2));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassisSubsystem.setAllMotorSpeeds(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
