/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author baotri1998
 */
public class Soundhelper {

    private Player player;
    private URL filename;

    public Soundhelper(URL filename) {
        this.filename = filename;
    }

    public void stop() {
        if (player != null) {
            player.close();
        }
    }

    public void play() throws URISyntaxException, IOException {
        try {

            BufferedInputStream bis = new BufferedInputStream(filename.openStream());
            player = new Player(bis);
        } catch (FileNotFoundException | JavaLayerException ex) {
            System.out.println(ex);
        }

        new Thread(new Runnable() { 
            @Override
            public void run() {
                try {
                    player.play();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }).start();
    }
}
