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
    private BufferedReader scaleReader;

   // private String path ="/home/schurli/Dokumente/TU/MasterMedieninformatik/DesignThinking/Create-Your-Meal/server/src/resources/";

    private int oldWeight=0;
    private int newWeight=0;
    private boolean stopped=true;

    public ScaleThread(ScalesController listener,int scaleNumber){
        this.listener=listener;
        this.scaleNumber=scaleNumber;
        path=path+"scale"+scaleNumber+".py";
        ProcessBuilder pb = new ProcessBuilder(path);
        pb.redirectErrorStream(true);
        try {
            Process p = pb.start();
            scaleReader= new BufferedReader(new InputStreamReader(p.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

        while (true) {
            if (stopped) {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    stopped = false;
                }
            }
            try {
                String line;
                newWeight = 0;
                while ((line = scaleReader.readLine()) != null || stopped) {
                    if (StringUtils.isNumber(line)) {
                        newWeight = new Integer(line).intValue();
                    }
                    if(newWeight>oldWeight+5 || newWeight < oldWeight-5) {
                        oldWeight=newWeight;
                        listener.fireWeights();
                    }
                }
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
    public void clear(){
        this.stopped=true;
        this.newWeight=0;
    }
}
