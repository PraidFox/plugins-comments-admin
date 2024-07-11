package ru.atlassian.commentsAdmin.models;

import lombok.Getter;
@Getter
public class CommentsPostDto {
    private String issueId;
    private String source;
    private String body;
}
