package com.mmpoznyak.syslogdemo;

import com.mmpoznyak.syslogdemo.logging.Audit;
import com.mmpoznyak.syslogdemo.logging.EventType;
import org.springframework.stereotype.Service;

@Service
public class ServiceOperations {

    @Audit(eventType = EventType.ANY_NOT_IMPORTANT)
    public void printAnyNotImportant(String userId) { }

    @Audit(eventType = EventType.UPDATE_PROFILE)
    public void updateProfile(String userId, String table) { }
}
