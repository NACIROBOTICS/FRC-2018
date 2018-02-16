package team2935.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;


public class IntakeWheelsCommand extends Command {
 
//     enum IntakeState { OPEN, CLOSED };
//	 public IntakeState Intake = IntakeState.CLOSED;
	   
     public IntakeWheelsCommand() {    	
    	requires(Robot.intakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    protected void execute() {    	
    	// buttons for intake wheels
       	boolean IntakeIn = Robot.m_oi.getIntakeIn();
    	boolean IntakeOut = Robot.m_oi.getIntakeOut();
    	
    	if(IntakeIn && IntakeOut) {
    		Robot.intakeSubsystem.closeIntake();	
      	}else { 
            Robot.intakeSubsystem.openIntake();
            }
    	
    	if(!IntakeOut && IntakeIn){
    		Robot.intakeSubsystem.runIntake(0.5);
    	}else if(IntakeOut){
    		Robot.intakeSubsystem.runIntake(-0.5);
    	}else{
    		Robot.intakeSubsystem.runIntake(0);
    	} 	
    	
    	
    	
    	
    	
    	
    }
    
    protected boolean isFinished() {return false;}
    
    protected void end() {}
    
    protected void interrupted() {}
}
