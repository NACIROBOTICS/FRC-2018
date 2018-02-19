package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossLineAuto extends CommandGroup {

    public CrossLineAuto() {
    	addSequential(new DriveToDistanceOnHeading(20,0.5,5));
    }
}
