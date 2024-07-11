package ru.atlassian.commentsAdmin.container;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.tabpanels.GenericMessageAction;
import com.atlassian.jira.plugin.issuetabpanel.*;
import com.atlassian.jira.user.ApplicationUser;
import com.google.gson.Gson;
import ru.atlassian.commentsAdmin.models.CommentsDto;
import ru.atlassian.commentsAdmin.services.CommentsAdminService;


import java.util.ArrayList;
import java.util.List;


public class IssueTabCustomCommentsAdmin extends AbstractIssueTabPanel {
    public final CommentsAdminService commentsAdminService;

    private final Gson gson = new Gson();

    public IssueTabCustomCommentsAdmin(CommentsAdminService commentsAdminService) {
        this.commentsAdminService = commentsAdminService;

    }

    @Override
    public List<IssueAction> getActions(Issue issue, ApplicationUser applicationUser) {


        List<IssueAction> issueActions = new ArrayList<>();
        List<CommentsDto> comments = commentsAdminService.getCommentsByIssueId(Math.toIntExact(issue.getId()));

       String htmlContent = "<div id='commentsAdmin'></div><div> Тут я был</div><script>window.CommentsAdmin.runReact('" + gson.toJson(comments) + "')</script>";


        IssueAction htmlAction = new GenericMessageAction(htmlContent);
        issueActions.add(htmlAction);

        return issueActions;

    }

    @Override
    public boolean showPanel(Issue issue, ApplicationUser applicationUser) {
        return true;
    }
}
