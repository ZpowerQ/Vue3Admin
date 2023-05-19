package com.power.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Good_cell_count {
    private Integer id;
    private String name;
    private int count;
    private float money;
    @TableField("`like`")
    private int like;
}
