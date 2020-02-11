package com.quiz.domain;

import com.quiz.SessionProvider;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class ThemeStorage {
    private final SessionProvider sessionProvider;

    public ThemeStorage(SessionProvider sessionProvider) {this.sessionProvider = sessionProvider;}

    public List<Theme> getAllThemes()
    {
        Session session = sessionProvider.getPublicSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Theme> criteria = builder.createQuery(Theme.class);
        Root<Theme> rootCriteria = criteria.from(Theme.class);
        criteria.select(rootCriteria);
        return session.createQuery(criteria).getResultList();
    }
}
