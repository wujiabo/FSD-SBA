package com.wujiabo.fsd.feign;

import com.wujiabo.fsd.dto.TTechnology;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sba-technology", fallback = TechnologyFeignFallback.class)
public interface TechnologyFeign {

    @RequestMapping(value = "/api/technology/find/{skillName}", method = RequestMethod.GET)
    ResponseEntity<TTechnology> findBySkillName(@PathVariable("skillName") String skillName);
}
