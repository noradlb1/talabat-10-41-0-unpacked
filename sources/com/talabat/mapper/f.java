package com.talabat.mapper;

import io.reactivex.functions.Predicate;
import java.util.Map;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Mapping f61067b;

    public /* synthetic */ f(Mapping mapping) {
        this.f61067b = mapping;
    }

    public final boolean test(Object obj) {
        return this.f61067b.f61061b.contains(((Map.Entry) obj).getKey());
    }
}
