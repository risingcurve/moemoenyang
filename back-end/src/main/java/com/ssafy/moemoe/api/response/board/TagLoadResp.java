package com.ssafy.moemoe.api.response.board;

import com.querydsl.core.annotations.QueryProjection;
import com.ssafy.moemoe.db.entity.board.Board;
import com.ssafy.moemoe.db.entity.board.Tag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Board 전체 정보 조회 API ([GET] /) 요청에 대한 응답값 정의.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ApiModel("BoardLoadRes")
public class TagLoadResp {

    @ApiModelProperty(name = "tag_id")
    private Long tagId;
    @ApiModelProperty(name = "name")
    private String name;
    @ApiModelProperty(name = "rate")
    private Float rate;
    @ApiModelProperty(name = "board")
    private Board board;

    @QueryProjection
    public TagLoadResp(Tag tag) {
        this.tagId = tag.getTagId();
        this.name = tag.getName();
        this.rate = tag.getRate();
        this.board = tag.getBoard();
    }
}