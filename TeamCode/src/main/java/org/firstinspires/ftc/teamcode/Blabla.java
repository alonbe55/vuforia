package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by ${alon} on 12/11/2017.
 */
@TeleOp(name = "bbb")
public class Blabla extends OpMode {

    DcMotor lf;
    DcMotor lb;
    DcMotor rf;
    DcMotor rb;
    double lfp;
    double lbp;
    double rfp;
    double rbp;
   // BNO055IMU gyro;
    GyroSensor gyro;


    @Override
    public void init() {
        lf = hardwareMap.dcMotor.get("FrontLeftMotor");
        lb = hardwareMap.dcMotor.get("BackLeftMotor");
        rf = hardwareMap.dcMotor.get("FrontRightMotor");
        rb = hardwareMap.dcMotor.get("BackRightMotor");
    }


    @Override
    public void loop() {
        rfp = -(gamepad1.left_stick_y - gamepad1.left_stick_x);
        rbp = -(gamepad1.left_stick_y + gamepad1.left_stick_x);
        lfp = gamepad1.left_stick_y + gamepad1.left_stick_x;
        lbp = gamepad1.left_stick_y - gamepad1.left_stick_x;
        lf.setPower(lfp);
        lb.setPower(lbp);
        rf.setPower(rfp);
        rb.setPower(rbp);
        angle(gyro.getHeading(),0.01);
    }

    public void angle(double cangel, double kp) {
        double fangel = Math.atan2(gamepad1.left_stick_x, gamepad1.left_stick_y);
        fangel = fangel * (180 / Math.PI);
        double error = fangel - cangel;
        if (error > 0) {
            lfp = lfp + (error * kp);
            lbp = lbp + (error * kp);
            lf.setPower(lfp);
            lb.setPower(lbp);
        }
        if (error < 0) {
            rfp = rfp - (error * kp);
            rbp = rbp - (error * kp);
            rf.setPower(rfp);
            rb.setPower(rbp);
        }
    }
}