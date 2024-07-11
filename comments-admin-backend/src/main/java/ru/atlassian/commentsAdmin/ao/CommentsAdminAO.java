package ru.atlassian.commentsAdmin.ao;

import net.java.ao.Entity;
import net.java.ao.schema.Table;

import java.util.Date;

@Table("COMMENTS_ADMIN")
public interface CommentsAdminAO extends Entity {


    String getIssueId();

    void setIssueId(String issueId);
    String getSource();

    void setSource(String body);

    String getBody();

    void setBody(String body);

    String getAuthor();

    void setAuthor(String author);

    Date getCreated();

    void setCreated(Date created);

}
