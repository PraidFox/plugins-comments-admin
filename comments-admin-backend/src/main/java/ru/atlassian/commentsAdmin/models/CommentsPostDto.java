package ru.atlassian.commentsAdmin.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsPostDto {
    @SuppressWarnings("unused")
    public CommentsPostDto(String issueId, String source, String body) {
        this.issueId = issueId;
        this.source = source;
        this.body = body;
    }
    @SuppressWarnings("unused")
    public CommentsPostDto() {
        // for jackson
    }

    private String issueId;
    private String source;
    private String body;
}
