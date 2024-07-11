import React from 'react';
import ReactDOM from "react-dom";
import App from './App/App';
import {CommentsAdminDto} from "./tools/interfaces/dto/CommentsAdminDto";
import CommentsAdminApi from "./tools/api/CommentsAdminApi";


export function runReact(comments: string) {


    let commentsAdminDtos:CommentsAdminDto[] = []

    commentsAdminDtos = JSON.parse(comments)

    console.log("Здесь текст", process.env.REACT_APP_LOGIN)


    ReactDOM.render(
        <React.StrictMode>
            <App comments={commentsAdminDtos}/>
        </React.StrictMode>, document.getElementById('commentsAdmin'));

}

if (process.env.NODE_ENV === 'development') {
    console.log("Я здесь!")
    CommentsAdminApi.getCommentsAdminByIssueId(process.env.REACT_APP_ISSUE_ID!).then(r =>
        runReact(JSON.stringify(r.data))
    )
}
