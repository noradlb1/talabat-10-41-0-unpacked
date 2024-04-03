package com.instabug.library.map;

public interface TwoWayMapper<Type1, Type2> {
    Type1 mapBackwards(Type2 type2);

    Type2 mapForwards(Type1 type1);
}
