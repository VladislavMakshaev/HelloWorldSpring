package com.quiz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class SessionProvider {
    private static final ThreadLocal<Session> PUBLIC_SESSION_THREAD_LOCAL = new ThreadLocal<>();

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    public Session getPublicSession() {
        Session session = PUBLIC_SESSION_THREAD_LOCAL.get();
        if (session == null) {
            session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
            PUBLIC_SESSION_THREAD_LOCAL.set(session);
        }
        return session;
    }

    public static void closePublicSession() {
        Session session = PUBLIC_SESSION_THREAD_LOCAL.get();
        if (session != null) {
            session.close();
            PUBLIC_SESSION_THREAD_LOCAL.remove();
        }
    }
}

