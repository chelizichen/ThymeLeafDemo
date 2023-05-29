package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

@Data
public class Pagination {
    private String keyword;
    private String page;
    private String offset;
    private String size = "10";
    public Pagination(String page,String keyword){
        this.page = page;
        this.keyword = keyword;
    }

    public String getKeyword() {
        if(keyword == null){
            return "%%";
        }
        return "%"+keyword+"%";
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return Integer.parseInt(page);
    }

    public void setPage(String page) {
        this.page = page;
    }


    public Integer getOffset() {
        int i = 10 * Integer.parseInt(page);
        return i;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return Integer.parseInt(size);
    }

    public void setSize(String size) {
        this.size = size;
    }
}
