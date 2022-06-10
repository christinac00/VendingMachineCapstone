package com.techelevator.view;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer implements AutoCloseable{

    private Clip clip;
    private AudioInputStream audioInputStream;

    public AudioPlayer(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void play(){
        clip.start();
        try{
            Thread.sleep(2500);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void close() throws IOException {
        clip.close();
        audioInputStream.close();
    }
}