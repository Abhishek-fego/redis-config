package com.example.redisconfig.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BaseDto {

    private Long id;

    @JsonIgnore
    private Boolean is_deleted;

    @JsonIgnore
    private LocalDateTime created_at;

    @JsonIgnore
    private LocalDateTime updated_at;

    @JsonIgnore
    private Long created_by;

    @JsonIgnore
    private Long updated_by;
}
