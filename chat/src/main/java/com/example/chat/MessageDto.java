package com.example.chat;

import java.time.Instant;

public class MessageDto {
    private Integer userId;
    private String body;
    private Instant createdAt;
    private Long retreiveDuation;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getRetreiveDuation() {
        return retreiveDuation;
    }

    public void setRetreiveDuation(Long retreiveDuation) {
        this.retreiveDuation = retreiveDuation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
