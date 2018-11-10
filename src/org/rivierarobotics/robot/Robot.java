package org.rivierarobotics.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {

    private DriveTrain driveTrain;
    private Joystick joystick1;
    private Joystick joystick2;

    @Override
    public void robotInit() {
        driveTrain = new DriveTrain();
        joystick1 = new Joystick(0);
        joystick2 = new Joystick(1);
    }

    @Override
    public void teleopPeriodic() {
        // Tank Drive:
        /*
        double y1 = joystick1.getY();
        double y2 = joystick2.getY();
        driveTrain.setPower(y1, y2);
        */

        // Arcade Drive:
        double x1 = joystick1.getX();
        double y2 = joystick2.getY();
        setArcade(x1, y2);
    }

    private void setArcade(double rotate, double power) {
        double max = Math.max(Math.abs(rotate), Math.abs(power));
        double diff = power - rotate;
        double sum = power + rotate;

        double left;
        double right;
        if (power > 0) {
            if (rotate > 0) {
                left = max;
                right = diff;
            } else {
                left = sum;
                right = max;
            }
        } else {
            if (rotate > 0) {
                left = sum;
                right = -max;
            } else {
                left = -max;
                right = diff;
            }
        }
        driveTrain.setPower(left, right);
    }

}
