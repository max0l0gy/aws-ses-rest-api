package ru.maxmorev.awsses.api.controller;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailRequest;
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.maxmorev.awsses.api.configuration.SesConfiguration;
import ru.maxmorev.awsses.api.domain.EmailRequest;

@Slf4j
@RestController
@AllArgsConstructor
public class SendTemplateController {

    private final SesConfiguration sesConfiguration;

    @PostMapping(path = "/send/template/")
    public SendTemplatedEmailResult sendEmailTemplate(@RequestBody EmailRequest emailRequest) {
        log.info("EmailRequest \n\n {}", emailRequest);
        SendTemplatedEmailRequest sendTemplatedEmailRequest = new SendTemplatedEmailRequest()
                .withConfigurationSetName(sesConfiguration.getSet())
                .withDestination(new Destination().withToAddresses(emailRequest.getDestination()))
                .withSource(sesConfiguration.getSource())
                .withTemplate(emailRequest.getTemplate())
                .withTemplateData(emailRequest.getTemplateDataAsJson());

        return AmazonSimpleEmailServiceClientBuilder.defaultClient().sendTemplatedEmail(sendTemplatedEmailRequest);
    }

}
