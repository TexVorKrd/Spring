package ru.veb.web.servises.integration;



import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.integration.file.FileHeaders;

@MessagingGateway (defaultRequestChannel = "msgInChanel")
public interface IntegrationService {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String msg);

}
