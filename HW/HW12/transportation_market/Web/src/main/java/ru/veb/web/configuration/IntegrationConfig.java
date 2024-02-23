package ru.veb.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import ru.veb.web.servises.transformers.msgTransformerService;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel msgInChanel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel msgOutChanel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer (inputChannel = "msgInChanel",outputChannel = "msgOutChanel")
    public GenericTransformer<String, String> msgTransformer(){
        return new msgTransformerService();
    }

    @Bean
    @ServiceActivator(inputChannel = "msgOutChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "./Web/files"));

        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }


    }
