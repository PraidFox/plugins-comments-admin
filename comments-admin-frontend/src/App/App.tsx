import React, {useEffect, useState} from 'react';
import {CommentsAdminDto} from "../tools/interfaces/dto/CommentsAdminDto";
import {CommentAtlas} from "./CommentAtlas";


function App({comments}: { comments: CommentsAdminDto[] }) {
    const [content, setContent] = useState<React.JSX.Element[]>([])

    useEffect(() => {
        let reactContent: React.JSX.Element[] = comments.map(comment =>
            <CommentAtlas
                avatarUrl={comment.avatarUrl}
                author={comment.author}
                source={comment.source}
                body={comment.body}
                created={comment.created}
            />
        )


        if (comments.length === 0) {
            reactContent = [<CommentAtlas
                avatarUrl={"http://localhost:8080/secure/useravatar?avatarId=10350&s=48"}
                author={"Текст!!!!!!!!!!"}
                source={"lheujq ntrcn"}
                body={"Много текста"}
                created={"21.05"}
            />]
        }

        setContent(reactContent)
    }, [comments]);


    return (
        <>
            {content.map(item => <div key={item.key}>{item}
                <hr/>
            </div>)}
        </>
    )
}

export default App;
