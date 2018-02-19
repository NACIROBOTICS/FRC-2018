package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RSLeftSwitchAuto extends CommandGroup {

    public RSLeftSwitchAuto() {
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
    }
}
