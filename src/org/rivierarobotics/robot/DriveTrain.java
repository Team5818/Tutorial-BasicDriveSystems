package org.rivierarobotics.robot;

public class DriveTrain {

    private DriveSide left;
    private DriveSide right;

    public DriveTrain() {
        left = new DriveSide(true);
        right = new DriveSide(false);

    }

    public void setPower(double l, double r) {
        left.setPower(l);
        right.setPower(r);
    }

}
