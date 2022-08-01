package com.example.redisconfig.service;

import com.example.redisconfig.dto.GenericResponseDto;
import com.example.redisconfig.dto.UserDto;
import com.example.redisconfig.entity.User;
import com.example.redisconfig.exception.ResourceNotFoundException;
import com.example.redisconfig.mapper.UserMapper;
import com.example.redisconfig.repository.UserRepository;
import com.example.redisconfig.common.util.RedisUtility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final RedisUtility redisUtility;

    public UserService(UserRepository userRepository, UserMapper userMapper, RedisUtility redisUtility) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.redisUtility = redisUtility;
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(userMapper::domainToDto).collect(Collectors.toList());
    }


    public GenericResponseDto registerUser(UserDto userDto) {
        return new GenericResponseDto("User registered successfully!!",userRepository.save(userMapper.dtoToDomain(userDto)));
    }


    public UserDto getUserById(Long id) {
        UserDto userDto = redisUtility.getValue(id);
        if(userDto == null){
            User  user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No user with the given id"));
            UserDto userDto1 = userMapper.domainToDto(user);
            redisUtility.setValue(userDto1.getId(),userDto1);
            return userDto1;
        }
        return userDto;
    }

    public String deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            if(redisUtility.deleteValue(id)){
                return "Deletion success!!";
            }
        }
        else {
            throw new ResourceNotFoundException("No user with the given id");
        }
        return "Deletion unsuccessful!!";
    }
}
