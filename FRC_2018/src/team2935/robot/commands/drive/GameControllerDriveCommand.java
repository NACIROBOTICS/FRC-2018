package team2935.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;
import team2935.robot.subsystems.ChassisSubsystem;


public class GameControllerDriveCommand extends Command {

	public GameControllerDriveCommand() {requires(Robot.chassisSubsystem);}
	
	// Called just before this Command runs the first time
	@Override	
	protected void initialize() {}
	int i=1;
	boolean tank = true;
	boolean isShifted = false;
	protected void execute() {
        double leftEncoder = Robot.chassisSubsystem.getLeftEncoderDistance();
        double rightEncoder = Robot.chassisSubsystem.getRightEncoderDistance();
        
		boolean driveMode = Robot.m_oi.getDriveMode();
        boolean leftShifter = Robot.m_oi.isLeftShifter();
        boolean rightShifter = Robot.m_oi.isRightShifter();
		if(driveMode && !tank) {
			i++;
			tank=true;
		}
		else if(!driveMode && tank) {
			tank= false;
		}
        //tank
		double leftSpeed = Robot.m_oi.getLeftDriveSpeed();
		double rightSpeed = Robot.m_oi.getRightDriveSpeed();
		
		//arcade
		double fowardSpeed = Robot.m_oi.getFowardDriveSpeed();
		double turnSpeed = Robot.m_oi.getTurnDriveSpeed()*0.75;
		
		
		
		if(leftShifter && rightShifter) {Robot.chassisSubsystem.shiftHigh();}
		else {Robot.chassisSubsystem.shiftLow();}
		

		//if(FowardSpeed > 0.90 || rightSpeed > 0.90 && leftSpeed > 0.90 ) 
		//	Robot.chassisSubsystem.shiftHigh();
	    //  else 
		//	Robot.chassisSubsystem.shiftLow();
		
		if(i%2==0) 
		{
			if(rightEncoder>leftEncoder&&!(turnSpeed>0.1 || turnSpeed<-0.1)) {
			    Robot.chassisSubsystem.setDifferentMotorSpeeds(fowardSpeed- turnSpeed, fowardSpeed*0.96+ turnSpeed);
		    } else if(leftEncoder>rightEncoder&&!(turnSpeed>0.1 || turnSpeed<-0.1)) {
			    Robot.chassisSubsystem.setDifferentMotorSpeeds(fowardSpeed*0.96- turnSpeed, fowardSpeed+ turnSpeed);
		    } else {
		       Robot.chassisSubsystem.setDifferentMotorSpeeds(fowardSpeed-turnSpeed, fowardSpeed+turnSpeed);
	        }
			Robot.chassisSubsystem.resetEncoders();
			
		}
		else { Robot.chassisSubsystem.setDifferentMotorSpeeds(leftSpeed, rightSpeed);}
		
	}
	protected boolean isFinished() {return false;}
	
	protected void end() {}

	protected void interrupted() {}
}
