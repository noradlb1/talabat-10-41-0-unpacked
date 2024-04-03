package com.pichillilorenzo.flutter_inappwebview;

import java.util.Map;

public interface Options<T> {
    Map<String, Object> getRealOptions(T t11);

    Options parse(Map<String, Object> map);

    Map<String, Object> toMap();
}
