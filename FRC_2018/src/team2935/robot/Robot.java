/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team2935.robot;

import java.util.ArrayList;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team2935.robot.subsystems.ChassisSubsystem;
import team2935.robot.subsystems.IntakeSubsystem;
import team2935.robot.commands.auto.GoStaightAndTurnAuto;
import team2935.robot.subsystems.ArmSubsystem;

public class Robot extends TimedRobot {
	public static final ChassisSubsystem chassisSubsystem = new ChassisSubsystem();
	public static final ArmSubsystem armSubsystem = new ArmSubsystem();
	public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
   
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	public UsbCamera camera;
	public static ArrayList<Subsystem> subsystemList = new ArrayList<>();

	@Override
	public void robotInit() {
		m_oi = new OI();
		SmartDashboard.putData("Scheduler", Scheduler.getInstance());
		subsystemList.add(chassisSubsystem);
		subsystemList.add(armSubsystem);
		subsystemList.add(intakeSubsystem);
        Robot.chassisSubsystem.robotInit();
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.getVideoMode();
		camera.setResolution(250, 250);
		m_chooser.addObject("GoStaightAndTurnAuto", new GoStaightAndTurnAuto());
		SmartDashboard.putData("Autonomous Selector", m_chooser);
		//chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {Robot.chassisSubsystem.resetEncoders();}
	
	@Override
	public void disabledPeriodic() {
		Robot.chassisSubsystem.resetGyro();
		Robot.m_oi.updateSmartDashboard();
		SmartDashboard.putData("Autonomous Selector", m_chooser);
	    SmartDashboard.putNumber("RightTicks", chassisSubsystem.getRightEncoderDistance());
	    SmartDashboard.putNumber("LeftTicks", chassisSubsystem.getLeftEncoderDistance());
	    SmartDashboard.putNumber("Angle",chassisSubsystem.getAngle());
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Robot.chassisSubsystem.resetGyro();
		m_autonomousCommand = m_chooser.getSelected();
		m_autonomousCommand.start();
//		Robot.command.auto.GoStaightAndTurnAuto.start();
	
		
		
		// case "Default Auto": default:autonomousCommand = new ExampleCommand(); break; }
		

		// schedule the autonomous command (example)
	/*	if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}*/
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Robot.m_oi.updateSmartDashboard();

		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		/*if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}*/
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Robot.m_oi.updateSmartDashboard();
		SmartDashboard.putNumber("RightTicks", chassisSubsystem.getRightEncoderDistance());
	    SmartDashboard.putNumber("LeftTicks", chassisSubsystem.getLeftEncoderDistance());
	    SmartDashboard.putNumber("Angle",chassisSubsystem.getAngle());
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void testPeriodic() {LiveWindow.run();}
}
