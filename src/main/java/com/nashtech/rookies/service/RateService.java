package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.RateDto;

import java.util.Set;

public interface RateService {
    Set<RateDto> findAllRate();

    RateDto findByIdRate(Long id);

    void createRate(RateDto rateDto);

    void updateRate(RateDto rateDto, Long id);

    void deleteRate(Long id);
}
