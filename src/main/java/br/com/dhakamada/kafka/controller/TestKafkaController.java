package br.com.dhakamada.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dhakamada
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/16/18 10:26 AM
 */
@RestController
@RequestMapping("kafka")
public class TestKafkaController {
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    public void kafka() {

        sendKafka("SpringKafkaTopic",0, "Mensagem 0");
        sendKafka("SpringKafkaTopic",0, "Mensagem 0");
        sendKafka("SpringKafkaTopic",1, "Mensagem 0");
        sendKafka("SpringKafkaTopic",2, "Mensagem 0");
    }

    private void sendKafka(String topic, Integer partition, String data) {
                            ListenableFuture<SendResult<String, String>> future2 = kafkaTemplate.send(topic, partition, null,data);
        future2.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message: " + result);
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Failed to send message");
            }
        });
    }

}
