package org.usfirst.frc.team1844.robot.commands.lift;

import org.usfirst.frc.team1844.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftWithJoystick extends Command {

	public LiftWithJoystick() {
		requires(Robot.m_liftarm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double speed = Robot.m_oi.getDriverJoystick().getY(Hand.kRight); // Right Y

		
		// Sloppy cube
		speed *= speed * speed;

		Robot.m_liftarm.setSpeed(speed*0.3);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
