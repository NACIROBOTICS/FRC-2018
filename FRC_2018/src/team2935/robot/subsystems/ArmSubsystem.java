package team2935.robot.subsystems;

import com.toronto.subsystems.T_Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import team2935.robot.RobotMap;
import team2935.robot.commands.arm.ArmMoveCommand;



public class ArmSubsystem extends T_Subsystem
{
	private VictorSP ArmMotor1 = new VictorSP(RobotMap.ARM_MOTOR1);
	private VictorSP ArmMotor2 = new VictorSP(RobotMap.ARM_MOTOR2);

    public void initDefaultCommand() {setDefaultCommand(new ArmMoveCommand());}

	public void robotInit() {}
	
	public void runArm(double speed)
	{
		ArmMotor1.set(speed);
		ArmMotor2.set(speed);
	}
	public void updatePeriodic() {}
}

