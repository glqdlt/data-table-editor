package com.glqdlt.ex.datatableexample;

import lombok.Data;

import java.util.List;

@Data
public class ResultEditorVO<T> {
    List<T> data;
}
