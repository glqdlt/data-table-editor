package com.glqdlt.ex.datatableexample;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DataTableVo<T> {
    private List<T> data;
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;

}
