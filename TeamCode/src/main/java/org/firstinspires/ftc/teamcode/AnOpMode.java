package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by user on 10/10/2017.
 */
@Autonomous(name ="drive")
public class AnOpMode extends OpMode {
    DcMotor manoa1;
    DcMotor manoa2;
    @Override
    public void init() {
        manoa1=hardwareMap.dcMotor.get("left");
        manoa2=hardwareMap.dcMotor.get("right");
    }

    @Override
    public void loop() {
        manoa1.setPower(0.3);
        manoa2.setPower(0.3);
        telemetry.addData("the motor power is: ", "0.3");
    }

}

