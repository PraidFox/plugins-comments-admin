package ru.atlassian.commentsAdmin.services;

import ru.atlassian.commentsAdmin.models.CommentsDto;
import ru.atlassian.commentsAdmin.models.CommentsPostDto;

import java.util.List;

public interface ICommentsAdminService {

    List<CommentsDto> getCommentsByIssueId(int issueId);

    void save(CommentsPostDto data, String author);
    void delete(int commentsAdminId);
}
