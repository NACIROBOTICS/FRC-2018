package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LSLeftSwitchAuto extends CommandGroup {
    												//2 Cube Auto
    public LSLeftSwitchAuto() {
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
    }
}
