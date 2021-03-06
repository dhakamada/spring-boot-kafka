//package br.com.dhakamada.kafka.consumer;
//
//import java.util.concurrent.CountDownLatch;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.annotation.TopicPartition;
//
///**
// * @author dhakamada
// * @version $Revision: $<br/>
// * $Id: $
// * @since 1/15/18 6:34 PM
// */
//public class Listener {
//    public CountDownLatch countDownLatch0 = new CountDownLatch(3);
//    public CountDownLatch countDownLatch1 = new CountDownLatch(3);
//    public CountDownLatch countDownLatch2 = new CountDownLatch(3);
//
//    @KafkaListener(topics="SpringKafkaTopic", topicPartitions = { @TopicPartition(topic = "SpringKafkaTopic", partitions = { "0" }) })
//    public void listenPartition0(ConsumerRecord<?, ?> record) {
//        System.out.println("Listener Id0, Thread ID: " + Thread.currentThread().getId());
//        System.out.println("Received: " + record);
//        countDownLatch0.countDown();
//    }
//
//    @KafkaListener(topics="SpringKafkaTopic", topicPartitions = { @TopicPartition(topic = "SpringKafkaTopic", partitions = { "1" }) })
//    public void listenPartition1(ConsumerRecord<?, ?> record) {
//        System.out.println("Listener Id1, Thread ID: " + Thread.currentThread().getId());
//        System.out.println("Received: " + record);
//        countDownLatch1.countDown();
//    }
//
//    @KafkaListener(topics="SpringKafkaTopic", id = "id2", topicPartitions = { @TopicPartition(topic = "SpringKafkaTopic", partitions = { "2" }) })
//    public void listenPartition2(ConsumerRecord<?, ?> record) {
//        System.out.println("Listener Id2, Thread ID: " + Thread.currentThread().getId());
//        System.out.println("Received: " + record);
//        countDownLatch2.countDown();
//    }
//}