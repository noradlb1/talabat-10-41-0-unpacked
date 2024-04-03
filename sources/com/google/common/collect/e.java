package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Multimaps.AsMap.EntrySet f44645b;

    public /* synthetic */ e(Multimaps.AsMap.EntrySet entrySet) {
        this.f44645b = entrySet;
    }

    public final Object apply(Object obj) {
        return this.f44645b.lambda$iterator$0(obj);
    }
}
