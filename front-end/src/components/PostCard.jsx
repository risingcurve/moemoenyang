import React from "react";
import BoardFooter from "./board/BoardFooter";
import BoardHeader from "./board/BoardHeader";

export const PostCard = ({ onBottom = false, postInfo }) => {
  return (
    <div className="FeedItem">
      <BoardHeader onBottom={onBottom} postInfo={postInfo} />
      <div className="flex-shrink-0 h-[30vh]">
        <img
          className="object-cover h-full w-full"
          src={postInfo.image}
          alt="고양이게시물이미지"
        />
      </div>
      <BoardFooter onBottom={onBottom} postInfo={postInfo} />
    </div>
  );
};
