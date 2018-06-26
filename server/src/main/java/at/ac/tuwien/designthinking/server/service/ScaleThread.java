package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.controller.ScalesController;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;


public class ScaleThread extends Thread {

    private ScalesController listener;

    private int scaleNumber;
    //TODO:path to raspberry adjustment
    private String path ="/home/pi/scales/";
    private int oldWeight=0;
    private int newWeight=0;
    private int multiple=0;
    private boolean stopped=true;

    public ScaleThread(ScalesController listener,int scaleNumber){
        this.listener=listener;
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
                oldWeight=newWeight;
                newWeight = 0;
                    String line= in.readLine();
                    if(StringUtils.isNumber(line)) {
                        newWeight = new Integer(line).intValue();
                        System.out.println("scale " + this.scaleNumber + " value: " + newWeight);
                    }
               // if(updateWeight()){
                    listener.fireWeights();
                //}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getNewWeight(){
        return newWeight;
    }
    public int getScaleNumber() {
        return scaleNumber;
    }
    public void setStopped(boolean stopped){
        this.stopped=stopped;
    }

    public boolean updateWeight() {
        if(oldWeight==0 && newWeight != 0)
        {
            return true;
        }
        if (oldWeight != 0) {
            int newMultiple = newWeight / oldWeight;
            newMultiple = Math.round(newMultiple);
            if (newMultiple != multiple) {
                multiple = newMultiple;
                return true;
            }
        }
        return false;
    }
}
