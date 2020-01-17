package hello;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private List<String> list = new ArrayList(Arrays.asList(
            "В каком году в России отменили крепостное право?",
            "Какой князь крестил Русь?",
            "Как звали первого царя из династии Романовых?"
    ));

    public String getQuestion(int index) {
        return list.get(index);
    }

    public int getSize() {
        return list.size();
    }

    public List getAllQuestions() {
        return list;
    }

    public void addQuestion(String question) {
        this.list.add(question);
    }
}
