package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.dto.Scale;
import at.ac.tuwien.designthinking.server.service.AlgorithmService;
import at.ac.tuwien.designthinking.server.service.ScaleThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schurli on 23.06.18.
 */
@Controller
public class ScalesController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    AlgorithmService algorithmService;

    private final ScaleThread scale1 = new ScaleThread(this,1);
    private final ScaleThread scale2 = new ScaleThread(this,2);
    private final ScaleThread scale3 = new ScaleThread(this,3);
    private final ScaleThread scale4 = new ScaleThread(this,4);
    private final ScaleThread scale5 = new ScaleThread(this,5);
    private final ScaleThread scale6 = new ScaleThread(this,6);

    @Autowired
    public  ScalesController(AlgorithmService algorithmService){
        this.algorithmService=algorithmService;
        scale1.start();
        scale2.start();
        scale3.start();
        scale4.start();
        scale5.start();
        scale6.start();
    }

    @MessageMapping("/startScale")
    @SendTo("/weights")
    public List<Scale> getWeights() throws Exception {
        startScales();
        Thread.sleep(5000);
        return readWeights();
    }

    public void fireWeights() {
        template.convertAndSend("/weights",readWeights());
    }

    public void startScales() {
        if (scale1.isAlive()) {
            scale1.interrupt();
        }
        if (scale2.isAlive()) {
            scale2.interrupt();
        }
        if (scale3.isAlive()) {
            scale3.interrupt();
        }
        if (scale4.isAlive()) {
            scale4.interrupt();
        }
        if (scale5.isAlive()) {
            scale5.interrupt();
        }
        if (scale6.isAlive()) {
            scale6.interrupt();
        }
    }
    public void stopScales(){
        scale1.setStopped(true);
        scale2.setStopped(true);
        scale3.setStopped(true);
        scale4.setStopped(true);
        scale5.setStopped(true);
        scale6.setStopped(true);


    }
    public List<Scale> readWeights(){

        List<Scale> scaleList = new ArrayList<>();
        scaleList.add(new Scale(scale1.getScaleNumber(),scale1.getNewWeight()));
        scaleList.add(new Scale(scale2.getScaleNumber(),scale2.getNewWeight()));
        scaleList.add(new Scale(scale3.getScaleNumber(),scale3.getNewWeight()));
        scaleList.add(new Scale(scale4.getScaleNumber(),scale4.getNewWeight()));
        scaleList.add(new Scale(scale5.getScaleNumber(),scale5.getNewWeight()));
        scaleList.add(new Scale(scale6.getScaleNumber(),scale6.getNewWeight()));
        return scaleList;

    }

}
