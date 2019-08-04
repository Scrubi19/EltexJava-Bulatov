package ru.eltex.root.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ServiceMail {

    private static final Logger logger = LoggerFactory.getLogger(ServiceMail.class);

    private ServiceSender serviceSender;

    @Autowired
    public void setServiceSender(ServiceSender serviceSender) {
        this.serviceSender = serviceSender;
    }

    @PostConstruct
    private void init() {
        serviceSender.sendMail();
    }

}