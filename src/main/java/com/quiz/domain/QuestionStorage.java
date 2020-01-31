package com.quiz.domain;

import com.quiz.SessionProvider;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class QuestionStorage {

    private final SessionProvider sessionProvider;

    public QuestionStorage(SessionProvider sessionProvider) {this.sessionProvider = sessionProvider;}

    public Question getQuestionById(Integer questionId)
    {
        Session session = sessionProvider.getPublicSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Question> criteria = builder.createQuery(Question.class);
        Root<Question> rootCriteria = criteria.from(Question.class);
        criteria.select(rootCriteria).where(builder.equal(rootCriteria.get("id_question"), questionId));
        return session.createQuery(criteria).getSingleResult();
    }

    public List<Question> getAllQuestions()
    {
        Session session = sessionProvider.getPublicSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Question> criteria = builder.createQuery(Question.class);
        Root<Question> rootCriteria = criteria.from(Question.class);
        criteria.select(rootCriteria);
        return session.createQuery(criteria).getResultList();
    }

    public List<Question> addQuestion(Question question)
    {
        Session session = sessionProvider.getPublicSession();
        session.beginTransaction();
        session.saveOrUpdate(question);
        session.getTransaction().commit();
        sessionProvider.closePublicSession();
        return getAllQuestions();
    }
}
