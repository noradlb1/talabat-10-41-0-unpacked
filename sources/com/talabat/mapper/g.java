package com.talabat.mapper;

import com.google.gson.annotations.SerializedName;
import io.reactivex.functions.Predicate;
import java.lang.reflect.Field;

public final /* synthetic */ class g implements Predicate {
    public final boolean test(Object obj) {
        return ((Field) obj).isAnnotationPresent(SerializedName.class);
    }
}
