package org.usfirst.frc.team1844.robot.commands;

import org.usfirst.frc.team1844.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurntoAngle extends Command {

	public double targetangle;
	public double timeout;
	
    public TurntoAngle(double angle, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.m_drivetrain);
    	targetangle = angle;
    	this.timeout = timeout;
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    	Robot.m_drivetrain.setAngle(targetangle);
    	Robot.m_drivetrain.PIDDrive();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_drivetrain.PIDStop();
    	Robot.m_drivetrain.stop();
    	Robot.m_drivetrain.PIDReset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
