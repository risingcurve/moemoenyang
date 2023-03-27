package com.ssafy.moemoe.api.controller.cat;

import com.ssafy.moemoe.api.request.CatInfoReq;
import com.ssafy.moemoe.api.response.board.BoardSpotResp;
import com.ssafy.moemoe.api.response.board.CatDetailBoardResp;
import com.ssafy.moemoe.api.response.cat.CatDetailResp;
import com.ssafy.moemoe.api.response.cat.CatListResp;
import com.ssafy.moemoe.api.response.cat.DiseaseResultResp;
import com.ssafy.moemoe.api.response.cat.DiseaseTimeline;
import com.ssafy.moemoe.api.service.cat.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cats")
public class CatController {

    final String tiredCatImage = "https://i.ibb.co/9q6ZT22/image.jpg"; //피곤한 냥이 이미지
    private final CatService catService;

    @PostMapping("")
    public ResponseEntity<?> insertCat(HttpServletRequest request, CatInfoReq catInfoReq) {
        // request를 이용한 멤버아이디 가져오기 추가 예정

        boolean result = catService.insertCat("멤버 UUID", catInfoReq);
        if(result) {
            return new ResponseEntity<>("고양이가 등록되었습니다.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("고양이가 등록에 실패했습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    //고양이 리스트 조회
    @GetMapping("")
    public ResponseEntity<?> getCats(HttpServletRequest request, @RequestParam Long universityId) {
        // request를 이용한 멤버아이디 가져오기 추가 예정

        List<CatListResp> cats = catService.getCats("member UUID", universityId);
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    //특정 고양이 상세 조회
    @GetMapping("/{catId}")
    public ResponseEntity<?> getCat(HttpServletRequest request, @PathVariable Long catId) {
        // request를 이용한 멤버아이디 가져오기 추가 예정

        CatDetailResp catDetailResp = catService.getCat(catId);
        if(catDetailResp == null) {
            return new ResponseEntity<>("고양이가 조회에 실패했습니다.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(catDetailResp, HttpStatus.OK);
    }

    //고양이 상세페이지에서 게시글 조회
    @GetMapping("/{catId}/boards")
    public ResponseEntity<?> getCatBoards(@PathVariable Long catId) {

        List<CatDetailBoardResp> catBoards = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            catBoards.add(CatDetailBoardResp.builder()
                    .board_id(i)
                    .image(tiredCatImage)
                    .build());
        }

        return ResponseEntity.ok(catBoards);
    }

    //질병 검사 결과 조회
    @GetMapping("/{catId}/disease")
    public ResponseEntity<?> getDiseaseResult(@PathVariable Long catId) {

        DiseaseResultResp result = DiseaseResultResp.builder()
                .disease_id(1)
                .name("엄청 아픈 병")
                .explanation("엄청 아프니까 빨리 병원을 데려가세요. 병원에 데려갈 때는 조심히 들고 가주세요. 아프니까요.")
                .image(tiredCatImage)
                .build();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{catId}/diseases")
    public ResponseEntity<?> getDiseaseTimelines(@PathVariable Long catId) {

        DiseaseResultResp disease = DiseaseResultResp.builder()
                .disease_id(1)
                .name("엄청 아픈 병")
                .explanation("엄청 아프니까 빨리 병원을 데려가세요. 병원에 데려갈 때는 조심히 들고 가주세요. 아프니까요.")
                .image(tiredCatImage)
                .build();

        List<DiseaseTimeline> diseaseTimelines = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            diseaseTimelines.add(DiseaseTimeline.builder()
                            .disease_timeline_id(i)
                            .created_at(LocalDateTime.now())
                            .image(tiredCatImage)
                            .nickname("노찌노찌")
                            .member_id(1)
                            .disease(disease)
                            .build());
        }

        return ResponseEntity.ok(diseaseTimelines);
    }

    @GetMapping("/{catId}/spot")
    public ResponseEntity<?> getCatSpots(@PathVariable Long catId) {

        List<BoardSpotResp> spots = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            spots.add(BoardSpotResp.builder()
                            .board_id(i)
                            .created_at(LocalDateTime.now())
                            .image(tiredCatImage)
                            .lat(37.501258)
                            .lng(127.039516)
                            .build());
        }

        return ResponseEntity.ok(spots);
    }
}
