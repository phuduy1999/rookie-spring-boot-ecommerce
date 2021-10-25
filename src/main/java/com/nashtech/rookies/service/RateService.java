package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.dto.RateDto;

import java.util.Set;

public interface RateService {
    public Set<RateDto> findAllRate();

    public RateDto findByIdRate(Long id);

    public void createRate(RateDto rateDto);

    public void updateRate(RateDto rateDto, Long id);

    public void deleteRate(Long id);
}
