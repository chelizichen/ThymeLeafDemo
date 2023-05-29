package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    public String id;

    public String name;

    public String sex;

    public String age;

    public String groupId;

    public String avatar;

    public String createTime;
}
