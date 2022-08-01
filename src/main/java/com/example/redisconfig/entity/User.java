package com.example.redisconfig.entity;


import com.example.redisconfig.common.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users")
public class User extends BaseModel  {

    private String username;

    private String password;


}
