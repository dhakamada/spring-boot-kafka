package br.com.dhakamada.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author dhakamada
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/15/18 1:31 PM
 */
@EnableKafka
@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
