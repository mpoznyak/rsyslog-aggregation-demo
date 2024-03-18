package com.mmpoznyak.syslogdemo;

import com.mmpoznyak.syslogdemo.logging.Audit;
import com.mmpoznyak.syslogdemo.logging.EventType;
import org.springframework.stereotype.Service;

@Service
public class ServiceOperations {

    @Audit(eventType = EventType.LOGIN)
    public void login(String userId, String ipAddress) { }

    @Audit(eventType = EventType.LOGOUT)
    public void logout(String userId) { }

    @Audit(eventType = EventType.UPDATE_PROFILE)
    public void updateProfile(String userId, String table) { }

    @Audit(eventType = EventType.DELETE_ACCOUNT)
    public void deleteAccount(String userId) { }
}
