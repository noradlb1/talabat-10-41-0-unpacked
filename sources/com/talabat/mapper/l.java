package com.talabat.mapper;

import io.reactivex.functions.Predicate;
import java.lang.reflect.Field;

public final /* synthetic */ class l implements Predicate {
    public final boolean test(Object obj) {
        return ((Field) obj).isAnnotationPresent(ModelMapping.class);
    }
}
