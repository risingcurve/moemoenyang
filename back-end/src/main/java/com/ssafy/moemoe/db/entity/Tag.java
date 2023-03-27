package com.ssafy.moemoe.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag_id = null;

    private String name;

    private Float rate;

    // ManyToOne 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    private Tag(String name, float rate, Date download_expiration, Board board) {
        this.name = name;
        this.rate = rate;
        this.board = board;
    }

}
