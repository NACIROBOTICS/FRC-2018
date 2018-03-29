package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team2935.robot.Robot;

public class AutoFinder extends CommandGroup{
	
	public AutoFinder(char robotSide) {
		char switch_side = Robot.m_oi.getSwitchSide();
		char robot_position = robotSide;
		
		switch(robot_position) {
		case 'L':
			switch(switch_side) {
				case 'L':
			    	addSequential(new DriveToDistanceOnHeading(14,0.6,5));
			    	addSequential(new TurnToAngle(90,3));
			    	addSequential(new DriveToDistanceOnHeading(1.5,0.6,3));
			    	addSequential(new AutoOuttakeCube(2));
			    	
			    	addSequential(new DriveToDistanceOnHeading(-1.5,0.6,3));
			    	addSequential(new AutoLowerArm(-2));
			    	break;
				case 'R':
			    	addSequential(new DriveToDistanceOnHeading(14,0.8,4));
			    	addSequential(new TurnToAngle(90,3.5));
			    	addSequential(new DriveToDistanceOnHeading(10,0.8,3.5));
			    	addSequential(new TurnToAngle(90,3.5));
			       	addSequential(new DriveToDistanceOnHeading(2,1,1));
			    	addSequential(new AutoOuttakeCube(0.5));
			    	break;
			    default:
			    	addSequential(new DriveToDistanceOnHeading(20,0.5,5));
			    	break;
			}
			break;
		case 'R':
			switch(switch_side) {
				case 'L':
					addSequential(new DriveToDistanceOnHeading(14,0.8,4));
			    	addSequential(new TurnToAngle(-90,4));
			    	addSequential(new DriveToDistanceOnHeading(10,0.8,3));
			    	addSequential(new TurnToAngle(-90,4));
			       	addSequential(new DriveToDistanceOnHeading(2,1,1));
			    	addSequential(new AutoOuttakeCube(1));
			    	break;
				case 'R':
					addSequential(new DriveToDistanceOnHeading(14,0.7,4));
			    	addSequential(new TurnToAngle(-90,3));
			    	addSequential(new DriveToDistanceOnHeading(1.5,0.7,2));
			    	addSequential(new AutoOuttakeCube(1));
			    	break;
			    default:
			    	addSequential(new DriveToDistanceOnHeading(20,0.5,5));
			    	break;
			}
			break;	
		case 'C':
			switch(switch_side) {
			case 'L':
				addSequential(new DriveToDistanceOnHeading(7,0.8,4));
		    	//addSequential(new TurnToAngle(-90,2.5));   	
		    	//addSequential(new DriveToDistanceOnHeading(5,0.6,1));
		    	//addSequential(new TurnToAngle(90,1.5));
		    //	addSequential(new DriveToDistanceOnHeading(2.5,0.6,1));
		    	addSequential(new AutoOuttakeCube(1));
		    	break;
			case 'R':
				addSequential(new DriveToDistanceOnHeading(1,0.6,2.5));
		    	addSequential(new TurnToAngle(85,4));   	
		    	addSequential(new DriveToDistanceOnHeading(8,0.5,4));
		    	//addSequential(new TurnToAngle(-90,2.5));
		    	//addSequential(new DriveToDistanceOnHeading(2.5,0.6,2.5));
		    	addSequential(new AutoOuttakeCube(1));
		    	break;
		    default:
		    	addSequential(new DriveToDistanceOnHeading(20,0.5,5));
		    	break;
			}
			break;	
	    }	          
  }
}