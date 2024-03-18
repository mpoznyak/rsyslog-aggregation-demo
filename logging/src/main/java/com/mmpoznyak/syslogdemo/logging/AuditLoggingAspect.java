package com.mmpoznyak.syslogdemo.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Aspect
@Component
public class AuditLoggingAspect {

    private static final String USER_ID = "userId";
    private static final String TABLE = "table";
    private static final String IPADDRESS = "ipAddress";

    private final MessageSource messageSource;

    public AuditLoggingAspect(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Before("@annotation(audit)")
    public void logBefore(JoinPoint joinPoint, Audit audit) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        var params = getMethodParams(joinPoint);
        var description = createDescription(params, audit.eventType());
        var message = String.format("Timestamp: %s, User ID: %s, Event: %s, Description: %s",
                LocalDateTime.now(), params.get(USER_ID), audit.eventType(), description);
        logger.info(message);
    }

    private String createDescription(Map<String, String> params, EventType eventType) {
        String userId = params.get(USER_ID);
        Object[] messageParams = switch (eventType) {
            case LOGIN -> new Object[]{userId, params.get(IPADDRESS)};
            case UPDATE_PROFILE -> new Object[]{userId, params.get(TABLE)};
            case LOGOUT, DELETE_ACCOUNT -> new Object[]{userId};
            case ANY_NOT_IMPORTANT -> new Object[]{};
        };
        return messageSource.getMessage(eventType.name(), messageParams, Locale.ENGLISH);
    }

    private Map<String, String> getMethodParams(JoinPoint joinPoint) {
        var args = joinPoint.getArgs();
        var signature = (MethodSignature) joinPoint.getSignature();
        var parameterNames = signature.getParameterNames();

        Map<String, String> namedArguments = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            namedArguments.put(parameterNames[i], (String) args[i]);
        }
        return namedArguments;
    }

}