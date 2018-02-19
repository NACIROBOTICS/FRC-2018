package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CSRightSwitchAuto extends CommandGroup {

    public CSRightSwitchAuto() {
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
    }
}
