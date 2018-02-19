package faqapp.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by AAS on 2/14/2018.
 */

@Document( collection = "faqs")
public class FAQ {

    @Id
    private ObjectId id;

    private String question;

    private String answer;

    public FAQ(){}

    public FAQ(ObjectId id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
