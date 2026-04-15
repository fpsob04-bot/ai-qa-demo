package com.demo.aiqademo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "qa_record")
public class QaRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String answer;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    public QaRecord() {}

    public QaRecord(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.createTime = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
// Getter 和 Setter（用 IDEA 生成）
}