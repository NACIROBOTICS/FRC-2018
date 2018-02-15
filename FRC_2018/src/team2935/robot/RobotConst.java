package team2935.robot;

public class RobotConst {
	//Robot Properties
	public static final double MAX_FINAL_SHOOTER_SPEED = 0;
	public static final double MAX_LOW_DRIVE_SPEED = 5;//feet per second
	public static final double MAX_LOW_TURN_SPEED = 2.1;//feet per second
	public static final double MAX_HIGH_DRIVE_SPEED = 12;//feet per second
	public static final double MAX_HIGH_TURN_SPEED = 2.1;//feet per second
	public static final double DRIVE_ENCODER_COUNTS_PER_FT = 789.8;
	public static final double MAX_DRIVE_ENCODER_SPEED = 4850;
	public static final double DRIVE_LOW_SHIFT_THRESHOLD = 10;
	public static final double DRIVE_HIGH_SHIFT_THRESHOLD = 6;
	
	//Drive PID Control Variables
	public static final double DRIVE_LOW_PID_P = 0.18;
	public static final double DRIVE_LOW_PID_D = 0.14;
	public static final double DRIVE_HIGH_PID_P = 0.14;
	public static final double DRIVE_HIGH_PID_D = 0.25;

	public static final double DRIVE_PID_POWER_DROP = 0;
	
	//Gyro PID Control Variables
	public static final double GYRO_PID_P = 0.15;	
	public static final double GYRO_PID_D = 0.1;
	
	//Controller threshold
	public static final double CONTROLLER_DRIVE_THRESHOLD = 0.1;
	public static final double CONTROLLER_TURN_THRESHOLD = 0.1;	
}
