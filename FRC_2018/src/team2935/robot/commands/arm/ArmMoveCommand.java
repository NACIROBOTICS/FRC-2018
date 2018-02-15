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
    	boolean ArmUp = Robot.m_oi.getArmUp();
    	boolean ArmDown = Robot.m_oi.getArmDown();
    	if(ArmUp){
    		Robot.armSubsystem.runArm(0.5);
    	}else if(ArmDown){
    		Robot.armSubsystem.runArm(-0.5);
    	}else{
    		Robot.armSubsystem.runArm(0);
    	} 	
    }
    protected boolean isFinished() {return false;}
    
    protected void end() {}
    
    protected void interrupted() {}
}
