package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    public String id;

    public String p_name;
    public String age;
    public String nationality;
    public String team_id;
    public String img_src;
}
