package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by user on 10/10/2017.
 */
@Autonomous(name ="drivei")
public class newnew extends OpMode {
    DcMotor manoa1;
    DcMotor manoa2;
    double power1;
    double power2;
    @Override
    public void init() {
        manoa1=hardwareMap.dcMotor.get("manoa1");
        manoa2=hardwareMap.dcMotor.get("manoa2");

    }

    @Override
    public void loop() {
        power1=gamepad1.left_stick_y;
        power2=gamepad1.right_stick_y;
        manoa1.setPower(power1);
        manoa2.setPower(power2);
    }
}


