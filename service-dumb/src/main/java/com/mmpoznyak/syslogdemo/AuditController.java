package com.mmpoznyak.syslogdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditController {
    private static final Logger LOGGER = LoggerFactory.getLogger("AuditController");

    @PostMapping("/audit")
    private void processAuditMessages(@RequestBody String auditLogMessage) {
        LOGGER.info("Received: " + auditLogMessage);
    }
}
