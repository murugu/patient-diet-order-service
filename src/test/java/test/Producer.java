package test;

import com.davita.cwow.patientdietorder.entity.dvadiatetics.PatientDietOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@SpringBootApplication
@EnableBinding(Sink.class)
public class Producer {

    private final MessageChannel channel;

    @Autowired
    public Producer(Source channels) {
        this.channel = channels.output();
    }

    @Bean
    @RequestMapping(method = RequestMethod.POST)
    CommandLineRunner send(@RequestBody PatientDietOrderDto patientDietOrderDto) {
        this.channel.send(
                MessageBuilder
                        .withPayload(new GenericMessage<PatientDietOrderDto>(patientDietOrderDto))
                        .setHeader("action", "create")
                        .build());

//				MessageBuilder.withPayload(patientDietOrderDto)
//						.setHeader("action", "create")
//						.build());
        return null;
    }
    public static void main(String[] args) {
        SpringApplication.run(Producer.class, args);
    }
}
