package com.naver.hackday.trendapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author SaeHan Kim
 * @since 2018-11-14
 */

@Entity
@Table(name = "test")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Test {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
