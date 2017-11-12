package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by alon on 27/09/2017.
 */
@TeleOp(name = "SkeletonOpMode")
public class SkeletonOpMode extends  OpMode {

   DcMotor leftUPMotor;
   DcMotor rightUpMotor;
   DcMotor leftDownMotor;
   DcMotor rightDownMotor;

    double rightPower;
    double leftPower;


    @Override
    public void init() {
        leftUPMotor = hardwareMap.dcMotor.get("FrontLeftMotor");
        rightUpMotor = hardwareMap.dcMotor.get("FrontRightMotor");
        leftDownMotor = hardwareMap.dcMotor.get("BackLeftMotor");
        rightDownMotor = hardwareMap.dcMotor.get("BackRightMotor");
    }

    @Override
    public void loop() {
        rightPower = gamepad1.right_stick_y;
        leftPower = gamepad1.left_stick_y;
        leftUPMotor.setPower(rightPower);
        rightUpMotor.setPower(leftPower);
        leftDownMotor.setPower(rightPower);
        rightDownMotor.setPower(leftPower);
    }

}
