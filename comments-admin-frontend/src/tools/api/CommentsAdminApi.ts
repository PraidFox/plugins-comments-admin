import axios from "axios";
import Api from "./api";


export default class CommentsAdminApi {

    static getCommentsAdminByIssueId(issueId:string) {



        return axios.get(Api.baseUrl() + `rest/commentsAdmin/1/comments/${issueId}`, Api.customConfig)
    }
}