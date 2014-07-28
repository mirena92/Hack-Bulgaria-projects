package com.hackbulgaria.corejava;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.BrushCss;
import syntaxhighlighter.brush.BrushJScript;
import syntaxhighlighter.brush.BrushJava;
import syntaxhighlighter.brush.BrushPhp;
import syntaxhighlighter.example.Example;
import syntaxhighlighter.theme.ThemeMidnight;

public class QuickCodeInspector {

    public static void main(String[] args) {

        File file = new File(args[0]);

        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeMidnight());

        parser.setHtmlScript(true);
        parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(), new BrushJScript(), new BrushPhp()));

        try {
            highlighter.setContent(file);
        } catch (IOException ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] fileName = args[0].split("[\\\\]");

        JFrame frame = new JFrame();
        frame.setTitle(fileName[fileName.length - 1]);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(highlighter);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
}
