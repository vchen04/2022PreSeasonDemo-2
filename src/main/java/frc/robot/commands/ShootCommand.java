// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Command to run the shooter.
 */
public class ShootCommand extends CommandBase {
  
  /**
   * The shooter subsystem.
   */
  private final ShooterSubsystem m_shooter;

  /**
   * Constructor which creates a command to run the shooter.
   * 
   * @param subsystem the shooter subsystem
   */
  public ShootCommand(ShooterSubsystem subsystem) {
    m_shooter = subsystem;

    // Required for WPILib Commands
    addRequirements(subsystem);
  }

  /**
   * Called every time the command is scheduled (executed by the command
   * scheduler).
   */
  @Override
  public void execute() {
    m_shooter.run();
  }

  /**
   * Called when the command ends or is interrupted.
   * 
   * @param interrupted if the command was interrupted
   */
  @Override
  public void end(boolean interrupted) {
    m_shooter.stop();
  }

}