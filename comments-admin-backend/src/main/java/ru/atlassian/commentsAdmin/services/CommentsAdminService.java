package ru.atlassian.commentsAdmin.services;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.jira.avatar.Avatar;
import com.atlassian.jira.avatar.AvatarService;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import ru.atlassian.commentsAdmin.ao.CommentsAdminAO;
import ru.atlassian.commentsAdmin.models.CommentsDto;
import ru.atlassian.commentsAdmin.models.CommentsPostDto;
import com.atlassian.jira.user.util.UserManager;

import javax.inject.Named;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ExportAsService
@Named
public class CommentsAdminService implements ICommentsAdminService {
    @ComponentImport
    private final ActiveObjects activeObjects;
    @ComponentImport
    private final AvatarService avatarService;
    @ComponentImport
    private final UserManager userManager;

    //@Autowired
    public CommentsAdminService(ActiveObjects activeObjects, AvatarService avatarService, UserManager userManager) {
        this.activeObjects = activeObjects;
        this.avatarService = avatarService;
        this.userManager = userManager;
    }

    public List<CommentsDto> getCommentsByIssueId(int issueId) {
        List<CommentsDto> commentsDto = Arrays.stream(activeObjects.find(CommentsAdminAO.class, "issue_id = ?", issueId)).map(CommentsDto::new).collect(Collectors.toList());

        commentsDto.forEach(comment -> {
                    ApplicationUser user = userManager.getUserByName(comment.getAuthor());
                    comment.setAvatarUrl(avatarService.getAvatarAbsoluteURL(user, user, Avatar.Size.biggerThan(32)).toString());
                }
        );

        return commentsDto;
    }

    public void save(CommentsPostDto data, String author) {
        CommentsAdminAO commentsAdminAO = activeObjects.create(CommentsAdminAO.class);
        commentsAdminAO.setIssueId(data.getIssueId());
        commentsAdminAO.setSource(data.getSource());
        commentsAdminAO.setBody(data.getBody());
        commentsAdminAO.setAuthor(author);
        commentsAdminAO.setCreated(new Date());
        commentsAdminAO.save();
    }

    @Override
    public void delete(int commentsAdminId) {
        CommentsAdminAO commentsAdminAO = activeObjects.get(CommentsAdminAO.class, commentsAdminId);
        activeObjects.delete(commentsAdminAO);
    }
}
