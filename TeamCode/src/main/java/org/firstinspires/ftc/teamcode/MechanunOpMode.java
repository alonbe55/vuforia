package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by user on 02/11/2017.
 */
@TeleOp (name = "MechanumOpMode")
public class MechanunOpMode extends OpMode {
    DcMotor FrontLeftMotor;
    DcMotor BackLeftMotor;
    DcMotor FrontRightMotor;
    DcMotor BackRightMotor;
    double PFL=0;
    double PBL=0;
    double PFR=0;
    double PBR=0;

    @Override
    public void init() {
        FrontLeftMotor=hardwareMap.dcMotor.get("FrontLeftMotor");
        BackLeftMotor=hardwareMap.dcMotor.get("BackLeftMotor");
        FrontRightMotor=hardwareMap.dcMotor.get("FrontRightMotor");
        BackRightMotor=hardwareMap.dcMotor.get("BackRightMotor");
    }

    @Override
    public void loop() {
    PFR=-(gamepad1.left_stick_y-gamepad1.left_stick_x+gamepad1.right_stick_x);
    PBR=-(gamepad1.left_stick_y+gamepad1.left_stick_x-gamepad1.right_stick_x);
    PFL=gamepad1.left_stick_y+gamepad1.left_stick_x-gamepad1.right_stick_x;
    PBL=gamepad1.left_stick_y-gamepad1.left_stick_x+gamepad1.right_stick_x;
    if(gamepad1.left_trigger>0){
        PFL=gamepad1.left_trigger;
        PBL=gamepad1.left_trigger;
        PFR=gamepad1.left_trigger;
        PBR=gamepad1.left_trigger;
    }
        if(gamepad1.right_trigger>0){
            PFL=-gamepad1.right_trigger;
            PBL=-gamepad1.right_trigger;
            PFR=-gamepad1.right_trigger;
            PBR=-gamepad1.right_trigger;
        }
        telemetry.addData("PFL", PFL);
        telemetry.addData("PBL", PBL);
        telemetry.addData("PFR", PFR);
        telemetry.addData("PBR", PBR);

       FrontLeftMotor.setPower(PFL);
    BackLeftMotor.setPower(PBL);
    FrontRightMotor.setPower(PFR);
    BackRightMotor.setPower(PBR);
    }
}
