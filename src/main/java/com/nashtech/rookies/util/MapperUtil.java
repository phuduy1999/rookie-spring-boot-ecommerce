package com.nashtech.rookies.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class MapperUtil {
    private final static ModelMapper modelMapper = new ModelMapper();

//    @Autowired
//    public MapperUtil(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }

//    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
//        return source
//                .stream()
//                .map(element -> modelMapper.map(element, targetClass))
//                .collect(Collectors.toList());
//    }

    public static <S, T> Stream<T> mapListToStream(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass));
    }

    public static <S, T> T mapOne(S element, Class<T> targetClass) {
        return modelMapper.map(element, targetClass);
    }
}
