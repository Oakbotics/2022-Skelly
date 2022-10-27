package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ClimberPeumatics extends SubsystemBase{
    
    
    private final DoubleSolenoid climberSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ClimbConstants.PNEUMATIC_CLIMBER_FORWARD, Constants.ClimbConstants.PNEUMATIC_CLIMBER_REVERSE);

    public void setSolenoidForward() {
        climberSolenoid.set(Value.kForward);
    }

    public void setSolenoidReverse() {
        climberSolenoid.set(Value.kReverse);
    }

    public void solenoidToggle() {
        climberSolenoid.toggle();
    }

}
