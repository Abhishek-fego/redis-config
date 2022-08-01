package com.example.redisconfig.common;

import org.springframework.stereotype.Component;

@Component
public interface BaseMapper <M extends BaseModel,D extends BaseDto>{

    M dtoToDomain(D baseDto);

    D domainToDto(M baseModel);
}
