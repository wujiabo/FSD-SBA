package com.wujiabo.fsd.feign;

import com.wujiabo.fsd.dto.TTechnology;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TechnologyFeignFallback implements TechnologyFeign {
    @Override
    public ResponseEntity<TTechnology> findBySkillId(String skillId) {
        return null;
    }
}
