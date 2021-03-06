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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team2935.oi.OI;
import team2935.robot.commands.auto.AutoFinder;
import team2935.robot.commands.auto.CrossLineAuto;
import team2935.robot.subsystems.ArmSubsystem;
import team2935.robot.subsystems.ChassisSubsystem;
import team2935.robot.subsystems.IntakeSubsystem;

public class Robot extends TimedRobot {
	public static final ChassisSubsystem chassisSubsystem = new ChassisSubsystem();
	public static final ArmSubsystem armSubsystem = new ArmSubsystem();
	public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
   
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	SendableChooser<String> side_chooser = new SendableChooser<>();
    AutoFinder autoFinder;
	
	
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
		
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.getVideoMode();
		camera.setResolution(250, 250);
		
		subsystemList.add(chassisSubsystem);
		subsystemList.add(armSubsystem);
		subsystemList.add(intakeSubsystem);
        
		Robot.chassisSubsystem.robotInit();
		
		side_chooser.addDefault("Left", "Left");
		side_chooser.addDefault("Center", "Center");
		side_chooser.addDefault("Right", "Right");
        SmartDashboard.putData("Postion", side_chooser);
        
//		m_chooser.addDefault("Default", new GoStaightAndTurnAuto());
//		m_chooser.addObject("GoStaightAndTurnAuto", new GoStaightAndTurnAuto());
//		m_chooser.addObject("(LeftSide) LeftSwitchAuto", new LSLeftSwitchAuto());
//		m_chooser.addObject("(LeftSide) RightSwitchAuto", new LSRightSwitchAuto());
//		m_chooser.addObject("(Center) LeftSwitchAuto", new CSLeftSwitchAuto());
//		m_chooser.addObject("(Center) RightSwitchAuto", new CSRightSwitchAuto());
//		m_chooser.addObject("(Right) LeftSwitchAuto", new RSLeftSwitchAuto());
//		m_chooser.addObject("(Right) RightSwitchAuto", new RSRightSwitchAuto());
//		m_chooser.addObject("(AnyWhere) CrossAutoLine", new CrossLineAuto());
		SmartDashboard.putData("Autonomous Selector", m_chooser);
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
		Robot.m_oi.updateSmartDashboard();
		Scheduler.getInstance().run();
		Robot.intakeSubsystem.updatePeriodic();
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
		chassisSubsystem.resetEncoders();
		chassisSubsystem.resetGyro();
		m_autonomousCommand = new AutoFinder(side_chooser.getSelected().charAt(0));
		//m_autonomousCommand = new CrossLineAuto();

		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Robot.m_oi.updateSmartDashboard();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Robot.m_oi.updateSmartDashboard();
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
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
 	public void testPeriodic() {/*LiveWindow.run();*/}
}