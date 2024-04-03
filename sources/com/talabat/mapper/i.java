package com.talabat.mapper;

import io.reactivex.functions.Function;
import java.lang.reflect.Field;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f61068b;

    public /* synthetic */ i(Object obj) {
        this.f61068b = obj;
    }

    public final Object apply(Object obj) {
        return ModelMappingNameScanner.toFieldData(this.f61068b, (Field) obj);
    }
}
