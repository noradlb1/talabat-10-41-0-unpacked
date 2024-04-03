package com.talabat.mapper;

import io.reactivex.functions.Function;
import java.lang.reflect.Field;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Field f61065b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ModelMapping f61066c;

    public /* synthetic */ d(Field field, ModelMapping modelMapping) {
        this.f61065b = field;
        this.f61066c = modelMapping;
    }

    public final Object apply(Object obj) {
        return MappingInitializer.lambda$apply$3(this.f61065b, this.f61066c, (ModelMapper) obj);
    }
}
