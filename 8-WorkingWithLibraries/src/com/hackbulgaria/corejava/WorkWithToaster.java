package com.hackbulgaria.corejava;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class WorkWithToaster {
    
    public static void main(String args[]) throws InterruptedException, IOException {
        File file = new File("C:\\Users\\RUSHI\\Desktop\\dog.jpg");
        Toaster toaster = new Toaster();
        toaster.setToasterWidth(1200);
        toaster.setToasterHeight(700);
        toaster.setToasterColor(new Color(40));
        toaster.setBackgroundImage(ImageIO.read(file));
        toaster.setStep(5);
        
        Thread.sleep(10*1000);
        toaster.showToaster("Get a little rest, will you?");
        Thread.sleep(20*1000);
    }

}
