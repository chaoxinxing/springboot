package com.ceb.ymz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author fseve
 * @Date 2020/11/2 22:41
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String phone;
    private String name;
    private String password;
//    kjjhkjkhjkjh
}
