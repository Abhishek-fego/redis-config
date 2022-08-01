package com.example.redisconfig.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Boolean is_deleted;

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updated_at;

    @JsonIgnore
    private Long created_by;

    @JsonIgnore
    private Long updated_by;


}
