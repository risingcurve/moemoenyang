package com.ssafy.moemoe.api.response.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import com.ssafy.moemoe.db.entity.Board;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Board 전체 정보 조회 API ([GET] /) 요청에 대한 응답값 정의.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ApiModel("BoardLoadRes")
public class BoardLoadRes {
    @ApiModelProperty(name = "Board ID")
    Long boardId;

    @ApiModelProperty(name = "Cat ID")
    Long catId;

    @ApiModelProperty(name = "Cat image")
    String catImage;

    @ApiModelProperty(name = "Cat Name")
    String catName;

    @ApiModelProperty(name = "Member image")
    String memberImage;

    @ApiModelProperty(name = "Member Nickname")
    String memberNickname;

    @ApiModelProperty(name = "Board Image")
    String boardImage;

    @ApiModelProperty(name = "Tags")
    List<TagResp> tags;

    @ApiModelProperty(name = "recommend")
    Long recommend;

    @ApiModelProperty(name = "good")
    Long good;

    @ApiModelProperty(name = "impressed")
    Long impressed;

    @ApiModelProperty(name = "sad")
    Long sad;

    @ApiModelProperty(name = "angry")
    Long angry;

    @ApiModelProperty(name = "createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    LocalDateTime createdAt;

    @QueryProjection
    public BoardLoadRes(Board board, Cat cat, University university) {
        this.boardId = board.getBoard_id();
    }
}
