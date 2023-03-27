package com.ssafy.moemoe.db.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(value = {AuditingEntityListener.class}) // JPA 내부에서 엔티티 객체가 생성/변경되는 것을 감지하는 역할
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long board_id = null;

    Float lat;

    Float lng;

    String content;

    String image;

    @Builder.Default()
    Long recommend = (long)0;

    @Builder.Default()
    Long good = (long)0;

    @Builder.Default()
    Long impressed = (long)0;

    @Builder.Default()
    Long sad = (long)0;

    @Builder.Default()
    Long angry = (long)0;

    @CreatedDate // JPA에서 엔티티의 생성 시간을 처리
    @Column(name = "created_at", updatable = false)
    LocalDateTime created_at;

    // OneToMany 관계 설정
    @OneToMany(mappedBy = "board")
    private List<Tag> tagList = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<Reaction> reactionList = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<ReportBoard> reportBoardList = new ArrayList<>();

    // ManyToOne 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
    private University university;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @Builder
    private Board(float lat, float lng, String content, String image, Member member, University university, Cat cat) {
        this.lat = lat;
        this.lng = lng;
        this.content = content;
        this.image = image;
        this.member = member;
        this.university = university;
        this.cat = cat;
    }

}
