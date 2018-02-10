package team2935.robot.subsystems;
import com.toronto.subsystems.T_Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import team2935.robot.RobotMap;
import team2935.robot.commands.drive.GameControllerDriveCommand;


public class ChassisSubsystem extends T_Subsystem{
	//Definition of the motors used on the drive_train subsystem
		private VictorSP leftMotor1 = new VictorSP(RobotMap.DRIVE_LEFT_MOTOR1);
		private VictorSP leftMotor2 = new VictorSP(RobotMap.DRIVE_LEFT_MOTOR2);
		private VictorSP leftMotor3 = new VictorSP(RobotMap.DRIVE_LEFT_MOTOR3);
		private VictorSP rightMotor1 = new VictorSP(RobotMap.DRIVE_RIGHT_MOTOR1);
		private VictorSP rightMotor2 = new VictorSP(RobotMap.DRIVE_RIGHT_MOTOR2);
		private VictorSP rightMotor3 = new VictorSP(RobotMap.DRIVE_RIGHT_MOTOR3);
		private Solenoid shifterHigh = new Solenoid(RobotMap.SOLENOID_SHIFTER_HIGH);
		private Solenoid shifterLow = new Solenoid(RobotMap.SOLENOID_SHIFTER_LOW);
		//encoders
		public Encoder leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A,  RobotMap.LEFT_ENCODER_B);
		public Encoder rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A,RobotMap.RIGHT_ENCODER_B  ,true);
		
		
	
		public enum States {HIGH,LOW};
		
		private States shifterState = States.LOW;
		
		//Gives left encoder values
		public double getLeftEncoderDistance(){return leftEncoder.getDistance();}
		//Gives right encoder values
		public double getRightEncoderDistance(){return rightEncoder.getDistance();}
		
		public void initDefaultCommand() {setDefaultCommand(new GameControllerDriveCommand());}
		
		public void robotInit(){		
			rightMotor1.setInverted(true);
			rightMotor2.setInverted(true);
			rightMotor3.setInverted(true);
			resetEncoders();
		} 
		
		public void setLeftMotorSpeeds(double speed){
			leftMotor1.set(speed);
			leftMotor2.set(speed);
			leftMotor3.set(speed);
		}
		public void setRightMotorSpeeds(double speed){
			rightMotor1.set(speed);
			rightMotor2.set(speed);
			rightMotor3.set(speed);
		}		
		
		public void resetEncoders(){
			leftEncoder.reset();
			rightEncoder.reset();
		}
		
		public void setShifter() {
			if(shifterState.equals(States.LOW)) {
				shiftHigh();
				shifterState = States.HIGH;
			}else if(shifterState.equals(States.HIGH)){
				shiftLow();
				shifterState = States.LOW;
			}
		}
		public void shiftHigh() {
			shifterHigh.set(true);
			shifterLow.set(false);
		}
		public void shiftLow() {
			shifterHigh.set(false);
			shifterLow.set(true);
		}
		public void updatePeriodic() {
		}

}
