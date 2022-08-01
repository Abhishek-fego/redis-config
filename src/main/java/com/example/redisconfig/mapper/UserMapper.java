package com.example.redisconfig.mapper;

import com.example.redisconfig.common.BaseMapper;
import com.example.redisconfig.dto.UserDto;
import com.example.redisconfig.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<User, UserDto> {
    @Override
    public User dtoToDomain(UserDto baseDto) {
        return User.builder()
                .username(baseDto.getUsername())
                .password(baseDto.getPassword())
                .is_deleted(baseDto.getIs_deleted())
                .created_by(baseDto.getCreated_by())
                .updated_by(baseDto.getUpdated_by())
                .build();
    }

    @Override
    public UserDto domainToDto(User baseModel) {
        return UserDto.builder()
                .id(baseModel.getId())
                .username(baseModel.getUsername())
                .password(baseModel.getPassword())
                .is_deleted(baseModel.getIs_deleted())
                .created_at(baseModel.getCreated_at())
                .updated_at(baseModel.getUpdated_at())
                .created_by(baseModel.getCreated_by())
                .updated_by(baseModel.getUpdated_by())
                .build();
    }
}
