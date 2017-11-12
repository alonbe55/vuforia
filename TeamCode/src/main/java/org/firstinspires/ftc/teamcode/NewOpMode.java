package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
/**
 * Created by alon on 10/10/2017.
 */
@Autonomous(name ="drive1")
public class NewOpMode extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
    
    @Override
    public void init(){
        leftMotor= hardwareMap.dcMotor.get("left_motor");
        rightMotor=hardwareMap.dcMotor.get("right_motor");
    }

    @Override
    public void loop() {
        leftMotor.setPower(0.5);
        rightMotor.setPower(0.5);
    }
}

