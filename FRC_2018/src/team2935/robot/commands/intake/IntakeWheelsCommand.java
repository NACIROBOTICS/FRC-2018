package team2935.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;				


public class IntakeWheelsCommand extends Command {

    public IntakeWheelsCommand() {    	
    	requires(Robot.intakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    protected void execute() {
    	boolean openIntake = Robot.m_oi.OpenIntake();
    //	boolean closeIntake = Robot.m_oi.closeIntake();
    	boolean IntakeIn = Robot.m_oi.getIntakeIn();
    	boolean IntakeOut = Robot.m_oi.getIntakeOut();
    	if(IntakeIn){
    		Robot.intakeSubsystem.runIntake(1);
    	}else if(IntakeOut){
    		Robot.intakeSubsystem.runIntake(-0.5);
    	}else{
    		Robot.intakeSubsystem.runIntake(0);
    	} 	
    	if(!openIntake) {
    		Robot.intakeSubsystem.openIntake();	
    	}
    	else if(openIntake)
    		Robot.intakeSubsystem.closeIntake();
    }
    protected boolean isFinished() {return false;}
    
    protected void end() {}
    
    protected void interrupted() {}
}
