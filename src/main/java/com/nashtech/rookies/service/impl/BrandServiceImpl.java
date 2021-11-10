package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.constant.SuccessCode;
import com.nashtech.rookies.dto.BrandDto;
import com.nashtech.rookies.dto.ResponseDto;
import com.nashtech.rookies.entity.Brand;
import com.nashtech.rookies.repository.BrandRepository;
import com.nashtech.rookies.service.BrandService;
import com.nashtech.rookies.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public ResponseDto findAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandDto> brandDtos = MapperUtil.mapListToStream(brands, BrandDto.class)
                .collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(brandDtos);
        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_ALL_BRAND);
        return responseDto;
    }
}
