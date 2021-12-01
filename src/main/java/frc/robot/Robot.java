// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /**
   * The port the XBox controller is plugged into.
   */
  private final int CONTROLLER_PORT = 1;

  /**
   * The shooter subsystem.
   */
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  /**
  * The shoot command.
  */
  private final ShootCommand m_shootCommand = new ShootCommand(m_shooterSubsystem);

  /**
   * The XBox controller which will be used to control the robot.
   */
  private final XboxController m_controller = new XboxController(CONTROLLER_PORT);

  /**
  * This function is run when the robot is first started up and should be used for any
  * initialization code.
  */
  @Override
  public void robotInit() {
    // Get the X button from the Xbox controller
    JoystickButton shootButton = new JoystickButton(m_controller, XboxController.Button.kX.value);
    // Assign the X button to trigger the shoot command
    shootButton.whenHeld(m_shootCommand);
  }

  /**
  * This function is called every robot packet, no matter the mode. Use this for items like
  * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
  *
  * <p>This runs after the mode specific periodic functions, but before
  * LiveWindow and SmartDashboard integrated updating.
  */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

}
