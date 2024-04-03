package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.util.Collection;

public final /* synthetic */ class f implements Maps.EntryTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Multimaps.TransformedEntriesMultimap f44646a;

    public /* synthetic */ f(Multimaps.TransformedEntriesMultimap transformedEntriesMultimap) {
        this.f44646a = transformedEntriesMultimap;
    }

    public final Object transformEntry(Object obj, Object obj2) {
        return this.f44646a.lambda$createAsMap$0(obj, (Collection) obj2);
    }
}
