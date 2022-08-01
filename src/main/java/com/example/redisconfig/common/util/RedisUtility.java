package com.example.redisconfig.common.util;

import com.example.redisconfig.dto.UserDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUtility {

    private final RedisTemplate<String, Object> redisTemplate;


    private static final String KEY = "USER";

    public RedisUtility(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setValue(Long hashKey, UserDto userDto) {
        redisTemplate.opsForHash().put(KEY, hashKey.toString(), userDto);
    }

    public UserDto getValue(Long hashKey) {
        Object object = redisTemplate.opsForHash().get(KEY, hashKey.toString());
        return (UserDto) object;
    }

    public Boolean deleteValue(Long hashKey) {
        try{
            redisTemplate.opsForHash().delete(KEY,hashKey.toString());
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
