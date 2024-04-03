package com.talabat.mapper;

import io.reactivex.functions.Function;

public interface ModelMapper<S, D> extends Function<S, D> {
    D apply(S s11) throws Exception;
}
