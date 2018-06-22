package at.ac.tuwien.designthinking.server.service;

import org.h2.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;


public class ScaleThread extends Thread {

    private int scaleNumber;
    //TODO:path to raspberry adjustment
    private String path ="/home/pi/scales/";
    private int weight;
    private boolean stopped=true;


    ScaleThread(int scaleNumber){
        this.scaleNumber=scaleNumber;
        path=path+"scale"+scaleNumber+".py";
    }

    @Override
    public void run(){
        System.out.println("MyScale "+scaleNumber+" running ");
        while(true) {
            if(stopped){
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    stopped=false;
                }
            }
            try {
                ProcessBuilder pb = new ProcessBuilder(path);
                pb.redirectErrorStream(true);
                Process p = pb.start();
                BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                weight = 0;
                for (int i = 0; i < 2; i++) {
                    String line= in.readLine();
                    if(StringUtils.isNumber(line)) {
                        int ret = new Integer(line).intValue();
                        System.out.println("scale " + this.scaleNumber + " value: " + ret);
                        weight = weight + ret;
                    }
                }
                weight = weight / 2;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getWeight(){
        return weight;
    }

    public int getScaleNumber() {
        return scaleNumber;
    }
    public void setStopped(boolean stopped){
        this.stopped=stopped;
    }
}
