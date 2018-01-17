package br.com.dhakamada.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author dhakamada
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/15/18 6:34 PM
 */
public class Listener1 {
    public CountDownLatch countDownLatch0 = new CountDownLatch(3);

    @KafkaListener(topics = "SpringKafkaTopic")
    public void listen(@Payload String foo,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
            ConsumerRecord<?, ?> record
    ) {
        System.out.println("Listener, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + record);
        System.out.println("Partition: " + partition);
        countDownLatch0.countDown();
    }
}