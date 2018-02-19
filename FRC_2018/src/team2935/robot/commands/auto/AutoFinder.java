package team2935.robot.commands.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoFinder extends CommandGroup{
	
	
	public Command getAuto(char position){
		
	String gameData;
	gameData = DriverStation.getInstance().getGameSpecificMessage();
	char switch_side = gameData.charAt(0);
	
	switch(position) {
		case 'L':
			switch(switch_side) {
				case 'L':
					return new LSLeftSwitchAuto();
				case 'R':
					return new LSRightSwitchAuto();
			}
			
		case 'R':
			switch(switch_side) {
				case 'L':
					return new RSLeftSwitchAuto();
				case 'R':
					return new RSRightSwitchAuto();
		}
			
		case 'C':
			switch(switch_side) {
			case 'L':
				return new CSLeftSwitchAuto();
			case 'R':
				return new CSRightSwitchAuto();
			}
    }
   	return new CrossLineAuto();      
	          
  }
}
