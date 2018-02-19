package team2935.PID;

import team2935.robot.Robot;
import team2935.robot.RobotConst;

public class GyroPIDController {
	private double setSpeed;
	
	public GyroPIDController(double speed){
		setSpeed = speed;
	}
	private double calcPValue(double error){
		return error * RobotConst.GYRO_PID_P;
	}
	private double calcDValue(double error){
		return error * RobotConst.GYRO_PID_D;
	}
	public void adjustAngle(double targetAngle, double currentAngle){
		double angleError = targetAngle - currentAngle;
    	
    	if (angleError > 180.0)  { angleError -= 360.0; }
    	if (angleError < -180.0) { angleError += 360.0; }
    	
		double leftSpeed  = setSpeed;
		double rightSpeed = setSpeed;

		// Slow down one motor based on the error.
		if (angleError > 0) {
    		rightSpeed -= calcPValue(angleError);
    		if (rightSpeed < -setSpeed) {
    			 rightSpeed = -setSpeed;
    		}
    	}
    	else {
    		leftSpeed -=  -calcPValue(angleError);
    		if (leftSpeed < -setSpeed) {
    			leftSpeed = -setSpeed;
    		}
    	}
		Robot.chassisSubsystem.setDifferentMotorSpeeds(leftSpeed, rightSpeed);
	}
}
