package com.ssafy.moemoe.api.response.board;

import com.ssafy.moemoe.api.response.cat.CatDetailResp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ApiModel("BoardResp")
public class BoardResp {
    @ApiModelProperty(name = "boardId")
    private Long boardId;

    @ApiModelProperty(name = "catId")
    private Long catId;

    @ApiModelProperty(name = "universityId")
    private Long universityId;

    @ApiModelProperty(name = "memberNickname")
    private String memberNickname;

    @ApiModelProperty(name = "lat")
    private float lat;

    @ApiModelProperty(name = "lng")
    private float lng;

    @ApiModelProperty(name = "content")
    private String content;

    @Builder
    public BoardResp(Long boardId, Long catId, Long universityId, String memberNickname,
                     float lat, float lng, String content){
        this.boardId = boardId;
        this.catId = catId;
        this.universityId = universityId;
        this.memberNickname = memberNickname;
        this.lat = lat;
        this.lng = lng;
        this.content = content;
    }
}
