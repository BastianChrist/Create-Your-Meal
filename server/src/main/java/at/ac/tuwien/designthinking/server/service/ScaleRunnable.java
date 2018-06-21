package at.ac.tuwien.designthinking.server.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ScaleRunnable implements Runnable {

    private String scaleNumber;
    //TODO:path to raspberry adjustment
    private String path ="/home/schurli/Dokumente/TU/MasterMedieninformatik/DesignThinking/Create-Your-Meal/server/src/main/java/at/ac/tuwien/designthinking/server/service/";

    ScaleRunnable(String scaleNumber){
        this.scaleNumber=scaleNumber;
        path=path+"pythonTest"+scaleNumber+".py";
    }

    public void run(){
        System.out.println("MyThread running");

        try{
            ProcessBuilder pb = new ProcessBuilder(path);
            pb.redirectErrorStream(true);
            Process p = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            int sum=0;
            while ((line = in.readLine()) != null) {
                for(int i=0; i<3;i++){
                    int ret = new Integer(in.readLine()).intValue();
                    sum = sum+ret;
                }

                sum = sum/3;
                System.out.println("Scale "+scaleNumber+":Value "+sum);
                break;
            }
            in.close();

        }catch(Exception e){e.printStackTrace();}
        /*  try {
            return recipeService.getAll(userId,context);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }*/
    }
}
