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
	boolean Shifted = false;
	protected void execute() {
        double leftEncoder = Robot.chassisSubsystem.getLeftEncoderDistance();
        double rightEncoder = Robot.chassisSubsystem.getRightEncoderDistance();
        
		boolean DriveMode = Robot.m_oi.getDriveMode();
        boolean isShifted = Robot.m_oi.isShifting();
        boolean IsShifted = Robot.m_oi.IsShifting();
		if(DriveMode && !tank) {
			i++;
			tank=true;
		}
		else if(!DriveMode && tank)
			tank= false;
		//System.out.print(ChassisSubsystem.getLeftEncoderDistance());
        //tank
		double leftSpeed = Robot.m_oi.getLeftDriveSpeed();
		double rightSpeed = Robot.m_oi.getRightDriveSpeed();
		
		//arcade
		double FowardSpeed = Robot.m_oi.getFowardDriveSpeed();
		double TurnSpeed = Robot.m_oi.getTurnDriveSpeed()*0.75;
		
		
		
		if(isShifted && IsShifted) 
		{
			Robot.chassisSubsystem.shiftHigh();
			
		}
		else Robot.chassisSubsystem.shiftLow();
		

		//if(FowardSpeed > 0.90 || rightSpeed > 0.90 && leftSpeed > 0.90 ) 
		//	Robot.chassisSubsystem.shiftHigh();
	    //  else 
		//	Robot.chassisSubsystem.shiftLow();
		/**/
		
		/**/
		if(i%2==0) 
		{
			if(rightEncoder>leftEncoder&&!(TurnSpeed>0.1 && TurnSpeed<-0.1)) 
			{
				Robot.chassisSubsystem.setRightMotorSpeeds(FowardSpeed*0.96+ TurnSpeed);
			    Robot.chassisSubsystem.setLeftMotorSpeeds(FowardSpeed- TurnSpeed);
			    Robot.chassisSubsystem.resetEncoders();
		    }
			else if(leftEncoder>rightEncoder&&!(TurnSpeed>0.1 && TurnSpeed<-0.1)) 
			{
				Robot.chassisSubsystem.setLeftMotorSpeeds(FowardSpeed*0.96- TurnSpeed);
			    Robot.chassisSubsystem.setRightMotorSpeeds(FowardSpeed+ TurnSpeed);
			    Robot.chassisSubsystem.resetEncoders();
		    }
			else 
			{
		   Robot.chassisSubsystem.setLeftMotorSpeeds(FowardSpeed-TurnSpeed);
	       Robot.chassisSubsystem.setRightMotorSpeeds(FowardSpeed+TurnSpeed);
	       Robot.chassisSubsystem.resetEncoders();
	        }
			
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
