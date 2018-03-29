package team2935.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import team2935.robot.Robot;

public class IntakeWheelsCommand extends Command {

	// enum IntakeState { OPEN, CLOSED };
	// public IntakeState Intake = IntakeState.CLOSED;

	public IntakeWheelsCommand() {
		requires(Robot.intakeSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	protected void execute() {
		// buttons for intake wheels
		boolean spinIntake = Robot.m_oi.getSpinIntake();
		boolean intakeIn = Robot.m_oi.getIntakeIn();
		boolean intakeOut = Robot.m_oi.getIntakeOut();
		boolean openIntake = Robot.m_oi.getOpenIntake();
		boolean autoPickUp = Robot.m_oi.getCubePickUp();
		boolean CubeDected = Robot.intakeSubsystem.cubeDected();		
		if (openIntake) {
			Robot.intakeSubsystem.openIntake();
		} else {
			Robot.intakeSubsystem.closeIntake();
		}
		if(openIntake) {
			Robot.intakeSubsystem.runIntake(-0.50);
		}else if (intakeOut) {
			Robot.intakeSubsystem.runIntake(1);
		}  else if (spinIntake) {
			Robot.intakeSubsystem.spinCube(1);
		}else if(autoPickUp&&!CubeDected) {
	    	Robot.intakeSubsystem.runIntake(-0.5);
	    	Robot.intakeSubsystem.openIntake();
	    }else if (intakeIn) {
			Robot.intakeSubsystem.runIntake(-0.5);
		}else if(CubeDected) {
			Robot.intakeSubsystem.runIntake(0);
	    	Robot.intakeSubsystem.closeIntake();
		} else {
			Robot.intakeSubsystem.runIntake(0);
		}
		
       
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
