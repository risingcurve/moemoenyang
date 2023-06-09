package com.ssafy.moemoe.api.request.disease;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseTimelineRegistReq {

    private Long diseaseId;
    private MultipartFile image;
}
