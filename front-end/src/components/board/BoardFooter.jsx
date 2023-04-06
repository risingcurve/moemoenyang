import React, { useEffect, useState } from "react";
import TimeAgo from "javascript-time-ago";
import ko from "javascript-time-ago/locale/ko.json";
import { putEmoji } from "../../services/main";

import ReactTimeAgo from "react-time-ago";

export default function BoardFooter({
  onBottom = false,
  postInfo,
  emojiChange,
  setEmojiChange,
}) {
  TimeAgo.setDefaultLocale(ko.locale);
  TimeAgo.addLocale(ko);

  function onPutEmoji(boardId, emotionName) {
    console.log("put emoji");
    putEmoji(boardId, emotionName).then(() => setEmojiChange(!emojiChange));
  }

  const postDate = new Date(`
    ${postInfo.created_at[0]}-
    ${postInfo.created_at[1]}-
    ${postInfo.created_at[2]} 
    ${postInfo.created_at[3]}:
    ${postInfo.created_at[4]}:
    ${postInfo.created_at[5]}`);

  if (onBottom) {
    const { angry, good, impressed, recommend, sad } = postInfo;
    const emojiMap = { angry, good, impressed, recommend, sad };
    const [maxEmoji, maxEmojiCount] = Object.entries(emojiMap).sort((a, b) => {
      const res = b[1] - a[1];
      if (res === 0) {
        return b[0] - a[0];
      }
      return res;
    })[0];

    return (
      <div className="card-footer ml-4 mr-4 mt-2 mb-2">
        <div className="top">
          <div className="flex">
            <div className="icons flex flex-row justify-center items-center">
              <div className="MaxImoji mr-4 flex">
                <img
                  src={`/images/emoji/${maxEmoji}.png`}
                  className="_8-yf5"
                  height={30}
                  width={30}
                  alt="감정이모지"
                  onClick={() =>
                    onPutEmoji(postInfo.board_id, postInfo.tags[0]["name"])
                  }
                />
                <div className="text-center p-1">{maxEmojiCount}</div>
              </div>
            </div>
          </div>
          <div className="post-date">
            <span className="text-xs text-gray-900">
              <ReactTimeAgo date={new Date(postDate)} />
            </span>

            <div className="caption text-sm">{postInfo.content}</div>
            {/* <div className="caption text-sm font-bold text-center">더보기</div> */}
          </div>
        </div>
      </div>
    );
  }

  const emojiList = [
    { key: "angry", cnt: postInfo.angry },
    { key: "good", cnt: postInfo.good },
    { key: "impressed", cnt: postInfo.impressed },
    { key: "recommend", cnt: postInfo.recommend },
    { key: "sad", cnt: postInfo.sad },
  ];

  return (
    <div className="card-footer ml-4 mr-4 mt-1 mb-1">
      <div className="top">
        <div className="icons flex justify-center items-center">
          {emojiList.map((data) => {
            return (
              <div
                className="recommend mr-3 flex flex-col justify-center content-center"
                key={data.key}
              >
                <div
                  className={`p-1 ${
                    postInfo.my_emotion === data.key
                      ? "bg-rose-200 rounded-xl"
                      : ""
                  }`}
                >
                  <img
                    src={`/images/emoji/${data.key}.png`}
                    height={30}
                    width={30}
                    alt="감정이모지"
                    onClick={() => onPutEmoji(postInfo.board_id, data.key)}
                  />
                </div>

                <div className="text-center p-1">{data.cnt}</div>
              </div>
            );
          })}
        </div>

        <div className="caption text-sm">{postInfo.content}</div>
        <div className="post-date mt-1">
          <span className="text-xs text-gray-900">
            {" "}
            <ReactTimeAgo date={new Date(postDate)} />
          </span>
        </div>
      </div>
    </div>
  );
}
