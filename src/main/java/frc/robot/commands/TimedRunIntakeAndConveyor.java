package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;

public class TimedRunIntakeAndConveyor extends CommandBase{
    private final Intake m_intake;
    private final double intakeSpeed; 
    private final Shooter m_shooter;
    private final double conveyorSpeed;
    private final double elaspTime;
    private double startTime;
    private double time;

    public TimedRunIntakeAndConveyor(Intake m_intake, double intakeSpeed, Shooter m_shooter, double conveyorSpeed, double elaspTime) {
        this.m_intake = m_intake;
        this.intakeSpeed = intakeSpeed;
        this.m_shooter = m_shooter;
        this.conveyorSpeed = conveyorSpeed;
        this.elaspTime = elaspTime;
        addRequirements(this.m_intake, this.m_shooter);
    }

    @Override
    public void initialize() {
        m_intake.setSolenoidForward();
        startTime  = Timer.getFPGATimestamp();
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        m_intake.rollIntake(intakeSpeed);
        this.m_shooter.runConveryor(this.conveyorSpeed);
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.rollIntake(0);
        m_intake.setSolenoidReverse();
    }

    @Override
    public boolean isFinished(){
        return time - startTime > elaspTime;
    } 
}
