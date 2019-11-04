package com.wujiabo.fsd.service;

import com.wujiabo.fsd.entity.TTechnology;

import java.util.List;

public interface TechnologyService {
    List<TTechnology> findAllTechnologies();

    TTechnology findBySkillName(String skillName);
}
