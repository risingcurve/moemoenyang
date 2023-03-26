package com.ssafy.moemoe.db.repository.board;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
//    QBoard qBoard = QBoard.board;

}
