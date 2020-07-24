package com.screening.quiz.services.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Answers {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String userId;

    private String questionId;

    private String question;

    private Date createdDateTime;

    private Date updatedDateTime;

    @Lob
    private byte[] response;

    private String responseText;

    public Answers(String userId, String questionId, String question, byte[] response, String responseText) {
        this.userId = userId;
        this.questionId = questionId;
        this.question = question;
        this.response = response;
        this.responseText = responseText;
        this.createdDateTime = new Date();
        this.updatedDateTime = new Date();
    }
}
