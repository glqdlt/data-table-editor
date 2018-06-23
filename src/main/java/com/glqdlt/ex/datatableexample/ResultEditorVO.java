package com.glqdlt.ex.datatableexample;

import lombok.Data;

import java.util.List;

@Data
public class ResultEditorVO<T> {
//    단일이 아니고 리스트가 타입인 이유는 jquery datatable의 select가 multiple 도 있기 때문에 list 로 올거라고 기대를 한다.
    List<T> data;
}
