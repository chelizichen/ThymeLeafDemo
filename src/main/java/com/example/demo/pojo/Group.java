package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    public String id;
    public String name;
    // 球队图片
    public String avatar;
    public String desc;
    public String createTime;
}
