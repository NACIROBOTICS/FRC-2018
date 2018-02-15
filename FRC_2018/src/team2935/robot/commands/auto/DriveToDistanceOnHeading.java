
package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;
import team2935.robot.RobotConst;

public class DriveToDistanceOnHeading extends Command {
	private double encoderDistance;
	private double setSpeed;
	private double timeout;
	private double targetAngle = -1;
	
    public DriveToDistanceOnHeading(double distance, double speed, double timeout) {
        requires(Robot.chassisSubsystem);
        this.encoderDistance = Math.abs(distance) * RobotConst.DRIVE_ENCODER_COUNTS_PER_FT;
        this.setSpeed        = speed;
        this.timeout         = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.resetEncoders();
    	Robot.chassisSubsystem.resetGyro();
    	targetAngle = Robot.chassisSubsystem.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassisSubsystem.setAllMotorSpeeds(setSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	// Check for a timeout before the distance
    	if (timeSinceInitialized() > timeout) { return true; }
    	
    	return Math.abs(Robot.chassisSubsystem.getEncoderDistance()) >= encoderDistance;
    }

	@Override
	protected void end() {
		Robot.chassisSubsystem.setAllMotorSpeeds(0);
	}

	@Override
	protected void interrupted() {}
}
