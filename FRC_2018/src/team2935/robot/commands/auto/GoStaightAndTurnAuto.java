package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GoStaightAndTurnAuto extends CommandGroup {

    public GoStaightAndTurnAuto() {
    	addSequential(new DriveToDistanceOnHeading(5.7,0.5,3));
    	addSequential(new TurnToAngle(90,2));
    }
}
