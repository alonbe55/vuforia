package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by user on 25/10/2017.
 */

public class simpleservoopmode extends OpMode {

  Servo claw ;
double clawposition;

    @Override
    public void init() {
        claw = hardwareMap.servo.get("middle_claw");


    }



    @Override
    public void loop () {



    }
}
