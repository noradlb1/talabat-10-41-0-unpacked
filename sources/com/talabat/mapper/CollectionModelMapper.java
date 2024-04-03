package com.talabat.mapper;

import java.util.Collection;

public interface CollectionModelMapper<S, D> extends ModelMapper<S, D> {
    Collection<D> map(Collection<S> collection);
}
