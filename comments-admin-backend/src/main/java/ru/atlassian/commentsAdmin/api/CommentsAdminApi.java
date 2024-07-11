package ru.atlassian.commentsAdmin.api;

import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.google.gson.Gson;
import ru.atlassian.commentsAdmin.ao.CommentsAdminAO;
import ru.atlassian.commentsAdmin.models.CommentsDto;
import ru.atlassian.commentsAdmin.models.CommentsPostDto;
import ru.atlassian.commentsAdmin.services.CommentsAdminService;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;



@Path("/comments")
public class CommentsAdminApi {    public final CommentsAdminService commentsAdminService;
    @ComponentImport
    private final JiraAuthenticationContext jiraAuthenticationContext;

    private final Gson gson = new Gson();

    public CommentsAdminApi(CommentsAdminService commentsAdminService, JiraAuthenticationContext jiraAuthenticationContext) {
        this.commentsAdminService = commentsAdminService;
        this.jiraAuthenticationContext = jiraAuthenticationContext;
    }

    @GET
    @Path("/{issueId}")
    public Response getCommentsId(@PathParam("issueId") int issueId) {
        List<CommentsDto> commentsAdmin = commentsAdminService.getCommentsByIssueId(issueId);
        return Response.ok().entity(gson.toJson(commentsAdmin)).build();
    }

    @POST
    public Response save(CommentsPostDto data, String author) {
        String currentUser = jiraAuthenticationContext.getLoggedInUser().getName();
        commentsAdminService.save(data, currentUser);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(@QueryParam("commentsAdminId") int commentsAdminId) {
        commentsAdminService.delete(commentsAdminId);
        return Response.ok().build();
    }
}
