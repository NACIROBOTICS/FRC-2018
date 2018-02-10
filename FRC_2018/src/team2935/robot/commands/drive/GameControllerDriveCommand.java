package team2935.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;


public class GameControllerDriveCommand extends Command {
	
	public GameControllerDriveCommand() {requires(Robot.chassisSubsystem);}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {}
	int i=1;
	boolean tank = true;
	boolean Shifted = false;
	protected void execute() {

		boolean DriveMode = Robot.m_oi.getDriveMode();
        boolean isShifted = Robot.m_oi.isShifting();
		if(DriveMode && !tank) {
			i++;
			tank=true;
		}
		else if(!DriveMode && tank)
			tank= false;
		
        //tank
		double leftSpeed = Robot.m_oi.getLeftDriveSpeed();
		double rightSpeed = Robot.m_oi.getRightDriveSpeed();
		
		//arcade
		double FowardSpeed = Robot.m_oi.getFowardDriveSpeed();
		double TurnSpeed = Robot.m_oi.getTurnDriveSpeed();
		
		
		
		if(isShifted && !Shifted) 
		{
			Robot.chassisSubsystem.setShifter();
			Shifted = true;
		}
		else if (!isShifted && Shifted) Shifted = false;
		

		//if(FowardSpeed > 0.90 || rightSpeed > 0.90 && leftSpeed > 0.90 ) 
		//	Robot.chassisSubsystem.shiftHigh();
	    //  else 
		//	Robot.chassisSubsystem.shiftLow();
		
		if(i%2==0) {
				   Robot.chassisSubsystem.setLeftMotorSpeeds(FowardSpeed- TurnSpeed);
				   Robot.chassisSubsystem.setRightMotorSpeeds(FowardSpeed+ TurnSpeed);	  
	    }
		else {
		       Robot.chassisSubsystem.setRightMotorSpeeds(rightSpeed);
			   Robot.chassisSubsystem.setLeftMotorSpeeds(leftSpeed); 
		}
		
}
		
	
	
	protected boolean isFinished() {return false;}
	
	protected void end() {}

	protected void interrupted() {}
}
