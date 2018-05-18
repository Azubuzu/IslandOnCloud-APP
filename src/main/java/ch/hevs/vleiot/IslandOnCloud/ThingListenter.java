package ch.hevs.vleiot.IslandOnCloud;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ThingListenter {
    private final Log log = LogFactory.getLog(ThingListenter.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ThingListenter(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(),
            exchange = @Exchange(value = "amq.topic", type = ExchangeTypes.TOPIC,ignoreDeclarationExceptions = "true"),
            key = "@update.StuderInnotec_1.nodes.io.objects.inputs.attributes.switch0"
    ))
    private void onGatewayReading(@Payload Thing reading, Message message) {
        log.info(reading.toString());
        reading.setType("SetPoint");
        rabbitTemplate.convertAndSend("amq.topic","@set.StuderInnotec_1.nodes.io.objects.outputs.attributes.led0",reading);
    }
}
