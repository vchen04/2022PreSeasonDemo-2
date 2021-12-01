// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Represents the robot's shooter subsystem.
 */
public class ShooterSubsystem extends SubsystemBase {
  
  /**
   * The PWM port the shooter motor is plugged into.
   */
  private static final int PORT = 1;

  /**
   * The shooter motor.
   */
  private final PWMTalonFX m_motor;

  /**
   * Constructor which initializes the shooter subsystem.
   */
  public ShooterSubsystem() {
      m_motor = new PWMTalonFX(PORT);
  }

  /**
     * Runs the shooter motor at full speed.
     */
    public void run() {
      m_motor.set(1.0);
  }

  /**
   * Stops the shooter motor.
   */
  public void stop() {
      m_motor.set(0.0);
  }

}
