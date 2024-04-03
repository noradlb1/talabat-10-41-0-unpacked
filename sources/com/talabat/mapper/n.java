package com.talabat.mapper;

import io.reactivex.functions.Function;
import java.util.Map;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ModelMappingScanner f61069b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f61070c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Map f61071d;

    public /* synthetic */ n(ModelMappingScanner modelMappingScanner, Object obj, Map map) {
        this.f61069b = modelMappingScanner;
        this.f61070c = obj;
        this.f61071d = map;
    }

    public final Object apply(Object obj) {
        return this.f61069b.lambda$accept$2(this.f61070c, this.f61071d, (Mapping) obj);
    }
}
