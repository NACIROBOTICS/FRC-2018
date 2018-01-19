package com.torontocodingcollective.speedcontroller;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class TCanSpeedController extends TSpeedController {

	private final BaseMotorController canSpeedController;
	
	private boolean isInverted = false;
	
	public TCanSpeedController(TCanSpeedControllerType controllerType, int canAddress, int... canFollowerAddresses) {
		this(controllerType, canAddress, false, canFollowerAddresses);
	}
	
	public TCanSpeedController(TCanSpeedControllerType controllerType, int canAddress, boolean isInverted, int... followerCanAddresses) {
		this.isInverted = isInverted;
		canSpeedController = newController(controllerType, canAddress);
		
		for (int followerCanAddress: followerCanAddresses) {
			BaseMotorController follower = newController(controllerType, followerCanAddress);
			follower.follow(canSpeedController);
		}
	}
	
	public TCanSpeedController(TCanSpeedControllerType controllerType, int canAddress, 
			TCanSpeedControllerType followerControllerType, int followerCanAddress) {
		this(controllerType, canAddress, followerControllerType, followerCanAddress, false);
	}
	
	public TCanSpeedController(TCanSpeedControllerType controllerType, int canAddress, 
			TCanSpeedControllerType followerControllerType, int followerCanAddress, boolean isInverted) {

		canSpeedController = newController(controllerType, canAddress);
		
		BaseMotorController follower = newController(followerControllerType, followerCanAddress);
		follower.follow(canSpeedController);
		
		this.isInverted = isInverted;
	}
	
	private BaseMotorController newController(TCanSpeedControllerType controllerType, int canAddress) {
		
		switch (controllerType) {
		case VICTOR_SPX: return new VictorSPX(canAddress);
		case TALON_SRX:  
		default:         return new TalonSRX(canAddress);
		}
	}
	@Override
	public void set(double speed) {
		if (isInverted) {
			speed = -speed;
		}
		canSpeedController.set(ControlMode.PercentOutput, speed);
	}

	@Override
	public double get() {
		
		double speed = canSpeedController.getMotorOutputPercent();
		
		if (isInverted) {
			speed = -speed;
		}
		return speed;
	}

	@Override
	public void setInverted(boolean isInverted) {
		// Stop the motors before inverting
		set(0.0);
		this.isInverted = isInverted;
	}

	@Override
	public boolean getInverted() {
		return isInverted;
	}

	@Override
	public void disable() {
		set(0.0);
	}

	@Override
	public void stopMotor() {
		set(0.0);
	}

	/**
	 * NOTE: This routine is not used in the TorontoFramework but is provided for 
	 *       compile reasons.
	 */
	@Override
	public void pidWrite(double output) {
		set(output);
	}

}
