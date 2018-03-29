package team2935.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;				


public class ArmMoveCommand extends Command {

    public ArmMoveCommand() {    	
    	requires(Robot.armSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    protected void execute() {
    	boolean armUp = Robot.m_oi.getArmUp();
    	boolean armDown = Robot.m_oi.getArmDown();
    	if(armUp){
    		Robot.armSubsystem.runArmDown(0.6);
    	}else if(armDown){
    		Robot.armSubsystem.runArmUp(1);
    	}else{
    		Robot.armSubsystem.runArmDown(0);
    		Robot.armSubsystem.runArmUp(0);
    	} 	
    }
    protected boolean isFinished() {return false;}
    
    protected void end() {}
    
    protected void interrupted() {}
}
