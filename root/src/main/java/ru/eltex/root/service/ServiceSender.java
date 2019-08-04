package ru.eltex.root.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceSender {
    public static final Logger logger = LoggerFactory.getLogger(ServiceSender.class);

    public void sendMail() {
        logger.info("send Email");
    }
}
