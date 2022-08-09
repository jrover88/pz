package com.p27.pz.listener;

import com.p27.pz.request.CreditTransferRequest;
import com.p27.pz.response.CreditTransferResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@EnableRabbit
@AllArgsConstructor
public class PzListener {

    private final AmqpTemplate template;

    @RabbitListener(queues = "${leg.one.maps.to.pz.listener}")
    public void handleInboundMessageFromMapsLegOne(final CreditTransferRequest request) {

        log.info("Request from LEG1.MAPS: \n" + request);
        template.convertAndSend("l2-pz-to-maps", request);
        log.info("LEG 2. Emit object from PZ to MAPS");
    }

    @RabbitListener(queues = "${leg.three.maps.to.pz.listener}")
    public void handleInboundMessageFromMapsLegThree(final CreditTransferResponse response) {

        log.info("Message from LEG3.MAPS: " + response);
        template.convertAndSend("l4-pz-to-maps", response);
        log.info("LEG 4. Emit object from PZ to MAPS");
    }
}
