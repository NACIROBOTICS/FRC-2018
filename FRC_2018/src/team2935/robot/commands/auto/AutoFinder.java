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
			    	addSequential(new DriveToDistanceOnHeading(15,0.6,3));
			    	addSequential(new TurnToAngle(90,1.5));
			    	addSequential(new DriveToDistanceOnHeading(1.5,0.6,1.5));
			    	addSequential(new AutoOuttakeCube(1));
			    	addSequential(new DriveToDistanceOnHeading(-1.5,0.6,1.5));
			    	addSequential(new TurnToAngle(-90,2));
			    	addParallel(new AutoLowerArm(0.5));
			    	addSequential(new DriveToDistanceOnHeading(2,0.6,1));
			    	addSequential(new TurnToAngle(45,1));
			    	addSequential(new DriveToDistanceOnHeading(4,0.6,1.5));
			    	addParallel(new AutoIntakeCube(1.5));
			    	addSequential(new DriveToDistanceOnHeading(1,0.6,0.5));
			    	addSequential(new AutoOuttakeCube(0.5));
			    	break;
				case 'R':
			    	addSequential(new DriveToDistanceOnHeading(17,0.7,3));
			    	addSequential(new TurnToAngle(90,1.25));
			    	addSequential(new DriveToDistanceOnHeading(17,0.7,3));
			    	addSequential(new TurnToAngle(90,1.25));
			        addParallel(new AutoRaiseArm(0.5));
			    	addSequential(new DriveToDistanceOnHeading(2,0.6,1));
			    	addSequential(new AutoOuttakeCube(0.5));
			    	addSequential(new DriveToDistanceOnHeading(-2,0.6,1));
			    	addSequential(new TurnToAngle(45,0.75));
			    	addParallel(new AutoLowerArm(0.5));
			    	addSequential(new DriveToDistanceOnHeading(4,0.6,1.5));
			    	addParallel(new AutoIntakeCube(1.5));
			    	addSequential(new TurnToAngle(-45,0.75));
			    	addSequential(new DriveToDistanceOnHeading(2,0.7,0.75));
			    	addSequential(new AutoOuttakeCube(0.25));
			    	break;
			    default:
			    	addSequential(new DriveToDistanceOnHeading(20,0.5,5));
			    	break;
			}
			break;
		case 'R':
			switch(switch_side) {
				case 'L':
			    	addSequential(new DriveToDistanceOnHeading(17,0.7,3));
			    	addSequential(new TurnToAngle(-90,1.25));
			    	addSequential(new DriveToDistanceOnHeading(17,0.7,3));
			    	addSequential(new TurnToAngle(-90,1.25));
			        addParallel(new AutoRaiseArm(0.5));
			    	addSequential(new DriveToDistanceOnHeading(2,0.6,1));
			    	addSequential(new AutoOuttakeCube(0.5));
			    	addSequential(new DriveToDistanceOnHeading(-2,0.6,1));
			    	addSequential(new TurnToAngle(-45,0.75));
			    	addParallel(new AutoLowerArm(0.5));
			    	addSequential(new DriveToDistanceOnHeading(4,0.6,1.5));
			    	addParallel(new AutoIntakeCube(1.5));
			    	addSequential(new TurnToAngle(45,0.75));
			    	addSequential(new DriveToDistanceOnHeading(2,0.7,0.75));
			    	addSequential(new AutoOuttakeCube(0.25));
			    	break;
				case 'R':
					addSequential(new DriveToDistanceOnHeading(15,0.6,3));
			    	addSequential(new TurnToAngle(-90,1.5));
			    	addParallel(new AutoRaiseArm(1));
			    	addSequential(new DriveToDistanceOnHeading(1.5,0.6,1.5));
			    	addSequential(new AutoOuttakeCube(1));
			    	addSequential(new DriveToDistanceOnHeading(-1.5,0.6,1.5));
			    	addSequential(new TurnToAngle(90,2));
			    	addParallel(new AutoLowerArm(0.5));
			    	addSequential(new DriveToDistanceOnHeading(2,0.6,1));
			    	addSequential(new TurnToAngle(-45,1));
			    	addSequential(new DriveToDistanceOnHeading(4,0.6,1.5));
			    	addParallel(new AutoIntakeCube(1.5));
			    	addSequential(new DriveToDistanceOnHeading(1,0.6,0.5));
			    	addSequential(new AutoOuttakeCube(0.5));
			    	break;
			    default:
			    	addSequential(new DriveToDistanceOnHeading(20,0.5,5));
			    	break;
			}
			break;	
		case 'C':
			switch(switch_side) {
			case 'L':
				addSequential(new DriveToDistanceOnHeading(6,0.6,1.5));
		    	addSequential(new TurnToAngle(-90,1.5));   	
		    	addSequential(new DriveToDistanceOnHeading(5,0.6,1));
		    	addSequential(new TurnToAngle(90,1.5));
		    	addParallel(new AutoRaiseArm(0.5)); 
		    	addSequential(new DriveToDistanceOnHeading(2.5,0.6,1));
		    	addSequential(new AutoOuttakeCube(0.5));
		    	addSequential(new DriveToDistanceOnHeading(-1,0.6,0.5));    	
		    	addSequential(new TurnToAngle(90,1.5));
		        addParallel(new AutoLowerArm(0.5));
		        addSequential(new DriveToDistanceOnHeading(4,0.6,1.5));
		    	addParallel(new AutoIntakeCube(1.5));
		    	addSequential(new DriveToDistanceOnHeading(-4,0.6,1.5));
		    	addParallel(new AutoRaiseArm(0.5));    	
		    	addSequential(new TurnToAngle(-90,1.5));
		    	addSequential(new DriveToDistanceOnHeading(1,0.6,0.5));
		    	addSequential(new AutoOuttakeCube(0.5));
		    	break;
			case 'R':
				addSequential(new DriveToDistanceOnHeading(6,0.6,1.5));
		    	addSequential(new TurnToAngle(90,1.5));   	
		    	addSequential(new DriveToDistanceOnHeading(5,0.6,1));
		    	addSequential(new TurnToAngle(-90,1.5));
		    	addParallel(new AutoRaiseArm(0.5)); 
		    	addSequential(new DriveToDistanceOnHeading(2.5,0.6,1));
		    	addSequential(new AutoOuttakeCube(0.5));
		    	addSequential(new DriveToDistanceOnHeading(-1,0.6,0.5));    	
		    	addSequential(new TurnToAngle(-90,1.5));
		        addParallel(new AutoLowerArm(0.5));
		        addSequential(new DriveToDistanceOnHeading(4,0.6,1.5));
		    	addParallel(new AutoIntakeCube(1.5));
		    	addSequential(new DriveToDistanceOnHeading(-4,0.6,1.5));
		    	addParallel(new AutoRaiseArm(0.5));    	
		    	addSequential(new TurnToAngle(90,1.5));
		    	addSequential(new DriveToDistanceOnHeading(1,0.6,0.5));
		    	addSequential(new AutoOuttakeCube(0.5));
		    	break;
		    default:
		    	addSequential(new DriveToDistanceOnHeading(20,0.5,5));
		    	break;
			}
			break;	
	    }	          
  }
}
