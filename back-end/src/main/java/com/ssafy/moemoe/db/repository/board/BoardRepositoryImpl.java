package com.ssafy.moemoe.db.repository.board;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.moemoe.api.response.board.BoardLoadResp;
import com.ssafy.moemoe.db.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
public class BoardRepositoryImpl implements BoardRepositoryCustom {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<BoardLoadResp> findBoardByIdAndTag(Long universityId, String tagName, Pageable pageable) {

        List<InterviewLoadRes> content = jpaQueryFactory
                .select(new QInterviewLoadRes(qInterview))
                .from(qInterview)
//                .where(wordEq(word), categoryEq(categoryName), qInterview.interviewState.eq(4), qApplicant.user.id.isNull().or(qApplicant.user.id.ne(user_id)))
                .where(wordEq(word), categoryEq(categoryName), interviewStateEq(4), qInterview.user.id.ne(user_id))
                .orderBy()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Board> countQuery = jpaQueryFactory
                .select(qBoard)
                .from(qBoard)
                .where(wordEq(word), categoryEq(categoryName), interviewStateEq(4), qInterview.user.id.ne(user_id));

        return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetchCount());
    }

    private BooleanExpression tagNameEq(String tagName) {
        return tagName.isEmpty() ? null : qTag.name.contains(tagName);
    }
}
