package team2935.robot.subsystems;

import com.toronto.subsystems.T_Subsystem;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
//import edu.wpi.first.wpilibj.command.Subsystem;
import team2935.robot.RobotMap;
import team2935.robot.commands.intake.IntakeWheelsCommand;

/**
 *
 */
public class IntakeSubsystem extends  T_Subsystem {

	private VictorSP intakeMotor1 = new VictorSP(RobotMap.INTAKE_MOTOR1);
	private VictorSP intakeMotor2 = new VictorSP(RobotMap.INTAKE_MOTOR2);
	private Solenoid intakeOpen = new Solenoid(RobotMap.SOLENOID_INTAKE_CLOSE);
	private Solenoid intakeClose = new Solenoid(RobotMap.SOLENOID_INTAKE_OPEN);

    public void initDefaultCommand() {setDefaultCommand(new IntakeWheelsCommand());}
    @Override
	public void robotInit() {}
    
    public void runIntake(double speed)
	{
		intakeMotor1.set(speed);
		intakeMotor2.set(-speed);
	}
    public void spinCube(double speed) 
    {
    	intakeMotor1.set(speed);
		intakeMotor2.set(speed);	
    }
    public void openIntake() {
		intakeOpen.set(true);
		intakeClose.set(false);
	}
	public void closeIntake() {
		intakeOpen.set(false);
		intakeClose.set(true);
	}
    
    
    
	@Override
	public void updatePeriodic() {}
}

