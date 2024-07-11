package ru.atlassian.commentsAdmin.models;

import lombok.Getter;
import ru.atlassian.commentsAdmin.ao.CommentsAdminAO;

import java.util.Date;

@Getter
public class CommentsDto {

    public CommentsDto(CommentsAdminAO commentsAdminAO) {
        this.issueId = commentsAdminAO.getIssueId();
        this.source = commentsAdminAO.getSource();
        this.body = commentsAdminAO.getBody();
        this.author = commentsAdminAO.getAuthor();
        this.created = commentsAdminAO.getCreated();
    }

    private final String issueId;
    private final String source;
    private final String body;
    private final String author;
    private final Date created;

    private String avatarUrl;
    public void setAvatarUrl(String avatarUrls) {
        this.avatarUrl = avatarUrls;
    }
}
