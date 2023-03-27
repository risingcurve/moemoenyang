package com.ssafy.moemoe.db.repository.board;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.moemoe.api.response.board.BoardLoadResp;
import com.ssafy.moemoe.api.response.board.TagResp;
import com.ssafy.moemoe.db.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
public class TagRepositoryImpl implements TagRepositoryCustom {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<TagResp> findByBoardId(Long boardId) {
        return jpaQueryFactory
                .select(new QTagResp(qTag))
                .from(qTag)
                .where(qTag.board.id.eq(boardId))
                .fetch();
    }
}
