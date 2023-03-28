import React from "react";

export default function CatCard({ catInfo }) {
  return (
    <div className="flex flex-col rounded-xl shadow-lg m-4">
      <div className="relative">
        <img
          className="rounded-t-xl w-full h-32"
          src={catInfo.image}
          alt="고양이프로필사진"
        />
        {catInfo.isFollowing === null ? (
          <img
            className="absolute bottom-1 w-5 h-5 right-2"
            src="/images/button/Star.png"
            alt="즐겨찾기"
          />
        ) : (
          <img
            className="absolute bottom-1 w-5 h-5 right-2"
            src="/images/button/FillStar.png"
            alt="즐겨찾기"
          />
        )}
      </div>
      <div>
        <div className="font-bold text-lg m-1 ml-4">이름 : {catInfo.name}</div>
        <div className="font-bold text-lg m-1 ml-4">
          성별 : {catInfo.gender}
        </div>
        <div className="font-bold text-lg m-1 ml-4">나이 : {catInfo.age}</div>
      </div>
    </div>
  );
}
