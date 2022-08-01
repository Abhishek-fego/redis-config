package com.example.redisconfig.dto;

import com.example.redisconfig.common.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDto extends BaseDto implements Serializable {

    private String username;

    private String password;
}
