package team2935.robot.subsystems;

import com.toronto.subsystems.T_Subsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import team2935.robot.RobotMap;
import team2935.robot.commands.arm.ArmMoveCommand;



public class ArmSubsystem extends T_Subsystem
{
	private VictorSP armMotor1 = new VictorSP(RobotMap.ARM_MOTOR1);
	private DigitalInput limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH);
    public void initDefaultCommand() {setDefaultCommand(new ArmMoveCommand());}

	public void robotInit() {}
	
	public void runArmDown(double speed)
	{
		if(!limitSwitch.get()) {
			armMotor1.set(-speed);
		}
	}
	public void runArmUp(double speed){
		armMotor1.set(speed);	
	}
	
	public void updatePeriodic() {}
}

