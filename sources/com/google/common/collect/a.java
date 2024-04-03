package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f44643b;

    public /* synthetic */ a(Predicate predicate) {
        this.f44643b = predicate;
    }

    public final boolean apply(Object obj) {
        return this.f44643b.apply(Multisets.immutableEntry(((Map.Entry) obj).getKey(), ((Collection) ((Map.Entry) obj).getValue()).size()));
    }
}
