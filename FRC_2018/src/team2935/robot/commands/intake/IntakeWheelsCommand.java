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
    	boolean IntakeOpen = false;
    	//opens Itake
    	boolean openIntake = Robot.m_oi.OpenIntake();
    	// buttons for intake wheels
       	boolean IntakeIn = Robot.m_oi.getIntakeIn();
    	boolean IntakeOut = Robot.m_oi.getIntakeOut();
    	
    	if(IntakeIn){
    		Robot.intakeSubsystem.runIntake(0.5);
    	}else if(IntakeOut){
    		Robot.intakeSubsystem.runIntake(-0.5);
    	}else{
    		Robot.intakeSubsystem.runIntake(0);
    	} 	
    	
    	
    	if(openIntake && !IntakeOpen) {
    		Robot.intakeSubsystem.openIntake();	
    		IntakeOpen=true;
    	}else if(openIntake && IntakeOpen) {
            Robot.intakeSubsystem.closeIntake();
            IntakeOpen=false;

    	}
    }
    
    protected boolean isFinished() {return false;}
    
    protected void end() {}
    
    protected void interrupted() {}
}
