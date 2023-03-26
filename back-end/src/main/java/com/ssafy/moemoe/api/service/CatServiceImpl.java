package com.ssafy.moemoe.api.service;

import com.ssafy.moemoe.api.request.CatInfoReq;
import com.ssafy.moemoe.api.response.cat.CatListResp;
import com.ssafy.moemoe.db.entity.Cat;
import com.ssafy.moemoe.db.repository.CatCustomRepository;
import com.ssafy.moemoe.db.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CatServiceImpl implements CatService{

    private final CatRepository catRepository;
    private final CatCustomRepository catCustomRepository;

    @Override
    public boolean insertCat(String memberId, CatInfoReq catInfoReq) {
        // 멤버 유효성 검사 추가 예정

        Cat cat = toEntity(catInfoReq);

        catRepository.save(cat);

        return true;
    }

    @Override
    public List<CatListResp> getCats(String memberId, Long universityId) {
        return catCustomRepository.getCats(UUID.fromString(memberId), universityId);
    }


}