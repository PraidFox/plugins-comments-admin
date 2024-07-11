import Avatar from "@atlaskit/avatar";
import Comment, {CommentAuthor, CommentTime} from "@atlaskit/comment";
import React from "react";
import {CommentsAdminDto} from "../tools/interfaces/dto/CommentsAdminDto";


export const CommentAtlas = ({avatarUrl, author, source, body, created} : Omit<CommentsAdminDto, 'issueId'>) => {



    return (
        <Comment
            avatar={<Avatar
                appearance="circle"
                src={avatarUrl}
                size="small"
                name={author}
            />}
            author={<CommentAuthor>{author}</CommentAuthor>}
            type="author"
            time={<CommentTime>{created}</CommentTime>}
            content={
                <>
                    <span><b>Скрипт:</b> {source}</span>
                    <p>
                        <b>Причина: </b>
                        {body}
                    </p>
                </>
            }
        />
    )
}

