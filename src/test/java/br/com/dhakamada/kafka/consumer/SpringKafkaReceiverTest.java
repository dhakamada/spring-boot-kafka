//package br.com.dhakamada.kafka.consumer;
//
///**
// * @author dhakamada
// * @version $Revision: $<br/>
// * $Id: $
// * @since 1/15/18 1:55 PM
// */
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import br.com.dhakamada.kafka.SpringKafkaTests;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.listener.MessageListenerContainer;
//import org.springframework.kafka.test.utils.ContainerTestUtils;
//import org.springframework.kafka.test.utils.KafkaTestUtils;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringKafkaReceiverTest {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(SpringKafkaReceiverTest.class);
//
//    @Autowired
//    private Receiver receiver;
//
//    @Autowired
//    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//
//    private KafkaTemplate<String, String> template;
//
//    @Before
//    public void setUp() throws Exception {
//        // set up the Kafka producer properties
//        Map<String, Object> senderProperties =
//                KafkaTestUtils.senderProps(SpringKafkaTests.embeddedKafka.getBrokersAsString());
//
//        // create a Kafka producer factory
//        ProducerFactory<String, String> producerFactory =
//                new DefaultKafkaProducerFactory<String, String>(senderProperties);
//
//        // create a Kafka template
//        template = new KafkaTemplate<>(producerFactory);
//        // set the default topic to send to
//        template.setDefaultTopic(SpringKafkaTests.RECEIVER_TOPIC);
//
//        // wait until the partitions are assigned
//        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
//                .getListenerContainers()) {
//            ContainerTestUtils.waitForAssignment(messageListenerContainer,
//                    SpringKafkaTests.embeddedKafka.getPartitionsPerTopic());
//        }
//    }
//
//    @Test
//    public void testReceive() throws Exception {
//        // send the message
//        String greeting = "Hello Spring Kafka Receiver!";
//        template.sendDefault(greeting);
//        LOGGER.debug("test-sender sent message='{}'", greeting);
//
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        // check that the message was received
//        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
//    }
//}