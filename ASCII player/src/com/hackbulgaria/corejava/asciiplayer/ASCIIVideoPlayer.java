package com.hackbulgaria.corejava.asciiplayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import jline.ConsoleReader;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;

public class ASCIIVideoPlayer implements ASCIIPlayer {
    private List<ASCIIPicturePlayer> frames = new ArrayList<ASCIIPicturePlayer>();

    public ASCIIVideoPlayer(File file) throws IOException, JCodecException {
        // for testing purposes only get 5 frames
        // change to
        // while(FrameGrab.getFrame(file, frameNumber) != null)
        // for complete video

        int frameNumber = 0;
        while(frameNumber<60) {
            frames.add(new ASCIIPicturePlayer(FrameGrab.getFrame(file, frameNumber)));
            frameNumber++;
        }
    }

    @Override
    public void play() throws IOException, InterruptedException {
        export();
//        ConsoleReader reader = new ConsoleReader();
//        for (ASCIIPicturePlayer frame : frames) {
//            frame.play();
//            Thread.sleep(45);
//            reader.clearScreen();
//        }
    }
    
    public void export() throws IOException {
        List<BufferedImage> images = new ArrayList<>();

        Font f = new Font(Font.MONOSPACED, 10, 4);

        for (int i = 0; i < frames.size(); i++) {
            BufferedImage image = new BufferedImage(700, 400,
                    BufferedImage.TYPE_INT_ARGB);
            Graphics2D graph = image.createGraphics();
            graph.setFont(f);
            graph.setColor(Color.WHITE);
            graph.fillRect(0, 0, image.getWidth(), image.getHeight());
            graph.setColor(Color.BLACK);
            String[] rows = frames.get(i).toString().split("[\n]");
            int y = 0;
            for (int j = 0; j < rows.length; j++) {
                graph.drawString(rows[j], 0, y);
                y += 6;
            }
            images.add(image);
        }

        AnimatedGifEncoder e = new AnimatedGifEncoder();
        e.start(new FileOutputStream(new File("C:\\Users\\RUSHI\\Desktop\\Child4.gif")));
        e.setDelay(50);

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < frames.size(); i++) {
                e.addFrame(images.get(i));
            }
        }
        e.finish();
    }    

}

