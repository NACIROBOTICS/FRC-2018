package team2935.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.toronto.subsystems.T_Subsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import team2935.robot.RobotMap;
import team2935.robot.commands.arm.ArmMoveCommand;



public class ArmSubsystem extends T_Subsystem
{
	private WPI_TalonSRX armMotor1 = new WPI_TalonSRX(RobotMap.ARM_MOTOR1);
	private DigitalInput limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH);
    public void initDefaultCommand() {setDefaultCommand(new ArmMoveCommand());}

	public void robotInit() {}
	
	public void runArmDown(double speed)
	{
	
		if(!limitSwitch.get()) {
			armMotor1.set(-speed);
		}
		else{
			armMotor1.set(speed);
		}
		
	}
	public void runArmUp(double speed){
		armMotor1.set(null, speed);	
	}
	
	public void updatePeriodic() {}
}

