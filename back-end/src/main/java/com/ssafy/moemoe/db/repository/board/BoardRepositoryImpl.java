package com.ssafy.moemoe.db.repository.board;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.moemoe.api.response.board.BoardLoadResp;
import com.ssafy.moemoe.api.response.board.BoardResp;
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
    public List<BoardLoadResp> findBoardByIdAndTag(Long universityId, String tagName) {

        return jpaQueryFactory
                .select(new QBoardLoadResp(qBoard, qCat, q))
                .from(qInterview)
                .leftJoin(qInterview.user, qUser)
                .leftJoin(qInterview.interviewTimeList, qInterviewTime)
                .leftJoin(qInterviewTime.applicantList, qApplicant)
                .where(tagNameEq(word), qApplicant.applicantState.eq(applicantState), qApplicant.user.id.eq(user_id))
                .orderBy(ORDERS.stream().toArray(OrderSpecifier[]::new))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();;
    }


    private BooleanExpression tagNameEq(String tagName) {
        return tagName.isEmpty() ? null : qTag.name.contains(tagName);
    }

}
