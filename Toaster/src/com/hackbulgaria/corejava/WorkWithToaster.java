package com.hackbulgaria.corejava;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.nitido.utils.toaster.Toaster;

public class WorkWithToaster {

    public static void main(String args[]) throws InterruptedException, IOException {
        File file = new File(args[0]);
        Toaster toaster = new Toaster();
        toaster.setToasterWidth(1000);
        toaster.setToasterHeight(700);
        toaster.setToasterColor(Color.BLACK);
        toaster.setBackgroundImage(ImageIO.read(file));
        toaster.setStep(5);

        Thread.sleep(20 * 1000);
        toaster.showToaster("Get a little rest, will you?");
        Thread.sleep(20 * 1000);
    }
}
